package ozgur.com.news.api.response;

import com.google.gson.annotations.SerializedName;

public class GetidResponse {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @SerializedName("newsID")
    private int id;
}
