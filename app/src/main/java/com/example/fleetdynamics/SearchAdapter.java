package com.example.fleetdynamics;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;



public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder>
{

    Context context;
    ArrayList<String> regList;
    ArrayList<String> makeModelList;

    class SearchViewHolder extends RecyclerView.ViewHolder
    {
        TextView reg;
        TextView makeModel;
        public SearchViewHolder(@NonNull View itemView) {
            super(itemView);
            reg = (TextView) itemView.findViewById(R.id.auto);
            makeModel = (TextView) itemView.findViewById(R.id.auto);
        }
    }

    public SearchAdapter(Context context, ArrayList<String> regList, ArrayList<String> makeModelList) {
        this.context = context;
        this.regList = regList;
        this.makeModelList = makeModelList;
    }


    @Override
    public SearchAdapter.SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {

    }


    @Override
    public int getItemCount()
    {
        return regList.size();
    }
}
