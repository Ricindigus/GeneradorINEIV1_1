package pe.com.ricindigus.generadorinei.modelo.DataSourceCaptura;

/**
 * Created by dmorales on 13/12/2017.
 */

public class SQLConstantes {
    //DB
    public static final String DB = "bdcaptura.db";

    //TABLAS
    public static final String tableUsuarios = "usuarios";
    public static final String tableUbigeo = "ubigeo";
    public static final String tableMarco = "marco";
    public static final String tablaProvincias = "provincias";
    public static final String tablaDistritos = "distritos";
    public static final String tablaTablas = "tablas";
    public static final String tablaPaginador = "paginador";
    public static final String tablaControlador = "controlador";

    //COLUMNAS CONTROLADOR
    public static final String CONTROLADOR_ID = "ID";
    public static final String CONTROLADOR_ID_EMPRESA = "ID_EMPRESA";
    public static final String CONTROLADOR_ID_PREGUNTA = "ID_PREGUNTA";
    public static final String CONTROLADOR_VARIABLE = "VARIABLE";



    //COLUMNAS USUARIOS
    public static final String USUARIO_ID = "ID";
    public static final String USUARIO_PASSWORD = "PASSWORD";
    public static final String USUARIO_PERMISO = "PERMISO";


    //COLUMNAS UBIGEOS
    public static final String UBIGEO_ID = "ID";
    public static final String UBIGEO_ID_UBI = "ID_UBI";
    public static final String UBIGEO_DISTRITO = "DISTRITO";

    //COLUMNAS_MARCO
    public static final String MARCO_ID = "ID";
    public static final String MARCO_RUC = "RUC";
    public static final String MARCO_RAZON_SOCIAL = "RAZON_SOCIAL";
    public static final String MARCO_NOMBRE_COMERCIAL = "NOMBRE_COMERCIAL";
    public static final String MARCO_OPERADOR = "OPERADOR";
    public static final String MARCO_JEFE = "JEFE";
    public static final String MARCO_OBSERVADOR = "OBSERVADOR";
    public static final String MARCO_ANIO = "ANIO";
    public static final String MARCO_MES = "MES";
    public static final String MARCO_PERIODO = "PERIODO";
    public static final String MARCO_CCDD = "CCDD";
    public static final String MARCO_DEPARTAMENTO = "DEPARTAMENTO";
    public static final String MARCO_CCPP = "CCPP";
    public static final String MARCO_PROVINCIA = "PROVINCIA";
    public static final String MARCO_CCDI = "CCDI";
    public static final String MARCO_DISTRITO = "DISTRITO";
    public static final String MARCO_T_EMPRESA = "T_EMPRESA";
    public static final String MARCO_FRENTE = "FRENTE";
    public static final String MARCO_ZONA = "ZONA";
    public static final String MARCO_MANZANA = "MANZANA";
    public static final String MARCO_CAT_VIA = "CAT_VIA";
    public static final String MARCO_NOM_VIA = "NOM_VIA";
    public static final String MARCO_PUERTA = "PUERTA";
    public static final String MARCO_INTERIOR = "INTERIOR";
    public static final String MARCO_PISO = "PISO";
    public static final String MARCO_MZ = "MZ";
    public static final String MARCO_LOTE = "LOTE";


    public static final String TABLA_ID = "ID";
    public static final String TABLA_MODULO = "MODULO";
    public static final String TABLA_NOMBRE = "NOMBRE";
    public static final String TABLA_TIPO = "TIPO";

    public static final String SQL_CREATE_TABLA_CONTROLADOR =
            "CREATE TABLE " + tablaControlador + "(" +
                    CONTROLADOR_ID + " TEXT PRIMARY KEY," +
                    CONTROLADOR_ID_EMPRESA + " TEXT," +
                    CONTROLADOR_ID_PREGUNTA + " TEXT," +
                    CONTROLADOR_VARIABLE + " TEXT" + ");"
            ;

    public static final String SQL_CREATE_TABLA_USUARIOS =
            "CREATE TABLE " + tableUsuarios + "(" +
                    USUARIO_ID + " TEXT PRIMARY KEY," +
                    USUARIO_PASSWORD + " TEXT," +
                    USUARIO_PERMISO + " TEXT" + ");"
            ;
    public static final String SQL_CREATE_TABLA_UBIGEOS =
            "CREATE TABLE " + tableUbigeo + "(" +
                    UBIGEO_ID + " TEXT PRIMARY KEY," +
                    UBIGEO_ID_UBI + " TEXT, " +
                    UBIGEO_DISTRITO + " TEXT" +");"
            ;

