package sv.edu.utec.gomezmartinez.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import sv.edu.utec.gomezmartinez.entidades.EntClientes;

public class Clientes extends HelperBD{

    Context contex;

    public Clientes(Context context) {
        super(context);
        this.contex = context;
    }

    public long insertClientes(String nombre,String apellido, String direccion,String cuidad){

        long codigo=0;
        try {

            HelperBD baseHelp = new HelperBD(contex);
            SQLiteDatabase bd = baseHelp.getWritableDatabase();

            ContentValues valoresProv = new ContentValues();
            valoresProv.put("sNombreCliente", nombre);
            valoresProv.put("sApellidoCliente", apellido);
            valoresProv.put("sDireccionCliente", direccion);
            valoresProv.put("sCuidadCliente", cuidad);

            codigo= bd.insert(NOMBRE_TABLACLI, null, valoresProv);
            return codigo;
        }
        catch (Exception ex){
            ex.toString();
            return codigo=0;
        }

    }


    public ArrayList<EntClientes> mostrarClientes() {
        HelperBD baseHelp = new HelperBD(contex);
        SQLiteDatabase bd = baseHelp.getReadableDatabase();
        ArrayList<EntClientes> listaClientes = new ArrayList<>();
        EntClientes entClientes;
        Cursor cursorClientes;

        cursorClientes = bd.rawQuery("SELECT sNombreCliente, sApellidoCliente, sDireccionCliente, sCuidadCliente FROM " + NOMBRE_TABLACLI, null);
        while (cursorClientes.moveToNext()) {
            entClientes = new EntClientes();
            entClientes.setsNombreCliente(cursorClientes.getString(0));
            entClientes.setsApellidoCliente(cursorClientes.getString(1));
            entClientes.setsDireccionCliente(cursorClientes.getString(2));
            entClientes.setsCuidadCliente(cursorClientes.getString(3));
            listaClientes.add(entClientes);
        }
        cursorClientes.close();
        return listaClientes;
    }
}
