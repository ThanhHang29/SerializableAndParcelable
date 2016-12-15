package com.ttth.example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public static final String KEY_ACCOUNT = "key_account";
    private static final int SERIALIZABLE = 0;
    public static final String KEY_ACCOUNT_PARCE = "key_account_parce";
    private static final int PARCELABLE = 1;
    private TextView tvUser,tvPass;
    private Button btnSerializable, btnParceLable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        tvUser = (TextView) this.findViewById(R.id.tvUser);
        tvPass = (TextView) this.findViewById(R.id.tvPass);
        btnSerializable = (Button) this.findViewById(R.id.btnSerializable);
        btnParceLable = (Button) this.findViewById(R.id.btnParcelable);

        btnSerializable.setOnClickListener(this);
        btnParceLable.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSerializable:
                AccountSeriable account = new AccountSeriable("Hihi","1234");
                Intent intent = new Intent(MainActivity.this,ActivitySecond.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable(KEY_ACCOUNT,account);
                intent.putExtras(bundle);
                startActivityForResult(intent,SERIALIZABLE);
                break;
            case R.id.btnParcelable:
                AccountParce account1 = new AccountParce("Hihi","1234");
                Intent intent1 = new Intent(MainActivity.this,ActivitySecondParce.class);
                Bundle bundle1 = new Bundle();
                bundle1.putParcelable(KEY_ACCOUNT_PARCE,account1);
                intent1.putExtras(bundle1);
                startActivityForResult(intent1,PARCELABLE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SERIALIZABLE && resultCode == RESULT_OK){
            Bundle bundle = data.getBundleExtra(ActivitySecond.KEY_DATA);
            AccountSeriable account = (AccountSeriable) bundle.getSerializable(ActivitySecond.KEY_ACCOUNT_NEW);
            tvUser.setText(account.getUser());
            tvPass.setText(account.getPass());
        }
        if (requestCode == PARCELABLE && resultCode == RESULT_OK){
            Bundle bundle = data.getBundleExtra(ActivitySecondParce.KEY_DATA_PARCE);
            AccountParce account = bundle.getParcelable(ActivitySecondParce.KEY_ACCOUNT_NEW_PARCE);
            tvUser.setText(account.getUser());
            tvPass.setText(account.getPass());
        }
    }
}
