package pe.com.ricindigus.generadorinei.adapters;

/**
 * Created by otin016 on 27/06/2017.
 */

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import pe.com.ricindigus.generadorinei.R;
import pe.com.ricindigus.generadorinei.pojos.Encuestado;


public class PaisAdapter extends RecyclerView.Adapter<PaisAdapter.ViewHolder>{
    private List<String> paises;
    private Context context;
    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public PaisAdapter(List<String> paises, Context context, OnItemClickListener mOnItemClickListener) {
        this.paises = paises;
        this.context = context;
        this.mOnItemClickListener = mOnItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pais,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnItemClickListener.onItemClick(view, position);
            }
        });
        holder.txtPais.setText(paises.get(position));
    }

    @Override
    public int getItemCount() {
        return paises.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView txtPais;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView)itemView.findViewById(R.id.pais_cardview);
            txtPais = (TextView)itemView.findViewById(R.id.pais_textview);
        }
    }

}

