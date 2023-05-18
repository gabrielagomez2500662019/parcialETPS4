package sv.edu.utec.gomezmartinez.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class Vehiculo extends HelperBD{

    Context contex;

    public Vehiculo(Context context) {
        super(context);
        this.contex = context;
    }

    public long insertVehiculos(String marca,String modelo){

        long codigo=0;
        try {

            HelperBD baseHelp = new HelperBD(contex);
            SQLiteDatabase bd = baseHelp.getWritableDatabase();

            ContentValues valoresProv = new ContentValues();
            valoresProv.put("sMarca", marca);
            valoresProv.put("sModelo", modelo);

            codigo= bd.insert(NOMBRE_TABLAVEH, null, valoresProv);
            return codigo;
        }
        catch (Exception ex){
            ex.toString();
            return codigo=0;
        }

    }
}
