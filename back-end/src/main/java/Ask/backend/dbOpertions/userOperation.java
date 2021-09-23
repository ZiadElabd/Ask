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
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.addToSet;
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
    public List<ObjectId> getUserAnsweredQuestions(ObjectId id){
        Bson queryFilter = new Document("_id",id);
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
    public List<ObjectId> getuserMeFollow(ObjectId id){
        Bson queryFilter = new Document("_id",id);
        Bson projection = new Document("mefollow",1);
        user result = (user) collection
                .find(queryFilter)
                .projection(projection)
                .first()
                ;
        return result.getMeFollow();
    }
    public boolean deleteUser(ObjectId id){
        Bson queryFilter = new Document("_id",id);
        if (collection.findOneAndDelete(queryFilter)!=null) return true;
        return false;
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
    public List<user> getAllUsers(int start,int num){
         List<user> users=new ArrayList<>();
         collection.find().skip(start).limit(num).into(users);
         return users;
    }

}