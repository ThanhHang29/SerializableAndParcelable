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

public class ActivitySecondParce extends AppCompatActivity {
    public static final String KEY_ACCOUNT_NEW_PARCE = "account_new_parce";
    public static final String KEY_DATA_PARCE = "data_parce";
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
                    AccountParce accountNew = new AccountParce(user,pass);
                    Intent intent1 = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putParcelable(KEY_ACCOUNT_NEW_PARCE,accountNew);
                    intent1.putExtra(KEY_DATA_PARCE,bundle);
                    setResult(RESULT_OK,intent1);
                    finish();
                }


            }
        });

    }

    public void getData() {
        Intent intent = getIntent();
        AccountParce account = intent.getParcelableExtra(MainActivity.KEY_ACCOUNT_PARCE);
        edtUser.setText(account.getUser());
        edtPass.setText(account.getPass());
    }
}
