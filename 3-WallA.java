package com.example.mywallpaper;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.io.IOException;


public class MainActivity extends AppCompatActivity {

    Button wallcg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wallcg=(Button)findViewById(R.id.button);
        wallcg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changewp(); 
            }
        });
    }

    private void changewp() {

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
                R.drawable.img1);

        WallpaperManager manager =
                WallpaperManager.getInstance(getApplicationContext());

        try {
            manager.setBitmap(bitmap);
            Toast.makeText(this, "Wallpaper set successfully", Toast.LENGTH_LONG);
        } catch (IOException e)  { e.printStackTrace(); }
    }
}