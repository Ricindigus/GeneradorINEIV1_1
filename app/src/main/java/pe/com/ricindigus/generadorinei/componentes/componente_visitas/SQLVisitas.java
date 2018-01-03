package pe.com.ricindigus.generadorinei.componentes.componente_visitas;

/**
 * Created by RICARDO on 1/01/2018.
 */

public class SQLVisitas {
    public static final String tableDatosEntrevista = "datosEntrevista";
    public static final String tableVisitas = "visitas";

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


    public static final String SQL_DELETE_DATOS_ENTREVISTA = "DROP TABLE " + tableDatosEntrevista;
    public static final String SQL_DELETE_VISITAS = "DROP TABLE " + tableVisitas;

    //WHERE
    public static final String WHERE_CLAUSE_ID = "ID=?";
    public static final String WHERE_CLAUSE_ID_EMPRESA = "ID_EMPRESA=?";

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
}
