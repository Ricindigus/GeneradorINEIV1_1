package pe.com.ricindigus.generadorinei.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.R;
import pe.com.ricindigus.generadorinei.pojos.ExportarItem;

/**
 * Created by RICARDO on 7/09/2017.
 */

public class ExportarAdapter extends RecyclerView.Adapter<ExportarAdapter.ViewHolder> {
    ArrayList<ExportarItem> exportarItems;
    Context context;
    OnCheckedChangeListener onCheckedChangeListener;

    public interface OnCheckedChangeListener{
        public void onCheckedChanged(CompoundButton compoundButton, boolean b, int pos);
    }

    public ExportarAdapter(ArrayList<ExportarItem> exportarItems, Context context, OnCheckedChangeListener onCheckedChangeListener) {
        this.exportarItems = exportarItems;
        this.context = context;
        this.onCheckedChangeListener = onCheckedChangeListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_exportar,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.ckSeleccionado.setOnCheckedChangeListener(null);
        if(exportarItems.get(position).getSeleccionado() == 0) holder.ckSeleccionado.setChecked(false);
        if(exportarItems.get(position).getSeleccionado() == 1) holder.ckSeleccionado.setChecked(true);
        holder.ckSeleccionado.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                onCheckedChangeListener.onCheckedChanged(compoundButton,b,position);
            }
        });

        holder.txtIdEmpresa.setText(exportarItems.get(position).getIdEmpresa().toString());
        holder.txtRuc.setText(exportarItems.get(position).getRuc().toString());
        holder.txtRazonSocial.setText(exportarItems.get(position).getRazonSocial().toString());
    }

    @Override
    public int getItemCount() {
        return exportarItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardViewItem;
        CheckBox ckSeleccionado;
        TextView txtIdEmpresa;
        TextView txtRuc;
        TextView txtRazonSocial;

        public ViewHolder(View itemView) {
            super(itemView);
            cardViewItem = (CardView) itemView.findViewById(R.id.exportacion_cardview);
            ckSeleccionado = (CheckBox) itemView.findViewById(R.id.exportacion_ckSeleccionar);
            txtIdEmpresa = (TextView) itemView.findViewById(R.id.exportacion_txtId);
            txtRuc =(TextView) itemView.findViewById(R.id.exportacion_txtRuc);
            txtRazonSocial = (TextView)itemView.findViewById(R.id.exportacion_txtRazonSocial);
        }
    }
}
