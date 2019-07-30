package com.ng.musicplayer;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper;

import java.util.ArrayList;
import java.util.List;

public class AdapterListOfAlbums extends RecyclerView.Adapter<AdapterListOfAlbums.ViewHolder> implements GravitySnapHelper.SnapListener{

    private List<ListOfListAlbums> listOfListAlbums;


    public AdapterListOfAlbums() {
        this.listOfListAlbums = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_albums_adapter, parent, false);

        return new ViewHolder(view);
    }

    public void addListofListAlbums(ListOfListAlbums s){
        listOfListAlbums.add(s);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListOfListAlbums snap =  listOfListAlbums.get(position);
        holder.listAlbumsTv.setText(snap.getListName());
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(holder.recyclerView.getContext(), LinearLayoutManager.HORIZONTAL,false));
//
//        ListOfListAlbums snap = listOfListAlbums.get(position);
//        holder.listAlbumsTv.setText(snap.getListName());
//
//        if (snap.getGravity() == Gravity.START || snap.getGravity() == Gravity.END) {
//            holder.recyclerView.setLayoutManager(new LinearLayoutManager(holder
//                    .recyclerView.getContext(), LinearLayoutManager.HORIZONTAL, false));
//            holder.recyclerView.setOnFlingListener(null);
//            new GravitySnapHelper(snap.getGravity(), false, this).attachToRecyclerView(holder.recyclerView);
//        } else if (snap.getGravity() == Gravity.CENTER_HORIZONTAL) {
//            holder.recyclerView.setLayoutManager(new LinearLayoutManager(holder
//                    .recyclerView.getContext(), snap.getGravity() == Gravity.CENTER_HORIZONTAL ?
//                    LinearLayoutManager.HORIZONTAL : LinearLayoutManager.VERTICAL, false));
//            holder.recyclerView.setOnFlingListener(null);
//            new LinearSnapHelper().attachToRecyclerView(holder.recyclerView);
//        } else if (snap.getGravity() == Gravity.CENTER) { // Pager snap
//            holder.recyclerView.setLayoutManager(new LinearLayoutManager(holder
//                    .recyclerView.getContext(), LinearLayoutManager.HORIZONTAL, false));
//            holder.recyclerView.setOnFlingListener(null);
//            new PagerSnapHelper().attachToRecyclerView(holder.recyclerView);
//        } else { // Top / Bottom
//            holder.recyclerView.setLayoutManager(new LinearLayoutManager(holder
//                    .recyclerView.getContext()));
//            holder.recyclerView.setOnFlingListener(null);
//            new GravitySnapHelper(snap.getGravity()).attachToRecyclerView(holder.recyclerView);
//////        }
//////
//////
//////        holder.recyclerView.setAdapter(new Adapter(snap.getGravity() == Gravity.START
//////                || snap.getGravity() == Gravity.END
//////                || snap.getGravity() == Gravity.CENTER_HORIZONTAL,
//////                snap.getGravity() == Gravity.CENTER, snap.getApps()));

        holder.recyclerView.setAdapter(new AdapterAlbums(true, snap.getmAlbums()));
    }

    @Override
    public int getItemCount() {
        return listOfListAlbums.size();
    }


    @Override
    public void onSnap(int position) {
        Log.d("Snapped: ", position + "");
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView listAlbumsTv;
        public RecyclerView recyclerView;

        public ViewHolder(View itemView) {
            super(itemView);
            listAlbumsTv = (TextView) itemView.findViewById(R.id.text_name_list_albums);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.recycler_list_albums);
        }
    }
}
