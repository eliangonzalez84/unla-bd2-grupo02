package conexionMongo;

import java.net.UnknownHostException;
import java.time.LocalDate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.WriteResult;

import db2.grupo02.model.LocalDateAdapter;
import db2.grupo02.model.Venta;

public class VentaDao {
	private static DBCollection collection;
	private static Gson gson;
	private static DB db;
	
	public static void getInstance() throws UnknownHostException {
		db = ConectorDB.getDatabase("farmacia");
		collection = db.getCollection("ventas");
		gson = new GsonBuilder().setPrettyPrinting().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).create();
	}
	
	public static Venta traer(int id) {
		DBObject result = collection.findOne(new BasicDBObject("id", id));
		if (result == null) {
			return null;
		}
		return gson.fromJson(result.toString(), Venta.class);
	}
	
	public static void agregar(Venta venta) throws Exception {
		if (traer(venta.getId()) != null) {
			throw new Exception("ERROR: Ya existe una venta con este id");
		}
		String json = gson.toJson(venta);
		collection.insert(BasicDBObject.parse(json));
	}
}
