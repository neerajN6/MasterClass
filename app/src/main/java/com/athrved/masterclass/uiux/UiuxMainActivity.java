package com.athrved.masterclass.uiux;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.athrved.masterclass.R;
import com.athrved.masterclass.Upload;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

public class UiuxMainActivity extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;
    private Button mButtonUpload;
    private EditText mEditTextFileName, mEditTextEmail, mEditTextDesignation, mEditTextDesc, mEditTextPhNo;
    private ImageView mImageViewIn;
    private Uri mImageUri;
    private StorageReference mStorageRef;
    private DatabaseReference mDatabaseRef;
    private StorageReference totalStorageRef;
    private DatabaseReference totalDatabaseRef;
    private ProgressBar mProgressBar;
    private StorageTask mUploadTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uiux_main);

        mImageViewIn = findViewById(R.id.imageViewInMentorProfile);
        mButtonUpload = findViewById(R.id.button);
        mEditTextFileName = findViewById(R.id.editTextName);
        mEditTextEmail = findViewById(R.id.editTextEmail);
        mEditTextDesignation = findViewById(R.id.editTextDesignation);
        mEditTextDesc = findViewById(R.id.editTextDesc);
        mEditTextPhNo = findViewById(R.id.editTextPhNo);
        mProgressBar = findViewById(R.id.progress_bar);
        mStorageRef = FirebaseStorage.getInstance().getReference("Mentor Profile").child("Uiux");
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Mentor Profile").child("Uiux");
        totalStorageRef = FirebaseStorage.getInstance().getReference("All Mentor Profile");
        totalDatabaseRef = FirebaseDatabase.getInstance().getReference("All Mentor Profile");

        mImageViewIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser();
            }
        });

        mButtonUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mUploadTask!=null && mUploadTask.isInProgress()){
                    Toast.makeText(UiuxMainActivity.this, "Upload in progress.", Toast.LENGTH_SHORT).show();
                }else {

                    uploadFile(mImageUri);
                }

            }
        });
    }

    private void openFileChooser(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null &&data.getData() != null)
        {
            mImageUri = data.getData();

            mImageViewIn.setImageURI(mImageUri);
        }
    }

    private String getFileExtension(Uri mUri){
        ContentResolver cr = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cr.getType(mUri));
    }

    private void uploadFile(Uri uri){
        if (mImageUri != null) {

            final StorageReference fileRef = mStorageRef.child(System.currentTimeMillis() + "." + getFileExtension(uri));
            fileRef.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                    fileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {

                            Upload upload = new Upload(mEditTextFileName.getText().toString().trim(),
                                    uri.toString(),mEditTextEmail.getText().toString().trim(),
                                    mEditTextPhNo.getText().toString().trim(),
                                    mEditTextDesignation.getText().toString(),
                                    mEditTextDesc.getText().toString());
                            String uploadId = mDatabaseRef.push().getKey();
                            mDatabaseRef.child(uploadId).setValue(upload);
                            Toast.makeText(UiuxMainActivity.this, "Mentor Added Successfully", Toast.LENGTH_LONG).show();
                            mProgressBar.setVisibility(View.INVISIBLE);
                        }
                    });
                }
            })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(UiuxMainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(@NonNull UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0 * taskSnapshot.getBytesTransferred() /
                                    taskSnapshot.getTotalByteCount());
                            mProgressBar.setVisibility(View.VISIBLE);
                            mProgressBar.setProgress((int) progress);
                        }
                    });
        }else{
            Toast.makeText(this, "No photo selected", Toast.LENGTH_SHORT).show();
        }

        if (mImageUri != null) {

            final StorageReference fileRef = mStorageRef.child(System.currentTimeMillis() + "." + getFileExtension(uri));
            fileRef.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                    fileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {

                            Upload upload = new Upload(mEditTextFileName.getText().toString().trim(),
                                    uri.toString(),mEditTextEmail.getText().toString().trim(),
                                    mEditTextPhNo.getText().toString().trim(),
                                    mEditTextDesignation.getText().toString(),
                                    mEditTextDesc.getText().toString());
                            String uploadId = totalDatabaseRef.push().getKey();
                            totalDatabaseRef.child(uploadId).setValue(upload);
                            Toast.makeText(UiuxMainActivity.this, "Mentor Added Successfully", Toast.LENGTH_LONG).show();
                            mProgressBar.setVisibility(View.INVISIBLE);
                        }
                    });
                }
            })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(UiuxMainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(@NonNull UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0 * taskSnapshot.getBytesTransferred() /
                                    taskSnapshot.getTotalByteCount());
                            mProgressBar.setVisibility(View.VISIBLE);
                            mProgressBar.setProgress((int) progress);
                        }
                    });
        }else{
            Toast.makeText(this, "No photo selected", Toast.LENGTH_SHORT).show();
        }

    }
}