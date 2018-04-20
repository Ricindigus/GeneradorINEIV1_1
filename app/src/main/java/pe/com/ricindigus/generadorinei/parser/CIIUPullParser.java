package pe.com.ricindigus.generadorinei.parser;

import android.content.Context;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.pojos.CIIU;
import pe.com.ricindigus.generadorinei.pojos.Ubigeo;

/**
 * Created by otin016 on 28/08/2017.
 */

public class CIIUPullParser {
    public static final String CIIU_ID = "ID";
    public static final String CIIU_DESCRIPCION = "DESCRIPCION";

    private CIIU currentCiiu = null;
    private String currentTag = null;
    ArrayList<CIIU> ubigeos = new ArrayList<CIIU>();

    public ArrayList<CIIU> parseXML(Context context){
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();

            try {
                InputStream stream = context.getAssets().open("general/ciius.xml");
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
        return ubigeos;
    }

    private void handleText(String text) {
        String xmlText = text;
        if(currentCiiu != null && currentTag != null){
            switch (currentTag){
                case CIIU_ID: currentCiiu.setID(xmlText);break;
                case CIIU_DESCRIPCION: currentCiiu.setDESCRIPCION(xmlText);break;
            }
        }
    }

    private void handleStarTag(String name) {
        if(name.equals("CIIU")){
            currentCiiu = new CIIU();
            ubigeos.add(currentCiiu);
        }else{
            currentTag = name;
        }
    }
}
