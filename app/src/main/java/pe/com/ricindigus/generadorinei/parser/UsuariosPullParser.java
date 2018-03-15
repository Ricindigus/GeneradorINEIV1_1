package pe.com.ricindigus.generadorinei.parser;

import android.content.Context;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.pojos.Usuario;

/**
 * Created by otin016 on 23/08/2017.
 */

public class UsuariosPullParser {
    public static final String USU_ID = "ID";
    public static final String USU_PASSWORD = "PASSWORD";
    public static final String USU_PERMISO = "PERMISO";
    private Usuario currentUsuario = null;
    private String currentTag = null;
    ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

    public ArrayList<Usuario> parseXML(Context context){
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();

            try {
                InputStream stream = context.getAssets().open("general/usuarios.xml");
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
        return usuarios;
    }

    private void handleText(String text) {
        String xmlText = text;
        if(currentUsuario!= null && currentTag != null){
            switch (currentTag){
                case USU_ID:currentUsuario.setUSUARIO_ID(xmlText);break;
                case USU_PASSWORD:currentUsuario.setUSUARIO_PASSWORD(xmlText);break;
                case USU_PERMISO:currentUsuario.setUSUARIO_PERMISO(xmlText);break;
            }
        }
    }

    private void handleStarTag(String name) {
        if(name.equals("USUARIO")){
            currentUsuario = new Usuario();
            usuarios.add(currentUsuario);
        }else{
            currentTag = name;
        }
    }
}
