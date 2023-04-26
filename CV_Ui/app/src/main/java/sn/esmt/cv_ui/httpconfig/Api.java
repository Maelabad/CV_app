package sn.esmt.cv_ui.httpconfig;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {

    @POST("/usersCV/save")
    Call<CVResponse> save(@Body CVResponse cvResponse);
    //public CVResponse save(@Body CVResponse cvResponse);

    @GET("/usersCV/all")
    public Call<ArrayList<CVResponse>> all();


}
