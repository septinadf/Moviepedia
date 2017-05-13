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

import id.sch.smktelkom_mlg.privateassignment.xirpl334.moviepedia.NowPlaying;
import id.sch.smktelkom_mlg.privateassignment.xirpl334.moviepedia.R;
import id.sch.smktelkom_mlg.privateassignment.xirpl334.moviepedia.model.Film;

/**
 * Created by User on 13/05/2017.
 */

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.ViewHolder>{

    ArrayList<Film> filmList;
    NowPlaying nowPlaying;
    Context context;
    public String url = "https://image.tmdb.org/t/p/w500";
    public String image;
    private int lastposition = -1;


    public FilmAdapter(NowPlaying nowPlaying, ArrayList<Film> mList, Context context) {
        this.filmList = mList;
        this.nowPlaying = nowPlaying;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(FilmAdapter.ViewHolder holder, int position) {
        Film film = filmList.get(position);
        holder.tvJudul.setText(film.judul);
        holder.tvDeskripsi.setText(film.deskripsi);
        image = url+film.backdrop_path;
        Glide.with(context).load(image)
                .crossFade()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher)
                .into(holder.ivFoto);
    }

    @Override
    public int getItemCount() {
        if (filmList!=null)
            return filmList.size();
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivFoto;
        TextView tvJudul;
        TextView tvDeskripsi;

        public ViewHolder(View itemView) {
            super(itemView);
            ivFoto = (ImageView) itemView.findViewById(R.id.imageView);
            tvJudul = (TextView) itemView.findViewById(R.id.textViewJudul);
            tvDeskripsi = (TextView) itemView.findViewById(R.id.textViewDeskripsi);
        }
    }

    public FilmAdapter(NowPlaying nowPlaying, ArrayList<Film> filmList)
    {
        this.filmList = filmList;
    }
}
