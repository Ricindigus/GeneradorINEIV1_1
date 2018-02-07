package pe.com.ricindigus.generadorinei.componentes.componente_visitas;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.R;
import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.DataComponentes;
import pe.com.ricindigus.generadorinei.pojos.ItemVisita;

/**
 * Created by otin016 on 28/06/2017.
 */

public class VisitaAdapter extends RecyclerView.Adapter<VisitaAdapter.ViewHolder>{

    ArrayList<ItemVisita> visitas;
    Context context;
    OnItemClickListener onItemClickListener;
    ArrayList<String> resultados;

    public VisitaAdapter(ArrayList<ItemVisita> visitas, ArrayList<String> resultados, Context context, OnItemClickListener onItemClickListener) {
        this.visitas = visitas;
        this.resultados = resultados;
        this.context = context;
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        public void onItemClick(View view, int i);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View  view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_visita,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.txtNumero.setText(visitas.get(position).getNumero());
        holder.txtFecha.setText(checkDigito(Integer.parseInt(visitas.get(position).getDia())) + "/" +
                checkDigito(Integer.parseInt(visitas.get(position).getMes())) + "/" +
                checkDigito(Integer.parseInt(visitas.get(position).getAnio()))
        );
        holder.txtHoraInicio.setText(checkDigito(Integer.parseInt(visitas.get(position).getHoraInicio())) + ":"
                + checkDigito(Integer.parseInt(visitas.get(position).getMinInicio())));
        if(!visitas.get(position).getResultado().equals("")){
            holder.txtResultado.setText(resultados.get(Integer.parseInt(visitas.get(position).getResultado())));
        }else{
            holder.txtResultado.setText("No finalizado");
        }
        if(!visitas.get(position).getDiaProx().equals("")){
            holder.txtFechaProxVisita.setText(checkDigito(Integer.parseInt(visitas.get(position).getDiaProx())) + "/" +
                    checkDigito(Integer.parseInt(visitas.get(position).getMesProx())) + "/" +
                    checkDigito(Integer.parseInt(visitas.get(position).getAnioProx())));
            holder.txtHoraProxVisita.setText(checkDigito(Integer.parseInt(visitas.get(position).getHoraProx())) +
                    ":" + checkDigito(Integer.parseInt(visitas.get(position).getMinProx())));
        }else{
            holder.txtFechaProxVisita.setText("-/-/-");
            holder.txtHoraProxVisita.setText("-:-");
        }
        holder.cardViewVisita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(view,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return visitas.size();
    }

    public String checkDigito (int number) {
        return number <= 9 ? "0" + number : String.valueOf(number);
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtNumero;
        TextView txtFecha;
        TextView txtHoraInicio;
        TextView txtHoraFinal;
        TextView txtResultado;
        TextView txtFechaProxVisita;
        TextView txtHoraProxVisita;
        CardView cardViewVisita;

        public ViewHolder(View itemView) {
            super(itemView);
            txtNumero = (TextView) itemView.findViewById(R.id.visita_numero);
            txtFecha = (TextView) itemView.findViewById(R.id.visita_fecha);
            txtHoraInicio = (TextView) itemView.findViewById(R.id.visita_hora_inicio);
            txtHoraFinal = (TextView) itemView.findViewById(R.id.visita_hora_final);
            txtResultado = (TextView) itemView.findViewById(R.id.txt_item_visita_resultado);
            txtFechaProxVisita = (TextView) itemView.findViewById(R.id.visita_fecha_proxima);
            txtHoraProxVisita = (TextView) itemView.findViewById(R.id.visita_hora_proxima);
            cardViewVisita = (CardView) itemView.findViewById(R.id.cardview_visita);
        }
    }

}
