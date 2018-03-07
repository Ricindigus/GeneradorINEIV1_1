package pe.com.ricindigus.generadorinei.activities;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.R;
import pe.com.ricindigus.generadorinei.componentes.componente_checkbox.modelo.DataCheckBox;
import pe.com.ricindigus.generadorinei.componentes.componente_checkbox.pojos.PCheckBox;
import pe.com.ricindigus.generadorinei.componentes.componente_checkbox.CheckBoxPullParser;
import pe.com.ricindigus.generadorinei.componentes.componente_checkbox.pojos.SPCheckBox;
import pe.com.ricindigus.generadorinei.componentes.componente_edittext.modelo.DataEditText;
import pe.com.ricindigus.generadorinei.componentes.componente_edittext.pojos.PEditText;
import pe.com.ricindigus.generadorinei.componentes.componente_edittext.EditTextPullParser;
import pe.com.ricindigus.generadorinei.componentes.componente_edittext.pojos.SPEditText;
import pe.com.ricindigus.generadorinei.componentes.componente_formulario.DataFormulario;
import pe.com.ricindigus.generadorinei.componentes.componente_formulario.Formulario;
import pe.com.ricindigus.generadorinei.componentes.componente_formulario.FormularioPullParser;
import pe.com.ricindigus.generadorinei.componentes.componente_formulario.SPFormulario;
import pe.com.ricindigus.generadorinei.componentes.componente_gps.modelo.DataGPS;
import pe.com.ricindigus.generadorinei.componentes.componente_gps.pojos.GPS;
import pe.com.ricindigus.generadorinei.componentes.componente_gps.GPSPullParser;
import pe.com.ricindigus.generadorinei.componentes.componente_radio.modelo.DataRadio;
import pe.com.ricindigus.generadorinei.componentes.componente_radio.pojos.PRadio;
import pe.com.ricindigus.generadorinei.componentes.componente_radio.RadioPullParser;
import pe.com.ricindigus.generadorinei.componentes.componente_radio.pojos.SPRadio;
import pe.com.ricindigus.generadorinei.componentes.componente_radio.SPRadioPullParser;
import pe.com.ricindigus.generadorinei.componentes.componente_ubicacion.modelo.DataUbicacion;
import pe.com.ricindigus.generadorinei.componentes.componente_ubicacion.pojos.Ubicacion;
import pe.com.ricindigus.generadorinei.componentes.componente_ubicacion.UbicacionPullParser;
import pe.com.ricindigus.generadorinei.componentes.componente_visitas.modelo.DataVisitas;
import pe.com.ricindigus.generadorinei.componentes.componente_visitas.pojos.Visita;
import pe.com.ricindigus.generadorinei.componentes.componente_visitas.VisitaPullParser;
import pe.com.ricindigus.generadorinei.modelo.DataSourceCaptura.Data;
import pe.com.ricindigus.generadorinei.modelo.DataSourceCaptura.SQLConstantes;
import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.DataComponentes;
import pe.com.ricindigus.generadorinei.modelo.DataSourceTablasGuardado.DataTablas;
import pe.com.ricindigus.generadorinei.parser.EncuestaPullParser;
import pe.com.ricindigus.generadorinei.parser.EventosPullParser;
import pe.com.ricindigus.generadorinei.parser.MarcoPullParser;
import pe.com.ricindigus.generadorinei.parser.ModuloPullParser;
import pe.com.ricindigus.generadorinei.parser.OpcionSpinnerPullParser;
import pe.com.ricindigus.generadorinei.parser.PaginaPullParser;
import pe.com.ricindigus.generadorinei.parser.TablasPullParser;
import pe.com.ricindigus.generadorinei.parser.UbigeoPullParser;
import pe.com.ricindigus.generadorinei.parser.UsuariosPullParser;
import pe.com.ricindigus.generadorinei.parser.VariablesPullParser;
import pe.com.ricindigus.generadorinei.pojos.Encuesta;
import pe.com.ricindigus.generadorinei.pojos.Evento;
import pe.com.ricindigus.generadorinei.pojos.Marco;
import pe.com.ricindigus.generadorinei.pojos.Modulo;
import pe.com.ricindigus.generadorinei.pojos.OpcionSpinner;
import pe.com.ricindigus.generadorinei.pojos.Pagina;
import pe.com.ricindigus.generadorinei.pojos.Tabla;
import pe.com.ricindigus.generadorinei.pojos.Ubigeo;
import pe.com.ricindigus.generadorinei.pojos.Usuario;
import pe.com.ricindigus.generadorinei.pojos.Variable;

public class SplashActivity extends AppCompatActivity {

