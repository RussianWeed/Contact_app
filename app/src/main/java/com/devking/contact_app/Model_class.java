package com.devking.contact_app;

import com.google.gson.annotations.SerializedName;

public class Model_class {

    @SerializedName("Phn_number")
    int Phn_number;

    @SerializedName("Adhar_card")
    int Adhar_card;

    @SerializedName("Name")
    String Name;

    public Model_class() {
        // Required empty constructor
    }

    public Model_class(int phn_number, int adhar_card, String name) {
        Phn_number = phn_number;
        Adhar_card = adhar_card;
        Name = name;
    }

    public Integer getPhn_number() {
        return Phn_number;
    }

    public void setPhn_number(Integer phn_number) {
        Phn_number = phn_number;
    }

    public Integer getAdhar_card() {
        return Adhar_card;
    }

    public void setAdhar_card(Integer adhar_card) {
        Adhar_card = adhar_card;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
