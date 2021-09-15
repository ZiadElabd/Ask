package Ask.backend.models;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.List;

public class user {
    @BsonProperty("_id")
    private ObjectId id;
    @BsonProperty("email")
    private String email;
    @BsonProperty("password")
    private String password;
    @BsonProperty("userName")
    private String userName;
    @BsonProperty("askedQuestions")
    private List<question> askedQuestions;
    @BsonProperty("answeredQuestions")
    private List<question> answeredQuestions;


    @BsonProperty("birthDate")
    private String birthDate;

    public user() {
    }

    ;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<question> getAskedQuestions() {
        return askedQuestions;
    }

    public void setAskedQuestions(List<question> askedQuestions) {
        this.askedQuestions = askedQuestions;
    }

    public List<question> getAnsweredQuestions() {
        return answeredQuestions;
    }

    public void setAnsweredQuestions(List<question> answeredQuestions) {
        this.answeredQuestions = answeredQuestions;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        byte[] decodedBytes = Base64.getDecoder().decode(password);
        String pass = null;
        try {
             pass=new String(decodedBytes,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "user{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password+"  " +pass+ '\'' +
                ", userName='" + userName + '\'' +
                ", askedQuestions=" + askedQuestions +
                ", answeredQuestions=" + answeredQuestions +
                ", birthDate='" + birthDate + '\'' +
                '}';
    }
}
