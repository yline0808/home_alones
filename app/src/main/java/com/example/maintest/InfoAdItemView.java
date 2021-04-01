package com.example.maintest;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class InfoAdItemView extends LinearLayout {
    TextView textTitle;
    TextView textHost;

    public InfoAdItemView(Context context) {
        super(context);

        init(context);
    }

    public InfoAdItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }
    private void init(Context context){
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.info_ad_item, this, true);

        textTitle = (TextView)findViewById(R.id.text_title);
        textHost = (TextView)findViewById(R.id.text_host);
    }

    public void setTitle(String title){
        textTitle.setText(title);
    }
    public void setHost(String host){
        textHost.setText("["+host+"]");
    }

}
