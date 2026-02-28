package mongoApi.vercel_5;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class ConnectionManager {
	
	private  static String uri = "mongodb+srv://bilal:1234@cluster0.ye8yv1r.mongodb.net/?appName=Cluster0";
	private static String nomDB = "practica3";

    public static MongoDatabase getConnection() {
        MongoClient client = MongoClients.create(uri);
        return client.getDatabase(nomDB);
    }

}
