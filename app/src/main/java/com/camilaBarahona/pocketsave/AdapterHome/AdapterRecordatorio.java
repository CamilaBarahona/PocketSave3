package com.camilaBarahona.pocketsave.AdapterHome;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.camilaBarahona.pocketsave.Entidades.Recordatorio;
import com.camilaBarahona.pocketsave.R;

import java.util.ArrayList;

public class AdapterRecordatorio extends RecyclerView.Adapter<AdapterRecordatorio.ViewHolder> implements View.OnClickListener {
    LayoutInflater inflater;
    Context context;
    ArrayList<Recordatorio> recordatorioArrayList;

    //Listener
    private View.OnClickListener listener;

    public AdapterRecordatorio(Context context, ArrayList<Recordatorio> data) {
        this.context = context;
        this.recordatorioArrayList = data;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.card_recordatorios, parent, false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }
   public void setOnClicListener(View.OnClickListener listener) {
        this.listener = listener;
   }
   @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Recordatorio recordatorio = recordatorioArrayList.get(position);
        holder.titulo.setText(recordatorio.getTitulo());
        holder.cuerpo.setText(recordatorio.getCuerpo());
        holder.fecha.setText(recordatorio.getFecha());
        holder.hora.setText(recordatorio.getHora());
   }

   @Override
   public int getItemCount(){
        return recordatorioArrayList.size();
   }

   @Override
   public void onClick(View view) {
        if (listener != null){
            listener.onClick(view);
        }
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

            btn_editar = itemView.findViewById(R.id.btn_editarRecordatorio);
            btn_eliminar = itemView.findViewById(R.id.btn_eliminarRecordatorio);
        }
   }
}