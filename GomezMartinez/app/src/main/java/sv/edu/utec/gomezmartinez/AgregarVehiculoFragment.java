package sv.edu.utec.gomezmartinez;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import sv.edu.utec.gomezmartinez.helper.Clientes;
import sv.edu.utec.gomezmartinez.helper.Vehiculo;


public class AgregarVehiculoFragment extends Fragment {

    EditText txtMarca,txtModelo;
    TextView tvMensajes;
    Button btnGuardar;
    Context context;

    public AgregarVehiculoFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_agregar_vehiculo, container, false);
        txtMarca = view.findViewById(R.id.edtMARCA);
        txtModelo = view.findViewById(R.id.edtMODELO);
        btnGuardar = view.findViewById(R.id.btnGuardar);
        tvMensajes = view.findViewById(R.id.tvMensaje);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vehiculo baseProv = new Vehiculo(getContext());

                long codiSave = baseProv.insertVehiculos(
                        txtMarca.getText().toString(),
                        txtModelo.getText().toString());

                if (codiSave > 0) {
                    tvMensajes.append("Vehiculo Registrado Correctamente");
                } else {
                    tvMensajes.append("Error en insertar");
                }
            }
        });

        return view;
    }
}