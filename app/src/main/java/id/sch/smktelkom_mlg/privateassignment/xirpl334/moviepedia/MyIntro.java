package id.sch.smktelkom_mlg.privateassignment.xirpl334.moviepedia;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;


public class MyIntro extends AppIntro {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addSlide(AppIntroFragment.newInstance("MOVIEPEDIA",
                "Temukan Referensi Film Ter-Update",
                R.drawable.a,
                Color.parseColor("#EF4836")));

        addSlide(AppIntroFragment.newInstance("MOVIEPEDIA",
                "Tersedia Film Internasional Terlaris",
                R.drawable.b,
                Color.parseColor("#C0392B")));

        addSlide(AppIntroFragment.newInstance("MOVIEPEDIA",
                "Enjoy your film experience with moviepedia",
                R.drawable.c,
                Color.parseColor("#96281B")));

        showStatusBar(false);
        setBarColor(Color.parseColor("#00ffffff"));
        setSeparatorColor(Color.parseColor("#00ffffff"));
    }

    @Override
    public void onDonePressed() {
        startActivity(new Intent(MyIntro.this, MainActivity.class));
        finish();
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        startActivity(new Intent(MyIntro.this, MainActivity.class));
        Toast.makeText(MyIntro.this, "On Skip Clicked", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void onSlideChanged() {
        Toast.makeText(MyIntro.this, "On Slide Clicked", Toast.LENGTH_SHORT).show();

    }
}
