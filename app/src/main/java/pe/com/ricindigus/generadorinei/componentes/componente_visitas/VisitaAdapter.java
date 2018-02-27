package pe.com.ricindigus.generadorinei.componentes.componente_visitas;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;
import pe.com.ricindigus.generadorinei.R;
import pe.com.ricindigus.generadorinei.componentes.componente_visitas.pojos.Visita;

/**
 * Created by otin016 on 28/06/2017.
 */

public class VisitaAdapter extends RecyclerView.Adapter<VisitaAdapter.ViewHolder>{
    Context context;
    OnItemClickListener onItemClickListener;
    CursorAdapter cursorAdapter;
    Visita visita;

    public VisitaAdapter(final Visita visita, Context context, Cursor cursor, OnItemClickListener onItemClickListener) {
        this.visita = visita;
        this.context = context;
        this.onItemClickListener = onItemClickListener;
        this.cursorAdapter = new CursorAdapter(context,cursor,0) {
            @Override
            public View newView(Context context, Cursor cursor, ViewGroup parent) {
                return LayoutInflater.from(parent.getContext()).inflate(R.layout.item_visita,parent,false);
            }

            @Override
            public void bindView(View view, Context context, Cursor cursor) {
                TextView txtNumero = (TextView) view.findViewById(R.id.txt_item_visita_numero);
                TextView txtFecha = (TextView) view.findViewById(R.id.txt_item_visita_fecha);
                TextView txtHoraInicio = (TextView) view.findViewById(R.id.txt_item_visita_horai);
                TextView txtResultado = (TextView) view.findViewById(R.id.txt_item_visita_resultado);
                TextView txtFechaProxVisita = (TextView) view.findViewById(R.id.txt_item_visita_fprox);
                TextView txtHoraProxVisita = (TextView) view.findViewById(R.id.txt_item_visita_hprox);

                txtNumero.setText(cursor.getString(cursor.getColumnIndex(visita.getVARNUM())));
                txtFecha.setText(
                        checkDigito(Integer.parseInt(cursor.getString(cursor.getColumnIndex(visita.getVARDIA()))))+
                                "/" + checkDigito(Integer.parseInt(cursor.getString(cursor.getColumnIndex(visita.getVARMES())))) +
                                "/" + checkDigito(Integer.parseInt(cursor.getString(cursor.getColumnIndex(visita.getVARANIO()))))
                );
                txtHoraInicio.setText(
                        checkDigito(Integer.parseInt(cursor.getString(cursor.getColumnIndex(visita.getVARHORI())))) +
                                ":"+ checkDigito(Integer.parseInt(cursor.getString(cursor.getColumnIndex(visita.getVARMINI()))))
                );
                String resultado = cursor.getString(cursor.getColumnIndex(visita.getVARRES()));
                if(resultado != null)txtResultado.setText(context.getResources().getStringArray(R.array.array_resultado_visita)[Integer.parseInt(resultado)]);
                else txtResultado.setText("NO FINALIZADO");
                String diaProxV = cursor.getString(cursor.getColumnIndex(visita.getVARDIAP()));
                if(diaProxV != null) {
                    txtFechaProxVisita.setText(
                            checkDigito(Integer.parseInt(diaProxV)) +
                                    "/" + checkDigito(Integer.parseInt(cursor.getString(cursor.getColumnIndex(visita.getVARMESP())))) +
                                    "/" + checkDigito(Integer.parseInt(cursor.getString(cursor.getColumnIndex(visita.getVARANIOP()))))
                    );
                    txtHoraProxVisita.setText(
                            checkDigito(Integer.parseInt(cursor.getString(cursor.getColumnIndex(visita.getVARHORP())))) +
                                    ":" + checkDigito(Integer.parseInt(cursor.getString(cursor.getColumnIndex(visita.getVARMINP()))))
                    );
                }else{
                        txtFechaProxVisita.setText("-/-/-");
                        txtHoraProxVisita.setText("-:-");
                }
            }
        };
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
        cursorAdapter.getCursor().moveToPosition(position);
        cursorAdapter.bindView(holder.itemView,context,cursorAdapter.getCursor());
        holder.cardViewVisita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(view,position);
            }
        });
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardViewVisita;
        public ViewHolder(View itemView) {
            super(itemView);
            cardViewVisita = (CardView) itemView.findViewById(R.id.cardview_visita);
        }
    }

    @Override
    public int getItemCount() {
        return cursorAdapter.getCount();
    }

    public String checkDigito (int number) {
        return number <= 9 ? "0" + number : String.valueOf(number);
    }
}
