package pe.com.ricindigus.generadorinei.modelo.DataSourceCaptura;

/**
 * Created by dmorales on 13/12/2017.
 */

public class SQLConstantes {
    //DB
    public static final String DB = "bdencuesta.db";

    //TABLAS
    public static final String tableUsuarios = "usuarios";
    public static final String tableUbigeo = "ubigeo";
    public static final String tableMarco = "marco";
    public static final String tableCaratulas = "caratulas";
    public static final String tableDatosEntrevista = "datosEntrevista";
    public static final String tableVisitas = "visitas";
    public static final String tableIdentificaciones = "identificaciones";

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

    //COLUMNAS_CARATULA
    public static final String CARATULA_ID = "ID";
    public static final String CARATULA_CAMBIO = "CAMBIO";
    public static final String CARATULA_DEPARTAMENTO = "NOMBREDD";
    public static final String CARATULA_DEPARTAMENTO_COD = "CCDD";
    public static final String CARATULA_PROVINCIA = "NOMBREPV";
    public static final String CARATULA_PROVINCIA_COD = "CCPP";
    public static final String CARATULA_DISTRITO = "NOMBREDI";
    public static final String CARATULA_DISTRITO_COD = "CCDI";
    public static final String CARATULA_GPSLATITUD = "GPSLATITUD";
    public static final String CARATULA_GPSALTITUD = "GPSALTITUD";
    public static final String CARATULA_GPSLONGITUD = "GPSLONGITUD";
    public static final String CARATULA_SECTOR = "CCST";
    public static final String CARATULA_AREA = "CCAT";
    public static final String CARATULA_ZONA = "ZON_NUM";
    public static final String CARATULA_MANZANA_MUESTRA = "MZ_ID";
    public static final String CARATULA_FRENTE = "FRENTE";
    public static final String CARATULA_TIPVIA = "TIPVIA";
    public static final String CARATULA_NOMVIA = "NOMVIA";
    public static final String CARATULA_NPUERTA = "NROPTA";
    public static final String CARATULA_BLOCK = "BLOCK";
    public static final String CARATULA_INTERIOR = "INT";
    public static final String CARATULA_PISO = "PISO";
    public static final String CARATULA_MANZANA_VIA = "MZA";
    public static final String CARATULA_LOTE = "LOTE";
    public static final String CARATULA_KM = "KM";
    public static final String CARATULA_REFERENCIA = "REF_DIREC";

    //COLUMNAS_VISITA
    public static final String VISITA_ID = "ID";
    public static final String VISITA_ID_EMPRESA = "ID_EMPRESA";
    public static final String VISITA_N = "N_VISITA";
    public static final String VISITA_DIA = "V_DIA";
    public static final String VISITA_MES = "V_MES";
    public static final String VISITA_ANIO = "V_ANIO";
    public static final String VISITA_HORAI = "V_HORA_I";
    public static final String VISITA_MINUTOI = "V_MINUTO_I";
    public static final String VISITA_HORAF = "V_HORA_F";
    public static final String VISITA_MINUTOF = "V_MINUTO_F";
    public static final String VISITA_RESULTADO = "R_VISITA";
    public static final String VISITA_RESULTADO_ESP = "R_VISITA_ESP";
    public static final String VISITA_PROX_DIA = "V_PROX_FECHA_DIA";
    public static final String VISITA_PROX_MES = "V_PROX_FECHA_MES";
    public static final String VISITA_PROX_ANIO = "V_PROX_FECHA_ANIO";
    public static final String VISITA_PROX_HORA = "V_PROX_HORA";
    public static final String VISITA_PROX_MINUTO = "V_PROX_MIN";

    //COLUMNAS DATOS ENTREVISTA
    public static final String DATOS_ID = "ID";
    public static final String DATOS_RESULTADO_FINAL = "R_ENCUESTA";
    public static final String DATOS_RESULTADO_FINAL_ESP = "R_ENCUESTA_ESP";
    public static final String DATOS_FECHA_FINAL_DIA = "R_FECHA_DIA";
    public static final String DATOS_FECHA_FINAL_MES = "R_FECHA_MES";
    public static final String DATOS_FECHA_FINAL_ANIO = "R_FECHA_ANIO";


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

