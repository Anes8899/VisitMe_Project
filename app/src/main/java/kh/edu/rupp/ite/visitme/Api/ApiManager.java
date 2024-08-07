package kh.edu.rupp.ite.visitme.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {

    private static ApiManager instance;

    private ApiService apiService;

    private ApiManager(){}

    public static synchronized ApiManager getInstance(){
        if(instance == null){
            instance = new ApiManager();
        }
        return instance;
    }

    public ApiService getApiService(){
        if (apiService == null){
            Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://smlp-pub.s3.ap-southeast-1.amazonaws.com/iteapp-api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            apiService = retrofit.create(ApiService.class);
        }
        return apiService;
    }
}
