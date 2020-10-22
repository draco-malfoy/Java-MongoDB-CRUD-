package mongodb;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

public class CRUD {
	public static void main(String args[]) {

		// Mongo Client that acts as a path to Mongo's install directory
		MongoClient client = new MongoClient(new MongoClientURI("mongodb://127.0.0.1:27017"));

		// Provide Mongo's login credentials
		MongoCredential credential = MongoCredential.createCredential("drac0_malf0y", "newDB", "asd".toCharArray());

		System.out.println("Connection successfull.");

		// Get or Create(if it doesn't exist) database
		MongoDatabase database = client.getDatabase("newDB");

		// Creating a collection
		try {
			database.createCollection("newCollection");
		} catch (Exception e) {
			System.out.println("collection already exists");
		}

		// Getting/Selecting a collection
		MongoCollection<Document> collection = database.getCollection("newCollection");

		// Creating documents/rows
		Document document1 = new Document("title", "MongoDB").append("description", "Database").append("likes", "5000")
				.append("license", "opensource");
		Document document2 = new Document("title", "Oracle").append("description", "Database").append("likes", "10000")
				.append("license", "proprietary");

		List<Document> list = new ArrayList<Document>();
		list.add(document1);
		list.add(document2);

		// Inserting documents into collection
		collection.insertMany(list);
		
		// Drop the collection
		collection.drop();

		// Getting all documents by using an Iterator
		FindIterable<Document> docIterator = collection.find();

//		Iterator<Document> it = docIterator.iterator();
//		while (it.hasNext()) {
//			System.out.println(it.next());
//		}

		// update a document
		collection.updateOne(Filters.eq("title", 1), Updates.set("likes", 150));

		// delete a document
		collection.deleteOne(Filters.eq("title", "Second"));

		// drop the document
		collection.drop();

		// list all collections of database
		for (String name : database.listCollectionNames()) {
			System.out.println(name);
		}
	}
}