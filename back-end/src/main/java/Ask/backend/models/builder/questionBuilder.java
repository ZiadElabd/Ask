package Ask.backend.models.builder;

import Ask.backend.models.Imodel;
import Ask.backend.models.question;
import Ask.backend.models.reply;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class questionBuilder implements Ibuilder{
    private question newQuestion;
    public void buildaskedID(String id){
        this.newQuestion.setAskedID(id);
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
        this.newQuestion.setTime(now.toString());

    }
    public void buildanoymos(boolean state){
        this.newQuestion.setAnoymos(state);
    }
    public void buildLikes(){
        this.newQuestion.setLikes(new ArrayList<>());
    }
    @Override
    public boolean comopse(String sentData)  {
        newQuestion=new question();
        try {
            JSONObject obj = new JSONObject(sentData);
            buildaskedID(obj.getString("askedID"));
            buildanoymos(obj.getBoolean("anoymos"));
            buildquestionText(obj.getString("text"));
            buildtime();
            buildreplies();
            buildLikes();
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
