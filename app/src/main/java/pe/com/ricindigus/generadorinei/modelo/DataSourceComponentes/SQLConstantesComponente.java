package pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes;

/**
 * Created by dmorales on 23/11/2017.
 */

public class SQLConstantesComponente {
    public static final String NOMBRE_DB = "generador.db";

    //TABLAS
    public static final String tablaEncuestas = "encuestas";
    public static final String tablaPaginas = "paginas";
    public static final String tablaModulos = "modulos";
    public static final String tablaOpcionSpinner = "opciones";
    public static final String tablaEventos = "eventos";
    public static final String tablaVariables = "variables";
    public static final String tablaInfoTablas = "infotablas";





    //COLUMNAS ENCUESTAS
    public static final String ENCUESTA_ID = "ID";
    public static final String ENCUESTA_TITULO = "TITULO";

    //COLUMNAS MODULOS
    public static final String MODULO_ID = "ID";
    public static final String MODULO_TITULO = "TITULO";
    public static final String MODULO_CABECERA = "CABECERA";
    public static final String MODULO_NTABLA = "NTABLA";



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
    public static final String PAGINA_IDP6 = "IDP6";
    public static final String PAGINA_TP6 = "TIPO6";
    public static final String PAGINA_IDP7 = "IDP7";
    public static final String PAGINA_TP7 = "TIPO7";
    public static final String PAGINA_IDP8 = "IDP8";
    public static final String PAGINA_TP8 = "TIPO8";
    public static final String PAGINA_IDP9 = "IDP9";
    public static final String PAGINA_TP9 = "TIPO9";
    public static final String PAGINA_IDP10 = "IDP10";
    public static final String PAGINA_TP10 = "TIPO10";


    //COLUMNAS OPCIONES SPINNER
    public static final String OPCION_SPINNER_ID = "ID";
    public static final String OPCION_SPINNER_IDVARIABLE = "IDVARIABLE";
    public static final String OPCION_SPINNER_NDATO = "NDATO";
    public static final String OPCION_SPINNER_DATO = "DATO";

    //COLUMNAS EVENTOS
    public static final String EVENTO_ID = "ID";
    public static final String EVENTO_IDPAGA = "IDPAGA";
    public static final String EVENTO_IDPAGB = "IDPAGB";
    public static final String EVENTO_IDPREGA = "IDPREGA";
    public static final String EVENTO_IDPREGB = "IDPREGB";
    public static final String EVENTO_VAR = "VAR";
    public static final String EVENTO_VAL = "VAL";
    public static final String EVENTO_ACCION = "ACCION";

    //COLUMNAS VARIABLES
    public static final String VARIABLE_ID = "ID";
    public static final String VARIABLE_TABLA = "TABLA";
    public static final String VARIABLE_MODULO = "MODULO";
    public static final String VARIABLE_PAGINA = "PAGINA";
    public static final String VARIABLE_PREGUNTA = "PREGUNTA";


    //COLUMNAS INFO TABLAS
    public static final String INFOTABLAS_ID = "ID";
    public static final String INFOTABLAS_MODULO = "MODULO";
    public static final String INFOTABLAS_PARTE = "PARTE";
    public static final String INFOTABLAS_NOMBRE = "NOMBRE";
    public static final String INFOTABLAS_TIPO = "TIPO";

    public static final String SQL_CREATE_TABLA_INFOTABLAS =
            "CREATE TABLE " + tablaInfoTablas + "(" +
                    INFOTABLAS_ID + " TEXT PRIMARY KEY," +
                    INFOTABLAS_MODULO + " TEXT," +
                    INFOTABLAS_NOMBRE + " TEXT," +
                    INFOTABLAS_PARTE + " TEXT," +
                    INFOTABLAS_TIPO + " TEXT" + ");"
            ;


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
                    PAGINA_TP5 + " TEXT," +
                    PAGINA_IDP6 + " TEXT," +
                    PAGINA_TP6 + " TEXT," +
                    PAGINA_IDP7 + " TEXT," +
                    PAGINA_TP7 + " TEXT," +
                    PAGINA_IDP8 + " TEXT," +
                    PAGINA_TP8 + " TEXT," +
                    PAGINA_IDP9 + " TEXT," +
                    PAGINA_TP9 + " TEXT," +
                    PAGINA_IDP10 + " TEXT," +
                    PAGINA_TP10 + " TEXT" + ");"
            ;

    public static final String SQL_CREATE_TABLA_MODULOS =
            "CREATE TABLE " + tablaModulos + "(" +
                    MODULO_ID + " TEXT PRIMARY KEY," +
                    MODULO_TITULO + " TEXT," +
                    MODULO_CABECERA + " TEXT," +
                    MODULO_NTABLA + " TEXT" + ");"
            ;


    public static final String SQL_CREATE_TABLA_OPCION_SPINNER =
            "CREATE TABLE " + tablaOpcionSpinner + "(" +
                    OPCION_SPINNER_ID + " TEXT PRIMARY KEY," +
                    OPCION_SPINNER_IDVARIABLE + " TEXT," +
                    OPCION_SPINNER_NDATO + " TEXT," +
                    OPCION_SPINNER_DATO + " TEXT" + ");"
            ;

