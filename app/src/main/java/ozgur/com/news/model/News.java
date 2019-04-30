package ozgur.com.news.model;

import com.google.gson.annotations.SerializedName;

public class News {
    @SerializedName("haberTuru")
    private String type;
    @SerializedName("haberBaslik")
    private String title;
    @SerializedName("haberResmi")
    private String image;
    @SerializedName("haberİcerik")
    private String description;
    @SerializedName("haberYayinlanma")
    private String publishDate;
    @SerializedName("countLike")
    private int likeCount;
    @SerializedName("countDislike")
    private int dislikeCount;
    @SerializedName("countWiew")
    private int viewCount;
    @SerializedName("haberID")
    private int id;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getDislikeCount() {
        return dislikeCount;
    }

    public void setDislikeCount(int dislikeCount) {
        this.dislikeCount = dislikeCount;
    }

    public int getWiewCount() {
        return viewCount;
    }

    public void setWiewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
