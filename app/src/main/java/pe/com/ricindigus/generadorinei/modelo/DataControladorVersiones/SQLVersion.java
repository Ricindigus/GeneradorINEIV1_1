package pe.com.ricindigus.generadorinei.modelo.DataControladorVersiones;

/**
 * Created by dmorales on 16/03/2018.
 */

public class SQLVersion {
    public static final String DB = "bdversiones.db";

    //TABLAS
    public static final String tablaVersiones = "versiones";

    //COLUMNAS CONTROLADOR
    public static final String VERSION_ID = "ID";
    public static final String VERSION_BD_CAPTURA = "CAPTURA";
    public static final String VERSION_BD_COMPONENTES = "COMPONENTES";
    public static final String VERSION_BD_TABLAS = "TABLAS";


    public static final String SQL_CREATE_TABLA_VERSIONES   =
            "CREATE TABLE " + tablaVersiones + "(" +
                    VERSION_ID + " TEXT PRIMARY KEY," +
                    VERSION_BD_CAPTURA + " TEXT," +
                    VERSION_BD_COMPONENTES + " TEXT," +
                    VERSION_BD_TABLAS + " TEXT" + ");"
            ;

    public static final String SQL_DELETE_VERSIONES = "DROP TABLE " + tablaVersiones;
    public static final String WHERE_CLAUSE_ID = "ID=?";
}
