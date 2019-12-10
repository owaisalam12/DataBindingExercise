package com.owais.databindingbexercise.db;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.owais.databindingbexercise.BR;

@Entity(tableName = "contacts")
public class Contact extends BaseObservable {
    @ColumnInfo(name = "contact_id")
    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name = "contact_name")
    private String name;

    @ColumnInfo(name = "contact_email")
    private String email;

    @ColumnInfo(name = "contact_country")
    private String country;

    @ColumnInfo(name = "contact_date")
    private String date;

    @Ignore
    public Contact() {
    }

    public Contact(long id, String name, String email, String country, String date) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.country = country;
        this.date = date;
    }
    @Bindable
    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;

        notifyPropertyChanged(BR.id);
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);

    }

    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.email);

    }

    @Bindable
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
        notifyPropertyChanged(BR.country);

    }

    @Bindable
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
        notifyPropertyChanged(BR.date);

    }
}
