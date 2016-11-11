package com.sid.recyclerbutton;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Jethva Sagar (Piml Sid) on 11/8/16.
 * Email : Jethvasagar2@gmail.com
 */

public class RecyclerEventAdapter extends RecyclerView.Adapter<RecyclerEventAdapter.MyViewHolder>{

    private List<EventModel> arrayList;
    private UpdateInterface updateInterface;


    public RecyclerEventAdapter(List<EventModel> arrayList, UpdateInterface updateInterface){
        this.arrayList = arrayList;
        this.updateInterface = updateInterface;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recylcer_list_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        final EventModel eventModel = arrayList.get(position);
                    holder.textView.setText(eventModel.getName());
        holder.button.setText(eventModel.isActiove().toString());
                    if(eventModel.getStatus() == 1){
                        holder.button.setEnabled(false);
                    }
                    if(eventModel.getStatus() ==0){
                        holder.button.setText("START");
                        holder.button.setEnabled(true);
                    }

                    holder.button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                    if(holder.button.getText().equals("START")){
                        holder.button.setText("STOP");
                        for(int i=0;i<arrayList.size();i++){
                            if(i!=position){
                                arrayList.set(i,new EventModel(arrayList.get(i).getName(),"START",1));
                            }else{
                                arrayList.set(i,new EventModel(arrayList.get(i).getName(),"STOP",2));
                            }
                        }
                        notifyDataSetChanged();
                    }else if(holder.button.getText().toString().equals("STOP")){
                        holder.button.setText("START");
                        for(int i=0;i<arrayList.size();i++){
                            arrayList.set(i,new EventModel(arrayList.get(i).getName(),"START",0));
                        }
                        notifyDataSetChanged();
                    }
                }
            });




    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView textView;
        private Button button;

        public MyViewHolder(View itemView) {
            super(itemView);

            textView = (TextView)itemView.findViewById(R.id.txt1);
            button = (Button)itemView.findViewById(R.id.btnClick);
        }
    }
}
