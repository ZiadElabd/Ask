package Ask.backend.security;

import Ask.backend.dbOpertions.userOperation;
import org.bson.types.ObjectId;

public class proxy  {
    private Singleton trackingSystem;
    private passcoding passOperations=new passcoding();
    private userOperation dbOperations=new userOperation();

    public ObjectId checkAcess(String id){
        trackingSystem=Singleton.getInstance();
       return trackingSystem.checkUserExist(id);
    }
    public void deleteActiveUser(String id){
        trackingSystem.deleteOnlineUser(id);
    }
}
