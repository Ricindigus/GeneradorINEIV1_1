package pe.com.ricindigus.generadorinei.activities;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.InputFilter;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pe.com.ricindigus.generadorinei.fragments.ComponenteFragment;
import pe.com.ricindigus.generadorinei.interfaces.ActividadInterfaz;
import pe.com.ricindigus.generadorinei.componentes.componente_checkbox.CheckBoxFragment;
import pe.com.ricindigus.generadorinei.componentes.componente_checkbox.modelo.DataCheckBox;
import pe.com.ricindigus.generadorinei.componentes.componente_checkbox.pojos.PCheckBox;
import pe.com.ricindigus.generadorinei.componentes.componente_checkbox.pojos.SPCheckBox;
import pe.com.ricindigus.generadorinei.componentes.componente_edittext.modelo.DataEditText;
import pe.com.ricindigus.generadorinei.componentes.componente_edittext.pojos.SPEditText;
import pe.com.ricindigus.generadorinei.componentes.componente_formulario.modelo.DataFormulario;
import pe.com.ricindigus.generadorinei.componentes.componente_formulario.pojos.Formulario;
import pe.com.ricindigus.generadorinei.componentes.componente_formulario.FormularioFragment;
import pe.com.ricindigus.generadorinei.componentes.componente_formulario.pojos.SPFormulario;
import pe.com.ricindigus.generadorinei.componentes.componente_gps.modelo.DataGPS;
import pe.com.ricindigus.generadorinei.componentes.componente_gps.pojos.GPS;
import pe.com.ricindigus.generadorinei.componentes.componente_gps.GPSFragment;
import pe.com.ricindigus.generadorinei.componentes.componente_radio.modelo.DataRadio;
import pe.com.ricindigus.generadorinei.componentes.componente_radio.pojos.PRadio;
import pe.com.ricindigus.generadorinei.componentes.componente_radio.RadioFragment;
import pe.com.ricindigus.generadorinei.componentes.componente_radio.pojos.SPRadio;
import pe.com.ricindigus.generadorinei.componentes.componente_ubicacion.modelo.DataUbicacion;
import pe.com.ricindigus.generadorinei.componentes.componente_ubicacion.pojos.Ubicacion;
import pe.com.ricindigus.generadorinei.componentes.componente_ubicacion.UbicacionFragment;
import pe.com.ricindigus.generadorinei.componentes.componente_visitas.modelo.DataVisitas;
import pe.com.ricindigus.generadorinei.componentes.componente_visitas.pojos.Visita;
import pe.com.ricindigus.generadorinei.constantesglobales.TipoComponente;
import pe.com.ricindigus.generadorinei.R;
import pe.com.ricindigus.generadorinei.adapters.ExpandListAdapter;
import pe.com.ricindigus.generadorinei.componentes.componente_edittext.pojos.PEditText;
import pe.com.ricindigus.generadorinei.componentes.componente_edittext.EditTextFragment;
import pe.com.ricindigus.generadorinei.fragments.NombreSeccionFragment;
import pe.com.ricindigus.generadorinei.componentes.componente_visitas.VisitasFragment;
import pe.com.ricindigus.generadorinei.modelo.DataSourceCaptura.Data;
import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.DataComponentes;
import pe.com.ricindigus.generadorinei.modelo.DataSourceTablasGuardado.DataTablas;
import pe.com.ricindigus.generadorinei.pojos.Controlador;
import pe.com.ricindigus.generadorinei.pojos.Evento;
import pe.com.ricindigus.generadorinei.pojos.Modulo;
import pe.com.ricindigus.generadorinei.pojos.Pagina;
import pe.com.ricindigus.generadorinei.pojos.InfoTabla;
import pe.com.ricindigus.generadorinei.pojos.Pregunta;
import pe.com.ricindigus.generadorinei.pojos.Variable;

