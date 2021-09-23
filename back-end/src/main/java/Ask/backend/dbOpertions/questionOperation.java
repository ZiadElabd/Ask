package Ask.backend.dbOpertions;

import Ask.backend.models.question;
import Ask.backend.models.reply;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.addToSet;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class questionOperation {
    private String mongoUri = "mongodb+srv://askadmin:askadmin@cluster0.unqsy.mongodb.net/ziad?retryWrites=true&w=majority";
    private String databaseName = "ask";
    MongoDatabase users = MongoClients.create(mongoUri).getDatabase(databaseName);
    CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
    CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));
    MongoDatabase database = users.withCodecRegistry(pojoCodecRegistry);
    MongoCollection collection = database.getCollection("question", question.class);
    userOperation userDBoperation=new userOperation();
    public ObjectId writeQuestionTOdb(question obj) {
        ObjectId id=new ObjectId();
        try {
            id=collection.insertOne(obj).getInsertedId().asObjectId().getValue();
        } catch (Exception e) {
            return null;
        }
        return id;
    }

    public List<question> getAskedQuestion(ObjectId id){
        List<ObjectId> AskedQuestionsID=userDBoperation.getUserAskedQuestions(id);
        Bson queryFilter=in("_id",AskedQuestionsID);
        List<question> result=new ArrayList<>();
        collection.find(queryFilter).into(result);
        return result;
    }
    public List<question> getAnsweredQuestions(String userName){
        List<ObjectId> AnsweredQuestionsID=userDBoperation.getUserAnsweredQuestions(userName);
        Bson queryFilter=and(in("_id",AnsweredQuestionsID),eq("answered",true));
        List<question> result=new ArrayList<>();
        collection.find(queryFilter).into(result);
        return result;
    }
    public List<question> getUnAnsweredQuestions(String userName){
        List<ObjectId> AnsweredQuestionsID=userDBoperation.getUserAnsweredQuestions(userName);
        Bson queryFilter=and(in("_id",AnsweredQuestionsID),eq("answered",false));
        List<question> result=new ArrayList<>();
        collection.find(queryFilter).into(result);
        return result;
    }
    public void addReply(ObjectId questionID,reply newReply){
        Bson queryFilter=in("_id",questionID);
        Bson update=addToSet("replies",newReply);
        collection.updateOne(queryFilter,update);
    }

}
