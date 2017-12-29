package pe.com.ricindigus.generadorinei.componentes.componente_edittext;

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

public class EditTextPullParser {
    public static final String EDITTEXT_ID = "ID";
    public static final String EDITTEXT_MODULO = "MODULO";
    public static final String EDITTEXT_NUMERO = "NUMERO";
    public static final String EDITTEXT_PAGINA = "PAGINA";
    public static final String EDITTEXT_PREGUNTA = "PREGUNTA";
    public static final String EDITTEXT_SP1 = "SP1";
    public static final String EDITTEXT_VAR1 = "VAR1";
    public static final String EDITTEXT_SP2 = "SP2";
    public static final String EDITTEXT_VAR2 = "VAR2";
    public static final String EDITTEXT_SP3 = "SP3";
    public static final String EDITTEXT_VAR3 = "VAR3";

    private CEditText currentEditText = null;
    private String currentTag = null;
    ArrayList<CEditText> cEditTexts = new ArrayList<CEditText>();

    public ArrayList<CEditText> parseXML(Context context){
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();

            try {
                InputStream stream = context.getAssets().open("componente_edittext.xml");
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
        return cEditTexts;
    }

    private void handleText(String text) {
        String xmlText = text;
        if(currentEditText!= null && currentTag != null){
            switch (currentTag){
                case EDITTEXT_ID:currentEditText.setID(xmlText);break;
                case EDITTEXT_MODULO:currentEditText.setMODULO(xmlText);break;
                case EDITTEXT_NUMERO:currentEditText.setNUMERO(xmlText);break;
                case EDITTEXT_PAGINA:currentEditText.setPAGINA(xmlText);break;
                case EDITTEXT_PREGUNTA:currentEditText.setPREGUNTA(xmlText);break;
                case EDITTEXT_SP1:currentEditText.setSP1(xmlText);break;
                case EDITTEXT_VAR1:currentEditText.setVAR1(xmlText);break;
                case EDITTEXT_SP2:currentEditText.setSP2(xmlText);break;
                case EDITTEXT_VAR2:currentEditText.setVAR2(xmlText);break;
                case EDITTEXT_SP3:currentEditText.setSP3(xmlText);break;
                case EDITTEXT_VAR3:currentEditText.setVAR3(xmlText);break;
            }
        }
    }

    private void handleStarTag(String name) {
        if(name.equals("EDITTEXT")){
            currentEditText = new CEditText();
            cEditTexts.add(currentEditText);
        }else{
            currentTag = name;
        }
    }
}
