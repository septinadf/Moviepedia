package id.sch.smktelkom_mlg.privateassignment.xirpl334.moviepedia;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import id.sch.smktelkom_mlg.privateassignment.xirpl334.moviepedia.adapter.MyAdapter;
import id.sch.smktelkom_mlg.privateassignment.xirpl334.moviepedia.model.Results;
import id.sch.smktelkom_mlg.privateassignment.xirpl334.moviepedia.model.ResultsRespons;
import id.sch.smktelkom_mlg.privateassignment.xirpl334.moviepedia.service.GsonGetRequest;
import id.sch.smktelkom_mlg.privateassignment.xirpl334.moviepedia.service.VolleySingleton;


/**
 * A simple {@link Fragment} subclass.
 */
public class NowPlaying extends Fragment {
    ArrayList<Results> mlist = new ArrayList<>();
    MyAdapter myAdapter;

    public NowPlaying() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_now_playing, container, false);

        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.recycleView);
        rv.setHasFixedSize(true);
        myAdapter = new MyAdapter(this, mlist, getContext());
        rv.setAdapter(myAdapter);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);

        downloadDataResource();

        return rootView;
    }

    private void downloadDataResource() {
        String url = "https://api.themoviedb.org/3/movie/now_playing?api_key=83e9bd45d01bdec860110180bf6d664b&language=en-US&page=1";

        GsonGetRequest<ResultsRespons> myRequest = new GsonGetRequest<ResultsRespons>
                (url, ResultsRespons.class, null, new Response.Listener<ResultsRespons>() {

                    @Override
                    public void onResponse(ResultsRespons response) {
                        Log.d("FLOW", "onResponse: " + (new Gson().toJson(response)));
                        fillColor(response.results);
                        mlist.addAll(response.results);
                        myAdapter.notifyDataSetChanged();
                    }

                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("FLOW", "onErrorResponse: ", error);
                    }
                });
        VolleySingleton.getInstance(this).addToRequestQueue(myRequest);
    }

    private void fillColor(List<Results> results) {
        for (int i = 0; i < results.size(); i++)
            results.get(i).color = ColorUtil.getRandomColor();

    }


}
