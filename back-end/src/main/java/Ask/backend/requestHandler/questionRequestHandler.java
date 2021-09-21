package Ask.backend.requestHandler;

import Ask.backend.dbOpertions.questionOperation;
import Ask.backend.dbOpertions.userOperation;
import Ask.backend.models.builder.Director;
import Ask.backend.models.question;
import Ask.backend.security.proxy;
import org.bson.types.ObjectId;

public class questionRequestHandler {
    private proxy trackingSystem=new proxy();
    private questionOperation dbQuestionOperation=new questionOperation();
    private userOperation dbUserOperation=new userOperation();
    Director director=new Director();

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

}