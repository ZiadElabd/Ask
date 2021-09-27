package Ask.backend.models.builder;

import Ask.backend.dbOpertions.userOperation;
import Ask.backend.models.Imodel;
import Ask.backend.models.reply;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class replyBuilder implements Ibuilder{
   private reply newRely;
    private userOperation db=new userOperation();


    public void builduserNameAnswered(String userName){
        this.newRely.setUserNameAnswered(userName);
    }
    public void buildReplyText(String text){
        this.newRely.setReplyText(text);
    }
    public void buildTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        this.newRely.setTime(dtf.format(now));

    }
    public void buildPhoto(){
        this.newRely.
                setAnsweredPhoto(db.getProfilePhoto(this.newRely.getUserNameAnswered()));
    }
    public void buildLikes(){
        this.newRely.setLikes(new ArrayList<>());
    }

    @Override
    public boolean comopse(String sentData) {
        newRely=new reply();
        try {
            JSONObject obj = new JSONObject(sentData);
            buildReplyText(obj.getString("text"));
            builduserNameAnswered(obj.getString("userName"));
            buildTime();
            buildLikes();
            buildPhoto();
        } catch (JSONException e) {
          System.out.println("reply creation error");
          return false;
        }
        return true;
    }

    @Override
    public Imodel getModel() {
        return this.newRely;
    }
}
