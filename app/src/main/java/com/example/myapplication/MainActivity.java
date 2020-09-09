 package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

 public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnOne=(Button)findViewById(R.id.button1);
        final TextView txtResult=(TextView)findViewById(R.id.text1);
        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);// 创建一个view，并且将布局加入view中
                 final View viewDialog = LayoutInflater.from(MainActivity.this).inflate(R.layout.zidingyi, null, false);
                 builder.setTitle("登录")
                         .setView(viewDialog)
                         .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                             @Override
                             public void onClick(DialogInterface dialog, int which) {                //取得用户输入内容，注意findViewById前面的viewDialog，表示在该view里面进行查找
                                EditText editTextUserId = viewDialog.findViewById(R.id.edittext_user_id);
                                EditText editTextUserPassword = viewDialog.findViewById(R.id.edittext_user_password);
                                String userid=editTextUserId.getText().toString();
                                 String userpwd=editTextUserPassword.getText().toString();
                                 if(userid.equals("abc")&&userpwd.equals("123")){
                                     Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_LONG).show();
                                 }
                                 else{
                                     Toast.makeText(MainActivity.this,"登录失败",Toast.LENGTH_LONG).show();
                                 }

                             }        })
                         .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                             @Override
                             public void onClick(DialogInterface dialog, int which) {

                             }        });
                 builder.create().show();

            }
        });

    }


 }
