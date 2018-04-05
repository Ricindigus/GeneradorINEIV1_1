package pe.com.ricindigus.generadorinei.componentes.componente_visitas;


import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.SQLException;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

import pe.com.ricindigus.generadorinei.R;
import pe.com.ricindigus.generadorinei.componentes.componente_visitas.pojos.Visita;
import pe.com.ricindigus.generadorinei.fragments.ComponenteFragment;
import pe.com.ricindigus.generadorinei.modelo.DataSourceTablasGuardado.DataTablas;

/**
 * A simple {@link Fragment} subclass.
 */
public class VisitasFragment extends ComponenteFragment {
    private LinearLayoutManager linearLayoutManager;
    private VisitaAdapter visitaAdapter;
    private RecyclerView recyclerView;
    private FloatingActionButton btnAgregar;
    private TextView txtFechaFinal;
    private TextView txtHorafinal;
    private TextView txtResultadoFinal;
    private Context context;
    private String idEmpresa;
    private Visita visita;
    private DataTablas dataTablas;
    private Cursor cursor;
    private VisitaAdapter.OnItemClickListener onItemClickListener;


    int diaInicio;
    int mesInicio;
    int anioInicio;

    int horaInicio;
    int minutoInicio;
    int horaFin;
    int minutoFin;

    int diaProx;
    int mesProx;
    int anioProx;

    int horaProx;
    int minutoProx;

    private String RESFIN_ID;
    private String RESFIN_DIA;
    private String RESFIN_MES;
    private String RESFIN_ANIO;
    private String RESFIN_MIN;
    private String RESFIN_HORA;
    private int RESFIN;
    private String RESFIN_O;

    public VisitasFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public VisitasFragment(Context context, String idEmpresa, Visita visita) {
        this.context = context;
        this.idEmpresa = idEmpresa;
        this.visita = visita;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_visitas, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.visita_recycler);
        txtResultadoFinal = (TextView) rootView.findViewById(R.id.visitas_resultado_final);
        txtFechaFinal = (TextView) rootView.findViewById(R.id.visitas_fecha_final);
        txtHorafinal = (TextView) rootView.findViewById(R.id.visitas_hora_final);
        btnAgregar = (FloatingActionButton) rootView.findViewById(R.id.visitas_btnAgregarVisita);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cargarDatos();
        recyclerView.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        onItemClickListener = new VisitaAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, final int pos) {
                cursor.moveToPosition(pos);
                DataTablas dTablas = new DataTablas(context);
                dTablas.open();
                String resultadoVisita = cursor.getString(cursor.getColumnIndex(visita.getVARRES()));
                dTablas.close();
                if(resultadoVisita == null){
                    PopupMenu popupMenu = new PopupMenu(context,view);
                    popupMenu.getMenuInflater().inflate(R.menu.menu_visita,popupMenu.getMenu());
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            switch(item.getItemId()){
                                case R.id.opcion_editar:
                                            editarVisita(pos);
                                    break;
                                case R.id.opcion_eliminar:
                                            eliminarVisita(pos);
                                    break;
                                case R.id.opcion_finalizar:
                                    finalizarVisita(pos);
                                    break;
                            }
                            return true;
                        }
                    });
                    popupMenu.show();
                }
            }
        };

        try{
            dataTablas = new DataTablas(context);
            dataTablas.open();
            cursor = dataTablas.getVisitas(getIdTablaParte1(),idEmpresa);
            dataTablas.close();
            if(cursor != null){
                visitaAdapter = new VisitaAdapter(visita, context, cursor, onItemClickListener);
                recyclerView.setAdapter(visitaAdapter);
            }
        }catch (SQLException e){}



        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cursor.getCount() > 0) {
                    cursor.moveToPosition(cursor.getCount() - 1);
                    if(cursor.getString(cursor.getColumnIndex(visita.getVARRES())) != null) agregarVisita();
                    else mostrarMensaje("DEBE FINALIZAR LA VISITA ACTUAL, ANTES DE AGREGAR UNA NUEVA");
                }else{agregarVisita();}
            }
        });
    }


    public void agregarVisita(){
        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
        final View dialogView = getActivity().getLayoutInflater().inflate(R.layout.dialog_agregar_visita, null);
        final LinearLayout lytDialog = (LinearLayout) dialogView.findViewById(R.id.dialog_agregar_visita_lyt);
        final TextView txtNumero = (TextView) dialogView.findViewById(R.id.dialog_agregar_visita_txtNumero);
        final TextView txtFechaI = (TextView) dialogView.findViewById(R.id.dialog_agregar_visita_txtFI);
        final TextView txtHoraI = (TextView) dialogView.findViewById(R.id.dialog_agregar_visita_txtHI);

        txtFechaI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendario = Calendar.getInstance();
                int yy = calendario.get(Calendar.YEAR);
                int mm = calendario.get(Calendar.MONTH);
                int dd = calendario.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePicker = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        diaInicio = dayOfMonth;
                        mesInicio = monthOfYear + 1;
                        anioInicio = year;
                        String fecha = checkDigito(diaInicio) +"/"+checkDigito(mesInicio) +"/"+checkDigito(anioInicio);
                        txtFechaI.setText(fecha);
                    }
                }, yy, mm, dd);
                datePicker.show();
            }
        });

        txtHoraI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendario = Calendar.getInstance();
                int hh = calendario.get(Calendar.HOUR_OF_DAY);
                int mm = calendario.get(Calendar.MINUTE);

                TimePickerDialog timePicker = new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourofDay, int minute) {
                        String hora = checkDigito(hourofDay) +":"+checkDigito(minute);
                        txtHoraI.setText(hora);
                        horaInicio = hourofDay;
                        minutoInicio = minute;
                    }
                }, hh, mm,true);
                timePicker.show();
            }
        });

        alert.setTitle("AGREGAR VISITA");
        alert.setView(dialogView);
        alert.setPositiveButton("Agregar",null);
        alert.setNegativeButton("Cancelar",null);
        final AlertDialog alertDialog = alert.create();
