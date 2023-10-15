package com.example.walpaper;

import androidx.appcompat.app.AppCompatActivity;
import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
// import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Button changewallpaper;
    Timer mytimer;
    Drawable drawable;
    WallpaperManager wpm;
    int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        changewallpaper = findViewById(R.id.button);

        mytimer = new Timer();
        wpm = WallpaperManager.getInstance(this);

        changewallpaper.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                setWallpaper();
            }
        });
    }

    private void setWallpaper() {
        mytimer.schedule(new TimerTask() {

            @Override
            public void run() {

                if(id == 0)
                    drawable = getResources().getDrawable(R.drawable.one);
                else if(id == 1)
                    drawable = getResources().getDrawable(R.drawable.two);
                else if(id == 2)
                    drawable = getResources().getDrawable(R.drawable.three);
                else if(id == 3)
                    drawable = getResources().getDrawable(R.drawable.four);
                else if(id == 4)
                    drawable = getResources().getDrawable(R.drawable.five);
                id = (id+1) % 5;

                Bitmap wallpaper = ((BitmapDrawable)drawable).getBitmap();
                try {
                    wpm.setBitmap(wallpaper);

                } catch (Exception e) {
                    // e.printStackTrace();
                }
            }

        },0,30000);
    }
}