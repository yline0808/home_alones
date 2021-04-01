package com.example.maintest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NoticeCommentActivity extends AppCompatActivity {
    NoticeItem ni;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("android").child("notice");
    EditText editText;
    ListView commentList;
    TextView textView_comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_comment);

        ni = (NoticeItem) getIntent().getSerializableExtra("notice_comment");

        TextView textView_title = (TextView)findViewById(R.id.textView_title);
        textView_title.setText(ni.getTitle());
        TextView textView_contents = (TextView)findViewById(R.id.textView_contents);
        textView_contents.setText(ni.getContents());
        TextView textView_time = (TextView)findViewById(R.id.textView_time);
        textView_time.setText(ni.getTime());
        textView_comment = (TextView)findViewById(R.id.textView_comment);
        textView_comment.setText("" + ni.getComment());

        commentList = (ListView)findViewById(R.id.listView_comment);

        editText = (EditText)findViewById(R.id.editText_comment);
        ImageButton send = (ImageButton)findViewById(R.id.send);

        openChat(ni.getTime());

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(editText.getText())){
                    Toast.makeText(getApplicationContext(), "댓글을 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    long now = System.currentTimeMillis();
                    Date date = new Date(now);
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String getTime = sdf.format(date);

                    CommentItem comment = new CommentItem(editText.getText().toString(), getTime);
                    myRef.child(ni.getTime()).child("comment_all").push().setValue(comment);
                    editText.setText(null);

                    textView_comment.setText("" + (commentList.getCount() + 1));
                    myRef.child(ni.getTime()).child("comment").setValue(textView_comment.getText());
                }
            }
        });
        ImageButton imageButton = (ImageButton)findViewById(R.id.imageButton_back);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void addMessage(DataSnapshot dataSnapshot, ArrayAdapter<String> adapter){
        CommentItem commentItem = dataSnapshot.getValue(CommentItem.class);
        adapter.add("⤷ "+commentItem.getText());
    }

    private void removeMessage(DataSnapshot dataSnapshot, ArrayAdapter<String> adapter){
        CommentItem commentItem = dataSnapshot.getValue(CommentItem.class);
        adapter.remove(commentItem.getText());
    }

    private void openChat(final String chatRoom){
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1);
        commentList.setAdapter(adapter);

        myRef.child(chatRoom).child("comment_all").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                addMessage(dataSnapshot, adapter);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                removeMessage(dataSnapshot, adapter);
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
