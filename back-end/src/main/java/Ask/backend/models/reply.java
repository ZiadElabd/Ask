package Ask.backend.models;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;

public class reply {
    @BsonProperty("_id")
    private ObjectId id;
    @BsonProperty("nodeQuestion")
    private String nodeQuestion;
    @BsonProperty("replyText")
    private String replyText;
    @BsonProperty("time")
    private LocalDateTime time;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNodeQuestion() {
        return nodeQuestion;
    }

    public void setNodeQuestion(String nodeQuestion) {
        this.nodeQuestion = nodeQuestion;
    }

    public String getReplyText() {
        return replyText;
    }

    public void setReplyText(String replyText) {
        this.replyText = replyText;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
