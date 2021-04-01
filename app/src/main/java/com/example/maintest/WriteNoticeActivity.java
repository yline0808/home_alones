package com.example.maintest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WriteNoticeActivity extends AppCompatActivity {
    EditText editText_title;
    EditText editText_contents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_notice);

        editText_contents = (EditText)findViewById(R.id.editText_contents);
        editText_title = (EditText)findViewById(R.id.editText_title);

        Button button_bone = (Button)findViewById(R.id.button_done);
        button_bone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(editText_contents.getText()) || TextUtils.isEmpty(editText_title.getText())){
                    Toast.makeText(getApplicationContext(), "제목과 내용을 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                dbWrite();
                finish();
            }
        });
        ImageButton button_clear = (ImageButton) findViewById(R.id.button_clear);
        button_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    public void dbWrite() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef;

        myRef = database.getReference("android").child("notice");

        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String getTime = sdf.format(date);

        myRef.child(getTime).child("title").setValue(editText_title.getText().toString());
        myRef.child(getTime).child("contents").setValue(editText_contents.getText().toString());
        myRef.child(getTime).child("time").setValue(getTime);
        myRef.child(getTime).child("like").setValue(0);
        myRef.child(getTime).child("comment").setValue(0);
    }
}
