package pe.com.ricindigus.generadorinei.componentes.componente_checkbox;

import android.content.Context;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


/**
 * Created by dmorales on 28/12/2017.
 */

public class CheckBoxPullParser {

    public static final String CHECKBOX_ID = "ID";
    public static final String CHECKBOX_MODULO = "MODULO";
    public static final String CHECKBOX_NUMERO = "NUMERO";
    public static final String CHECKBOX_PREGUNTA = "PREGUNTA";

    private POJOCheckBox currentCheckBox = null;
    private String currentTag = null;
    ArrayList<POJOCheckBox> POJOCheckBoxes = new ArrayList<POJOCheckBox>();

    public ArrayList<POJOCheckBox> parseXML(Context context){
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();

            try {
                InputStream stream = context.getAssets().open("preguntas_checkbox.xml");
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
        return POJOCheckBoxes;
    }

    private void handleText(String text) {
        String xmlText = text;
        if(currentCheckBox!= null && currentTag != null){
            switch (currentTag){
                case CHECKBOX_ID:currentCheckBox.setID(xmlText);break;
                case CHECKBOX_MODULO:currentCheckBox.setMODULO(xmlText);break;
                case CHECKBOX_NUMERO:currentCheckBox.setNUMERO(xmlText);break;
                case CHECKBOX_PREGUNTA:currentCheckBox.setPREGUNTA(xmlText);break;
            }
        }
    }

    private void handleStarTag(String name) {
        if(name.equals("CHECKBOX")){
            currentCheckBox = new POJOCheckBox();
            POJOCheckBoxes.add(currentCheckBox);
        }else{
            currentTag = name;
        }
    }
}
