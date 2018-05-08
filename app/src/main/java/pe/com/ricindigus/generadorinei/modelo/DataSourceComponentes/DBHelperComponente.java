package pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import pe.com.ricindigus.generadorinei.componentes.componente_checkbox.modelo.SQLCheckBox;
import pe.com.ricindigus.generadorinei.componentes.componente_checkeditsuma.modelo.SQLCheckEditSuma;
import pe.com.ricindigus.generadorinei.componentes.componente_ciiu.modelo.SQLCiiu;
import pe.com.ricindigus.generadorinei.componentes.componente_editsuma.modelo.SQLEditSuma;
import pe.com.ricindigus.generadorinei.componentes.componente_edittext.modelo.SQLEditText;
import pe.com.ricindigus.generadorinei.componentes.componente_formulario.modelo.SQLFormulario;
import pe.com.ricindigus.generadorinei.componentes.componente_gps.modelo.SQLGps;
import pe.com.ricindigus.generadorinei.componentes.componente_radio.modelo.SQLRadio;
import pe.com.ricindigus.generadorinei.componentes.componente_ubicacion.modelo.SQLUbicacion;
import pe.com.ricindigus.generadorinei.componentes.componente_visitas.modelo.SQLVisitas;

/**
 * Created by dmorales on 23/11/2017.
 */

public class DBHelperComponente extends SQLiteOpenHelper{
    public static final int DB_VERSION = 1;

    public DBHelperComponente(Context context) {
        super(context, SQLConstantesComponente.NOMBRE_DB, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQLConstantesComponente.SQL_CREATE_TABLA_ENCUESTAS);
        sqLiteDatabase.execSQL(SQLConstantesComponente.SQL_CREATE_TABLA_MODULOS);
        sqLiteDatabase.execSQL(SQLConstantesComponente.SQL_CREATE_TABLA_PAGINAS);
        sqLiteDatabase.execSQL(SQLConstantesComponente.SQL_CREATE_TABLA_PREGUNTAS);
        sqLiteDatabase.execSQL(SQLConstantesComponente.SQL_CREATE_TABLA_EVENTOS);
        sqLiteDatabase.execSQL(SQLEditText.SQL_CREATE_TABLA_EDITTEXT);
        sqLiteDatabase.execSQL(SQLEditText.SQL_CREATE_TABLA_SPEDITTEXT);
        sqLiteDatabase.execSQL(SQLCiiu.SQL_CREATE_TABLA_CIIU);
        sqLiteDatabase.execSQL(SQLCiiu.SQL_CREATE_TABLA_SPCIIU);
        sqLiteDatabase.execSQL(SQLCheckBox.SQL_CREATE_TABLA_CHECKBOX);
        sqLiteDatabase.execSQL(SQLCheckBox.SQL_CREATE_TABLA_SPCHECKBOX);
        sqLiteDatabase.execSQL(SQLRadio.SQL_CREATE_TABLA_RADIO);
        sqLiteDatabase.execSQL(SQLRadio.SQL_CREATE_TABLA_SPRADIO);
        sqLiteDatabase.execSQL(SQLEditSuma.SQL_CREATE_TABLA_EDITSUMA);
        sqLiteDatabase.execSQL(SQLEditSuma.SQL_CREATE_TABLA_SPEDITSUMA);
        sqLiteDatabase.execSQL(SQLCheckEditSuma.SQL_CREATE_TABLA_CHECKEDITSUMA);
        sqLiteDatabase.execSQL(SQLCheckEditSuma.SQL_CREATE_TABLA_SPCHECKEDITSUMA);
        sqLiteDatabase.execSQL(SQLUbicacion.SQL_CREATE_TABLA_UBICACION);
        sqLiteDatabase.execSQL(SQLGps.SQL_CREATE_TABLA_GPS);
        sqLiteDatabase.execSQL(SQLFormulario.SQL_CREATE_TABLA_FORMULARIO);
        sqLiteDatabase.execSQL(SQLFormulario.SQL_CREATE_TABLA_SP_FORMULARIO);
        sqLiteDatabase.execSQL(SQLConstantesComponente.SQL_CREATE_TABLA_OPCION_SPINNER);
        sqLiteDatabase.execSQL(SQLVisitas.SQL_CREATE_TABLA_VISITAS);
        sqLiteDatabase.execSQL(SQLConstantesComponente.SQL_CREATE_TABLA_INFOTABLAS);
        sqLiteDatabase.execSQL(SQLConstantesComponente.SQL_CREATE_TABLA_VARIABLES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL(SQLConstantesComponente.SQL_DELETE_ENCUESTAS);
        sqLiteDatabase.execSQL(SQLConstantesComponente.SQL_DELETE_MODULOS);
        sqLiteDatabase.execSQL(SQLConstantesComponente.SQL_DELETE_PAGINAS);
        sqLiteDatabase.execSQL(SQLConstantesComponente.SQL_DELETE_PREGUNTAS);
        sqLiteDatabase.execSQL(SQLConstantesComponente.SQL_DELETE_EVENTOS);
        sqLiteDatabase.execSQL(SQLEditText.SQL_DELETE_EDITTEXT);
        sqLiteDatabase.execSQL(SQLEditText.SQL_DELETE_SPEDITTEXT);
        sqLiteDatabase.execSQL(SQLCiiu.SQL_DELETE_CIIU);
        sqLiteDatabase.execSQL(SQLCiiu.SQL_DELETE_SPCIIU);
        sqLiteDatabase.execSQL(SQLCheckBox.SQL_DELETE_CHECKBOX);
        sqLiteDatabase.execSQL(SQLCheckBox.SQL_DELETE_SPCHECKBOX);
        sqLiteDatabase.execSQL(SQLRadio.SQL_DELETE_RADIO);
        sqLiteDatabase.execSQL(SQLRadio.SQL_DELETE_SPRADIO);
        sqLiteDatabase.execSQL(SQLEditSuma.SQL_DELETE_EDITSUMA);
        sqLiteDatabase.execSQL(SQLEditSuma.SQL_DELETE_SPEDITSUMA);
        sqLiteDatabase.execSQL(SQLCheckEditSuma.SQL_DELETE_CHECKEDITSUMA);
        sqLiteDatabase.execSQL(SQLCheckEditSuma.SQL_DELETE_SPCHECKEDITSUMA);
        sqLiteDatabase.execSQL(SQLUbicacion.SQL_DELETE_UBICACION);
        sqLiteDatabase.execSQL(SQLGps.SQL_DELETE_GPS);
        sqLiteDatabase.execSQL(SQLFormulario.SQL_DELETE_FORMULARIO);
        sqLiteDatabase.execSQL(SQLFormulario.SQL_DELETE_SP_FORMULARIO);
        sqLiteDatabase.execSQL(SQLConstantesComponente.SQL_DELETE_OPCION_SPINNER);
        sqLiteDatabase.execSQL(SQLConstantesComponente.SQL_DELETE_INFOTABLAS);
        sqLiteDatabase.execSQL(SQLConstantesComponente.SQL_DELETE_VARIABLES);
        sqLiteDatabase.execSQL(SQLVisitas.SQL_DELETE_VISITAS);
        onCreate(sqLiteDatabase);
    }
}
