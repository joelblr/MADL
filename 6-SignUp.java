package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import android.content.Intent;
import java.util.regex.Pattern;

public class Signup extends AppCompatActivity {

  EditText username, pwd;
  Button signup;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    username = (EditText) findViewById(R.id.username);
    pwd = (EditText) findViewById(R.id.password);
    signup = (Button) findViewById(R.id.signup);

    signup.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View view) {
        String email = username.getText().toString();
        String userpwd = pwd.getText().toString();

        if (email.matches("")) {
          Toast
              .makeText(Signup.this, "Username cannot be empty", Toast.LENGTH_LONG)
              .show();
          return;
        }

        if (!isvalidPassword(userpwd)) {
          Toast
              .makeText(Signup.this, "Invalid Password", Toast.LENGTH_LONG)
              .show();
          return;
        }

        Intent intent = new Intent(Signup.this, Signin.class);
        intent.putExtra("email", email);
        intent.putExtra("userpwd", userpwd);
        startActivity(intent);
      }
    });
  }

  Pattern lowercase = Pattern.compile("^.*[a-z].*$");
  Pattern uppercase = Pattern.compile("^.*[A-Z].*$");
  Pattern number = Pattern.compile("^.*[0-9].*$");
  Pattern special = Pattern.compile("^.*[@#$%^&*(){},.;/].*$");

  private boolean isvalidPassword(String userpwd) {

    if (userpwd.length() < 8 || !special.matcher(userpwd).matches()
        || !lowercase.matcher(userpwd).matches()
        || !uppercase.matcher(userpwd).matches()
        || !number.matcher(userpwd).matches()

    )
      return false;

    return true;
  }
}