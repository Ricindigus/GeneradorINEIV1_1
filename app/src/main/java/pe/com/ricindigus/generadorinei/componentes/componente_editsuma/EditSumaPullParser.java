package pe.com.ricindigus.generadorinei.componentes.componente_editsuma;

import android.content.Context;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


import pe.com.ricindigus.generadorinei.componentes.componente_editsuma.pojos.PEditSuma;
import pe.com.ricindigus.generadorinei.componentes.componente_editsuma.pojos.SPEditSuma;

import static android.os.Environment.getExternalStorageDirectory;

/**
 * Created by dmorales on 30/04/2018.
 */

public class EditSumaPullParser {

    public static final String EDITSUMA_ID = "ID";
    public static final String EDITSUMA_MODULO = "MODULO";
    public static final String EDITSUMA_NUMERO = "NUMERO";
    public static final String EDITSUMA_PREGUNTA = "PREGUNTA";
    public static final String EDITSUMA_CABPREG = "CABPREG";
    public static final String EDITSUMA_CABRES = "CABRES";
    public static final String EDITSUMA_VALSUMA = "VALSUMA";

    public static final String SPEDITSUMA_ID = "ID";
    public static final String SPEDITSUMA_ID_PREGUNTA = "ID_PREGUNTA";
    public static final String SPEDITSUMA_SUBPREGUNTA = "SUBPREGUNTA";
    public static final String SPEDITSUMA_VARIABLE = "VARIABLE";
    public static final String SPEDITSUMA_LONGITUD = "LONGITUD";


    private String currentTag = null;
    private PEditSuma currentEditSuma = null;
    private SPEditSuma currentSPEditSuma = null;

    ArrayList<PEditSuma> pEditSumas = new ArrayList<PEditSuma>();
    ArrayList<SPEditSuma> spEditSumas = new ArrayList<SPEditSuma>();

    public ArrayList<PEditSuma> parseXMLPEditSuma(Context context){
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();

            try {
                InputStream stream = context.getAssets().open("preguntas_editsuma.xml");
                xpp.setInput(stream,null);

                int eventType = xpp.getEventType();

                while(eventType != XmlPullParser.END_DOCUMENT){
                    if(eventType == XmlPullParser.START_TAG){
                        handleStarTagPEditSuma(xpp.getName());
                    }else if(eventType == XmlPullParser.END_TAG){
                        currentTag = null;
                    }else if(eventType == XmlPullParser.TEXT){
                        handleTextPEditSuma(xpp.getText());
                    }
                    eventType = xpp.next();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        return pEditSumas;
    }

    public ArrayList<PEditSuma> parseXMLPEditSuma(Context context, String archivo){
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
                        handleStarTagPEditSuma(xpp.getName());
                    }else if(eventType == XmlPullParser.END_TAG){
                        currentTag = null;
                    }else if(eventType == XmlPullParser.TEXT){
                        handleTextPEditSuma(xpp.getText());
                    }
                    eventType = xpp.next();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        return pEditSumas;
    }

    private void handleTextPEditSuma(String text) {
        String xmlText = text;
        if(currentEditSuma!= null && currentTag != null){
            switch (currentTag){
                case EDITSUMA_ID:currentEditSuma.setID(xmlText);break;
                case EDITSUMA_MODULO:currentEditSuma.setMODULO(xmlText);break;
                case EDITSUMA_NUMERO:currentEditSuma.setNUMERO(xmlText);break;
                case EDITSUMA_PREGUNTA:currentEditSuma.setPREGUNTA(xmlText);break;
                case EDITSUMA_CABPREG:currentEditSuma.setCABPREG(xmlText);break;
                case EDITSUMA_CABRES:currentEditSuma.setCABRES(xmlText);break;
                case EDITSUMA_VALSUMA:currentEditSuma.setVALSUMA(xmlText);break;
            }
        }
    }

    private void handleStarTagPEditSuma(String name) {
        if(name.equals("EDITSUMA")){
            currentEditSuma = new PEditSuma();
            pEditSumas.add(currentEditSuma);
        }else{
            currentTag = name;
        }
    }

    public ArrayList<SPEditSuma> parseXMLSPEditSuma(Context context){
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();

            try {
                InputStream stream = context.getAssets().open("subpreguntas_editsuma.xml");
                xpp.setInput(stream,null);

                int eventType = xpp.getEventType();
                while(eventType != XmlPullParser.END_DOCUMENT){
                    if(eventType == XmlPullParser.START_TAG){
                        handleStarTagSPEditSuma(xpp.getName());
                    }else if(eventType == XmlPullParser.END_TAG){
                        currentTag = null;
                    }else if(eventType == XmlPullParser.TEXT){
                        handleTextSPEditSuma(xpp.getText());
                    }
                    eventType = xpp.next();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        return spEditSumas;
    }

    public ArrayList<SPEditSuma> parseXMLSPEditSuma(Context context, String archivo){
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
                        handleStarTagSPEditSuma(xpp.getName());
                    }else if(eventType == XmlPullParser.END_TAG){
                        currentTag = null;
                    }else if(eventType == XmlPullParser.TEXT){
                        handleTextSPEditSuma(xpp.getText());
                    }
                    eventType = xpp.next();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        return spEditSumas;
    }


    private void handleTextSPEditSuma(String text) {
        String xmlText = text;
        if(currentSPEditSuma!= null && currentTag != null){
            switch (currentTag){
                case SPEDITSUMA_ID: currentSPEditSuma.setID(xmlText);break;
                case SPEDITSUMA_ID_PREGUNTA: currentSPEditSuma.setID_PREGUNTA(xmlText);break;
                case SPEDITSUMA_SUBPREGUNTA: currentSPEditSuma.setSUBPREGUNTA(xmlText);break;
                case SPEDITSUMA_VARIABLE: currentSPEditSuma.setVARIABLE(xmlText);break;
                case SPEDITSUMA_LONGITUD: currentSPEditSuma.setLONGITUD(xmlText);break;
            }
        }
    }

    private void handleStarTagSPEditSuma(String name) {
        if(name.equals("SP_EDITSUMA")){
            currentSPEditSuma = new SPEditSuma();
            spEditSumas.add(currentSPEditSuma);
        }else{
            currentTag = name;
        }
    }
}
