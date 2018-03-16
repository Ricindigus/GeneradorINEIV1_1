package pe.com.ricindigus.generadorinei.parser;

import android.content.Context;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.activities.ImportarActivity;
import pe.com.ricindigus.generadorinei.pojos.Encuesta;
import pe.com.ricindigus.generadorinei.pojos.Usuario;

import static android.os.Environment.getExternalStorageDirectory;

/**
 * Created by dmorales on 20/12/2017.
 */

public class EncuestaPullParser {
    public static final String ENCUESTA_ID = "ID";
    public static final String ENCUESTA_TITULO = "TITULO";

    private Encuesta currentEncuesta = null;
    private String currentTag = null;
    ArrayList<Encuesta> encuestas = new ArrayList<Encuesta>();

    public ArrayList<Encuesta> parseXML(Context context){
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();

            try {
                InputStream stream = context.getAssets().open("encuesta.xml");
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
        return encuestas;
    }

    public ArrayList<Encuesta> parseXML(Context context, String archivo){
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
        return encuestas;
    }

    private void handleText(String text) {
        String xmlText = text;
        if(currentEncuesta != null && currentTag != null){
            switch (currentTag){
                case ENCUESTA_ID:currentEncuesta.setID(xmlText);break;
                case ENCUESTA_TITULO:currentEncuesta.setTITULO(xmlText);break;
            }
        }
    }

    private void handleStarTag(String name) {
        if(name.equals("ENCUESTA")){
            currentEncuesta = new Encuesta();
            encuestas.add(currentEncuesta);
        }else{
            currentTag = name;
        }
    }
}