public class EncuestaActivity extends AppCompatActivity implements ActividadInterfaz {
    private ArrayList<String> listDataHeader;
    private ExpandableListView expListView;
    private HashMap<String, List<String>> listDataChild;
    private ExpandListAdapter listAdapter;
    private Button btnAtras;
    private Button btnSiguiente;
    private String idModuloActual = "";
    private int posicionFragment = 1;
    private Fragment fragmentActual = new Fragment();
    private Fragment fragmentComponente = new Fragment();
    private String idEmpresa = "";
    private String idUsuario = "";
    private String tituloEncuesta = "";
    private String nombreSeccionActual = "";
    private Data data;
    private DataComponentes dataComponentes;
    private DataVisitas dataVisitas;
    private DataUbicacion dataUbicacion;
    private DataFormulario dataFormulario;
    private DataEditText dataEditText;
    private DataCheckBox dataCheckBox;
    private DataRadio dataRadio;
    private DataGPS dataGPS;
    private ContentValues contentPaginador;
    private ContentValues contentControlador;


    private View lytFocus;
    private Toolbar toolbar;
    private LinearLayout  lytComponente1, lytComponente2, lytComponente3, lytComponente4, lytComponente5,
            lytComponente6, lytComponente7, lytComponente8, lytComponente9, lytComponente10, layoutScrolleable;
    private int numeroPaginasTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuesta);
        toolbar = (Toolbar) findViewById(R.id.toolbar_encuesta);
        btnAtras = (Button) findViewById(R.id.btn_anterior);
        btnSiguiente = (Button) findViewById(R.id.btn_siguiente);
        layoutScrolleable = (LinearLayout) findViewById(R.id.layout_componente_scrolleable);
        lytFocus =  findViewById(R.id.layout_focus);
        lytComponente1 = (LinearLayout) findViewById(R.id.layout_componente1);
        lytComponente2 = (LinearLayout) findViewById(R.id.layout_componente2);
        lytComponente3 = (LinearLayout) findViewById(R.id.layout_componente3);
        lytComponente4 = (LinearLayout) findViewById(R.id.layout_componente4);
        lytComponente5 = (LinearLayout) findViewById(R.id.layout_componente5);
        lytComponente6 = (LinearLayout) findViewById(R.id.layout_componente6);
        lytComponente7 = (LinearLayout) findViewById(R.id.layout_componente7);
        lytComponente8 = (LinearLayout) findViewById(R.id.layout_componente8);
        lytComponente9 = (LinearLayout) findViewById(R.id.layout_componente9);
        lytComponente10 = (LinearLayout) findViewById(R.id.layout_componente10);

        setSupportActionBar(toolbar);


        DataTablas d = new DataTablas(this);
        d.open();
        d.close();

        final Bundle recupera = getIntent().getExtras();
        if (recupera != null) {
            idEmpresa = recupera.getString("idEmpresa");
            tituloEncuesta = recupera.getString("tituloEncuesta");
            idUsuario = recupera.getString("idUsuario");


        }


        dataComponentes = new DataComponentes(getApplicationContext());
        dataComponentes.open();
        numeroPaginasTotal = (int) dataComponentes.getNumeroItemsPaginas();
        dataComponentes.close();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);
        TextView txtHeaderTitulo = (TextView) headerView.findViewById(R.id.header_txtTituloEncuesta);
        TextView txtHeaderUsuario = (TextView) headerView.findViewById(R.id.header_txtUsuario);
        txtHeaderTitulo.setText(tituloEncuesta);
        txtHeaderUsuario.setText("Usuario: "+idUsuario);
