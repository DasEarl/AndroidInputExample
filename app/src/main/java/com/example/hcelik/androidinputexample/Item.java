package com.example.hcelik.androidinputexample;

import android.content.ClipData;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by hcelik on 26.08.17
 */

class Item {
    private String title;
    private String firstname;
    private String lastname;

    public Item(String title, String firstname, String lastname) {
        this.title = title;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getTitle() {
        return title;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    @Override
    public String toString() {
        return String.format("Title: %s, Firstname: %s, Lastname: %s", this.title, this.firstname, this.lastname);
    }
}
