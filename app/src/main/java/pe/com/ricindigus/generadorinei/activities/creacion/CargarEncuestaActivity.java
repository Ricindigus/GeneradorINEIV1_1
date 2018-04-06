package pe.com.ricindigus.generadorinei.activities.creacion;

import android.database.sqlite.SQLiteException;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.R;
import pe.com.ricindigus.generadorinei.componentes.componente_checkbox.CheckBoxPullParser;
import pe.com.ricindigus.generadorinei.componentes.componente_checkbox.modelo.DataCheckBox;
import pe.com.ricindigus.generadorinei.componentes.componente_checkbox.modelo.SQLCheckBox;
import pe.com.ricindigus.generadorinei.componentes.componente_checkbox.pojos.PCheckBox;
import pe.com.ricindigus.generadorinei.componentes.componente_checkbox.pojos.SPCheckBox;
import pe.com.ricindigus.generadorinei.componentes.componente_edittext.EditTextPullParser;
import pe.com.ricindigus.generadorinei.componentes.componente_edittext.modelo.DataEditText;
import pe.com.ricindigus.generadorinei.componentes.componente_edittext.modelo.SQLEditText;
import pe.com.ricindigus.generadorinei.componentes.componente_edittext.pojos.PEditText;
import pe.com.ricindigus.generadorinei.componentes.componente_edittext.pojos.SPEditText;
import pe.com.ricindigus.generadorinei.componentes.componente_formulario.FormularioPullParser;
import pe.com.ricindigus.generadorinei.componentes.componente_formulario.modelo.DataFormulario;
import pe.com.ricindigus.generadorinei.componentes.componente_formulario.modelo.SQLFormulario;
import pe.com.ricindigus.generadorinei.componentes.componente_formulario.pojos.Formulario;
import pe.com.ricindigus.generadorinei.componentes.componente_formulario.pojos.SPFormulario;
import pe.com.ricindigus.generadorinei.componentes.componente_gps.GPSPullParser;
import pe.com.ricindigus.generadorinei.componentes.componente_gps.modelo.DataGPS;
import pe.com.ricindigus.generadorinei.componentes.componente_gps.modelo.SQLGps;
import pe.com.ricindigus.generadorinei.componentes.componente_gps.pojos.GPS;
import pe.com.ricindigus.generadorinei.componentes.componente_radio.RadioPullParser;
import pe.com.ricindigus.generadorinei.componentes.componente_radio.modelo.DataRadio;
import pe.com.ricindigus.generadorinei.componentes.componente_radio.modelo.SQLRadio;
import pe.com.ricindigus.generadorinei.componentes.componente_radio.pojos.PRadio;
import pe.com.ricindigus.generadorinei.componentes.componente_radio.pojos.SPRadio;
import pe.com.ricindigus.generadorinei.componentes.componente_ubicacion.UbicacionPullParser;
import pe.com.ricindigus.generadorinei.componentes.componente_ubicacion.modelo.DataUbicacion;
import pe.com.ricindigus.generadorinei.componentes.componente_ubicacion.modelo.SQLUbicacion;
import pe.com.ricindigus.generadorinei.componentes.componente_ubicacion.pojos.Ubicacion;
import pe.com.ricindigus.generadorinei.componentes.componente_visitas.VisitaPullParser;
import pe.com.ricindigus.generadorinei.componentes.componente_visitas.modelo.DataVisitas;
import pe.com.ricindigus.generadorinei.componentes.componente_visitas.modelo.SQLVisitas;
import pe.com.ricindigus.generadorinei.componentes.componente_visitas.pojos.Visita;
import pe.com.ricindigus.generadorinei.modelo.DataControladorVersiones.DataVersion;
import pe.com.ricindigus.generadorinei.modelo.DataControladorVersiones.SQLVersion;
import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.DataComponentes;
import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.SQLConstantesComponente;
import pe.com.ricindigus.generadorinei.modelo.DataSourceTablasGuardado.DataTablas;
import pe.com.ricindigus.generadorinei.parser.EncuestaPullParser;
import pe.com.ricindigus.generadorinei.parser.EventosPullParser;
import pe.com.ricindigus.generadorinei.parser.InfoTablasPullParser;
import pe.com.ricindigus.generadorinei.parser.ModuloPullParser;
import pe.com.ricindigus.generadorinei.parser.OpcionSpinnerPullParser;
import pe.com.ricindigus.generadorinei.parser.PaginaPullParser;
import pe.com.ricindigus.generadorinei.parser.VariablesPullParser;
import pe.com.ricindigus.generadorinei.pojos.Encuesta;
import pe.com.ricindigus.generadorinei.pojos.Evento;
import pe.com.ricindigus.generadorinei.pojos.InfoTabla;
import pe.com.ricindigus.generadorinei.pojos.Modulo;
import pe.com.ricindigus.generadorinei.pojos.OpcionSpinner;
import pe.com.ricindigus.generadorinei.pojos.Pagina;
import pe.com.ricindigus.generadorinei.pojos.Variable;