    TextView txtMensaje;
    ProgressBar progressBar;
    ProgressBar progressBar1;
    ArrayList<Marco> marcos = new ArrayList<Marco>();
    ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    ArrayList<Ubigeo> ubigeos = new ArrayList<Ubigeo>();
    ArrayList<Modulo> modulos = new ArrayList<Modulo>();
    ArrayList<Visita> visitas = new ArrayList<Visita>();
    ArrayList<Ubicacion> ubicaciones = new ArrayList<Ubicacion>();
    ArrayList<GPS> gpsArrayList = new ArrayList<GPS>();
    ArrayList<Formulario> formularios = new ArrayList<Formulario>();
    ArrayList<SPFormulario> spFormularios = new ArrayList<SPFormulario>();
    ArrayList<PEditText> pEditTexts = new ArrayList<PEditText>();
    ArrayList<SPEditText> spEditTexts = new ArrayList<SPEditText>();
    ArrayList<PCheckBox> pCheckBoxes = new ArrayList<PCheckBox>();
    ArrayList<SPCheckBox> spCheckBoxes  = new ArrayList<SPCheckBox>();
    ArrayList<PRadio> pRadios = new ArrayList<PRadio>();
    ArrayList<SPRadio> spRadios = new ArrayList<SPRadio>();
    ArrayList<Pagina> paginas = new ArrayList<Pagina>();
    ArrayList<OpcionSpinner> opciones = new ArrayList<OpcionSpinner>();
    ArrayList<Tabla> tablas = new ArrayList<Tabla>();
    ArrayList<Evento> eventos = new ArrayList<Evento>();
    ArrayList<Variable> variables = new ArrayList<Variable>();
    ArrayList<Encuesta> encuestas = new ArrayList<Encuesta>();



    Data data;
    DataComponentes dataComponentes;
    DataVisitas dataVisitas;
    DataUbicacion dataUbicacion;
    DataGPS dataGPS;
    DataFormulario dataFormulario;
    DataEditText dataEditText;
    DataCheckBox dataCheckBox;
    DataRadio dataRadio;
    DataTablas dataTablas;


    int maximo = 0;
    double carga = 0.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        txtMensaje = (TextView) findViewById(R.id.splash_mensaje);
        progressBar = (ProgressBar) findViewById(R.id.marco_progreso2);
        progressBar1 = (ProgressBar) findViewById(R.id.marco_progreso1);


        data = new Data(getApplicationContext());
        data.open();
        long items1 = data.getNumeroItemsMarco();
        data.close();
        if(items1 == 0){
            MarcoPullParser marcoPullParser = new MarcoPullParser();
            UsuariosPullParser usuarioParser = new UsuariosPullParser();
            VisitaPullParser visitaPullParser = new VisitaPullParser();
            UbigeoPullParser ubigeoPullParser = new UbigeoPullParser();
            ModuloPullParser moduloPullParser = new ModuloPullParser();
            UbicacionPullParser ubicacionPullParser = new UbicacionPullParser();
            GPSPullParser gpsPullParser = new GPSPullParser();
            FormularioPullParser formularioPullParser = new FormularioPullParser();
            EditTextPullParser editTextPullParser = new EditTextPullParser();
            CheckBoxPullParser checkBoxPullParser = new CheckBoxPullParser();
            RadioPullParser radioPullParser = new RadioPullParser();
            SPRadioPullParser spRadioPullParser = new SPRadioPullParser();
            PaginaPullParser paginaPullParser = new PaginaPullParser();
            OpcionSpinnerPullParser opcionSpinnerPullParser = new OpcionSpinnerPullParser();
            TablasPullParser tablasPullParser = new TablasPullParser();
            EventosPullParser eventosPullParser = new EventosPullParser();
            VariablesPullParser variablesPullParser = new VariablesPullParser();
            EncuestaPullParser encuestaPullParser = new EncuestaPullParser();



            marcos = marcoPullParser.parseXML(getApplicationContext());
            usuarios = usuarioParser.parseXML(getApplicationContext());
            ubigeos = ubigeoPullParser.parseXML(getApplicationContext());
            modulos = moduloPullParser.parseXML(getApplicationContext());
            visitas = visitaPullParser.parseXML(getApplicationContext());
            ubicaciones = ubicacionPullParser.parseXML(getApplicationContext());
            gpsArrayList = gpsPullParser.parseXML(getApplicationContext());
            formularios = formularioPullParser.parseXMLFormulario(getApplicationContext());
            spFormularios = formularioPullParser.parseXMLSPFormulario(getApplicationContext());
            pEditTexts = editTextPullParser.parseXMLPEditText(getApplicationContext());
            spEditTexts = editTextPullParser.parseXMLSPEditText(getApplicationContext());
            pCheckBoxes = checkBoxPullParser.parseXMLPCheckBox(getApplicationContext());
            spCheckBoxes = checkBoxPullParser.parseXMLSPCheckBox(getApplicationContext());
            pRadios = radioPullParser.parseXMLPRadio(getApplicationContext());
            spRadios = spRadioPullParser.parseXML(getApplicationContext());
            paginas = paginaPullParser.parseXML(getApplicationContext());
            opciones = opcionSpinnerPullParser.parseXML(getApplicationContext());
            tablas = tablasPullParser.parseXML(getApplicationContext());
            eventos = eventosPullParser.parseXML(getApplicationContext());
            variables = variablesPullParser.parseXML(getApplicationContext());
            encuestas = encuestaPullParser.parseXML(getApplicationContext());
        }

