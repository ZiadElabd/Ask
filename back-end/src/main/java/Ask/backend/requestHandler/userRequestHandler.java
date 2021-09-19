package Ask.backend.requestHandler;

import Ask.backend.dbOpertions.*;
import Ask.backend.models.builder.*;
import Ask.backend.models.user;
import Ask.backend.security.Singleton;
import Ask.backend.security.passcoding;
import org.json.JSONException;
import org.json.JSONObject;

public class userRequestHandler {
    private operation dbOperations=new operation();
    private passcoding passOperations=new passcoding();
    private Singleton trackingSystem;
    private Director director=new Director();
    public boolean signup(String object){
        user newUser= (user) director.composeModel("user",object);
        if(newUser==null) return false;
        if (dbOperations.writeTOdb("user", user.class,newUser)) return true;
        return false;
    }

    public String signIn(String dataSent){
        String email;
        String password;
        try {
            JSONObject obj = new JSONObject(dataSent);
            email=obj.getString("email");
            password=obj.getString("password");
        } catch (JSONException e) {
            return null;
        }
        user temp= dbOperations.readuserFromdb("user",email);
        if(temp==null) return null;
        if(!passOperations.passwordCheck(password,temp.getPassword())) return null;
        trackingSystem=Singleton.getInstance();
        return trackingSystem.addOnlineUser(temp.getId());
    }


}

