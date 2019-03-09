package com.example.mytweet;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    Button  buttonOk;
    EditText userName;
    EditText company;
    EditText date;
    String name,comp, dat;
    Tweet newTweet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        buttonOk = (Button) findViewById(R.id.button2);
        userName = (EditText) findViewById(R.id.editText);
        company = (EditText) findViewById(R.id.editText2);
        date = (EditText) findViewById(R.id.editText3);

        buttonOk.setOnClickListener(this); }

             @Override
             public void onClick(View view) {
                 name = (String) userName.getText().toString();
                 comp = (String) company.getText().toString();
                 dat = (String) date.getText().toString();



                 switch (view.getId()) {
                     case R.id.button2:
                         Intent intent = new Intent(this, MainActivity.class);
                         intent.putExtra("userName",name);
                         intent.putExtra("company",comp);
                         intent.putExtra("date",dat);
                         setResult(Activity.RESULT_OK,intent);
                         finish();
                         break;
                     default:
                         break;
                 }
             }


}
