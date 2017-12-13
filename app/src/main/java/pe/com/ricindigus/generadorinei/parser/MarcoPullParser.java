package pe.com.ricindigus.generadorinei.parser;

import android.content.Context;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.pojos.Marco;

/**
 * Created by RICARDO on 10/08/2017.
 */

public class MarcoPullParser {
    private static final String M_ID = "ID";
    private static final String M_RUC = "RUC";
    private static final String M_RAZON_SOCIAL = "RAZON_SOCIAL";
    private static final String M_NOMBRE_COMERCIAL = "NOMBRE_COMERCIAL";
    private static final String M_OPERADOR = "OPERADOR";
    private static final String M_JEFE = "JEFE";
    private static final String M_OBSERVADOR = "OBSERVADOR";
    private static final String M_ANIO = "ANIO";
    private static final String M_MES = "MES";
    private static final String M_PERIODO = "PERIODO";
    private static final String M_CCDD = "CCDD";
    private static final String M_DEPARTAMENTO = "DEPARTAMENTO";
    private static final String M_CCPP = "CCPP";
    private static final String M_PROVINCIA = "PROVINCIA";
    private static final String M_CCDI = "CCDI";
    private static final String M_DISTRITO = "DISTRITO";
    private static final String M_T_EMPRESA = "T_EMPRESA";
    private static final String M_FRENTE = "FRENTE";
    private static final String M_ZONA = "ZONA";
    private static final String M_MANZANA = "MANZANA";
    private static final String M_CAT_VIA = "CAT_VIA";
    private static final String M_NOM_VIA = "NOM_VIA";
    private static final String M_PUERTA = "PUERTA";
    private static final String M_INTERIOR = "INTERIOR";
    private static final String M_PISO = "PISO";
    private static final String M_MZ = "MZ";
    private static final String M_LOTE = "LOTE";

    private Marco currentMarco = null;
    private String currentTag = null;
    ArrayList<Marco> marcos = new ArrayList<Marco>();

    public ArrayList<Marco> parseXML(Context context){
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();

            try {
                InputStream stream = context.getAssets().open("marco.xml");
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
        return marcos;
    }

    private void handleText(String text) {
        String xmlText = text;
        if(currentMarco!= null && currentTag != null){
            switch (currentTag){
                case M_ID:currentMarco.setID(xmlText);break;
                case M_RUC:currentMarco.setRUC(xmlText);break;
                case M_RAZON_SOCIAL:currentMarco.setRAZON_SOCIAL(xmlText);break;
                case M_NOMBRE_COMERCIAL:currentMarco.setNOMBRE_COMERCIAL(xmlText);break;
                case M_OPERADOR:currentMarco.setOPERADOR(xmlText);break;
                case M_JEFE:currentMarco.setJEFE(xmlText);break;
                case M_OBSERVADOR:currentMarco.setOBSERVADOR(xmlText);break;
                case M_ANIO:currentMarco.setANIO(xmlText);break;
                case M_MES:currentMarco.setMES(xmlText);break;
                case M_PERIODO:currentMarco.setPERIODO(xmlText);break;
                case M_CCDD:currentMarco.setCCDD(xmlText);break;
                case M_DEPARTAMENTO:currentMarco.setDEPARTAMENTO(xmlText);break;
                case M_CCPP:currentMarco.setCCPP(xmlText);break;
                case M_PROVINCIA:currentMarco.setPROVINCIA(xmlText);break;
                case M_CCDI:currentMarco.setCCDI(xmlText);break;
                case M_DISTRITO:currentMarco.setDISTRITO(xmlText);break;
                case M_T_EMPRESA:currentMarco.setT_EMPRESA(xmlText);break;
                case M_FRENTE:currentMarco.setFRENTE(xmlText);break;
                case M_ZONA:currentMarco.setZONA(xmlText);break;
                case M_MANZANA:currentMarco.setMANZANA(xmlText);break;
                case M_CAT_VIA:currentMarco.setCAT_VIA(xmlText);break;
                case M_NOM_VIA:currentMarco.setNOM_VIA(xmlText);break;
                case M_PUERTA:currentMarco.setPUERTA(xmlText);break;
                case M_INTERIOR:currentMarco.setINTERIOR(xmlText);break;
                case M_PISO:currentMarco.setPISO(xmlText);break;
                case M_MZ:currentMarco.setMZ(xmlText);break;
                case M_LOTE:currentMarco.setLOTE(xmlText);break;
            }
        }
    }

    private void handleStarTag(String name) {
        if(name.equals("TB_MARCO")){
            currentMarco = new Marco();
            marcos.add(currentMarco);
        }else{
            currentTag = name;
        }
    }
}
