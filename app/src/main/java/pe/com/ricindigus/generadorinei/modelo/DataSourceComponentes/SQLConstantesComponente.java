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
    public static final String tablaEditText = "edittexts";
    public static final String tablaCheckBox = "checkboxs";
    public static final String tablaRadio = "radios";


    //COLUMNAS ENCUESTAS
    public static final String ENCUESTA_ID = "ID";
    public static final String ENCUESTA_TITULO = "TITULO";

    //COLUMNAS MODULOS
    public static final String MODULO_ID = "ID";
    public static final String MODULO_TITULO = "TITULO";

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

    //COLUMNAS EDIT TEXT
    public static final String EDITTEXT_ID = "ID";
    public static final String EDITTEXT_MODULO = "MODULO";
    public static final String EDITTEXT_NUMERO = "NUMERO";
    public static final String EDITTEXT_PAGINA = "PAGINA";
    public static final String EDITTEXT_PREGUNTA = "PREGUNTA";
    public static final String EDITTEXT_SP1 = "SP1";
    public static final String EDITTEXT_VAR1 = "VAR1";
    public static final String EDITTEXT_SP2 = "SP2";
    public static final String EDITTEXT_VAR2 = "VAR2";
    public static final String EDITTEXT_SP3 = "SP3";
    public static final String EDITTEXT_VAR3 = "VAR3";

    //COLUMNAS CHECKBOX
    public static final String CHECKBOX_ID = "ID";
    public static final String CHECKBOX_MODULO = "MODULO";
    public static final String CHECKBOX_NUMERO = "NUMERO";
    public static final String CHECKBOX_PAGINA = "PAGINA";
    public static final String CHECKBOX_PREGUNTA = "PREGUNTA";
    public static final String CHECKBOX_SP1 = "SP1";
    public static final String CHECKBOX_VAR1 = "VAR1";
    public static final String CHECKBOX_SP2 = "SP2";
    public static final String CHECKBOX_VAR2 = "VAR2";
    public static final String CHECKBOX_SP3 = "SP3";
    public static final String CHECKBOX_VAR3 = "VAR3";
    public static final String CHECKBOX_SP4 = "SP4";
    public static final String CHECKBOX_VAR4 = "VAR4";
    public static final String CHECKBOX_SP5 = "SP5";
    public static final String CHECKBOX_VAR5 = "VAR5";
    public static final String CHECKBOX_SP6 = "SP6";
    public static final String CHECKBOX_VAR6 = "VAR6";
    public static final String CHECKBOX_SP7 = "SP7";
    public static final String CHECKBOX_VAR7 = "VAR7";
    public static final String CHECKBOX_SP8 = "SP8";
    public static final String CHECKBOX_VAR8 = "VAR8";
    public static final String CHECKBOX_SP9 = "SP9";
    public static final String CHECKBOX_VAR9 = "VAR9";
    public static final String CHECKBOX_SP10 = "SP10";
    public static final String CHECKBOX_VAR10 = "VAR10";
    public static final String CHECKBOX_SP11 = "SP11";
    public static final String CHECKBOX_VAR11 = "VAR11";
    public static final String CHECKBOX_SP12 = "SP12";
    public static final String CHECKBOX_VAR12 = "VAR12";
    public static final String CHECKBOX_SP13 = "SP13";
    public static final String CHECKBOX_VAR13 = "VAR13";
    public static final String CHECKBOX_SP14 = "SP14";
    public static final String CHECKBOX_VAR14 = "VAR14";
    public static final String CHECKBOX_SP15 = "SP15";
    public static final String CHECKBOX_VAR15 = "VAR15";
    public static final String CHECKBOX_SP16 = "SP16";
    public static final String CHECKBOX_VAR16 = "VAR16";
    public static final String CHECKBOX_SP17 = "SP17";
    public static final String CHECKBOX_VAR17 = "VAR17";
    public static final String CHECKBOX_SP18 = "SP18";
    public static final String CHECKBOX_VAR18 = "VAR18";
    public static final String CHECKBOX_SP19 = "SP19";
    public static final String CHECKBOX_VAR19 = "VAR19";
    public static final String CHECKBOX_VARESP = "VARESP";

    //COLUMNAS RADIO
    public static final String RADIO_ID = "ID";
    public static final String RADIO_MODULO = "MODULO";
    public static final String RADIO_NUMERO = "NUMERO";
    public static final String RADIO_PAGINA = "PAGINA";
    public static final String RADIO_PREGUNTA = "PREGUNTA";
    public static final String RADIO_SP1 = "SP1";
    public static final String RADIO_SP2 = "SP2";
    public static final String RADIO_SP3 = "SP3";
    public static final String RADIO_SP4 = "SP4";
    public static final String RADIO_SP5 = "SP5";
    public static final String RADIO_SP6 = "SP6";
    public static final String RADIO_SP7 = "SP7";
    public static final String RADIO_SP8 = "SP8";
    public static final String RADIO_SP9 = "SP9";
    public static final String RADIO_SP10 = "SP10";
    public static final String RADIO_VARRADIO = "VARRADIO";
    public static final String RADIO_VARESP = "VARESP";

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
                    MODULO_TITULO + " TEXT" + ");"
            ;

    public static final String SQL_CREATE_TABLA_EDITTEXT =
            "CREATE TABLE " + tablaEditText + "(" +
                    EDITTEXT_ID + " TEXT PRIMARY KEY," +
                    EDITTEXT_MODULO + " TEXT," +
                    EDITTEXT_NUMERO + " TEXT," +
                    EDITTEXT_PAGINA + " TEXT," +
                    EDITTEXT_PREGUNTA + " TEXT," +
                    EDITTEXT_SP1 + " TEXT," +
                    EDITTEXT_VAR1 + " TEXT," +
                    EDITTEXT_SP2 + " TEXT," +
                    EDITTEXT_VAR2 + " TEXT," +
                    EDITTEXT_SP3 + " TEXT," +
                    EDITTEXT_VAR3 + " TEXT" + ");"
            ;

    public static final String SQL_CREATE_TABLA_CHECKBOX =
            "CREATE TABLE " + tablaCheckBox + "(" +
                    CHECKBOX_ID + " TEXT PRIMARY KEY," +
                    CHECKBOX_MODULO + " TEXT," +
                    CHECKBOX_NUMERO + " TEXT," +
                    CHECKBOX_PAGINA + " TEXT," +
                    CHECKBOX_PREGUNTA + " TEXT," +
                    CHECKBOX_SP1 + " TEXT," +
                    CHECKBOX_VAR1 + " TEXT," +
                    CHECKBOX_SP2 + " TEXT," +
                    CHECKBOX_VAR2 + " TEXT," +
                    CHECKBOX_SP3 + " TEXT," +
                    CHECKBOX_VAR3 + " TEXT," +
                    CHECKBOX_SP4 + " TEXT," +
                    CHECKBOX_VAR4 + " TEXT," +
                    CHECKBOX_SP5 + " TEXT," +
                    CHECKBOX_VAR5 + " TEXT," +
                    CHECKBOX_SP6 + " TEXT," +
                    CHECKBOX_VAR6 + " TEXT," +
                    CHECKBOX_SP7 + " TEXT," +
                    CHECKBOX_VAR7 + " TEXT," +
                    CHECKBOX_SP8 + " TEXT," +
                    CHECKBOX_VAR8 + " TEXT," +
                    CHECKBOX_SP9 + " TEXT," +
                    CHECKBOX_VAR9 + " TEXT," +
                    CHECKBOX_SP10 + " TEXT," +
                    CHECKBOX_VAR10 + " TEXT," +
                    CHECKBOX_SP11 + " TEXT," +
                    CHECKBOX_VAR11 + " TEXT," +
                    CHECKBOX_SP12 + " TEXT," +
                    CHECKBOX_VAR12 + " TEXT," +
                    CHECKBOX_SP13 + " TEXT," +
                    CHECKBOX_VAR13 + " TEXT," +
                    CHECKBOX_SP14 + " TEXT," +
                    CHECKBOX_VAR14 + " TEXT," +
                    CHECKBOX_SP15 + " TEXT," +
                    CHECKBOX_VAR15 + " TEXT," +
                    CHECKBOX_SP16 + " TEXT," +
                    CHECKBOX_VAR16 + " TEXT," +
                    CHECKBOX_SP17 + " TEXT," +
                    CHECKBOX_VAR17 + " TEXT," +
                    CHECKBOX_SP18 + " TEXT," +
                    CHECKBOX_VAR18 + " TEXT," +
                    CHECKBOX_SP19 + " TEXT," +
                    CHECKBOX_VAR19 + " TEXT," +
                    CHECKBOX_VARESP + " TEXT" + ");"
            ;

    public static final String SQL_CREATE_TABLA_RADIO =
            "CREATE TABLE " + tablaRadio + "(" +
                    RADIO_ID + " TEXT PRIMARY KEY," +
                    RADIO_MODULO + " TEXT," +
                    RADIO_NUMERO + " TEXT," +
                    RADIO_PAGINA + " TEXT," +
                    RADIO_PREGUNTA + " TEXT," +
                    RADIO_SP1 + " TEXT," +
                    RADIO_SP2 + " TEXT," +
                    RADIO_SP3 + " TEXT," +
                    RADIO_SP4 + " TEXT," +
                    RADIO_SP5 + " TEXT," +
                    RADIO_SP6 + " TEXT," +
                    RADIO_SP7 + " TEXT," +
                    RADIO_SP8 + " TEXT," +
                    RADIO_SP9 + " TEXT," +
                    RADIO_SP10 + " TEXT," +
                    RADIO_VARRADIO + " TEXT," +
                    RADIO_VARESP + " TEXT" + ");"
            ;

    //CLAUSULA WHERE BUSQUEDA (WHERE)
    public static final String WHERE_CLAUSE_ID = "ID=?";


    //BORRADO DE TABLAS (DELETE)
    public static final String SQL_DELETE_ENCUESTAS = "DROP TABLE " + tablaEncuestas;
    public static final String SQL_DELETE_MODULOS = "DROP TABLE " + tablaModulos;
    public static final String SQL_DELETE_PAGINAS = "DROP TABLE " + tablaPaginas;
    public static final String SQL_DELETE_EDITTEXT = "DROP TABLE " + tablaEditText;
    public static final String SQL_DELETE_CHECKBOX = "DROP TABLE " + tablaCheckBox;
    public static final String SQL_DELETE_RADIO = "DROP TABLE " + tablaRadio;


    //TRAER TODAS LAS COLUMNAS
    public static final String[] ALL_COLUMNS_ENCUESTA = {
            ENCUESTA_ID, ENCUESTA_TITULO
    };

    public static final String[] ALL_COLUMNS_MODULOS = {
            MODULO_ID, MODULO_TITULO
    };


    public static final String[] ALL_COLUMNS_PAGINAS = {
            PAGINA_ID, PAGINA_MODULO , PAGINA_IDP1 , PAGINA_TP1 ,
            PAGINA_IDP2 , PAGINA_TP2 , PAGINA_IDP3 , PAGINA_TP3 ,
            PAGINA_IDP4 , PAGINA_TP4 , PAGINA_IDP5 , PAGINA_TP5,
            PAGINA_IDP6 , PAGINA_TP6, PAGINA_IDP7 , PAGINA_TP7,
            PAGINA_IDP8 , PAGINA_TP8, PAGINA_IDP9 , PAGINA_TP9,
            PAGINA_IDP10 , PAGINA_TP10
    };

    public static final String[] ALL_COLUMNS_EDITTEXT = {
            EDITTEXT_ID, EDITTEXT_MODULO , EDITTEXT_NUMERO , EDITTEXT_PAGINA, EDITTEXT_PREGUNTA ,
            EDITTEXT_SP1 , EDITTEXT_VAR1, EDITTEXT_SP2 , EDITTEXT_VAR2 , EDITTEXT_SP3 , EDITTEXT_VAR3
    };

    public static final String[] ALL_COLUMNS_CHECKBOX = {
            CHECKBOX_ID , CHECKBOX_MODULO , CHECKBOX_NUMERO , CHECKBOX_PAGINA, CHECKBOX_PREGUNTA,
            CHECKBOX_SP1 , CHECKBOX_VAR1, CHECKBOX_SP2 , CHECKBOX_VAR2 ,
            CHECKBOX_SP3 , CHECKBOX_VAR3 , CHECKBOX_SP4 , CHECKBOX_VAR4 ,
            CHECKBOX_SP5 , CHECKBOX_VAR5 , CHECKBOX_SP6 , CHECKBOX_VAR6 ,
            CHECKBOX_SP7 , CHECKBOX_VAR7 , CHECKBOX_SP8 , CHECKBOX_VAR8 ,
            CHECKBOX_SP9 , CHECKBOX_VAR9 , CHECKBOX_SP10 , CHECKBOX_VAR10 ,
            CHECKBOX_SP11 , CHECKBOX_VAR11 , CHECKBOX_SP12 , CHECKBOX_VAR12 ,
            CHECKBOX_SP13 , CHECKBOX_VAR13 , CHECKBOX_SP14 , CHECKBOX_VAR14 ,
            CHECKBOX_SP15 , CHECKBOX_VAR15 , CHECKBOX_SP16 , CHECKBOX_VAR16 ,
            CHECKBOX_SP17 , CHECKBOX_VAR17 , CHECKBOX_SP18 , CHECKBOX_VAR18 ,
            CHECKBOX_SP19 , CHECKBOX_VAR19 , CHECKBOX_VARESP
    };

    public static final String[] ALL_COLUMNS_RADIO = {
            RADIO_ID , RADIO_MODULO, RADIO_NUMERO , RADIO_PREGUNTA , RADIO_PAGINA,
            RADIO_SP1 , RADIO_SP2 , RADIO_SP3 , RADIO_SP4 , RADIO_SP5 ,
            RADIO_SP6 , RADIO_SP7 , RADIO_SP8 , RADIO_SP9 ,RADIO_SP10,
            RADIO_VARRADIO, RADIO_VARESP
    };
}
