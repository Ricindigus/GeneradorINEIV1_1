package pe.com.ricindigus.generadorinei.componentes.componente_caratula;

/**
 * Created by RICARDO on 1/01/2018.
 */

public class SQLCaratula {
    public static final String tableCaratulas = "caratulas";

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

    //WHERE
    public static final String WHERE_CLAUSE_ID = "ID=?";
    public static final String WHERE_CLAUSE_ID_EMPRESA = "ID_EMPRESA=?";

    public static final String SQL_DELETE_CARATULAS = "DROP TABLE " + tableCaratulas;

    //TRAER COLUMNAS CARATULAS
    public static final String[] ALL_COLUMNS_CARATULA = {
            CARATULA_ID, CARATULA_CAMBIO, CARATULA_DEPARTAMENTO, CARATULA_DEPARTAMENTO_COD , CARATULA_PROVINCIA,
            CARATULA_PROVINCIA_COD, CARATULA_DISTRITO, CARATULA_DISTRITO_COD, CARATULA_GPSLATITUD,
            CARATULA_GPSALTITUD, CARATULA_GPSLONGITUD, CARATULA_SECTOR, CARATULA_AREA,
            CARATULA_ZONA,CARATULA_MANZANA_MUESTRA, CARATULA_FRENTE, CARATULA_TIPVIA,
            CARATULA_NOMVIA, CARATULA_NPUERTA, CARATULA_BLOCK, CARATULA_INTERIOR,
            CARATULA_PISO, CARATULA_MANZANA_VIA, CARATULA_LOTE, CARATULA_KM, CARATULA_REFERENCIA
    };


}
