package pe.com.ricindigus.generadorinei.componentes.componente_identificacion;

/**
 * Created by RICARDO on 1/01/2018.
 */

public class SQLIdentificacion {
    public static final String tableIdentificaciones = "identificaciones";


    //COLUMNAS_IDENTIFICACION
    public static final String IDENTIFICACION_ID = "ID";
    public static final String IDENTIFICACION_RUC = "NUM_RUC";
    public static final String IDENTIFICACION_RAZON = "RAZON_SOCIAL";
    public static final String IDENTIFICACION_NOMBRE = "NOM_COMER_COOP";
    public static final String IDENTIFICACION_ANIO_FUNCIONAMIENTO = "ANIO_OPERACION";
    public static final String IDENTIFICACION_WEB = "PAG_WEB";
    public static final String IDENTIFICACION_WEBNO = "PAG_WEB_NO";
    public static final String IDENTIFICACION_CORREO = "CORREO";
    public static final String IDENTIFICACION_CORREONO = "CORREO_NO";
    public static final String IDENTIFICACION_FIJO = "TEL_FIJO";
    public static final String IDENTIFICACION_FIJONO = "TEL_FIJO_NO";
    public static final String IDENTIFICACION_MOVIL = "TEL_MOVIL";
    public static final String IDENTIFICACION_MOVILNO = "TEL_MOVIL_NO";
    public static final String IDENTIFICACION_CONDUCTOR_NOMBRE = "NOM_INFORMANTE";
    public static final String IDENTIFICACION_CONDUCTOR_SEXO = "SEXO_INFORMANTE";
    public static final String IDENTIFICACION_CONDUCTOR_EDAD = "EDAD_INFORMANTE";
    public static final String IDENTIFICACION_CONDUCTOR_ESTUDIOS = "ACAD_INFORMANTE";
    public static final String IDENTIFICACION_CONDUCTOR_CARGO = "CARGO_INFORMANTE";
    public static final String IDENTIFICACION_CONDUCTOR_CARGO_ESP = "CARGO_INFORMANTE_ESP";


    public static final String SQL_CREATE_TABLA_IDENTIFICACIONES =
            "CREATE TABLE " + tableIdentificaciones + "(" +
                    IDENTIFICACION_ID + " TEXT PRIMARY KEY," +
                    IDENTIFICACION_RUC + " TEXT," +
                    IDENTIFICACION_RAZON + " TEXT," +
                    IDENTIFICACION_NOMBRE + " TEXT," +
                    IDENTIFICACION_WEB + " TEXT," +
                    IDENTIFICACION_WEBNO + " TEXT," +
                    IDENTIFICACION_CORREO + " TEXT," +
                    IDENTIFICACION_CORREONO + " TEXT," +
                    IDENTIFICACION_FIJO + " TEXT," +
                    IDENTIFICACION_FIJONO + " TEXT," +
                    IDENTIFICACION_MOVIL + " TEXT," +
                    IDENTIFICACION_MOVILNO + " TEXT," +
                    IDENTIFICACION_ANIO_FUNCIONAMIENTO + " TEXT," +
                    IDENTIFICACION_CONDUCTOR_NOMBRE + " TEXT," +
                    IDENTIFICACION_CONDUCTOR_SEXO + " TEXT," +
                    IDENTIFICACION_CONDUCTOR_EDAD + " TEXT," +
                    IDENTIFICACION_CONDUCTOR_ESTUDIOS + " TEXT," +
                    IDENTIFICACION_CONDUCTOR_CARGO + " TEXT," +
                    IDENTIFICACION_CONDUCTOR_CARGO_ESP + " TEXT" + ");"
            ;

    public static final String SQL_DELETE_IDENTIFICACIONES = "DROP TABLE " + tableIdentificaciones;

    //WHERE
    public static final String WHERE_CLAUSE_ID = "ID=?";
    public static final String WHERE_CLAUSE_ID_EMPRESA = "ID_EMPRESA=?";

    //TRAER COLUMNAS IDENTIFICACIONES
    public static final String[] ALL_COLUMNS_IDENTIFICACIONES = {
            IDENTIFICACION_ID, IDENTIFICACION_RUC, IDENTIFICACION_RAZON, IDENTIFICACION_NOMBRE, IDENTIFICACION_WEB,
            IDENTIFICACION_WEBNO, IDENTIFICACION_CORREO, IDENTIFICACION_CORREONO, IDENTIFICACION_FIJO,
            IDENTIFICACION_FIJONO, IDENTIFICACION_MOVIL, IDENTIFICACION_MOVILNO, IDENTIFICACION_ANIO_FUNCIONAMIENTO,
            IDENTIFICACION_CONDUCTOR_NOMBRE, IDENTIFICACION_CONDUCTOR_SEXO, IDENTIFICACION_CONDUCTOR_EDAD,
            IDENTIFICACION_CONDUCTOR_ESTUDIOS, IDENTIFICACION_CONDUCTOR_CARGO,IDENTIFICACION_CONDUCTOR_CARGO_ESP
    };
}
