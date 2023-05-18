package sv.edu.utec.gomezmartinez;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import sv.edu.utec.gomezmartinez.adaptadores.LstClientesAdapter;
import sv.edu.utec.gomezmartinez.entidades.EntClientes;
import sv.edu.utec.gomezmartinez.helper.Clientes;

public class ListarClientesFragment extends Fragment {

    RecyclerView listaClientes;
    ArrayList<EntClientes> AlistClientes;
    Context context;

    public ListarClientesFragment(  ) {
        this.context = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listar_clientes, container, false);
        listaClientes = view.findViewById(R.id.rcvLstClientes);
        listaClientes.setLayoutManager(new LinearLayoutManager(getContext()));

        Clientes dbClientes = new Clientes(getContext());
        ArrayList<EntClientes> listaClientesData = dbClientes.mostrarClientes();
        LstClientesAdapter adapter = new LstClientesAdapter(listaClientesData);
        listaClientes.setAdapter(adapter);

        return view;
    }

}