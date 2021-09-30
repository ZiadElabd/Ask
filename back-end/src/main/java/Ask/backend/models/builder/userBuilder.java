package Ask.backend.models.builder;

import Ask.backend.models.Gender;
import Ask.backend.models.user;
import Ask.backend.security.passcoding;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class userBuilder implements Ibuilder {
   private user newUser ;

    public void buildEamil(String email) {
        this.newUser.setEmail(email);
    }

    public void buildPassword(String password) {
        passcoding temp=new passcoding();
       this.newUser.setPassword(temp.encoding(password));
    }

    public void buildUsername(String username) {
       this.newUser.setUserName(username);
    }
    public void buildAskedQuestion() {
       this.newUser.setAskedQuestions(new ArrayList<>());
    }
    public void buildAnsweredQuestion() {
        this.newUser.setAnsweredQuestions(new ArrayList<>());
    }
    public void buildBirthdate(String date) {
        this.newUser.setBirthDate(date);
    }
    public void buildGender(Gender gender) {
        this.newUser.setGender(gender);
    }
    public void buildFirstname(String firstName){
        this.newUser.setFirstName(firstName);
    }
    public void buildLastName(String lastName){
        this.newUser.setLastName(lastName);
    }
    public void buildmeFollow(){
        this.newUser.setMeFollow(new ArrayList<>());
    }
    public void buildfollowMe(){
        this.newUser.setFollowMe(new ArrayList<>());
    }
    @Override
    public user getModel() {
        return this.newUser;
    }
    @Override
    public boolean comopse(String sentData) {
        this.newUser = new user();
        try {
            JSONObject obj = new JSONObject(sentData);
            buildEamil(obj.getString("email"));
            buildPassword(obj.getString("password"));
            buildUsername(obj.getString("username"));
            buildAnsweredQuestion();
            buildAskedQuestion();
            buildmeFollow();
            buildfollowMe();
            Gender sex;
            String gender=obj.getString("gender");
            if (gender.equals("Male")) sex = Gender.Male;
            else if (gender.equals("Female")) sex = Gender.Female;
            else sex = Gender.engineer;
            buildGender(sex);
            buildBirthdate(obj.getString("birthDate"));
            buildFirstname(obj.getString("firstName"));
            buildLastName(obj.getString("lastName"));

        } catch (JSONException e) {
            return false;
        }
        return true;
    }

}
