package app.tuancuong.com.tuancuong.Model;

public class WebModel {
    public String url;
    public String title;

    public WebModel(String url, String title) {
        this.url = url;
        this.title = title;
    }

    public WebModel() {
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
