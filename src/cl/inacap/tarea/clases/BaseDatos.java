package cl.inacap.tarea.clases;



import android.content.Context;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class BaseDatos extends SQLiteOpenHelper {

	public BaseDatos(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void onCreate(SQLiteDatabase _db) 
	{
			_db.execSQL(AdaptadorBase.DATABASE_CREATE);
			_db.execSQL(AdaptadorBase.INSERT_DB);
			
	}
	@Override
	public void onUpgrade(SQLiteDatabase _db, int _oldVersion, int _newVersion) 
	{
			// Log the version upgrade.
			Log.w("TaskDBAdapter", "Upgrading from version " +_oldVersion + " to " +_newVersion + ", which will destroy all old data");
	
	
			// Upgrade the existing database to conform to the new version. Multiple
			// previous versions can be handled by comparing _oldVersion and _newVersion
			// values.
			// The simplest case is to drop the old table and create a new one.
			//_db.execSQL("DROP TABLE IF EXISTS " + "TEMPLATE");
			_db.execSQL("DROP TABLE IF EXISTS " + "LOGIN");
			// Create a new one.
			_db.execSQL("create table (CLIENTE ID_CLIENTE integer primary key autoincrement,Nombre text,APELLIDO text,EMPRESA text);"+
	        "create table PRODUCTO (ID_PRODUCTO integer primary key autoincrement,Nombre text,MARCA text);"+
	        "create table PEDIDO (ID_PEDIDO integer primary key autoincrement, CLIENTE integer,producto integer, fecha text, precio integer);");
			_db.execSQL("INSERT INTO LOGIN(ID, USERNAME, PASSWORD) VALUES(1,'herman','1234');" +
					 "INSERT INTO CLIENTE(ID_CLIENTE,NOMBRE,APELLIDO,EMPRESA) VALUES(1,'vende1','1234');"+
					 "INSERT INTO CLIENTE(ID_CLIENTE,NOMBRE,APELLIDO,EMPRESA) VALUES(2,'vende2','1234');"+
					 "INSERT INTO CLIENTE(ID_CLIENTE,NOMBRE,APELLIDO,EMPRESA) VALUES(3,'vende3','1234');"+
					 "INSERT INTO CLIENTE(ID_CLIENTE,NOMBRE,APELLIDO,EMPRESA) VALUES(4,'vende4','1234');"+
					 "INSERT INTO PRODUCTO(ID_PRODUCTO, NOMBRE, MARCA) VALUES(1,'arroz','Chino');"+
					 "INSERT INTO PRODUCTO(ID_PRODUCTO, NOMBRE, MARCA) VALUES(2,'azuca','IANSA');"+
					 "INSERT INTO PRODUCTO(ID_PRODUCTO, NOMBRE, MARCA) VALUES(3,'Te','SUPREMO');"+
					 "INSERT INTO PRODUCTO(ID_PRODUCTO, NOMBRE, MARCA) VALUES(4,'Sal','Lobos');"+
					 "INSERT INTO PRODUCTO(ID_PRODUCTO, NOMBRE, MARCA) VALUES(5,'Harina','La selecta');");
			//onCreate(_db);
	}

}
