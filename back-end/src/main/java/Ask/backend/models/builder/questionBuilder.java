package Ask.backend.models.builder;

import Ask.backend.models.Imodel;
import Ask.backend.models.question;
import Ask.backend.models.reply;
import org.json.JSONException;
import org.json.JSONObject;

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
    public void buildtime(String time){
        this.newQuestion.setTime(time);
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
            buildtime(obj.getString("date"));
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