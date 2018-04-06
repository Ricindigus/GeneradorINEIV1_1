package pe.com.ricindigus.generadorinei.parser;

import android.content.Context;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.pojos.Pagina;
import pe.com.ricindigus.generadorinei.pojos.Pregunta;

import static android.os.Environment.getExternalStorageDirectory;

/**
 * Created by dmorales on 28/12/2017.
 */

public class PreguntaPullParser {
    public static final String PREGUNTA_ID = "_id";
    public static final String PREGUNTA_MODULO = "MODULO";
    public static final String PREGUNTA_PAGINA = "PAGINA";
    public static final String PREGUNTA_NUMERO = "NUMERO";
    public static final String PREGUNTA_TIPO = "TIPO";



    private Pregunta currentPregunta = null;
    private String currentTag = null;
    ArrayList<Pregunta> preguntas = new ArrayList<>();

    public ArrayList<Pregunta> parseXML(Context context){
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();

            try {
                InputStream stream = context.getAssets().open("preguntas.xml");
                xpp.setInput(stream,null);

                int eventType = xpp.getEventType();

                while(eventType != XmlPullParser.END_DOCUMENT){
                    if(eventType == XmlPullParser.START_TAG){
                        handleStarTag(xpp.getName());
                    }else if(eventType == XmlPullParser.END_TAG){
                        currentTag = null;
                    }else if(eventType == XmlPullParser.TEXT){
                        handleText(xpp.getText());
                    }
                    eventType = xpp.next();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        return preguntas;
    }

    public ArrayList<Pregunta> parseXML(Context context, String archivo){
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
                        handleStarTag(xpp.getName());
                    }else if(eventType == XmlPullParser.END_TAG){
                        currentTag = null;
                    }else if(eventType == XmlPullParser.TEXT){
                        handleText(xpp.getText());
                    }
                    eventType = xpp.next();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        return preguntas;
    }

    private void handleText(String text) {
        String xmlText = text;
        if(currentPregunta != null && currentTag != null){
            switch (currentTag){
                case PREGUNTA_ID:currentPregunta.set_id(xmlText);break;
                case PREGUNTA_MODULO:currentPregunta.setMODULO(xmlText);break;
                case PREGUNTA_NUMERO:currentPregunta.setNUMERO(xmlText);break;
                case PREGUNTA_PAGINA:currentPregunta.setPAGINA(xmlText);break;
                case PREGUNTA_TIPO:currentPregunta.setTIPO(xmlText);break;
            }
        }
    }

    private void handleStarTag(String name) {
        if(name.equals("PREGUNTA")){
            currentPregunta = new Pregunta();
            preguntas.add(currentPregunta);
        }else{
            currentTag = name;
        }
    }
}
