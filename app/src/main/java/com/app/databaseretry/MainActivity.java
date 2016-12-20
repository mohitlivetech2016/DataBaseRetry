package com.app.databaseretry;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /*DataBase mMydb;
    EditText mEtFname,mEtLname,mEtMailId,mEtPassword,mEtPhoneNo;
    Button mBtnSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMydb= new DataBase(this);

        mEtFname=(EditText)findViewById(R.id.idEtFirstName);
        mEtLname=(EditText)findViewById(R.id.idEtLastName);
        mEtMailId=(EditText)findViewById(R.id.idEtMailId);
        mEtPassword=(EditText)findViewById(R.id.idEtPassword);
        mEtPhoneNo=(EditText)findViewById(R.id.idEtMobileNo);

        mBtnSubmit=(Button)findViewById(R.id.idBtnSubmitData);

        addDate();

    }

    public void addDate()
    {
        mBtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fName,lName,mailId,pass,mobileNo;
                fName=mEtFname.getText().toString();
                lName=mEtLname.getText().toString();
                mailId=mEtMailId.getText().toString();
                pass=mEtPassword.getText().toString();
                mobileNo=mEtPhoneNo.getText().toString();
                boolean isInserted= mMydb.insertData(fName,lName,mailId,pass,mobileNo);


                if(isInserted == true)
                {
                    Toast.makeText(MainActivity.this, "SuccessFull Inserted", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Not Inserted Kindly Insert it Again", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }*/
}
