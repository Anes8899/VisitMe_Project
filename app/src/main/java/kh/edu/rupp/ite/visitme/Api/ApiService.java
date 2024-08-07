package kh.edu.rupp.ite.visitme.Api;

import java.util.List;

import kh.edu.rupp.ite.visitme.Model.Place;
import kh.edu.rupp.ite.visitme.Model.Profile;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("top-places.json")
    Call<List<Place>>loadingPlace();

    @GET("user-profile.json")
    Call<Profile>loadingProfile();
}
