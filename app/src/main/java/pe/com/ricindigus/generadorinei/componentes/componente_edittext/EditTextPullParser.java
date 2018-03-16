package pe.com.ricindigus.generadorinei.componentes.componente_edittext;

import android.content.Context;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.componentes.componente_edittext.pojos.PEditText;
import pe.com.ricindigus.generadorinei.componentes.componente_edittext.pojos.SPEditText;
import pe.com.ricindigus.generadorinei.componentes.componente_gps.pojos.GPS;

import static android.os.Environment.getExternalStorageDirectory;


/**
 * Created by dmorales on 28/12/2017.
 */

public class EditTextPullParser {
    //columnas pregunta edittext
    public static final String EDITTEXT_ID = "ID";
    public static final String EDITTEXT_MODULO = "MODULO";
    public static final String EDITTEXT_NUMERO = "NUMERO";
    public static final String EDITTEXT_PREGUNTA = "PREGUNTA";

    //preguntas columnas subpregunta edittext
    public static final String SPEDITTEXT_ID = "ID";
    public static final String SPEDITTEXT_ID_PREGUNTA = "ID_PREGUNTA";
    public static final String SPEDITTEXT_SUBPREGUNTA = "SUBPREGUNTA";
    public static final String SPEDITTEXT_VARIABLE = "VARIABLE";
    public static final String SPEDITTEXT_TIPO = "TIPO";
    public static final String SPEDITTEXT_LONGITUD = "LONGITUD";

    private String currentTag = null;
    private PEditText currentEditText = null;
    private SPEditText currentSPEditText = null;

    ArrayList<PEditText> pEditTexts = new ArrayList<PEditText>();
    ArrayList<SPEditText> spEditTexts = new ArrayList<SPEditText>();

    public ArrayList<PEditText> parseXMLPEditText(Context context){
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();

            try {
                InputStream stream = context.getAssets().open("preguntas_edittext.xml");
                xpp.setInput(stream,null);

                int eventType = xpp.getEventType();

                while(eventType != XmlPullParser.END_DOCUMENT){
                    if(eventType == XmlPullParser.START_TAG){
                        handleStarTagPEditText(xpp.getName());
                    }else if(eventType == XmlPullParser.END_TAG){
                        currentTag = null;
                    }else if(eventType == XmlPullParser.TEXT){
                        handleTextPEditText(xpp.getText());
                    }
                    eventType = xpp.next();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        return pEditTexts;
    }

    public ArrayList<PEditText> parseXMLPEditText(Context context, String archivo){
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
                        handleStarTagPEditText(xpp.getName());
                    }else if(eventType == XmlPullParser.END_TAG){
                        currentTag = null;
                    }else if(eventType == XmlPullParser.TEXT){
                        handleTextPEditText(xpp.getText());
                    }
                    eventType = xpp.next();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        return pEditTexts;
    }

    private void handleTextPEditText(String text) {
        String xmlText = text;
        if(currentEditText!= null && currentTag != null){
            switch (currentTag){
                case EDITTEXT_ID:currentEditText.setID(xmlText);break;
                case EDITTEXT_MODULO:currentEditText.setMODULO(xmlText);break;
                case EDITTEXT_NUMERO:currentEditText.setNUMERO(xmlText);break;
                case EDITTEXT_PREGUNTA:currentEditText.setPREGUNTA(xmlText);break;
            }
        }
    }

    private void handleStarTagPEditText(String name) {
        if(name.equals("EDITTEXT")){
            currentEditText = new PEditText();
            pEditTexts.add(currentEditText);
        }else{
            currentTag = name;
        }
    }

    public ArrayList<SPEditText> parseXMLSPEditText(Context context){
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();

            try {
                InputStream stream = context.getAssets().open("subpreguntas_edittext.xml");
                xpp.setInput(stream,null);

                int eventType = xpp.getEventType();

                while(eventType != XmlPullParser.END_DOCUMENT){
                    if(eventType == XmlPullParser.START_TAG){
                        handleStarTagSPEditText(xpp.getName());
                    }else if(eventType == XmlPullParser.END_TAG){
                        currentTag = null;
                    }else if(eventType == XmlPullParser.TEXT){
                        handleTextSPEditText(xpp.getText());
                    }
                    eventType = xpp.next();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        return spEditTexts;
    }

    public ArrayList<SPEditText> parseXMLSPEditText(Context context, String archivo){
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
                        handleStarTagSPEditText(xpp.getName());
                    }else if(eventType == XmlPullParser.END_TAG){
                        currentTag = null;
                    }else if(eventType == XmlPullParser.TEXT){
                        handleTextSPEditText(xpp.getText());
                    }
                    eventType = xpp.next();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        return spEditTexts;
    }


    private void handleTextSPEditText(String text) {
        String xmlText = text;
        if(currentSPEditText!= null && currentTag != null){
            switch (currentTag){
                case SPEDITTEXT_ID: currentSPEditText.setID(xmlText);break;
                case SPEDITTEXT_ID_PREGUNTA: currentSPEditText.setID_PREGUNTA(xmlText);break;
                case SPEDITTEXT_SUBPREGUNTA: currentSPEditText.setSUBPREGUNTA(xmlText);break;
                case SPEDITTEXT_VARIABLE: currentSPEditText.setVARIABLE(xmlText);break;
                case SPEDITTEXT_TIPO: currentSPEditText.setTIPO(xmlText);break;
                case SPEDITTEXT_LONGITUD: currentSPEditText.setLONGITUD(xmlText);break;
            }
        }
    }

    private void handleStarTagSPEditText(String name) {
        if(name.equals("SP_EDITTEXT")){
            currentSPEditText = new SPEditText();
            spEditTexts.add(currentSPEditText);
        }else{
            currentTag = name;
        }
    }
}
