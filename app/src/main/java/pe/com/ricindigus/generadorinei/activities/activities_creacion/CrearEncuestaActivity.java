package pe.com.ricindigus.generadorinei.activities.activities_creacion;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import pe.com.ricindigus.generadorinei.R;
import pe.com.ricindigus.generadorinei.componentes.componente_checkbox.modelo.SQLCheckBox;
import pe.com.ricindigus.generadorinei.componentes.componente_edittext.modelo.SQLEditText;
import pe.com.ricindigus.generadorinei.componentes.componente_formulario.modelo.SQLFormulario;
import pe.com.ricindigus.generadorinei.componentes.componente_gps.modelo.SQLGps;
import pe.com.ricindigus.generadorinei.componentes.componente_radio.modelo.SQLRadio;
import pe.com.ricindigus.generadorinei.componentes.componente_ubicacion.modelo.SQLUbicacion;
import pe.com.ricindigus.generadorinei.componentes.componente_visitas.modelo.SQLVisitas;
import pe.com.ricindigus.generadorinei.fragments.creacion.EventosFragment;
import pe.com.ricindigus.generadorinei.fragments.creacion.ModulosFragment;
import pe.com.ricindigus.generadorinei.fragments.creacion.PaginasFragment;
import pe.com.ricindigus.generadorinei.fragments.creacion.PreguntasFragment;
import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.DataComponentes;
import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.SQLConstantesComponente;

public class CrearEncuestaActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private String tituloEncuesta;
    private String fragmentTag = "modulos";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_encuesta);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        ModulosFragment modulosFragment = new ModulosFragment(CrearEncuestaActivity.this);
        fragmentTransaction.replace(R.id.fragment_crear_encuesta, modulosFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("¿Desea salir del proceso de creación de encuesta? (Se perderá la información ingresada)")
                    .setTitle("Aviso")
                    .setCancelable(false)
                    .setNegativeButton("Cancelar",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            })
                    .setPositiveButton("Ok",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    DataComponentes dataComponentes = new DataComponentes(CrearEncuestaActivity.this);
                                    dataComponentes.open();
                                    dataComponentes.deleteAllElementosFromTabla(SQLConstantesComponente.tablaEncuestas);
                                    dataComponentes.deleteAllElementosFromTabla(SQLConstantesComponente.tablaModulos);
                                    dataComponentes.deleteAllElementosFromTabla(SQLConstantesComponente.tablaPaginas);
                                    dataComponentes.deleteAllElementosFromTabla(SQLConstantesComponente.tablaEventos);
                                    dataComponentes.deleteAllElementosFromTabla(SQLConstantesComponente.tablaOpcionSpinner);
                                    dataComponentes.deleteAllElementosFromTabla(SQLConstantesComponente.tablaInfoTablas);
                                    dataComponentes.deleteAllElementosFromTabla(SQLConstantesComponente.tablaVariables);
                                    dataComponentes.deleteAllElementosFromTabla(SQLVisitas.tableVisitas);
                                    dataComponentes.deleteAllElementosFromTabla(SQLUbicacion.tablaUbicacion);
                                    dataComponentes.deleteAllElementosFromTabla(SQLGps.tablaGPS);
                                    dataComponentes.deleteAllElementosFromTabla(SQLFormulario.tablaFormulario);
                                    dataComponentes.deleteAllElementosFromTabla(SQLFormulario.tablaSPFormulario);
                                    dataComponentes.deleteAllElementosFromTabla(SQLEditText.tablaEditText);
                                    dataComponentes.deleteAllElementosFromTabla(SQLEditText.tablaSPEditText);
                                    dataComponentes.deleteAllElementosFromTabla(SQLRadio.tablaRadio);
                                    dataComponentes.deleteAllElementosFromTabla(SQLRadio.tablaSPRadio);
                                    dataComponentes.deleteAllElementosFromTabla(SQLCheckBox.tablaCheckBox);
                                    dataComponentes.deleteAllElementosFromTabla(SQLCheckBox.tablaSPCheckBox);
                                    dataComponentes.close();
                                    finish();
                                }
                            });
            AlertDialog alert = builder.create();
            alert.show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.crear_encuesta, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.volver_menu) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        guardarFragment();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        int id = item.getItemId();

        if (id == R.id.nav_modulos) {
            ModulosFragment modulosFragment = new ModulosFragment(CrearEncuestaActivity.this);
            fragmentTransaction.replace(R.id.fragment_crear_encuesta, modulosFragment,"modulos");
        } else if (id == R.id.nav_guardar) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Se guardara la encuesta actual")
                    .setTitle("Aviso")
                    .setCancelable(false)
                    .setNegativeButton("Cancelar",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            })
                    .setPositiveButton("Ok",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    finish();
                                }
                            });
            AlertDialog alert = builder.create();
            alert.show();
        } else if (id == R.id.nav_preguntas) {
            PreguntasFragment preguntasFragment = new PreguntasFragment(CrearEncuestaActivity.this);
            fragmentTransaction.replace(R.id.fragment_crear_encuesta, preguntasFragment,"preguntas");
        } else if (id == R.id.nav_eventos) {
            EventosFragment eventosFragment = new EventosFragment(CrearEncuestaActivity.this);
            fragmentTransaction.replace(R.id.fragment_crear_encuesta, eventosFragment,"eventos");
        }
        fragmentTransaction.commit();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void guardarFragment(){
        if(fragmentTag.equals("modulo")){
            ModulosFragment modulosFragment = (ModulosFragment)getSupportFragmentManager().findFragmentByTag(fragmentTag);

        }else if(fragmentTag.equals("eventos")){
            EventosFragment eventosFragment = (EventosFragment)getSupportFragmentManager().findFragmentByTag(fragmentTag);

        }
    }
}
