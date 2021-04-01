package com.example.maintest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class NoticeBoardActivity extends AppCompatActivity {
    NoticeAdapter adapter;
    ArrayList<NoticeItem> nil;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_board);

        nil = (ArrayList<NoticeItem>)getIntent().getSerializableExtra("noticeInfo");

        ImageButton imageButton_write = (ImageButton)findViewById(R.id.imageButton_write);
        imageButton_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), WriteNoticeActivity.class);
                startActivityForResult(intent, 21);
                finish();
            }
        });

        ImageButton imageButton_back = (ImageButton)findViewById(R.id.imageButton_back);
        imageButton_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(101);
                finish();
            }
        });

        ListView listView = (ListView)findViewById(R.id.listView);

        adapter = new NoticeAdapter();

        for(int i = 0; i < nil.size(); i++){
            adapter.addItem(new NoticeItem(nil.get(i).getTitle(), nil.get(i).getContents(),  nil.get(i).getTime(), nil.get(i).getLike(), nil.get(i).getComment()));
        }

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                intent = new Intent(getApplicationContext(), NoticeCommentActivity.class);
                intent.putExtra("notice_comment", nil.get(i));
                startActivityForResult(intent, 201);
                finish();
            }
        });
    }
    class NoticeAdapter extends BaseAdapter{
        ArrayList<NoticeItem> items = new ArrayList<NoticeItem>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(NoticeItem item){
            items.add(item);
        }

        @Override
        public Object getItem(int i) {
            return items.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            NoticeItemView nview = new NoticeItemView(getApplicationContext());

            NoticeItem item = items.get(i);

            nview.setTitle(item.getTitle());
            nview.setSummary(item.getSummary());
            nview.setTime(item.getTime());
//            nview.setLike(""+item.getLike());
            nview.setComment(""+item.getComment());

            return nview;
        }
    }

}
