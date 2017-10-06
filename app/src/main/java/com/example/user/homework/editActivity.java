package com.example.user.homework;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class editActivity extends AppCompatActivity {

    private EditText id_edt, pw_edt;
    private Button check_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        id_edt = (EditText) findViewById(R.id.iid_edt);
        pw_edt = (EditText) findViewById(R.id.ipw_edt);
        check_btn = (Button) findViewById(R.id.check_btn);

        check_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*SharedPreferences account = getSharedPreferences("account", MODE_PRIVATE);
                account.edit().putString("ID", id_edt.getText().toString())
                        .putString("PW", pw_edt.getText().toString())
                        .apply();*/
                getIntent().putExtra("ID", id_edt.getText().toString())
                        .putExtra("PW", pw_edt.getText().toString());
                Toast.makeText(editActivity.this, "修改完成 請重新登入", Toast.LENGTH_LONG).show();
                setResult(MainActivity.MODIFY_SUCCESS, getIntent());
                finish();
            }
        });
    }
}
