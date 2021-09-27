package Ask.backend.models.builder;

import Ask.backend.dbOpertions.userOperation;
import Ask.backend.models.Imodel;
import Ask.backend.models.question;
import Ask.backend.models.reply;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class questionBuilder implements Ibuilder{
    private question newQuestion;
    private userOperation db=new userOperation();
    public void buildaskedUser(String AskedUser){
        this.newQuestion.setAskedUser(AskedUser);
    }
    public void buildquestionText(String text){
        this.newQuestion.setQuestionText(text);
    }
    public void buildreplies(){
        this.newQuestion.setReplies(new reply());
    }
    public void buildtime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        this.newQuestion.setTime(dtf.format(now));
    }
    public void buildPhoto(){
        this.newQuestion.setAskedPhoto(db.getProfilePhoto(this.newQuestion.getAskedUser()));
    }
    public void buildanoymos(boolean state){
        this.newQuestion.setAnoymos(state);
    }
    public void buildAnswered(){this.newQuestion.setAnswered(false);}
    @Override
    public boolean comopse(String sentData)  {
        newQuestion=new question();
        try {
            JSONObject obj = new JSONObject(sentData);
            buildaskedUser(obj.getString("askedUser"));
            buildanoymos(obj.getBoolean("anoymos"));
            buildquestionText(obj.getString("text"));
            buildAnswered();
            buildtime();
            buildreplies();
            buildPhoto();
        } catch (JSONException e) {
            System.out.println("error in create question");
            return false;
        }
        return true;
    }

    @Override
    public Imodel getModel() {
        return this.newQuestion;
    }
}
