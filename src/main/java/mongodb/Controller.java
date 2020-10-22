package mongodb;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class Controller {
	public static void main(String... args) {
		POJO user = new POJO("Cataract", "AHG76AG", 'M', "Electrical");
		
		Document doc = new Document("name", user.getName()).append("rollNo", user.getRollNo()).append("gender", user.getGender())
				.append("branch", user.getBranch());
		
		MongoClient mClient = new MongoClient();
		
		MongoDatabase database = mClient.getDatabase("studentDB");
		
		MongoCollection<Document> collection = database.getCollection("studentCollection");
		
		collection.insertOne(doc);
		
		MongoCursor cursor = collection.find().iterator();
		while(cursor.hasNext()) {
			System.out.println(cursor.next());
		}
		
		
		mClient.close();
	}

}
