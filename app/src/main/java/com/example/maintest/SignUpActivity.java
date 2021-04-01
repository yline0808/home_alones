package com.example.maintest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class SignUpActivity extends AppCompatActivity {
    EditText editText1;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    EditText editText5;
    EditText editText6;
    EditText editText7;
    EditText editText8;
    RadioButton radioButton1;
    RadioButton radioButton2;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("android");
    ArrayList<UserItem> ui = new ArrayList<UserItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Button sign = (Button)findViewById(R.id.sign);
        Button back = (Button)findViewById(R.id.back);

        editText1 = (EditText)findViewById(R.id.editText1);
        editText2 = (EditText)findViewById(R.id.editText2);
        editText3 = (EditText)findViewById(R.id.editText3);
        editText4 = (EditText)findViewById(R.id.editText4);
        editText5 = (EditText)findViewById(R.id.editText5);
        editText6 = (EditText)findViewById(R.id.editText6);
        editText7 = (EditText)findViewById(R.id.editText7);
        editText8 = (EditText)findViewById(R.id.editText8);
        radioButton1 = (RadioButton)findViewById(R.id.radioButton1);
        radioButton2 = (RadioButton)findViewById(R.id.radioButton2);

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(editText1.getText()) || TextUtils.isEmpty(editText2.getText()) || TextUtils.isEmpty(editText3.getText()) ||
                        TextUtils.isEmpty(editText4.getText()) || TextUtils.isEmpty(editText5.getText()) || TextUtils.isEmpty(editText6.getText()) ||
                        TextUtils.isEmpty(editText7.getText()) || TextUtils.isEmpty(editText8.getText()) || (radioButton1.isChecked() == radioButton2.isChecked()) ){
                    Toast.makeText(getApplicationContext(), "항목을 모두 입력해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                String sex = null;
                if(radioButton1.isChecked()){
                    sex = "남";
                }else if(radioButton2.isChecked()){
                    sex = "여";
                }
                UserItem userItem = new UserItem(editText1.getText().toString(), editText2.getText().toString(),
                        sex, Integer.parseInt(editText3.getText().toString()), editText4.getText().toString(), editText5.getText().toString(),
                        editText6.getText().toString(), Integer.parseInt(editText7.getText().toString()), editText8.getText().toString());
                myRef.child("user").push().setValue(userItem);

                finish();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
