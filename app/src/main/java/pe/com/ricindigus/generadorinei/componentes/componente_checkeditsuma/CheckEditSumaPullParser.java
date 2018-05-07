package pe.com.ricindigus.generadorinei.componentes.componente_checkeditsuma;

import android.content.Context;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.componentes.componente_checkeditsuma.pojos.PCheckEditSuma;
import pe.com.ricindigus.generadorinei.componentes.componente_checkeditsuma.pojos.SPCheckEditSuma;
import pe.com.ricindigus.generadorinei.componentes.componente_editsuma.pojos.PEditSuma;
import pe.com.ricindigus.generadorinei.componentes.componente_editsuma.pojos.SPEditSuma;

import static android.os.Environment.getExternalStorageDirectory;

/**
 * Created by dmorales on 30/04/2018.
 */

public class
CheckEditSumaPullParser {

    //COLUMNAS CHECKEDITSUMA
    public static final String CHECKEDITSUMA_ID = "ID";
    public static final String CHECKEDITSUMA_MODULO = "MODULO";
    public static final String CHECKEDITSUMA_NUMERO = "NUMERO";
    public static final String CHECKEDITSUMA_PREGUNTA = "PREGUNTA";
    public static final String CHECKEDITSUMA_CABPREG = "CABPREG";
    public static final String CHECKEDITSUMA_CABRES = "CABRES";
    public static final String CHECKEDITSUMA_VALSUMA = "VALSUMA";


    //COLUMNAS SUBPREGUNTAS CHECKEDITSUMA
    public static final String SPCHECKEDITSUMA_ID = "ID";
    public static final String SPCHECKEDITSUMA_ID_PREGUNTA = "ID_PREGUNTA";
    public static final String SPCHECKEDITSUMA_SUBPREGUNTA = "SUBPREGUNTA";
    public static final String SPCHECKEDITSUMA_VARIABLE = "VARIABLE";
    public static final String SPCHECKEDITSUMA_VARESP = "VARESP";
    public static final String SPCHECKEDITSUMA_LONGITUD = "LONGITUD";


    private String currentTag = null;
    private PCheckEditSuma currentCheckEditSuma = null;
    private SPCheckEditSuma currentSPCheckEditSuma = null;

    ArrayList<PCheckEditSuma> pCheckEditSumas = new ArrayList<>();
    ArrayList<SPCheckEditSuma> spCheckEditSumas = new ArrayList<>();

    public ArrayList<PCheckEditSuma> parseXMLPCheckEditSuma(Context context){
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();

            try {
                InputStream stream = context.getAssets().open("preguntas_checkeditsuma.xml");
                xpp.setInput(stream,null);

                int eventType = xpp.getEventType();

                while(eventType != XmlPullParser.END_DOCUMENT){
                    if(eventType == XmlPullParser.START_TAG){
                        handleStarTagPCheckEditSuma(xpp.getName());
                    }else if(eventType == XmlPullParser.END_TAG){
                        currentTag = null;
                    }else if(eventType == XmlPullParser.TEXT){
                        handleTextPCheckEditSuma(xpp.getText());
                    }
                    eventType = xpp.next();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        return pCheckEditSumas;
    }

    public ArrayList<PCheckEditSuma> parseXMLPCheckEditSuma(Context context, String archivo){
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
                        handleStarTagPCheckEditSuma(xpp.getName());
                    }else if(eventType == XmlPullParser.END_TAG){
                        currentTag = null;
                    }else if(eventType == XmlPullParser.TEXT){
                        handleTextPCheckEditSuma(xpp.getText());
                    }
                    eventType = xpp.next();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        return pCheckEditSumas;
    }

    private void handleTextPCheckEditSuma(String text) {
        String xmlText = text;
        if(currentCheckEditSuma != null && currentTag != null){
            switch (currentTag){
                case CHECKEDITSUMA_ID:
                    currentCheckEditSuma.setID(xmlText);break;
                case CHECKEDITSUMA_MODULO:
                    currentCheckEditSuma.setMODULO(xmlText);break;
                case CHECKEDITSUMA_NUMERO:
                    currentCheckEditSuma.setNUMERO(xmlText);break;
                case CHECKEDITSUMA_PREGUNTA:
                    currentCheckEditSuma.setPREGUNTA(xmlText);break;
                case CHECKEDITSUMA_CABPREG:
                    currentCheckEditSuma.setCABPREG(xmlText);break;
                case CHECKEDITSUMA_CABRES:
                    currentCheckEditSuma.setCABRES(xmlText);break;
                case CHECKEDITSUMA_VALSUMA:
                    currentCheckEditSuma.setVALSUMA(xmlText);break;
            }
        }
    }

    private void handleStarTagPCheckEditSuma(String name) {
        if(name.equals("CHECKEDITSUMA")){
            currentCheckEditSuma = new PCheckEditSuma();
            pCheckEditSumas.add(currentCheckEditSuma);
        }else{
            currentTag = name;
        }
    }

    public ArrayList<SPCheckEditSuma> parseXMLSPCheckEditSuma(Context context){
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();

            try {
                InputStream stream = context.getAssets().open("subpreguntas_checkeditsuma.xml");
                xpp.setInput(stream,null);

                int eventType = xpp.getEventType();
                while(eventType != XmlPullParser.END_DOCUMENT){
                    if(eventType == XmlPullParser.START_TAG){
                        handleStarTagSPCheckEditSuma(xpp.getName());
                    }else if(eventType == XmlPullParser.END_TAG){
                        currentTag = null;
                    }else if(eventType == XmlPullParser.TEXT){
                        handleTextSPCheckEditSuma(xpp.getText());
                    }
                    eventType = xpp.next();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        return spCheckEditSumas;
    }

    public ArrayList<SPCheckEditSuma> parseXMLSPCheckEditSuma(Context context, String archivo){
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
                        handleStarTagSPCheckEditSuma(xpp.getName());
                    }else if(eventType == XmlPullParser.END_TAG){
                        currentTag = null;
                    }else if(eventType == XmlPullParser.TEXT){
                        handleTextSPCheckEditSuma(xpp.getText());
                    }
                    eventType = xpp.next();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        return spCheckEditSumas;
    }


    private void handleTextSPCheckEditSuma(String text) {
        String xmlText = text;
        if(currentSPCheckEditSuma != null && currentTag != null){
            switch (currentTag){
                case SPCHECKEDITSUMA_ID: currentSPCheckEditSuma.setID(xmlText);break;
                case SPCHECKEDITSUMA_ID_PREGUNTA: currentSPCheckEditSuma.setID_PREGUNTA(xmlText);break;
                case SPCHECKEDITSUMA_SUBPREGUNTA: currentSPCheckEditSuma.setSUBPREGUNTA(xmlText);break;
                case SPCHECKEDITSUMA_VARIABLE: currentSPCheckEditSuma.setVARIABLE(xmlText);break;
                case SPCHECKEDITSUMA_VARESP: currentSPCheckEditSuma.setVARESP(xmlText);break;
                case SPCHECKEDITSUMA_LONGITUD: currentSPCheckEditSuma.setLONGITUD(xmlText);break;
            }
        }
    }

    private void handleStarTagSPCheckEditSuma(String name) {
        if(name.equals("SP_CHECKEDITSUMA")){
            currentSPCheckEditSuma = new SPCheckEditSuma();
            spCheckEditSumas.add(currentSPCheckEditSuma);
        }else{
            currentTag = name;
        }
    }
}
