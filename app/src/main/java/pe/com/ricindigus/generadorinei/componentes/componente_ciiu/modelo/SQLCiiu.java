package pe.com.ricindigus.generadorinei.componentes.componente_ciiu.modelo;

/**
 * Created by dmorales on 19/04/2018.
 */

public class SQLCiiu {
    public static final String tablaCiius = "ciius";
    public static final String tablaSPCiius = "spciius";

    //COLUMNAS CIIU
    public static final String CIIU_ID = "ID";
    public static final String CIIU_MODULO = "MODULO";
    public static final String CIIU_NUMERO = "NUMERO";
    public static final String CIIU_PREGUNTA = "PREGUNTA";

    //COLUMNAS SUBPREGUNTAS CIIU
    public static final String SPCIIU_ID = "ID";
    public static final String SPCIIU_ID_PREGUNTA = "ID_PREGUNTA";
    public static final String SPCIIU_VARACT = "VARACT";
    public static final String SPCIIU_VARAUTO = "VARAUTO";
    public static final String SPCIIU_VARCK = "VARCK";

    public static final String SQL_CREATE_TABLA_CIIU =
            "CREATE TABLE " + tablaCiius + "(" +
                    CIIU_ID + " TEXT PRIMARY KEY," +
                    CIIU_MODULO + " TEXT," +
                    CIIU_NUMERO + " TEXT," +
                    CIIU_PREGUNTA + " TEXT" + ");"
            ;

    public static final String SQL_CREATE_TABLA_SPCIIU =
            "CREATE TABLE " + tablaSPCiius + "(" +
                    SPCIIU_ID + " TEXT PRIMARY KEY," +
                    SPCIIU_ID_PREGUNTA + " TEXT," +
                    SPCIIU_VARACT + " TEXT," +
                    SPCIIU_VARAUTO + " TEXT," +
                    SPCIIU_VARCK + " TEXT" + ");"
            ;

    public static final String SQL_DELETE_CIIU = "DROP TABLE " + tablaCiius;
    public static final String SQL_DELETE_SPCIIU = "DROP TABLE " + tablaSPCiius;

    //WHERE
    public static final String WHERE_CLAUSE_ID = "ID=?";
    public static final String WHERE_CLAUSE_ID_PREGUNTA = "ID_PREGUNTA=?";


    public static final String[] ALL_COLUMNS_CIIU = {
            CIIU_ID, CIIU_MODULO , CIIU_NUMERO , CIIU_PREGUNTA
    };

    public static final String[] ALL_COLUMNS_SPCIIU = {
            SPCIIU_ID , SPCIIU_ID_PREGUNTA ,
            SPCIIU_VARACT , SPCIIU_VARACT , SPCIIU_VARCK
    };
}