//        getSupportActionBar().setTitle(tituloEncuesta);
        enableExpandableList();

        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ocultarTeclado(btnAtras);
                if (posicionFragment - 1 >= 1) {
                    do{
                        posicionFragment--;
                    }while(!validoSetearPagina(posicionFragment));
                    setPagina(posicionFragment, -1);
                    setNombreSeccion(posicionFragment, -1);
                }

            }
        });

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ocultarTeclado(btnSiguiente);
                if (validarPagina(posicionFragment)) {
                    guardarPagina(posicionFragment);
                    do{
                        if (posicionFragment + 1 <= numeroPaginasTotal) posicionFragment++;
                        else posicionFragment = 1;
                    }while(!validoSetearPagina(posicionFragment));
                    setPagina(posicionFragment, 1);
                    setNombreSeccion(posicionFragment, 1);
                }
            }
        });

        setNombreSeccion(1, 1);
        setPagina(1, 1);
    }

    public boolean validoSetearPagina(int pagina){
        boolean correcto = false;
        DataComponentes dataComponentes = new DataComponentes(getApplicationContext());
        dataComponentes.open();
        DataTablas dataTablas = new DataTablas(EncuestaActivity.this);
        dataTablas.open();
        Data d = new Data(this);
        d.open();
        d.deleteAllControladores();
        ArrayList<Evento> eventos =  new ArrayList<Evento>();
        eventos = dataComponentes.getEventos(pagina+"");
        if(eventos.size() > 0){
            for (Evento e : eventos){
                if(e.getACCION().equals("0")){
                    String variable = e.getVAR();
                    String valor = e.getVAL();
                    String modulo = dataComponentes.getPagina(pagina + "").getMODULO();
                    if(dataTablas.getValor(modulo,variable,idEmpresa).equals(valor)){
                        String idControlador = idEmpresa + e.getIDPREGB() + variable;
                        d.insertarControlador(new Controlador(idControlador,idEmpresa,e.getIDPAGB(),e.getIDPREGB(),variable));
                    }
                }
            }
        }
        ArrayList<Pregunta> preguntas = dataComponentes.getPreguntasXPagina(pagina+"");
        for (Pregunta p : preguntas){
            if(!d.existeControladorPagina(p.get_id())) correcto = true;
        }
        dataTablas.close();
        dataComponentes.close();
        d.close();
        return correcto;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_encuesta, menu);
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.clear();
        DataComponentes dtc = new DataComponentes(this);
        dtc.open();
        String mod = dtc.getPagina(posicionFragment + "").getMODULO();
        dtc.close();
        int num = 0;
        try {
            num = Integer.parseInt(mod);
        } catch (NumberFormatException e) {
        }
        if (num != 0) getMenuInflater().inflate(R.menu.menu_encuesta, menu);
        else getMenuInflater().inflate(R.menu.menu_simple, menu);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        final int id = item.getItemId();
        if (id == R.id.volver_marco || id == R.id.action_marco_simple) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("¿Está seguro que desea volver al marco y salir de la encuesta?")
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
                                    finish();
                                }
                            });
            AlertDialog alert = builder.create();
            alert.show();
            return true;
        }
        if (id == R.id.registrar_observacion) {
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            final View dialogView = this.getLayoutInflater().inflate(R.layout.dialog_observaciones, null);
            LinearLayout lytObservaciones = dialogView.findViewById(R.id.dialog_lytObservaciones);
            final EditText edtObservaciones = dialogView.findViewById(R.id.dialog_edtObservaciones);
            edtObservaciones.setFilters(new InputFilter[]{new InputFilter.AllCaps()});

            DataComponentes dtc = new DataComponentes(this);
            dtc.open();
            String mod = dtc.getPagina(posicionFragment + "").getMODULO();
            InfoTabla infoTabla = dtc.getInfoTablaxModulo(mod);
            dtc.close();
            final String idTabla = infoTabla.getID();
            DataTablas dT = new DataTablas(this);
            dT.open();
            String obs = dT.getValor(idTabla, "OBS", idEmpresa);
            dT.close();
            final String observaciones = obs;
            dialog.setView(dialogView);
            dialog.setTitle("OBSERVACIONES " + infoTabla.getNOMBRE_XML());
            dialog.setPositiveButton("Guardar", null);
            dialog.setNegativeButton("Cancelar", null);
            final AlertDialog alertDialog = dialog.create();
            alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
                @Override
                public void onShow(DialogInterface dialogInterface) {
                    edtObservaciones.setText(observaciones);
                    Button b = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
                    b.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            // TODO Do something
                            DataTablas dT = new DataTablas(EncuestaActivity.this);
                            dT.open();
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("OBS", edtObservaciones.getText().toString());
                            if (dT.existenDatos(idTabla, idEmpresa))
                                dT.actualizarValores(idTabla, idEmpresa, contentValues);
                            else dT.insertarValores(idTabla, contentValues);
                            dT.close();
                            alertDialog.dismiss();
                        }
                    });
                }
            });
            alertDialog.show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void setNombreSeccion(int nPagina, int direccion) {
        String nombreSeccion = "";
        int numeroDePagina = nPagina;
        dataComponentes = new DataComponentes(getApplicationContext());
        dataComponentes.open();
        String idModulo = dataComponentes.getPagina(numeroDePagina + "").getMODULO();
        if (!idModulo.equals(idModuloActual)) {
            nombreSeccion = dataComponentes.getModulo(idModulo).getTITULO();
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            if (direccion > 0) {
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
            } else {
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right);
            }
            NombreSeccionFragment nombreSeccionFragment = new NombreSeccionFragment(nombreSeccion);
            fragmentTransaction.replace(R.id.textoNombreSeccion, nombreSeccionFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            idModuloActual = idModulo;
        }
        dataComponentes.close();
    }

    public void setPagina(int numeroPagina, int direccion) {
        dataComponentes = new DataComponentes(getApplicationContext());
        dataComponentes.open();
        Pagina pagina = dataComponentes.getPagina(numeroPagina + "");
        ArrayList<Pregunta> preguntas =  dataComponentes.getPreguntasXPagina(numeroPagina + "");
        if(preguntas.size() == 1){
            if (Integer.parseInt(preguntas.get(0).getTIPO()) == TipoComponente.VISITAS) setPaginaVisita(numeroPagina, direccion);
            else setPaginaNormal(numeroPagina, direccion);
        }else setPaginaNormal(numeroPagina, direccion);
        dataComponentes.close();
    }

    public void setPaginaVisita(int numeroPagina, int direccion) {
        layoutScrolleable.setVisibility(View.VISIBLE);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        dataComponentes = new DataComponentes(getApplicationContext());
        dataVisitas = new DataVisitas(getApplicationContext());
        dataComponentes.open();
        dataVisitas.open();

        Pagina pagina = dataComponentes.getPagina(numeroPagina + "");
        ArrayList<Pregunta> preguntas = dataComponentes.getPreguntasXPagina(numeroPagina + "");
        String idComponente = preguntas.get(0).get_id();
        String tipoComponente = preguntas.get(0).getTIPO();
        int layoutComponente = R.id.layout_componente_scrolleable;
        int[] layouts = {R.id.layout_componente1, R.id.layout_componente2, R.id.layout_componente3, R.id.layout_componente4, R.id.layout_componente5,
                R.id.layout_componente6, R.id.layout_componente7, R.id.layout_componente8, R.id.layout_componente9, R.id.layout_componente10};
        for (int i = 0; i < layouts.length; i++) {
            if (fragmentManager.findFragmentById(layouts[i]) != null)
                fragmentTransaction.detach(fragmentManager.findFragmentById(layouts[i]));
        }
        switch (Integer.parseInt(tipoComponente)) {
            case TipoComponente.VISITAS:
                Visita visita = dataVisitas.getVisita(idComponente);
                fragmentComponente = new VisitasFragment(EncuestaActivity.this, idEmpresa, visita);
                break;
        }
        fragmentTransaction.replace(layoutComponente, fragmentComponente, idComponente);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        dataComponentes.close();
        dataVisitas.close();
    }

    public void setPaginaNormal(int numeroPagina, int direccion) {
        dataComponentes = new DataComponentes(getApplicationContext());
        dataComponentes.open();
        DataTablas dataTablas = new DataTablas(EncuestaActivity.this);
        dataTablas.open();
        Data d = new Data(this);
        d.open();
        d.deleteAllControladores();
        ArrayList<Evento> eventos =  new ArrayList<Evento>();
        eventos = dataComponentes.getEventos(numeroPagina+"");
        if(eventos.size() > 0){
            for (Evento e : eventos){
                if(e.getACCION().equals("0")){
                    String variable = e.getVAR();
                    String valor = e.getVAL();
                    String modulo = dataComponentes.getPagina(numeroPagina + "").getMODULO();
                    if(dataTablas.getValor(modulo,variable,idEmpresa).equals(valor)){
                        String idControlador = idEmpresa + e.getIDPREGB() + variable;
                        d.insertarControlador(new Controlador(idControlador,idEmpresa,e.getIDPAGB(),e.getIDPREGB(),variable));
                    }
                }
            }
        }
        dataTablas.close();
        dataComponentes.close();
        d.close();


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (layoutScrolleable.getVisibility() == View.VISIBLE) {
            fragmentTransaction.remove(fragmentManager.findFragmentById(R.id.layout_componente_scrolleable));
            layoutScrolleable.setVisibility(View.GONE);
        }
        dataComponentes = new DataComponentes(getApplicationContext());
        dataUbicacion = new DataUbicacion(getApplicationContext());
        dataFormulario = new DataFormulario(getApplicationContext());
        dataEditText = new DataEditText(getApplicationContext());
        dataCheckBox = new DataCheckBox(getApplicationContext());
        dataRadio = new DataRadio(getApplicationContext());
        dataGPS = new DataGPS(getApplicationContext());
        dataComponentes.open();
        dataUbicacion.open();
        dataFormulario.open();
        dataEditText.open();
        dataCheckBox.open();
        dataRadio.open();
        dataGPS.open();

        Pagina pagina = dataComponentes.getPagina(numeroPagina + "");
        ArrayList<Pregunta> preguntas = dataComponentes.getPreguntasXPagina(numeroPagina + "");
        int[] layouts = {R.id.layout_componente1, R.id.layout_componente2, R.id.layout_componente3, R.id.layout_componente4, R.id.layout_componente5,
                R.id.layout_componente6, R.id.layout_componente7, R.id.layout_componente8, R.id.layout_componente9, R.id.layout_componente10};
        for (int i = 0; i < layouts.length; i++) {
            if (i<preguntas.size()) {
                int tipo = Integer.parseInt(preguntas.get(i).getTIPO());
                switch (tipo) {
                    case TipoComponente.UBICACION:
                        Ubicacion ubicacion = dataUbicacion.getUbicacion(preguntas.get(i).get_id());
                        UbicacionFragment ubicacionFragment = new UbicacionFragment(EncuestaActivity.this, idEmpresa, ubicacion);
                        fragmentComponente = ubicacionFragment;
                        break;
                    case TipoComponente.GPS:
                        GPS gps = dataGPS.getGPS(preguntas.get(i).get_id());
                        GPSFragment gpsFragment = new GPSFragment(EncuestaActivity.this, idEmpresa, gps);

                        fragmentComponente = gpsFragment;
                        break;
                    case TipoComponente.FORMULARIO:
                        Formulario formulario = dataFormulario.getFormulario(preguntas.get(i).get_id());
                        ArrayList<SPFormulario> formularios = dataFormulario.getSPFormularios(preguntas.get(i).get_id());
                        FormularioFragment formularioFragment = new FormularioFragment(formulario, formularios, EncuestaActivity.this, idEmpresa);
                        fragmentComponente = formularioFragment;
                        break;
                    case TipoComponente.EDITTEXT:
                        PEditText pEditText = dataEditText.getPEditText(preguntas.get(i).get_id());
                        ArrayList<SPEditText> spEditTexts = dataEditText.getSPEditTexts(preguntas.get(i).get_id());
                        EditTextFragment editTextFragment = new EditTextFragment(pEditText, spEditTexts, EncuestaActivity.this, idEmpresa);
                        fragmentComponente = editTextFragment;
                        break;
                    case TipoComponente.CHECKBOX:
                        PCheckBox PCheckBox = dataCheckBox.getPCheckbox(preguntas.get(i).get_id());
                        ArrayList<SPCheckBox> spCheckBoxes = dataCheckBox.getSPCheckBoxs(preguntas.get(i).get_id());
                        CheckBoxFragment checkBoxFragment = new CheckBoxFragment(PCheckBox, spCheckBoxes, EncuestaActivity.this, idEmpresa);
                        fragmentComponente = checkBoxFragment;
                        break;
                    case TipoComponente.RADIO:
                        PRadio PRadio = dataRadio.getPRadio(preguntas.get(i).get_id());
                        ArrayList<SPRadio> spRadios = dataRadio.getSPRadios(preguntas.get(i).get_id());
                        RadioFragment radioFragment = new RadioFragment(PRadio, spRadios, EncuestaActivity.this, idEmpresa);
                        fragmentComponente = radioFragment;
                        break;
//                    case TipoComponente.M2P1:
//                        fragmentComponente = new M2P1Fragment();
//                        break;
                }
                fragmentTransaction.replace(layouts[i], fragmentComponente, preguntas.get(i).get_id());
            } else {
                if (fragmentManager.findFragmentById(layouts[i]) != null) {
                    fragmentTransaction.remove(fragmentManager.findFragmentById(layouts[i]));
                }
            }
        }
        dataComponentes.close();
        dataFormulario.close();
        dataUbicacion.close();
        dataEditText.close();
        dataCheckBox.close();
        dataRadio.close();
        dataGPS.close();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public boolean validarPagina(int numeroPagina) {
        boolean valido = true;
        FragmentManager fragmentManager = getSupportFragmentManager();
        dataComponentes = new DataComponentes(getApplicationContext());
        dataComponentes.open();
        Pagina pagina = dataComponentes.getPagina(numeroPagina + "");
//        String[] ids = {pagina.getIDP1(), pagina.getIDP2(), pagina.getIDP3(), pagina.getIDP4(), pagina.getIDP5(),
//                pagina.getIDP6(), pagina.getIDP7(), pagina.getIDP8(), pagina.getIDP9(), pagina.getIDP10()};
        ArrayList<Pregunta> preguntas = dataComponentes.getPreguntasXPagina(numeroPagina + "");
        int indice = 0;
        while (indice<preguntas.size() && valido) {
            ComponenteFragment componenteFragment = (ComponenteFragment) fragmentManager.findFragmentByTag(preguntas.get(indice).get_id());
            valido = componenteFragment.validarDatos();
            indice++;
        }
        dataComponentes.close();
        return valido;
    }

    public void guardarPagina(int numeroPagina) {
        Data data = new Data(this);
        DataComponentes dataComponentes = new DataComponentes(this);
        DataTablas dataTablas = new DataTablas(this);
        dataTablas.open();
        dataComponentes.open();
        data.open();
        ArrayList<Controlador> controladors = data.getControladoresActualizar(numeroPagina+"");
        if(controladors.size() > 0){
            for (Controlador c : controladors){
                for (Variable v : dataComponentes.getVariablesxPregunta(c.getID_PREGUNTA())){
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(v.getID(),"");
                    dataTablas.actualizarValores(v.getTABLA(),idEmpresa,contentValues);
                }
            }
        }
        data.close();
        dataComponentes.close();
        dataTablas.close();
        FragmentManager fragmentManager = getSupportFragmentManager();
        dataComponentes = new DataComponentes(getApplicationContext());
        dataComponentes.open();
        Pagina pagina = dataComponentes.getPagina(numeroPagina + "");
//        String[] ids = {pagina.getIDP1(), pagina.getIDP2(), pagina.getIDP3(), pagina.getIDP4(), pagina.getIDP5(),
//                pagina.getIDP6(), pagina.getIDP7(), pagina.getIDP8(), pagina.getIDP9(), pagina.getIDP10()};
//
        ArrayList<Pregunta> preguntas = dataComponentes.getPreguntasXPagina(numeroPagina + "");
        int indice = 0;
        while (indice < preguntas.size()) {
            ComponenteFragment componenteFragment = (ComponenteFragment) fragmentManager.findFragmentByTag(preguntas.get(indice).get_id());
            componenteFragment.guardarDatos();
            indice++;
        }
        dataComponentes.close();
    }

    public void ocultarTeclado(View view) {
        InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    @SuppressLint("NewApi")
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == event.KEYCODE_BACK) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("¿Está seguro que desea volver al marco y salir de la encuesta?")
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
                                    finish();
                                }
                            });
            AlertDialog alert = builder.create();
            alert.show();
        }
        return super.onKeyDown(keyCode, event);
    }


    private void enableExpandableList() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();
        expListView = (ExpandableListView) findViewById(R.id.left_drawer);

        prepareListData(listDataHeader, listDataChild);
        listAdapter = new ExpandListAdapter(this, listDataHeader, listDataChild);
        expListView.setAdapter(listAdapter);

        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                DataComponentes dataComp = new DataComponentes(EncuestaActivity.this);
                dataComp.open();
                ArrayList<Modulo> modulos = dataComp.getAllModulos();
                Modulo m = modulos.get(groupPosition);
                ArrayList<Pagina> paginas = dataComp.getPaginasxModulo(m.getID());
                int numPagina = Integer.parseInt(paginas.get(childPosition).get_id());
                if (numPagina < posicionFragment) setNombreSeccion(numPagina, -1);
                else setNombreSeccion(numPagina, 1);
                setPagina(numPagina, 1);
                posicionFragment = numPagina;
                dataComp.close();
                return false;
            }
        });
    }

    private void prepareListData(List<String> listDataHeader, Map<String, List<String>> listDataChild) {
        dataComponentes = new DataComponentes(this);
        dataComponentes.open();
        ArrayList<Modulo> modulos = dataComponentes.getAllModulos();
        for (Modulo m : modulos) {
            //pone la cabecera
            listDataHeader.add(m.getCABECERA());
            ArrayList<Pagina> paginas = dataComponentes.getPaginasxModulo(m.getID());
            List<String> subItems = new ArrayList<String>();
            //busca los subtitulos
            for (Pagina p : paginas) {
                ArrayList<Pregunta> preguntas = dataComponentes.getPreguntasXPagina(p.get_id());
                String subTitulo = "";
                if (preguntas.size() == 1)
                    subTitulo = "Modulo " + p.getMODULO() + ": P" + preguntas.get(0).getNUMERO();
                else subTitulo = "Modulo " + p.getMODULO() + ": P" + preguntas.get(0).getNUMERO() +
                        " - P" + preguntas.get((preguntas.size() - 1)).getNUMERO();
                subItems.add(subTitulo);
            }
            //agrega cabecera y subtitulos
            listDataChild.put(listDataHeader.get(listDataHeader.size() - 1), subItems);
        }
        dataComponentes.close();
    }

    public String getNumPregunta(String idP) {
        String codigo = idP.substring(idP.indexOf("P") + 1);
        return codigo;
    }

    @Override
    public void realizarEvento(String variable, String valor, boolean cargandoDatos) {
        DataComponentes dataComponentes = new DataComponentes(EncuestaActivity.this);
        dataComponentes.open();
        Data dat = new Data(this);
        dat.open();
        DataTablas dataTablas = new DataTablas(this);
        dataTablas.open();
        ArrayList<Evento> eventos = dataComponentes.getEventos(variable,valor);
        if(!cargandoDatos){
            for (Evento evento : eventos) {
                if(evento.getACCION().equals("1")) {
                    String idControlador = idEmpresa+evento.getIDPREGB()+evento.getVAR();
                    if(dat.existeControlador(idControlador)) dat.eliminarControlador(idControlador);
                    ComponenteFragment componenteFragment = (ComponenteFragment)getSupportFragmentManager().findFragmentByTag(evento.getIDPREGB());
                    if(componenteFragment != null){
                        if (dat.getNumeroControladores(idEmpresa,evento.getIDPREGB()) == 0) componenteFragment.habilitar();
                    }
                }
                else {
                    String idControlador = idEmpresa+evento.getIDPREGB()+evento.getVAR();
                    if(!dat.existeControlador(idControlador))dat.insertarControlador(new Controlador(idControlador,idEmpresa,evento.getIDPAGB(),evento.getIDPREGB(),evento.getVAR()));
                    ComponenteFragment componenteFragment = (ComponenteFragment)getSupportFragmentManager().findFragmentByTag(evento.getIDPREGB());
                    if(componenteFragment != null) componenteFragment.inhabilitar();
                }
            }
        }


        dataComponentes.close();
        dat.close();
    }

    @Override
    public boolean existeEvento(String variable) {
        boolean existe = false;
        DataComponentes dataComponentes = new DataComponentes(EncuestaActivity.this);
        dataComponentes.open();
        existe = dataComponentes.existeEvento(variable);
        dataComponentes.close();
        return existe;
    }


}

