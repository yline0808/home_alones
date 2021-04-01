package com.example.maintest;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NoticeItemView extends LinearLayout {
    TextView textView_title;
    TextView textView_summary;
    TextView textView_time;

//    TextView textView_like;
    TextView textView_comment;

    public NoticeItemView(Context context) {
        super(context);

        init(context);
    }

    public NoticeItemView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private void init(Context context){
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.notice_item, this, true);

        textView_title = (TextView)findViewById(R.id.textView_title);
        textView_summary = (TextView)findViewById(R.id.textView_summary);
        textView_time = (TextView)findViewById(R.id.textView_time);

//        textView_like = (TextView)findViewById(R.id.textView_like);
        textView_comment = (TextView)findViewById(R.id.textView_comment);
    }
    public void setTitle(String title){
        textView_title.setText(title);
    }
    public void setSummary(String summary){
        textView_summary.setText(summary);
    }
    public void setTime(String time){
        textView_time.setText(time);
    }
//    public void setLike(String like){
//        textView_like.setText(like);
//    }
    public void setComment(String comment){
        textView_comment.setText(comment);
    }
}
