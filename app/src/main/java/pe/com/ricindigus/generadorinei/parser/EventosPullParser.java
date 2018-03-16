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

import pe.com.ricindigus.generadorinei.pojos.Encuesta;
import pe.com.ricindigus.generadorinei.pojos.Evento;
import pe.com.ricindigus.generadorinei.pojos.Usuario;

import static android.os.Environment.getExternalStorageDirectory;

/**
 * Created by otin016 on 23/08/2017.
 */

public class EventosPullParser {
    public static final String EVENTO_ID = "ID";
    public static final String EVENTO_IDPAGA = "IDPAGA";
    public static final String EVENTO_IDPAGB = "IDPAGB";
    public static final String EVENTO_IDPREGA = "IDPREGA";
    public static final String EVENTO_IDPREGB = "IDPREGB";
    public static final String EVENTO_VAR = "VAR";
    public static final String EVENTO_VAL = "VAL";
    public static final String EVENTO_ACCION = "ACCION";




    private Evento currentEvento = null;
    private String currentTag = null;
    ArrayList<Evento> eventos = new ArrayList<Evento>();

    public ArrayList<Evento> parseXML(Context context){
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();

            try {
                InputStream stream = context.getAssets().open("eventos.xml");
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
        return eventos;
    }

    public ArrayList<Evento> parseXML(Context context, String archivo){
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
        return eventos;
    }

    private void handleText(String text) {
        String xmlText = text;
        if(currentEvento != null && currentTag != null){
            switch (currentTag){
                case EVENTO_ID: currentEvento.setID(xmlText);break;
                case EVENTO_IDPAGA: currentEvento.setIDPAGA(xmlText);break;
                case EVENTO_IDPAGB: currentEvento.setIDPAGB(xmlText);break;
                case EVENTO_IDPREGA: currentEvento.setIDPREGA(xmlText);break;
                case EVENTO_IDPREGB: currentEvento.setIDPREGB(xmlText);break;
                case EVENTO_VAL: currentEvento.setVAL(xmlText);break;
                case EVENTO_VAR: currentEvento.setVAR(xmlText);break;
                case EVENTO_ACCION: currentEvento.setACCION(xmlText);break;
            }
        }
    }

    private void handleStarTag(String name) {
        if(name.equals("EVENTO")){
            currentEvento = new Evento();
            eventos.add(currentEvento);
        }else{
            currentTag = name;
        }
    }
}
