package Ask.backend.models;

import org.bson.codecs.pojo.annotations.BsonIgnore;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

public class question implements Imodel {
    @BsonProperty("_id")
    private ObjectId id;
    @BsonIgnore
    private String StringID;
    @BsonProperty("askedUser")
    private String askedUser;
    @BsonProperty("questionText")
    private String questionText;
    @BsonProperty("askedPhoto")
    private String askedPhoto;
    @BsonProperty("replies")
    private reply replies;
    @BsonProperty("time")
    private String time;
    @BsonProperty("anoymos")
    private boolean anoymos;
    @BsonProperty("answered")
    private boolean answered;
    @BsonProperty("seen")
    private boolean seen;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getStringID() {
        return StringID;
    }

    public void setStringID(String stringID) {
        StringID = stringID;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getAskedPhoto() {
        return askedPhoto;
    }

    public void setAskedPhoto(String askedPhoto) {
        this.askedPhoto = askedPhoto;
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

    public String getAskedUser() {
        return askedUser;
    }

    public void setAskedUser(String askedUser) {
        this.askedUser = askedUser;
    }


    public boolean isAnswered() {
        return answered;
    }

    public void setAnswered(boolean answered) {
        this.answered = answered;
    }

    public boolean isSeen() {
        return seen;
    }

    public void setSeen(boolean seen) {
        this.seen = seen;
    }
}
