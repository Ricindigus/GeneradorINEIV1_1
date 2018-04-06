package pe.com.ricindigus.generadorinei.activities.creacion;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Xml;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.xmlpull.v1.XmlSerializer;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.IOHelper;
import pe.com.ricindigus.generadorinei.R;
import pe.com.ricindigus.generadorinei.componentes.componente_checkbox.modelo.DataCheckBox;
import pe.com.ricindigus.generadorinei.componentes.componente_checkbox.modelo.SQLCheckBox;
import pe.com.ricindigus.generadorinei.componentes.componente_checkbox.pojos.PCheckBox;
import pe.com.ricindigus.generadorinei.componentes.componente_checkbox.pojos.SPCheckBox;
import pe.com.ricindigus.generadorinei.componentes.componente_edittext.modelo.DataEditText;
import pe.com.ricindigus.generadorinei.componentes.componente_edittext.modelo.SQLEditText;
import pe.com.ricindigus.generadorinei.componentes.componente_edittext.pojos.PEditText;
import pe.com.ricindigus.generadorinei.componentes.componente_edittext.pojos.SPEditText;
import pe.com.ricindigus.generadorinei.componentes.componente_formulario.modelo.DataFormulario;
import pe.com.ricindigus.generadorinei.componentes.componente_formulario.modelo.SQLFormulario;
import pe.com.ricindigus.generadorinei.componentes.componente_formulario.pojos.Formulario;
import pe.com.ricindigus.generadorinei.componentes.componente_formulario.pojos.SPFormulario;
import pe.com.ricindigus.generadorinei.componentes.componente_gps.modelo.DataGPS;
import pe.com.ricindigus.generadorinei.componentes.componente_gps.modelo.SQLGps;
import pe.com.ricindigus.generadorinei.componentes.componente_gps.pojos.GPS;
import pe.com.ricindigus.generadorinei.componentes.componente_radio.modelo.DataRadio;
import pe.com.ricindigus.generadorinei.componentes.componente_radio.modelo.SQLRadio;
import pe.com.ricindigus.generadorinei.componentes.componente_radio.pojos.PRadio;
import pe.com.ricindigus.generadorinei.componentes.componente_radio.pojos.SPRadio;
import pe.com.ricindigus.generadorinei.componentes.componente_ubicacion.modelo.DataUbicacion;
import pe.com.ricindigus.generadorinei.componentes.componente_ubicacion.modelo.SQLUbicacion;
import pe.com.ricindigus.generadorinei.componentes.componente_ubicacion.pojos.Ubicacion;
import pe.com.ricindigus.generadorinei.componentes.componente_visitas.modelo.DataVisitas;
import pe.com.ricindigus.generadorinei.componentes.componente_visitas.modelo.SQLVisitas;
import pe.com.ricindigus.generadorinei.componentes.componente_visitas.pojos.Visita;
import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.DataComponentes;
import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.SQLConstantesComponente;
import pe.com.ricindigus.generadorinei.pojos.Encuesta;
import pe.com.ricindigus.generadorinei.pojos.Evento;
import pe.com.ricindigus.generadorinei.pojos.InfoTabla;
import pe.com.ricindigus.generadorinei.pojos.Modulo;
import pe.com.ricindigus.generadorinei.pojos.OpcionSpinner;
import pe.com.ricindigus.generadorinei.pojos.Pagina;
import pe.com.ricindigus.generadorinei.pojos.Variable;

import static android.os.Environment.getExternalStorageDirectory;

public class ExportarEncuestaActivity extends AppCompatActivity {

