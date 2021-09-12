package com.athrved.masterclass;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.hbb20.CountryCodePicker;

public class PhoneNoLogIn extends AppCompatActivity {

    EditText phoneNoEditText;
    CountryCodePicker countryCodePicker;
    ImageButton backBtnInPhoneNoLogIn;
    TextView continueWithSocialTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_no_log_in);

        countryCodePicker = findViewById(R.id.countryCodePicker);
        phoneNoEditText = findViewById(R.id.phoneNoEditText);
        backBtnInPhoneNoLogIn = findViewById(R.id.backBtnInPhoneNoLogIn);
        continueWithSocialTextView = findViewById(R.id.continueWithSocialTextView);

        backBtnInPhoneNoLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PhoneNoLogIn.this, SignUp.class);
                startActivity(intent);
                finish();
            }
        });

        continueWithSocialTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PhoneNoLogIn.this, SignUp.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void callVerifyOtpScreen(View view) {
        if (!validatePhoneNumber()) {
            return;
        }

        String _getUserEnteredNumber = phoneNoEditText.getText().toString().trim();
        String _phoneNo = "+" + countryCodePicker.getFullNumber() + _getUserEnteredNumber;

        Intent intent = new Intent(getApplicationContext(), VerifyOtp.class);

        intent.putExtra("phoneNo", _phoneNo);
        intent.putExtra("phNo", _getUserEnteredNumber);

        startActivity(intent);
        finish();
    }

    private boolean validatePhoneNumber() {

        String val = phoneNoEditText.getText().toString().trim();

        if (val.isEmpty()) {
            phoneNoEditText.setError("Field cannot be empty");
            return false;
        } else {
            phoneNoEditText.setError(null);
            return true;
        }
    }


}