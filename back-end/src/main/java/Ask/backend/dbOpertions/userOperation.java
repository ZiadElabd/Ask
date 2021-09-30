package Ask.backend.dbOpertions;

import Ask.backend.models.user;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class userOperation {
    private String mongoUri = "mongodb+srv://askadmin:askadmin@cluster0.unqsy.mongodb.net/ziad?retryWrites=true&w=majority";
    private String databaseName = "ask";
    MongoDatabase users = MongoClients.create(mongoUri).getDatabase(databaseName);
    CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
    CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));
    MongoDatabase database = users.withCodecRegistry(pojoCodecRegistry);
    MongoCollection collection = database.getCollection("user", user.class);

    public boolean writeUserTOdb(user obj) {
        try {
            collection.insertOne(obj);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public user readuserFromdb(String username){
        Bson queryFilter = new Document("userName",username);
        Bson projection = new Document("userName",1).append("password",1);
        user result = null;
        try {
            result = (user) collection
                    .find(queryFilter)
                    .projection(projection)
                    .first();
        }catch (NoSuchElementException e){
            return null;
        }
        return result;
    }
    public List<ObjectId> getUserAnsweredQuestions(String userName){
        Bson queryFilter = new Document("userName",userName);
        Bson projection = new Document("answeredQuestions",1);
        user result = (user) collection
                .find(queryFilter)
                .projection(projection)
                .first()
                ;
        return result.getAnsweredQuestions();
    }
    public List<ObjectId> getUserAskedQuestions(ObjectId id){
        Bson queryFilter = new Document("_id",id);
        Bson projection = new Document("askedQuestions",1);
        user result = (user) collection
                .find(queryFilter)
                .projection(projection)
                .first()
                ;
        return result.getAskedQuestions();
    }
    public List<String> getMeFollowlist(String userName){
        Bson queryFilter = new Document("userName",userName);
        Bson projection = new Document("mefollow",1);
        user result = (user) collection
                .find(queryFilter)
                .projection(projection)
                .first()
                ;
        return result.getMeFollow();
    }
    public List<user> getfollowersUsers(List<String> followersUserName){
        List<user> result=new ArrayList<>();
        Bson queryFilter = in("userName",followersUserName);
        Bson projection=new Document("firstname",1)
                .append("lastname",1).
                append("userName",1);
        collection.find(queryFilter).projection(projection).into(result);
        return result;
    }

    public void updateAskedQuestion(ObjectId id,ObjectId questionID){
        Bson queryFilter=eq("_id",id);
        Bson update=addToSet("askedQuestions",questionID);
        collection.updateOne(queryFilter,update);
    }
    public void updateAnsweredQuestion(String userName,ObjectId questionID){
        Bson queryFilter=eq("userName",userName);
        Bson update=addToSet("answeredQuestions",questionID);
        collection.updateOne(queryFilter,update);
    }
    public  void updatemeFollowList(ObjectId userID,String toFollow){
        Bson queryFilter=eq("_id",userID);
        Bson update=addToSet("mefollow",toFollow);
        collection.updateOne(queryFilter,update);
    }
    public void meFollowListRemove(ObjectId id,String follower){
        Bson queryFilter=eq("_id",id);
        Bson update=pull("mefollow",follower);
        collection.updateOne(queryFilter,update);
    }
    public void updateProfilePhoto(String userName, String photo){
        Bson queryFilter=eq("userName",userName);
        Bson update=set("profilePhoto",photo);
        collection.updateOne(queryFilter,update);
    }
    public String getProfilePhoto(String userName){
        Bson queryFilter=eq("userName",userName);
        Bson projection = new Document("profilePhoto",1);
        user result= (user) collection.find(queryFilter).projection(projection).first();
        return result.getProfilePhoto();
    }
    public void updateCoverPhoto(String userName,String photo){
        Bson queryFilter=eq("userName",userName);
        Bson update=set("coverPhoto",photo);
        collection.updateOne(queryFilter,update);
    }
    public String getCoverPhoto(String userName){
        Bson queryFilter=eq("userName",userName);
        Bson projection = new Document("coverPhoto",1);
        user result= (user) collection.find(queryFilter).projection(projection).first();
        return result.getCoverPhoto();
    }
    public List<user> getAllUsers(ObjectId id){
         List<user> users=new ArrayList<>();
         Bson queryFilter=ne("_id",id);
         Bson projection=new Document("firstname",1).append("lastname",1).append("userName",1).append("profilePhoto",1);
         collection.find(queryFilter)
                 .projection(projection)
                 .limit(50).into(users);
         return users;
    }
    public user getuser(String userName){
        Bson queryFilter=eq("userName",userName);
        Bson projection=new Document("firstname",1).
                append("lastname",1).
                append("userName",1).
                append("bio",1).
                append("location",1).
                append("birthDate",1).
                append("profilePhoto",1).
                append("coverPhoto",1);
         return (user) collection.find(queryFilter)
                .projection(projection)
                .first();
    }
    public void setSettings(ObjectId id,
                               String firstName,
                               String lastName,
                               String Location,
                               String bio,
                               String gender,
                               String birthdate)
    {
        Bson queryFilter=eq("_id",id);
        Bson update=combine(
                set("firstname",firstName),
                set("lastname",lastName),
                set("location",Location),
                set("bio",bio),
                set("gender",gender),
                set("birthDate",birthdate)
        );
        collection.updateOne(queryFilter,update);
    }
    public boolean deleteUser(ObjectId id){
        Bson queryFilter = new Document("_id",id);
        if (collection.findOneAndDelete(queryFilter)!=null) return true;
        return false;
    }

}