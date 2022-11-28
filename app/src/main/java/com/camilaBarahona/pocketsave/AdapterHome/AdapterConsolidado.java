package com.camilaBarahona.pocketsave.AdapterHome;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.camilaBarahona.pocketsave.R;
import com.camilaBarahona.pocketsave.db.Gasto;

import java.util.ArrayList;

public class AdapterConsolidado extends RecyclerView.Adapter<AdapterConsolidado.ViewHolder> {
    LayoutInflater inflater;
    Context context;
    ArrayList<Gasto> listaGastos;

    //Listener
    private View.OnClickListener listener;

    public AdapterConsolidado(Context context, ArrayList<Gasto> listaGastos) {
        this.context = context;
        this.listaGastos = listaGastos;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.card_gastos, parent, false);
        return new ViewHolder(v);
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.movimiento.setText(listaGastos.get(position).getTipo_movimiento());
        holder.categoria.setText(listaGastos.get(position).getCategoria_movimiento());
        holder.valor.setText(listaGastos.get(position).getMonto());
        holder.fecha.setText(listaGastos.get(position).getFecha());

        }

    @Override
    public int getItemCount() {
        return listaGastos.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView movimiento, fecha, categoria, valor;
        ImageView image;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            movimiento = itemView.findViewById(R.id.tvMovimiento);
            fecha = itemView.findViewById(R.id.tvFecha);
            categoria = itemView.findViewById(R.id.tvCategoria);
            valor = itemView.findViewById(R.id.tvValor);
        }
    }
}
