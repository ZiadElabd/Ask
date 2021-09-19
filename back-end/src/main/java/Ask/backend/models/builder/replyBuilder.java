package Ask.backend.models.builder;

import Ask.backend.models.Imodel;
import Ask.backend.models.reply;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class replyBuilder implements Ibuilder{
   private reply newRely;
    public void buildnodeQuestionID(String id){
        this.newRely.setNodeQuestionID(id);
    }
    public void builduserAnsweredID(String id){
        this.newRely.setUserAnsweredID(id);
    }
    public void buildReplyText(String text){
        this.newRely.setReplyText(text);
    }
    public void buildTime(String date){
        this.newRely.setTime(date);
    }
    public void buildLikes(){
        this.newRely.setLikes(new ArrayList<>());
    }

    @Override
    public boolean comopse(String sentData) {
        newRely=new reply();
        try {
            JSONObject obj = new JSONObject(sentData);
            buildnodeQuestionID( obj.getString("nodeQuestionID"));
            buildReplyText(obj.getString("text"));
            builduserAnsweredID(obj.getString("userAnsweredID"));
            buildTime(obj.getString("time"));
            buildLikes();
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
