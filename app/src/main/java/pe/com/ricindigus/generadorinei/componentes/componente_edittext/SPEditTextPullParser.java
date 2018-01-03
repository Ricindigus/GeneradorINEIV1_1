package pe.com.ricindigus.generadorinei.componentes.componente_edittext;

import android.content.Context;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by RICARDO on 1/01/2018.
 */

public class SPEditTextPullParser {
    public static final String SPEDITTEXT_ID = "ID";
    public static final String SPEDITTEXT_ID_PREGUNTA = "ID_PREGUNTA";
    public static final String SPEDITTEXT_SUBPREGUNTA = "SUBPREGUNTA";
    public static final String SPEDITTEXT_VARIABLE = "VARIABLE";
    public static final String SPEDITTEXT_TIPO = "TIPO";
    public static final String SPEDITTEXT_LONGITUD = "LONGITUD";


    private SPEditText currentSPEditText = null;
    private String currentTag = null;
    ArrayList<SPEditText> spEditTexts = new ArrayList<SPEditText>();

    public ArrayList<SPEditText> parseXML(Context context){
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();

            try {
                InputStream stream = context.getAssets().open("subpreguntas_edittext.xml");
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
        return spEditTexts;
    }

    private void handleText(String text) {
        String xmlText = text;
        if(currentSPEditText!= null && currentTag != null){
            switch (currentTag){
                case SPEDITTEXT_ID: currentSPEditText.setID(xmlText);break;
                case SPEDITTEXT_ID_PREGUNTA: currentSPEditText.setID_PREGUNTA(xmlText);break;
                case SPEDITTEXT_SUBPREGUNTA: currentSPEditText.setSUBPREGUNTA(xmlText);break;
                case SPEDITTEXT_VARIABLE: currentSPEditText.setVARIABLE(xmlText);break;
                case SPEDITTEXT_TIPO: currentSPEditText.setTIPO(xmlText);break;
                case SPEDITTEXT_LONGITUD: currentSPEditText.setLONGITUD(xmlText);break;
            }
        }
    }

    private void handleStarTag(String name) {
        if(name.equals("SP_EDITTEXT")){
            currentSPEditText = new SPEditText();
            spEditTexts.add(currentSPEditText);
        }else{
            currentTag = name;
        }
    }
}
