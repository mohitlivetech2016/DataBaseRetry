package com.app.databaseretry;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DataBase mMydb;
    EditText mEtFname,mEtLname,mEtMailId,mEtPassword,mEtPhoneNo;
    Button mBtnSubmit,mBtnViewAll,mBtnUpdateData,mBtnResetData,mBtnDeleteData;

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
        mBtnViewAll=(Button)findViewById(R.id.idBtnShowAllData);
        mBtnSubmit=(Button)findViewById(R.id.idBtnSubmitData);
        mBtnUpdateData=(Button)findViewById(R.id.idBtnUpdateData);
        mBtnDeleteData=(Button)findViewById(R.id.idBtnDeleteData);
        mBtnResetData=(Button)findViewById(R.id.idBtnReset);
        addDate();
        viewAll();
        updateData();
        deletedData();
        resetValue();

    }

    private void resetValue() {

        mBtnResetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mEtFname.setText("");
                mEtLname.setText("");
                mEtMailId.setText("");
                mEtPassword.setText("");
                mEtPhoneNo.setText("");


            }
        });


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

    }

    public void viewAll()
    {
        mBtnViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res=mMydb.getAllData();
                if(res.getCount()==0)
                {
                    //Toast.makeText(MainActivity.this, "No Data", Toast.LENGTH_SHORT).show();
                    //show mes
                    showMessage("Error","No data found");
                    return;
                }

                StringBuffer buffer=new StringBuffer();
                while (res.moveToNext())
                {
                    buffer.append("First Name :"+res.getString(0)+"\n"+ " ");
                    buffer.append("Lname :"+res.getString(1)+ "\n");
                    buffer.append("MailId :"+res.getString(2)+ "\n");
                    buffer.append("Password :"+res.getString(3)+ "\n");
                    buffer.append("MobNo :"+res.getString(4)+ "\n");

                }
                //show all data
                showMessage("Data",buffer.toString());
            }
        });

    }

    public void showMessage(String title,String Messages)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Messages);
        builder.show();

    }


    public void updateData()
    {

        mBtnUpdateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fName,lName,mailId,pass,mobileNo;
                fName=mEtFname.getText().toString();
                lName=mEtLname.getText().toString();
                mailId=mEtMailId.getText().toString();
                pass=mEtPassword.getText().toString();
                mobileNo=mEtPhoneNo.getText().toString();
                boolean isUpdated= mMydb.updateMessages(fName,lName,mailId,pass,mobileNo);

                if(isUpdated==true)
                {

                    Toast.makeText(MainActivity.this, "Update Successfully", Toast.LENGTH_SHORT).show();
                }

                else
                {
                    Toast.makeText(MainActivity.this, "Please try again", Toast.LENGTH_SHORT).show();

                }
            }
        });


    }

    public void deletedData()
    {
        mBtnDeleteData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mailId;
                mailId=mEtMailId.getText().toString();

                Integer isDeleted=mMydb.deleteData(mailId);

                if(isDeleted >0)
                {
                    Toast.makeText(MainActivity.this, "Row Deleted Successfully", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Try Again", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
