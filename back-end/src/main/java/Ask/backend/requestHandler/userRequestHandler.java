package Ask.backend.requestHandler;

import Ask.backend.dbOpertions.userOperation;
import Ask.backend.models.builder.Director;
import Ask.backend.models.user;
import Ask.backend.security.Singleton;
import Ask.backend.security.passcoding;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.bson.types.ObjectId;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
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
    public List<user> getUsers(ObjectId realID){
        List<user> users= dbOperations.getAllUsers(realID);
        for (user u:users) {
            u.setStringID(u.getId().toHexString());
        }
     return users;
    }
    public user  getuserProfile(String userName){
        user result=dbOperations.getuser(userName);
        result.setStringID(result.getId().toHexString());
        return result;

    }
    public boolean AddFollower(ObjectId realID,String userName){
        dbOperations.updatemeFollowList(realID,userName);
       return true;
    }
    public boolean removeFollower(ObjectId id,String userName){
        dbOperations.meFollowListRemove(id,userName);
        return true;
    }
    public List<user> getFollowers(String userName){
        List<String> mefollowList=dbOperations.getMeFollowlist(userName);
        List<user> result=dbOperations.getfollowersUsers(mefollowList);
        return result;
    }
    public boolean setProfilePhoto(String userName, MultipartFile image){
        try {
            Binary profile=new Binary(BsonBinarySubType.BINARY,image.getBytes());
            dbOperations.updateProfilePhoto(userName,Base64.getEncoder().encodeToString(profile.getData()) );
        } catch (IOException e) {
            return false;
        }
        return true;
    }
    public String getProfilePhoto(String userName){
          dbOperations.getProfilePhoto(userName);
        return   dbOperations.getProfilePhoto(userName);
    }
    public boolean setCoverPhoto(String userName, MultipartFile image){
        try {
            Binary profile=new Binary(BsonBinarySubType.BINARY,image.getBytes());
            dbOperations.updateCoverPhoto(userName,Base64.getEncoder().encodeToString(profile.getData()) );
        } catch (IOException e) {
            return false;
        }
        return true;
    }
    public String getCoverPhoto(String userName){
        return   dbOperations.getCoverPhoto(userName);
    }
    public boolean updateSettings(ObjectId id,String datasent){
        try {
            JSONObject obj = new JSONObject(datasent);
            String firstName=obj.getString("firstName");
            String lastName=obj.getString("lastName");
            String bio=obj.getString("bio");
            String location= obj.getString("location");
            String gender= obj.getString("gender");
            String birthDate=obj.getString("birthDate");
            dbOperations.setSettings(id,firstName,lastName,location,bio,gender,birthDate);
        } catch (JSONException e) {
            return false;
        }
        return true;
    }








}

