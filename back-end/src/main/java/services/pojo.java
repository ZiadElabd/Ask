package services;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import models.user;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.ArrayList;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;


public class pojo {
    String mongoUri = "mongodb+srv://askadmin:askadmin@cluster0.unqsy.mongodb.net/ziad?retryWrites=true&w=majority";
    String databaseName = "ziad";
    public boolean writeTOdb( String name,Class type,Object obj) {
        MongoDatabase users= MongoClients.create(mongoUri).getDatabase(databaseName);
        CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
        CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));
        MongoDatabase database = users.withCodecRegistry(pojoCodecRegistry);
        MongoCollection<Object> collection = database.getCollection(name, type);
        collection.insertOne(obj);
        ArrayList<Object> test=new ArrayList<>();
        collection.find().into(test);
        for (int i = 0; i < test.size(); i++) {
            System.out.println(test.get(i).toString());
        }
        return true;
    }
}


