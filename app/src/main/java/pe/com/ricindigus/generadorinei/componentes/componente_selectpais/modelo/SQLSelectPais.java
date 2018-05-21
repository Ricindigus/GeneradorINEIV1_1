package pe.com.ricindigus.generadorinei.componentes.componente_selectpais.modelo;

public class SQLSelectPais {
    public static final String tablaSelectPais = "selectpais";

    //COLUMNAS SELECTPAIS
    public static final String SELECTPAIS_ID = "ID";
    public static final String SELECTPAIS_MODULO = "MODULO";
    public static final String SELECTPAIS_NUMERO = "NUMERO";
    public static final String SELECTPAIS_PREGUNTA = "PREGUNTA";
    public static final String SELECTPAIS_VARPAIS = "VARPAIS";


    public static final String SQL_CREATE_TABLA_SELECTPAIS =
            "CREATE TABLE " + tablaSelectPais + "(" +
                    SELECTPAIS_ID + " TEXT PRIMARY KEY," +
                    SELECTPAIS_MODULO + " TEXT," +
                    SELECTPAIS_NUMERO + " TEXT," +
                    SELECTPAIS_PREGUNTA + " TEXT," +
                    SELECTPAIS_VARPAIS + " TEXT" + ");"
            ;


    public static final String SQL_DELETE_SELECTPAIS = "DROP TABLE " + tablaSelectPais;

    //WHERE
    public static final String WHERE_CLAUSE_ID = "ID=?";
    public static final String WHERE_CLAUSE_ID_PREGUNTA = "ID_PREGUNTA=?";


    public static final String[] ALL_COLUMNS_SELECTPAIS = {
            SELECTPAIS_ID, SELECTPAIS_MODULO , SELECTPAIS_NUMERO , SELECTPAIS_PREGUNTA, SELECTPAIS_VARPAIS
    };

}
