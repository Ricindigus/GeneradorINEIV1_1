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
    public static final String CHECKBOX_PAGINA = "PAGINA";
    public static final String CHECKBOX_PREGUNTA = "PREGUNTA";
    public static final String CHECKBOX_SP1 = "SP1";
    public static final String CHECKBOX_VAR1 = "VAR1";
    public static final String CHECKBOX_SP2 = "SP2";
    public static final String CHECKBOX_VAR2 = "VAR2";
    public static final String CHECKBOX_SP3 = "SP3";
    public static final String CHECKBOX_VAR3 = "VAR3";
    public static final String CHECKBOX_SP4 = "SP4";
    public static final String CHECKBOX_VAR4 = "VAR4";
    public static final String CHECKBOX_SP5 = "SP5";
    public static final String CHECKBOX_VAR5 = "VAR5";
    public static final String CHECKBOX_SP6 = "SP6";
    public static final String CHECKBOX_VAR6 = "VAR6";
    public static final String CHECKBOX_SP7 = "SP7";
    public static final String CHECKBOX_VAR7 = "VAR7";
    public static final String CHECKBOX_SP8 = "SP8";
    public static final String CHECKBOX_VAR8 = "VAR8";
    public static final String CHECKBOX_SP9 = "SP9";
    public static final String CHECKBOX_VAR9 = "VAR9";
    public static final String CHECKBOX_SP10 = "SP10";
    public static final String CHECKBOX_VAR10 = "VAR10";
    public static final String CHECKBOX_SP11 = "SP11";
    public static final String CHECKBOX_VAR11 = "VAR11";
    public static final String CHECKBOX_SP12 = "SP12";
    public static final String CHECKBOX_VAR12 = "VAR12";
    public static final String CHECKBOX_SP13 = "SP13";
    public static final String CHECKBOX_VAR13 = "VAR13";
    public static final String CHECKBOX_SP14 = "SP14";
    public static final String CHECKBOX_VAR14 = "VAR14";
    public static final String CHECKBOX_SP15 = "SP15";
    public static final String CHECKBOX_VAR15 = "VAR15";
    public static final String CHECKBOX_SP16 = "SP16";
    public static final String CHECKBOX_VAR16 = "VAR16";
    public static final String CHECKBOX_SP17 = "SP17";
    public static final String CHECKBOX_VAR17 = "VAR17";
    public static final String CHECKBOX_SP18 = "SP18";
    public static final String CHECKBOX_VAR18 = "VAR18";
    public static final String CHECKBOX_SP19 = "SP19";
    public static final String CHECKBOX_VAR19 = "VAR19";
    public static final String CHECKBOX_VARESP = "VARESP";

    private CCheckBox currentCheckBox = null;
    private String currentTag = null;
    ArrayList<CCheckBox> cCheckBoxes = new ArrayList<CCheckBox>();

    public ArrayList<CCheckBox> parseXML(Context context){
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();

            try {
                InputStream stream = context.getAssets().open("componente_checkbox.xml");
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
        return cCheckBoxes;
    }

    private void handleText(String text) {
        String xmlText = text;
        if(currentCheckBox!= null && currentTag != null){
            switch (currentTag){
                case CHECKBOX_ID:currentCheckBox.setID(xmlText);break;
                case CHECKBOX_MODULO:currentCheckBox.setMODULO(xmlText);break;
                case CHECKBOX_NUMERO:currentCheckBox.setNUMERO(xmlText);break;
                case CHECKBOX_PAGINA:currentCheckBox.setPAGINA(xmlText);break;
                case CHECKBOX_PREGUNTA:currentCheckBox.setPREGUNTA(xmlText);break;
                case CHECKBOX_SP1:currentCheckBox.setSP1(xmlText);break;
                case CHECKBOX_VAR1:currentCheckBox.setVAR1(xmlText);break;
                case CHECKBOX_SP2:currentCheckBox.setSP2(xmlText);break;
                case CHECKBOX_VAR2:currentCheckBox.setVAR2(xmlText);break;
                case CHECKBOX_SP3:currentCheckBox.setSP3(xmlText);break;
                case CHECKBOX_VAR3:currentCheckBox.setVAR3(xmlText);break;
                case CHECKBOX_SP4:currentCheckBox.setSP4(xmlText);break;
                case CHECKBOX_VAR4:currentCheckBox.setVAR4(xmlText);break;
                case CHECKBOX_SP5:currentCheckBox.setSP5(xmlText);break;
                case CHECKBOX_VAR5:currentCheckBox.setVAR5(xmlText);break;
                case CHECKBOX_SP6:currentCheckBox.setSP6(xmlText);break;
                case CHECKBOX_VAR6:currentCheckBox.setVAR6(xmlText);break;
                case CHECKBOX_SP7:currentCheckBox.setSP7(xmlText);break;
                case CHECKBOX_VAR7:currentCheckBox.setVAR7(xmlText);break;
                case CHECKBOX_SP8:currentCheckBox.setSP8(xmlText);break;
                case CHECKBOX_VAR8:currentCheckBox.setVAR8(xmlText);break;
                case CHECKBOX_SP9:currentCheckBox.setSP9(xmlText);break;
                case CHECKBOX_VAR9:currentCheckBox.setVAR9(xmlText);break;
                case CHECKBOX_SP10:currentCheckBox.setSP10(xmlText);break;
                case CHECKBOX_VAR10:currentCheckBox.setVAR10(xmlText);break;
                case CHECKBOX_SP11:currentCheckBox.setSP11(xmlText);break;
                case CHECKBOX_VAR11:currentCheckBox.setVAR11(xmlText);break;
                case CHECKBOX_SP12:currentCheckBox.setSP12(xmlText);break;
                case CHECKBOX_VAR12:currentCheckBox.setVAR12(xmlText);break;
                case CHECKBOX_SP13:currentCheckBox.setSP13(xmlText);break;
                case CHECKBOX_VAR13:currentCheckBox.setVAR13(xmlText);break;
                case CHECKBOX_SP14:currentCheckBox.setSP14(xmlText);break;
                case CHECKBOX_VAR14:currentCheckBox.setVAR14(xmlText);break;
                case CHECKBOX_SP15:currentCheckBox.setSP15(xmlText);break;
                case CHECKBOX_VAR15:currentCheckBox.setVAR15(xmlText);break;
                case CHECKBOX_SP16:currentCheckBox.setSP16(xmlText);break;
                case CHECKBOX_VAR16:currentCheckBox.setVAR16(xmlText);break;
                case CHECKBOX_SP17:currentCheckBox.setSP17(xmlText);break;
                case CHECKBOX_VAR17:currentCheckBox.setVAR17(xmlText);break;
                case CHECKBOX_SP18:currentCheckBox.setSP18(xmlText);break;
                case CHECKBOX_VAR18:currentCheckBox.setVAR18(xmlText);break;
                case CHECKBOX_SP19:currentCheckBox.setSP19(xmlText);break;
                case CHECKBOX_VAR19:currentCheckBox.setVAR19(xmlText);break;
                case CHECKBOX_VARESP:currentCheckBox.setVARESP(xmlText);break;
            }
        }
    }

    private void handleStarTag(String name) {
        if(name.equals("CHECKBOX")){
            currentCheckBox = new CCheckBox();
            cCheckBoxes.add(currentCheckBox);
        }else{
            currentTag = name;
        }
    }
}
