package com.sid.recyclerbutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements UpdateInterface{

    private RecyclerView recyclerView;
    private RecyclerEventAdapter recyclerEventAdapter;
    private List<EventModel> eventModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        eventModelArrayList = new ArrayList<>();
        //init();
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,1);
        recyclerEventAdapter = new RecyclerEventAdapter(eventModelArrayList,this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerEventAdapter);
    }
//    void  init(){
//        eventModelArrayList.add(new EventModel("One","START",0));
//        eventModelArrayList.add(new EventModel("Two","START",0));
//        eventModelArrayList.add(new EventModel("Three","START",0));
//        eventModelArrayList.add(new EventModel("Four","START",0));
//        eventModelArrayList.add(new EventModel("Five","START",0));
//        eventModelArrayList.add(new EventModel("Six","START",0));
//        eventModelArrayList.add(new EventModel("Seven","START",0));
//        eventModelArrayList.add(new EventModel("Eight","START",0));
//        eventModelArrayList.add(new EventModel("Nine","START",0));
//        eventModelArrayList.add(new EventModel("Ten","START",0));
//
//
//    }

    @Override
    public void getPosition(int position, int t) {
        Log.v("Sid","Position :: " + position + "  Active :: " + t);
       /* eventModelArrayList.set(position,new EventModel(
                eventModelArrayList.get(position).getName(),t));*/
        //recyclerEventAdapter.notifyDataSetChanged();

    }
}
