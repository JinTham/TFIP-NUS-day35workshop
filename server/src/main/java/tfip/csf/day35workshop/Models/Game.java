package tfip.csf.day35workshop.Models;

import java.util.List;

public class Game {
    
    private int gid;
    private String name;
    private int year;
    private int ranking;
    private String url;
    private String image;
    private List<Comment> comments;
    
    public Game() {
    }

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }



    public int getGid() {
        return gid;
    }



    public void setGid(int gid) {
        this.gid = gid;
    }


}
