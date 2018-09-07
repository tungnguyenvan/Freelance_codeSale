package app.tuancuong.com.tuancuong.model;

public class WebModel {
    public int image;
    public String url;
    public String title;

    public WebModel(String url, String title) {
        this.url = url;
        this.title = title;
    }

    public WebModel(int image, String url, String title) {
        this.image = image;
        this.url = url;
        this.title = title;
    }

    public WebModel() {
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
