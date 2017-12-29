package pe.com.ricindigus.generadorinei.componentes.componente_caratula;

import android.content.ContentValues;

import pe.com.ricindigus.generadorinei.modelo.DataSourceCaptura.SQLConstantes;

/**
 * Created by dmorales on 13/12/2017.
 */

public class CCaratula {
    private String ID;
    private String CAMBIO;
    private String NOMBREDD;
    private String CCDD;
    private String NOMBREPV;
    private String CCPP;
    private String NOMBREDI;
    private String CCDI;
    private String GPSLATITUD;
    private String GPSALTITUD;
    private String GPSLONGITUD;
    private String CCST;
    private String CCAT;
    private String ZON_NUM;
    private String MZ_ID;
    private String FRENTE;
    private String TIPVIA;
    private String NOMVIA;
    private String NROPTA;
    private String BLOCK;
    private String INT;
    private String PISO;
    private String MZA;
    private String LOTE;
    private String KM;
    private String REF_DIREC;

    public CCaratula(){
        this.ID = "";
        this.CAMBIO = "";
        this.NOMBREDD = "";
        this.CCDD = "";
        this.NOMBREPV = "";
        this.CCPP = "";
        this.NOMBREDI = "";
        this.CCDI = "";
        this.GPSLATITUD = "";
        this.GPSALTITUD = "";
        this.GPSLONGITUD = "";
        this.CCST = "";
        this.CCAT = "";
        this.ZON_NUM = "";
        this.MZ_ID = "";
        this.FRENTE = "";
        this.TIPVIA = "";
        this.NOMVIA = "";
        this.NROPTA = "";
        this.BLOCK = "";
        this.INT = "";
        this.PISO = "";
        this.MZA = "";
        this.LOTE = "";
        this.KM = "";
        this.REF_DIREC = "";

    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getCAMBIO() {
        return CAMBIO;
    }

    public void setCAMBIO(String CAMBIO) {
        this.CAMBIO = CAMBIO;
    }

    public String getNOMBREDD() {
        return NOMBREDD;
    }

    public void setNOMBREDD(String NOMBREDD) {
        this.NOMBREDD = NOMBREDD;
    }

    public String getCCDD() {
        return CCDD;
    }

    public void setCCDD(String CCDD) {
        this.CCDD = CCDD;
    }

    public String getNOMBREPV() {
        return NOMBREPV;
    }

    public void setNOMBREPV(String NOMBREPV) {
        this.NOMBREPV = NOMBREPV;
    }

    public String getCCPP() {
        return CCPP;
    }

    public void setCCPP(String CCPP) {
        this.CCPP = CCPP;
    }

    public String getNOMBREDI() {
        return NOMBREDI;
    }

    public void setNOMBREDI(String NOMBREDI) {
        this.NOMBREDI = NOMBREDI;
    }

    public String getCCDI() {
        return CCDI;
    }

    public void setCCDI(String CCDI) {
        this.CCDI = CCDI;
    }

    public String getGPSLATITUD() {
        return GPSLATITUD;
    }

    public void setGPSLATITUD(String GPSLATITUD) {
        this.GPSLATITUD = GPSLATITUD;
    }

    public String getGPSALTITUD() {
        return GPSALTITUD;
    }

    public void setGPSALTITUD(String GPSALTITUD) {
        this.GPSALTITUD = GPSALTITUD;
    }

    public String getGPSLONGITUD() {
        return GPSLONGITUD;
    }

    public void setGPSLONGITUD(String GPSLONGITUD) {
        this.GPSLONGITUD = GPSLONGITUD;
    }

    public String getCCST() {
        return CCST;
    }

    public void setCCST(String CCST) {
        this.CCST = CCST;
    }

    public String getCCAT() {
        return CCAT;
    }

    public void setCCAT(String CCAT) {
        this.CCAT = CCAT;
    }

    public String getZON_NUM() {
        return ZON_NUM;
    }

    public void setZON_NUM(String ZON_NUM) {
        this.ZON_NUM = ZON_NUM;
    }

    public String getMZ_ID() {
        return MZ_ID;
    }

    public void setMZ_ID(String MZ_ID) {
        this.MZ_ID = MZ_ID;
    }

    public String getFRENTE() {
        return FRENTE;
    }

    public void setFRENTE(String FRENTE) {
        this.FRENTE = FRENTE;
    }

    public String getTIPVIA() {
        return TIPVIA;
    }

    public void setTIPVIA(String TIPVIA) {
        this.TIPVIA = TIPVIA;
    }

    public String getNOMVIA() {
        return NOMVIA;
    }

    public void setNOMVIA(String NOMVIA) {
        this.NOMVIA = NOMVIA;
    }

    public String getNROPTA() {
        return NROPTA;
    }

    public void setNROPTA(String NROPTA) {
        this.NROPTA = NROPTA;
    }

    public String getBLOCK() {
        return BLOCK;
    }

    public void setBLOCK(String BLOCK) {
        this.BLOCK = BLOCK;
    }

    public String getINT() {
        return INT;
    }

    public void setINT(String INT) {
        this.INT = INT;
    }

    public String getPISO() {
        return PISO;
    }

    public void setPISO(String PISO) {
        this.PISO = PISO;
    }

    public String getMZA() {
        return MZA;
    }

    public void setMZA(String MZA) {
        this.MZA = MZA;
    }

    public String getLOTE() {
        return LOTE;
    }

    public void setLOTE(String LOTE) {
        this.LOTE = LOTE;
    }

    public String getKM() {
        return KM;
    }

    public void setKM(String KM) {
        this.KM = KM;
    }

    public String getREF_DIREC() {
        return REF_DIREC;
    }

    public void setREF_DIREC(String REF_DIREC) {
        this.REF_DIREC = REF_DIREC;
    }


    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues(30);
        contentValues.put(SQLConstantes.CARATULA_ID,ID);
        contentValues.put(SQLConstantes.CARATULA_CAMBIO,CAMBIO);
        contentValues.put(SQLConstantes.CARATULA_DEPARTAMENTO,NOMBREDD);
        contentValues.put(SQLConstantes.CARATULA_DEPARTAMENTO_COD,CCDD);
        contentValues.put(SQLConstantes.CARATULA_PROVINCIA,NOMBREPV);
        contentValues.put(SQLConstantes.CARATULA_PROVINCIA_COD,CCPP);
        contentValues.put(SQLConstantes.CARATULA_DISTRITO,NOMBREDI);
        contentValues.put(SQLConstantes.CARATULA_DISTRITO_COD,CCDI);
        contentValues.put(SQLConstantes.CARATULA_GPSLATITUD,GPSLATITUD);
        contentValues.put(SQLConstantes.CARATULA_GPSALTITUD,GPSALTITUD);
        contentValues.put(SQLConstantes.CARATULA_GPSLONGITUD,GPSLONGITUD);
        contentValues.put(SQLConstantes.CARATULA_SECTOR,CCST);
        contentValues.put(SQLConstantes.CARATULA_AREA,CCAT);
        contentValues.put(SQLConstantes.CARATULA_ZONA,ZON_NUM);
        contentValues.put(SQLConstantes.CARATULA_MANZANA_MUESTRA,MZ_ID);
        contentValues.put(SQLConstantes.CARATULA_FRENTE,FRENTE);
        contentValues.put(SQLConstantes.CARATULA_TIPVIA,TIPVIA);
        contentValues.put(SQLConstantes.CARATULA_NOMVIA,NOMVIA);
        contentValues.put(SQLConstantes.CARATULA_NPUERTA,NROPTA);
        contentValues.put(SQLConstantes.CARATULA_BLOCK,BLOCK);
        contentValues.put(SQLConstantes.CARATULA_INTERIOR,INT);
        contentValues.put(SQLConstantes.CARATULA_PISO,PISO);
        contentValues.put(SQLConstantes.CARATULA_MANZANA_VIA,MZA);
        contentValues.put(SQLConstantes.CARATULA_LOTE,LOTE);
        contentValues.put(SQLConstantes.CARATULA_KM,KM);
        contentValues.put(SQLConstantes.CARATULA_REFERENCIA,REF_DIREC);
        return contentValues;
    }
}
