package id.sch.smktelkom_mlg.privateassignment.xirpl334.moviepedia.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.privateassignment.xirpl334.moviepedia.Popular;
import id.sch.smktelkom_mlg.privateassignment.xirpl334.moviepedia.R;
import id.sch.smktelkom_mlg.privateassignment.xirpl334.moviepedia.model.Results;

/**
 * Created by User on 14/05/2017.
 */

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.MyViewHolder> {
    public String url = "https://image.tmdb.org/t/p/w500";
    public String image;
    ArrayList<Results> mlist;
    Popular popular;
    Context context;
    private int lastposition = -1;

    public PopularAdapter(Popular popular, ArrayList<Results> mlist, Context context) {
        this.mlist = mlist;
        this.popular = popular;
        this.context = context;
    }


    @Override
    public PopularAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent, false);
        // set the view's size, margins, paddings and layout parameters
        PopularAdapter.MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(PopularAdapter.MyViewHolder holder, int position) {
        Results results = mlist.get(position);
        holder.tvName.setText(results.title);
        holder.tvDesc.setText(results.overview);
        image = url + results.backdrop_path;
        Glide.with(context).load(image)
                .crossFade()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        if (mlist != null)
            return mlist.size();
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvDesc;
        ImageView imageView;

        public MyViewHolder(View v) {
            super(v);

            tvName = (TextView) v.findViewById(R.id.textViewJudul);
            tvDesc = (TextView) v.findViewById(R.id.textViewDeskripsi);
            imageView = (ImageView) v.findViewById(R.id.imageView);
        }
    }
}