    public static final String SQL_CREATE_TABLA_CARATULAS =
            "CREATE TABLE " + tableCaratulas + "(" +
                    CARATULA_ID + " TEXT PRIMARY KEY," +
                    CARATULA_CAMBIO + " TEXT," +
                    CARATULA_DEPARTAMENTO + " TEXT," +
                    CARATULA_DEPARTAMENTO_COD + " TEXT," +
                    CARATULA_PROVINCIA + " TEXT," +
                    CARATULA_PROVINCIA_COD + " TEXT," +
                    CARATULA_DISTRITO + " TEXT," +
                    CARATULA_DISTRITO_COD + " TEXT," +
                    CARATULA_GPSLATITUD + " TEXT," +
                    CARATULA_GPSALTITUD + " TEXT," +
                    CARATULA_GPSLONGITUD + " TEXT," +
                    CARATULA_SECTOR + " TEXT," +
                    CARATULA_AREA + " TEXT," +
                    CARATULA_ZONA + " TEXT," +
                    CARATULA_MANZANA_MUESTRA + " TEXT," +
                    CARATULA_FRENTE + " TEXT," +
                    CARATULA_TIPVIA + " TEXT," +
                    CARATULA_NOMVIA + " TEXT," +
                    CARATULA_NPUERTA + " TEXT," +
                    CARATULA_BLOCK + " TEXT," +
                    CARATULA_INTERIOR + " TEXT," +
                    CARATULA_PISO + " TEXT," +
                    CARATULA_MANZANA_VIA + " TEXT," +
                    CARATULA_LOTE + " TEXT," +
                    CARATULA_KM + " TEXT," +
                    CARATULA_REFERENCIA + " TEXT" + ");"
            ;

    public static final String SQL_CREATE_TABLA_VISITAS =
            "CREATE TABLE " + tableVisitas + "(" +
                    VISITA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    VISITA_ID_EMPRESA + " TEXT," +
                    VISITA_N + " TEXT," +
                    VISITA_DIA + " TEXT," +
                    VISITA_MES + " TEXT," +
                    VISITA_ANIO + " TEXT," +
                    VISITA_HORAI + " TEXT," +
                    VISITA_MINUTOI + " TEXT," +
                    VISITA_HORAF + " TEXT," +
                    VISITA_MINUTOF + " TEXT," +
                    VISITA_RESULTADO + " TEXT," +
                    VISITA_RESULTADO_ESP + " TEXT," +
                    VISITA_PROX_DIA + " TEXT," +
                    VISITA_PROX_MES + " TEXT," +
                    VISITA_PROX_ANIO + " TEXT," +
                    VISITA_PROX_HORA + " TEXT," +
                    VISITA_PROX_MINUTO + " TEXT" + ");"
            ;
    public static final String SQL_CREATE_TABLA_DATOS_ENTREVISTA =
            "CREATE TABLE " + tableDatosEntrevista + "(" +
                    DATOS_ID + " TEXT PRIMARY KEY," +
                    DATOS_RESULTADO_FINAL + " TEXT," +
                    DATOS_RESULTADO_FINAL_ESP + " TEXT," +
                    DATOS_FECHA_FINAL_DIA + " TEXT," +
                    DATOS_FECHA_FINAL_MES + " TEXT," +
                    DATOS_FECHA_FINAL_ANIO + " TEXT" + ");"
            ;
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

    //WHERE
    public static final String WHERE_CLAUSE_ID = "ID=?";
    public static final String WHERE_CLAUSE_ID_EMPRESA = "ID_EMPRESA=?";
    public static final String WHERE_CLAUSE_ID_OPERADOR = "OPERADOR=?";
    public static final String WHERE_CLAUSE_ID_JEFE = "JEFE=?";
    public static final String WHERE_CLAUSE_ID_OBSERVADOR = "OBSERVADOR=?";

