package pe.com.ricindigus.generadorinei.adapters.creacion;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.R;
import pe.com.ricindigus.generadorinei.constantesglobales.NombreComponente;
import pe.com.ricindigus.generadorinei.pojos.Pregunta;

/**
 * Created by RICARDO on 3/04/2018.
 */

public class CreacionPreguntasAdapter extends RecyclerView.Adapter<CreacionPreguntasAdapter.ViewHolder>{
    ArrayList<Pregunta> preguntas;
    Context context;

    public CreacionPreguntasAdapter(ArrayList<Pregunta> preguntas, Context context) {
        this.preguntas = preguntas;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pregunta,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.txtId.setText(preguntas.get(position).get_id());
        holder.txtModulo.setText(preguntas.get(position).getMODULO());
        holder.txtPagina.setText(preguntas.get(position).getPAGINA());
        holder.txtNumero.setText(preguntas.get(position).getNUMERO());
        holder.txtTipo.setText(NombreComponente.values()[Integer.parseInt(preguntas.get(position).getTIPO())].name());
    }

    @Override
    public int getItemCount() {
        return preguntas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardViewPregunta;
        TextView txtId;
        TextView txtModulo;
        TextView txtPagina;
        TextView txtNumero;
        TextView txtTipo;

        public ViewHolder(View itemView) {
            super(itemView);
            cardViewPregunta = (CardView) itemView.findViewById(R.id.cardview_pregunta);
            txtId = (TextView) itemView.findViewById(R.id.item_pregunta_id);
            txtModulo = (TextView) itemView.findViewById(R.id.item_pregunta_modulo);
            txtPagina = (TextView) itemView.findViewById(R.id.item_pregunta_pagina);
            txtNumero = (TextView) itemView.findViewById(R.id.item_pregunta_numero);
            txtTipo = (TextView) itemView.findViewById(R.id.item_pregunta_tipo);
        }
    }
}
