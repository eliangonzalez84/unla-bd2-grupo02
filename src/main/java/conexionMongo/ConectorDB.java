package conexionMongo;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class ConectorDB {
	public static DB getDatabase(String dbName) throws UnknownHostException{

    	MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
	    DB database = mongoClient.getDB(dbName);
	    return database;
	}
}
