package com.example.maintest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class LoginXActivity extends AppCompatActivity {
    ArrayList<UserItem> uil = new ArrayList<UserItem>();
    ArrayList<InfomationItem> iil = new ArrayList<InfomationItem>();
    ArrayList<InfomationItem> ail = new ArrayList<InfomationItem>();
    String id;
    String pw;
    Intent intent;
    UserItem ui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_x);

        uil = (ArrayList<UserItem>)getIntent().getSerializableExtra("uil");
        iil = (ArrayList<InfomationItem>)getIntent().getSerializableExtra("iil");
        ail = (ArrayList<InfomationItem>)getIntent().getSerializableExtra("ail");
        id = (String)getIntent().getSerializableExtra("id");
        pw = (String)getIntent().getSerializableExtra("pw");

        if(login()){
            intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.putExtra("iil", iil);
            intent.putExtra("ail", ail);
            intent.putExtra("ui", ui);
            startActivityForResult(intent, 1000);
        }
        else{
            Toast.makeText(getApplicationContext(), "아이디, 비밀번호가 틀렸습니다.", Toast.LENGTH_SHORT).show();
            finish();
        }
        finish();
    }
    private boolean login(){
        for(int i = 0; i < uil.size(); i++){
            if(id.equals(uil.get(i).getId()) && pw.equals(uil.get(i).getPassword())){
                ui = uil.get(i);
                return true;
            }
        }
        return false;
    }
}
