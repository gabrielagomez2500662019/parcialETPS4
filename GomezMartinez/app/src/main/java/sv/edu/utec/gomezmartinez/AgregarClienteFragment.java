package sv.edu.utec.gomezmartinez;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import sv.edu.utec.gomezmartinez.helper.Clientes;


public class AgregarClienteFragment extends Fragment {

    EditText txtNom,txtApe,txtDire,txtCuidad;
    TextView tvMensajes;
    Button btnGuardar;
    Context context;
    public AgregarClienteFragment() {
        // Required empty public constructor

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatActivity appCompatActivity =new AppCompatActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_agregar_cliente, container, false);
        txtNom = view.findViewById(R.id.edtNOMCLIENTE);
        txtApe = view.findViewById(R.id.edtAPECLIENTE);
        txtDire = view.findViewById(R.id.edtDIRECLIENTE);
        txtCuidad = view.findViewById(R.id.edtCUICLIENTE);
        btnGuardar = view.findViewById(R.id.btnGuardar);
        tvMensajes = view.findViewById(R.id.tvMensaje);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Clientes baseProv = new Clientes(getContext());

                long codiSave = baseProv.insertClientes(
                        txtNom.getText().toString(),
                        txtApe.getText().toString(),
                        txtDire.getText().toString(),
                        txtCuidad.getText().toString());

                if (codiSave > 0) {
                    tvMensajes.append("Cliente Registrado Correctamente");
                } else {
                    tvMensajes.append("Error en insertar");
                }
            }
        });

        return view;
    }
}