package Ask.backend.models;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

import java.util.List;

public class question implements Imodel {
    @BsonProperty("_id")
    private ObjectId id;
    @BsonProperty("askedID")
    private String askedID;
    @BsonProperty("answeredID")
    private String answeredID;
    @BsonProperty("questionText")
    private String questionText;
    @BsonProperty("replies")
    private reply replies;
    @BsonProperty("time")
    private String time;
    @BsonProperty("anoymos")
    private boolean anoymos;
    @BsonProperty("answered")
    private boolean answered;
    @BsonProperty("likes")
    private List<String> likes;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }


    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public reply getReplies() {
        return replies;
    }

    public void setReplies(reply replies) {
        this.replies = replies;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isAnoymos() {
        return anoymos;
    }

    public void setAnoymos(boolean anoymos) {
        this.anoymos = anoymos;
    }

    public String getAskedID() {
        return askedID;
    }

    public void setAskedID(String askedID) {
        this.askedID = askedID;
    }

    public String getAnsweredID() {
        return answeredID;
    }

    public void setAnsweredID(String answeredID) {
        this.answeredID = answeredID;
    }

    public List<String> getLikes() {
        return likes;
    }

    public void setLikes(List<String> likes) {
        this.likes = likes;
    }

    public boolean isAnswered() {
        return answered;
    }

    public void setAnswered(boolean answered) {
        this.answered = answered;
    }
}
