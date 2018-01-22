package pe.com.ricindigus.generadorinei.componentes.componente_radio;

import android.content.Context;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.componentes.componente_radio.pojos.SPRadio;

/**
 * Created by RICARDO on 2/01/2018.
 */

public class SPRadioPullParser {
    public static final String SPRADIO_ID = "ID";
    public static final String SPRADIO_ID_PREGUNTA = "ID_PREGUNTA";
    public static final String SPRADIO_SUBPREGUNTA = "SUBPREGUNTA";
    public static final String SPRADIO_VARIABLE = "VARIABLE";
    public static final String SPRADIO_VARDESC = "VARDESC";

    private SPRadio currentSPRadio = null;
    private String currentTag = null;
    ArrayList<SPRadio> spRadios = new ArrayList<SPRadio>();

    public ArrayList<SPRadio> parseXML(Context context){
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();

            try {
                InputStream stream = context.getAssets().open("subpreguntas_radio.xml");
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
        return spRadios;
    }

    private void handleText(String text) {
        String xmlText = text;
        if(currentSPRadio!= null && currentTag != null){
            switch (currentTag){
                case SPRADIO_ID:currentSPRadio.setID(xmlText);break;
                case SPRADIO_ID_PREGUNTA:currentSPRadio.setID_PREGUNTA(xmlText);break;
                case SPRADIO_SUBPREGUNTA:currentSPRadio.setSUBPREGUNTA(xmlText);break;
                case SPRADIO_VARIABLE:currentSPRadio.setVARIABLE(xmlText);break;
                case SPRADIO_VARDESC:currentSPRadio.setVARDESC(xmlText);break;
            }
        }
    }

    private void handleStarTag(String name) {
        if(name.equals("SP_RADIO")){
            currentSPRadio = new SPRadio();
            spRadios.add(currentSPRadio);
        }else{
            currentTag = name;
        }
    }
}
