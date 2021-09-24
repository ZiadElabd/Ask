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

import java.util.ArrayList;
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

    public List<question>  getUserUnAnsweredQuestion(String id,String userName){
        ObjectId realID=trackingSystem.checkAcess(id);
        if (realID.equals(null)) return null;
        List<question> result= dbQuestionOperation.getUnAnsweredQuestions(userName);
        for (question q:result) {
            q.setStringID(q.getId().toHexString());
        }
        return result;
    }
    public List<question> getUserAnsweredQuestion(String id,String userName){
        ObjectId realID=trackingSystem.checkAcess(id);
        if (realID.equals(null)) return null;
        List<question> result=dbQuestionOperation.getAnsweredQuestions(userName);
        for (question q:result) {
            q.setStringID(q.getId().toHexString());
        }
        return result;
    }
    public boolean AnswerQuestion(String id,String dataSent){
        ObjectId realID=trackingSystem.checkAcess(id);
        if (realID.equals(null)) return false;
        ObjectId questionID;
        reply newReply= (reply) director.composeModel("reply",dataSent);
        try {
            JSONObject obj = new JSONObject(dataSent);
            questionID=new ObjectId(obj.getString("QuestionStringID"));
        } catch (JSONException e) {
            return false;
        }
        dbQuestionOperation.addReply(questionID,newReply);
        return true;
    }
    public List<question> getFollwersQuestions(String id ,String userName){
        ObjectId realID=trackingSystem.checkAcess(id);
        if (realID.equals(null)) return null;
        List<String> mefollowList=dbUserOperation.getMeFollowlist(userName);
        List<question> questions=new ArrayList<>();
        for (String user:mefollowList) {
            questions.addAll(dbQuestionOperation.getAnsweredQuestions(user));
        }

        for (question q:questions) {
            q.setStringID(q.getId().toHexString());
        }
        return questions;
    }


}