//        alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                Calendar c = Calendar.getInstance();
                diaInicio = c.get(Calendar.DAY_OF_MONTH);
                mesInicio = c.get(Calendar.MONTH) + 1;
                anioInicio = c.get(Calendar.YEAR);
                horaInicio = c.get(Calendar.HOUR_OF_DAY);
                minutoInicio = c.get(Calendar.MINUTE);

                txtNumero.setText("VISITA N° " + checkDigito((visitaAdapter.getItemCount() + 1)));
                txtFechaI.setText(checkDigito(diaInicio) + "/" + checkDigito(mesInicio) + "/" + checkDigito(anioInicio));
                txtHoraI.setText(checkDigito(horaInicio) + ":" + checkDigito(minutoInicio));
                Button btnAdd = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
                btnAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // TODO Do something
                        boolean valido = true;
                        String mensaje = "";
                        boolean vFechaInicio = true, vHoraInicio = true;
                        if(cursor.getCount() > 0){
                            cursor.moveToPosition(cursor.getCount()-1);
                            int y = Integer.parseInt(cursor.getString(cursor.getColumnIndex(visita.getVARANIO())));
                            int m = Integer.parseInt(cursor.getString(cursor.getColumnIndex(visita.getVARMES())));
                            int d = Integer.parseInt(cursor.getString(cursor.getColumnIndex(visita.getVARDIA())));

                            int compHora = Integer.parseInt(cursor.getString(cursor.getColumnIndex(visita.getVARHORI())));
                            int compMinuto = Integer.parseInt(cursor.getString(cursor.getColumnIndex(visita.getVARMINI())));


                            Date fi1 = new Date(y,m,d);
                            Date fi2 = new Date(anioInicio,mesInicio,diaInicio);
                            String sfi1 = checkDigito(d) + "/" + checkDigito(m) + "/" + checkDigito(y);
                            String sfi2 = checkDigito(diaInicio) + "/" + checkDigito(mesInicio) + "/" + checkDigito(anioInicio);
                            if(fi2.before(fi1)){
                                vFechaInicio = false;
                                if(mensaje.equals("")) mensaje = "FECHA: LA FECHA DE LA NUEVA VISITA NO DEBE SER MENOR A LA VISITA ANTERIOR";
                            }else if(d == diaInicio && m == mesInicio && y == anioInicio){
                                if((horaInicio*60 + minutoInicio) <= (compHora*60+compMinuto)){
                                    vHoraInicio = false;
                                    if(mensaje.equals("")) mensaje = "FECHA: SI LA FECHA ES LA MISMA, LA HORA DE LA NUEVA VISITA NO DEBE SER MENOR O IGUAL A LA VISITA ANTERIOR";
                                }
                            }
                        }
                        valido = vFechaInicio && vHoraInicio;
                        if(valido){
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("_id",idEmpresa+String.valueOf(cursor.getCount()+1));
                            contentValues.put("ID_EMPRESA",idEmpresa);
                            contentValues.put(visita.getVARNUM(),String.valueOf(cursor.getCount()+1));
                            contentValues.put(visita.getVARDIA(),diaInicio);
                            contentValues.put(visita.getVARMES(),mesInicio);
                            contentValues.put(visita.getVARANIO(),anioInicio);
                            contentValues.put(visita.getVARHORI(),horaInicio);
                            contentValues.put(visita.getVARMINI(),minutoInicio);
                            try{
                                DataTablas dTablas = new DataTablas(context);
                                dTablas.open();
                                dTablas.insertarValores(getIdTablaParte1(),contentValues);
                                cursor = dTablas.getVisitas(getIdTablaParte1(),idEmpresa);
                                dTablas.close();
                                if(cursor != null){
                                    visitaAdapter = new VisitaAdapter(visita, context, cursor, onItemClickListener);
                                    recyclerView.setAdapter(visitaAdapter);
                                }
                            }catch (SQLException e){}
//                            recyclerView.getAdapter().notifyDataSetChanged();
                            alertDialog.dismiss();
                        }else Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        alertDialog.show();
    }

    public void editarVisita(final int posicion){
        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
        final View dialogView = getActivity().getLayoutInflater().inflate(R.layout.dialog_agregar_visita, null);
        final LinearLayout lytDialog = (LinearLayout) dialogView.findViewById(R.id.dialog_agregar_visita_lyt);
        final TextView txtNumero = (TextView) dialogView.findViewById(R.id.dialog_agregar_visita_txtNumero);
        final TextView txtFechaI = (TextView) dialogView.findViewById(R.id.dialog_agregar_visita_txtFI);
        final TextView txtHoraI = (TextView) dialogView.findViewById(R.id.dialog_agregar_visita_txtHI);

        txtFechaI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int dd = Integer.parseInt(cursor.getString(cursor.getColumnIndex(visita.getVARDIA())));
                int mm = Integer.parseInt(cursor.getString(cursor.getColumnIndex(visita.getVARMES())));
                int yy = Integer.parseInt(cursor.getString(cursor.getColumnIndex(visita.getVARANIO())));

                DatePickerDialog datePicker = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        diaInicio = dayOfMonth;
                        mesInicio = monthOfYear + 1;
                        anioInicio = year;
                        String fecha = checkDigito(diaInicio) +"/"+checkDigito(mesInicio)
                                +"/"+checkDigito(anioInicio);
                        txtFechaI.setText(fecha);

                    }
                }, yy, mm-1, dd);
                datePicker.show();
            }
        });

        txtHoraI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendario = Calendar.getInstance();
                int hh = calendario.get(Calendar.HOUR_OF_DAY);
                int mm = calendario.get(Calendar.MINUTE);

                TimePickerDialog timePicker = new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourofDay, int minute) {
                        String hora = checkDigito(hourofDay) +":"+checkDigito(minute);
                        txtHoraI.setText(hora);
                        horaInicio= hourofDay;
                        minutoInicio = minute;
                    }
                }, hh, mm,true);
                timePicker.show();
            }
        });

        alert.setTitle("EDITAR VISITA");
        alert.setView(dialogView);
        alert.setPositiveButton("Guardar",null);
        alert.setNegativeButton("Cancelar",null);
        final AlertDialog alertDialog = alert.create();

        alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                cursor.moveToPosition(posicion);

                diaInicio = Integer.parseInt(cursor.getString(cursor.getColumnIndex(visita.getVARDIA())));
                mesInicio = Integer.parseInt(cursor.getString(cursor.getColumnIndex(visita.getVARMES())));
                anioInicio = Integer.parseInt(cursor.getString(cursor.getColumnIndex(visita.getVARANIO())));
                horaInicio = Integer.parseInt(cursor.getString(cursor.getColumnIndex(visita.getVARHORI())));
                minutoInicio = Integer.parseInt(cursor.getString(cursor.getColumnIndex(visita.getVARMINI())));

                txtNumero.setText("VISITA N° " + checkDigito(Integer.parseInt(cursor.getString(cursor.getColumnIndex(visita.getVARNUM())))));
                txtFechaI.setText(checkDigito(diaInicio) + "/" + checkDigito(mesInicio) + "/" + checkDigito(anioInicio));
                txtHoraI.setText(checkDigito(horaInicio) + ":" + checkDigito(minutoInicio));
                Button btnAdd = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
                btnAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // TODO Do something
                        boolean valido =true;
                        String mensaje = "";
                        boolean vFechaInicio = true, vHoraInicio = true;

                        if(cursor.getCount() > 1){
                            cursor.moveToPosition(posicion-1);
                            int d = Integer.parseInt(cursor.getString(cursor.getColumnIndex(visita.getVARDIA())));
                            int m = Integer.parseInt(cursor.getString(cursor.getColumnIndex(visita.getVARMES())));
                            int y = Integer.parseInt(cursor.getString(cursor.getColumnIndex(visita.getVARANIO())));

                            int compHora = Integer.parseInt(cursor.getString(cursor.getColumnIndex(visita.getVARHORI())));
                            int compMinuto = Integer.parseInt(cursor.getString(cursor.getColumnIndex(visita.getVARMINI())));

                            Date fi1 = new Date(y,m,d);
                            Date fi2 = new Date(anioInicio,mesInicio,diaInicio);
                            String sfi1 = checkDigito(d) + "/" + checkDigito(m) + "/" + checkDigito(y);
                            String sfi2 = checkDigito(diaInicio) + "/" + checkDigito(mesInicio) + "/" + checkDigito(anioInicio);

                            if(fi2.before(fi1)){
                                vFechaInicio = false;
                                if(mensaje.equals("")) mensaje = "FECHA: LA FECHA DE LA PROXIMA VISITA NO DEBE SER MENOR A LA VISITA ACTUAL";
                            }else if(d == diaInicio && m == mesInicio && y == anioInicio){
                                if((horaInicio*60 + minutoInicio) <= (compHora*60+compMinuto)){
                                    vHoraInicio = false;
                                    if(mensaje.equals("")) mensaje = "FECHA: SI LA FECHA ES LA MISMA, LA HORA DE LA NUEVA VISITA NO DEBE SER MENOR O IGUAL A LA VISITA ANTERIOR";
                                }
                            }
                        }
                        valido = vFechaInicio && vHoraInicio;
                        if(valido){
                            ContentValues contentValues = new ContentValues();
                            contentValues.put(visita.getVARDIA(),diaInicio);
                            contentValues.put(visita.getVARMES(),mesInicio);
                            contentValues.put(visita.getVARANIO(),anioInicio);
                            contentValues.put(visita.getVARHORI(),horaInicio);
                            contentValues.put(visita.getVARMINI(),minutoInicio);
                            contentValues.put(visita.getVARDIA(),diaInicio);
                            contentValues.put(visita.getVARDIA(),diaInicio);
                            try{
                                cursor.moveToPosition(posicion);
                                String idVisita = cursor.getString(cursor.getColumnIndex("_id"));
                                dataTablas = new DataTablas(context);
                                dataTablas.open();
                                dataTablas.actualizarVisita(getIdTablaParte1(),idVisita,contentValues);
                                cursor = dataTablas.getVisitas(getIdTablaParte1(),idEmpresa);
                                dataTablas.close();
                                if(cursor != null){
                                    visitaAdapter = new VisitaAdapter(visita, context, cursor, onItemClickListener);
                                    recyclerView.setAdapter(visitaAdapter);
                                }
                            }catch (SQLException e){}
                            alertDialog.dismiss();
                        }else Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        alertDialog.show();
    }

    public void eliminarVisita(final int posicion){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("¿Está seguro que desea eliminar la visita? (no podrá revertir el cambio)")
                .setTitle("Aviso")
                .setCancelable(false)
                .setNegativeButton("No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        })
                .setPositiveButton("Sí",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                try{
                                    cursor.moveToPosition(posicion);
                                    String idVisita = cursor.getString(cursor.getColumnIndex("_id"));
                                    dataTablas = new DataTablas(context);
                                    dataTablas.open();
                                    dataTablas.deleteVisita(getIdTablaParte1(),idVisita);
                                    cursor = dataTablas.getVisitas(getIdTablaParte1(),idEmpresa);
                                    dataTablas.close();
                                    if(cursor != null){
                                        visitaAdapter = new VisitaAdapter(visita, context, cursor, onItemClickListener);
                                        recyclerView.setAdapter(visitaAdapter);
                                    }
                                }catch (SQLException e){}
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void finalizarVisita(final int posicion){
        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
        final View dialogView = getActivity().getLayoutInflater().inflate(R.layout.dialog_finalizar_visita, null);
        final LinearLayout lytDialog = (LinearLayout) dialogView.findViewById(R.id.dialog_finalizar_visita_lyt);
        final TextView txtNumero = (TextView) dialogView.findViewById(R.id.dialog_finalizar_visita_txtNumero);
        final TextView txtHoraF = (TextView) dialogView.findViewById(R.id.dialog_finalizar_visita_txtHoraFin);
        final Spinner spResultado = (Spinner) dialogView.findViewById(R.id.dialog_finalizar_visita_spResultado);
        final EditText edtEspecifique = (EditText) dialogView.findViewById(R.id.dialog_finalizar_visita_edtEspecifique);
        final CheckBox ckProxVisita = (CheckBox) dialogView.findViewById(R.id.dialog_finalizar_visita_ckProximaVisita);
        final TextView txtFechaProxVisita = (TextView) dialogView.findViewById(R.id.dialog_finalizar_visita_txtFechaProx);
        final TextView txtHoraProxVisita = (TextView) dialogView.findViewById(R.id.dialog_finalizar_visita_txtHoraProx);
        final CardView cardViewEspecifique = (CardView) dialogView.findViewById(R.id.dialog_cardview_finalizar_especifique);
        final CardView cardViewProxFecha= (CardView) dialogView.findViewById(R.id.dialog_cardview_proxFecha);
        final CardView cardViewProxHora = (CardView) dialogView.findViewById(R.id.dialog_cardview_proxHora);
        String especifique = "";

        txtHoraF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendario = Calendar.getInstance();
                int dia = calendario.get(Calendar.DAY_OF_MONTH);
                int mes = calendario.get(Calendar.MONTH);
                int anio = calendario.get(Calendar.YEAR);
                int hh = calendario.get(Calendar.HOUR_OF_DAY);
                int mm = calendario.get(Calendar.MINUTE);

                TimePickerDialog timePicker = new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourofDay, int minute) {
                        String hora = checkDigito(hourofDay) +":"+checkDigito(minute);
                        txtHoraF.setText(hora);
                        horaFin = hourofDay;
                        minutoFin = minute;
                    }
                }, hh, mm,true);
                timePicker.show();
            }
        });

        spResultado.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
                if(pos == 4 || pos == 2){
                    ckProxVisita.setEnabled(true);
                    ckProxVisita.setChecked(true);
                }else{
                    ckProxVisita.setChecked(false);
                    ckProxVisita.setEnabled(false);
                }
                if(pos == 7){
                    edtEspecifique.setEnabled(true);
                    cardViewEspecifique.setVisibility(View.VISIBLE);
//                    edtEspecifique.setBackgroundResource(R.drawable.fondo_edit_text);
                }else{
                    if(edtEspecifique.isEnabled()){
                        edtEspecifique.setText("");
                        cardViewEspecifique.setVisibility(View.GONE);
//                        edtEspecifique.setBackgroundResource(R.drawable.fondo_edit_text_disabled);
                        edtEspecifique.setEnabled(false);
                    }
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        ckProxVisita.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    txtFechaProxVisita.setEnabled(true);
                    txtHoraProxVisita.setEnabled(true);
                    txtFechaProxVisita.setClickable(true);
                    txtHoraProxVisita.setClickable(true);
                    cardViewProxFecha.setCardBackgroundColor(Color.WHITE);
                    cardViewProxHora.setCardBackgroundColor(Color.WHITE);
                }else{
                    cardViewProxFecha.setCardBackgroundColor(Color.GRAY);
                    cardViewProxHora.setCardBackgroundColor(Color.GRAY);
                    txtFechaProxVisita.setClickable(false);
                    txtHoraProxVisita.setClickable(false);
                    txtFechaProxVisita.setEnabled(false);
                    txtHoraProxVisita.setEnabled(false);
                }
            }
        });

        txtFechaProxVisita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendario = Calendar.getInstance();
                int yy = calendario.get(Calendar.YEAR);
                int mm = calendario.get(Calendar.MONTH);
                int dd = calendario.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePicker = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        diaProx = dayOfMonth;
                        mesProx = monthOfYear + 1;
                        anioProx = year;
                        String fecha = checkDigito(diaProx) +"/"+checkDigito(mesProx)
                                +"/"+checkDigito(anioProx);
                        txtFechaProxVisita.setText(fecha);
                    }
                }, yy, mm, dd);
                datePicker.show();
            }
        });
        txtHoraProxVisita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendario = Calendar.getInstance();
                int hh = calendario.get(Calendar.HOUR_OF_DAY);
                int mm = calendario.get(Calendar.MINUTE);

                TimePickerDialog timePicker = new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourofDay, int minute) {
                        String hora = checkDigito(hourofDay) +":"+checkDigito(minute);
                        txtHoraProxVisita.setText(hora);
                        horaProx = hourofDay;
                        minutoProx = minute;
                    }
                }, hh, mm,true);
                timePicker.show();
            }
        });

        alert.setTitle("FINALIZAR VISITA");
        alert.setView(dialogView);
        alert.setPositiveButton("Finalizar",null);
        alert.setNegativeButton("Cancelar",null);
        final AlertDialog alertDialog = alert.create();

        alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                ocultarTeclado(lytDialog);
                Calendar c = Calendar.getInstance();
                diaProx = c.get(Calendar.DAY_OF_MONTH);
                mesProx = c.get(Calendar.MONTH) + 1;
                anioProx = c.get(Calendar.YEAR);
                horaProx = c.get(Calendar.HOUR_OF_DAY);
                minutoProx = c.get(Calendar.MINUTE);
                horaFin = horaProx;
                minutoFin = minutoProx;
                cursor.moveToPosition(posicion);
                txtNumero.setText("VISITA N° " + checkDigito(Integer.parseInt(cursor.getString(cursor.getColumnIndex(visita.getVARNUM())))));
                txtHoraF.setText(checkDigito(horaFin) + ":" + checkDigito(minutoFin));
                txtFechaProxVisita.setText(checkDigito(diaProx + 1) + "/" + checkDigito(mesProx) + "/" + checkDigito(anioProx));
                txtHoraProxVisita.setText(checkDigito(horaProx) + ":" + checkDigito(minutoProx));
                Button btnFinalizarVisita = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
                btnFinalizarVisita.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // TODO Do something
                        boolean valido = false;
                        boolean vHoraFin = true, vResultado = true, vEspecifique = true, vFechaProxima = true, vHoraProxima = true;
                        String mensaje = "";
                        cursor.moveToPosition(posicion);
                        int t1 = Integer.parseInt(cursor.getString(cursor.getColumnIndex(visita.getVARHORI())))*60 + Integer.parseInt(cursor.getString(cursor.getColumnIndex(visita.getVARMINI())));
                        int t2 = horaFin * 60 + minutoFin;

                        if(t1 >= t2){
                            vHoraFin = false;
                            if(mensaje.equals("")) mensaje = "LA HORA DE FIN DEBE SER MAYOR A LA DE INICIO";
                        }

                        if(spResultado.getSelectedItemPosition() == 0){
                            vResultado = false;
                            if(mensaje.equals("")) mensaje = "DEBE INDICAR EL RESULTADO DE LA VISITA";
                        }
                        if(spResultado.getSelectedItemPosition() == 1){
                            if(!coberturaCorrecta()){
                                vResultado = false;
                                if(mensaje.equals("")) mensaje = "LA COBERTURA Y CIERRE ES INCORRECTA NO PUEDE FINALIZAR COMO COMPLETA";
                            }
                        }
                        if(spResultado.getSelectedItemPosition() == 4 && !ckProxVisita.isChecked()){
                            vResultado = false;
                            if(mensaje.equals("")) mensaje = "DEBE REGISTRAR INFORMACION DE LA PROXIMA VISITA";
                        }
                        if(edtEspecifique.isEnabled() && edtEspecifique.getText().toString().trim().length() < 3){
                            vEspecifique = false;
                            if(mensaje.equals("")) mensaje = "DEBE ESPECIFICAR EL RESULTADO DE LA VISITA";
                        }
                        if(ckProxVisita.isChecked()){
                            cursor.moveToPosition(posicion);
                            int y = Integer.parseInt(cursor.getString(cursor.getColumnIndex(visita.getVARANIO())));
                            int m = Integer.parseInt(cursor.getString(cursor.getColumnIndex(visita.getVARMES())));
                            int d = Integer.parseInt(cursor.getString(cursor.getColumnIndex(visita.getVARDIA())));
                            Date fi1 = new Date(y,m,d);
                            Date fi2 = new Date(anioProx,mesProx,diaProx);
                            String sfi1 = checkDigito(d) + "/" + checkDigito(m) + "/" + checkDigito(y);
                            String sfi2 = checkDigito(diaProx) + "/" + checkDigito(mesProx) + "/" + checkDigito(anioProx);

                            if(fi2.before(fi1)){
                                vFechaProxima = false;
                                if(mensaje.equals("")) mensaje = "FECHA: LA FECHA DE LA PROXIMA VISITA NO DEBE SER MENOR A LA VISITA ACTUAL";
                            }
                        }

                        valido = vHoraFin && vResultado && vEspecifique && vFechaProxima;

                        if(valido){
                            //actualizo visita con datos de finalizar
                            ContentValues contentValues = new ContentValues();
                            contentValues.put(visita.getVARRES(),String.valueOf(spResultado.getSelectedItemPosition()));
                            //falta guardar el especifique del resultado otro
                            if(ckProxVisita.isChecked()){
                                contentValues.put(visita.getVARDIAP(),checkDigito(diaProx));
                                contentValues.put(visita.getVARMESP(),checkDigito(mesProx));
                                contentValues.put(visita.getVARANIOP(),checkDigito(anioProx));
                                contentValues.put(visita.getVARHORP(),checkDigito(horaProx));
                                contentValues.put(visita.getVARMINP(),checkDigito(minutoProx));
                            }
                            try{
                                dataTablas = new DataTablas(context);
                                dataTablas.open();
                                cursor.moveToPosition(posicion);
                                dataTablas.actualizarVisita(getIdTablaParte1(),cursor.getString(cursor.getColumnIndex("_id")),contentValues);
                                cursor = dataTablas.getVisitas(getIdTablaParte1(),idEmpresa);
                                dataTablas.close();
                                if(cursor != null){
                                    visitaAdapter = new VisitaAdapter(visita, context, cursor, onItemClickListener);
                                    recyclerView.setAdapter(visitaAdapter);
                                }
                            }catch (SQLException e){}

//                            //MUESTRO Y GUARDO DATOS DE RESULTADO FINAL
                            final Calendar cal = Calendar.getInstance();
                            cursor.moveToPosition(posicion);
                            int yy = Integer.parseInt(cursor.getString(cursor.getColumnIndex(visita.getVARANIO())));
                            int mm = Integer.parseInt(cursor.getString(cursor.getColumnIndex(visita.getVARMES())));
                            int dd = Integer.parseInt(cursor.getString(cursor.getColumnIndex(visita.getVARDIA())));


                            //----nuevo content values final
                            ContentValues contentValuesFinal = new ContentValues();
                            cursor.moveToPosition(posicion);
                            contentValuesFinal.put(visita.getVARRESFINAL(),cursor.getString(cursor.getColumnIndex(visita.getVARRES())));
                            //FALTA GUARDAR RWESULTADO ESPECIFIQUE DE OTRO
                            contentValuesFinal.put(visita.getVARRESDIA(),dd);
                            contentValuesFinal.put(visita.getVARRESMES(),mm);
                            contentValuesFinal.put(visita.getVARRESANIO(),yy);
                            contentValuesFinal.put(visita.getVARRESHORA(),horaFin);
                            contentValuesFinal.put(visita.getVARRESMIN(),minutoFin);
                            dataTablas = new DataTablas(context);
                            dataTablas.open();
                            if(!dataTablas.existenDatos(getIdTablaParte2(),idEmpresa)){
                                contentValuesFinal.put("ID_EMPRESA",idEmpresa);
                                dataTablas.insertarValores(getIdTablaParte2(),contentValuesFinal);
                            }else dataTablas.actualizarValores(getIdTablaParte2(),idEmpresa,contentValuesFinal);
                            dataTablas.close();
                            txtResultadoFinal.setText(getResources().getStringArray(R.array.array_resultado_visita)[spResultado.getSelectedItemPosition()]);
                            txtFechaFinal.setText(checkDigito(dd) + "/" + checkDigito(mm) + "/" + checkDigito(yy));
                            txtHorafinal.setText(checkDigito(horaFin) + ":" + checkDigito(minutoFin));
                            alertDialog.dismiss();
                        }else Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        alertDialog.show();
    }

    public boolean coberturaCorrecta(){
        boolean correcto = true;
        return correcto;
    }
