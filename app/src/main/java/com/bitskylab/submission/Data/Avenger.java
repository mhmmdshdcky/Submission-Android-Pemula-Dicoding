package com.bitskylab.submission.Data;

import android.os.Parcel;
import android.os.Parcelable;

public class Avenger implements Parcelable{
    private String name;
    private String remarks;
    private String photo;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;

        public String getName() {
        return name;
    }

        public void setName(String name) {
        this.name = name;
    }

        public String getRemarks() {
        return remarks;
    }

        public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

        public String getPhoto() {
        return photo;
    }

        public void setPhoto(String photo) {
        this.photo = photo;
    }
        @Override
        public int describeContents() {
        return 0;
    }
        @Override
        public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.remarks);
        dest.writeString(this.photo);
    }

    public Avenger() {
    }
    protected Avenger(Parcel in) {
        this.name = in.readString();
        this.remarks = in.readString();
        this.photo = in.readString();
    }
        public static final Parcelable.Creator<Avenger> CREATOR = new Parcelable.Creator<Avenger>() {
            @Override
            public Avenger createFromParcel(Parcel source) {
                return new Avenger(source);
            }
            @Override
            public Avenger[] newArray(int size) {
                return new Avenger[size];
            }
        };
}
