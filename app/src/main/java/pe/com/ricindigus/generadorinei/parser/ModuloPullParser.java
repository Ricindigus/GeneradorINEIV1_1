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

import pe.com.ricindigus.generadorinei.pojos.Modulo;

import static android.os.Environment.getExternalStorageDirectory;

/**
 * Created by dmorales on 28/12/2017.
 */

public class ModuloPullParser {
    public static final String MODULO_ID = "ID";
    public static final String MODULO_TITULO = "TITULO";
    public static final String MODULO_CABECERA = "CABECERA";
    public static final String MODULO_TABLA_XML = "TABLA_XML";
    public static final String MODULO_NPAGINAS = "NPAGINAS";

    private Modulo currentModulo = null;
    private String currentTag = null;
    ArrayList<Modulo> modulos = new ArrayList<Modulo>();

    public ArrayList<Modulo> parseXML(Context context){
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();

            try {
                InputStream stream = context.getAssets().open("modulos.xml");
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
        return modulos;
    }

    public ArrayList<Modulo> parseXML(Context context, String archivo){
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
        return modulos;
    }

    private void handleText(String text) {
        String xmlText = text;
        if(currentModulo!= null && currentTag != null){
            switch (currentTag){
                case MODULO_ID:currentModulo.setID(xmlText);break;
                case MODULO_TITULO:currentModulo.setTITULO(xmlText);break;
                case MODULO_CABECERA:currentModulo.setCABECERA(xmlText);break;
                case MODULO_TABLA_XML:currentModulo.setTABLA_XML(xmlText);break;
                case MODULO_NPAGINAS:currentModulo.setNPAGINAS(xmlText);break;
            }
        }
    }

    private void handleStarTag(String name) {
        if(name.equals("MODULO")){
            currentModulo = new Modulo();
            modulos.add(currentModulo);
        }else{
            currentTag = name;
        }
    }
}
