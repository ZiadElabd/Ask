package Ask.backend.models;

import org.bson.codecs.pojo.annotations.BsonProperty;

import java.util.List;

public class reply implements Imodel{
    @BsonProperty("userNameAnswered")
    private String userNameAnswered;
    @BsonProperty("answeredPhoto")
    private String answeredPhoto;
    @BsonProperty("replyText")
    private String replyText;
    @BsonProperty("time")
    private String time;
    @BsonProperty("likes")
    private List<String> likes;


    public String getUserNameAnswered() {
        return userNameAnswered;
    }

    public void setUserNameAnswered(String userNameAnswered) {
        this.userNameAnswered = userNameAnswered;
    }

    public String getReplyText() {
        return replyText;
    }

    public void setReplyText(String replyText) {
        this.replyText = replyText;
    }

    public String getAnsweredPhoto() {
        return answeredPhoto;
    }

    public void setAnsweredPhoto(String answeredPhoto) {
        this.answeredPhoto = answeredPhoto;
    }

    public List<String> getLikes() {
        return likes;
    }

    public void setLikes(List<String> likes) {
        this.likes = likes;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }



}
