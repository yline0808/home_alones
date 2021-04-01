package com.example.maintest;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import com.google.android.gms.maps.model.MarkerOptions;

public class HomeItemView extends LinearLayout {
    TextView textView_address;
    TextView textView_dangi;
    TextView textView_place;
    TextView textView_money_mon;
    TextView textView_money_bo;
    TextView textView_count;
    MarkerOptions mo = new MarkerOptions();

    public HomeItemView(Context context) {
        super(context);

        init(context);
    }

    public HomeItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private void init(Context context){
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.all_home_info, this, true);

        textView_address = (TextView)findViewById(R.id.textView_address_info);
        textView_dangi = (TextView)findViewById(R.id.textView_dangi_info);
        textView_place = (TextView)findViewById(R.id.textView_place_info);
        textView_money_mon = (TextView)findViewById(R.id.textView_money_mon_info);
        textView_money_bo = (TextView)findViewById(R.id.textView_money_bo_info);
        textView_count = (TextView)findViewById(R.id.textView_count_info);
    }

    public void setTextView_address(String address) {
        textView_address.setText(address);
    }
    public void setTextView_dangi(String dangi) {
        textView_dangi.setText(dangi);
    }
    public void setTextView_place(String place) {
        textView_place.setText(place);
    }
    public void setTextView_money_mon(String money) {
        textView_money_mon.setText(money);
    }
    public void setTextView_money_bo(String money) {
        textView_money_bo.setText(money);
    }
    public void setTextView_count(String count){
        textView_count.setText(count);
    }
}
