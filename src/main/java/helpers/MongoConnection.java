package helpers;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.ListDatabasesIterable;
import org.bson.Document;

import java.util.List;

/**
 * Created by TutorialKart on 31/10/17.
 */
public class MongoConnection {
    public static void main(String[] args) {
        MongoClient mongoClient = null;
        try {
            mongoClient = new MongoClient( "127.0.0.1" , 27017 );

            System.out.println("Connected to MongoDB!");
        } catch (MongoException e) {
            e.printStackTrace();
        } finally {
            if(mongoClient!=null)
                mongoClient.close();
        }
    }
}