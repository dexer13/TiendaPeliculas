/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Copia;
import model.Pelicula;
import org.bson.BsonDocument;
import org.bson.conversions.Bson;

/**
 *
 * @author Lenovo
 */
public class Conexion {

    static final String url = "localhost";
    static final int puerto = 27017;
    static final String database = "tienda";

    public void GuardarPelicula(Pelicula p) {

        DB db;
        Mongo mongo = new Mongo("localhost", 27017);
        db = mongo.getDB(database);
        DBCollection collection = db.getCollection("peliculas");
        BasicDBObject pelicula = new BasicDBObject();
        pelicula.put("titulo", p.getTitulo());
        pelicula.put("anio", p.getAnio());
        pelicula.put("critica", p.getCritica());
        pelicula.put("caratula", p.getCaratula());
        List<BasicDBObject> lcopias = new ArrayList<>();
        if (p.getCopias() != null) {
            for (Copia c : p.getCopias()) {
                BasicDBObject copia = new BasicDBObject();
                copia.put("deteriorada", c.isDeteriorada());
                copia.put("formato", c.getFormato());
                copia.put("precio_alquiler", c.getPrecioAlquiler());

            }
        }
        pelicula.put("copias", lcopias);
        collection.insert(pelicula);

    }

    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
        try {
            DB db;
            Mongo mongo = new Mongo("localhost", 27017);
            db = mongo.getDB("mongo_excercise");
            DBCollection coleccion = db.getCollection("movie");
            DBCursor cursor = coleccion.find();
            while (cursor.hasNext()) {
                DBObject obj = cursor.next();
                System.out.println(obj.get("title"));
            }
        } catch (Exception ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
