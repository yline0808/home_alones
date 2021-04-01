package com.example.maintest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    Intent intent;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef;
    ArrayList<HappyHomeMap> hhl = new ArrayList<HappyHomeMap>();
    ArrayList<NoticeItem> nil = new ArrayList<NoticeItem>();
    ArrayList<InfomationItem> iil = new ArrayList<InfomationItem>();
    ArrayList<InfomationItem> ail = new ArrayList<InfomationItem>();
    ArrayList<LndicesItem> lnil = new ArrayList<LndicesItem>();
    ListView infoList;
    ViewPager vp;
    ScrollView scrollView_main;
    UserItem ui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iil = (ArrayList<InfomationItem>)getIntent().getSerializableExtra("iil");
        ail = (ArrayList<InfomationItem>)getIntent().getSerializableExtra("ail");
        ui = (UserItem)getIntent().getSerializableExtra("ui");

        scrollView_main = (ScrollView)findViewById(R.id.scrollView_main);
        scrollView_main.smoothScrollTo(0,0);
        infoList = (ListView)findViewById(R.id.listView_info);
        InfoAdAdapter infoAdAdapter = new InfoAdAdapter();

        for(int i = 0; i < iil.size(); i++){
            infoAdAdapter.addItem(new InfomationItem(iil.get(i).getHost(), iil.get(i).getTitle()));
        }

        infoList.setAdapter(infoAdAdapter);

        infoList.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                scrollView_main.requestDisallowInterceptTouchEvent(true);

                return false;
            }
        });

        infoList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse(iil.get(i).getUrl()));
                startActivity(intent);
            }
        });

        vp = (ViewPager)findViewById(R.id.viewPager);
        vp.setAdapter(new PagerAdapter(getSupportFragmentManager()));
        vp.setCurrentItem(0);


        LinearLayout btn_n = (LinearLayout)findViewById(R.id.btn_n);
        btn_n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), NoticeBoardActivity.class);
                Collections.reverse(nil);
                intent.putExtra("noticeInfo",nil);
                startActivityForResult(intent, 102);
            }
        });

        LinearLayout btn_m = (LinearLayout)findViewById(R.id.btn_m);
        btn_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), MapActivity.class);
                intent.putExtra("mapLocation", hhl);
                startActivityForResult(intent, 101);
            }
        });

        LinearLayout btn_t = (LinearLayout)findViewById(R.id.btn_t);
        btn_t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), ListActivity.class);
                intent.putExtra("total_home", hhl);
                startActivityForResult(intent, 100);
            }
        });
        LinearLayout mypage = (LinearLayout)findViewById(R.id.mypage);
        mypage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), MyPageActivity.class);
                intent.putExtra("lndices", lnil);
                intent.putExtra("ui", ui);
                startActivityForResult(intent, 105);
            }
        });
    }

    View.OnClickListener movePageListener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            int tag = (int)view.getTag();
            vp.setCurrentItem(tag, true);
        }
    };

    class PagerAdapter extends FragmentStatePagerAdapter{
        public PagerAdapter(FragmentManager fm){
            super(fm);
        }
        public Fragment getItem(int position){
            switch (position){
                case 0:
                    return new AdFirstFragement();
                case 1:
                    return new AdSecondFragement();
                case 2:
                    return new AdThirdFragement();
                case 3:
                    return new AdFourFragement();
                default:
                    return null;
            }
        }
        public int getCount(){
            return 4;
        }
    }

    class InfoAdAdapter extends BaseAdapter{
        ArrayList<InfomationItem> items = new ArrayList<InfomationItem>();
        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(InfomationItem item){
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
            InfoAdItemView v = new InfoAdItemView(getApplicationContext());

            InfomationItem item = items.get(i);
            v.setTitle(item.getTitle());
            v.setHost(item.getHost());

            return v;
        }
    }

    public void readLndicesData(){
        myRef = database.getReference("android").child("lndices");
        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                LndicesItem lndicesItem = new LndicesItem();

                lndicesItem.setGu(dataSnapshot.child("구").getValue().toString());
                lndicesItem.setGi(Float.parseFloat(dataSnapshot.child("지수").getValue().toString()));

                lnil.add(lndicesItem);
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

    public void readNoticeData(){
        myRef = database.getReference("android").child("notice");
        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                NoticeItem ni = new NoticeItem();
                try {
                    ni.setTitle(dataSnapshot.child("title").getValue().toString());
                    ni.setContents(dataSnapshot.child("contents").getValue().toString());
                    ni.setTime(dataSnapshot.child("time").getValue().toString());
                    ni.setLike(Integer.parseInt(dataSnapshot.child("like").getValue().toString()));
                    ni.setComment(Integer.parseInt(dataSnapshot.child("comment").getValue().toString()));
                    ni.setSummary(ni.getContents());
                }
                catch (Exception e){}

                if(dataSnapshot.child("comment_all").exists()){
                    ArrayList<CommentItem> cil = new ArrayList<CommentItem>();
                    for(DataSnapshot snapshot : dataSnapshot.child("comment_all").getChildren()){
                        cil.add(new CommentItem(snapshot.getValue().toString(), snapshot.getKey().toString()));
                    }
                    ni.setComment_all(cil);
                }
                nil.add(ni);
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

    public void readData() {
        myRef = database.getReference("android").child("home");

        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                HappyHomeMap hh = new HappyHomeMap();

                hh.setCount(Integer.parseInt(dataSnapshot.child("모집호수_계").getValue().toString()));
                hh.setWd(Float.parseFloat(dataSnapshot.child("위도").getValue().toString()));
                hh.setGd(Float.parseFloat(dataSnapshot.child("경도").getValue().toString()));
                hh.setPlace(Float.parseFloat(dataSnapshot.child("전용면적_제곱미터").getValue().toString()));
                hh.setSupply(dataSnapshot.child("공급기관").getValue().toString());
                hh.setSupplyInfo(dataSnapshot.child("공급정보").getValue().toString());
                hh.setGu(dataSnapshot.child("구").getValue().toString());
                hh.setDangi(dataSnapshot.child("단지명").getValue().toString());
                hh.setAddress(dataSnapshot.child("주소").getValue().toString());
                hh.setMoney_mon(Long.parseLong(dataSnapshot.child("월임대료").getValue().toString()));
                hh.setMoney_contract(Long.parseLong(dataSnapshot.child("임대보증금_계약금").getValue().toString()));
                hh.setMoney_changes(Long.parseLong(dataSnapshot.child("잔금").getValue().toString()));
                hh.setMoney_bo(Long.parseLong(dataSnapshot.child("임대보증금_계").getValue().toString()));

                hhl.add(hh);
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
        hhl.clear();
        readData();
        nil.clear();
        readNoticeData();
        lnil.clear();
        readLndicesData();
    }
}
