package com.ng.musicplayer;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PlaylistDetailsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PlaylistDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PlaylistDetailsFragment extends Fragment implements SongAdapter.OnSongListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private RecyclerView mRecyclerView;
    private ImageButton btnBack;
    private Button btnPlayPlaylist;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public PlaylistDetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PlaylistDetailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PlaylistDetailsFragment newInstance(String param1, String param2) {
        PlaylistDetailsFragment fragment = new PlaylistDetailsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_playlist_details, container, false);
        mRecyclerView = rootView.findViewById(R.id.songs);
        SongAdapter songAdapter = new SongAdapter(getSongs(), this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setHasFixedSize(true);
        btnBack = rootView.findViewById(R.id.btn_back);
        btnPlayPlaylist = rootView.findViewById(R.id.btn_play_playlist);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });

        btnPlayPlaylist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NowPlayingFragment nowPlayingFragment = new NowPlayingFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_frag_layout, nowPlayingFragment, "nowPlayingFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });

        setupAdapter();
        displayBottomNav();
        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }

    void displayBottomNav() {
        //hide bottomnavigationview
        BottomNavigationView bottomNavigationView = getActivity().findViewById(R.id.main_nav);
        bottomNavigationView.animate().translationY(0);
        View fragView = getActivity().findViewById(R.id.main_frag_layout);

        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) fragView.getLayoutParams();
        params.addRule(RelativeLayout.ABOVE, bottomNavigationView.getId());
        fragView.setLayoutParams(params);
    }
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }



    private void setupAdapter(){
        List<Song> songs = getSongs();
        SongAdapter songAdapter = new SongAdapter(songs, this);
        mRecyclerView.setAdapter(songAdapter);

    }
    private List<Song> getSongs(){
        List<Song> list = new ArrayList<>();
        list.add(new Song("Xin người", "Duy Mạnh", false, R.drawable.mytam));
        list.add(new Song("Xin người", "Duy Mạnh", false, R.drawable.mytam));
        list.add(new Song("Xin người", "Duy Mạnh", false, R.drawable.mytam));
        list.add(new Song("Xin người", "Duy Mạnh", false, R.drawable.mytam));
        list.add(new Song("Xin người", "Duy Mạnh", false, R.drawable.mytam));
        list.add(new Song("Xin người", "Duy Mạnh", false, R.drawable.mytam));
        list.add(new Song("Xin người", "Duy Mạnh", false, R.drawable.mytam));
        list.add(new Song("Xin người", "Duy Mạnh", false, R.drawable.mytam));
        list.add(new Song("Xin người", "Duy Mạnh", false, R.drawable.mytam));
        list.add(new Song("Xin người", "Duy Mạnh", false, R.drawable.mytam));
        list.add(new Song("Xin người 2", "Duy Mạnh", false, R.drawable.mytam));
        list.add(new Song("Hay trao cho ", "Duy Mạnh", false, R.drawable.mytam));
        list.add(new Song("Một con vịt ", "Duy Mạnh", false, R.drawable.mytam));
        list.add(new Song("Xin người", "Duy Mạnh", false, R.drawable.mytam));
        list.add(new Song("Xin người", "Duy Mạnh", false, R.drawable.mytam));
        list.add(new Song("Xin người", "Duy Mạnh", false, R.drawable.mytam));
        list.add(new Song("Xin người", "Duy Mạnh", false, R.drawable.mytam));
        list.add(new Song("Xin người", "Duy Mạnh", false, R.drawable.mytam));
        return list;
    }

    @Override
    public void OnSongClick(int pos) {
        NowPlayingFragment nowPlayingFragment = new NowPlayingFragment();
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_frag_layout, nowPlayingFragment, "nowPlayingFragment")
                .addToBackStack(null)
                .commit();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
