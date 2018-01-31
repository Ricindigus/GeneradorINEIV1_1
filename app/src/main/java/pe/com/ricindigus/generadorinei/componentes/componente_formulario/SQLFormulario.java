package pe.com.ricindigus.generadorinei.componentes.componente_formulario;

/**
 * Created by dmorales on 30/01/2018.
 */

public class SQLFormulario {
    public static final String tablaFormulario = "formularios";
    public static final String tablaSPFormulario = "spformularios";

    public static final String FORMULARIO_ID = "ID";
    public static final String FORMULARIO_MODULO = "MODULO";
    public static final String FORMULARIO_NUMERO = "NUMERO";
    public static final String FORMULARIO_TITULO= "TITULO";


    public static final String SP_FORMU_ID= "ID";
    public static final String SP_FORMU_IDPREGUNTA= "ID_PREGUNTA";
    public static final String SP_FORMU_SUBPREGUNTA= "SUBPREGUNTA";
    public static final String SP_FORMU_VARE = "VARE";
    public static final String SP_FORMU_TIPO = "TIPO";
    public static final String SP_FORMU_LONG = "LONG";
    public static final String SP_FORMU_VARS = "VARS";
    public static final String SP_FORMU_VARESP = "VARESP";
    public static final String SP_FORMU_TIPESP = "TIPESP";
    public static final String SP_FORMU_LONESP = "LONESP";
    public static final String SP_FORMU_HABESP = "HABESP";
    public static final String SP_FORMU_VARCK = "VARCK";


    public static final String SQL_CREATE_TABLA_FORMULARIO = "CREATE TABLE " + tablaFormulario + "(" +
            FORMULARIO_ID + " TEXT PRIMARY KEY," +
            FORMULARIO_MODULO + " TEXT," +
            FORMULARIO_NUMERO + " TEXT," +
            FORMULARIO_TITULO + " TEXT" + ");"
            ;

    public static final String SQL_CREATE_TABLA_SP_FORMULARIO = "CREATE TABLE " + tablaSPFormulario + "(" +
            SP_FORMU_ID + " TEXT PRIMARY KEY," +
            SP_FORMU_IDPREGUNTA + " TEXT," +
            SP_FORMU_SUBPREGUNTA + " TEXT," +
            SP_FORMU_VARE + " TEXT," +
            SP_FORMU_TIPO + " TEXT," +
            SP_FORMU_LONG + " TEXT," +
            SP_FORMU_VARS + " TEXT," +
            SP_FORMU_VARESP + " TEXT," +
            SP_FORMU_TIPESP + " TEXT," +
            SP_FORMU_LONESP + " TEXT," +
            SP_FORMU_HABESP + " TEXT," +
            SP_FORMU_VARCK + " TEXT" + ");"
            ;

    public static final String SQL_DELETE_FORMULARIO= "DROP TABLE " + tablaFormulario;
    public static final String SQL_DELETE_SP_FORMULARIO= "DROP TABLE " + tablaSPFormulario;


    //WHERE
    public static final String WHERE_CLAUSE_ID = "ID=?";
    public static final String WHERE_CLAUSE_ID_PREGUNTA = "ID_PREGUNTA=?";


    public static final String[] ALL_COLUMNS_FORMULARIO = {
            FORMULARIO_ID, FORMULARIO_MODULO, FORMULARIO_NUMERO, FORMULARIO_TITULO
    };

    public static final String[] ALL_COLUMNS_SP_FORMULARIO = {
            SP_FORMU_ID, SP_FORMU_IDPREGUNTA, SP_FORMU_SUBPREGUNTA, SP_FORMU_VARE,
            SP_FORMU_TIPO, SP_FORMU_LONG, SP_FORMU_VARS, SP_FORMU_VARESP,
            SP_FORMU_TIPESP,SP_FORMU_LONESP,
            SP_FORMU_HABESP,SP_FORMU_VARCK
    };
}
