package com.devking.contact_app;

import android.view.PixelCopy;

import java.util.List;
import java.util.jar.Attributes;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api_call {

    @GET("list")
    Call<List<Model_class>> getcontactlist();


    @FormUrlEncoded
    @POST("create/")
    Call<Model_class> add_data (@Field("Name") String Name , @Field("Phn_number") String Phn_number, @Field("Adhar_card") String Adhar_card);


    @FormUrlEncoded
    @POST("update/")
    Call<Model_class> update_data (@Field("Name") String Name , @Field("Phn_number") String Phn_number, @Field("Adhar_card") String Adhar_card);
}