    TextView txtMensaje;
    ProgressBar progreso;
    Button btnExportar;
    Button btnVolver;
    DataComponentes dataComponentes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exportar_encuesta);
        txtMensaje = (TextView) findViewById(R.id.exportar_encuesta_txtMensaje);
        progreso = (ProgressBar) findViewById(R.id.exportar_encuesta_progreso);
        btnExportar = (Button) findViewById(R.id.exportar_encuesta_btnExportar);
        btnVolver = (Button) findViewById(R.id.exportar_encuesta_btnVolver);

        progreso.setMax(4200);
        txtMensaje.setVisibility(View.GONE);
        progreso.setVisibility(View.GONE);

        btnExportar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MyAsyncTask().execute(100);
            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public void exportarTituloEncuesta(){
        String nombreArchivo = "encuesta.xml";
        XmlSerializer serializer = Xml.newSerializer();
        StringWriter writer = new StringWriter();
        try {
            serializer.setOutput(writer);
            serializer.startDocument("utf-8", true);
            serializer.startTag("", "ENCUESTAS");

            dataComponentes = new DataComponentes(this);
            dataComponentes.open();

            ArrayList<Encuesta> encuestas = dataComponentes.getEncuestas();
            String[] variablesTabla = dataComponentes.getNombreColumnasTabla(SQLConstantesComponente.tablaEncuestas);
            for (Encuesta e : encuestas){
                serializer.startTag("", "ENCUESTA");
                for (String variable : variablesTabla){
                    String valor = dataComponentes.getValorFromTabla(SQLConstantesComponente.tablaEncuestas, variable, e.getID());
                    escribirCampoXml(serializer, variable, valor);
                }
                serializer.endTag("","ENCUESTA");
            }
            dataComponentes.close();
            serializer.endTag("", "ENCUESTAS");
            serializer.endDocument();
            String result = writer.toString();
            File nuevaCarpeta = new File(getExternalStorageDirectory(), "GENERADOR");
            nuevaCarpeta.mkdirs();
            File file = new File(nuevaCarpeta, nombreArchivo);
            IOHelper.writeToFile(file,result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void exportarModulosEncuesta(){
        String nombreArchivo = "modulos.xml";
        XmlSerializer serializer = Xml.newSerializer();
        StringWriter writer = new StringWriter();
        try {
            serializer.setOutput(writer);
            serializer.startDocument("utf-8", true);
            serializer.startTag("", "MODULOS");

            dataComponentes = new DataComponentes(this);
            dataComponentes.open();

            ArrayList<Modulo> modulos = dataComponentes.getAllModulos();
            String[] variablesTabla = dataComponentes.getNombreColumnasTabla(SQLConstantesComponente.tablaModulos);
            for (Modulo m : modulos){
                serializer.startTag("", "MODULO");
                for (String variable : variablesTabla){
                    String valor = dataComponentes.getValorFromTabla(SQLConstantesComponente.tablaModulos, variable, m.getID());
                    escribirCampoXml(serializer, variable, valor);
                }
                serializer.endTag("","MODULO");
            }
            dataComponentes.close();
            serializer.endTag("", "MODULOS");
            serializer.endDocument();
            String result = writer.toString();
            File nuevaCarpeta = new File(getExternalStorageDirectory(), "GENERADOR");
            nuevaCarpeta.mkdirs();
            File file = new File(nuevaCarpeta, nombreArchivo);
            IOHelper.writeToFile(file,result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void exportarPaginasEncuesta(){
        String nombreArchivo = "paginas.xml";
        XmlSerializer serializer = Xml.newSerializer();
        StringWriter writer = new StringWriter();
        try {
            serializer.setOutput(writer);
            serializer.startDocument("utf-8", true);
            serializer.startTag("", "PAGINAS");

            dataComponentes = new DataComponentes(this);
            dataComponentes.open();

            ArrayList<Pagina> paginas = dataComponentes.getAllPaginas();
            String[] variablesTabla = SQLConstantesComponente.ALL_COLUMNS_PAGINAS;
            for (Pagina p : paginas){
                serializer.startTag("", "PAGINA");
                for (String variable : variablesTabla){
                    String valor = dataComponentes.getValorFromTabla(SQLConstantesComponente.tablaPaginas, variable, p.get_id());
                    escribirCampoXml(serializer, variable, valor);
                }
                serializer.endTag("","PAGINA");
            }
            dataComponentes.close();
            serializer.endTag("", "PAGINAS");
            serializer.endDocument();
            String result = writer.toString();
            File nuevaCarpeta = new File(getExternalStorageDirectory(), "GENERADOR");
            nuevaCarpeta.mkdirs();
            File file = new File(nuevaCarpeta, nombreArchivo);
            IOHelper.writeToFile(file,result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void exportarVisitaEncuesta(){
        String nombreArchivo = "visitas.xml";
        XmlSerializer serializer = Xml.newSerializer();
        StringWriter writer = new StringWriter();
        try {
            serializer.setOutput(writer);
            serializer.startDocument("utf-8", true);
            serializer.startTag("", "VISITAS");

            dataComponentes = new DataComponentes(this);
            dataComponentes.open();
            DataVisitas dataVisitas = new DataVisitas(this);
            dataVisitas.open();

            ArrayList<Visita> visitas = dataVisitas.getAllVisitas();
            String[] variablesTabla = SQLVisitas.ALL_COLUMNS_VISITAS;
            for (Visita v : visitas){
                serializer.startTag("", "VISITA");
                for (String variable : variablesTabla){
                    String valor = dataComponentes.getValorFromTabla(SQLVisitas.tableVisitas, variable, v.getID());
                    escribirCampoXml(serializer, variable, valor);
                }
                serializer.endTag("","VISITA");
            }
            dataComponentes.close();
            dataVisitas.close();
            serializer.endTag("", "VISITAS");
            serializer.endDocument();
            String result = writer.toString();
            File nuevaCarpeta = new File(getExternalStorageDirectory(), "GENERADOR");
            nuevaCarpeta.mkdirs();
            File file = new File(nuevaCarpeta, nombreArchivo);
            IOHelper.writeToFile(file,result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void exportarUbicacionEncuesta(){
        String nombreArchivo = "ubicaciones.xml";
        XmlSerializer serializer = Xml.newSerializer();
        StringWriter writer = new StringWriter();
        try {
            serializer.setOutput(writer);
            serializer.startDocument("utf-8", true);
            serializer.startTag("", "UBICACIONES");

            dataComponentes = new DataComponentes(this);
            dataComponentes.open();
            DataUbicacion dataUbicacion = new DataUbicacion(this);
            dataUbicacion.open();
            ArrayList<Ubicacion> ubicacions = dataUbicacion.getAllUbicacion();
            String[] variablesTabla = SQLUbicacion.ALL_COLUMNS_UBICACION;
            for (Ubicacion u : ubicacions){
                serializer.startTag("", "UBICACION");
                for (String variable : variablesTabla){
                    String valor = dataComponentes.getValorFromTabla(SQLUbicacion.tablaUbicacion, variable, u.getID());
                    escribirCampoXml(serializer, variable, valor);
                }
                serializer.endTag("","UBICACION");
            }
            dataComponentes.close();
            dataUbicacion.close();
            serializer.endTag("", "UBICACIONES");
            serializer.endDocument();
            String result = writer.toString();
            File nuevaCarpeta = new File(getExternalStorageDirectory(), "GENERADOR");
            nuevaCarpeta.mkdirs();
            File file = new File(nuevaCarpeta, nombreArchivo);
            IOHelper.writeToFile(file,result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void exportarGPSEncuesta(){
        String nombreArchivo = "gps.xml";
        XmlSerializer serializer = Xml.newSerializer();
        StringWriter writer = new StringWriter();
        try {
            serializer.setOutput(writer);
            serializer.startDocument("utf-8", true);
            serializer.startTag("", "SGPS");

            dataComponentes = new DataComponentes(this);
            dataComponentes.open();
            DataGPS dataGPS = new DataGPS(this);
            dataGPS.open();
            ArrayList<GPS> gpsArrayList = dataGPS.getAllGPS();
            String[] variablesTabla = SQLGps.ALL_COLUMNS_GPS;
            for (GPS g : gpsArrayList){
                serializer.startTag("", "GPS");
                for (String variable : variablesTabla){
                    String valor = dataComponentes.getValorFromTabla(SQLGps.tablaGPS, variable, g.getID());
                    escribirCampoXml(serializer, variable, valor);
                }
                serializer.endTag("","GPS");
            }
            dataComponentes.close();
            dataGPS.close();
            serializer.endTag("", "SGPS");
            serializer.endDocument();
            String result = writer.toString();
            File nuevaCarpeta = new File(getExternalStorageDirectory(), "GENERADOR");
            nuevaCarpeta.mkdirs();
            File file = new File(nuevaCarpeta, nombreArchivo);
            IOHelper.writeToFile(file,result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void exportarFormulariosEncuesta(){
        String nombreArchivo = "preguntas_formulario.xml";
        XmlSerializer serializer = Xml.newSerializer();
        StringWriter writer = new StringWriter();
        try {
            serializer.setOutput(writer);
            serializer.startDocument("utf-8", true);
            serializer.startTag("", "FORMULARIOS");

            dataComponentes = new DataComponentes(this);
            dataComponentes.open();
            DataFormulario dataFormulario = new DataFormulario(this);
            dataFormulario.open();
            ArrayList<Formulario> formularios = dataFormulario.getAllFormulario();
            String[] variablesTabla = SQLFormulario.ALL_COLUMNS_FORMULARIO;
            for (Formulario f : formularios){
                serializer.startTag("", "FORMULARIO");
                for (String variable : variablesTabla){
                    String valor = dataComponentes.getValorFromTabla(SQLFormulario.tablaFormulario, variable, f.getID());
                    escribirCampoXml(serializer, variable, valor);
                }
                serializer.endTag("","FORMULARIO");
            }
            dataComponentes.close();
            dataFormulario.close();
            serializer.endTag("", "FORMULARIOS");
            serializer.endDocument();
            String result = writer.toString();
            File nuevaCarpeta = new File(getExternalStorageDirectory(), "GENERADOR");
            nuevaCarpeta.mkdirs();
            File file = new File(nuevaCarpeta, nombreArchivo);
            IOHelper.writeToFile(file,result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void exportarSPFormulariosEncuesta(){
        String nombreArchivo = "subpreguntas_formulario.xml";
        XmlSerializer serializer = Xml.newSerializer();
        StringWriter writer = new StringWriter();
        try {
            serializer.setOutput(writer);
            serializer.startDocument("utf-8", true);
            serializer.startTag("", "SP_FORMULARIOS");

            dataComponentes = new DataComponentes(this);
            dataComponentes.open();
            DataFormulario dataFormulario = new DataFormulario(this);
            dataFormulario.open();
            ArrayList<SPFormulario> spFormularios = dataFormulario.getAllSPFormularios();
            String[] variablesTabla = SQLFormulario.ALL_COLUMNS_SP_FORMULARIO;
            for (SPFormulario spf : spFormularios){
                serializer.startTag("", "SP_FORMULARIO");
                for (String variable : variablesTabla){
                    String valor = dataComponentes.getValorFromTabla(SQLFormulario.tablaSPFormulario, variable, spf.getID());
                    escribirCampoXml(serializer, variable, valor);
                }
                serializer.endTag("","SP_FORMULARIO");
            }
            dataComponentes.close();
            dataFormulario.close();
            serializer.endTag("", "SP_FORMULARIOS");
            serializer.endDocument();
            String result = writer.toString();
            File nuevaCarpeta = new File(getExternalStorageDirectory(), "GENERADOR");
            nuevaCarpeta.mkdirs();
            File file = new File(nuevaCarpeta, nombreArchivo);
            IOHelper.writeToFile(file,result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void exportarPEditTextsEncuesta(){
        String nombreArchivo = "preguntas_edittext.xml";
        XmlSerializer serializer = Xml.newSerializer();
        StringWriter writer = new StringWriter();
        try {
            serializer.setOutput(writer);
            serializer.startDocument("utf-8", true);
            serializer.startTag("", "EDITTEXTS");

            dataComponentes = new DataComponentes(this);
            dataComponentes.open();
            DataEditText dataEditText = new DataEditText(this);
            dataEditText.open();
            ArrayList<PEditText> pEditTexts = dataEditText.getAllPEditText();
            String[] variablesTabla = SQLEditText.ALL_COLUMNS_EDITTEXT;
            for (PEditText pe :pEditTexts ){
                serializer.startTag("", "EDITTEXT");
                for (String variable : variablesTabla){
                    String valor = dataComponentes.getValorFromTabla(SQLEditText.tablaEditText, variable, pe.getID());
                    escribirCampoXml(serializer, variable, valor);
                }
                serializer.endTag("","EDITTEXT");
            }
            dataComponentes.close();
            dataEditText.close();
            serializer.endTag("", "EDITTEXTS");
            serializer.endDocument();
            String result = writer.toString();
            File nuevaCarpeta = new File(getExternalStorageDirectory(), "GENERADOR");
            nuevaCarpeta.mkdirs();
            File file = new File(nuevaCarpeta, nombreArchivo);
            IOHelper.writeToFile(file,result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void exportarSPEditTextsEncuesta(){
        String nombreArchivo = "subpreguntas_edittext.xml";
        XmlSerializer serializer = Xml.newSerializer();
        StringWriter writer = new StringWriter();
        try {
            serializer.setOutput(writer);
            serializer.startDocument("utf-8", true);
            serializer.startTag("", "SP_EDITTEXTS");

            dataComponentes = new DataComponentes(this);
            dataComponentes.open();
            DataEditText dataEditText = new DataEditText(this);
            dataEditText.open();
            ArrayList<SPEditText> spEditTexts = dataEditText.getAllSPEditTexts();
            String[] variablesTabla = SQLEditText.ALL_COLUMNS_SPEDITTEXT;
            for (SPEditText pe : spEditTexts ){
                serializer.startTag("", "SP_EDITTEXT");
                for (String variable : variablesTabla){
                    String valor = dataComponentes.getValorFromTabla(SQLEditText.tablaSPEditText, variable, pe.getID());
                    escribirCampoXml(serializer, variable, valor);
                }
                serializer.endTag("","SP_EDITTEXT");
            }
            dataComponentes.close();
            dataEditText.close();
            serializer.endTag("", "SP_EDITTEXTS");
            serializer.endDocument();
            String result = writer.toString();
            File nuevaCarpeta = new File(getExternalStorageDirectory(), "GENERADOR");
            nuevaCarpeta.mkdirs();
            File file = new File(nuevaCarpeta, nombreArchivo);
            IOHelper.writeToFile(file,result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void exportarPCheckBoxsEncuesta(){
        String nombreArchivo = "preguntas_checkbox.xml";
        XmlSerializer serializer = Xml.newSerializer();
        StringWriter writer = new StringWriter();
        try {
            serializer.setOutput(writer);
            serializer.startDocument("utf-8", true);
            serializer.startTag("", "CHECKBOXS");

            dataComponentes = new DataComponentes(this);
            dataComponentes.open();
            DataCheckBox dataCheckBox = new DataCheckBox(this);
            dataCheckBox.open();
            ArrayList<PCheckBox> pCheckBoxes = dataCheckBox.getAllPCheckbox();
            String[] variablesTabla = SQLCheckBox.ALL_COLUMNS_CHECKBOX;
            for (PCheckBox pc :pCheckBoxes ){
                serializer.startTag("", "CHECKBOX");
                for (String variable : variablesTabla){
                    String valor = dataComponentes.getValorFromTabla(SQLCheckBox.tablaCheckBox, variable, pc.getID());
                    escribirCampoXml(serializer, variable, valor);
                }
                serializer.endTag("","CHECKBOX");
            }
            dataComponentes.close();
            dataCheckBox.close();
            serializer.endTag("", "CHECKBOXS");
            serializer.endDocument();
            String result = writer.toString();
            File nuevaCarpeta = new File(getExternalStorageDirectory(), "GENERADOR");
            nuevaCarpeta.mkdirs();
            File file = new File(nuevaCarpeta, nombreArchivo);
            IOHelper.writeToFile(file,result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void exportarSPCheckBoxsEncuesta(){
        String nombreArchivo = "subpreguntas_checkbox.xml";
        XmlSerializer serializer = Xml.newSerializer();
        StringWriter writer = new StringWriter();
        try {
            serializer.setOutput(writer);
            serializer.startDocument("utf-8", true);
            serializer.startTag("", "SP_CHECKBOXES");

            dataComponentes = new DataComponentes(this);
            dataComponentes.open();
            DataCheckBox dataCheckBox = new DataCheckBox(this);
            dataCheckBox.open();
            ArrayList<SPCheckBox> spCheckBoxes = dataCheckBox.getAllSPCheckBoxs();
            String[] variablesTabla = SQLCheckBox.ALL_COLUMNS_SPCHECKBOX;
            for (SPCheckBox spc : spCheckBoxes ){
                serializer.startTag("", "SP_CHECKBOX");
                for (String variable : variablesTabla){
                    String valor = dataComponentes.getValorFromTabla(SQLCheckBox.tablaSPCheckBox, variable, spc.getID());
                    escribirCampoXml(serializer, variable, valor);
                }
                serializer.endTag("","SP_CHECKBOX");
            }
            dataComponentes.close();
            dataCheckBox.close();
            serializer.endTag("", "SP_CHECKBOXES");
            serializer.endDocument();
            String result = writer.toString();
            File nuevaCarpeta = new File(getExternalStorageDirectory(), "GENERADOR");
            nuevaCarpeta.mkdirs();
            File file = new File(nuevaCarpeta, nombreArchivo);
            IOHelper.writeToFile(file,result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void exportarPRadiosEncuesta(){
        String nombreArchivo = "preguntas_radio.xml";
        XmlSerializer serializer = Xml.newSerializer();
        StringWriter writer = new StringWriter();
        try {
            serializer.setOutput(writer);
            serializer.startDocument("utf-8", true);
            serializer.startTag("", "RADIOS");

            dataComponentes = new DataComponentes(this);
            dataComponentes.open();
            DataRadio dataRadio = new DataRadio(this);
            dataRadio.open();
            ArrayList<PRadio> pRadios = dataRadio.getAllPRadio();
            String[] variablesTabla = SQLRadio.ALL_COLUMNS_RADIO;
            for (PRadio pr : pRadios){
                serializer.startTag("", "RADIO");
                for (String variable : variablesTabla){
                    String valor = dataComponentes.getValorFromTabla(SQLRadio.tablaRadio, variable, pr.getID());
                    escribirCampoXml(serializer, variable, valor);
                }
                serializer.endTag("","RADIO");
            }
            dataComponentes.close();
            dataRadio.close();
            serializer.endTag("", "RADIOS");
            serializer.endDocument();
            String result = writer.toString();
            File nuevaCarpeta = new File(getExternalStorageDirectory(), "GENERADOR");
            nuevaCarpeta.mkdirs();
            File file = new File(nuevaCarpeta, nombreArchivo);
            IOHelper.writeToFile(file,result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void exportarSPRadiosEncuesta(){
        String nombreArchivo = "subpreguntas_radio.xml";
        XmlSerializer serializer = Xml.newSerializer();
        StringWriter writer = new StringWriter();
        try {
            serializer.setOutput(writer);
            serializer.startDocument("utf-8", true);
            serializer.startTag("", "SP_RADIOS");

            dataComponentes = new DataComponentes(this);
            dataComponentes.open();
            DataRadio dataRadio = new DataRadio(this);
            dataRadio.open();
            ArrayList<SPRadio> spRadios = dataRadio.getAllSPRadios();
            String[] variablesTabla = SQLRadio.ALL_COLUMNS_SPRADIO;
            for (SPRadio spr : spRadios ){
                serializer.startTag("", "SP_RADIO");
                for (String variable : variablesTabla){
                    String valor = dataComponentes.getValorFromTabla(SQLRadio.tablaSPRadio, variable, spr.getID());
                    escribirCampoXml(serializer, variable, valor);
                }
                serializer.endTag("","SP_RADIO");
            }
            dataComponentes.close();
            dataRadio.close();
            serializer.endTag("", "SP_RADIOS");
            serializer.endDocument();
            String result = writer.toString();
            File nuevaCarpeta = new File(getExternalStorageDirectory(), "GENERADOR");
            nuevaCarpeta.mkdirs();
            File file = new File(nuevaCarpeta, nombreArchivo);
            IOHelper.writeToFile(file,result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void exportarOpcionSpinnersEncuesta(){
        String nombreArchivo = "opciones.xml";
        XmlSerializer serializer = Xml.newSerializer();
        StringWriter writer = new StringWriter();
        try {
            serializer.setOutput(writer);
            serializer.startDocument("utf-8", true);
            serializer.startTag("", "OPCIONES");

            dataComponentes = new DataComponentes(this);
            dataComponentes.open();
            ArrayList<OpcionSpinner> opcionSpinners = dataComponentes.getAllOpcionesSpinner();
            String[] variablesTabla = SQLConstantesComponente.ALL_COLUMNS_OPCION_SPINNER;
            for (OpcionSpinner op : opcionSpinners ){
                serializer.startTag("", "OPCION");
                for (String variable : variablesTabla){
                    String valor = dataComponentes.getValorFromTabla(SQLConstantesComponente.tablaOpcionSpinner, variable, op.getID());
                    escribirCampoXml(serializer, variable, valor);
                }
                serializer.endTag("","OPCION");
            }
            dataComponentes.close();
            serializer.endTag("", "OPCIONES");
            serializer.endDocument();
            String result = writer.toString();
            File nuevaCarpeta = new File(getExternalStorageDirectory(), "GENERADOR");
            nuevaCarpeta.mkdirs();
            File file = new File(nuevaCarpeta, nombreArchivo);
            IOHelper.writeToFile(file,result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void exportarVariablesEncuesta(){
        String nombreArchivo = "variables.xml";
        XmlSerializer serializer = Xml.newSerializer();
        StringWriter writer = new StringWriter();
        try {
            serializer.setOutput(writer);
            serializer.startDocument("utf-8", true);
            serializer.startTag("", "VARIABLES");

            dataComponentes = new DataComponentes(this);
            dataComponentes.open();
            ArrayList<Variable> variables = dataComponentes.getAllVariables();
            String[] variablesTabla = SQLConstantesComponente.ALL_COLUMNS_VARIABLES;
            for (Variable var : variables ){
                serializer.startTag("", "VARIABLE");
                for (String variable : variablesTabla){
                    String valor = dataComponentes.getValorFromTabla(SQLConstantesComponente.tablaVariables, variable, var.getID());
                    escribirCampoXml(serializer, variable, valor);
                }
                serializer.endTag("","VARIABLE");
            }
            dataComponentes.close();
            serializer.endTag("", "VARIABLES");
            serializer.endDocument();
            String result = writer.toString();
            File nuevaCarpeta = new File(getExternalStorageDirectory(), "GENERADOR");
            nuevaCarpeta.mkdirs();
            File file = new File(nuevaCarpeta, nombreArchivo);
            IOHelper.writeToFile(file,result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void exportarEventosEncuesta(){
        String nombreArchivo = "eventos.xml";
        XmlSerializer serializer = Xml.newSerializer();
        StringWriter writer = new StringWriter();
        try {
            serializer.setOutput(writer);
            serializer.startDocument("utf-8", true);
            serializer.startTag("", "EVENTOS");

            dataComponentes = new DataComponentes(this);
            dataComponentes.open();
            ArrayList<Evento> eventos = dataComponentes.getAllEventos();
            String[] variablesTabla = SQLConstantesComponente.ALL_COLUMNS_EVENTOS;
            for (Evento evento : eventos){
                serializer.startTag("", "EVENTO");
                for (String variable : variablesTabla){
                    String valor = dataComponentes.getValorFromTabla(SQLConstantesComponente.tablaEventos, variable, evento.getID());
                    escribirCampoXml(serializer, variable, valor);
                }
                serializer.endTag("","EVENTO");
            }
            dataComponentes.close();
            serializer.endTag("", "EVENTOS");
            serializer.endDocument();
            String result = writer.toString();
            File nuevaCarpeta = new File(getExternalStorageDirectory(), "GENERADOR");
            nuevaCarpeta.mkdirs();
            File file = new File(nuevaCarpeta, nombreArchivo);
            IOHelper.writeToFile(file,result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void exportarInfoTablasEncuesta(){
        String nombreArchivo = "infotablas.xml";
        XmlSerializer serializer = Xml.newSerializer();
        StringWriter writer = new StringWriter();
        try {
            serializer.setOutput(writer);
            serializer.startDocument("utf-8", true);
            serializer.startTag("", "INFOTABLAS");

            dataComponentes = new DataComponentes(this);
            dataComponentes.open();
            ArrayList<InfoTabla> infoTablas = dataComponentes.getAllInfoTablas();
            String[] variablesTabla = SQLConstantesComponente.ALL_COLUMNS_INFOTABLAS;
            for (InfoTabla infoTabla : infoTablas){
                serializer.startTag("", "INFOTABLA");
                for (String variable : variablesTabla){
                    String valor = dataComponentes.getValorFromTabla(SQLConstantesComponente.tablaInfoTablas, variable, infoTabla.getID());
                    escribirCampoXml(serializer, variable, valor);
                }
                serializer.endTag("","INFOTABLA");
            }
            dataComponentes.close();
            serializer.endTag("", "INFOTABLAS");
            serializer.endDocument();
            String result = writer.toString();
            File nuevaCarpeta = new File(getExternalStorageDirectory(), "GENERADOR");
            nuevaCarpeta.mkdirs();
            File file = new File(nuevaCarpeta, nombreArchivo);
            IOHelper.writeToFile(file,result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    void escribirCampoXml(XmlSerializer s, String campo,String valor){
        try {
            s.startTag("", campo);
            if(valor != null) s.text(valor);
            else s.text("");
            s.endTag("", campo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public class MyAsyncTask extends AsyncTask<Integer,Integer,String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            txtMensaje.setText("Exportando...");
            txtMensaje.setVisibility(View.VISIBLE);
            progreso.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(Integer... integers) {
            exportarTituloEncuesta();
            exportarModulosEncuesta();
            exportarPaginasEncuesta();
            exportarVisitaEncuesta();
            exportarUbicacionEncuesta();
            exportarGPSEncuesta();
            exportarFormulariosEncuesta();
            exportarSPFormulariosEncuesta();
            exportarPEditTextsEncuesta();
            exportarSPEditTextsEncuesta();
            exportarPCheckBoxsEncuesta();
            exportarSPCheckBoxsEncuesta();
            exportarPRadiosEncuesta();
            exportarSPRadiosEncuesta();
            exportarOpcionSpinnersEncuesta();
            exportarVariablesEncuesta();
            exportarEventosEncuesta();
            exportarInfoTablasEncuesta();
            return "Listo";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progreso.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(String string) {
            super.onPostExecute(string);
            txtMensaje.setText(string);
            progreso.setVisibility(View.GONE);
            txtMensaje.setVisibility(View.GONE);
            Toast.makeText(ExportarEncuestaActivity.this, "Exportacion Completa", Toast.LENGTH_SHORT).show();
        }
    }
}
