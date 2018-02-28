package pe.com.ricindigus.generadorinei.parser;

import android.content.Context;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by dmorales on 12/01/2018.
 */

public class ControladorPullParser {
    String createControlador = "";
    String currentTag = null;


    public String parseXML(Context context){
        createControlador = "CREATE TABLE controlador("
                + "ID_EMPRESA" + " TEXT PRIMARY KEY";
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();
            try {
                InputStream stream = context.getAssets().open("controlador.xml");
                xpp.setInput(stream,null);

                int eventType = xpp.getEventType();

                while(eventType != XmlPullParser.END_DOCUMENT){
                    if(eventType == XmlPullParser.START_TAG){
                        handleStarTag(xpp);
                    }else if(eventType == XmlPullParser.END_TAG){
                        handleEndTag(xpp.getName());
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
        return createControlador;
    }

    private void handleStarTag(XmlPullParser xpp) {
        currentTag = xpp.getName();
    }
    private void handleText(String text) {
        String xmlText = text;
        if(currentTag != null){
            if(currentTag.equals("IDPREGUNTA"))
                createControlador = createControlador + "," + xmlText + " TEXT";
        }
    }

    private void handleEndTag(String text){
        String xmlText = text;
        if(xmlText.equals("IDPREGUNTAS")){
            createControlador = createControlador + ");";
        }else{
            currentTag = null;
        }
    }
}
