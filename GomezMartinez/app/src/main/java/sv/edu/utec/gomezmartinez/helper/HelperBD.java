package sv.edu.utec.gomezmartinez.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class HelperBD extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String NOMBRE_BASE="PARCIAL4.db";
    public static final String NOMBRE_TABLACLI="MD_Clientes";
    public static final String NOMBRE_TABLAVEH="MD_Vehiculos";
    public static final String NOMBRE_TABLADETALLE="MD_Vehiculos_Clientes";


    public HelperBD(Context context) {
        super(context, NOMBRE_BASE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        crearTablaClientes(db);
        crearTablaVehiculo(db);
        crearTablaVehiculo_Cliente(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+NOMBRE_TABLACLI);
        onCreate(db);
    }

    public SQLiteDatabase getWritableDatabaseWithJournal() {
        SQLiteDatabase db = getWritableDatabase();
        disableWriteAheadLogging(db); // Deshabilitar el modo WAL para la instancia de la base de datos
        return db;
    }

    private void disableWriteAheadLogging(SQLiteDatabase db) {
        db.disableWriteAheadLogging(); // Deshabilitar el modo WAL para la instancia de la base de datos
    }

    //creacion de tablas de base de datos
    private void crearTablaClientes(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + NOMBRE_TABLACLI);
        db.execSQL("CREATE TABLE "+NOMBRE_TABLACLI+" ("+
                "ID_Cliente INTEGER PRIMARY KEY AUTOINCREMENT ,"+
                "sNombreCliente TEXT NOT NULL ,"+
                "sApellidoCliente TEXT NOT NULL ,"+
                "sDireccionCliente TEXT NOT NULL,"+
                "sCuidadCliente TEXT NOT NULL"
                +")");
    }

    private void crearTablaVehiculo(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + NOMBRE_TABLAVEH);
        db.execSQL("CREATE TABLE "+NOMBRE_TABLAVEH+" ("+
                "ID_Vehiculo INTEGER PRIMARY KEY AUTOINCREMENT ,"+
                "sMarca TEXT NOT NULL ,"+
                "sModelo TEXT NOT NULL "
                +")");
    }

    private void crearTablaVehiculo_Cliente(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + NOMBRE_TABLADETALLE);
        db.execSQL("CREATE TABLE "+NOMBRE_TABLADETALLE+" ("+
                "ID_Cliente INTEGER  ,"+
                "ID_Vehiculo INTEGER  ,"+
                "sMatricula TEXT NOT NULL ,"+
                "iKilometros REAL NOT NULL,"+
                "FOREIGN KEY (ID_Cliente) REFERENCES "+NOMBRE_TABLACLI+" (ID_Cliente)," +
                "FOREIGN KEY (ID_Vehiculo) REFERENCES "+NOMBRE_TABLAVEH+" (ID_Vehiculo)"+
                ")");
    }

}
