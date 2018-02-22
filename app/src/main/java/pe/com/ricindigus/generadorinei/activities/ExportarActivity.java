package pe.com.ricindigus.generadorinei.activities;

import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Xml;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
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
import pe.com.ricindigus.generadorinei.adapters.ExportarAdapter;
import pe.com.ricindigus.generadorinei.modelo.DataSourceCaptura.Data;
import pe.com.ricindigus.generadorinei.modelo.DataSourceCaptura.SQLConstantes;
import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.DataComponentes;
import pe.com.ricindigus.generadorinei.modelo.DataSourceTablasGuardado.DataTablas;
import pe.com.ricindigus.generadorinei.parser.TablasPullParser;
import pe.com.ricindigus.generadorinei.pojos.ExportarItem;
import pe.com.ricindigus.generadorinei.pojos.Marco;
import pe.com.ricindigus.generadorinei.pojos.Tabla;

import static android.os.Environment.getExternalStorageDirectory;

public class ExportarActivity extends AppCompatActivity {

    ArrayList<Marco> marcos;
    ArrayList<ExportarItem> exportarItems;
    private DataComponentes dataComponentes;
    private DataTablas dataTablas;
    private Data data;
    private String idUsuario;
    private String permisoUsuario;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private ExportarAdapter exportarAdapter;
    private Button btnExportar;
    private Button btnVolver;
    private TextView txtMensaje;
    private ProgressBar progreso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exportar);
        recyclerView = (RecyclerView) findViewById(R.id.exportacion_recycler);
        btnExportar = (Button) findViewById(R.id.exportacion_btnExportar);
        btnVolver = (Button) findViewById(R.id.exportacion_btnVolver);
        txtMensaje = (TextView) findViewById(R.id.exportacion_txtMensaje);
        progreso = (ProgressBar) findViewById(R.id.exportacion_progreso);

        progreso.setMax(4200);
        txtMensaje.setVisibility(View.GONE);
        progreso.setVisibility(View.GONE);

        final Bundle recupera = getIntent().getExtras();
        if(recupera != null){
            idUsuario = recupera.getString("idUsuario");
            permisoUsuario = recupera.getString("permisoUsuario");
        }
        inicializarDatos();
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        exportarAdapter = new ExportarAdapter(exportarItems, this, new ExportarAdapter.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b, int pos) {
                if(b){
                    exportarItems.get(pos).setSeleccionado(1);
                }else{
                    exportarItems.get(pos).setSeleccionado(0);
                }
            }
        });
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(exportarAdapter);

        btnExportar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MyAsyncTask().execute(100);
            }
        });
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    private void inicializarDatos() {
        marcos = new ArrayList<Marco>();
        exportarItems = new ArrayList<>();
        data = new Data(this);
        data.open();
        marcos = data.getAllMarcos(idUsuario,Integer.parseInt(permisoUsuario));
        data.close();

        for(Marco marco1: marcos){
            ExportarItem exportarItem = new ExportarItem(0,marco1.getID(),marco1.getRUC(),marco1.getRAZON_SOCIAL());
            exportarItems.add(exportarItem);
        }
    }
    public void mostrarMensaje(String m){
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(m);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    public void exportarEmpresa(String idEmpresa){
        String nombreArchivo = idEmpresa + ".xml";
        Marco marco;
        data = new Data(this);
        data.open();
        marco = data.getMarco(idEmpresa);
        data.close();

        XmlSerializer serializer = Xml.newSerializer();
        StringWriter writer = new StringWriter();
        try {
            serializer.setOutput(writer);
            serializer.startDocument("utf-8", true);
            serializer.startTag("", "ENCUESTA");
            serializer.attribute("", "id",idEmpresa);
            serializer.startTag("", "MARCO");
            escribirCampoXml(serializer,"ID",marco.getID());
            escribirCampoXml(serializer, SQLConstantes.MARCO_RUC,marco.getRUC());
            escribirCampoXml(serializer,SQLConstantes.MARCO_RAZON_SOCIAL,marco.getRAZON_SOCIAL());
            escribirCampoXml(serializer,SQLConstantes.MARCO_NOMBRE_COMERCIAL,marco.getNOMBRE_COMERCIAL());
            escribirCampoXml(serializer,SQLConstantes.MARCO_OPERADOR,marco.getOPERADOR());
            escribirCampoXml(serializer,SQLConstantes.MARCO_JEFE,marco.getJEFE());
            escribirCampoXml(serializer,SQLConstantes.MARCO_OBSERVADOR,marco.getOBSERVADOR());
            escribirCampoXml(serializer,SQLConstantes.MARCO_ANIO,marco.getANIO());
            escribirCampoXml(serializer,SQLConstantes.MARCO_MES,marco.getMES());
            escribirCampoXml(serializer,SQLConstantes.MARCO_PERIODO,marco.getPERIODO());
            escribirCampoXml(serializer,SQLConstantes.MARCO_CCDD,marco.getCCDD());
            escribirCampoXml(serializer,SQLConstantes.MARCO_DEPARTAMENTO,marco.getDEPARTAMENTO());
            escribirCampoXml(serializer,SQLConstantes.MARCO_CCPP,marco.getCCPP());
            escribirCampoXml(serializer,SQLConstantes.MARCO_PROVINCIA,marco.getPROVINCIA());
            escribirCampoXml(serializer,SQLConstantes.MARCO_CCDI,marco.getCCDI());
            escribirCampoXml(serializer,SQLConstantes.MARCO_DISTRITO,marco.getDISTRITO());
            escribirCampoXml(serializer,SQLConstantes.MARCO_T_EMPRESA,marco.getT_EMPRESA());
            escribirCampoXml(serializer,SQLConstantes.MARCO_FRENTE,marco.getFRENTE());
            escribirCampoXml(serializer,SQLConstantes.MARCO_ZONA,marco.getZONA());
            escribirCampoXml(serializer,SQLConstantes.MARCO_MANZANA,marco.getMANZANA());
            escribirCampoXml(serializer,SQLConstantes.MARCO_CAT_VIA,marco.getCAT_VIA());
            escribirCampoXml(serializer,SQLConstantes.MARCO_NOM_VIA,marco.getNOM_VIA());
            escribirCampoXml(serializer,SQLConstantes.MARCO_PUERTA,marco.getPUERTA());
            escribirCampoXml(serializer,SQLConstantes.MARCO_INTERIOR,marco.getINTERIOR());
            escribirCampoXml(serializer,SQLConstantes.MARCO_PISO,marco.getPISO());
            escribirCampoXml(serializer,SQLConstantes.MARCO_MZ,marco.getMZ());
            escribirCampoXml(serializer,SQLConstantes.MARCO_LOTE,marco.getLOTE());
            serializer.endTag("", "MARCO");

            dataComponentes = new DataComponentes(this);
            dataComponentes.open();
            dataTablas = new DataTablas(this);
            dataTablas.open();
            ArrayList<Tabla> tablas = (new TablasPullParser()).parseXML(this);
            for(Tabla tabla : tablas){
                String nombreTabla = tabla.getNOMBRE();
                String idTabla = tabla.getID();
                if(dataTablas.existenDatos(idTabla,idEmpresa)){
                    String[] variablesTabla = dataTablas.getNombreColumnas(idTabla,idEmpresa);
                    serializer.startTag("", nombreTabla);
                    if(tabla.getTIPO().equals("1")){
                        for (String variable : variablesTabla){
                            String valor = dataTablas.getValor(idTabla,variable,idEmpresa);
                            escribirCampoXml(serializer, variable, valor);
                        }
                    }else{

                        ArrayList<String> filas = dataTablas.getFilas(idTabla,idEmpresa);
                        for (String idFila : filas){
                            serializer.startTag("", "ITEM_" + nombreTabla);
                            for (String variable : variablesTabla){
                                String valor = dataTablas.getValorxId(idTabla,variable,idFila);
                                escribirCampoXml(serializer, variable, valor);
                            }
                            serializer.endTag("", "ITEM_" + nombreTabla);
                        }
                    }
                    serializer.endTag("", nombreTabla);
                }
            }
            dataComponentes.close();
            dataTablas.close();
//            if(!caratula.getID().equals("")) {
//                serializer.startTag("", "CARATULA");
//                escribirCampoXml(serializer, "ID", caratula.getID());
//                escribirCampoXml(serializer, SQLConstantes.CARATULA_DEPARTAMENTO, caratula.getNOMBREDD());
//                escribirCampoXml(serializer, SQLConstantes.CARATULA_DEPARTAMENTO_COD, caratula.getCCDD());
//                escribirCampoXml(serializer, SQLConstantes.CARATULA_PROVINCIA, caratula.getNOMBREPV());
//                escribirCampoXml(serializer, SQLConstantes.CARATULA_PROVINCIA_COD, caratula.getCCPP());
//                escribirCampoXml(serializer, SQLConstantes.CARATULA_DISTRITO, caratula.getNOMBREDI());
//                escribirCampoXml(serializer, SQLConstantes.CARATULA_DISTRITO_COD, caratula.getCCDI());
//                escribirCampoXml(serializer, SQLConstantes.CARATULA_GPSLATITUD, caratula.getGPSLATITUD());
//                escribirCampoXml(serializer, SQLConstantes.CARATULA_GPSLONGITUD, caratula.getGPSLONGITUD());
//                escribirCampoXml(serializer, SQLConstantes.CARATULA_SECTOR, caratula.getSECTOR_TR());
//                escribirCampoXml(serializer, SQLConstantes.CARATULA_AREA, caratula.getARA_TR());
//                escribirCampoXml(serializer, SQLConstantes.CARATULA_ZONA, caratula.getZONA());
//                escribirCampoXml(serializer, SQLConstantes.CARATULA_MANZANA_MUESTRA, caratula.getMANZANA_ID());
//                escribirCampoXml(serializer, SQLConstantes.CARATULA_FRENTE, caratula.getFRENTE());
//                escribirCampoXml(serializer, SQLConstantes.CARATULA_TIPVIA, caratula.getTIPVIA());
//                escribirCampoXml(serializer, SQLConstantes.CARATULA_NOMVIA, caratula.getTIPVIA_D());
//                escribirCampoXml(serializer, SQLConstantes.CARATULA_NPUERTA, caratula.getNROPTA());
//                escribirCampoXml(serializer, SQLConstantes.CARATULA_BLOCK, caratula.getBLOCK());
//                escribirCampoXml(serializer, SQLConstantes.CARATULA_INTERIOR, caratula.getINTERIOR());
//                escribirCampoXml(serializer, SQLConstantes.CARATULA_PISO, caratula.getPISO());
//                escribirCampoXml(serializer, SQLConstantes.CARATULA_MANZANA_VIA, caratula.getMZA());
//                escribirCampoXml(serializer, SQLConstantes.CARATULA_LOTE, caratula.getLOTE());
//                escribirCampoXml(serializer, SQLConstantes.CARATULA_KM, caratula.getKM());
//                escribirCampoXml(serializer, SQLConstantes.CARATULA_REFERENCIA, caratula.getREF_DIREC());
//                serializer.endTag("", "CARATULA");
//            }

//            serializer.startTag("","RESULTADO_ENCUESTA");
//            escribirCampoXml(serializer,SQLConstantes.RESULTADO_ID,resultadoEncuesta.getRESFIN_ID());
//            escribirCampoXml(serializer,SQLConstantes.RESULTADO_DIA,resultadoEncuesta.getRESFIN_DIA());
//            escribirCampoXml(serializer,SQLConstantes.RESULTADO_MES,resultadoEncuesta.getRESFIN_MES());
//            escribirCampoXml(serializer,SQLConstantes.RESULTADO_ANIO,resultadoEncuesta.getRESFIN_ANIO());
//            escribirCampoXml(serializer,SQLConstantes.RESULTADO_HORA,resultadoEncuesta.getRESFIN_HORA());
//            escribirCampoXml(serializer,SQLConstantes.RESULTADO_MIN,resultadoEncuesta.getRESFIN_MIN());
//            escribirCampoXml(serializer,SQLConstantes.RESULTADO_RESULTADO,resultadoEncuesta.getRESFIN());
//            escribirCampoXml(serializer,SQLConstantes.RESULTADO_RESULTADO_ESP,resultadoEncuesta.getRESFIN_O());
//            serializer.endTag("","RESULTADO_ENCUESTA");
//
//
//
//            if(visitas.size()>0) {
//                serializer.startTag("", "VISITAS");
//                for (Visita visita : visitas) {
//                    serializer.startTag("", "VISITA");
//                    escribirCampoXml(serializer, "ID", visita.getID());
//                    escribirCampoXml(serializer, SQLConstantes.VISITA_ID_EMPRESA, visita.getID_EMPRESA());
//                    escribirCampoXml(serializer, SQLConstantes.VISITA_N, visita.getV_NRO());
//                    escribirCampoXml(serializer, SQLConstantes.VISITA_DIA, visita.getV_DIA());
//                    escribirCampoXml(serializer, SQLConstantes.VISITA_MES, visita.getV_MES());
//                    escribirCampoXml(serializer, SQLConstantes.VISITA_ANIO, visita.getV_ANIO());
//                    escribirCampoXml(serializer, SQLConstantes.VISITA_HORA, visita.getV_HORA());
//                    escribirCampoXml(serializer, SQLConstantes.VISITA_MINUTO, visita.getV_MINUTO());
//                    escribirCampoXml(serializer, SQLConstantes.VISITA_RESULTADO, visita.getV_RESULTADO());
//                    escribirCampoXml(serializer, SQLConstantes.VISITA_RESULTADO_ESP, visita.getV_RESULTADO_O());
//                    escribirCampoXml(serializer, SQLConstantes.VISITA_PROX_DIA, visita.getV_PROX_VIS_DIA());
//                    escribirCampoXml(serializer, SQLConstantes.VISITA_PROX_MES, visita.getV_PROX_VIS_MES());
//                    escribirCampoXml(serializer, SQLConstantes.VISITA_PROX_ANIO, visita.getV_PROX_VIS_ANIO());
//                    escribirCampoXml(serializer, SQLConstantes.VISITA_PROX_HORA, visita.getV_PROX_VIS_HORA());
//                    escribirCampoXml(serializer, SQLConstantes.VISITA_PROX_MINUTO, visita.getV_PROX_VIS_MINUTO());
//                    serializer.endTag("", "VISITA");
//                }
//                serializer.endTag("", "VISITAS");
//            }
//            if(!identificacion.getID().equals("")) {
//                serializer.startTag("", "IDENTIFICACION");
//                escribirCampoXml(serializer, "ID", identificacion.getID());
//                escribirCampoXml(serializer, SQLConstantes.IDENTIFICACION_RUC, identificacion.getNUM_RUC());
//                escribirCampoXml(serializer, SQLConstantes.IDENTIFICACION_RAZON, identificacion.getRAZON_SOCIAL());
//                escribirCampoXml(serializer, SQLConstantes.IDENTIFICACION_NOMBRE, identificacion.getNOM_COMER_MYPE());
//                escribirCampoXml(serializer, SQLConstantes.IDENTIFICACION_WEB, identificacion.getPAGWEB());
//                escribirCampoXml(serializer, SQLConstantes.IDENTIFICACION_WEBNO, identificacion.getPAGWEB_NO());
//                escribirCampoXml(serializer, SQLConstantes.IDENTIFICACION_CORREO, identificacion.getCORREO());
//                escribirCampoXml(serializer, SQLConstantes.IDENTIFICACION_CORREONO, identificacion.getCORREO_NO());
//                escribirCampoXml(serializer, SQLConstantes.IDENTIFICACION_FIJO, identificacion.getTELFIJO());
//                escribirCampoXml(serializer, SQLConstantes.IDENTIFICACION_FIJONO, identificacion.getTELFIJO_NO());
//                escribirCampoXml(serializer, SQLConstantes.IDENTIFICACION_MOVIL, identificacion.getTELMOVIL());
//                escribirCampoXml(serializer, SQLConstantes.IDENTIFICACION_MOVILNO, identificacion.getTELMOVIL_NO());
//                escribirCampoXml(serializer, SQLConstantes.IDENTIFICACION_ANIO_FUNCIONAMIENTO, identificacion.getANO_INI());
//                escribirCampoXml(serializer, SQLConstantes.IDENTIFICACION_CONDUCTOR_NOMBRE, identificacion.getCOND_APEL_NOM());
//                escribirCampoXml(serializer, SQLConstantes.IDENTIFICACION_CONDUCTOR_SEXO, identificacion.getCOND_SEXO());
//                escribirCampoXml(serializer, SQLConstantes.IDENTIFICACION_CONDUCTOR_EDAD, identificacion.getCOND_EDAD());
//                escribirCampoXml(serializer, SQLConstantes.IDENTIFICACION_CONDUCTOR_ESTUDIOS, identificacion.getCOND_NEST());
//                escribirCampoXml(serializer, SQLConstantes.IDENTIFICACION_CONDUCTOR_CARGO, identificacion.getINFOR_CARGO());
//                escribirCampoXml(serializer, SQLConstantes.IDENTIFICACION_CONDUCTOR_CARGO_ESP, identificacion.getINFOR_CARGO_O());
//                serializer.endTag("", "IDENTIFICACION");
//            }
//            if(!modulo1.getID().equals("")) {
//                serializer.startTag("", "MODULO1");
//                escribirCampoXml(serializer, "ID", modulo1.getID());
//                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_101,modulo1.getP_101());
//                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_101_1,modulo1.getP_101_1());
//                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_101_1_O,modulo1.getP_101_1_O());
//                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_102A,modulo1.getP_102A());
//                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_102_1,modulo1.getP_102_1());
//                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_102B,modulo1.getP_102B());
//                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_102_2,modulo1.getP_102_2());
//                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_102C,modulo1.getP_102C());
//                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_102_3,modulo1.getP_102_3());
//                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_102D,modulo1.getP_102D());
//                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_102_4,modulo1.getP_102_4());
//                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_103,convertir(modulo1.getP_103()));
//                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_103_O,modulo1.getP_103_O());
//                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_104,modulo1.getP_104());
//                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_105,modulo1.getP_105());
//                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_106_1,modulo1.getP_106_1());
//                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_106_2,modulo1.getP_106_2());
//                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_106_3,modulo1.getP_106_3());
//                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_106_4,modulo1.getP_106_4());
//                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_106_5,modulo1.getP_106_5());
//                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_107_1,modulo1.getP_107_1());
//                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_107_2,modulo1.getP_107_2());
//                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_107_3,modulo1.getP_107_3());
//                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_108,modulo1.getP_108());
//                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_109_1,modulo1.getP_109_1());
//                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_109_2,modulo1.getP_109_2());
//                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_109_3,modulo1.getP_109_3());
//                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_109_4,modulo1.getP_109_4());
//                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_109_5,modulo1.getP_109_5());
//                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_109_6,modulo1.getP_109_6());
//                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_109_6_O,modulo1.getP_109_6_O());
//                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_110_1,modulo1.getP_110_1());
//                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_110_2,modulo1.getP_110_2());
//                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_110_3,modulo1.getP_110_3());
//                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_110_4,modulo1.getP_110_4());
//                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_110_5,modulo1.getP_110_5());
//                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_110_6,modulo1.getP_110_6());
//                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_110_7,modulo1.getP_110_7());
//                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_110_7_O,modulo1.getP_110_7_O());
//                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_111,modulo1.getP_111());
//                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_112,modulo1.getP_112());
//                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_112_O,modulo1.getP_112_O());
//                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_113_1,modulo1.getP_113_1());
//                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_113_2,modulo1.getP_113_2());
//                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_113_3,modulo1.getP_113_3());
//                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_113_4,modulo1.getP_113_4());
//                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_113_5,modulo1.getP_113_5());
//                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_113_5_O,modulo1.getP_113_5_O());
//                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_114_1,modulo1.getP_114_1());
//                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_114_2,modulo1.getP_114_2());
//                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_114_3,modulo1.getP_114_3());
//                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_114_4,modulo1.getP_114_4());
//                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_114_5,modulo1.getP_114_5());
//                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_114_6,modulo1.getP_114_6());
//                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_114_7,modulo1.getP_114_7());
//                escribirCampoXml(serializer, SQLConstantes.SECCION100_P_114_7_O,modulo1.getP_114_7_O());
//                escribirCampoXml(serializer, SQLConstantes.SECCION100_OBS,modulo1.getOBS());
//                serializer.endTag("", "MODULO1");
//            }


            serializer.endTag("", "ENCUESTA");
            serializer.endDocument();
            String result = writer.toString();
            File nuevaCarpeta = new File(getExternalStorageDirectory(), "GENERADOR");
            nuevaCarpeta.mkdirs();
            File file = new File(nuevaCarpeta, nombreArchivo);
            IOHelper.writeToFile(file,result);
//            IOHelper.writeToFile(this, "cities.xml", result);
//                    txtXml.setText("From writeToXmlFile\n" + result);
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
            String mensaje = "";
            int i = 1;
            for(ExportarItem exportarItem : exportarItems){
                if(exportarItem.getSeleccionado() == 1){
                    //aqui exporta
                    exportarEmpresa(exportarItem.getIdEmpresa());
                    publishProgress(i);
                }
                i++;
            }
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
            Toast.makeText(ExportarActivity.this, "Exportacion Completa", Toast.LENGTH_SHORT).show();
        }
    }

    public String convertir(String num){
        String valor = "";
        if(!num.equals("")){
            int n = Integer.parseInt(num) + 1;
            if(n != 0) valor = valor + n;
        }
        return valor;
    }
}
