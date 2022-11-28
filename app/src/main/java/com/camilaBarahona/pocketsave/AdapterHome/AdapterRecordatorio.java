package com.camilaBarahona.pocketsave.AdapterHome;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.camilaBarahona.pocketsave.R;
import com.camilaBarahona.pocketsave.db.Recordatorio;

import java.util.ArrayList;

public class AdapterRecordatorio extends RecyclerView.Adapter<AdapterRecordatorio.ViewHolder>  {
    LayoutInflater inflater;
    Context context;
    ArrayList<com.camilaBarahona.pocketsave.db.Recordatorio> listaRecordatorios;


    //Listener
    private View.OnClickListener listener;

    public AdapterRecordatorio(Context context, ArrayList<Recordatorio> listaRecordatorios) {
        this.context = context;
        this.listaRecordatorios = listaRecordatorios;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.card_recordatorios, parent, false);
        return new ViewHolder(view);
    }
   public void setOnClicListener(View.OnClickListener listener) {
        this.listener = listener;
   }
   @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.titulo.setText(listaRecordatorios.get(position).getTitulo());
        holder.cuerpo.setText(listaRecordatorios.get(position).getCuerpo());
        holder.fecha.setText(listaRecordatorios.get(position).getFecha());
        holder.hora.setText(listaRecordatorios.get(position).getHora());
   }

   @Override
   public int getItemCount(){
        return listaRecordatorios.size();
   }


   public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView titulo, cuerpo, fecha, hora;
        Button btn_editar, btn_eliminar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.tvTituloRecordatorio);
            cuerpo = itemView.findViewById(R.id.tvCuerpo);
            fecha = itemView.findViewById(R.id.tvFecha);
            hora = itemView.findViewById(R.id.tvHora);

        }
   }
}
