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

import java.util.NoSuchElementException;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class operation {
   private String mongoUri = "mongodb+srv://askadmin:askadmin@cluster0.unqsy.mongodb.net/ziad?retryWrites=true&w=majority";
   private String databaseName = "ask";
    MongoDatabase users = MongoClients.create(mongoUri).getDatabase(databaseName);
    CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
    CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));
    MongoDatabase database = users.withCodecRegistry(pojoCodecRegistry);
    public boolean writeTOdb( String name,Class type,Object obj) {
        try {
            MongoCollection<Object> collection = database.getCollection(name, type);
            collection.insertOne(obj);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    public user readuserFromdb(String name, String username){
        MongoCollection collection=database.getCollection(name,user.class);
        Bson queryFilter = new Document("userName",username);
        Bson projection = new Document("userName",1).append("password",1);
        user result = null;
        try {
             result = (user) collection
                    .find(queryFilter)
                    .projection(projection)
                    .limit(1)
                    .iterator()
                    .tryNext();
        }catch (NoSuchElementException e){
            return null;
        }
        return result;
    }

}
