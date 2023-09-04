package com.example.texttospeech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText et;
    TextToSpeech ts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btn_ts);
        et = (EditText) findViewById(R.id.texttospeech);
        ts = new TextToSpeech(getBaseContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i != TextToSpeech.ERROR) {
                    ts.setLanguage(Locale.ENGLISH);
                    Toast.makeText(getBaseContext(), "SUCCESS", Toast.LENGTH_LONG).show();
                }
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                speak();
            }

            private void speak() {
                String text = et.getText().toString();
                ts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

    }
}
