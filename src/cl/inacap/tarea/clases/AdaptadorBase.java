package cl.inacap.tarea.clases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class AdaptadorBase {
	
	static final String DATABASE_NAME = "productos_frescos.db";
	static final int DATABASE_VERSION = 1;
	public static final int NAME_COLUMN = 1;
	// TODO: Creando los campos de la tabla.
	// SQL para crear la nueva base.
	static final String DATABASE_CREATE = "create table "+"LOGIN"+
	                             "( " +"ID"+" integer primary key autoincrement,"+ "USERNAME  text,PASSWORD text);"+
	        "create table "+"CLIENTE"+"(ID_CLIENTE"+" integer primary key autoincrement,"+ "Nombre text,APELLIDO text,EMPRESA text);"+
	        "create table "+"PRODUCTO"+"(ID_PRODUCTO"+" integer primary key autoincrement,"+ "Nombre text,MARCA text);"+
	        "create table "+"PEDIDO"+"(ID_PEDIDO"+" integer primary key autoincrement,"+ "cliente integer,producto integer, fecha text, precio integer);";
	static final String INSERT_DB = "INSERT INTO LOGIN(ID, USERNAME, PASSWORD) VALUES(1,'herman','1234');" +
	 "INSERT INTO CLIENTE(ID_CLIENTE,NOMBRE,APELLIDO,EMPRESA) VALUES(1,'vende1','1234');"+
	 "INSERT INTO CLIENTE(ID_CLIENTE,NOMBRE,APELLIDO,EMPRESA) VALUES(2,'vende2','1234');"+
	 "INSERT INTO CLIENTE(ID_CLIENTE,NOMBRE,APELLIDO,EMPRESA) VALUES(3,'vende3','1234');"+
	 "INSERT INTO CLIENTE(ID_CLIENTE,NOMBRE,APELLIDO,EMPRESA) VALUES(4,'vende4','1234');"+
	 "INSERT INTO PRODUCTO(ID_PRODUCTO, NOMBRE, MARCA) VALUES(1,'arroz','Chino');"+
	 "INSERT INTO PRODUCTO(ID_PRODUCTO, NOMBRE, MARCA) VALUES(2,'azuca','IANSA');"+
	 "INSERT INTO PRODUCTO(ID_PRODUCTO, NOMBRE, MARCA) VALUES(3,'Te','SUPREMO');"+
	 "INSERT INTO PRODUCTO(ID_PRODUCTO, NOMBRE, MARCA) VALUES(4,'Sal','Lobos');"+
	 "INSERT INTO PRODUCTO(ID_PRODUCTO, NOMBRE, MARCA) VALUES(5,'Harina','La selecta');";
	
	// Objeto db de tipo SQLLite
	public  SQLiteDatabase db;
	// Context de la app usado en la base de datos
	private final Context context;
	// Un objeto dbhelper de tipo base de datos y por el constructor se abre y actualiza
	private BaseDatos dbHelper;
	public AdaptadorBase(Context context) {
		super();
		this.context = context;
		dbHelper = new BaseDatos(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	public  AdaptadorBase open() throws SQLException 
	{
		db = dbHelper.getWritableDatabase();
		return this;
	}
	public void close() 
	{
		db.close();
	}
	public  SQLiteDatabase getDatabaseInstance()
	{
		return db;
	}
	
	public String validaUsuario(String userName)
	{
		Cursor cursor=db.query("LOGIN", null, "USERNAME=?", new String[]{userName}, null, null, null);
        if(cursor.getCount()<1) // UserName no existe
        {
        	cursor.close();
        	return "NO EXISTE";
        }
	    cursor.moveToFirst();
		String password= cursor.getString(cursor.getColumnIndex("PASSWORD"));
		cursor.close();
		return password;				
	}
	
	
	
	

}
