package Ask.backend.security;

import Ask.backend.dbOpertions.operation;
import org.bson.types.ObjectId;

public class proxy  {
    private Singleton trackingSystem;
    private operation dbOperations=new operation();
    private passcoding passOperations=new passcoding();


    public ObjectId checkAcess(String id){
       return trackingSystem.checkUserExist(id);
    }
}
