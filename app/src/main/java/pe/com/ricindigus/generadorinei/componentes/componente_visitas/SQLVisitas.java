package pe.com.ricindigus.generadorinei.componentes.componente_visitas;

/**
 * Created by RICARDO on 1/01/2018.
 */

public class SQLVisitas {
    public static final String tableVisitas = "visitas";

    //COLUMNAS_VISITA
    public static final String VISITA_ID = "ID";
    public static final String VISITA_MODULO = "MODULO";
    public static final String VISITA_NUMERO = "NUMERO";
    public static final String VISITA_VARNUM = "VARNUM";
    public static final String VISITA_VARDIA = "VARDIA";
    public static final String VISITA_VARMES = "VARMES";
    public static final String VISITA_VARANIO = "VARANIO";
    public static final String VISITA_VARHORI = "VARHORI";
    public static final String VISITA_VARMINI = "VARMINI";
    public static final String VISITA_VARHORF = "VARHORF";
    public static final String VISITA_VARMINF = "VARMINF";
    public static final String VISITA_VARRES = "VARRES";
    public static final String VISITA_VARDIAP = "VARDIAP";
    public static final String VISITA_VARMESP = "VARMESP";
    public static final String VISITA_VARANIOP = "VARANIOP";
    public static final String VISITA_VARHORP = "VARHORP";
    public static final String VISITA_VARMINP = "VARMINP";
    public static final String VISITA_VARRESFINAL = "VARRESFINAL";
    public static final String VISITA_VARRESFECHA = "VARRESFECHA";


    public static final String SQL_CREATE_TABLA_VISITAS =
            "CREATE TABLE " + tableVisitas + "(" +
                    VISITA_ID + " TEXT PRIMARY KEY," +
                    VISITA_MODULO + " TEXT," +
                    VISITA_NUMERO + " TEXT," +
                    VISITA_VARNUM + " TEXT," +
                    VISITA_VARDIA + " TEXT," +
                    VISITA_VARMES + " TEXT," +
                    VISITA_VARANIO + " TEXT," +
                    VISITA_VARHORI + " TEXT," +
                    VISITA_VARMINI + " TEXT," +
                    VISITA_VARHORF + " TEXT," +
                    VISITA_VARMINF + " TEXT," +
                    VISITA_VARRES + " TEXT," +
                    VISITA_VARDIAP + " TEXT," +
                    VISITA_VARMESP + " TEXT," +
                    VISITA_VARANIOP + " TEXT," +
                    VISITA_VARHORP + " TEXT," +
                    VISITA_VARMINP + " TEXT," +
                    VISITA_VARRESFINAL + " TEXT," +
                    VISITA_VARRESFECHA + " TEXT" + ");"
            ;




    public static final String SQL_DELETE_VISITAS = "DROP TABLE " + tableVisitas;

    //WHERE
    public static final String WHERE_CLAUSE_ID = "ID=?";
    public static final String WHERE_CLAUSE_ID_EMPRESA = "ID_EMPRESA=?";

    //TRAER COLUMNAS VISITAS
    public static final String[] ALL_COLUMNS_VISITAS = {
            VISITA_ID, VISITA_MODULO, VISITA_NUMERO, VISITA_VARNUM, VISITA_VARDIA,
            VISITA_VARMES, VISITA_VARANIO, VISITA_VARHORI, VISITA_VARMINI,
            VISITA_VARHORF, VISITA_VARMINF, VISITA_VARRES, VISITA_VARDIAP,
            VISITA_VARMESP, VISITA_VARANIOP, VISITA_VARHORP, VISITA_VARMINP,
            VISITA_VARRESFINAL,VISITA_VARRESFECHA
    };

}
