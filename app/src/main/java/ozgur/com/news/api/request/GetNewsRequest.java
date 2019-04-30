package ozgur.com.news.api.request;

import ozgur.com.news.model.NewsType;

public class GetNewsRequest {
    NewsType type;

    public NewsType getType() {
        return type;
    }

    public void setType(NewsType type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    int id;

}
