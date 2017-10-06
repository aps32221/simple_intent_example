package com.example.user.homework;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText id_edt, pw_edt;
    private Button login_btn;
    String id,pw;
    //private boolean isFirst = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        id_edt = (EditText) findViewById(R.id.id_edt);
        pw_edt = (EditText) findViewById(R.id.pw_edt);
        login_btn = (Button) findViewById(R.id.login_btn);

        id = getIntent().getStringExtra("ID");
        pw = getIntent().getStringExtra("PW");

        /*isFirst = getSharedPreferences("account", MODE_PRIVATE).getBoolean("isFirst", true);
        if(isFirst){
            getSharedPreferences("account", MODE_PRIVATE).edit().putString("ID", "a")
                    .putString("PW", "a")
                    .putBoolean("isFirst", false)
                    .apply();
        }*/

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(id_edt.getText().toString().equals(id) &&
                        pw_edt.getText().toString().equals(pw)){
                    Toast.makeText(LoginActivity.this, "登入成功", Toast.LENGTH_LONG).show();
                    getIntent().putExtra("ID", id_edt.getText().toString());
                    getIntent().putExtra("PW", pw_edt.getText().toString());
                    setResult(MainActivity.LOGIN_SUCCESS, getIntent());
                    finish();
                }else{
                    Toast.makeText(LoginActivity.this, "帳號或密碼有誤", Toast.LENGTH_LONG).show();
                    setResult(MainActivity.LOGIN_FAILED, getIntent());
                    finish();
                }
            }
        });

    }
}
