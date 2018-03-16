package pe.com.ricindigus.generadorinei.componentes.componente_radio;

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
import pe.com.ricindigus.generadorinei.componentes.componente_radio.pojos.PRadio;
import pe.com.ricindigus.generadorinei.componentes.componente_radio.pojos.SPRadio;

import static android.os.Environment.getExternalStorageDirectory;

/**
 * Created by dmorales on 28/12/2017.
 */

public class RadioPullParser {
    //columnas pregunta radio
    public static final String RADIO_ID = "ID";
    public static final String RADIO_MODULO = "MODULO";
    public static final String RADIO_NUMERO = "NUMERO";
    public static final String RADIO_PREGUNTA = "PREGUNTA";

    //columnas subpreguntas radio
    public static final String SPRADIO_ID = "ID";
    public static final String SPRADIO_ID_PREGUNTA = "ID_PREGUNTA";
    public static final String SPRADIO_SUBPREGUNTA = "SUBPREGUNTA";
    public static final String SPRADIO_VARIABLE = "VARIABLE";
    public static final String SPRADIO_VARDESC = "VARDESC";

    private String currentTag = null;

    private PRadio currentRadio = null;
    private SPRadio currentSPRadio = null;
    ArrayList<PRadio> PRadios = new ArrayList<PRadio>();
    ArrayList<SPRadio> spRadios = new ArrayList<SPRadio>();

    public ArrayList<PRadio> parseXMLPRadio(Context context){
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();

            try {
                InputStream stream = context.getAssets().open("preguntas_radio.xml");
                xpp.setInput(stream,null);

                int eventType = xpp.getEventType();

                while(eventType != XmlPullParser.END_DOCUMENT){
                    if(eventType == XmlPullParser.START_TAG){
                        handleStarTagPRadio(xpp.getName());
                    }else if(eventType == XmlPullParser.END_TAG){
                        currentTag = null;
                    }else if(eventType == XmlPullParser.TEXT){
                        handleTextPRadio(xpp.getText());
                    }
                    eventType = xpp.next();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        return PRadios;
    }

    public ArrayList<PRadio> parseXMLPRadio(Context context, String archivo){
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
                        handleStarTagPRadio(xpp.getName());
                    }else if(eventType == XmlPullParser.END_TAG){
                        currentTag = null;
                    }else if(eventType == XmlPullParser.TEXT){
                        handleTextPRadio(xpp.getText());
                    }
                    eventType = xpp.next();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        return PRadios;
    }

    private void handleTextPRadio(String text) {
        String xmlText = text;
        if(currentRadio!= null && currentTag != null){
            switch (currentTag){
                case RADIO_ID:currentRadio.setID(xmlText);break;
                case RADIO_MODULO:currentRadio.setMODULO(xmlText);break;
                case RADIO_NUMERO:currentRadio.setNUMERO(xmlText);break;
                case RADIO_PREGUNTA:currentRadio.setPREGUNTA(xmlText);break;
            }
        }
    }

    private void handleStarTagPRadio(String name) {
        if(name.equals("RADIO")){
            currentRadio = new PRadio();
            PRadios.add(currentRadio);
        }else{
            currentTag = name;
        }
    }

    public ArrayList<SPRadio> parseXMLSPRadio(Context context){
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();

            try {
                InputStream stream = context.getAssets().open("subpreguntas_radio.xml");
                xpp.setInput(stream,null);

                int eventType = xpp.getEventType();

                while(eventType != XmlPullParser.END_DOCUMENT){
                    if(eventType == XmlPullParser.START_TAG){
                        handleStarTagSPRadio(xpp.getName());
                    }else if(eventType == XmlPullParser.END_TAG){
                        currentTag = null;
                    }else if(eventType == XmlPullParser.TEXT){
                        handleTextSPRadio(xpp.getText());
                    }
                    eventType = xpp.next();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        return spRadios;
    }

    public ArrayList<SPRadio> parseXMLSPRadio(Context context, String archivo){
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
                        handleStarTagSPRadio(xpp.getName());
                    }else if(eventType == XmlPullParser.END_TAG){
                        currentTag = null;
                    }else if(eventType == XmlPullParser.TEXT){
                        handleTextSPRadio(xpp.getText());
                    }
                    eventType = xpp.next();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        return spRadios;
    }

    private void handleTextSPRadio(String text) {
        String xmlText = text;
        if(currentSPRadio!= null && currentTag != null){
            switch (currentTag){
                case SPRADIO_ID:currentSPRadio.setID(xmlText);break;
                case SPRADIO_ID_PREGUNTA:currentSPRadio.setID_PREGUNTA(xmlText);break;
                case SPRADIO_SUBPREGUNTA:currentSPRadio.setSUBPREGUNTA(xmlText);break;
                case SPRADIO_VARIABLE:currentSPRadio.setVARIABLE(xmlText);break;
                case SPRADIO_VARDESC:currentSPRadio.setVARDESC(xmlText);break;
            }
        }
    }

    private void handleStarTagSPRadio(String name) {
        if(name.equals("SP_RADIO")){
            currentSPRadio = new SPRadio();
            spRadios.add(currentSPRadio);
        }else{
            currentTag = name;
        }
    }
}
