package ozgur.com.news;

import android.app.Application;

import ozgur.com.news.api.APIService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


import static ozgur.com.news.api.APIUrl.BASE_URL;

public class NewsApplication extends Application {

    APIService apiService;
   static NewsApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        apiService = retrofit.create(APIService.class);
    }

    public static NewsApplication getInstance() {
        return instance;
    }

    public APIService getApiService() {
        return apiService;
    }
}
