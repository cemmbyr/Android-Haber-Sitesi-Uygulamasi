package ozgur.com.news.api;

import ozgur.com.news.api.request.GetNewsRequest;
import ozgur.com.news.api.response.GetNewsResponse;
import ozgur.com.news.api.response.GetidResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


public interface APIService {


    @POST("/getNews")
    Call<GetNewsResponse> verilerimilistele(@Body GetNewsRequest request);

    @POST("/increaseCountLike")
    Call<GetidResponse> idLikeListele(@Body GetNewsRequest request);

    @POST("/increaseCountDislike")
    Call<GetidResponse> idDisListele(@Body GetNewsRequest request);

    @POST("/increaseCountView")
    Call<GetidResponse> idViewListele(@Body GetNewsRequest request);

}
