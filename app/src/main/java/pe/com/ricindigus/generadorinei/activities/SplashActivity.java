package pe.com.ricindigus.generadorinei.activities;

import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.R;
import pe.com.ricindigus.generadorinei.componentes.componente_checkbox.CCheckBox;
import pe.com.ricindigus.generadorinei.componentes.componente_checkbox.CheckBoxPullParser;
import pe.com.ricindigus.generadorinei.componentes.componente_edittext.CEditText;
import pe.com.ricindigus.generadorinei.componentes.componente_edittext.EditTextPullParser;
import pe.com.ricindigus.generadorinei.componentes.componente_radio.CRadio;
import pe.com.ricindigus.generadorinei.componentes.componente_radio.RadioPullParser;
import pe.com.ricindigus.generadorinei.modelo.DataSourceCaptura.Data;
import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.DataComponentes;
import pe.com.ricindigus.generadorinei.parser.MarcoPullParser;
import pe.com.ricindigus.generadorinei.parser.ModuloPullParser;
import pe.com.ricindigus.generadorinei.parser.PaginaPullParser;
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
    ArrayList<CEditText> cEditTexts = new ArrayList<CEditText>();
    ArrayList<CCheckBox> cCheckBoxes = new ArrayList<CCheckBox>();
    ArrayList<CRadio> cRadios = new ArrayList<CRadio>();
    ArrayList<Pagina> paginas = new ArrayList<Pagina>();

    Data data;
    DataComponentes dataComponentes;
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
            CheckBoxPullParser checkBoxPullParser = new CheckBoxPullParser();
            RadioPullParser radioPullParser = new RadioPullParser();
            PaginaPullParser paginaPullParser = new PaginaPullParser();

            marcos = marcoPullParser.parseXML(getApplicationContext());
            usuarios = usuarioParser.parseXML(getApplicationContext());
            ubigeos = ubigeoPullParser.parseXML(getApplicationContext());
            dataComponentes = new DataComponentes(getApplicationContext());
            dataComponentes.open();
            modulos = moduloPullParser.parseXML(getApplicationContext());
            cEditTexts = editTextPullParser.parseXML(getApplicationContext());
            cCheckBoxes = checkBoxPullParser.parseXML(getApplicationContext());
            cRadios = radioPullParser.parseXML(getApplicationContext());
            paginas = paginaPullParser.parseXML(getApplicationContext());
            dataComponentes.close();
        }

        maximo = marcos.size() + usuarios.size() + ubigeos.size() + modulos.size()
                + cEditTexts.size() + cCheckBoxes.size() + cRadios .size() + paginas.size();
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
                for (CEditText cEditText : cEditTexts) {
                    try {
                        dataComponentes.insertarCEditText(cEditText);
                    }catch (SQLiteException e){
                        e.printStackTrace();
                    }
                    publishProgress(i,(int)Math.floor(i/carga));
                    i++;
                }
                for (CCheckBox cCheckBox : cCheckBoxes) {
                    try {
                        dataComponentes.insertarCCheckBox(cCheckBox);
                    }catch (SQLiteException e){
                        e.printStackTrace();
                    }
                    publishProgress(i,(int)Math.floor(i/carga));
                    i++;
                }
                for (CRadio cRadio : cRadios) {
                    try {
                        dataComponentes.insertarCRadio(cRadio);
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
