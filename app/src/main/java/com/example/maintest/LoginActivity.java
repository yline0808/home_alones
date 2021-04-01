package com.example.maintest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class LoginActivity extends AppCompatActivity {
    Intent intent;
    ArrayList<InfomationItem> iil = new ArrayList<InfomationItem>();
    ArrayList<InfomationItem> ail = new ArrayList<InfomationItem>();
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef;
    ArrayList<UserItem> uil = new ArrayList<UserItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        readUserDB();
        readInformationDB();
        readAdvertiseDB();

        final EditText editText_id = (EditText)findViewById(R.id.editText1);
        final EditText editText_pw = (EditText)findViewById(R.id.editText2);

        TextView textView_join = (TextView)findViewById(R.id.textView_join);
        textView_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivityForResult(intent, 1001);
//                Toast.makeText(getApplicationContext(), "권한이 없습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        Button btn_l = (Button)findViewById(R.id.btn_l);

        btn_l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(editText_id.getText()) || TextUtils.isEmpty(editText_pw.getText())){
                    Toast.makeText(getApplicationContext(), "항목을 모두 입력해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }

                intent = new Intent(getApplicationContext(), LoginXActivity.class);

                Collections.reverse(iil);
                Collections.reverse(ail);

                intent.putExtra("iil", iil);
                intent.putExtra("ail", ail);
                intent.putExtra("uil", uil);
                intent.putExtra("id", editText_id.getText().toString());
                intent.putExtra("pw", editText_pw.getText().toString());
                startActivityForResult(intent, 1000);
            }
        });
    }

//    private void addUser(DataSnapshot dataSnapshot){
//        UserItem userItem = dataSnapshot.getValue(UserItem.class);
//        uil.add(userItem);
//    }

    public void readUserDB(){
        myRef = database.getReference("android").child("user");
        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                UserItem ui = new UserItem();

                ui.setAge(Integer.parseInt(dataSnapshot.child("age").getValue().toString()));
                ui.setCommut(dataSnapshot.child("commut").getValue().toString());
                ui.setHfacilities(dataSnapshot.child("hfacilities").getValue().toString());
                ui.setHlive(dataSnapshot.child("hlive").getValue().toString());
                ui.setId(dataSnapshot.child("id").getValue().toString());
                ui.setLive(dataSnapshot.child("live").getValue().toString());
                ui.setPassword(dataSnapshot.child("password").getValue().toString());
                ui.setPlace(Integer.parseInt(dataSnapshot.child("place").getValue().toString()));
                ui.setSex(dataSnapshot.child("sex").getValue().toString());

                uil.add(ui);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void readAdvertiseDB(){
        myRef = database.getReference("android").child("advertise");
        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                InfomationItem ii = new InfomationItem();

                ii.setHost(dataSnapshot.child("host").getValue().toString());
                ii.setTitle(dataSnapshot.child("title").getValue().toString());
                ii.setUrl(dataSnapshot.child("url").getValue().toString());

                ail.add(ii);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    public void readInformationDB(){
        myRef = database.getReference("android").child("information");
        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                InfomationItem ii = new InfomationItem();

                ii.setHost(dataSnapshot.child("host").getValue().toString());
                ii.setTitle(dataSnapshot.child("title").getValue().toString());
                ii.setUrl(dataSnapshot.child("url").getValue().toString());

                iil.add(ii);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        iil.clear();
        readInformationDB();
        ail.clear();
        readAdvertiseDB();
        uil.clear();
        readUserDB();
    }
}
