package com.ttth.example;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Thanh Hang on 15/12/16.
 */

public class AccountParce implements Parcelable{
    private String user, pass;

    public AccountParce(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    protected AccountParce(Parcel in) {
        user = in.readString();
        pass = in.readString();
    }

    public static final Creator<AccountParce> CREATOR = new Creator<AccountParce>() {
        @Override
        public AccountParce createFromParcel(Parcel in) {
            return new AccountParce(in);
        }

        @Override
        public AccountParce[] newArray(int size) {
            return new AccountParce[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(user);
        dest.writeString(pass);
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }
}
