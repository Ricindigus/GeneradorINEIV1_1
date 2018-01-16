package pe.com.ricindigus.generadorinei.activities;

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
import pe.com.ricindigus.generadorinei.componentes.componente_checkbox.DataCheckBox;
import pe.com.ricindigus.generadorinei.componentes.componente_checkbox.POJOCheckBox;
import pe.com.ricindigus.generadorinei.componentes.componente_checkbox.CheckBoxPullParser;
import pe.com.ricindigus.generadorinei.componentes.componente_checkbox.SPCheckBox;
import pe.com.ricindigus.generadorinei.componentes.componente_checkbox.SPCheckBoxPullParser;
import pe.com.ricindigus.generadorinei.componentes.componente_edittext.DataEditText;
import pe.com.ricindigus.generadorinei.componentes.componente_edittext.POJOEditText;
import pe.com.ricindigus.generadorinei.componentes.componente_edittext.EditTextPullParser;
import pe.com.ricindigus.generadorinei.componentes.componente_edittext.SPEditText;
import pe.com.ricindigus.generadorinei.componentes.componente_edittext.SPEditTextPullParser;
import pe.com.ricindigus.generadorinei.componentes.componente_radio.DataRadio;
import pe.com.ricindigus.generadorinei.componentes.componente_radio.POJORadio;
import pe.com.ricindigus.generadorinei.componentes.componente_radio.RadioPullParser;
import pe.com.ricindigus.generadorinei.componentes.componente_radio.SPRadio;
import pe.com.ricindigus.generadorinei.componentes.componente_radio.SPRadioPullParser;
import pe.com.ricindigus.generadorinei.modelo.DataSourceCaptura.Data;
import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.DataComponentes;
import pe.com.ricindigus.generadorinei.modelo.DataSourceTablasGuardado.DataTablas;
import pe.com.ricindigus.generadorinei.parser.MarcoPullParser;
import pe.com.ricindigus.generadorinei.parser.ModuloPullParser;
import pe.com.ricindigus.generadorinei.parser.PaginaPullParser;
import pe.com.ricindigus.generadorinei.parser.TablaGuardadoPullParser;
import pe.com.ricindigus.generadorinei.parser.UbigeoPullParser;
import pe.com.ricindigus.generadorinei.parser.UsuariosPullParser;
import pe.com.ricindigus.generadorinei.pojos.Marco;
import pe.com.ricindigus.generadorinei.pojos.Modulo;
import pe.com.ricindigus.generadorinei.pojos.Pagina;
import pe.com.ricindigus.generadorinei.pojos.Ubigeo;
import pe.com.ricindigus.generadorinei.pojos.Usuario;

public class SplashActivity extends AppCompatActivity {

    TextView txtMensaje;
    ProgressBar progressBar;
    ProgressBar progressBar1;
    ArrayList<Marco> marcos = new ArrayList<Marco>();
    ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    ArrayList<Ubigeo> ubigeos = new ArrayList<Ubigeo>();
    ArrayList<Modulo> modulos = new ArrayList<Modulo>();
    ArrayList<POJOEditText> POJOEditTexts = new ArrayList<POJOEditText>();
    ArrayList<SPEditText> spEditTexts = new ArrayList<SPEditText>();
    ArrayList<POJOCheckBox> POJOCheckBoxes = new ArrayList<POJOCheckBox>();
    ArrayList<SPCheckBox> spCheckBoxes  = new ArrayList<SPCheckBox>();
    ArrayList<POJORadio> POJORadios = new ArrayList<POJORadio>();
    ArrayList<SPRadio> spRadios = new ArrayList<SPRadio>();
    ArrayList<Pagina> paginas = new ArrayList<Pagina>();

    Data data;
    DataComponentes dataComponentes;
    DataEditText dataEditText;
    DataCheckBox dataCheckBox;
    DataRadio dataRadio;


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
            UbigeoPullParser ubigeoPullParser = new UbigeoPullParser();
            ModuloPullParser moduloPullParser = new ModuloPullParser();
            EditTextPullParser editTextPullParser = new EditTextPullParser();
            SPEditTextPullParser spEditTextPullParser = new SPEditTextPullParser();
            CheckBoxPullParser checkBoxPullParser = new CheckBoxPullParser();
            SPCheckBoxPullParser spCheckBoxPullParser = new SPCheckBoxPullParser();
            RadioPullParser radioPullParser = new RadioPullParser();
            SPRadioPullParser spRadioPullParser = new SPRadioPullParser();
            PaginaPullParser paginaPullParser = new PaginaPullParser();


            marcos = marcoPullParser.parseXML(getApplicationContext());
            usuarios = usuarioParser.parseXML(getApplicationContext());
            ubigeos = ubigeoPullParser.parseXML(getApplicationContext());
            dataComponentes = new DataComponentes(getApplicationContext());
            dataComponentes.open();
            modulos = moduloPullParser.parseXML(getApplicationContext());
            POJOEditTexts = editTextPullParser.parseXML(getApplicationContext());
            spEditTexts = spEditTextPullParser.parseXML(getApplicationContext());
            POJOCheckBoxes = checkBoxPullParser.parseXML(getApplicationContext());
            spCheckBoxes = spCheckBoxPullParser.parseXML(getApplicationContext());
            POJORadios = radioPullParser.parseXML(getApplicationContext());
            spRadios = spRadioPullParser.parseXML(getApplicationContext());
            paginas = paginaPullParser.parseXML(getApplicationContext());
            dataComponentes.close();
        }

        maximo = marcos.size() + usuarios.size() + ubigeos.size() + modulos.size()
                + POJOEditTexts.size() + spEditTexts.size()
                + POJOCheckBoxes.size() + spCheckBoxes.size()
                + POJORadios.size() + spRadios.size()
                + paginas.size();
//                + POJOEditTexts.size() + POJOCheckBoxes.size() + POJORadios.size() + paginas.size();
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
            data = new Data(getApplicationContext());
            data.open();
            dataComponentes = new DataComponentes(getApplicationContext());
            dataComponentes.open();
            dataEditText = new DataEditText(getApplicationContext());
            dataEditText.open();
            dataCheckBox = new DataCheckBox(getApplicationContext());
            dataCheckBox.open();
            dataRadio = new DataRadio(getApplicationContext());
            dataRadio.open();
            long items = data.getNumeroItemsMarco();
            if(items == 0){
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
                for (POJOEditText pojoEditText : POJOEditTexts) {
                    try {
                        dataEditText.insertarPOJOEditText(pojoEditText);
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
                for (POJOCheckBox pojoCheckBox : POJOCheckBoxes) {
                    try {
                        dataCheckBox.insertarPOJOCheckBox(pojoCheckBox);
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
                for (POJORadio POJORadio : POJORadios) {
                    try {
                        dataRadio.insertarPOJORadio(POJORadio);
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
            dataEditText.close();
            dataCheckBox.close();
            dataRadio.close();
            DataTablas dataTablas = new DataTablas(getApplicationContext());
            dataTablas.open();
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
            if(values[0] > marcos.size()+usuarios.size() && values[0] < marcos.size()+usuarios.size()+ubigeos.size()) texto = "CARGANDO UBIGEO " + contador +"%";
            if(values[0] > marcos.size()+usuarios.size()+ubigeos.size() && values[0] < maximo) texto = "CARGANDO ENCUESTA " + contador +"%";
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
