package codex.afinal.smsapp;

import android.content.ContentValues;
import  android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Ali on 22-Nov-17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="persons.db";
    private static final String TABLE_NAME="person";
    private static final String COLUMN_ID="id";
    private static final String COLUMN_NAME="name";
    private static final String COLUMN_CONTACT="contact";
    SQLiteDatabase db;
    private static final String TABLE_CREATE="create table person("+
            "name text not null Primary Key , contact text not null);";

    public void onCreate(SQLiteDatabase db){
        db.execSQL(TABLE_CREATE);
    }

    public String getContact(String name){
        db=this.getReadableDatabase();
        String query="select name, contact from "+TABLE_NAME;
        Cursor cursor=db.rawQuery(query,null);
        String n,c;
        c="Person Not Found";

        if(cursor.moveToFirst()){

        do{
            n=cursor.getString(0);
            if(n.equals(name))
            {
                c=cursor.getString(1);
                break;
            }

          }while(cursor.moveToNext());

        }
        return c;

    }


    public ArrayList<person> getList(){
        db=this.getReadableDatabase();
        String query="select name, contact from "+TABLE_NAME;
        Cursor cursor=db.rawQuery(query,null);
        String n,c;
        ArrayList<person> list=new ArrayList<person>();
        person obj;
        if(cursor.moveToFirst()){

            do{
                n=cursor.getString(0);
                c=cursor.getString(1);
                obj=new person(n,c);
                list.add(obj);
            }while(cursor.moveToNext());

        }
        return list;

    }




    public boolean insertPerson(person p){

        if(getContact(p.getName()).equals("Person Not Found")){
            db=this.getWritableDatabase();
            ContentValues values=new ContentValues();
            values.put(COLUMN_NAME,p.getName());
            values.put(COLUMN_CONTACT,p.getContact());

            db.insert(TABLE_NAME,null,values);
            db.close();
            return true;
        }

        return false;

    }



    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

        String query= "DROP TABLE IF EXITS "+ TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }


}
