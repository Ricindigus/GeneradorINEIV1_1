package pe.com.ricindigus.generadorinei.componentes.componente_ciiu;

import android.content.Context;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.componentes.componente_ciiu.pojos.PCiiu;
import pe.com.ricindigus.generadorinei.componentes.componente_ciiu.pojos.SPCiiu;

import static android.os.Environment.getExternalStorageDirectory;

/**
 * Created by dmorales on 19/04/2018.
 */

public class CIIUPullParser {
    //columnas pregunta edittext
    public static final String CIIU_ID = "ID";
    public static final String CIIU_MODULO = "MODULO";
    public static final String CIIU_NUMERO = "NUMERO";
    public static final String CIIU_PREGUNTA = "PREGUNTA";

    //preguntas columnas subpregunta edittext
    public static final String SPCIIU_ID = "ID";
    public static final String SPCIIU_ID_PREGUNTA = "ID_PREGUNTA";
    public static final String SPCIIU_VARACT = "VARACT";
    public static final String SPCIIU_VARAUTO = "VARAUTO";
    public static final String SPCIIU_VARCK = "VARCK";

    private String currentTag = null;
    private PCiiu currentCiiu = null;
    private SPCiiu currentSPCiiu = null;

    ArrayList<PCiiu> pCiius = new ArrayList<PCiiu>();
    ArrayList<SPCiiu> spCiius = new ArrayList<SPCiiu>();

    public ArrayList<PCiiu> parseXMLPCiiu(Context context){
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();

            try {
                InputStream stream = context.getAssets().open("preguntas_ciiu.xml");
                xpp.setInput(stream,null);

                int eventType = xpp.getEventType();

                while(eventType != XmlPullParser.END_DOCUMENT){
                    if(eventType == XmlPullParser.START_TAG){
                        handleStarTagPCiiu(xpp.getName());
                    }else if(eventType == XmlPullParser.END_TAG){
                        currentTag = null;
                    }else if(eventType == XmlPullParser.TEXT){
                        handleTextPCiiu(xpp.getText());
                    }
                    eventType = xpp.next();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        return pCiius;
    }

    public ArrayList<PCiiu> parseXMLPCiiu(Context context, String archivo){
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
                        handleStarTagPCiiu(xpp.getName());
                    }else if(eventType == XmlPullParser.END_TAG){
                        currentTag = null;
                    }else if(eventType == XmlPullParser.TEXT){
                        handleTextPCiiu(xpp.getText());
                    }
                    eventType = xpp.next();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        return pCiius;
    }

    private void handleTextPCiiu(String text) {
        String xmlText = text;
        if(currentCiiu!= null && currentTag != null){
            switch (currentTag){
                case CIIU_ID:currentCiiu.setID(xmlText);break;
                case CIIU_MODULO:currentCiiu.setMODULO(xmlText);break;
                case CIIU_NUMERO:currentCiiu.setNUMERO(xmlText);break;
                case CIIU_PREGUNTA:currentCiiu.setPREGUNTA(xmlText);break;
            }
        }
    }

    private void handleStarTagPCiiu(String name) {
        if(name.equals("CIIU")){
            currentCiiu = new PCiiu();
            pCiius.add(currentCiiu);
        }else{
            currentTag = name;
        }
    }

    public ArrayList<SPCiiu> parseXMLSPCiiu(Context context){
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();

            try {
                InputStream stream = context.getAssets().open("subpreguntas_ciiu.xml");
                xpp.setInput(stream,null);

                int eventType = xpp.getEventType();

                while(eventType != XmlPullParser.END_DOCUMENT){
                    if(eventType == XmlPullParser.START_TAG){
                        handleStarTagSPCiiu(xpp.getName());
                    }else if(eventType == XmlPullParser.END_TAG){
                        currentTag = null;
                    }else if(eventType == XmlPullParser.TEXT){
                        handleTextSPCiiu(xpp.getText());
                    }
                    eventType = xpp.next();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        return spCiius;
    }

    public ArrayList<SPCiiu> parseXMLSPCiiu(Context context, String archivo){
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
                        handleStarTagSPCiiu(xpp.getName());
                    }else if(eventType == XmlPullParser.END_TAG){
                        currentTag = null;
                    }else if(eventType == XmlPullParser.TEXT){
                        handleTextSPCiiu(xpp.getText());
                    }
                    eventType = xpp.next();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        return spCiius;
    }


    private void handleTextSPCiiu(String text) {
        String xmlText = text;
        if(currentSPCiiu!= null && currentTag != null){
            switch (currentTag){
                case SPCIIU_ID: currentSPCiiu.setID(xmlText);break;
                case SPCIIU_ID_PREGUNTA: currentSPCiiu.setID_PREGUNTA(xmlText);break;
                case SPCIIU_VARACT: currentSPCiiu.setVARACT(xmlText);break;
                case SPCIIU_VARAUTO: currentSPCiiu.setVARAUTO(xmlText);break;
                case SPCIIU_VARCK: currentSPCiiu.setVARCK(xmlText);break;
            }
        }
    }

    private void handleStarTagSPCiiu(String name) {
        if(name.equals("SP_CIIU")){
            currentSPCiiu = new SPCiiu();
            spCiius.add(currentSPCiiu);
        }else{
            currentTag = name;
        }
    }
}
