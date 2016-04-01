package com.example.boris.prueba;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "DBmarker";
    private final static int DB_SCHEMA_VERSION = 1;

    String TABLA_MARKER = "CREATE TABLE tablaMarker(_id INTEGER PRIMARY KEY AUTOINCREMENT, latitud_marker DECIMAL, longitud_marker DECIMAL, nombre_marker TEXT, descripcion_marker TEXT, " +
            "categoria_marker TEXT, subcategoria_marker TEXT, direccion_marker TEXT, imagen_marker BLOB)";

    public  DataBaseHelper(Context context)
    {
        super(context, DB_NAME, null, DB_SCHEMA_VERSION);
    }
    /** Called when the activity is first created. */
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(TABLA_MARKER);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        android.util.Log.v("Constante", "Actualiza la base de datos y destruye la base de datos antigua con el mismo nombre");
        db.execSQL("DROP table if exists tablaMarker");
        onCreate(db);
    }

/*
    //spinner recetas
    public List<String> getAllRecetas(){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT  * FROM tablaRecetas", null);
        List<String> lectures = new ArrayList<String>();

        if (c.moveToFirst()) {
            do {
                lectures.add(c.getString(1));

            } while (c.moveToNext());
        }

        c.close();
        db.close();

        return lectures;
    }

    public List<String> getAllMedicamentos(){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT  * FROM tablaMedicamentos", null);
        List<String> lectures = new ArrayList<String>();

        if (c.moveToFirst()) {
            do {
                lectures.add(c.getString(1));

            } while (c.moveToNext());
        }

        return lectures;
    }


    //Retrive  data from database
   public List<Recetas> getDataFromDBReceta(){

        List<Recetas> modelList = new ArrayList<Recetas>();
        String query = "select * from tablaRecetas order by fecha_receta";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query,null);

        if (cursor.moveToFirst()){
            do {
                Recetas model = new Recetas();
                model.setNombre_receta(cursor.getString(1));
                model.setNombre_medico(cursor.getString(2));
                model.setApellido_medico(cursor.getString(3));
                model.setFecha_receta(cursor.getString(4));
                model.setImagen_receta(cursor.getBlob(5));

                modelList.add(model);
            }while (cursor.moveToNext());
        }

        Log.d("datos recetas", modelList.toString());


        return modelList;
    }*/

    /* Retrive  data from database
    public List<Cortes> getDataFromDBCortes(){

        List<Cortes> modelList = new ArrayList<Cortes>();
        String query = "select * from tablaCortes";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query,null);

        if (cursor.moveToFirst()){
            do {
                Cortes model = new Cortes();
                model.setNombre_corte(cursor.getString(1));

                modelList.add(model);
            }while (cursor.moveToNext());
        }

        Log.d("datos cortes", modelList.toString());


        return modelList;
    }*/
}