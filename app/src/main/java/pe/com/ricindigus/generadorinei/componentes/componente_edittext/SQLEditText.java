package pe.com.ricindigus.generadorinei.componentes.componente_edittext;

/**
 * Created by RICARDO on 1/01/2018.
 */

public class SQLEditText {
    public static final String tablaEditText = "edittexts";
    public static final String tablaSPEditText = "spedittexts";

    //COLUMNAS EDIT TEXT
    public static final String EDITTEXT_ID = "ID";
    public static final String EDITTEXT_MODULO = "MODULO";
    public static final String EDITTEXT_NUMERO = "NUMERO";
    public static final String EDITTEXT_PREGUNTA = "PREGUNTA";

    //COLUMNAS SUBPREGUNTAS EDITTEXT
    public static final String SPEDITTEXT_ID = "ID";
    public static final String SPEDITTEXT_ID_PREGUNTA = "ID_PREGUNTA";
    public static final String SPEDITTEXT_SUBPREGUNTA = "SUBPREGUNTA";
    public static final String SPEDITTEXT_VARIABLE = "VARIABLE";
    public static final String SPEDITTEXT_TIPO = "TIPO";
    public static final String SPEDITTEXT_LONGITUD = "LONGITUD";

    public static final String SQL_CREATE_TABLA_EDITTEXT =
            "CREATE TABLE " + tablaEditText + "(" +
                    EDITTEXT_ID + " TEXT PRIMARY KEY," +
                    EDITTEXT_MODULO + " TEXT," +
                    EDITTEXT_NUMERO + " TEXT," +
                    EDITTEXT_PREGUNTA + " TEXT" + ");"
            ;

    public static final String SQL_CREATE_TABLA_SPEDITTEXT =
            "CREATE TABLE " + tablaSPEditText + "(" +
                    SPEDITTEXT_ID + " TEXT PRIMARY KEY," +
                    SPEDITTEXT_ID_PREGUNTA + " TEXT," +
                    SPEDITTEXT_SUBPREGUNTA + " TEXT," +
                    SPEDITTEXT_VARIABLE + " TEXT," +
                    SPEDITTEXT_TIPO + " TEXT," +
                    SPEDITTEXT_LONGITUD + " TEXT" + ");"
            ;
    
    public static final String SQL_DELETE_EDITTEXT = "DROP TABLE " + tablaEditText;
    public static final String SQL_DELETE_SPEDITTEXT = "DROP TABLE " + tablaSPEditText;

    //WHERE
    public static final String WHERE_CLAUSE_ID = "ID=?";
    public static final String WHERE_CLAUSE_ID_PREGUNTA = "ID_PREGUNTA=?";


    public static final String[] ALL_COLUMNS_EDITTEXT = {
            EDITTEXT_ID, EDITTEXT_MODULO , EDITTEXT_NUMERO , EDITTEXT_PREGUNTA
    };

    public static final String[] ALL_COLUMNS_SPEDITTEXT = {
            SPEDITTEXT_ID , SPEDITTEXT_ID_PREGUNTA , SPEDITTEXT_SUBPREGUNTA , 
            SPEDITTEXT_VARIABLE , SPEDITTEXT_TIPO , SPEDITTEXT_LONGITUD 
    };


}
