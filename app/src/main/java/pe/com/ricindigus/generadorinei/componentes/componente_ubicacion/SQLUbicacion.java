package pe.com.ricindigus.generadorinei.componentes.componente_ubicacion;

/**
 * Created by dmorales on 29/01/2018.
 */

public class SQLUbicacion {
    public static final String tablaUbicacion = "ubicaciones";

    public static final String UBICACION_ID = "ID";
    public static final String UBICACION_NUM = "NUMERO";
    public static final String UBICACION_MODULO= "MODULO";
    public static final String UBICACION_DEPARTAMENTO = "VARDEP";
    public static final String UBICACION_PROVINCIA = "VARPRO";
    public static final String UBICACION_DISTRITO = "VARDIS";

    public static final String SQL_CREATE_TABLA_UBICACION = "CREATE TABLE " + tablaUbicacion + "(" +
            UBICACION_ID + " TEXT PRIMARY KEY," +
            UBICACION_NUM + " TEXT," +
            UBICACION_MODULO + " TEXT," +
            UBICACION_DEPARTAMENTO + " TEXT," +
            UBICACION_PROVINCIA + " TEXT," +
            UBICACION_DISTRITO + " TEXT" + ");"
            ;

    public static final String SQL_DELETE_UBICACION = "DROP TABLE " + tablaUbicacion;

    //WHERE
    public static final String WHERE_CLAUSE_ID = "ID=?";


    public static final String[] ALL_COLUMNS_UBICACION = {
            UBICACION_ID , UBICACION_DEPARTAMENTO , UBICACION_PROVINCIA , UBICACION_DISTRITO
            , UBICACION_NUM, UBICACION_MODULO
    };
}
