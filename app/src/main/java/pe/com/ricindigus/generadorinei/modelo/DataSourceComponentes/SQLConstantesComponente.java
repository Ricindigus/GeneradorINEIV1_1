package pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes;

/**
 * Created by dmorales on 23/11/2017.
 */

public class SQLConstantesComponente {
    public static final String NOMBRE_DB = "generador.db";

    //TABLAS
    public static final String tablaEncuestas = "encuestas";
    public static final String tablaEditText = "edittexts";
    public static final String tablaPaginas = "paginas";

    //COLUMNAS ENCUESTAS
    public static final String ENCUESTA_ID = "ID";
    public static final String ENCUESTA_TITULO = "TITULO";

    //COLUMNAS PAGINAS
    public static final String PAGINA_ID = "ID";
    public static final String PAGINA_MODULO = "MODULO";
    public static final String PAGINA_IDP1 = "IDP1";
    public static final String PAGINA_TP1 = "TIPO1";
    public static final String PAGINA_IDP2 = "IDP2";
    public static final String PAGINA_TP2 = "TIPO2";
    public static final String PAGINA_IDP3 = "IDP3";
    public static final String PAGINA_TP3 = "TIPO3";
    public static final String PAGINA_IDP4 = "IDP4";
    public static final String PAGINA_TP4 = "TIPO4";
    public static final String PAGINA_IDP5 = "IDP5";
    public static final String PAGINA_TP5 = "TIPO5";

    //COLUMNAS EDIT TEXT
    public static final String EDITTEXT_ID = "ID";
    public static final String EDITTEXT_MODULO = "MODULO";
    public static final String EDITTEXT_NUMERO = "NUMERO";
    public static final String EDITTEXT_PREGUNTA = "PREGUNTA";
    public static final String EDITTEXT_SP1 = "SP1";
    public static final String EDITTEXT_HINT1 = "HINT1";
    public static final String EDITTEXT_VAR1 = "VAR1";
    public static final String EDITTEXT_SP2 = "SP2";
    public static final String EDITTEXT_HINT2 = "HINT2";
    public static final String EDITTEXT_VAR2 = "VAR2";
    public static final String EDITTEXT_SP3 = "SP3";
    public static final String EDITTEXT_HINT3 = "HINT3";
    public static final String EDITTEXT_VAR3 = "VAR3";

    //CREACION DE TABLAS (CREATE)
    public static final String SQL_CREATE_TABLA_ENCUESTAS =
            "CREATE TABLE " + tablaEncuestas + "(" +
                    ENCUESTA_ID + " TEXT PRIMARY KEY," +
                    ENCUESTA_TITULO + " TEXT" + ");"
            ;

    public static final String SQL_CREATE_TABLA_PAGINAS =
            "CREATE TABLE " + tablaPaginas + "(" +
                    PAGINA_ID + " TEXT PRIMARY KEY," +
                    PAGINA_MODULO + " TEXT," +
                    PAGINA_IDP1 + " TEXT," +
                    PAGINA_TP1 + " TEXT," +
                    PAGINA_IDP2 + " TEXT," +
                    PAGINA_TP2 + " TEXT," +
                    PAGINA_IDP3 + " TEXT," +
                    PAGINA_TP3 + " TEXT," +
                    PAGINA_IDP4 + " TEXT," +
                    PAGINA_TP4 + " TEXT," +
                    PAGINA_IDP5 + " TEXT," +
                    PAGINA_TP5 + " TEXT" + ");"
            ;

    public static final String SQL_CREATE_TABLA_EDITTEXT =
            "CREATE TABLE " + tablaEditText + "(" +
                    EDITTEXT_ID + " TEXT PRIMARY KEY," +
                    EDITTEXT_MODULO + " TEXT," +
                    EDITTEXT_NUMERO + " TEXT," +
                    EDITTEXT_PREGUNTA + " TEXT," +
                    EDITTEXT_SP1 + " TEXT," +
                    EDITTEXT_HINT1 + " TEXT," +
                    EDITTEXT_VAR1 + " TEXT," +
                    EDITTEXT_SP2 + " TEXT," +
                    EDITTEXT_HINT2 + " TEXT," +
                    EDITTEXT_VAR2 + " TEXT," +
                    EDITTEXT_SP3 + " TEXT," +
                    EDITTEXT_HINT3 + " TEXT," +
                    EDITTEXT_VAR3 + " TEXT" + ");"
            ;

    //CLAUSULA WHERE BUSQUEDA (WHERE)
    public static final String WHERE_CLAUSE_ID = "ID=?";


    //BORRADO DE TABLAS (DELETE)
    public static final String SQL_DELETE_ENCUESTAS = "DROP TABLE " + tablaEncuestas;
    public static final String SQL_DELETE_PAGINAS = "DROP TABLE " + tablaPaginas;
    public static final String SQL_DELETE_EDITTEXT = "DROP TABLE " + tablaEditText;


    //TRAER TODAS LAS COLUMNAS
    public static final String[] ALL_COLUMNS_ENCUESTA = {
            ENCUESTA_ID, ENCUESTA_TITULO
    };

    public static final String[] ALL_COLUMNS_PAGINAS = {
            PAGINA_ID, PAGINA_MODULO , PAGINA_IDP1 , PAGINA_TP1 ,
            PAGINA_IDP2 , PAGINA_TP2 , PAGINA_IDP3 , PAGINA_TP3 ,
            PAGINA_IDP4 , PAGINA_TP4 , PAGINA_IDP5 , PAGINA_TP5
    };

    public static final String[] ALL_COLUMNS_EDITTEXT = {
            EDITTEXT_ID, EDITTEXT_MODULO , EDITTEXT_NUMERO , EDITTEXT_PREGUNTA ,
            EDITTEXT_HINT1, EDITTEXT_HINT2, EDITTEXT_HINT3,
            EDITTEXT_SP1 , EDITTEXT_VAR1, EDITTEXT_SP2 , EDITTEXT_VAR2 , EDITTEXT_SP3 , EDITTEXT_VAR3
    };


}
