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
//            case "?????????":
//
//                break;
//            case "?????????":
//
//                break;
//            case "?????????":
//
//                break;
//            case "?????????":
//
//                break;
//            case "?????????":
//
//                break;
//            case "?????????":
//
//                break;
//            case "?????????":
//
//                break;
//            case "?????????":
//
//                break;
//            case "?????????":
//
//                break;
//            case "?????????":
//
//                break;
//            case "????????????":
//
//                break;
//            case "?????????":
//
//                break;
//            case "?????????":
//
//                break;
//            case "????????????":
//
//                break;
//            case "?????????":
//
//                break;
//            case "?????????":
//
//                break;
//            case "?????????":
//
//                break;
//            case "?????????":
//
//                break;
//            case "?????????":
//
//                break;
//            case "????????????":
//
//                break;
//            case "?????????":
//
//                break;
//            case "?????????":
//
//                break;
//            case "?????????":
//
//                break;
//            case "??????":
//
//                break;
//            case "?????????":
//
//                break;
//        }
//    }
}