        maximo = marcos.size() + usuarios.size() + ubigeos.size() + modulos.size() + visitas.size()+
                + ubicaciones.size() + gpsArrayList.size() + formularios.size()
                + pEditTexts.size() + spEditTexts.size()
                + pCheckBoxes.size() + spCheckBoxes.size()
                + pRadios.size() + spRadios.size() + encuestas.size()
                + paginas.size() + opciones.size() + tablas.size() + eventos.size() + variables.size() ;
        carga = (maximo*1.00)/100.00;

        progressBar.setMax(maximo);
        progressBar.setVisibility(View.GONE);
        progressBar1.setMax(maximo);
        progressBar1.setVisibility(View.GONE);
        new MyAsyncTask().execute(0);
    }

    public class MyAsyncTask extends AsyncTask<Integer,Integer,String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
            progressBar1.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(Integer... integers) {
            String mensaje = "";
            String mensaje1 = "";
            int i = 1;
            dataComponentes = new DataComponentes(getApplicationContext());
            dataComponentes.open();
            data = new Data(getApplicationContext());
            data.open();
            dataVisitas = new DataVisitas(getApplicationContext());
            dataVisitas.open();
            dataUbicacion = new DataUbicacion(getApplicationContext());
            dataUbicacion.open();
            dataGPS = new DataGPS(getApplicationContext());
            dataGPS.open();
            dataFormulario =new DataFormulario(getApplicationContext());
            dataFormulario.open();
            dataEditText = new DataEditText(getApplicationContext());
            dataEditText.open();
            dataCheckBox = new DataCheckBox(getApplicationContext());
            dataCheckBox.open();
            dataRadio = new DataRadio(getApplicationContext());
            dataRadio.open();
            dataTablas = new DataTablas(getApplicationContext());
            dataTablas.open();


            long items = data.getNumeroItemsMarco();
            if(items == 0){
                for (Encuesta encuesta : encuestas) {
                    try {
                        dataComponentes.insertarEncuesta(encuesta);
                    }catch (SQLiteException e){
                        e.printStackTrace();
                    }
                    publishProgress(i,(int)Math.floor(i/carga));
                    i++;
                }
                for (Marco marco : marcos) {
                    try {
                        data.insertarMarco(marco);
                    }catch (SQLiteException e){
                        e.printStackTrace();
                    }
                    publishProgress(i,(int)Math.floor(i/carga));
                    i++;
                }
                for (Usuario usuario : usuarios) {
                    try {
                        data.insertarUsuario(usuario);
                    }catch (SQLiteException e){
                        e.printStackTrace();
                    }
                    publishProgress(i,(int)Math.floor(i/carga));
                    i++;
                }
                for (Ubigeo ubigeo : ubigeos) {
                    try {
                        data.insertarUbigeo(ubigeo);
                    }catch (SQLiteException e){
                        e.printStackTrace();
                    }
                    publishProgress(i,(int)Math.floor(i/carga));
                    i++;
                }
                for (Modulo modulo : modulos) {
                    try {
                        dataComponentes.insertarModulo(modulo);
                    }catch (SQLiteException e){
                        e.printStackTrace();
                    }
                    publishProgress(i,(int)Math.floor(i/carga));
                    i++;
                }
                for (Visita visita : visitas) {
                    try {
                        dataVisitas.insertarVisita(visita);
                    }catch (SQLiteException e){
                        e.printStackTrace();
                    }
                    publishProgress(i,(int)Math.floor(i/carga));
                    i++;
                }
                for (Ubicacion ubicacion : ubicaciones) {
                    try {
                        dataUbicacion.insertarUbicacion(ubicacion);
                    }catch (SQLiteException e){
                        e.printStackTrace();
                    }
                    publishProgress(i,(int)Math.floor(i/carga));
                    i++;
                }
                for (GPS gps : gpsArrayList) {
                    try {
                        dataGPS.insertarGPS(gps);
                    }catch (SQLiteException e){
                        e.printStackTrace();
                    }
                    publishProgress(i,(int)Math.floor(i/carga));
                    i++;
                }
                for (Formulario formulario : formularios) {
                    try {
                        dataFormulario.insertarFormulario(formulario);
                    }catch (SQLiteException e){
                        e.printStackTrace();
                    }
                    publishProgress(i,(int)Math.floor(i/carga));
                    i++;
                }
                for (SPFormulario spFormulario : spFormularios) {
                    try {
                        dataFormulario.insertarSPFormulario(spFormulario);
                    }catch (SQLiteException e){
                        e.printStackTrace();
                    }
                    publishProgress(i,(int)Math.floor(i/carga));
                    i++;
                }
                for (PEditText pEditText : pEditTexts) {
                    try {
                        dataEditText.insertarPOJOEditText(pEditText);
                    }catch (SQLiteException e){
                        e.printStackTrace();
                    }
                    publishProgress(i,(int)Math.floor(i/carga));
                    i++;
                }
                for (SPEditText spEditText : spEditTexts) {
                    try {
                        dataEditText.insertarSPEditText(spEditText);
                    }catch (SQLiteException e){
                        e.printStackTrace();
                    }
                    publishProgress(i,(int)Math.floor(i/carga));
                    i++;
                }
                for (PCheckBox pCheckBox : pCheckBoxes) {
                    try {
                        dataCheckBox.insertarPOJOCheckBox(pCheckBox);
                    }catch (SQLiteException e){
                        e.printStackTrace();
                    }
                    publishProgress(i,(int)Math.floor(i/carga));
                    i++;
                }
                for (SPCheckBox spCheckBox : spCheckBoxes) {
                    try {
                        dataCheckBox.insertarSPCheckBox(spCheckBox);
                    }catch (SQLiteException e){
                        e.printStackTrace();
                    }
                    publishProgress(i,(int)Math.floor(i/carga));
                    i++;
                }
                for (PRadio PRadio : pRadios) {
                    try {
                        dataRadio.insertarPOJORadio(PRadio);
                    }catch (SQLiteException e){
                        e.printStackTrace();
                    }
                    publishProgress(i,(int)Math.floor(i/carga));
                    i++;
                }
                for (SPRadio spRadio : spRadios) {
                    try {
                        dataRadio.insertarSPRadio(spRadio);
                    }catch (SQLiteException e){
                        e.printStackTrace();
                    }
                    publishProgress(i,(int)Math.floor(i/carga));
                    i++;
                }
                for (Pagina pagina : paginas) {
                    try {
                        dataComponentes.insertarPagina(pagina);
                    }catch (SQLiteException e){
                        e.printStackTrace();
                    }
                    publishProgress(i,(int)Math.floor(i/carga));
                    i++;
                }
                for (OpcionSpinner opcionSpinner : opciones) {
                    try {
                        dataComponentes.insertarOpcion(opcionSpinner);
                    }catch (SQLiteException e){
                        e.printStackTrace();
                    }
                    publishProgress(i,(int)Math.floor(i/carga));
                    i++;
                }
                for (Tabla tabla : tablas) {
                    try {
                        data.insertarTabla(tabla);
                    }catch (SQLiteException e){
                        e.printStackTrace();
                    }
                    publishProgress(i,(int)Math.floor(i/carga));
                    i++;
                }
                for (Evento evento : eventos) {
                    try {
                        dataComponentes.insertarEvento(evento);
                    }catch (SQLiteException e){
                        e.printStackTrace();
                    }
                    publishProgress(i,(int)Math.floor(i/carga));
                    i++;
                }
                for (Variable variable : variables) {
                    try {
                        dataComponentes.insertarVariable(variable);
                    }catch (SQLiteException e){
                        e.printStackTrace();
                    }
                    publishProgress(i,(int)Math.floor(i/carga));
                    i++;
                }
                mensaje = "LISTO, BIENVENIDO";
            }else{
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            data.close();
            dataComponentes.close();
            dataVisitas.close();
            dataGPS.close();
            dataUbicacion.close();
            dataFormulario.close();
            dataEditText.close();
            dataCheckBox.close();
            dataRadio.close();
            dataTablas.close();
            return mensaje;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            int contador = values[1];
            String texto = "";
            if(values[0] < marcos.size()) texto = "CARGANDO MARCO " + contador +"%";
            if(values[0] > marcos.size() && values[0] < marcos.size()+usuarios.size()) texto = "CARGANDO USUARIOS " + contador +"%";
            if(values[0] > marcos.size()+usuarios.size() && values[0] < marcos.size()+usuarios.size()+ ubigeos.size()) texto = "CARGANDO UBIGEO " + contador +"%";
            if(values[0] > marcos.size() +usuarios.size() + ubigeos.size() && values[0] < maximo) texto = "CARGANDO ENCUESTA " + contador +"%";
            txtMensaje.setText(texto);
            progressBar.setProgress(values[0]);
            progressBar1.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(String mensaje) {
            super.onPostExecute(mensaje);
            txtMensaje.setText(mensaje);
            progressBar.setVisibility(View.GONE);
            progressBar1.setVisibility(View.GONE);
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }

}