    public static final String SQL_CREATE_TABLA_MARCO =
            "CREATE TABLE " + tableMarco + "(" +
                    MARCO_ID + " TEXT PRIMARY KEY," +
                    MARCO_RUC + " TEXT," +
                    MARCO_RAZON_SOCIAL + " TEXT," +
                    MARCO_NOMBRE_COMERCIAL + " TEXT," +
                    MARCO_OPERADOR + " TEXT," +
                    MARCO_JEFE + " TEXT," +
                    MARCO_OBSERVADOR + " TEXT," +
                    MARCO_ANIO + " TEXT," +
                    MARCO_MES + " TEXT," +
                    MARCO_PERIODO + " TEXT," +
                    MARCO_CCDD + " TEXT," +
                    MARCO_DEPARTAMENTO + " TEXT," +
                    MARCO_CCPP + " TEXT," +
                    MARCO_PROVINCIA + " TEXT," +
                    MARCO_CCDI + " TEXT," +
                    MARCO_DISTRITO + " TEXT," +
                    MARCO_T_EMPRESA + " TEXT," +
                    MARCO_FRENTE + " TEXT," +
                    MARCO_ZONA + " TEXT," +
                    MARCO_MANZANA + " TEXT," +
                    MARCO_CAT_VIA + " TEXT," +
                    MARCO_NOM_VIA + " TEXT," +
                    MARCO_PUERTA + " TEXT," +
                    MARCO_INTERIOR + " TEXT," +
                    MARCO_PISO + " TEXT," +
                    MARCO_MZ + " TEXT," +
                    MARCO_LOTE + " TEXT" + ");"
            ;

    public static final String SQL_CREATE_TABLA_TABLAS =
            "CREATE TABLE " + tablaTablas + "(" +
                    TABLA_ID + " TEXT PRIMARY KEY," +
                    TABLA_MODULO + " TEXT," +
                    TABLA_NOMBRE + " TEXT," +
                    TABLA_TIPO + " TEXT" + ");"
            ;


    //WHERE
    public static final String WHERE_CLAUSE_ID = "ID=?";
    public static final String WHERE_CLAUSE_ID_UBIGEO = "ID_UBI=?";
    public static final String WHERE_CLAUSE_ID_EMPRESA = "ID_EMPRESA=?";
    public static final String WHERE_CLAUSE_ID_PREGUNTA = "ID_PREGUNTA=?";
    public static final String WHERE_CLAUSE_ID_OPERADOR = "OPERADOR=?";
    public static final String WHERE_CLAUSE_ID_JEFE = "JEFE=?";
    public static final String WHERE_CLAUSE_ID_OBSERVADOR = "OBSERVADOR=?";
    public static final String WHERE_CLAUSE_TABLA_NOMBRE = "NOMBRE=?";
    public static final String WHERE_CLAUSE_TABLA_MODULO = "MODULO=?";


    //DELETE
    public static final String SQL_DELETE_USUARIOS = "DROP TABLE " + tableUsuarios;
    public static final String SQL_DELETE_UBIGEO = "DROP TABLE " + tableUbigeo;
    public static final String SQL_DELETE_MARCO = "DROP TABLE " + tableMarco;
    public static final String SQL_DELETE_TABLA = "DROP TABLE " + tablaTablas;
    public static final String SQL_DELETE_CONTROLADOR = "DROP TABLE " + tablaControlador;
    public static final String SQL_DELETE_PAGINADOR = "DROP TABLE " + tablaPaginador;





    //TRAER COLUMNAS
    public static final String[] ALL_COLUMNS_USUARIOS = {
            USUARIO_ID, USUARIO_PASSWORD, USUARIO_PERMISO
    };

    public static final String[] ALL_COLUMNS_CONTROLADOR = {
            CONTROLADOR_ID,CONTROLADOR_ID_EMPRESA, CONTROLADOR_ID_PREGUNTA, CONTROLADOR_VARIABLE
    };
    public static final String[] ALL_COLUMNS_UBIGEOS = {
            UBIGEO_ID, UBIGEO_ID_UBI,UBIGEO_DISTRITO
    };

    public static final String[] ALL_COLUMNS_TABLAS = {
            TABLA_ID, TABLA_MODULO, TABLA_NOMBRE, TABLA_TIPO
    };

    public static final String[] ALL_COLUMNS_MARCO = {
            MARCO_ID, MARCO_RUC, MARCO_RAZON_SOCIAL, MARCO_NOMBRE_COMERCIAL,
            MARCO_OPERADOR, MARCO_JEFE, MARCO_OBSERVADOR, MARCO_ANIO,
            MARCO_MES, MARCO_PERIODO, MARCO_CCDD, MARCO_DEPARTAMENTO,
            MARCO_CCPP, MARCO_PROVINCIA, MARCO_CCDI, MARCO_DISTRITO,
            MARCO_T_EMPRESA, MARCO_FRENTE, MARCO_ZONA, MARCO_MANZANA,
            MARCO_CAT_VIA, MARCO_NOM_VIA, MARCO_PUERTA, MARCO_INTERIOR,
            MARCO_PISO, MARCO_MZ, MARCO_LOTE
    };
}
