package pe.com.ricindigus.generadorinei.componentes.componente_radio;

/**
 * Created by RICARDO on 1/01/2018.
 */

public class SQLRadio {
    public static final String tablaRadio = "radios";
    public static final String tablaSPRadio = "spradios";


    //COLUMNAS RADIO
    public static final String RADIO_ID = "ID";
    public static final String RADIO_MODULO = "MODULO";
    public static final String RADIO_NUMERO = "NUMERO";
    public static final String RADIO_PREGUNTA = "PREGUNTA";

    //COLUMNAS SUBPREGUNTAS RADIO
    public static final String SPRADIO_ID = "ID";
    public static final String SPRADIO_ID_PREGUNTA = "ID_PREGUNTA";
    public static final String SPRADIO_SUBPREGUNTA = "SUBPREGUNTA";
    public static final String SPRADIO_VARIABLE = "VARIABLE";
    public static final String SPRADIO_VARDESC = "VARDESC";


    public static final String SQL_CREATE_TABLA_RADIO =
            "CREATE TABLE " + tablaRadio + "(" +
                    RADIO_ID + " TEXT PRIMARY KEY," +
                    RADIO_MODULO + " TEXT," +
                    RADIO_NUMERO + " TEXT," +
                    RADIO_PREGUNTA + " TEXT" + ");"
            ;

    public static final String SQL_CREATE_TABLA_SPRADIO =
            "CREATE TABLE " + tablaSPRadio + "(" +
                    SPRADIO_ID + " TEXT PRIMARY KEY," +
                    SPRADIO_ID_PREGUNTA + " TEXT," +
                    SPRADIO_SUBPREGUNTA + " TEXT," +
                    SPRADIO_VARIABLE + " TEXT," +
                    SPRADIO_VARDESC + " TEXT" + ");"
            ;


    public static final String SQL_DELETE_RADIO = "DROP TABLE " + tablaRadio;
    public static final String SQL_DELETE_SPRADIO = "DROP TABLE " + tablaSPRadio;


    //WHERE
    public static final String WHERE_CLAUSE_ID = "ID=?";
    public static final String WHERE_CLAUSE_ID_PREGUNTA = "ID_PREGUNTA=?";


    public static final String[] ALL_COLUMNS_RADIO = {
            RADIO_ID , RADIO_MODULO, RADIO_NUMERO , RADIO_PREGUNTA
    };

    public static final String[] ALL_COLUMNS_SPRADIO = {
            SPRADIO_ID , SPRADIO_ID_PREGUNTA, SPRADIO_SUBPREGUNTA , SPRADIO_VARIABLE , SPRADIO_VARDESC
    };
}
