package pe.com.ricindigus.generadorinei.componentes.componente_formulario;

import android.content.Context;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


/**
 * Created by dmorales on 30/01/2018.
 */

public class FormularioPullParser {
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
    public static final String SP_FORMU_VARCK = "VARCK";


    private String currentTag = null;
    private Formulario currentFormulario = null;
    private SPFormulario currentSPFormulario = null;

    ArrayList<Formulario> formularios = new ArrayList<Formulario>();
    ArrayList<SPFormulario> spFormularios = new ArrayList<SPFormulario>();

    public ArrayList<Formulario> parseXMLFormulario(Context context){
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();

            try {
                InputStream stream = context.getAssets().open("preguntas_formulario.xml");
                xpp.setInput(stream,null);

                int eventType = xpp.getEventType();

                while(eventType != XmlPullParser.END_DOCUMENT){
                    if(eventType == XmlPullParser.START_TAG){
                        handleStarTagFormulario(xpp.getName());
                    }else if(eventType == XmlPullParser.END_TAG){
                        currentTag = null;
                    }else if(eventType == XmlPullParser.TEXT){
                        handleTextFormulario(xpp.getText());
                    }
                    eventType = xpp.next();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        return formularios;
    }

    private void handleTextFormulario(String text) {
        String xmlText = text;
        if(currentFormulario!= null && currentTag != null){
            switch (currentTag){
                case FORMULARIO_ID:currentFormulario.setID(xmlText);break;
                case FORMULARIO_MODULO:currentFormulario.setMODULO(xmlText);break;
                case FORMULARIO_NUMERO:currentFormulario.setNUMERO(xmlText);break;
                case FORMULARIO_TITULO:currentFormulario.setTITULO(xmlText);break;
            }
        }
    }

    private void handleStarTagFormulario(String name) {
        if(name.equals("FORMULARIO")){
            currentFormulario = new Formulario();
            formularios.add(currentFormulario);
        }else{
            currentTag = name;
        }
    }

    public ArrayList<SPFormulario> parseXMLSPFormulario(Context context){
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();

            try {
                InputStream stream = context.getAssets().open("subpreguntas_formulario.xml");
                xpp.setInput(stream,null);

                int eventType = xpp.getEventType();

                while(eventType != XmlPullParser.END_DOCUMENT){
                    if(eventType == XmlPullParser.START_TAG){
                        handleStarTagSPFormulario(xpp.getName());
                    }else if(eventType == XmlPullParser.END_TAG){
                        currentTag = null;
                    }else if(eventType == XmlPullParser.TEXT){
                        handleTextSPFormulario(xpp.getText());
                    }
                    eventType = xpp.next();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        return spFormularios;
    }

    private void handleTextSPFormulario(String text) {
        String xmlText = text;
        if(currentSPFormulario!= null && currentTag != null){
            switch (currentTag){
                case SP_FORMU_ID: currentSPFormulario.setID(xmlText);break;
                case SP_FORMU_IDPREGUNTA: currentSPFormulario.setID_PREGUNTA(xmlText);break;
                case SP_FORMU_SUBPREGUNTA: currentSPFormulario.setSUBPREGUNTA(xmlText);break;
                case SP_FORMU_VARE: currentSPFormulario.setVARE(xmlText);break;
                case SP_FORMU_LONG: currentSPFormulario.setLONG(xmlText);break;
                case SP_FORMU_TIPO: currentSPFormulario.setTIPO(xmlText);break;
                case SP_FORMU_VARS: currentSPFormulario.setVARS(xmlText);break;
                case SP_FORMU_VARESP: currentSPFormulario.setVARESP(xmlText);break;
                case SP_FORMU_VARCK: currentSPFormulario.setVARCK(xmlText);break;
            }
        }
    }

    private void handleStarTagSPFormulario(String name) {
        if(name.equals("SP_FORMULARIO")){
            currentSPFormulario = new SPFormulario();
            spFormularios.add(currentSPFormulario);
        }else{
            currentTag = name;
        }
    }
}
