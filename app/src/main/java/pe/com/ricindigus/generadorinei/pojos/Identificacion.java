package pe.com.ricindigus.generadorinei.pojos;

import android.content.ContentValues;

import pe.com.ricindigus.generadorinei.modelo.DataSourceCaptura.SQLConstantes;

/**
 * Created by otin016 on 12/08/2017.
 */

public class Identificacion {
    public String ID;
    public String NUM_RUC;
    public String RAZON_SOCIAL;
    public String NOM_COMER_COOP;
    public String ANIO_FUNDACION;
    public String PAG_WEB;
    public String PAG_WEB_NO;
    public String CORREO;
    public String CORREO_NO;
    public String COD_FIJO;
    public String TEL_FIJO;
    public String TEL_FIJO_NO;
    public String TEL_MOVIL;
    public String TEL_MOVIL_NO;
    public String ANIO_OPERACION;
    public String NOM_INFORMANTE;
    public String SEXO_INFORMANTE;
    public String EDAD_INFORMANTE;
    public String ACAD_INFORMANTE;
    public String CARGO_INFORMANTE;
    public String CARGO_INFORMANTE_ESP;
    private String USU_CREACION;
    private String FEC_CREACION;
    private String USU_REGISTRO;
    private String FEC_REGISTRO;

    public Identificacion(){
        this.ID = "";
        this.NUM_RUC = "";
        this.RAZON_SOCIAL = "";
        this.NOM_COMER_COOP = "";
        this.ANIO_FUNDACION = "";
        this.PAG_WEB = "";
        this.PAG_WEB_NO = "";
        this.CORREO = "";
        this.CORREO_NO = "";
        this.COD_FIJO = "";
        this.TEL_FIJO = "";
        this.TEL_FIJO_NO = "";
        this.TEL_MOVIL = "";
        this.TEL_MOVIL_NO = "";
        this.ANIO_OPERACION = "";
        this.NOM_INFORMANTE = "";
        this.SEXO_INFORMANTE = "";
        this.EDAD_INFORMANTE = "";
        this.ACAD_INFORMANTE = "";
        this.CARGO_INFORMANTE = "";
        this.CARGO_INFORMANTE_ESP = "";
        this.USU_CREACION = "";
        this.FEC_CREACION = "";
        this.USU_REGISTRO = "";
        this.FEC_REGISTRO = "";
    }

