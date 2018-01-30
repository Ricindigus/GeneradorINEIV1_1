package pe.com.ricindigus.generadorinei.parser;

import android.content.Context;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.pojos.OpcionSpinner;

/**
 * Created by dmorales on 30/01/2018.
 */

public class OpcionSpinnerPullParser {
    public static final String OPCION_SPINNER_ID = "ID";
    public static final String OPCION_SPINNER_IDVARIABLE = "IDVARIABLE";
    public static final String OPCION_SPINNER_NOPCION = "NOPCION";
    public static final String OPCION_SPINNER_OPCION = "OPCION";
    
    private OpcionSpinner currentOpcionSpinner = null;
    private String currentTag = null;
    ArrayList<OpcionSpinner> opcionSpinners = new ArrayList<OpcionSpinner>();

    public ArrayList<OpcionSpinner> parseXML(Context context){
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();

            try {
                InputStream stream = context.getAssets().open("opciones.xml");
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
        return opcionSpinners;
    }

    private void handleText(String text) {
        String xmlText = text;
        if(currentOpcionSpinner!= null && currentTag != null){
            switch (currentTag){
                case OPCION_SPINNER_ID:currentOpcionSpinner.setID(xmlText);break;
                case OPCION_SPINNER_IDVARIABLE:currentOpcionSpinner.setID(xmlText);break;
                case OPCION_SPINNER_NOPCION:currentOpcionSpinner.setID(xmlText);break;
                case OPCION_SPINNER_OPCION:currentOpcionSpinner.setID(xmlText);break;
            }
        }
    }

    private void handleStarTag(String name) {
        if(name.equals("OPCION")){
            currentOpcionSpinner = new OpcionSpinner();
            opcionSpinners.add(currentOpcionSpinner);
        }else{
            currentTag = name;
        }
    }
}
