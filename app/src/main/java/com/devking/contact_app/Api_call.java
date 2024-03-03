package com.devking.contact_app;

import android.view.PixelCopy;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api_call {

    @GET("list")
    Call<List<Model_class>> getcontactlist();

}