    public Identificacion(String ID, String NUM_RUC, String RAZON_SOCIAL, String NOM_COMER_COOP, String ANIO_FUNDACION, String PAG_WEB, String PAG_WEB_NO, String CORREO, String CORREO_NO, String COD_FIJO, String TEL_FIJO, String TEL_FIJO_NO, String TEL_MOVIL, String TEL_MOVIL_NO, String ANIO_OPERACION, String NOM_INFORMANTE, String SEXO_INFORMANTE, String EDAD_INFORMANTE, String ACAD_INFORMANTE, String CARGO_INFORMANTE, String CARGO_INFORMANTE_ESP, String USU_CREACION, String FEC_CREACION, String USU_REGISTRO, String FEC_REGISTRO) {
        this.ID = ID;
        this.NUM_RUC = NUM_RUC;
        this.RAZON_SOCIAL = RAZON_SOCIAL;
        this.NOM_COMER_COOP = NOM_COMER_COOP;
        this.ANIO_FUNDACION = ANIO_FUNDACION;
        this.PAG_WEB = PAG_WEB;
        this.PAG_WEB_NO = PAG_WEB_NO;
        this.CORREO = CORREO;
        this.CORREO_NO = CORREO_NO;
        this.COD_FIJO = COD_FIJO;
        this.TEL_FIJO = TEL_FIJO;
        this.TEL_FIJO_NO = TEL_FIJO_NO;
        this.TEL_MOVIL = TEL_MOVIL;
        this.TEL_MOVIL_NO = TEL_MOVIL_NO;
        this.ANIO_OPERACION = ANIO_OPERACION;
        this.NOM_INFORMANTE = NOM_INFORMANTE;
        this.SEXO_INFORMANTE = SEXO_INFORMANTE;
        this.EDAD_INFORMANTE = EDAD_INFORMANTE;
        this.ACAD_INFORMANTE = ACAD_INFORMANTE;
        this.CARGO_INFORMANTE = CARGO_INFORMANTE;
        this.CARGO_INFORMANTE_ESP = CARGO_INFORMANTE_ESP;
        this.USU_CREACION = USU_CREACION;
        this.FEC_CREACION = FEC_CREACION;
        this.USU_REGISTRO = USU_REGISTRO;
        this.FEC_REGISTRO = FEC_REGISTRO;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getUSU_CREACION() {
        return USU_CREACION;
    }

    public void setUSU_CREACION(String USU_CREACION) {
        this.USU_CREACION = USU_CREACION;
    }

    public String getFEC_CREACION() {
        return FEC_CREACION;
    }

    public void setFEC_CREACION(String FEC_CREACION) {
        this.FEC_CREACION = FEC_CREACION;
    }

    public String getUSU_REGISTRO() {
        return USU_REGISTRO;
    }

    public void setUSU_REGISTRO(String USU_REGISTRO) {
        this.USU_REGISTRO = USU_REGISTRO;
    }

    public String getFEC_REGISTRO() {
        return FEC_REGISTRO;
    }

    public void setFEC_REGISTRO(String FEC_REGISTRO) {
        this.FEC_REGISTRO = FEC_REGISTRO;
    }

    public String getNUM_RUC() {
        return NUM_RUC;
    }

    public void setNUM_RUC(String NUM_RUC) {
        this.NUM_RUC = NUM_RUC;
    }

    public String getRAZON_SOCIAL() {
        return RAZON_SOCIAL;
    }

    public void setRAZON_SOCIAL(String RAZON_SOCIAL) {
        this.RAZON_SOCIAL = RAZON_SOCIAL;
    }

    public String getNOM_COMER_COOP() {
        return NOM_COMER_COOP;
    }

    public void setNOM_COMER_COOP(String NOM_COMER_COOP) {
        this.NOM_COMER_COOP = NOM_COMER_COOP;
    }

    public String getANIO_FUNDACION() {
        return ANIO_FUNDACION;
    }

    public void setANIO_FUNDACION(String ANIO_FUNDACION) {
        this.ANIO_FUNDACION = ANIO_FUNDACION;
    }

    public String getPAG_WEB() {
        return PAG_WEB;
    }

    public void setPAG_WEB(String PAG_WEB) {
        this.PAG_WEB = PAG_WEB;
    }

    public String getPAG_WEB_NO() {
        return PAG_WEB_NO;
    }

    public void setPAG_WEB_NO(String PAG_WEB_NO) {
        this.PAG_WEB_NO = PAG_WEB_NO;
    }

    public String getCORREO() {
        return CORREO;
    }

    public void setCORREO(String CORREO) {
        this.CORREO = CORREO;
    }

    public String getCORREO_NO() {
        return CORREO_NO;
    }

    public void setCORREO_NO(String CORREO_NO) {
        this.CORREO_NO = CORREO_NO;
    }

    public String getCOD_FIJO() {
        return COD_FIJO;
    }

    public void setCOD_FIJO(String COD_FIJO) {
        this.COD_FIJO = COD_FIJO;
    }

    public String getTEL_FIJO() {
        return TEL_FIJO;
    }

    public void setTEL_FIJO(String TEL_FIJO) {
        this.TEL_FIJO = TEL_FIJO;
    }

    public String getTEL_FIJO_NO() {
        return TEL_FIJO_NO;
    }

    public void setTEL_FIJO_NO(String TEL_FIJO_NO) {
        this.TEL_FIJO_NO = TEL_FIJO_NO;
    }

    public String getTEL_MOVIL() {
        return TEL_MOVIL;
    }

    public void setTEL_MOVIL(String TEL_MOVIL) {
        this.TEL_MOVIL = TEL_MOVIL;
    }

    public String getTEL_MOVIL_NO() {
        return TEL_MOVIL_NO;
    }

    public void setTEL_MOVIL_NO(String TEL_MOVIL_NO) {
        this.TEL_MOVIL_NO = TEL_MOVIL_NO;
    }

    public String getANIO_OPERACION() {
        return ANIO_OPERACION;
    }

    public void setANIO_OPERACION(String ANIO_OPERACION) {
        this.ANIO_OPERACION = ANIO_OPERACION;
    }

    public String getNOM_INFORMANTE() {
        return NOM_INFORMANTE;
    }

    public void setNOM_INFORMANTE(String NOM_INFORMANTE) {
        this.NOM_INFORMANTE = NOM_INFORMANTE;
    }

    public String getSEXO_INFORMANTE() {
        return SEXO_INFORMANTE;
    }

    public void setSEXO_INFORMANTE(String SEXO_INFORMANTE) {
        this.SEXO_INFORMANTE = SEXO_INFORMANTE;
    }

    public String getEDAD_INFORMANTE() {
        return EDAD_INFORMANTE;
    }

    public void setEDAD_INFORMANTE(String EDAD_INFORMANTE) {
        this.EDAD_INFORMANTE = EDAD_INFORMANTE;
    }

    public String getACAD_INFORMANTE() {
        return ACAD_INFORMANTE;
    }

    public void setACAD_INFORMANTE(String ACAD_INFORMANTE) {
        this.ACAD_INFORMANTE = ACAD_INFORMANTE;
    }

    public String getCARGO_INFORMANTE() {
        return CARGO_INFORMANTE;
    }

    public void setCARGO_INFORMANTE(String CARGO_INFORMANTE) {
        this.CARGO_INFORMANTE = CARGO_INFORMANTE;
    }

    public String getCARGO_INFORMANTE_ESP() {
        return CARGO_INFORMANTE_ESP;
    }

    public void setCARGO_INFORMANTE_ESP(String CARGO_INFORMANTE_ESP) {
        this.CARGO_INFORMANTE_ESP = CARGO_INFORMANTE_ESP;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues(25);
        contentValues.put(SQLConstantes.IDENTIFICACION_ID,ID);
        contentValues.put(SQLConstantes.IDENTIFICACION_RUC,NUM_RUC);
        contentValues.put(SQLConstantes.IDENTIFICACION_RAZON,RAZON_SOCIAL);
        contentValues.put(SQLConstantes.IDENTIFICACION_NOMBRE,NOM_COMER_COOP);
        contentValues.put(SQLConstantes.IDENTIFICACION_WEB,PAG_WEB);
        contentValues.put(SQLConstantes.IDENTIFICACION_WEBNO,PAG_WEB_NO);
        contentValues.put(SQLConstantes.IDENTIFICACION_CORREO,CORREO);
        contentValues.put(SQLConstantes.IDENTIFICACION_CORREONO,CORREO_NO);
        contentValues.put(SQLConstantes.IDENTIFICACION_FIJO,TEL_FIJO);
        contentValues.put(SQLConstantes.IDENTIFICACION_FIJONO,TEL_FIJO_NO);
        contentValues.put(SQLConstantes.IDENTIFICACION_MOVIL,TEL_MOVIL);
        contentValues.put(SQLConstantes.IDENTIFICACION_MOVILNO,TEL_MOVIL_NO);
        contentValues.put(SQLConstantes.IDENTIFICACION_ANIO_FUNCIONAMIENTO,ANIO_OPERACION);
        contentValues.put(SQLConstantes.IDENTIFICACION_CONDUCTOR_NOMBRE,NOM_INFORMANTE);
        contentValues.put(SQLConstantes.IDENTIFICACION_CONDUCTOR_SEXO,SEXO_INFORMANTE);
        contentValues.put(SQLConstantes.IDENTIFICACION_CONDUCTOR_EDAD,EDAD_INFORMANTE);
        contentValues.put(SQLConstantes.IDENTIFICACION_CONDUCTOR_ESTUDIOS,ACAD_INFORMANTE);
        contentValues.put(SQLConstantes.IDENTIFICACION_CONDUCTOR_CARGO,CARGO_INFORMANTE);
        contentValues.put(SQLConstantes.IDENTIFICACION_CONDUCTOR_CARGO_ESP,CARGO_INFORMANTE_ESP);
        return contentValues;
    }
}
