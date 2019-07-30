package com.ng.musicplayer;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private RecyclerView mRecyclerView;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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

    private void setupAdapter() {
         List<Album> listAlbums = getAlbums();
         List<ListOfListAlbums> listOfListAlbums = new ArrayList<>();
         listOfListAlbums.add(new ListOfListAlbums("trend vietnam", listAlbums));
         listOfListAlbums.add(new ListOfListAlbums("Ha noi xua", listAlbums));


         AdapterListOfAlbums adapterListOfAlbums = new AdapterListOfAlbums();

         adapterListOfAlbums.addListofListAlbums(new ListOfListAlbums("Mới phát gần đây", listAlbums));
         adapterListOfAlbums.addListofListAlbums(new ListOfListAlbums("Nghe đi nghe lại", listAlbums));
         adapterListOfAlbums.addListofListAlbums(new ListOfListAlbums("Dành cho bạn", listAlbums));
         adapterListOfAlbums.addListofListAlbums(new ListOfListAlbums("Album và bài hát ưa thích của bạn", listAlbums));
         adapterListOfAlbums.addListofListAlbums(new ListOfListAlbums("Thư giãn", listAlbums));
         adapterListOfAlbums.addListofListAlbums(new ListOfListAlbums("Được đề xuất cho hôm nay", listAlbums));
         adapterListOfAlbums.addListofListAlbums(new ListOfListAlbums("Vui vẻ", listAlbums));
        mRecyclerView.setAdapter(adapterListOfAlbums);
    }

    private List<Album> getAlbums(){
        List<Album> list = new ArrayList<>();
        list.add(new Album("V-pop không thể thiếu", "Mỹ Tâm, Đen..", R.drawable.mytam));
        list.add(new Album("Mãi Yêu Mỹ Tâm", "Mỹ Tâm", R.drawable.mytam));
        list.add(new Album("Cà Phê Quán Quen", "Mỹ Tâm, Tiên Tiên,...", R.drawable.mytam));
        list.add(new Album("Indie Việt", "Tiên Tiên, Đen,...", R.drawable.mytam));
        list.add(new Album("Top Hits Vietnam", "Ha noi, Viet n", R.drawable.mytam));
        list.add(new Album("Thiên Hạ Nghe G", "Acivii, Ed Sheeran,..", R.drawable.mytam));

        return list;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_home, container, false);
        mRecyclerView = rootView.findViewById(R.id.recycler_list_albums);
        AdapterAlbums adapterAlbums = new AdapterAlbums(false, getAlbums());
//        mRecyclerView.setAdapter(adapterAlbums);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setHasFixedSize(true);
        setupAdapter();
        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }
//
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

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
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
