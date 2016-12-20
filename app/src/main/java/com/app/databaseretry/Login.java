package com.app.databaseretry;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText mEtLoginMailId, mEtLoginPassword;
    TextView mTvClicktoRegister;
    Button mBtnLogin;
    DataBase mydb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    private void init() {

        mEtLoginMailId = (EditText) findViewById(R.id.idEtLoginMAilId);
        mEtLoginPassword = (EditText) findViewById(R.id.idEtPassword);
        mTvClicktoRegister = (TextView) findViewById(R.id.idTvGoToRegister);
        mBtnLogin = (Button) findViewById(R.id.idBtnLoginButton);


    }

    public void loginButton(View v)

    {


        if (valid()) {



                Toast.makeText(this, "Login Successfully", Toast.LENGTH_LONG).show();

            } else {
                Toast.makeText(this, "Invalid userid or password", Toast.LENGTH_LONG).show();
            }



    }

    boolean valid() {

        if (mEtLoginMailId.getText().toString().equals("")) {
            mEtLoginMailId.setError("please enter username");
            mEtLoginMailId.requestFocus();
            return false;
        } else if
                (mEtLoginPassword.getText().toString().equals("")) {
            mEtLoginPassword.setError("please enter username");
            mEtLoginPassword.requestFocus();
            return false;
        } else {
            return true;
        }
    }

}
