package pl.edu.pb.mybooksapp;

import android.util.Log;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Book {
    @SerializedName("title")
    private String title;
    @SerializedName("author_name")
    private List<String> authors;
    @SerializedName("cover_i")
    private String cover;
    @SerializedName("number_of_pages_median")
    private String numberOfPages;
    @SerializedName("subtitle")
    private String subtitle;
    @SerializedName("first_publish_year")
    private String publisher;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getNumberOfPages() {
        if(numberOfPages == null)
        {return "No info";}
        else
        {return numberOfPages;}
    }

    public void setNumberOfPages(String numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getSubtitle() {
        if(subtitle == null)
        {return "No subtitle";}
        else
        {return subtitle;}
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getPublisher() {
        if(publisher == null)
        {
            Log.d("Book", "Publisher is null");
            return "No info on publisher";
        }
        else
        {
            Log.d("Book", "Publisher: " + publisher);
            return publisher;
        }
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}