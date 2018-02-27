package pe.com.ricindigus.generadorinei.componentes.componente_gps.modelo;

/**
 * Created by dmorales on 29/01/2018.
 */

public class SQLGps {
    public static final String tablaGPS = "gps";

    public static final String GPS_ID = "ID";
    public static final String GPS_NUMERO = "NUMERO";
    public static final String GPS_MODULO = "MODULO";
    public static final String GPS_LATITUD = "VARLAT";
    public static final String GPS_LONGITUD = "VARLONG";
    public static final String GPS_ALTITUD = "VARALT";

    public static final String SQL_CREATE_TABLA_GPS = "CREATE TABLE " + tablaGPS + "(" +
            GPS_ID + " TEXT PRIMARY KEY," +
            GPS_NUMERO + " TEXT," +
            GPS_MODULO + " TEXT," +
            GPS_LATITUD + " TEXT," +
            GPS_LONGITUD + " TEXT," +
            GPS_ALTITUD + " TEXT" + ");"
            ;

    public static final String SQL_DELETE_GPS= "DROP TABLE " + tablaGPS;

    //WHERE
    public static final String WHERE_CLAUSE_ID = "ID=?";


    public static final String[] ALL_COLUMNS_GPS = {
            GPS_ID , GPS_NUMERO , GPS_MODULO , GPS_LATITUD , GPS_LONGITUD , GPS_ALTITUD
    };


}
