package pe.com.ricindigus.generadorinei.componentes.componente_gps;

import android.content.Context;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;



/**
 * Created by dmorales on 30/01/2018.
 */

public class GPSPullParser {
    public static final String GPS_ID = "ID";
    public static final String GPS_NUMERO = "NUMERO";
    public static final String GPS_MODULO = "MODULO";
    public static final String GPS_LATITUD = "VARLAT";
    public static final String GPS_LONGITUD = "VARLONG";
    public static final String GPS_ALTITUD = "VARALT";
    private GPS currentGPS = null;
    private String currentTag = null;
    ArrayList<GPS> gpsArrayList = new ArrayList<GPS>();

    public ArrayList<GPS> parseXML(Context context){
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();

            try {
                InputStream stream = context.getAssets().open("gps.xml");
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
        return gpsArrayList;
    }

    private void handleText(String text) {
        String xmlText = text;
        if(currentGPS!= null && currentTag != null){
            switch (currentTag){
                case GPS_ID:currentGPS.setID(xmlText);break;
                case GPS_NUMERO:currentGPS.setNUMERO(xmlText);break;
                case GPS_MODULO:currentGPS.setMODULO(xmlText);break;
                case GPS_LATITUD:currentGPS.setVARLAT(xmlText);break;
                case GPS_LONGITUD:currentGPS.setVARLONG(xmlText);break;
                case GPS_ALTITUD:currentGPS.setVARALT(xmlText);break;
            }
        }
    }

    private void handleStarTag(String name) {
        if(name.equals("GPS")){
            currentGPS = new GPS();
            gpsArrayList.add(currentGPS);
        }else{
            currentTag = name;
        }
    }
}
