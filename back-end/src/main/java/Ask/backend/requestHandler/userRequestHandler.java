package Ask.backend.requestHandler;

import Ask.backend.dbOpertions.userOperation;
import Ask.backend.models.builder.Director;
import Ask.backend.models.user;
import Ask.backend.security.Singleton;
import Ask.backend.security.passcoding;
import org.bson.types.ObjectId;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class userRequestHandler {
    private userOperation dbOperations=new userOperation();
    private passcoding passOperations=new passcoding();
    private Singleton trackingSystem;
    private Director director=new Director();
    public boolean signup(String object){
        user newUser= (user) director.composeModel("user",object);
        if(newUser==null) return false;
        if (dbOperations.writeUserTOdb(newUser)) return true;
        return false;
    }

    public String signIn(String dataSent){
        String userName;
        String password;
        try {
            JSONObject obj = new JSONObject(dataSent);
            userName=obj.getString("userName");
            password=obj.getString("password");
        } catch (JSONException e) {
            return null;
        }
        user temp= dbOperations.readuserFromdb(userName);
        if(temp==null) return null;
        if(!passOperations.passwordCheck(password,temp.getPassword())) return null;
        trackingSystem=Singleton.getInstance();
        return trackingSystem.addOnlineUser(temp.getId());
    }
    public boolean checkUserName(String userName){
        if(dbOperations.readuserFromdb(userName)==null) return true;
        return false;
    }
    public List<user> getUsers(String id){
        ObjectId realID=trackingSystem.checkUserExist(id);
        if (realID.equals(null)) return null;
       List<user> users= dbOperations.getAllUsers();
        for (user u:users) {
            u.setStringID(u.getId().toHexString());
        }
     return users;
    }
    public user  getuserProfile(String id,String userName){
        ObjectId realID=trackingSystem.checkUserExist(id);
        if (realID.equals(null))return null;
        user result=dbOperations.getuser(userName);
        result.setStringID(result.getId().toHexString());
        return result;

    }
    public boolean AddFollower(String id,String userName){
        ObjectId realID=trackingSystem.checkUserExist(id);
        if (realID.equals(null))return false;
        dbOperations.updatemeFollowList(realID,userName);
       return true;
    }
    public boolean removeFollower(String id,String userName){
     return true;
    }
    public List<user> getFollowers(String id,String userName){
        ObjectId realID=trackingSystem.checkUserExist(id);
        if (realID.equals(null))return null;
        List<String> mefollowList=dbOperations.getMeFollowlist(userName);
         return dbOperations.getfollowersUsers(mefollowList);
    }







}

