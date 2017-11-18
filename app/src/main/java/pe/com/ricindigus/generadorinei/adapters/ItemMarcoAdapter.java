package pe.com.ricindigus.generadorinei.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.R;
import pe.com.ricindigus.generadorinei.pojos.PojoItemMarco;

/**
 * Created by dmorales on 10/11/2017.
 */

public class ItemMarcoAdapter extends RecyclerView.Adapter<ItemMarcoAdapter.ViewHolder>{


    public interface OnItemClickListener {
        void onItemClick(PojoItemMarco item);
    }

    private ArrayList<PojoItemMarco> items;
    private final OnItemClickListener listener;

    public ItemMarcoAdapter(ArrayList<PojoItemMarco> items, OnItemClickListener listener) {
        this.items = items;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txtCampo1.setText(items.get(position).getDato1());
        holder.txtCampo2.setText(items.get(position).getDato2());
        holder.txtCampo3.setText(items.get(position).getDato3());
        holder.txtCampo4.setText(items.get(position).getDato4());
        holder.clickItem(items.get(position),position,listener);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtCampo1;
        TextView txtCampo2;
        TextView txtCampo3;
        TextView txtCampo4;

        public ViewHolder(View itemView) {
            super(itemView);
            txtCampo1 = (TextView) itemView.findViewById(R.id.item_campo1);
            txtCampo2 = (TextView) itemView.findViewById(R.id.item_campo2);
            txtCampo3 = (TextView) itemView.findViewById(R.id.item_campo3);
            txtCampo4 = (TextView) itemView.findViewById(R.id.item_campo4);
        }

        public void clickItem(final PojoItemMarco item, int posicion, final OnItemClickListener clickListener){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickListener.onItemClick(item);
                }
            });
        }
    }
}
