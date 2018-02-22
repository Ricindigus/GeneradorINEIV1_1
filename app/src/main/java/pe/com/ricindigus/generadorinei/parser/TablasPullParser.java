package pe.com.ricindigus.generadorinei.parser;

import android.content.Context;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.pojos.Tabla;

/**
 * Created by dmorales on 12/01/2018.
 */

public class TablasPullParser {
    ArrayList<Tabla> tablas = new ArrayList<Tabla>();
    private Tabla currentTabla = null;

    public ArrayList<Tabla> parseXML(Context context){
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
                    }
                    eventType = xpp.next();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        return tablas;
    }

    private void handleStarTag(XmlPullParser xpp) {
        if(xpp.getName().equals("modulo")){
            currentTabla = new Tabla(
                    xpp.getAttributeValue(0) + xpp.getAttributeValue(1),
                    xpp.getAttributeValue(0) ,
                    xpp.getAttributeValue(3),
                    xpp.getAttributeValue(2));
        }
    }

    private void handleEndTag(String text){
        String xmlText = text;
        if(xmlText.equals("modulo")){
            tablas.add(currentTabla);
        }
    }
}
