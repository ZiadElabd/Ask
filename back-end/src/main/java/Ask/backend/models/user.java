package Ask.backend.models;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.List;

public class user implements Imodel{
    @BsonProperty("_id")
    private ObjectId id;
    @BsonProperty("email")
    private String email;
    @BsonProperty("password")
    private String password;
    @BsonProperty("firstname")
    private String firstName;
    @BsonProperty("lastname")
    private String lastname;
    @BsonProperty("userName")
    private String userName;
    @BsonProperty("askedQuestions")
    private List<ObjectId> askedQuestions;
    @BsonProperty("answeredQuestions")
    private List<ObjectId> answeredQuestions;
    @BsonProperty("birthDate")
    private String birthDate;
    @BsonProperty("gender")
    private Gender gender;
    @BsonProperty("mefollow")
    private List<ObjectId> meFollow;
    @BsonProperty ("followMe")
    private List<ObjectId> followMe;
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

    public List<ObjectId> getAskedQuestions() {
        return askedQuestions;
    }

    public void setAskedQuestions(List<ObjectId> askedQuestions) {
        this.askedQuestions = askedQuestions;
    }

    public List<ObjectId> getAnsweredQuestions() {
        return answeredQuestions;
    }

    public void setAnsweredQuestions(List<ObjectId> answeredQuestions) {
        this.answeredQuestions = answeredQuestions;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<ObjectId> getMeFollow() {
        return meFollow;
    }

    public void setMeFollow(List<ObjectId> meFollow) {
        this.meFollow = meFollow;
    }

    public List<ObjectId> getFollowMe() {
        return followMe;
    }

    public void setFollowMe(List<ObjectId> followMe) {
        this.followMe = followMe;
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
               // ", password='" + password+"  " +pass+ '\'' +
                ", userName='" + userName + '\'' +
                ", askedQuestions=" + askedQuestions +
                ", answeredQuestions=" + answeredQuestions +
                ", birthDate='" + birthDate + '\'' +
                "}";
    }
}
