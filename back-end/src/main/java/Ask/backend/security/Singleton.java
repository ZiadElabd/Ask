package Ask.backend.security;

import org.bson.types.ObjectId;

import java.util.Hashtable;
import java.util.UUID;

public class Singleton implements  Iproxy{
    private static Singleton instance = null;
    private static Hashtable<String , ObjectId> onlineUser=new Hashtable<>();

    private Singleton(){}

    public static Singleton getInstance() {
        if (instance==null){
            instance=new Singleton();
        }
        return instance;
    }
    public  Hashtable getOnlineUser(){
        return this.onlineUser;
    }
    public String addOnlineUser(ObjectId id){
        String uniqueID = UUID.randomUUID().toString();
        onlineUser.put(uniqueID,id);
        return uniqueID;
    }
    public boolean checkUser(String id){
        return onlineUser.containsKey(id);
    }
    public ObjectId checkAcess(String id){
        ObjectId realID=null;
        try {
            realID=onlineUser.get(id);
        }catch (Exception e){
            return null;
        }
        return realID;
    }
    public void deleteOnlineUser(String id){
         onlineUser.remove(id);
    }

}
