package pe.com.ricindigus.generadorinei.componentes.componente_selectpais;

import android.content.Context;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


import pe.com.ricindigus.generadorinei.componentes.componente_selectpais.pojos.PSelectPais;

import static android.os.Environment.getExternalStorageDirectory;

public class SelectPaisPullParser {
    //columnas pregunta edittext
    public static final String SELECTPAIS_ID = "ID";
    public static final String SELECTPAIS_MODULO = "MODULO";
    public static final String SELECTPAIS_NUMERO = "NUMERO";
    public static final String SELECTPAIS_PREGUNTA = "PREGUNTA";
    public static final String SELECTPAIS_VARPAIS = "VARPAIS";



    private String currentTag = null;
    private PSelectPais currentSelectPais = null;

    ArrayList<PSelectPais> pSelectPaiss = new ArrayList<PSelectPais>();


    public ArrayList<PSelectPais> parseXMLPSelectPais(Context context){
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();

            try {
                InputStream stream = context.getAssets().open("preguntas_selectpais.xml");
                xpp.setInput(stream,null);

                int eventType = xpp.getEventType();

                while(eventType != XmlPullParser.END_DOCUMENT){
                    if(eventType == XmlPullParser.START_TAG){
                        handleStarTagPSelectPais(xpp.getName());
                    }else if(eventType == XmlPullParser.END_TAG){
                        currentTag = null;
                    }else if(eventType == XmlPullParser.TEXT){
                        handleTextPSelectPais(xpp.getText());
                    }
                    eventType = xpp.next();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        return pSelectPaiss;
    }

    public ArrayList<PSelectPais> parseXMLPSelectPais(Context context, String archivo){
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();
            FileInputStream fis = null;
            try {
                File nuevaCarpeta = new File(getExternalStorageDirectory(), "GENERADOR");
                File file = new File(nuevaCarpeta, archivo);
                FileInputStream fileInputStream = new FileInputStream(file);
                fis = new FileInputStream(file);
                xpp.setInput(fis, null);
                int eventType = xpp.getEventType();

                while(eventType != XmlPullParser.END_DOCUMENT){
                    if(eventType == XmlPullParser.START_TAG){
                        handleStarTagPSelectPais(xpp.getName());
                    }else if(eventType == XmlPullParser.END_TAG){
                        currentTag = null;
                    }else if(eventType == XmlPullParser.TEXT){
                        handleTextPSelectPais(xpp.getText());
                    }
                    eventType = xpp.next();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        return pSelectPaiss;
    }

    private void handleTextPSelectPais(String text) {
        String xmlText = text;
        if(currentSelectPais!= null && currentTag != null){
            switch (currentTag){
                case SELECTPAIS_ID:currentSelectPais.setID(xmlText);break;
                case SELECTPAIS_MODULO:currentSelectPais.setMODULO(xmlText);break;
                case SELECTPAIS_NUMERO:currentSelectPais.setNUMERO(xmlText);break;
                case SELECTPAIS_PREGUNTA:currentSelectPais.setPREGUNTA(xmlText);break;
                case SELECTPAIS_VARPAIS:currentSelectPais.setVARPAIS(xmlText);break;
            }
        }
    }

    private void handleStarTagPSelectPais(String name) {
        if(name.equals("SELECTPAIS")){
            currentSelectPais = new PSelectPais();
            pSelectPaiss.add(currentSelectPais);
        }else{
            currentTag = name;
        }
    }
}
