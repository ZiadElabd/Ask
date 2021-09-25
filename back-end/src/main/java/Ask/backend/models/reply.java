package Ask.backend.models;

import org.bson.codecs.pojo.annotations.BsonProperty;

import java.util.List;

public class reply implements Imodel{
    @BsonProperty("userNameAnswered")
    private String userNameAnswered;
    @BsonProperty("replyText")
    private String replyText;
    @BsonProperty("time")
    private String time;
    @BsonProperty("likes")
    private List<String> likes;



    public String getReplyText() {
        return replyText;
    }

    public void setReplyText(String replyText) {
        this.replyText = replyText;
    }

    public String getUserAnsweredID() {
        return userNameAnswered;
    }

    public void setUserNameAnswered(String userNameAnswered) {
        this.userNameAnswered = userNameAnswered;
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
