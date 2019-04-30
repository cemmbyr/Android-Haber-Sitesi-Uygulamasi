package ozgur.com.news.api.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import ozgur.com.news.model.News;

public class GetNewsResponse {
    @SerializedName("news")
    private List<News> newsList;

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }
}
