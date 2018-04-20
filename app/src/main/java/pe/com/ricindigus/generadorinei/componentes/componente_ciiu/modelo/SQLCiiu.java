package pe.com.ricindigus.generadorinei.componentes.componente_ciiu.modelo;

/**
 * Created by dmorales on 19/04/2018.
 */

public class SQLCiiu {
    public static final String tablaPCiius = "pciius";
    public static final String tablaSPCiius = "spciius";

    //COLUMNAS CIIU
    public static final String PCIIU_ID = "ID";
    public static final String PCIIU_MODULO = "MODULO";
    public static final String PCIIU_NUMERO = "NUMERO";
    public static final String PCIIU_PREGUNTA = "PREGUNTA";

    //COLUMNAS SUBPREGUNTAS CIIU
    public static final String SPCIIU_ID = "ID";
    public static final String SPCIIU_ID_PREGUNTA = "ID_PREGUNTA";
    public static final String SPCIIU_SUBPREGUNTA = "SUBPREGUNTA";
    public static final String SPCIIU_VARACT = "VARACT";
    public static final String SPCIIU_VARCIIU = "VARCIIU";
    public static final String SPCIIU_VARCK = "VARCK";

    public static final String SQL_CREATE_TABLA_CIIU =
            "CREATE TABLE " + tablaPCiius + "(" +
                    PCIIU_ID + " TEXT PRIMARY KEY," +
                    PCIIU_MODULO + " TEXT," +
                    PCIIU_NUMERO + " TEXT," +
                    PCIIU_PREGUNTA + " TEXT" + ");"
            ;

    public static final String SQL_CREATE_TABLA_SPCIIU =
            "CREATE TABLE " + tablaSPCiius + "(" +
                    SPCIIU_ID + " TEXT PRIMARY KEY," +
                    SPCIIU_ID_PREGUNTA + " TEXT," +
                    SPCIIU_SUBPREGUNTA + " TEXT," +
                    SPCIIU_VARACT + " TEXT," +
                    SPCIIU_VARCIIU + " TEXT," +
                    SPCIIU_VARCK + " TEXT" + ");"
            ;

    public static final String SQL_DELETE_CIIU = "DROP TABLE " + tablaPCiius;
    public static final String SQL_DELETE_SPCIIU = "DROP TABLE " + tablaSPCiius;

    //WHERE
    public static final String WHERE_CLAUSE_ID = "ID=?";
    public static final String WHERE_CLAUSE_ID_PREGUNTA = "ID_PREGUNTA=?";


    public static final String[] ALL_COLUMNS_CIIU = {
            PCIIU_ID, PCIIU_MODULO, PCIIU_NUMERO, PCIIU_PREGUNTA
    };

    public static final String[] ALL_COLUMNS_SPCIIU = {
            SPCIIU_ID , SPCIIU_ID_PREGUNTA , SPCIIU_SUBPREGUNTA ,
            SPCIIU_VARACT , SPCIIU_VARCIIU , SPCIIU_VARCK
    };
}
