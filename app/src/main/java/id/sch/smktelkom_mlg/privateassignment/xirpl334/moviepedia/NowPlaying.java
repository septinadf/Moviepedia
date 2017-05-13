package id.sch.smktelkom_mlg.privateassignment.xirpl334.moviepedia;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.privateassignment.xirpl334.moviepedia.adapter.FilmAdapter;
import id.sch.smktelkom_mlg.privateassignment.xirpl334.moviepedia.model.Film;


/**
 * A simple {@link Fragment} subclass.
 */
public class NowPlaying extends Fragment {
    ArrayList<Film> mList = new ArrayList<>();
    FilmAdapter mAdapter;

    public NowPlaying() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_now_playing, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);
        mAdapter = new FilmAdapter(this,mList);
        recyclerView.setAdapter(mAdapter);
        return view;
    }

}
