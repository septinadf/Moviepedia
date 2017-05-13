package id.sch.smktelkom_mlg.privateassignment.xirpl334.moviepedia.model;

import android.database.CursorJoiner;

import java.util.List;

/**
 * Created by User on 13/05/2017.
 */

public class FilmResponse {
    public  String page;
    public List<Film> result;
    public String total_result;
    public String total_pages;
}
