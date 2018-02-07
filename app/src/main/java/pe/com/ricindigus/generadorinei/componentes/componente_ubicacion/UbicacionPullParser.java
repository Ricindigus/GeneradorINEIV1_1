package pe.com.ricindigus.generadorinei.componentes.componente_ubicacion;

import android.content.Context;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


/**
 * Created by dmorales on 30/01/2018.
 */

public class UbicacionPullParser {
    public static final String UBICACION_ID = "ID";
    public static final String UBICACION_NUM = "NUMERO";
    public static final String UBICACION_MODULO= "MODULO";
    public static final String UBICACION_DEPARTAMENTO = "VARDEP";
    public static final String UBICACION_PROVINCIA = "VARPRO";
    public static final String UBICACION_DISTRITO = "VARDIS";
    private Ubicacion currentUbicacion = null;
    private String currentTag = null;
    ArrayList<Ubicacion> ubicaciones = new ArrayList<Ubicacion>();

    public ArrayList<Ubicacion> parseXML(Context context){
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();

            try {
                InputStream stream = context.getAssets().open("ubicaciones.xml");
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
        return ubicaciones;
    }

    private void handleText(String text) {
        String xmlText = text;
        if(currentUbicacion!= null && currentTag != null){
            switch (currentTag){
                case UBICACION_ID:currentUbicacion.setID(xmlText);break;
                case UBICACION_NUM:currentUbicacion.setNUMERO(xmlText);break;
                case UBICACION_MODULO:currentUbicacion.setMODULO(xmlText);break;
                case UBICACION_DEPARTAMENTO:currentUbicacion.setVARDEP(xmlText);break;
                case UBICACION_PROVINCIA:currentUbicacion.setVARPRO(xmlText);break;
                case UBICACION_DISTRITO:currentUbicacion.setVARDIS(xmlText);break;
            }
        }
    }

    private void handleStarTag(String name) {
        if(name.equals("UBICACION")){
            currentUbicacion = new Ubicacion();
            ubicaciones.add(currentUbicacion);
        }else{
            currentTag = name;
        }
    }
}
