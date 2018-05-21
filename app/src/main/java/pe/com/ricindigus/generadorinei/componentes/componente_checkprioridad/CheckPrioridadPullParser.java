package pe.com.ricindigus.generadorinei.componentes.componente_checkprioridad;

import android.content.Context;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.componentes.componente_checkprioridad.pojos.PCheckPrioridad;
import pe.com.ricindigus.generadorinei.componentes.componente_checkprioridad.pojos.SPCheckPrioridad;

import static android.os.Environment.getExternalStorageDirectory;

/**
 * Created by dmorales on 30/04/2018.
 */

public class
CheckPrioridadPullParser {

    //COLUMNAS CHECKPRIORIDAD
    public static final String CHECKPRIORIDAD_ID = "ID";
    public static final String CHECKPRIORIDAD_MODULO = "MODULO";
    public static final String CHECKPRIORIDAD_NUMERO = "NUMERO";
    public static final String CHECKPRIORIDAD_PREGUNTA = "PREGUNTA";
    public static final String CHECKPRIORIDAD_CAB1 = "CAB1";
    public static final String CHECKPRIORIDAD_CAB2 = "CAB2";
    public static final String CHECKPRIORIDAD_PRIORIDAD = "PRIORIDAD";


    //COLUMNAS SUBPREGUNTAS CHECKPRIORIDAD
    public static final String SPCHECKPRIORIDAD_ID = "ID";
    public static final String SPCHECKPRIORIDAD_ID_PREGUNTA = "ID_PREGUNTA";
    public static final String SPCHECKPRIORIDAD_SUBPREGUNTA = "SUBPREGUNTA";
    public static final String SPCHECKPRIORIDAD_VARCK = "VARCK";
    public static final String SPCHECKPRIORIDAD_VARESP = "VARESP";
    public static final String SPCHECKPRIORIDAD_VARSP = "VARSP";



    private String currentTag = null;
    private PCheckPrioridad currentCheckPrioridad = null;
    private SPCheckPrioridad currentSPCheckPrioridad = null;

    ArrayList<PCheckPrioridad> pCheckPrioridads = new ArrayList<>();
    ArrayList<SPCheckPrioridad> spCheckPrioridads = new ArrayList<>();

    public ArrayList<PCheckPrioridad> parseXMLPCheckPrioridad(Context context){
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();

            try {
                InputStream stream = context.getAssets().open("preguntas_checkprioridad.xml");
                xpp.setInput(stream,null);

                int eventType = xpp.getEventType();

                while(eventType != XmlPullParser.END_DOCUMENT){
                    if(eventType == XmlPullParser.START_TAG){
                        handleStarTagPCheckPrioridad(xpp.getName());
                    }else if(eventType == XmlPullParser.END_TAG){
                        currentTag = null;
                    }else if(eventType == XmlPullParser.TEXT){
                        handleTextPCheckPrioridad(xpp.getText());
                    }
                    eventType = xpp.next();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        return pCheckPrioridads;
    }

    public ArrayList<PCheckPrioridad> parseXMLPCheckPrioridad(Context context, String archivo){
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();
            FileInputStream fis = null;
            try {
                File nuevaCarpeta = new File(getExternalStorageDirectory(), "GENERADOR");
                File file = new File(nuevaCarpeta, archivo);
                FileInputStream fileInputStream = new FileInputStream(file);
                fis = new FileInputStream(file);
                xpp.setInput(fis, null);
                int eventType = xpp.getEventType();

                while(eventType != XmlPullParser.END_DOCUMENT){
                    if(eventType == XmlPullParser.START_TAG){
                        handleStarTagPCheckPrioridad(xpp.getName());
                    }else if(eventType == XmlPullParser.END_TAG){
                        currentTag = null;
                    }else if(eventType == XmlPullParser.TEXT){
                        handleTextPCheckPrioridad(xpp.getText());
                    }
                    eventType = xpp.next();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        return pCheckPrioridads;
    }

    private void handleTextPCheckPrioridad(String text) {
        String xmlText = text;
        if(currentCheckPrioridad != null && currentTag != null){
            switch (currentTag){
                case CHECKPRIORIDAD_ID:
                    currentCheckPrioridad.setID(xmlText);break;
                case CHECKPRIORIDAD_MODULO:
                    currentCheckPrioridad.setMODULO(xmlText);break;
                case CHECKPRIORIDAD_NUMERO:
                    currentCheckPrioridad.setNUMERO(xmlText);break;
                case CHECKPRIORIDAD_PREGUNTA:
                    currentCheckPrioridad.setPREGUNTA(xmlText);break;
                case CHECKPRIORIDAD_CAB1:
                    currentCheckPrioridad.setCAB1(xmlText);break;
                case CHECKPRIORIDAD_CAB2:
                    currentCheckPrioridad.setCAB2(xmlText);break;
                case CHECKPRIORIDAD_PRIORIDAD:
                    currentCheckPrioridad.setPRIORIDAD(xmlText);break;
            }
        }
    }

    private void handleStarTagPCheckPrioridad(String name) {
        if(name.equals("CHECKPRIORIDAD")){
            currentCheckPrioridad = new PCheckPrioridad();
            pCheckPrioridads.add(currentCheckPrioridad);
        }else{
            currentTag = name;
        }
    }

    public ArrayList<SPCheckPrioridad> parseXMLSPCheckPrioridad(Context context){
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();

            try {
                InputStream stream = context.getAssets().open("subpreguntas_checkprioridad.xml");
                xpp.setInput(stream,null);

                int eventType = xpp.getEventType();
                while(eventType != XmlPullParser.END_DOCUMENT){
                    if(eventType == XmlPullParser.START_TAG){
                        handleStarTagSPCheckPrioridad(xpp.getName());
                    }else if(eventType == XmlPullParser.END_TAG){
                        currentTag = null;
                    }else if(eventType == XmlPullParser.TEXT){
                        handleTextSPCheckPrioridad(xpp.getText());
                    }
                    eventType = xpp.next();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        return spCheckPrioridads;
    }

    public ArrayList<SPCheckPrioridad> parseXMLSPCheckPrioridad(Context context, String archivo){
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();
            FileInputStream fis = null;
            try {
                File nuevaCarpeta = new File(getExternalStorageDirectory(), "GENERADOR");
                File file = new File(nuevaCarpeta, archivo);
                FileInputStream fileInputStream = new FileInputStream(file);
                fis = new FileInputStream(file);
                xpp.setInput(fis, null);
                int eventType = xpp.getEventType();

                while(eventType != XmlPullParser.END_DOCUMENT){
                    if(eventType == XmlPullParser.START_TAG){
                        handleStarTagSPCheckPrioridad(xpp.getName());
                    }else if(eventType == XmlPullParser.END_TAG){
                        currentTag = null;
                    }else if(eventType == XmlPullParser.TEXT){
                        handleTextSPCheckPrioridad(xpp.getText());
                    }
                    eventType = xpp.next();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        return spCheckPrioridads;
    }


    private void handleTextSPCheckPrioridad(String text) {
        String xmlText = text;
        if(currentSPCheckPrioridad != null && currentTag != null){
            switch (currentTag){
                case SPCHECKPRIORIDAD_ID: currentSPCheckPrioridad.setID(xmlText);break;
                case SPCHECKPRIORIDAD_ID_PREGUNTA: currentSPCheckPrioridad.setID_PREGUNTA(xmlText);break;
                case SPCHECKPRIORIDAD_SUBPREGUNTA: currentSPCheckPrioridad.setSUBPREGUNTA(xmlText);break;
                case SPCHECKPRIORIDAD_VARCK: currentSPCheckPrioridad.setVARCK(xmlText);break;
                case SPCHECKPRIORIDAD_VARESP: currentSPCheckPrioridad.setVARESP(xmlText);break;
                case SPCHECKPRIORIDAD_VARSP: currentSPCheckPrioridad.setVARSP(xmlText);break;
            }
        }
    }

    private void handleStarTagSPCheckPrioridad(String name) {
        if(name.equals("SP_CHECKPRIORIDAD")){
            currentSPCheckPrioridad = new SPCheckPrioridad();
            spCheckPrioridads.add(currentSPCheckPrioridad);
        }else{
            currentTag = name;
        }
    }
}