//
//    public boolean tieneVisitas(){
//        boolean correcto = true;
//        if(visitas.size() == 0) correcto = false;
//        return correcto;
//    }
//    public boolean finalizacionCorrecta(){
//        boolean correcto = true;
//        if(visitas.get(visitas.size()-1).getV_RESULTADO().equals("")) correcto = false;
//        return correcto;
//    }
    public void cargarDatos(){
        dataTablas = new DataTablas(context);
        dataTablas.open();
        if(dataTablas.existenDatos(getIdTablaParte2(),idEmpresa)){
            txtResultadoFinal.setText(getResources().getStringArray(R.array.array_resultado_visita)[Integer.parseInt(dataTablas.getValor(getIdTablaParte2(),visita.getVARRESFINAL(),idEmpresa))]);
            txtFechaFinal.setText(
                    checkDigito(Integer.parseInt(dataTablas.getValor(getIdTablaParte2(),visita.getVARRESDIA(),idEmpresa))) +
                            "/" + checkDigito(Integer.parseInt(dataTablas.getValor(getIdTablaParte2(),visita.getVARRESMES(),idEmpresa))) +
                            "/" + checkDigito(Integer.parseInt(dataTablas.getValor(getIdTablaParte2(),visita.getVARRESANIO(),idEmpresa))));
            txtHorafinal.setText(
                    checkDigito(Integer.parseInt(dataTablas.getValor(getIdTablaParte2(),visita.getVARRESHORA(),idEmpresa))) +
                            ":" + checkDigito(Integer.parseInt(dataTablas.getValor(getIdTablaParte2(),visita.getVARRESMIN(),idEmpresa))));
        }

        dataTablas.close();
    }

    @Override
    public void llenarVista() {

    }

    @Override
    public void inhabilitar() {

    }

    @Override
    public void habilitar() {

    }

    @Override
    public void guardarDatos() {

    }

    public boolean validarDatos(){
        boolean valido = true;
        String mensaje = "";
        if(cursor.getCount() > 0){
            cursor.moveToPosition(cursor.getCount()-1);
            if(cursor.getString(cursor.getColumnIndex(visita.getVARRES())) != null){
                valido =  false;
                mensaje = "DEBE INICIAR UNA VISITA ANTES DE CONTINUAR";
            }
        }else{
            valido =  false;
            mensaje = "DEBE INICIAR UNA VISITA ANTES DE CONTINUAR";
        }

        if(!valido){
            mostrarMensaje(mensaje);
        }
        return valido;
    }

    @Override
    public boolean estaHabilitado() {
        return false;
    }

    @Override
    public String getIdTabla() {
        return null;
    }

    public String checkDigito (int number) {
        return number <= 9 ? "0" + number : String.valueOf(number);
    }
    public void ocultarTeclado(View view){
        InputMethodManager mgr = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
    public void mostrarMensaje(String m){
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(m);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    public String getIdTablaParte1(){
        return visita.getMODULO() + "_1";
    }
    public String getIdTablaParte2(){
        return visita.getMODULO() + "_2";
    }

}