    public static final String SQL_CREATE_TABLA_EVENTOS =
            "CREATE TABLE " + tablaEventos + "(" +
                    EVENTO_ID + " TEXT PRIMARY KEY," +
                    EVENTO_IDPAGA + " TEXT," +
                    EVENTO_IDPAGB + " TEXT," +
                    EVENTO_VAR + " TEXT," +
                    EVENTO_VAL + " TEXT," +
                    EVENTO_ACCION + " TEXT," +
                    EVENTO_IDPREGA+ " TEXT," +
                    EVENTO_IDPREGB + " TEXT" + ");"
            ;

    public static final String SQL_CREATE_TABLA_VARIABLES =
            "CREATE TABLE " + tablaVariables + "(" +
                    VARIABLE_ID + " TEXT PRIMARY KEY," +
                    VARIABLE_MODULO + " TEXT," +
                    VARIABLE_PAGINA + " TEXT," +
                    VARIABLE_PREGUNTA + " TEXT," +
                    VARIABLE_TABLA + " TEXT" + ");"
            ;

    //CLAUSULA WHERE BUSQUEDA (WHERE)
    public static final String WHERE_CLAUSE_ID = "ID=?";
    public static final String WHERE_CLAUSE_ID_VARIABLE = "IDVARIABLE=?";
    public static final String WHERE_CLAUSE_MODULO_PAGINA = "MODULO=?";
    public static final String WHERE_CLAUSE_VAR = "VAR=?";
    public static final String WHERE_CLAUSE_VAL = "VAL=?";
    public static final String WHERE_CLAUSE_IDPAGB = "IDPAGB=?";
    public static final String WHERE_CLAUSE_PREGUNTA = "PREGUNTA=?";
    public static final String WHERE_CLAUSE_TABLA = "TABLA=?";
    public static final String WHERE_CLAUSE_PAGINA = "PAGINA=?";
    public static final String WHERE_CLAUSE_MODULO = "MODULO=?";
    public static final String WHERE_CLAUSE_NOMBRE = "NOMBRE=?";




    //BORRADO DE TABLAS (DELETE)
    public static final String SQL_DELETE_ENCUESTAS = "DROP TABLE " + tablaEncuestas;
    public static final String SQL_DELETE_MODULOS = "DROP TABLE " + tablaModulos;
    public static final String SQL_DELETE_PAGINAS = "DROP TABLE " + tablaPaginas;
    public static final String SQL_DELETE_OPCION_SPINNER = "DROP TABLE " + tablaOpcionSpinner;
    public static final String SQL_DELETE_EVENTOS = "DROP TABLE " + tablaEventos;
    public static final String SQL_DELETE_VARIABLES = "DROP TABLE " + tablaVariables;
    public static final String SQL_DELETE_INFOTABLAS = "DROP TABLE " + tablaInfoTablas;




    //TRAER TODAS LAS COLUMNAS
    public static final String[] ALL_COLUMNS_ENCUESTA = {
            ENCUESTA_ID, ENCUESTA_TITULO
    };


    public static final String[] ALL_COLUMNS_VARIABLES = {
            VARIABLE_ID, VARIABLE_TABLA, VARIABLE_PREGUNTA, VARIABLE_PAGINA,VARIABLE_MODULO
    };

    public static final String[] ALL_COLUMNS_MODULOS = {
            MODULO_ID, MODULO_TITULO, MODULO_CABECERA, MODULO_NTABLA
    };

    public static final String[] ALL_COLUMNS_EVENTOS = {
            EVENTO_ID, EVENTO_IDPREGA,EVENTO_IDPREGB ,EVENTO_VAR,
            EVENTO_VAL,EVENTO_IDPAGA, EVENTO_IDPAGB, EVENTO_ACCION
    };

    public static final String[] ALL_COLUMNS_PAGINAS = {
            PAGINA_ID ,PAGINA_MODULO ,
            PAGINA_IDP1 , PAGINA_TP1 ,
            PAGINA_IDP2 , PAGINA_TP2 ,
            PAGINA_IDP3 , PAGINA_TP3 ,
            PAGINA_IDP4 , PAGINA_TP4 ,
            PAGINA_IDP5 , PAGINA_TP5 ,
            PAGINA_IDP6 , PAGINA_TP6 ,
            PAGINA_IDP7 , PAGINA_TP7 ,
            PAGINA_IDP8 , PAGINA_TP8 ,
            PAGINA_IDP9 , PAGINA_TP9 ,
            PAGINA_IDP10 , PAGINA_TP10
    };

    public static final String[] ALL_COLUMNS_OPCION_SPINNER = {
            OPCION_SPINNER_ID , OPCION_SPINNER_IDVARIABLE ,
            OPCION_SPINNER_NDATO, OPCION_SPINNER_DATO
    };

    public static final String[] ALL_COLUMNS_INFOTABLAS = {
            INFOTABLAS_ID, INFOTABLAS_PARTE, INFOTABLAS_NOMBRE,
            INFOTABLAS_MODULO,INFOTABLAS_TIPO
    };

}
