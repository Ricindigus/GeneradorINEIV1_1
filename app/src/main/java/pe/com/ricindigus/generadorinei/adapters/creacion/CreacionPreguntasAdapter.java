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
    OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public CreacionPreguntasAdapter(ArrayList<Pregunta> preguntas, Context context, OnItemClickListener onItemClickListener) {
        this.preguntas = preguntas;
        this.context = context;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pregunta,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.txtNumero.setText(preguntas.get(position).getNumero());
        holder.txtModulo.setText(preguntas.get(position).getModulo());
        holder.txtIdPregunta.setText(preguntas.get(position).getIdPregunta());
        holder.txtTipo.setText(NombreComponente.values()[Integer.parseInt(preguntas.get(position).getTipoComponente())].name());
        holder.txtDescripcion.setText(preguntas.get(position).getDescripcion());
        holder.cardViewPregunta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(view,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return preguntas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardViewPregunta;
        TextView txtNumero;
        TextView txtModulo;
        TextView txtIdPregunta;
        TextView txtTipo;
        TextView txtDescripcion;

        public ViewHolder(View itemView) {
            super(itemView);
            cardViewPregunta = (CardView) itemView.findViewById(R.id.cardview_pregunta);
            txtNumero = (TextView) itemView.findViewById(R.id.item_pregunta_numero);
            txtModulo = (TextView) itemView.findViewById(R.id.item_pregunta_modulo);
            txtIdPregunta = (TextView) itemView.findViewById(R.id.item_pregunta_idpregunta);
            txtTipo = (TextView) itemView.findViewById(R.id.item_pregunta_tipo);
            txtDescripcion = (TextView) itemView.findViewById(R.id.item_pregunta_descripcion);
        }
    }
}
