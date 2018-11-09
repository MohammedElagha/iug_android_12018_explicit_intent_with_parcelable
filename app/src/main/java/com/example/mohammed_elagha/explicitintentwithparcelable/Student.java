package com.example.mohammed_elagha.explicitintentwithparcelable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Mohammed El-Agha on 28/10/18.
 */

public class Student implements Parcelable {

    private int id;
    private String name;
    private double gpa;

    public Student() {

    }

    public Student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }



    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeDouble(gpa);
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    private Student(Parcel in) {
        id = in.readInt();
        name = in.readString();
        gpa = in.readDouble();
        in.readParcelable(Student.class.getClassLoader());
    }
}
