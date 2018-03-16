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
import pe.com.ricindigus.generadorinei.pojos.InfoTabla;
import pe.com.ricindigus.generadorinei.pojos.Usuario;

import static android.os.Environment.getExternalStorageDirectory;

/**
 * Created by otin016 on 23/08/2017.
 */

public class InfoTablasPullParser {
    public static final String INFOTABLAS_ID = "ID";
    public static final String INFOTABLAS_MODULO = "MODULO";
    public static final String INFOTABLAS_PARTE = "PARTE";
    public static final String INFOTABLAS_NOMBRE = "NOMBRE";
    public static final String INFOTABLAS_TIPO = "TIPO";

    private InfoTabla currentInfoTabla = null;
    private String currentTag = null;
    ArrayList<InfoTabla> infoTablas = new ArrayList<>();

    public ArrayList<InfoTabla> parseXML(Context context){
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();

            try {
                InputStream stream = context.getAssets().open("infotablas.xml");
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
        return infoTablas;
    }

    public ArrayList<InfoTabla> parseXML(Context context, String archivo){
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
        return infoTablas;
    }

    private void handleText(String text) {
        String xmlText = text;
        if(currentInfoTabla!= null && currentTag != null){
            switch (currentTag){
                case INFOTABLAS_ID:currentInfoTabla.setID(xmlText);break;
                case INFOTABLAS_MODULO:currentInfoTabla.setMODULO(xmlText);break;
                case INFOTABLAS_NOMBRE:currentInfoTabla.setNOMBRE(xmlText);break;
                case INFOTABLAS_PARTE:currentInfoTabla.setPARTE(xmlText);break;
                case INFOTABLAS_TIPO:currentInfoTabla.setTIPO(xmlText);break;
            }
        }
    }

    private void handleStarTag(String name) {
        if(name.equals("INFOTABLA")){
            currentInfoTabla = new InfoTabla();
            infoTablas.add(currentInfoTabla);
        }else{
            currentTag = name;
        }
    }
}
