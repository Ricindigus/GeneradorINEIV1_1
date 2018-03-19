package pe.com.ricindigus.generadorinei.adapters.creacion;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.R;
import pe.com.ricindigus.generadorinei.componentes.componente_visitas.pojos.Visita;
import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.SQLConstantesComponente;
import pe.com.ricindigus.generadorinei.pojos.Modulo;

/**
 * Created by otin016 on 28/06/2017.
 */

public class CreacionModulosAdapter extends RecyclerView.Adapter<CreacionModulosAdapter.ViewHolder>{
    ArrayList<Modulo> modulos;
    Context context;
    OnItemClickListener onItemClickListener;

    public CreacionModulosAdapter(ArrayList<Modulo> modulos, Context context, OnItemClickListener onItemClickListener) {
        this.modulos = modulos;
        this.context = context;
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        public void onItemClick(View view, int pos);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View  view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_modulo,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.txtNumero.setText(modulos.get(position).getID());
        holder.txtTitulo.setText(modulos.get(position).getTITULO());
        holder.txtCabecera.setText(modulos.get(position).getCABECERA());
        holder.txtNombreTabla.setText(modulos.get(position).getNTABLA());
        holder.cardViewVisita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(view,position);
            }
        });
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardViewVisita;
        TextView txtNumero;
        TextView txtTitulo;
        TextView txtCabecera;
        TextView txtNombreTabla;
        public ViewHolder(View itemView) {
            super(itemView);
            cardViewVisita = (CardView) itemView.findViewById(R.id.cardview_modulos);
            txtNumero = (TextView) itemView.findViewById(R.id.modulo_id);
            txtTitulo = (TextView) itemView.findViewById(R.id.modulo_titulo);
            txtCabecera = (TextView) itemView.findViewById(R.id.modulo_cabecera);
            txtNombreTabla = (TextView) itemView.findViewById(R.id.modulo_tabla);
        }
    }

    @Override
    public int getItemCount() {
        return modulos.size();
    }
}
