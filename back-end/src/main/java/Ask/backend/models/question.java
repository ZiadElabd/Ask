package Ask.backend.models;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;
import java.util.List;

public class question {
    @BsonProperty("_id")
    private ObjectId id;
    @BsonProperty("askedID")
    private String askedID;
    @BsonProperty("answeredID")
    private List<String> answeredID;
    @BsonProperty("questionText")
    private String questionText;
    @BsonProperty("replies")
    private List<reply> replies;
    @BsonProperty("time")
    private LocalDateTime time;


    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getAskedID() {
        return askedID;
    }

    public void setAskedID(String askedID) {
        this.askedID = askedID;
    }

    public List<String> getAnsweredID() {
        return answeredID;
    }

    public void setAnsweredID(List<String> answeredID) {
        this.answeredID = answeredID;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public List<reply> getReplies() {
        return replies;
    }

    public void setReplies(List<reply> replies) {
        this.replies = replies;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
