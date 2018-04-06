package pe.com.ricindigus.generadorinei.activities.activities_encuesta;

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
import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.DataComponentes;
import pe.com.ricindigus.generadorinei.modelo.DataSourceTablasGuardado.DataTablas;
import pe.com.ricindigus.generadorinei.parser.InfoTablasPullParser;
import pe.com.ricindigus.generadorinei.pojos.ExportarItem;
import pe.com.ricindigus.generadorinei.pojos.Marco;
import pe.com.ricindigus.generadorinei.pojos.InfoTabla;

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

        XmlSerializer serializer = Xml.newSerializer();
        StringWriter writer = new StringWriter();
        try {
            serializer.setOutput(writer);
            serializer.startDocument("utf-8", true);
            serializer.startTag("", "ENCUESTA");
            serializer.attribute("", "id",idEmpresa);

            dataComponentes = new DataComponentes(this);
            dataComponentes.open();
            dataTablas = new DataTablas(this);
            dataTablas.open();
            ArrayList<InfoTabla> infoTablas =(new InfoTablasPullParser()).parseXML(this);
            for(InfoTabla infoTabla : infoTablas){
                String nombreTabla = infoTabla.getNOMBRE_XML();
                String idTabla = infoTabla.getID();
                if(dataTablas.existenDatos(idTabla,idEmpresa)){
                    String[] variablesTabla = dataTablas.getNombreColumnas(idTabla,idEmpresa);
                    if(infoTabla.getTIPO().equals("1"))serializer.startTag("", nombreTabla);
                    else serializer.startTag("", nombreTabla + "_ITEMS");
                    if(infoTabla.getTIPO().equals("1")){
                        for (String variable : variablesTabla){
                            String valor = dataTablas.getValor(idTabla,variable,idEmpresa);
                            escribirCampoXml(serializer, variable, valor);
                        }
                    }else{
                        ArrayList<String> filas = dataTablas.getFilas(idTabla,idEmpresa);
                        for (String idFila : filas){
                            serializer.startTag("", nombreTabla);
                            for (String variable : variablesTabla){
                                String valor = dataTablas.getValorxId(idTabla,variable,idFila);
                                escribirCampoXml(serializer, variable, valor);
                            }
                            serializer.endTag("", nombreTabla);
                        }
                    }
                    if(infoTabla.getTIPO().equals("1"))serializer.endTag("", nombreTabla);
                    else serializer.endTag("", nombreTabla + "_ITEMS");
                }
            }
            dataComponentes.close();
            dataTablas.close();
            serializer.endTag("", "ENCUESTA");
            serializer.endDocument();
            String result = writer.toString();
            File nuevaCarpeta = new File(getExternalStorageDirectory(), "GENERAPP_EXPORTACION");
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
