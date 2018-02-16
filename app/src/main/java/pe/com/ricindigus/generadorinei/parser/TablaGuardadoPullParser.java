package pe.com.ricindigus.generadorinei.parser;

import android.content.Context;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.pojos.Usuario;

/**
 * Created by dmorales on 12/01/2018.
 */

public class TablaGuardadoPullParser {
    ArrayList<String> createModulos = new ArrayList<String>();
    private String currentCreate = "";
    private String currentTag = null;

    public ArrayList<String> parseXML(Context context){
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();
            try {
                InputStream stream = context.getAssets().open("variables.xml");
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
        return createModulos;
    }

    private void handleStarTag(XmlPullParser xpp) {
        if(xpp.getName().equals("modulo")){
            currentCreate = "CREATE TABLE " + "modulo" + xpp.getAttributeValue(0) + xpp.getAttributeValue(1)+ "(";
            if (xpp.getAttributeValue(2).equals("1")){
                currentCreate = currentCreate + "ID_EMPRESA" + " TEXT PRIMARY KEY";
            }else{
                currentCreate = currentCreate + "_id" + " TEXT PRIMARY KEY,"
                        + "ID_EMPRESA" + " TEXT";
            }
        }else{
            currentTag = xpp.getName();
        }
    }
    private void handleText(String text) {
        String xmlText = text;
        if(currentTag != null){
            if(currentTag.equals("var"))
                currentCreate = currentCreate + "," + xmlText + " TEXT";
        }
    }

    private void handleEndTag(String text){
        String xmlText = text;
        if(xmlText.equals("modulo")){
            currentCreate = currentCreate + ");";
            createModulos.add(currentCreate);
        }else{
            currentTag = null;
        }
    }
}
