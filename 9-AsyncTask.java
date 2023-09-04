package com.example.asynctask;

import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

  TextView tv;
  Button start, stop;

  @Override
  protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    start = (Button) findViewById(R.id.btn_start);
    stop = (Button) findViewById(R.id.btn_stop);
    tv = (TextView) findViewById(R.id.text_aync);

    LongRunningTask longRunningTask = new LongRunningTask();

    start.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        longRunningTask.doInBackground();
        longRunningTask.onProgressUpdate();
      }
    });

    stop.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            // tv.setSelected(false);
            longRunningTask.onPostExecute("AsyncTask Completed");
          }
        });
  }

  private class LongRunningTask extends AsyncTask<String, String, String> {

    @Override
    protected void onPreExecute() {
      super.onPreExecute();
    }

    @Override
    protected void onProgressUpdate(String... values) {
      super.onProgressUpdate(values);
      Toast
          .makeText(
              getApplicationContext(),
              "Banner is moving",
              Toast.LENGTH_LONG)
          .show();
    }

    @Override
    protected String doInBackground(String... strings) {
      tv.setEllipsize(TextUtils.TruncateAt.MARQUEE);
      tv.setSelected(true);
      tv.setVisibility(View.VISIBLE);
      return null;
    }

    @Override
    protected void onPostExecute(String s) {
      super.onPostExecute(s);
      tv.setSelected(false); //
      tv.setVisibility(View.INVISIBLE);
      Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
    }
  }
}
