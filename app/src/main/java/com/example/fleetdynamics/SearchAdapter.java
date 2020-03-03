package com.example.fleetdynamics;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
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
            reg = itemView.findViewById(R.id.reg);
            makeModel = itemView.findViewById(R.id.makeModel);
        }
    }

    public SearchAdapter(Context context, ArrayList<String> regList, ArrayList<String> makeModelList) {
        this.context = context;
        this.regList = regList;
        this.makeModelList = makeModelList;
    }


    @Override
    public SearchAdapter.SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.search_result_damage, parent, false);
        return new SearchAdapter.SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        holder.reg.setText(regList.get(position));
        holder.makeModel.setText(makeModelList.get(position));


    }


    @Override
    public int getItemCount()
    {
        return regList.size();
    }
}
