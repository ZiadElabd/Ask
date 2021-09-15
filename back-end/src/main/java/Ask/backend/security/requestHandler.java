package Ask.backend.security;

import Ask.backend.dbOpertions.operation;
import Ask.backend.models.user;

public class requestHandler {
    private operation dbOperations=new operation();
    private passcoding passOperations=new passcoding();
    private Singleton trackingSystem;

    public boolean signup(user newUser){
        if (dbOperations.writeTOdb("question", user.class,newUser)) return true;
        return false;
    }

    public boolean signIn(String email,String password){
        user temp= (user) dbOperations.readFromdb("user",email);
        if(temp.getEmail()==null) return false;
        if(!email.equals(temp.getEmail())) return false;
        if(!passOperations.passwordCheck(password,temp.getPassword())) return false;
        trackingSystem=Singleton.getInstance();
        trackingSystem.addOnlineUser(temp.getId());
        return true;
    }


}

