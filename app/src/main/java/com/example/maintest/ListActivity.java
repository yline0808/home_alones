package com.example.maintest;

import androidx.appcompat.app.AppCompatActivity;

import android.location.Location;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    ArrayList<HappyHomeMap> hhl;
    ArrayList<String> ll = new ArrayList<String>();
    Spinner spinner;
    ListView listView;
    ArrayList<HappyHomeMap> findItems;
    HomeInfoAdapter hAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView = (ListView)findViewById(R.id.listView_allhome);
        spinner = (Spinner)findViewById(R.id.spinner);

        ll.add("강동구");ll.add("강서구");ll.add("구로구");ll.add("노원구");ll.add("동대문구");
        ll.add("동작구");ll.add("마포구");ll.add("서대문구");ll.add("서초구");ll.add("성북구");
        ll.add("송파구");ll.add("양천구");ll.add("영등포구");ll.add("은평구");ll.add("중랑구");

        hhl = (ArrayList<HappyHomeMap>)getIntent().getSerializableExtra("total_home");

        ArrayAdapter<String> spadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ll);
        spadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(spadapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                hAdapter = new HomeInfoAdapter();
                findItems = new ArrayList<HappyHomeMap>();
                for(int j = 0; j < hhl.size(); j++){
                    if(hhl.get(j).getGu().equals(ll.get(i))){
                        findItems.add(hhl.get(j));
                    }
                }
                for(int j = 0; j < findItems.size(); j++){
                    hAdapter.addItem(new HappyHomeMap(
                            findItems.get(j).getCount(),
                            findItems.get(j).getWd(),
                            findItems.get(j).getGd(),
                            findItems.get(j).getPlace(),
                            findItems.get(j).getSupply(),
                            findItems.get(j).getSupplyInfo(),
                            findItems.get(j).getGu(),
                            findItems.get(j).getDangi(),
                            findItems.get(j).getAddress(),
                            findItems.get(j).getMoney_mon(),
                            findItems.get(j).getMoney_contract(),
                            findItems.get(j).getMoney_changes(),
                            findItems.get(j).getMoney_bo()
                    ));
                }
                listView.setAdapter(hAdapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Toast.makeText(getApplicationContext(), "임대보즌금(계약금) : " + findItems.get(i).getMoney_contract() + "\n잔금 : " + findItems.get(i).getMoney_changes(), Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        ImageButton btn_back = (ImageButton)findViewById(R.id.imageButton_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    class HomeInfoAdapter extends BaseAdapter {
        ArrayList<HappyHomeMap> items = new ArrayList<HappyHomeMap>();

        public void addItem(HappyHomeMap item){
            items.add(item);
        }

        @Override
        public int getCount() {
            return items.size();
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
            HomeItemView hview = new HomeItemView(getApplicationContext());

            HappyHomeMap item = items.get(i);

            hview.setTextView_address(item.getAddress());
            hview.setTextView_dangi(item.getDangi());
            hview.setTextView_place(""+item.getPlace());
            hview.setTextView_money_mon(""+item.getMoney_mon());
            hview.setTextView_money_bo(""+item.getMoney_bo());
            hview.setTextView_count(""+item.getCount());

            return hview;
        }
    }
}