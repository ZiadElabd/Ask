package Ask.backend.security;

import Ask.backend.dbOpertions.userOperation;
import org.bson.types.ObjectId;

public class proxy implements Iproxy {
    private Singleton trackingSystem;
    private passcoding passOperations=new passcoding();
    private userOperation dbOperations=new userOperation();


    public ObjectId checkAcess(String id){
        trackingSystem=Singleton.getInstance();
        if (trackingSystem.checkUser(id))
            return trackingSystem.checkAcess(id);
        return  null;
    }
    public void deleteActiveUser(String id){
        trackingSystem.deleteOnlineUser(id);
    }
}
