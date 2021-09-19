package Ask.backend.models;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

import java.util.List;

public class reply implements Imodel{
    @BsonProperty("_id")
    private ObjectId id;
    @BsonProperty("nodeQuestionID")
    private String nodeQuestionID;
    @BsonProperty("userAnsweredID")
    private String userAnsweredID;
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

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNodeQuestionID() {
        return nodeQuestionID;
    }

    public void setNodeQuestionID(String nodeQuestionID) {
        this.nodeQuestionID = nodeQuestionID;
    }

    public String getUserAnsweredID() {
        return userAnsweredID;
    }

    public void setUserAnsweredID(String userAnsweredID) {
        this.userAnsweredID = userAnsweredID;
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
