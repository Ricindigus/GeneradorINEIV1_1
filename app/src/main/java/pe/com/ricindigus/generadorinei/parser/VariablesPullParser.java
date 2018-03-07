package pe.com.ricindigus.generadorinei.parser;

import android.content.Context;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.pojos.Usuario;
import pe.com.ricindigus.generadorinei.pojos.Variable;

/**
 * Created by otin016 on 23/08/2017.
 */

public class VariablesPullParser {
    public static final String VARIABLE_ID = "ID";
    public static final String VARIABLE_TABLA = "TABLA";
    public static final String VARIABLE_MODULO = "MODULO";
    public static final String VARIABLE_PAGINA = "PAGINA";
    public static final String VARIABLE_PREGUNTA = "PREGUNTA";

    private Variable currentVariable = null;
    private String currentTag = null;
    ArrayList<Variable> variables = new ArrayList<Variable>();

    public ArrayList<Variable> parseXML(Context context){
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
        return variables;
    }

    private void handleText(String text) {
        String xmlText = text;
        if(currentVariable!= null && currentTag != null){
            switch (currentTag){
                case VARIABLE_ID:currentVariable.setID(xmlText);break;
                case VARIABLE_MODULO:currentVariable.setMODULO(xmlText);break;
                case VARIABLE_PAGINA:currentVariable.setPAGINA(xmlText);break;
                case VARIABLE_PREGUNTA:currentVariable.setPREGUNTA(xmlText);break;
                case VARIABLE_TABLA:currentVariable.setTABLA(xmlText);break;
            }
        }
    }

    private void handleStarTag(String name) {
        if(name.equals("VARIABLE")){
            currentVariable = new Variable();
            variables.add(currentVariable);
        }else{
            currentTag = name;
        }
    }
}
