package pe.com.ricindigus.generadorinei.componentes.componente_checkbox.modelo;

/**
 * Created by RICARDO on 1/01/2018.
 */

public class SQLCheckBox {
    public static final String tablaCheckBox = "checkboxs";
    public static final String tablaSPCheckBox = "spcheckboxs";

    //COLUMNAS CHECKBOX
    public static final String CHECKBOX_ID = "ID";
    public static final String CHECKBOX_MODULO = "MODULO";
    public static final String CHECKBOX_NUMERO = "NUMERO";
    public static final String CHECKBOX_PREGUNTA = "PREGUNTA";

    //COLUMNAS SPCHECKBOX
    public static final String SPCHECKBOX_ID = "ID";
    public static final String SPCHECKBOX_ID_PREGUNTA = "ID_PREGUNTA";
    public static final String SPCHECKBOX_SUBPREGUNTA = "SUBPREGUNTA";
    public static final String SPCHECKBOX_VARIABLE = "VARIABLE";
    public static final String SPCHECKBOX_VARDESC = "VARDESC";


    public static final String SQL_CREATE_TABLA_CHECKBOX =
            "CREATE TABLE " + tablaCheckBox + "(" +
                    CHECKBOX_ID + " TEXT PRIMARY KEY," +
                    CHECKBOX_MODULO + " TEXT," +
                    CHECKBOX_NUMERO + " TEXT," +
                    CHECKBOX_PREGUNTA + " TEXT" + ");"
            ;

    public static final String SQL_CREATE_TABLA_SPCHECKBOX =
            "CREATE TABLE " + tablaSPCheckBox + "(" +
                    SPCHECKBOX_ID + " TEXT PRIMARY KEY," +
                    SPCHECKBOX_ID_PREGUNTA + " TEXT," +
                    SPCHECKBOX_SUBPREGUNTA + " TEXT," +
                    SPCHECKBOX_VARIABLE + " TEXT," +
                    SPCHECKBOX_VARDESC + " TEXT" + ");"
            ;

    public static final String SQL_DELETE_CHECKBOX = "DROP TABLE " + tablaCheckBox;
    public static final String SQL_DELETE_SPCHECKBOX = "DROP TABLE " + tablaSPCheckBox;


    //WHERE
    public static final String WHERE_CLAUSE_ID = "ID=?";
    public static final String WHERE_CLAUSE_ID_PREGUNTA = "ID_PREGUNTA=?";


    public static final String[] ALL_COLUMNS_CHECKBOX = {
            CHECKBOX_ID , CHECKBOX_MODULO , CHECKBOX_NUMERO , CHECKBOX_PREGUNTA
    };
    public static final String[] ALL_COLUMNS_SPCHECKBOX = {
            SPCHECKBOX_ID, SPCHECKBOX_ID_PREGUNTA, SPCHECKBOX_SUBPREGUNTA,
            SPCHECKBOX_VARIABLE, SPCHECKBOX_VARDESC
    };
}
