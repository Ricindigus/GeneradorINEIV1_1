package pe.com.ricindigus.generadorinei.componentes.componente_checkbox;

import android.content.Context;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.componentes.componente_checkbox.pojos.PCheckBox;
import pe.com.ricindigus.generadorinei.componentes.componente_checkbox.pojos.SPCheckBox;


/**
 * Created by dmorales on 28/12/2017.
 */

public class CheckBoxPullParser {

    //columnas preguntas checkbox
    public static final String CHECKBOX_ID = "ID";
    public static final String CHECKBOX_MODULO = "MODULO";
    public static final String CHECKBOX_NUMERO = "NUMERO";
    public static final String CHECKBOX_PREGUNTA = "PREGUNTA";

    //columnas subpreguntas checkbox
    public static final String SPCHECKBOX_ID = "ID";
    public static final String SPCHECKBOX_ID_PREGUNTA = "ID_PREGUNTA";
    public static final String SPCHECKBOX_SUBPREGUNTA = "SUBPREGUNTA";
    public static final String SPCHECKBOX_VARIABLE = "VARIABLE";
    public static final String SPCHECKBOX_VARDESC = "VARDESC";
    public static final String SPCHECKBOX_DESHAB = "DESHAB";

    private String currentTag = null;

    private PCheckBox currentCheckBox = null;
    ArrayList<PCheckBox> PCheckBoxes = new ArrayList<PCheckBox>();
    private SPCheckBox currentSPCheckBox = null;
    ArrayList<SPCheckBox> spCheckBoxes = new ArrayList<SPCheckBox>();

    public ArrayList<PCheckBox> parseXMLPCheckBox(Context context){
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
                        handleStarTagCheckBox(xpp.getName());
                    }else if(eventType == XmlPullParser.END_TAG){
                        currentTag = null;
                    }else if(eventType == XmlPullParser.TEXT){
                        handleTextCheckBox(xpp.getText());
                    }
                    eventType = xpp.next();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        return PCheckBoxes;
    }

    private void handleTextCheckBox(String text) {
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

    private void handleStarTagCheckBox(String name) {
        if(name.equals("CHECKBOX")){
            currentCheckBox = new PCheckBox();
            PCheckBoxes.add(currentCheckBox);
        }else{
            currentTag = name;
        }
    }

    public ArrayList<SPCheckBox> parseXMLSPCheckBox(Context context){
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
                        handleStarTagSPCheckBox(xpp.getName());
                    }else if(eventType == XmlPullParser.END_TAG){
                        currentTag = null;
                    }else if(eventType == XmlPullParser.TEXT){
                        handleTextSPCheckBox(xpp.getText());
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

    private void handleTextSPCheckBox(String text) {
        String xmlText = text;
        if(currentSPCheckBox!= null && currentTag != null){
            switch (currentTag){
                case SPCHECKBOX_ID:currentSPCheckBox.setID(xmlText);break;
                case SPCHECKBOX_ID_PREGUNTA:currentSPCheckBox.setID_PREGUNTA(xmlText);break;
                case SPCHECKBOX_SUBPREGUNTA:currentSPCheckBox.setSUBPREGUNTA(xmlText);break;
                case SPCHECKBOX_VARDESC:currentSPCheckBox.setVARDESC(xmlText);break;
                case SPCHECKBOX_VARIABLE:currentSPCheckBox.setVARIABLE(xmlText);break;
                case SPCHECKBOX_DESHAB:currentSPCheckBox.setDESHAB(xmlText);break;
            }
        }
    }

    private void handleStarTagSPCheckBox(String name) {
        if(name.equals("SP_CHECKBOX")){
            currentSPCheckBox = new SPCheckBox();
            spCheckBoxes.add(currentSPCheckBox);
        }else{
            currentTag = name;
        }
    }




}
