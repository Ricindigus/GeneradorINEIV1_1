package pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes;

/**
 * Created by dmorales on 23/11/2017.
 */

public class SQLConstantesComponente {
    public static final String NOMBRE_DB = "generador.db";

    //TABLAS
    public static final String tablaEncuestas = "encuestas";
    public static final String tablaPreguntas = "preguntas";
    public static final String tablaEditText = "editTexts";

    //COLUMNAS ENCUESTAS
    public static final String ID_ENCUESTA = "ID";
    public static final String TITULO_ENCUESTA = "TITULO";

    //COLUMNAS PREGUNTAS
    public static final String ID_PREGUNTA = "ID";
    public static final String TEXTO_PREGUNTA = "PREGUNTA";
    public static final String TIPO_PREGUNTA = "TIPO";

    //COLUMNAS EDIT TEXT
    public static final String EDITTEXT_ID = "ID";
    public static final String EDITTEXT_SP1 = "SP1";
    public static final String EDITTEXT_VAR1 = "VAR1";
    public static final String EDITTEXT_SP2 = "SP2";
    public static final String EDITTEXT_VAR2 = "VAR2";
    public static final String EDITTEXT_SP3 = "SP3";
    public static final String EDITTEXT_VAR3 = "VAR3";


    //CREACION DE TABLAS (CREATE)
    public static final String SQL_CREATE_TABLA_ENCUESTAS =
            "CREATE TABLE " + tablaEncuestas + "(" +
                    ID_ENCUESTA + " TEXT PRIMARY KEY," +
                    TITULO_ENCUESTA + " TEXT" + ");"
            ;

    public static final String SQL_CREATE_TABLA_PREGUNTAS =
            "CREATE TABLE " + tablaPreguntas + "(" +
                    ID_PREGUNTA + " TEXT PRIMARY KEY," +
                    TEXTO_PREGUNTA + " TEXT," +
                    TIPO_PREGUNTA + " TEXT" + ");"
            ;

    public static final String SQL_CREATE_TABLA_EDITTEXT =
            "CREATE TABLE " + tablaEditText + "(" +
                    EDITTEXT_ID + " TEXT PRIMARY KEY," +
                    EDITTEXT_SP1 + " TEXT," +
                    EDITTEXT_VAR1 + " TEXT," +
                    EDITTEXT_SP2 + " TEXT," +
                    EDITTEXT_VAR2 + " TEXT," +
                    EDITTEXT_SP3 + " TEXT," +
                    EDITTEXT_VAR3 + " TEXT" + ");"
            ;

    //CLAUSULA WHERE BUSQUEDA (WHERE)
    public static final String WHERE_CLAUSE_ID = "ID=?";


    //BORRADO DE TABLAS (DELETE)
    public static final String SQL_DELETE_ENCUESTAS = "DROP TABLE " + tablaEncuestas;
    public static final String SQL_DELETE_PREGUNTAS = "DROP TABLE " + tablaPreguntas;
    public static final String SQL_DELETE_EDITTEXT = "DROP TABLE " + tablaEditText;


    //TRAER TODAS LAS COLUMNAS
    public static final String[] ALL_COLUMNS_ENCUESTA = {
            ID_ENCUESTA, TITULO_ENCUESTA
    };

    public static final String[] ALL_COLUMNS_PREGUNTAS = {
        ID_PREGUNTA, TEXTO_PREGUNTA, TIPO_PREGUNTA
    };

    public static final String[] ALL_COLUMNS_EDITTEXT = {
    EDITTEXT_ID, EDITTEXT_SP1 , EDITTEXT_VAR1, EDITTEXT_SP2 , EDITTEXT_VAR2 , EDITTEXT_SP3 , EDITTEXT_VAR3
    };


}
