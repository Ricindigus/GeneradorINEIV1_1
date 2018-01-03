package pe.com.ricindigus.generadorinei.componentes.componente_checkbox;

import android.content.Context;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by RICARDO on 2/01/2018.
 */

public class SPCheckBoxPullParser {
    public static final String SPCHECKBOX_ID = "ID";
    public static final String SPCHECKBOX_ID_PREGUNTA = "ID_PREGUNTA";
    public static final String SPCHECKBOX_SUBPREGUNTA = "SUBPREGUNTA";
    public static final String SPCHECKBOX_VARIABLE = "VARIABLE";
    public static final String SPCHECKBOX_VARDESC = "VARDESC";

    private SPCheckBox currentSPCheckBox = null;
    private String currentTag = null;
    ArrayList<SPCheckBox> spCheckBoxes = new ArrayList<SPCheckBox>();

    public ArrayList<SPCheckBox> parseXML(Context context){
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();

            try {
                InputStream stream = context.getAssets().open("subpreguntas_checkbox.xml");
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
        return spCheckBoxes;
    }

    private void handleText(String text) {
        String xmlText = text;
        if(currentSPCheckBox!= null && currentTag != null){
            switch (currentTag){
                case SPCHECKBOX_ID:currentSPCheckBox.setID(xmlText);break;
                case SPCHECKBOX_ID_PREGUNTA:currentSPCheckBox.setID_PREGUNTA(xmlText);break;
                case SPCHECKBOX_SUBPREGUNTA:currentSPCheckBox.setSUBPREGUNTA(xmlText);break;
                case SPCHECKBOX_VARDESC:currentSPCheckBox.setVARDESC(xmlText);break;
                case SPCHECKBOX_VARIABLE:currentSPCheckBox.setVARIABLE(xmlText);break;
            }
        }
    }

    private void handleStarTag(String name) {
        if(name.equals("SP_CHECKBOX")){
            currentSPCheckBox = new SPCheckBox();
            spCheckBoxes.add(currentSPCheckBox);
        }else{
            currentTag = name;
        }
    }
}
