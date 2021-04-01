package com.example.maintest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyPageActivity extends AppCompatActivity {
    ImageButton imageButton_back;
    ArrayList<LndicesItem> lnil = new ArrayList<LndicesItem>();
    UserItem ui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page);

        lnil = (ArrayList<LndicesItem>)getIntent().getSerializableExtra("lndices");
        ui = (UserItem)getIntent().getSerializableExtra("ui");

        TextView top1 = (TextView)findViewById(R.id.top1);
        TextView top2 = (TextView)findViewById(R.id.top2);

        TextView text1 = (TextView)findViewById(R.id.editText1);
        TextView text2 = (TextView)findViewById(R.id.editText2);
        TextView text3 = (TextView)findViewById(R.id.editText3);
        TextView text4 = (TextView)findViewById(R.id.editText4);
        TextView text5 = (TextView)findViewById(R.id.editText5);
        TextView text6 = (TextView)findViewById(R.id.editText6);
        TextView text7 = (TextView)findViewById(R.id.editText7);
        TextView text8 = (TextView)findViewById(R.id.editText8);
        TextView text9 = (TextView)findViewById(R.id.editText9);

        text1.setText(ui.getId());
        text3.setText(ui.getSex());
        text4.setText(""+ui.getAge());
        text5.setText(ui.getLive());
        text6.setText(ui.getCommut());
        text7.setText(ui.getHlive());
        text8.setText(""+ui.getPlace());
        text9.setText(ui.getHfacilities());

        imageButton_back = (ImageButton)findViewById(R.id.imageButton_back);
        imageButton_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
//    private void topSet(String live){
//        switch (live){
//            case "강남구":
//
//                break;
//            case "강동구":
//
//                break;
//            case "강북구":
//
//                break;
//            case "강서구":
//
//                break;
//            case "관악구":
//
//                break;
//            case "광진구":
//
//                break;
//            case "구로구":
//
//                break;
//            case "금천구":
//
//                break;
//            case "노원구":
//
//                break;
//            case "도봉구":
//
//                break;
//            case "동대문구":
//
//                break;
//            case "동작구":
//
//                break;
//            case "마포구":
//
//                break;
//            case "서대문구":
//
//                break;
//            case "서초구":
//
//                break;
//            case "성동구":
//
//                break;
//            case "성북구":
//
//                break;
//            case "송파구":
//
//                break;
//            case "양천구":
//
//                break;
//            case "영등포구":
//
//                break;
//            case "용산구":
//
//                break;
//            case "은평구":
//
//                break;
//            case "종로구":
//
//                break;
//            case "중구":
//
//                break;
//            case "중랑구":
//
//                break;
//        }
//    }
}
