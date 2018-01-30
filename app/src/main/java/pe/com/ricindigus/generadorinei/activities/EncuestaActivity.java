package pe.com.ricindigus.generadorinei.activities;

import android.annotation.SuppressLint;
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
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pe.com.ricindigus.generadorinei.componentes.componente_checkbox.CheckBoxFragment;
import pe.com.ricindigus.generadorinei.componentes.componente_checkbox.modelo.DataCheckBox;
import pe.com.ricindigus.generadorinei.componentes.componente_checkbox.pojos.PCheckBox;
import pe.com.ricindigus.generadorinei.componentes.componente_checkbox.pojos.SPCheckBox;
import pe.com.ricindigus.generadorinei.componentes.componente_edittext.modelo.DataEditText;
import pe.com.ricindigus.generadorinei.componentes.componente_edittext.pojos.SPEditText;
import pe.com.ricindigus.generadorinei.componentes.componente_formulario.FormularioFragment;
import pe.com.ricindigus.generadorinei.componentes.componente_gps.GPSFragment;
import pe.com.ricindigus.generadorinei.componentes.componente_radio.modelo.DataRadio;
import pe.com.ricindigus.generadorinei.componentes.componente_radio.pojos.PRadio;
import pe.com.ricindigus.generadorinei.componentes.componente_radio.RadioFragment;
import pe.com.ricindigus.generadorinei.componentes.componente_radio.pojos.SPRadio;
import pe.com.ricindigus.generadorinei.componentes.componente_ubicacion.Ubicacion;
import pe.com.ricindigus.generadorinei.componentes.componente_ubicacion.UbicacionFragment;
import pe.com.ricindigus.generadorinei.constantesglobales.TipoComponente;
import pe.com.ricindigus.generadorinei.R;
import pe.com.ricindigus.generadorinei.adapters.ExpandListAdapter;
import pe.com.ricindigus.generadorinei.componentes.componente_edittext.pojos.PEditText;
import pe.com.ricindigus.generadorinei.componentes.componente_edittext.EditTextFragment;
import pe.com.ricindigus.generadorinei.componentes.componente_caratula.CaratulaFragment;
import pe.com.ricindigus.generadorinei.componentes.componente_identificacion.IdentificacionFragment;
import pe.com.ricindigus.generadorinei.fragments.M2P1Fragment;
import pe.com.ricindigus.generadorinei.fragments.NombreSeccionFragment;
import pe.com.ricindigus.generadorinei.componentes.componente_visitas.VisitasFragment;
import pe.com.ricindigus.generadorinei.modelo.DataSourceCaptura.Data;
import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.DataComponentes;
import pe.com.ricindigus.generadorinei.pojos.Pagina;

