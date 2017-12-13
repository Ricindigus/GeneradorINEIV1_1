package pe.com.ricindigus.generadorinei.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.R;
import pe.com.ricindigus.generadorinei.pojos.ItemMarco;


/**
 * Created by user on 9/08/2017.
 */

public class MarcoAdapter extends RecyclerView.Adapter<MarcoAdapter.ViewHolder>{
    ArrayList<ItemMarco> marcos;
    OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public MarcoAdapter(ArrayList<ItemMarco> marcos, OnItemClickListener onItemClickListener) {
        this.marcos = marcos;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.marco_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.txtId.setText(marcos.get(position).getId());
        holder.txtRuc.setText(marcos.get(position).getRuc());
        holder.txtRazonSocial.setText(marcos.get(position).getRazonSocial());
        holder.txtTamanio.setText(marcos.get(position).getTamanio());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(view,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return marcos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView txtId;
        TextView txtRuc;
        TextView txtRazonSocial;
        TextView txtTamanio;
        TextView txtResultado;
        public ViewHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.marco_item_cardview);
            txtId = itemView.findViewById(R.id.marco_item_txtId);
            txtRuc = itemView.findViewById(R.id.marco_item_txtRuc);
            txtRazonSocial = itemView.findViewById(R.id.marco_item_txtRazonSocial);
            txtTamanio = itemView.findViewById(R.id.marco_item_txtTamanio);
            txtResultado = itemView.findViewById(R.id.marco_item_txtResultado);
        }
    }
}
