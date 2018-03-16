package pe.com.ricindigus.generadorinei.activities;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.R;
import pe.com.ricindigus.generadorinei.modelo.DataSourceCaptura.Data;
import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.DataComponentes;
import pe.com.ricindigus.generadorinei.modelo.DataSourceTablasGuardado.DataTablas;
import pe.com.ricindigus.generadorinei.parser.InfoTablasPullParser;
import pe.com.ricindigus.generadorinei.pojos.InfoTabla;

import static android.os.Environment.getExternalStorageDirectory;

public class ImportarActivity extends AppCompatActivity {
    private TextView txtImportar;
    private Button btnImportar;
    private Button btnVolver;
    private String idEmpresa;
    private EditText edtArchivo;
    private DataComponentes dataComponentes;
    private DataTablas dataTablas;
    private Data data;
    private ArrayList<InfoTabla> infoTablas = null;
    private String currentTag = null;
    private String currentVariable = null;
    private InfoTabla currentInfoTabla = null;
    private ContentValues currentContentValues = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_importar);

        txtImportar = (TextView) findViewById(R.id.txtImportar);
        btnImportar = (Button) findViewById(R.id.importacion_btnImportar);
        btnVolver = (Button) findViewById(R.id.importacion_btnVolver);
        edtArchivo = (EditText) findViewById(R.id.importacion_edtArchivo);

        btnImportar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                idEmpresa = edtArchivo.getText().toString();
                String nombreArchivo = idEmpresa + ".xml";
                parseXMLImportar(nombreArchivo);
                Toast.makeText(ImportarActivity.this, "Empresa importada", Toast.LENGTH_SHORT).show();
            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
    public void parseXMLImportar(String nombreArchivo){
        infoTablas = (new InfoTablasPullParser()).parseXML(this);
        XmlPullParserFactory factory;
        FileInputStream fis = null;
        try {
            factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();
            File nuevaCarpeta = new File(getExternalStorageDirectory(), "GENERAPP_EXPORTACION");
            File file = new File(nuevaCarpeta, nombreArchivo);
            FileInputStream fileInputStream = new FileInputStream(file);
            fis = new FileInputStream(file);
            xpp.setInput(fis, null);
            int eventType = xpp.getEventType();
            while(eventType != XmlPullParser.END_DOCUMENT){
                if(eventType == XmlPullParser.START_TAG){
                    handleStarTag(xpp.getName());
                }else if(eventType == XmlPullParser.END_TAG){
                    handleEndTag(xpp.getName());
                }else if(eventType == XmlPullParser.TEXT){
                    handleText(xpp.getText());
                }
                eventType = xpp.next();
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(ImportarActivity.this, "No existe el archivo", Toast.LENGTH_SHORT).show();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void handleStarTag(String name) {
        boolean encontrado = false;
        int c = 0;
        while (c < infoTablas.size() && !encontrado){
            if(name.equals(infoTablas.get(c).getNOMBRE())) {
                encontrado = true;
                currentInfoTabla = infoTablas.get(c);
                currentContentValues = new ContentValues();
            }
            c++;
        }
        if(!encontrado) currentVariable = name;
    }
    private void handleText(String text) {
        currentContentValues.put(currentVariable,text);
    }


    public void handleEndTag(String name){
        boolean encontrado = false;
        int c = 0;
        while (c < infoTablas.size() && !encontrado){
            if(name.equals(infoTablas.get(c).getNOMBRE())) {
                encontrado = true;
                DataTablas dataTablas = new DataTablas(this);
                dataTablas.open();
                if(infoTablas.get(c).getTIPO().equals("1")) dataTablas.deleteDatos(currentInfoTabla.getID(),idEmpresa);
                else dataTablas.deleteDatosxId(currentInfoTabla.getID(),currentContentValues.getAsString("_id"));
                dataTablas.insertarValores(currentInfoTabla.getID(),currentContentValues);

            }
            c++;
        }
    }
}
