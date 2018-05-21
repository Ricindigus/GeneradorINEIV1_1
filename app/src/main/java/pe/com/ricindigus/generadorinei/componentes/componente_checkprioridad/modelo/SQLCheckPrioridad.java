package pe.com.ricindigus.generadorinei.componentes.componente_checkprioridad.modelo;

/**
 * Created by RICARDO on 1/01/2018.
 */

public class SQLCheckPrioridad {
    public static final String tablaCheckPrioridad = "checkprioridades";
    public static final String tablaSPCheckPrioridad = "spcheckprioridades";

    //COLUMNAS CHECKPRIORIDAD
    public static final String CHECKPRIORIDAD_ID = "ID";
    public static final String CHECKPRIORIDAD_MODULO = "MODULO";
    public static final String CHECKPRIORIDAD_NUMERO = "NUMERO";
    public static final String CHECKPRIORIDAD_PREGUNTA = "PREGUNTA";
    public static final String CHECKPRIORIDAD_CAB1 = "CAB1";
    public static final String CHECKPRIORIDAD_CAB2 = "CAB2";
    public static final String CHECKPRIORIDAD_PRIORIDAD = "PRIORIDAD";


    //COLUMNAS SUBPREGUNTAS CHECKPRIORIDAD
    public static final String SPCHECKPRIORIDAD_ID = "ID";
    public static final String SPCHECKPRIORIDAD_ID_PREGUNTA = "ID_PREGUNTA";
    public static final String SPCHECKPRIORIDAD_SUBPREGUNTA = "SUBPREGUNTA";
    public static final String SPCHECKPRIORIDAD_VARCK = "VARCK";
    public static final String SPCHECKPRIORIDAD_VARESP = "VARESP";
    public static final String SPCHECKPRIORIDAD_VARSP = "VARSP";


    public static final String SQL_CREATE_TABLA_CHECKPRIORIDAD =
            "CREATE TABLE " + tablaCheckPrioridad + "(" +
                    CHECKPRIORIDAD_ID + " TEXT PRIMARY KEY," +
                    CHECKPRIORIDAD_MODULO + " TEXT," +
                    CHECKPRIORIDAD_NUMERO + " TEXT," +
                    CHECKPRIORIDAD_PREGUNTA + " TEXT," +
                    CHECKPRIORIDAD_CAB1 + " TEXT," +
                    CHECKPRIORIDAD_CAB2 + " TEXT," +
                    CHECKPRIORIDAD_PRIORIDAD + " TEXT" + ");"
            ;

    public static final String SQL_CREATE_TABLA_SPCHECKPRIORIDAD =
            "CREATE TABLE " + tablaSPCheckPrioridad + "(" +
                    SPCHECKPRIORIDAD_ID + " TEXT PRIMARY KEY," +
                    SPCHECKPRIORIDAD_ID_PREGUNTA + " TEXT," +
                    SPCHECKPRIORIDAD_SUBPREGUNTA + " TEXT," +
                    SPCHECKPRIORIDAD_VARCK + " TEXT," +
                    SPCHECKPRIORIDAD_VARESP + " TEXT," +
                    SPCHECKPRIORIDAD_VARSP + " TEXT" + ");"
            ;
    
    public static final String SQL_DELETE_CHECKPRIORIDAD = "DROP TABLE " + tablaCheckPrioridad;
    public static final String SQL_DELETE_SPCHECKPRIORIDAD = "DROP TABLE " + tablaSPCheckPrioridad;

    //WHERE
    public static final String WHERE_CLAUSE_ID = "ID=?";
    public static final String WHERE_CLAUSE_ID_PREGUNTA = "ID_PREGUNTA=?";

    public static final String[] ALL_COLUMNS_CHECKPRIORIDAD = {
            CHECKPRIORIDAD_ID, CHECKPRIORIDAD_MODULO , CHECKPRIORIDAD_NUMERO , CHECKPRIORIDAD_PREGUNTA,
            CHECKPRIORIDAD_CAB1, CHECKPRIORIDAD_CAB2, CHECKPRIORIDAD_PRIORIDAD
    };

    public static final String[] ALL_COLUMNS_SPCHECKPRIORIDAD = {
            SPCHECKPRIORIDAD_ID , SPCHECKPRIORIDAD_ID_PREGUNTA , SPCHECKPRIORIDAD_SUBPREGUNTA ,
            SPCHECKPRIORIDAD_VARESP , SPCHECKPRIORIDAD_VARCK , SPCHECKPRIORIDAD_VARSP
    };


}