public class EncuestaActivity extends AppCompatActivity {
    private ArrayList<String> listDataHeader;
    private ExpandableListView expListView;
    private HashMap<String, List<String>> listDataChild;
    private ExpandListAdapter listAdapter;
    private Button btnAtras;
    private Button btnSiguiente;
    private int moduloActual = 0;
    private int posicionFragment = 1;
    private Fragment fragmentActual = new Fragment();
    private Fragment fragmentComponente = new Fragment();
    private String idEmpresa = "";
    private String nombreSeccionActual = "";
    private Data data;
    private DataComponentes dataComponentes;
    private DataEditText dataEditText;
    private DataCheckBox dataCheckBox;
    private DataRadio dataRadio;
    private Toolbar toolbar;
    private LinearLayout lytComponente1, lytComponente2, lytComponente3, lytComponente4, lytComponente5,
            lytComponente6, lytComponente7, lytComponente8, lytComponente9, lytComponente10;
    private int numeroPaginasTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuesta);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        btnAtras = (Button) findViewById(R.id.btn_anterior);
        btnSiguiente = (Button) findViewById(R.id.btn_siguiente);
        lytComponente1 =  (LinearLayout)findViewById(R.id.layout_componente1);
        lytComponente2 =  (LinearLayout)findViewById(R.id.layout_componente2);
        lytComponente3 =  (LinearLayout)findViewById(R.id.layout_componente3);
        lytComponente4 =  (LinearLayout)findViewById(R.id.layout_componente4);
        lytComponente5 =  (LinearLayout)findViewById(R.id.layout_componente5);
        lytComponente6 =  (LinearLayout)findViewById(R.id.layout_componente6);
        lytComponente7 =  (LinearLayout)findViewById(R.id.layout_componente7);
        lytComponente8 =  (LinearLayout)findViewById(R.id.layout_componente8);
        lytComponente9 =  (LinearLayout)findViewById(R.id.layout_componente9);
        lytComponente10 =  (LinearLayout)findViewById(R.id.layout_componente10);

        setSupportActionBar(toolbar);

        final Bundle recupera=getIntent().getExtras();
        if(recupera != null){
            idEmpresa = recupera.getString("idEmpresa");
        }

        dataComponentes = new DataComponentes(getApplicationContext());
        dataComponentes.open();
        numeroPaginasTotal = (int)dataComponentes.getNumeroItemsPaginas();
        dataComponentes.close();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        enableExpandableList();

        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ocultarTeclado(btnAtras);
                if(posicionFragment - 1 >= 1){
                    posicionFragment--;
                    setNombreSeccion(posicionFragment,-1);
                    setPagina(posicionFragment,-1);
                }
            }
        });

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ocultarTeclado(btnSiguiente);
                if(validarPagina(posicionFragment)){
                    guardarPagina(posicionFragment);
                    if(posicionFragment + 1 <= numeroPaginasTotal) posicionFragment++;
                    else posicionFragment = 1;
                    setNombreSeccion(posicionFragment,1);
                    setPagina(posicionFragment,1);
                }
            }
        });
        setNombreSeccion(1,1);
        setPagina(1,1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_encuesta,menu);
        return true;
    }


    public void setNombreSeccion(int nPagina, int direccion){
        String nombreSeccion = "";
        int numeroDePagina = nPagina;
        dataComponentes = new DataComponentes(getApplicationContext());
        dataComponentes.open();
        String mod = dataComponentes.getPagina(numeroDePagina+"").getMODULO();
        if(!mod.equals(moduloActual))nombreSeccion = dataComponentes.getModulo(mod).getTITULO();
        if(!nombreSeccion.equals(nombreSeccionActual)){
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            if(direccion > 0){
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
            }else{
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right);
            }
            NombreSeccionFragment nombreSeccionFragment = new NombreSeccionFragment(nombreSeccion);
            fragmentTransaction.replace(R.id.textoNombreSeccion, nombreSeccionFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            nombreSeccionActual = nombreSeccion;
        }
        dataComponentes.close();
    }

    public void setPagina(int numeroPagina, int direccion){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        dataComponentes = new DataComponentes(getApplicationContext());
        dataEditText = new DataEditText(getApplicationContext());
        dataCheckBox = new DataCheckBox(getApplicationContext());
        dataRadio = new DataRadio(getApplicationContext());
        dataComponentes.open();
        dataEditText.open();
        dataCheckBox.open();
        dataRadio.open();

        Pagina pagina = dataComponentes.getPagina(numeroPagina+"");
        String[] ids = {pagina.getIDP1(), pagina.getIDP2(), pagina.getIDP3(), pagina.getIDP4(), pagina.getIDP5(),
                pagina.getIDP6(), pagina.getIDP7(), pagina.getIDP8(), pagina.getIDP9(), pagina.getIDP10()};
        String[] tipos = {pagina.getTIPO1(),pagina.getTIPO2(),pagina.getTIPO3(),pagina.getTIPO4(),pagina.getTIPO5(),
                pagina.getTIPO6(),pagina.getTIPO7(),pagina.getTIPO8(),pagina.getTIPO9(),pagina.getTIPO10()};
        int[] layouts = {R.id.layout_componente1, R.id.layout_componente2,R.id.layout_componente3,R.id.layout_componente4,R.id.layout_componente5,
                R.id.layout_componente6, R.id.layout_componente7,R.id.layout_componente8,R.id.layout_componente9,R.id.layout_componente10};
        for (int i = 0; i < ids.length; i++) {
            if(!ids[i].equals("")){
                int tipo= Integer.parseInt(tipos[i]);
                switch (tipo){
                    case TipoComponente.VISITAS:
                        fragmentComponente = new VisitasFragment();
                        break;
                    case TipoComponente.UBICACION:
                        fragmentComponente = new UbicacionFragment();
                        break;
                    case TipoComponente.GPS:
                        fragmentComponente = new GPSFragment();
                        break;
                    case TipoComponente.FORMULARIO:
                        fragmentComponente = new FormularioFragment();
                        break;
                    case TipoComponente.EDITTEXT:
                        PEditText pEditText = dataEditText.getPOJOEditText(ids[i]);
                        ArrayList<SPEditText> spEditTexts = dataEditText.getSPEditTexts(ids[i]);
                        fragmentComponente = new EditTextFragment(pEditText,spEditTexts,getApplicationContext(),idEmpresa);
                        break;
                    case TipoComponente.CHECKBOX:
                        PCheckBox PCheckBox = dataCheckBox.getPOJOCheckbox(ids[i]);
                        ArrayList<SPCheckBox> spCheckBoxes = dataCheckBox.getSPCheckBoxs(ids[i]);
                        fragmentComponente = new CheckBoxFragment(PCheckBox,spCheckBoxes,getApplicationContext(),idEmpresa);
                        break;
                    case TipoComponente.RADIO:
                        PRadio PRadio = dataRadio.getPOJORadio(ids[i]);
                        ArrayList<SPRadio> spRadios = dataRadio.getSPRadios(ids[i]);
                        fragmentComponente = new RadioFragment(PRadio,spRadios,getApplicationContext(),idEmpresa);
                        break;
                    case TipoComponente.M2P1:
                        fragmentComponente = new M2P1Fragment();
                        break;
                }
                fragmentTransaction.replace(layouts[i], fragmentComponente,ids[i]);
            }else{
                if(fragmentManager.findFragmentById(layouts[i]) != null) {
                    fragmentTransaction.remove(fragmentManager.findFragmentById(layouts[i]));
                }
            }
        }
        dataComponentes.close();
        dataEditText.close();
        dataCheckBox.close();
        dataRadio.close();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public boolean validarPagina(int numeroPagina){
        boolean valido = true;
        FragmentManager fragmentManager = getSupportFragmentManager();
        dataComponentes = new DataComponentes(getApplicationContext());
        dataComponentes.open();
        Pagina pagina = dataComponentes.getPagina(numeroPagina+"");
        String[] ids = {pagina.getIDP1(), pagina.getIDP2(), pagina.getIDP3(), pagina.getIDP4(), pagina.getIDP5(),
                pagina.getIDP6(), pagina.getIDP7(), pagina.getIDP8(), pagina.getIDP9(), pagina.getIDP10()};
        String[] tipos = {pagina.getTIPO1(),pagina.getTIPO2(),pagina.getTIPO3(),pagina.getTIPO4(),pagina.getTIPO5(),
                pagina.getTIPO6(),pagina.getTIPO7(),pagina.getTIPO8(),pagina.getTIPO9(),pagina.getTIPO10()};
        int indice = 0;
        while(!ids[indice].equals("") && valido){
            Fragment fragment = fragmentManager.findFragmentByTag(ids[indice]);
            switch (Integer.parseInt(tipos[indice])){
                case TipoComponente.VISITAS: valido = valido && ((VisitasFragment)fragment).validarDatos();break;
                case TipoComponente.UBICACION: valido = valido && ((UbicacionFragment)fragment).validarDatos();break;
                case TipoComponente.GPS: valido = valido && ((GPSFragment)fragment).validarDatos();break;
                case TipoComponente.FORMULARIO: valido = valido && ((FormularioFragment)fragment).validarDatos();break;
                case TipoComponente.EDITTEXT: valido = valido && ((EditTextFragment)fragment).validarDatos();break;
                case TipoComponente.CHECKBOX: valido = valido && ((CheckBoxFragment)fragment).validarDatos();break;
                case TipoComponente.RADIO: valido = valido && ((RadioFragment)fragment).validarDatos();break;
            }
            indice++;
        }
        dataComponentes.close();
        return valido;
    }

    public void guardarPagina(int numeroPagina){
        FragmentManager fragmentManager = getSupportFragmentManager();
        dataComponentes = new DataComponentes(getApplicationContext());
        dataComponentes.open();
        Pagina pagina = dataComponentes.getPagina(numeroPagina+"");
        String[] ids = {pagina.getIDP1(), pagina.getIDP2(), pagina.getIDP3(), pagina.getIDP4(), pagina.getIDP5(),
                pagina.getIDP6(), pagina.getIDP7(), pagina.getIDP8(), pagina.getIDP9(), pagina.getIDP10()};
        String[] tipos = {pagina.getTIPO1(),pagina.getTIPO2(),pagina.getTIPO3(),pagina.getTIPO4(),pagina.getTIPO5(),
                pagina.getTIPO6(),pagina.getTIPO7(),pagina.getTIPO8(),pagina.getTIPO9(),pagina.getTIPO10()};
        int indice = 0;
        while(!ids[indice].equals("")){
            Fragment fragment = fragmentManager.findFragmentByTag(ids[indice]);
            switch (Integer.parseInt(tipos[indice])){
                case TipoComponente.VISITAS: ((VisitasFragment)fragment).guardarDatos();break;
                case TipoComponente.UBICACION: ((UbicacionFragment)fragment).guardarDatos();break;
                case TipoComponente.GPS: ((GPSFragment)fragment).guardarDatos();break;
                case TipoComponente.FORMULARIO: ((FormularioFragment)fragment).guardarDatos();break;
                case TipoComponente.EDITTEXT: ((EditTextFragment)fragment).guardarDatos();break;
                case TipoComponente.CHECKBOX: ((CheckBoxFragment)fragment).guardarDatos();break;
                case TipoComponente.RADIO: ((RadioFragment)fragment).guardarDatos();break;
            }
            indice++;
        }
        dataComponentes.close();
    }

    public void ocultarTeclado(View view){
        InputMethodManager mgr = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
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

    //--------------------------------------------------------------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------------------------------------

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
                int posicion = 0;
                switch (groupPosition){
                    case 0:
                        switch (childPosition){
                            case 0:
                                setPagina(childPosition,1);
                                posicionFragment = childPosition;break;
                            case 1:
                                posicionFragment = childPosition;
                                setPagina(childPosition,1);
                                break;
                            case 2:
                                posicionFragment = childPosition;
                                setPagina(childPosition,1);
                                break;
                            case 3:
                                posicionFragment = childPosition;
                                setPagina(childPosition,1);
                                break;
                        }
                        break;
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    case 5:

                        break;
                    case 6:

                        break;
                    case 7:

                        break;
                    case 8:

                        break;
                    case 9:

                        break;
                    case 10:
                        break;
                }
                return false;
            }
        });
    }

    private void prepareListData(List<String> listDataHeader, Map<String, List<String>> listDataChild) {

        // Adding child data
        listDataHeader.add("INICIO");
        listDataHeader.add("MÓDULO I");listDataHeader.add("MÓDULO II");listDataHeader.add("MÓDULO III");
        listDataHeader.add("MÓDULO IV");listDataHeader.add("MÓDULO V");listDataHeader.add("MÓDULO VI");
        listDataHeader.add("MÓDULO VII");listDataHeader.add("MÓDULO VIII");listDataHeader.add("MÓDULO IX");
        listDataHeader.add("MÓDULO X");
        // Adding child data
        List<String> inicio = new ArrayList<String>();
        inicio.add("CONTROL DE VISITA");inicio.add("CARATULA");inicio.add("IDENTIFICACION");

        List<String> modulo1 = new ArrayList<String>();
        modulo1.add("Módulo I: P1 - P4");modulo1.add("Módulo I: P5 - P7");modulo1.add("Módulo I: P8 - P12");

        List<String> modulo2 = new ArrayList<String>();
        modulo2.add("Módulo II: P1 - P5");modulo2.add("Módulo II: P6 - P13");modulo2.add("Módulo II: P14 - P17");
        modulo2.add("Módulo II: P18 - P19");modulo2.add("Módulo II: P20 - P22");modulo2.add("Módulo II: P23 - P25");

        List<String> modulo3 = new ArrayList<String>();
        modulo3.add("Módulo III: P1 - P6");modulo3.add("Módulo III: P7 - P12");

        List<String> modulo4 = new ArrayList<String>();
        modulo4.add("Módulo IV: P1 - P3");modulo4.add("Módulo IV: P4 - P7");modulo4.add("Módulo IV: P8 - P10");

        List<String> modulo5 = new ArrayList<String>();
        modulo5.add("Módulo V: P1");modulo5.add("Módulo V: P2");modulo5.add("Módulo V: P3 - P5");
        modulo5.add("Módulo V: P6 - P8");modulo5.add("Módulo V: P9");modulo5.add("Módulo V: P10");
        modulo5.add("Módulo V: P11");modulo5.add("Módulo V: P12");modulo5.add("Módulo V: P13");
        modulo5.add("Módulo V: P14");modulo5.add("Módulo V: P15");modulo5.add("Módulo V: P16");
        modulo5.add("Módulo V: P17");modulo5.add("Módulo V: P18");modulo5.add("Módulo V: P19");
        modulo5.add("Módulo V: P20");modulo5.add("Módulo V: P21");modulo5.add("Módulo V: P22");
        modulo5.add("Módulo V: P23");modulo5.add("Módulo V: P24");modulo5.add("Módulo V: P25");
        modulo5.add("Módulo V: P26");modulo5.add("Módulo V: P27");

        List<String> modulo6 = new ArrayList<String>();
        modulo6.add("Módulo VI: P1 - P3");modulo6.add("Módulo VI: P4");modulo6.add("Módulo VI: P5");
        modulo6.add("Módulo VI: P6");modulo6.add("Módulo VI: P7 - P8");modulo6.add("Módulo VI: P9 - P10");

        List<String> modulo7 = new ArrayList<String>();
        modulo7.add("Módulo VII: P1 - P4");modulo7.add("Módulo VII: P5 - P7");modulo7.add("Módulo VII: P8");
        modulo7.add("Módulo VII: P9");modulo7.add("Módulo VII: P10 - P14");modulo7.add("Módulo VII: P15 - P17");
        modulo7.add("Módulo VII: P18");modulo7.add("Módulo VII: P19");modulo7.add("Módulo VII: P20 - P33");
        modulo7.add("Módulo VII: P34 - P36");modulo7.add("Módulo VII: P37 - P39");
        modulo7.add("Módulo VII: P40 - P43");modulo7.add("Módulo VII: P44 - P46");

        List<String> modulo8 = new ArrayList<String>();
        modulo8.add("Módulo VIII: Inteligencia Artificial/Aprendizaje Automático");modulo8.add("Módulo VIII: Robótica Avanzada");
        modulo8.add("Módulo VIII: Transporte Autónomo");modulo8.add("Módulo VIII: Manufactura Avanzada");
        modulo8.add("Módulo VIII: Producción con impresión en 3D");modulo8.add("Módulo VIII: Servicios Avanzados en Redes (Computacion en la nube, BIG DATA)");

        List<String> modulo9 = new ArrayList<String>();
        modulo9.add("Módulo IX: P1 - P2");

        List<String> modulo10 = new ArrayList<String>();
        modulo10.add("Módulo X: P1 - P4");

        listDataChild.put(listDataHeader.get(0), inicio);// Header, Child data
        listDataChild.put(listDataHeader.get(1), modulo1);
        listDataChild.put(listDataHeader.get(2), modulo2);
        listDataChild.put(listDataHeader.get(3), modulo3);
        listDataChild.put(listDataHeader.get(4), modulo4);
        listDataChild.put(listDataHeader.get(5), modulo5);
        listDataChild.put(listDataHeader.get(6), modulo6);
        listDataChild.put(listDataHeader.get(7), modulo7);
        listDataChild.put(listDataHeader.get(8), modulo8);
        listDataChild.put(listDataHeader.get(9), modulo9);
        listDataChild.put(listDataHeader.get(10), modulo10);
    }

}
