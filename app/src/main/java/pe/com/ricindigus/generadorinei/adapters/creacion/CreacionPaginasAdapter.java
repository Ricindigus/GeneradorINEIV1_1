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
import pe.com.ricindigus.generadorinei.pojos.Pagina;

/**
 * Created by otin016 on 28/06/2017.
 */

public class CreacionPaginasAdapter extends RecyclerView.Adapter<CreacionPaginasAdapter.ViewHolder>{
    ArrayList<Pagina> paginas;
    Context context;
    OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public CreacionPaginasAdapter(ArrayList<Pagina> paginas, Context context, OnItemClickListener onItemClickListener) {
        this.paginas = paginas;
        this.context = context;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View  view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pagina,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.txtNPagina.setText(paginas.get(position).getID());
        holder.txtModulo.setText("MODULO " + paginas.get(position).getMODULO());
        holder.txtTipo1.setText(paginas.get(position).getTIPO1());
        holder.txtTipo2.setText(paginas.get(position).getTIPO2());
        holder.txtTipo3.setText(paginas.get(position).getTIPO3());
        holder.txtTipo4.setText(paginas.get(position).getTIPO4());
        holder.txtTipo5.setText(paginas.get(position).getTIPO5());
        holder.txtTipo6.setText(paginas.get(position).getTIPO6());
        holder.txtTipo7.setText(paginas.get(position).getTIPO7());
        holder.txtTipo8.setText(paginas.get(position).getTIPO8());
        holder.txtTipo9.setText(paginas.get(position).getTIPO9());
        holder.txtTipo10.setText(paginas.get(position).getTIPO10());
        holder.cardViewPagina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(view,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return paginas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardViewPagina;
        TextView txtNPagina;
        TextView txtModulo;
        TextView txtTipo1;
        TextView txtTipo2;
        TextView txtTipo3;
        TextView txtTipo4;
        TextView txtTipo5;
        TextView txtTipo6;
        TextView txtTipo7;
        TextView txtTipo8;
        TextView txtTipo9;
        TextView txtTipo10;
        public ViewHolder(View itemView) {
            super(itemView);
            cardViewPagina = (CardView) itemView.findViewById(R.id.cardview_paginas);
            txtNPagina = (TextView) itemView.findViewById(R.id.pagina_numero);
            txtModulo = (TextView) itemView.findViewById(R.id.pagina_modulo);
            txtTipo1 = (TextView) itemView.findViewById(R.id.pagina_tipo1);
            txtTipo2 = (TextView) itemView.findViewById(R.id.pagina_tipo2);
            txtTipo3 = (TextView) itemView.findViewById(R.id.pagina_tipo3);
            txtTipo4 = (TextView) itemView.findViewById(R.id.pagina_tipo4);
            txtTipo5 = (TextView) itemView.findViewById(R.id.pagina_tipo5);
            txtTipo6 = (TextView) itemView.findViewById(R.id.pagina_tipo6);
            txtTipo7 = (TextView) itemView.findViewById(R.id.pagina_tipo7);
            txtTipo8 = (TextView) itemView.findViewById(R.id.pagina_tipo8);
            txtTipo9 = (TextView) itemView.findViewById(R.id.pagina_tipo9);
            txtTipo10 = (TextView) itemView.findViewById(R.id.pagina_tipo10);
        }
    }
}
