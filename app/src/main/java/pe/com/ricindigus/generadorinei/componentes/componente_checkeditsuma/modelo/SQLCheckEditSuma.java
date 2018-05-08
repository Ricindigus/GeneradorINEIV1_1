package pe.com.ricindigus.generadorinei.componentes.componente_checkeditsuma.modelo;

/**
 * Created by RICARDO on 1/01/2018.
 */

public class SQLCheckEditSuma {
    public static final String tablaCheckEditSuma = "checkeditsumas";
    public static final String tablaSPCheckEditSuma = "spcheckeditsumas";

    //COLUMNAS CHECKEDITSUMA
    public static final String CHECKEDITSUMA_ID = "ID";
    public static final String CHECKEDITSUMA_MODULO = "MODULO";
    public static final String CHECKEDITSUMA_NUMERO = "NUMERO";
    public static final String CHECKEDITSUMA_PREGUNTA = "PREGUNTA";
    public static final String CHECKEDITSUMA_CABPREG = "CABPREG";
    public static final String CHECKEDITSUMA_CABRES = "CABRES";
    public static final String CHECKEDITSUMA_VALSUMA = "VALSUMA";


    //COLUMNAS SUBPREGUNTAS CHECKEDITSUMA
    public static final String SPCHECKEDITSUMA_ID = "ID";
    public static final String SPCHECKEDITSUMA_ID_PREGUNTA = "ID_PREGUNTA";
    public static final String SPCHECKEDITSUMA_SUBPREGUNTA = "SUBPREGUNTA";
    public static final String SPCHECKEDITSUMA_VARIABLE = "VARIABLE";
    public static final String SPCHECKEDITSUMA_VARESP = "VARESP";
    public static final String SPCHECKEDITSUMA_LONGITUD = "LONGITUD";


    public static final String SQL_CREATE_TABLA_CHECKEDITSUMA =
            "CREATE TABLE " + tablaCheckEditSuma + "(" +
                    CHECKEDITSUMA_ID + " TEXT PRIMARY KEY," +
                    CHECKEDITSUMA_MODULO + " TEXT," +
                    CHECKEDITSUMA_NUMERO + " TEXT," +
                    CHECKEDITSUMA_PREGUNTA + " TEXT," +
                    CHECKEDITSUMA_CABRES + " TEXT," +
                    CHECKEDITSUMA_CABPREG + " TEXT," +
                    CHECKEDITSUMA_VALSUMA + " TEXT" + ");"
            ;

    public static final String SQL_CREATE_TABLA_SPCHECKEDITSUMA =
            "CREATE TABLE " + tablaSPCheckEditSuma + "(" +
                    SPCHECKEDITSUMA_ID + " TEXT PRIMARY KEY," +
                    SPCHECKEDITSUMA_ID_PREGUNTA + " TEXT," +
                    SPCHECKEDITSUMA_SUBPREGUNTA + " TEXT," +
                    SPCHECKEDITSUMA_VARIABLE + " TEXT," +
                    SPCHECKEDITSUMA_VARESP + " TEXT," +
                    SPCHECKEDITSUMA_LONGITUD + " TEXT" + ");"
            ;
    
    public static final String SQL_DELETE_CHECKEDITSUMA = "DROP TABLE " + tablaCheckEditSuma;
    public static final String SQL_DELETE_SPCHECKEDITSUMA = "DROP TABLE " + tablaSPCheckEditSuma;

    //WHERE
    public static final String WHERE_CLAUSE_ID = "ID=?";
    public static final String WHERE_CLAUSE_ID_PREGUNTA = "ID_PREGUNTA=?";

    public static final String[] ALL_COLUMNS_CHECKEDITSUMA = {
            CHECKEDITSUMA_ID, CHECKEDITSUMA_MODULO , CHECKEDITSUMA_NUMERO , CHECKEDITSUMA_PREGUNTA,
            CHECKEDITSUMA_CABPREG, CHECKEDITSUMA_CABRES, CHECKEDITSUMA_VALSUMA
    };

    public static final String[] ALL_COLUMNS_SPCHECKEDITSUMA = {
            SPCHECKEDITSUMA_ID , SPCHECKEDITSUMA_ID_PREGUNTA , SPCHECKEDITSUMA_SUBPREGUNTA ,
            SPCHECKEDITSUMA_VARESP , SPCHECKEDITSUMA_VARIABLE , SPCHECKEDITSUMA_LONGITUD
    };


}
