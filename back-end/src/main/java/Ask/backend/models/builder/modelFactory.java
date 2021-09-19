package Ask.backend.models.builder;

public class modelFactory {
    public Ibuilder getModelBuilder (String name){
        Ibuilder builder = null;
        if(name.equals(null)) return null;
        else if(name.equals("user")){
            builder=new userBuilder();
        }else if(name.equals("question")){
            builder=new questionBuilder();
        }else if(name.equals("reply")){
            builder=new replyBuilder();
        }
        return builder;
    }
}
