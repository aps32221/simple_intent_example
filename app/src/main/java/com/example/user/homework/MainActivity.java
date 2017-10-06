package com.example.user.homework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private boolean isLogin = false;
    public static final int LOGIN_SUCCESS= 1;
    public static final int LOGIN_FAILED = 2;
    public static final int LOGIN_ONLOGIN = 0;
    public static final int MODIFY_SUCCESS = 3;
    public static final int MODIFY_ONMODIFY = 4;
    private String id = "a";
    private String pw = "a";

    private TextView info_tv;
    private Button edit_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        info_tv = (TextView) findViewById(R.id.info_tv);
        edit_btn = (Button) findViewById(R.id.edit_btn) ;


        edit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this, editActivity.class), MainActivity.MODIFY_ONMODIFY);
            }
        });

        if(!isLogin){
            startActivityForResult(new Intent(this, LoginActivity.class).putExtra("ID", id).putExtra("PW", pw), MainActivity.LOGIN_ONLOGIN);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode){
            case LOGIN_SUCCESS:
                isLogin = true;
                info_tv.setText("已登入");
                break;
            case MODIFY_SUCCESS:
                id = data.getStringExtra("ID");
                pw = data.getStringExtra("PW");
                startActivityForResult(new Intent(this, LoginActivity.class).putExtra("ID", id).putExtra("PW", pw), MainActivity.LOGIN_ONLOGIN);
                break;
            case LOGIN_FAILED:
            default:
                finish();
                break;
        }

    }
}
