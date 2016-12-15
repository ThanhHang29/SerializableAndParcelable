package com.ttth.example;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Thanh Hang on 15/12/16.
 */

public class ActivitySecond extends AppCompatActivity {
    private static final String TAG = "Activity_second_serialiable";
    public static final String KEY_ACCOUNT_NEW = "account_new";
    public static final String KEY_DATA = "key_data";
    private EditText edtUser, edtPass;
    private Button btnStart;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();
        getData();
    }

    private void initView() {
        edtUser = (EditText) this.findViewById(R.id.edtUser);
        edtPass = (EditText) this.findViewById(R.id.edtPass);
        btnStart = (Button) this.findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edtUser.getText().toString();
                String pass = edtPass.getText().toString();
                if (!user.isEmpty() && !pass.isEmpty()){
                    AccountSeriable accountNew = new AccountSeriable(user,pass);
                    Intent intent1 = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(KEY_ACCOUNT_NEW,accountNew);
                    intent1.putExtra(KEY_DATA,bundle);
                    setResult(RESULT_OK,intent1);
                    finish();
                }

            }
        });
    }
    public void getData(){
        Intent intent = getIntent();
        AccountSeriable account = (AccountSeriable) intent.getSerializableExtra(MainActivity.KEY_ACCOUNT);
        edtUser.setText(account.getUser());
        edtPass.setText(account.getPass());

    }
}
