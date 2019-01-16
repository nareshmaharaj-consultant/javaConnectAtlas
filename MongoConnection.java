import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.model.CreateCollectionOptions;
import com.mongodb.client.model.ValidationOptions;
import org.bson.Document;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.result.*;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class MongoConnection { 
   
   public static void main( String args[] ) 
   {  

   	MongoClient mongoClient = MongoClients.create("mongodb://naresh:p*******@cluster0-shard-00-00-nyjzb.mongodb.net:27017,cluster0-shard-00-01-nyjzb.mongodb.net:27017,cluster0-shard-00-02-nyjzb.mongodb.net:27017/?replicaSet=Cluster0-shard-0&authSource=admin&ssl=true");

 	MongoDatabase database = mongoClient.getDatabase("my-sample-dvla");
	MongoCollection<Document> collection = database.getCollection("sample-drivers");

	Document document = new Document("name", "Mongo Milestones")
               .append("contact", new Document("phone", "228-555-0149")
                                       	.append("email", "cafeconleche@example.com")
                                       	.append("location",Arrays.asList(-73.92502, 40.8279556)))
               				.append("Points", 3)
               				.append("categories", Arrays.asList("Motorcar", "Bikes", "Majorily Fat Pies"));

	collection.insertOne(document);
   } 
}
