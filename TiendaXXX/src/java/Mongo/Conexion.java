/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mongo;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Lenovo
 */
public class Conexion {
    public static void main(String[] args) {
        try {
            DB db;
            Mongo mongo=new Mongo("localhost", 27017);
            db=mongo.getDB("mongo_excercise");
            DBCollection coleccion=db.getCollection("movie");
            DBCursor cursor= coleccion.find();
            while(cursor.hasNext()){
                DBObject obj=cursor.next();
                System.out.println(obj.get("title"));
            }
        } catch (UnknownHostException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
