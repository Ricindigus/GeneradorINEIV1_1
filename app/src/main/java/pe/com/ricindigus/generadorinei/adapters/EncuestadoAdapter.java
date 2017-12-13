package pe.com.ricindigus.generadorinei.adapters;

/**
 * Created by otin016 on 27/06/2017.
 */

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.R;
import pe.com.ricindigus.generadorinei.pojos.Encuestado;



public class EncuestadoAdapter extends RecyclerView.Adapter<EncuestadoAdapter.ViewHolder>{
    private ArrayList<Encuestado> encuestados;
    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public EncuestadoAdapter(ArrayList<Encuestado> encuestados) {
        this.encuestados = encuestados;
    }

    public EncuestadoAdapter(ArrayList<Encuestado> encuestados, OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
        this.encuestados = encuestados;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.encuestado_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView numero, campo1, campo2, campo3;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView)itemView;
            numero = (TextView)itemView.findViewById(R.id.encuestado_numero);
            campo1 = (TextView)itemView.findViewById(R.id.encuestado_campo1);
            campo2 = (TextView)itemView.findViewById(R.id.encuestado_campo2);
            campo3 = (TextView)itemView.findViewById(R.id.encuestado_campo3);
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnItemClickListener.onItemClick(view, position);
            }
        });
        holder.numero.setText(String.valueOf(encuestados.get(position).getNumero()));
        holder.campo1.setText(encuestados.get(position).getCampo1());
        holder.campo2.setText(encuestados.get(position).getCampo2());
        holder.campo3.setText(encuestados.get(position).getCampo3());
//        holder.imgBasura.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                notas.remove(position);
//                notifyDataSetChanged();
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return encuestados.size();
    }


}

