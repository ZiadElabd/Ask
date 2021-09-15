package Ask.backend.security;

import org.bson.types.ObjectId;

import java.util.Hashtable;
import java.util.UUID;

public class Singleton {
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
    public ObjectId checkUserExist(String id){
        return onlineUser.get(id);
    }
    public void deleteOnlineUser(String id){
         onlineUser.remove(id);
    }

}