    //DELETE
    public static final String SQL_DELETE_USUARIOS = "DROP TABLE " + tableUsuarios;
    public static final String SQL_DELETE_UBIGEO = "DROP TABLE " + tableUbigeo;
    public static final String SQL_DELETE_MARCO = "DROP TABLE " + tableMarco;
    public static final String SQL_DELETE_DATOS_ENTREVISTA = "DROP TABLE " + tableDatosEntrevista;
    public static final String SQL_DELETE_CARATULAS = "DROP TABLE " + tableCaratulas;
    public static final String SQL_DELETE_VISITAS = "DROP TABLE " + tableVisitas;
    public static final String SQL_DELETE_IDENTIFICACIONES = "DROP TABLE " + tableIdentificaciones;


    //TRAER COLUMNAS

    public static final String[] ALL_COLUMNS_USUARIOS = {
            USUARIO_ID, USUARIO_PASSWORD, USUARIO_PERMISO
    };

    public static final String[] ALL_COLUMNS_UBIGEOS = {
            UBIGEO_ID, UBIGEO_ID_UBI,UBIGEO_DISTRITO
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

    //TRAER COLUMNAS CARATULAS
    public static final String[] ALL_COLUMNS_CARATULA = {
            CARATULA_ID, CARATULA_CAMBIO, CARATULA_DEPARTAMENTO, CARATULA_DEPARTAMENTO_COD , CARATULA_PROVINCIA,
            CARATULA_PROVINCIA_COD, CARATULA_DISTRITO, CARATULA_DISTRITO_COD, CARATULA_GPSLATITUD,
            CARATULA_GPSALTITUD, CARATULA_GPSLONGITUD, CARATULA_SECTOR, CARATULA_AREA,
            CARATULA_ZONA,CARATULA_MANZANA_MUESTRA, CARATULA_FRENTE, CARATULA_TIPVIA,
            CARATULA_NOMVIA, CARATULA_NPUERTA, CARATULA_BLOCK, CARATULA_INTERIOR,
            CARATULA_PISO, CARATULA_MANZANA_VIA, CARATULA_LOTE, CARATULA_KM, CARATULA_REFERENCIA
    };

    //TRAER COLUMNAS VISITAS
    public static final String[] ALL_COLUMNS_VISITAS = {
            VISITA_ID, VISITA_ID_EMPRESA,  VISITA_DIA, VISITA_MES,VISITA_ANIO,
            VISITA_HORAI, VISITA_MINUTOI, VISITA_HORAF,VISITA_MINUTOF, VISITA_RESULTADO, VISITA_RESULTADO_ESP, VISITA_PROX_DIA, VISITA_PROX_MES, VISITA_PROX_ANIO, VISITA_PROX_HORA,
            VISITA_PROX_MINUTO,VISITA_N
    };

    public static final String[] ALL_COLUMNS_DATOS_ENTREVISTA= {
            DATOS_ID, DATOS_RESULTADO_FINAL,DATOS_RESULTADO_FINAL_ESP,
            DATOS_FECHA_FINAL_DIA,DATOS_FECHA_FINAL_MES,DATOS_FECHA_FINAL_ANIO
    };

    //TRAER COLUMNAS IDENTIFICACIONES
    public static final String[] ALL_COLUMNS_IDENTIFICACIONES = {
            IDENTIFICACION_ID, IDENTIFICACION_RUC, IDENTIFICACION_RAZON, IDENTIFICACION_NOMBRE, IDENTIFICACION_WEB,
            IDENTIFICACION_WEBNO, IDENTIFICACION_CORREO, IDENTIFICACION_CORREONO, IDENTIFICACION_FIJO,
            IDENTIFICACION_FIJONO, IDENTIFICACION_MOVIL, IDENTIFICACION_MOVILNO, IDENTIFICACION_ANIO_FUNCIONAMIENTO,
            IDENTIFICACION_CONDUCTOR_NOMBRE, IDENTIFICACION_CONDUCTOR_SEXO, IDENTIFICACION_CONDUCTOR_EDAD,
            IDENTIFICACION_CONDUCTOR_ESTUDIOS, IDENTIFICACION_CONDUCTOR_CARGO,IDENTIFICACION_CONDUCTOR_CARGO_ESP
    };

}
