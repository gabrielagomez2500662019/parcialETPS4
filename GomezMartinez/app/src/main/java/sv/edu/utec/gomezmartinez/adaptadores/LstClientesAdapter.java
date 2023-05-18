package sv.edu.utec.gomezmartinez.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import sv.edu.utec.gomezmartinez.R;
import sv.edu.utec.gomezmartinez.entidades.EntClientes;

public class LstClientesAdapter extends RecyclerView.Adapter<LstClientesAdapter.ClientesViewHolder> {

   ArrayList<EntClientes> listaCliente;


   public LstClientesAdapter(ArrayList<EntClientes>listaCliente) {

       this.listaCliente=listaCliente;
   }

   public LstClientesAdapter() {
   }

   @NonNull
   @Override
   public LstClientesAdapter.ClientesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_clientes, parent, false);
       return new ClientesViewHolder(view);
   }

    @Override
    public void onBindViewHolder(@NonNull LstClientesAdapter.ClientesViewHolder holder, int position) {
        holder.viewNombre.setText(listaCliente.get(position).getsNombreCliente());
        holder.viewApellido.setText(listaCliente.get(position).getsApellidoCliente());
        holder.viewDireccion.setText(listaCliente.get(position).getsDireccionCliente());
        holder.viewCuidad.setText(listaCliente.get(position).getsCuidadCliente());
    }

   @Override
   public int getItemCount() {
       return listaCliente.size();
   }

   public class ClientesViewHolder extends RecyclerView.ViewHolder {
       TextView viewNombre,viewApellido,viewDireccion,viewCuidad;
       public ClientesViewHolder(@NonNull View itemView) {
           super(itemView);
           viewNombre=itemView.findViewById(R.id.tvNomProve);
           viewApellido=itemView.findViewById(R.id.tvTelProve);
           viewDireccion=itemView.findViewById(R.id.tvCorreo);
           viewCuidad=itemView.findViewById(R.id.tvCorreo);
       }
   }
}