public class CargarEncuestaActivity extends AppCompatActivity {
    TextView txtMensaje;
    ProgressBar progreso;
    Button btnExportar;
    Button btnVolver;

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
    ArrayList<InfoTabla> infoTablas = new ArrayList<InfoTabla>();
    ArrayList<Evento> eventos = new ArrayList<Evento>();
    ArrayList<Variable> variables = new ArrayList<Variable>();
    ArrayList<Encuesta> encuestas = new ArrayList<Encuesta>();


    DataComponentes dataComponentes;
    DataVisitas dataVisitas;
    DataUbicacion dataUbicacion;
    DataGPS dataGPS;
    DataFormulario dataFormulario;
    DataEditText dataEditText;
    DataCheckBox dataCheckBox;
    DataRadio dataRadio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cargar_encuesta);
        txtMensaje = (TextView) findViewById(R.id.cargar_encuesta_txtMensaje);
        progreso = (ProgressBar) findViewById(R.id.cargar_encuesta_progreso);
        btnExportar = (Button) findViewById(R.id.cargar_encuesta_btnCargar);
        btnVolver = (Button) findViewById(R.id.cargar_encuesta_btnVolver);


        progreso.setMax(4200);
        txtMensaje.setVisibility(View.GONE);
        progreso.setVisibility(View.GONE);

        btnExportar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MyAsyncTask().execute(0);
            }
        });
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public class MyAsyncTask extends AsyncTask<Integer,Integer,String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            txtMensaje.setText("Cargando...");
            txtMensaje.setVisibility(View.VISIBLE);
            progreso.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(Integer... integers) {
            VisitaPullParser visitaPullParser = new VisitaPullParser();
            ModuloPullParser moduloPullParser = new ModuloPullParser();
            UbicacionPullParser ubicacionPullParser = new UbicacionPullParser();
            GPSPullParser gpsPullParser = new GPSPullParser();
            FormularioPullParser formularioPullParser = new FormularioPullParser();
            EditTextPullParser editTextPullParser = new EditTextPullParser();
            CheckBoxPullParser checkBoxPullParser = new CheckBoxPullParser();
            RadioPullParser radioPullParser = new RadioPullParser();
            PaginaPullParser paginaPullParser = new PaginaPullParser();
            OpcionSpinnerPullParser opcionSpinnerPullParser = new OpcionSpinnerPullParser();
            InfoTablasPullParser infoTablasPullParser = new InfoTablasPullParser();
            EventosPullParser eventosPullParser = new EventosPullParser();
            VariablesPullParser variablesPullParser = new VariablesPullParser();
            EncuestaPullParser encuestaPullParser = new EncuestaPullParser();

            encuestas = encuestaPullParser.parseXML(getApplicationContext(),"encuesta.xml");
            modulos = moduloPullParser.parseXML(getApplicationContext(),"modulos.xml");
            visitas = visitaPullParser.parseXML(getApplicationContext(),"visitas.xml");
            ubicaciones = ubicacionPullParser.parseXML(getApplicationContext(),"ubicaciones.xml");
            gpsArrayList = gpsPullParser.parseXML(getApplicationContext(),"gps.xml");
            formularios = formularioPullParser.parseXMLFormulario(getApplicationContext(), "preguntas_formulario.xml");
            spFormularios = formularioPullParser.parseXMLSPFormulario(getApplicationContext(),"subpreguntas_formulario.xml");
            pEditTexts = editTextPullParser.parseXMLPEditText(getApplicationContext(),"preguntas_edittext.xml");
            spEditTexts = editTextPullParser.parseXMLSPEditText(getApplicationContext(),"subpreguntas_edittext.xml");
            pCheckBoxes = checkBoxPullParser.parseXMLPCheckBox(getApplicationContext(),"preguntas_checkbox.xml");
            spCheckBoxes = checkBoxPullParser.parseXMLSPCheckBox(getApplicationContext(),"subpreguntas_checkbox.xml");
            pRadios = radioPullParser.parseXMLPRadio(getApplicationContext(),"preguntas_radio.xml");
            spRadios = radioPullParser.parseXMLSPRadio(getApplicationContext(),"subpreguntas_radio.xml");
            paginas = paginaPullParser.parseXML(getApplicationContext(),"paginas.xml");
            opciones = opcionSpinnerPullParser.parseXML(getApplicationContext(),"opciones.xml");
            infoTablas = infoTablasPullParser.parseXML(getApplicationContext(),"infotablas.xml");
            eventos = eventosPullParser.parseXML(getApplicationContext(),"eventos.xml");
            variables = variablesPullParser.parseXML(getApplicationContext(),"variables.xml");

            dataComponentes = new DataComponentes(getApplicationContext());
            dataComponentes.open();
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

//            DataTablas dt = new DataTablas(getApplicationContext());
//            dt.open();
//            infoTablas = dataComponentes.getAllInfoTablas();
//            for (InfoTabla infoTabla:infoTablas) {
//                dt.deleteTabla("modulo"+infoTabla.get_id());
//            }
//            dt.close();

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



            for (Encuesta encuesta : encuestas) {
                try {
                    dataComponentes.insertarEncuesta(encuesta);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
            for (Modulo modulo : modulos) {
                try {
                    dataComponentes.insertarModulo(modulo);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
            for (Visita visita : visitas) {
                try {
                    dataVisitas.insertarVisita(visita);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
            for (Ubicacion ubicacion : ubicaciones) {
                try {
                    dataUbicacion.insertarUbicacion(ubicacion);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
            for (GPS gps : gpsArrayList) {
                try {
                    dataGPS.insertarGPS(gps);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
            for (Formulario formulario : formularios) {
                try {
                    dataFormulario.insertarFormulario(formulario);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
            for (SPFormulario spFormulario : spFormularios) {
                try {
                    dataFormulario.insertarSPFormulario(spFormulario);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
            for (PEditText pEditText : pEditTexts) {
                try {
                    dataEditText.insertarPEditText(pEditText);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
            for (SPEditText spEditText : spEditTexts) {
                try {
                    dataEditText.insertarSPEditText(spEditText);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
            for (PCheckBox pCheckBox : pCheckBoxes) {
                try {
                    dataCheckBox.insertarPCheckBox(pCheckBox);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
            for (SPCheckBox spCheckBox : spCheckBoxes) {
                try {
                    dataCheckBox.insertarSPCheckBox(spCheckBox);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
            for (PRadio PRadio : pRadios) {
                try {
                    dataRadio.insertarPRadio(PRadio);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
            for (SPRadio spRadio : spRadios) {
                try {
                    dataRadio.insertarSPRadio(spRadio);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
            for (Pagina pagina : paginas) {
                try {
                    dataComponentes.insertarPagina(pagina);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
            for (OpcionSpinner opcionSpinner : opciones) {
                try {
                    dataComponentes.insertarOpcion(opcionSpinner);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
            for (InfoTabla infoTabla : infoTablas) {
                try {
                    dataComponentes.insertarInfoTablas(infoTabla);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
            for (Evento evento : eventos) {
                try {
                    dataComponentes.insertarEvento(evento);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
            for (Variable variable : variables) {
                try {
                    dataComponentes.insertarVariable(variable);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
            //CODIGO DE CREACION DE TABLAS
            DataVersion dataVersion = new DataVersion(getApplicationContext());
            dataVersion.open();
            String version = dataVersion.getVersion(SQLVersion.VERSION_BD_TABLAS);
            int nuevaVersion = Integer.parseInt(version) + 1;
            dataVersion.actualizarVersion(SQLVersion.VERSION_BD_TABLAS,nuevaVersion+"");
            DataTablas dataTablas = new DataTablas(getApplicationContext());
            dataTablas.open();
            dataTablas.close();

            dataComponentes.close();
            dataVisitas.close();
            dataGPS.close();
            dataUbicacion.close();
            dataFormulario.close();
            dataEditText.close();
            dataCheckBox.close();
            dataRadio.close();

            return "Listo";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progreso.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(String mensaje) {
            super.onPostExecute(mensaje);
            txtMensaje.setText(mensaje);
            progreso.setVisibility(View.GONE);
            txtMensaje.setVisibility(View.GONE);
            Toast.makeText(CargarEncuestaActivity.this, "Cargado Completo", Toast.LENGTH_SHORT).show();
        }
    }
}
