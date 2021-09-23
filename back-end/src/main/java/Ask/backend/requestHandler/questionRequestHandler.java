package Ask.backend.requestHandler;

import Ask.backend.dbOpertions.questionOperation;
import Ask.backend.dbOpertions.userOperation;
import Ask.backend.models.builder.Director;
import Ask.backend.models.question;
import Ask.backend.models.reply;
import Ask.backend.security.proxy;
import org.bson.types.ObjectId;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class questionRequestHandler {
    private proxy trackingSystem=new proxy();
    private questionOperation dbQuestionOperation=new questionOperation();
    private userOperation dbUserOperation=new userOperation();
    Director director=new Director();
   /* public List<question> getfollowersQuestion(String id){
        ObjectId realID=trackingSystem.checkAcess(id);
        if (realID==null) return null;
        List<ObjectId> IDS=dbUserOperation.getuserMeFollow(realID);
        return  null;
    }*/
    public boolean AddQuestion(String AskedQuestionID,String userName,String obj){
        ObjectId realID;
        realID=trackingSystem.checkAcess(AskedQuestionID);
        if(realID.equals(null)) return false;
        question AddedQuestion= (question) director.composeModel("question",obj);
        ObjectId questionId=dbQuestionOperation.writeQuestionTOdb(AddedQuestion);
        // thread to update and add question information in current user
        new Thread(() -> {
            dbUserOperation.updateAskedQuestion(realID,questionId);
        }).start();
        // thread to update and add question information in sent user
        new Thread(() -> {
            dbUserOperation.updateAnsweredQuestion(userName,questionId);
        }).start();
        return true;
    }

    public List<question>  getUserAnsweredQuestion(String id){
        ObjectId realID=trackingSystem.checkAcess(id);
        List<question> result= dbQuestionOperation.getAnsweredQuestions(realID);
        for (question q:result) {
            q.setStringID(q.getId().toHexString());
        }
        return result;
    }
    public boolean AnswerQuestion(String id,String dataSent){
        ObjectId realID=trackingSystem.checkAcess(id);
        reply newReply= (reply) director.composeModel("reply",dataSent);
        try {
            JSONObject obj = new JSONObject(dataSent);
            //ObjectId idobject=obj.getJSONObject("questionID");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return true;
    }


}