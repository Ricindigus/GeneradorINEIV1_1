package pe.com.ricindigus.generadorinei.modelo;

/**
 * Created by dmorales on 23/11/2017.
 */

public class SQLConstantesComponente {
    public static final String NOMBRE_DB = "generador.db";

    //TABLAS
    public static final String tablaEncuestas = "encuestas";
    public static final String tablaResultadoVisitas = "resultadoVisitas";
    public static final String tablaPreguntas = "preguntas";
    public static final String tablaEditText = "EditText";

    //COLUMNAS ENCUESTAS
    public static final String ID_ENCUESTA = "id";
    public static final String TITULO_ENCUESTA = "titulo";
    public static final String PERIODOS_ENCUESTA = "periodo";
    public static final String GPS_ENCUESTA = "gps";

    //COLUMNAS RESULTADO VISITAS
    public static final String ID_VISITA = "id";
    public static final String RESULTADO_VISITA = "resultado";

    //COLUMNAS PREGUNTAS
    public static final String ID_PREGUNTA = "id";
    public static final String TEXTO_PREGUNTA = "pregunta";
    public static final String TIPO_PREGUNTA = "tipo";

    //COLUMNAS EDIT TEXT
    public static final String EDITTEXT_ID = "id";
    public static final String EDITTEXT_SP1 = "sp1";
    public static final String EDITTEXT_VAR1 = "var1";
    public static final String EDITTEXT_SP2 = "sp2";
    public static final String EDITTEXT_VAR2 = "var2";
    public static final String EDITTEXT_SP3 = "sp3";
    public static final String EDITTEXT_VAR3 = "var3";


}
