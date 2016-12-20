package com.app.databaseretry;

import java.lang.ref.SoftReference;

/**
 * Created by Android on 20-Dec-16.
 */

public class Student {

    private String mFname;
    private String mLname;

    public String getmMailId() {
        return mMailId;
    }

    public void setmMailId(String mMailId) {
        this.mMailId = mMailId;
    }

    public String getmFname() {
        return mFname;
    }

    public void setmFname(String mFname) {
        this.mFname = mFname;
    }

    public String getmLname() {
        return mLname;
    }

    public void setmLname(String mLname) {
        this.mLname = mLname;
    }

    public String getmPass() {
        return mPass;
    }

    public void setmPass(String mPass) {
        this.mPass = mPass;
    }

    public String getmMobNo() {
        return mMobNo;
    }

    public void setmMobNo(String mMobNo) {
        this.mMobNo = mMobNo;
    }

    private String mMailId;
    private String mPass;
    private String mMobNo;
}
