package com.athrved.masterclass;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.athrved.masterclass.ai.AiImagesActivity;
import com.athrved.masterclass.ai.AiMainActivity;
import com.athrved.masterclass.appdev.AMainActivity;
import com.athrved.masterclass.iot.IotMainActivity;
import com.athrved.masterclass.machdesign.MMainActivity;
import com.athrved.masterclass.uiux.UiuxMainActivity;
import com.athrved.masterclass.webdevelopment.WMainActivity;

public class AddMentors extends AppCompatActivity {
    int CourseId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_mentors);

        Spinner spinner1 = (Spinner) findViewById(R.id.TopicSpinnerForAddMentor);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.add_mentors_array, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                Object item = parent.getItemAtPosition(pos);
                CourseId = parent.getSelectedItemPosition();
                String Course = parent.getItemAtPosition(pos).toString();
                Log.d(TAG, "Course222: " + CourseId);

                if(CourseId==1)
                {
                    Intent intent1 = new Intent(AddMentors.this, AiMainActivity.class);
                    startActivity(intent1);
                }
                else if(CourseId==2)
                {
                    Intent intent2 = new Intent(AddMentors.this, WMainActivity.class);
                    startActivity(intent2);
                }
                else if(CourseId==3)
                {
                    Intent intent2 = new Intent(AddMentors.this, AMainActivity.class);
                    startActivity(intent2);
                }
                else if(CourseId==4)
                {
                    Intent intent2 = new Intent(AddMentors.this, MMainActivity.class);
                    startActivity(intent2);
                }
                else if(CourseId==5)
                {
                    Intent intent2 = new Intent(AddMentors.this, UiuxMainActivity.class);
                    startActivity(intent2);
                }
                else if(CourseId==6)
                {
                    Intent intent2 = new Intent(AddMentors.this, IotMainActivity.class);
                    startActivity(intent2);
                }
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}