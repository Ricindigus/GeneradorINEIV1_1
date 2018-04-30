package pe.com.ricindigus.generadorinei.componentes.componente_editsuma.modelo;

/**
 * Created by RICARDO on 1/01/2018.
 */

public class SQLEditSuma {
    public static final String tablaEditSuma = "editsumas";
    public static final String tablaSPEditSuma = "speditsumas";

    //COLUMNAS EDITSUMA
    public static final String EDITSUMA_ID = "ID";
    public static final String EDITSUMA_MODULO = "MODULO";
    public static final String EDITSUMA_NUMERO = "NUMERO";
    public static final String EDITSUMA_PREGUNTA = "PREGUNTA";
    public static final String EDITSUMA_CABPREG = "CABPREG";
    public static final String EDITSUMA_CABRES = "CABRES";
    public static final String EDITSUMA_VALSUMA = "VALSUMA";


    //COLUMNAS SUBPREGUNTAS EDITSUMA
    public static final String SPEDITSUMA_ID = "ID";
    public static final String SPEDITSUMA_ID_PREGUNTA = "ID_PREGUNTA";
    public static final String SPEDITSUMA_SUBPREGUNTA = "SUBPREGUNTA";
    public static final String SPEDITSUMA_VARIABLE = "VARIABLE";
    public static final String SPEDITSUMA_LONGITUD = "LONGITUD";


    public static final String SQL_CREATE_TABLA_EDITSUMA =
            "CREATE TABLE " + tablaEditSuma + "(" +
                    EDITSUMA_ID + " TEXT PRIMARY KEY," +
                    EDITSUMA_MODULO + " TEXT," +
                    EDITSUMA_NUMERO + " TEXT," +
                    EDITSUMA_PREGUNTA + " TEXT," +
                    EDITSUMA_CABRES + " TEXT," +
                    EDITSUMA_CABPREG + " TEXT," +
                    EDITSUMA_VALSUMA + " TEXT" + ");"
            ;

    public static final String SQL_CREATE_TABLA_SPEDITSUMA =
            "CREATE TABLE " + tablaSPEditSuma + "(" +
                    SPEDITSUMA_ID + " TEXT PRIMARY KEY," +
                    SPEDITSUMA_ID_PREGUNTA + " TEXT," +
                    SPEDITSUMA_SUBPREGUNTA + " TEXT," +
                    SPEDITSUMA_VARIABLE + " TEXT," +
                    SPEDITSUMA_LONGITUD + " TEXT" + ");"
            ;
    
    public static final String SQL_DELETE_EDITSUMA = "DROP TABLE " + tablaEditSuma;
    public static final String SQL_DELETE_SPEDITSUMA = "DROP TABLE " + tablaSPEditSuma;

    //WHERE
    public static final String WHERE_CLAUSE_ID = "ID=?";
    public static final String WHERE_CLAUSE_ID_PREGUNTA = "ID_PREGUNTA=?";

    public static final String[] ALL_COLUMNS_EDITSUMA = {
            EDITSUMA_ID, EDITSUMA_MODULO , EDITSUMA_NUMERO , EDITSUMA_PREGUNTA,
            EDITSUMA_CABPREG, EDITSUMA_CABRES, EDITSUMA_VALSUMA
    };

    public static final String[] ALL_COLUMNS_SPEDITSUMA = {
            SPEDITSUMA_ID , SPEDITSUMA_ID_PREGUNTA , SPEDITSUMA_SUBPREGUNTA ,
            SPEDITSUMA_VARIABLE , SPEDITSUMA_LONGITUD
    };


}
