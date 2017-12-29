package pe.com.ricindigus.generadorinei.componentes.componente_radio;

import android.content.Context;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.pojos.Usuario;

/**
 * Created by dmorales on 28/12/2017.
 */

public class RadioPullParser {

    public static final String RADIO_ID = "ID";
    public static final String RADIO_MODULO = "MODULO";
    public static final String RADIO_NUMERO = "NUMERO";
    public static final String RADIO_PAGINA = "PAGINA";
    public static final String RADIO_PREGUNTA = "PREGUNTA";
    public static final String RADIO_SP1 = "SP1";
    public static final String RADIO_SP2 = "SP2";
    public static final String RADIO_SP3 = "SP3";
    public static final String RADIO_SP4 = "SP4";
    public static final String RADIO_SP5 = "SP5";
    public static final String RADIO_SP6 = "SP6";
    public static final String RADIO_SP7 = "SP7";
    public static final String RADIO_SP8 = "SP8";
    public static final String RADIO_SP9 = "SP9";
    public static final String RADIO_SP10 = "SP10";
    public static final String RADIO_VARRADIO = "VARRADIO";
    public static final String RADIO_VARESP = "VARESP";
    private CRadio currentRadio = null;
    private String currentTag = null;
    ArrayList<CRadio> cRadios = new ArrayList<CRadio>();

    public ArrayList<CRadio> parseXML(Context context){
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();

            try {
                InputStream stream = context.getAssets().open("componente_radio.xml");
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
        return cRadios;
    }

    private void handleText(String text) {
        String xmlText = text;
        if(currentRadio!= null && currentTag != null){
            switch (currentTag){
                case RADIO_ID:currentRadio.setID(xmlText);break;
                case RADIO_MODULO:currentRadio.setMODULO(xmlText);break;
                case RADIO_NUMERO:currentRadio.setNUMERO(xmlText);break;
                case RADIO_PAGINA:currentRadio.setPAGINA(xmlText);break;
                case RADIO_PREGUNTA:currentRadio.setPREGUNTA(xmlText);break;
                case RADIO_SP1:currentRadio.setSP1(xmlText);break;
                case RADIO_SP2:currentRadio.setSP2(xmlText);break;
                case RADIO_SP3:currentRadio.setSP3(xmlText);break;
                case RADIO_SP4:currentRadio.setSP4(xmlText);break;
                case RADIO_SP5:currentRadio.setSP5(xmlText);break;
                case RADIO_SP6:currentRadio.setSP6(xmlText);break;
                case RADIO_SP7:currentRadio.setSP7(xmlText);break;
                case RADIO_SP8:currentRadio.setSP8(xmlText);break;
                case RADIO_SP9:currentRadio.setSP9(xmlText);break;
                case RADIO_SP10:currentRadio.setSP10(xmlText);break;
                case RADIO_VARRADIO:currentRadio.setVARRADIO(xmlText);break;
                case RADIO_VARESP:currentRadio.setVARESP(xmlText);break;
            }
        }
    }

    private void handleStarTag(String name) {
        if(name.equals("RADIO")){
            currentRadio = new CRadio();
            cRadios.add(currentRadio);
        }else{
            currentTag = name;
        }
    }
}
