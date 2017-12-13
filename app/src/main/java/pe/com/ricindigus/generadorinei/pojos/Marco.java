package pe.com.ricindigus.generadorinei.pojos;

import android.content.ContentValues;

import pe.com.ricindigus.generadorinei.modelo.DataSourceCaptura.SQLConstantes;

/**
 * Created by otin016 on 22/08/2017.
 */

public class Marco {
    private String ID;
    private String RUC;
    private String RAZON_SOCIAL;
    private String NOMBRE_COMERCIAL;
    private String OPERADOR;
    private String JEFE;
    private String OBSERVADOR;
    private String ANIO;
    private String MES;
    private String PERIODO;
    private String CCDD;
    private String DEPARTAMENTO;
    private String CCPP;
    private String PROVINCIA;
    private String CCDI;
    private String DISTRITO;
    private String T_EMPRESA;
    private String FRENTE;
    private String ZONA;
    private String MANZANA;
    private String CAT_VIA;
    private String NOM_VIA;
    private String PUERTA;
    private String INTERIOR;
    private String PISO;
    private String MZ;
    private String LOTE;

    public Marco() {
        this.ID = "";
        this.RUC = "";
        this.RAZON_SOCIAL = "";
        this.NOMBRE_COMERCIAL = "";
        this.OPERADOR = "";
        this.JEFE = "";
        this.OBSERVADOR = "";
        this.ANIO = "";
        this.MES = "";
        this.PERIODO = "";
        this.CCDD = "";
        this.DEPARTAMENTO = "";
        this.CCPP = "";
        this.PROVINCIA = "";
        this.CCDI = "";
        this.DISTRITO = "";
        this.T_EMPRESA = "";
        this.FRENTE = "";
        this.ZONA = "";
        this.MANZANA = "";
        this.CAT_VIA = "";
        this.NOM_VIA = "";
        this.PUERTA = "";
        this.INTERIOR = "";
        this.PISO = "";
        this.MZ = "";
        this.LOTE = "";
    }

    public Marco(String ID, String RUC, String RAZON_SOCIAL, String NOMBRE_COMERCIAL, String OPERADOR, String JEFE, String OBSERVADOR, String ANIO, String MES, String PERIODO, String CCDD, String DEPARTAMENTO, String CCPP, String PROVINCIA, String CCDI, String DISTRITO, String t_EMPRESA, String FRENTE, String ZONA, String MANZANA, String CAT_VIA, String NOM_VIA, String PUERTA, String INTERIOR, String PISO, String MZ, String LOTE) {
        this.ID = ID;
        this.RUC = RUC;
        this.RAZON_SOCIAL = RAZON_SOCIAL;
        this.NOMBRE_COMERCIAL = NOMBRE_COMERCIAL;
        this.OPERADOR = OPERADOR;
        this.JEFE = JEFE;
        this.OBSERVADOR = OBSERVADOR;
        this.ANIO = ANIO;
        this.MES = MES;
        this.PERIODO = PERIODO;
        this.CCDD = CCDD;
        this.DEPARTAMENTO = DEPARTAMENTO;
        this.CCPP = CCPP;
        this.PROVINCIA = PROVINCIA;
        this.CCDI = CCDI;
        this.DISTRITO = DISTRITO;
        this.T_EMPRESA = t_EMPRESA;
        this.FRENTE = FRENTE;
        this.ZONA = ZONA;
        this.MANZANA = MANZANA;
        this.CAT_VIA = CAT_VIA;
        this.NOM_VIA = NOM_VIA;
        this.PUERTA = PUERTA;
        this.INTERIOR = INTERIOR;
        this.PISO = PISO;
        this.MZ = MZ;
        this.LOTE = LOTE;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getRUC() {
        return RUC;
    }

    public void setRUC(String RUC) {
        this.RUC = RUC;
    }

    public String getRAZON_SOCIAL() {
        return RAZON_SOCIAL;
    }

    public void setRAZON_SOCIAL(String RAZON_SOCIAL) {
        this.RAZON_SOCIAL = RAZON_SOCIAL;
    }

    public String getNOMBRE_COMERCIAL() {
        return NOMBRE_COMERCIAL;
    }

    public void setNOMBRE_COMERCIAL(String NOMBRE_COMERCIAL) {
        this.NOMBRE_COMERCIAL = NOMBRE_COMERCIAL;
    }

    public String getOPERADOR() {
        return OPERADOR;
    }

    public void setOPERADOR(String OPERADOR) {
        this.OPERADOR = OPERADOR;
    }

    public String getJEFE() {
        return JEFE;
    }

    public void setJEFE(String JEFE) {
        this.JEFE = JEFE;
    }

    public String getOBSERVADOR() {
        return OBSERVADOR;
    }

    public void setOBSERVADOR(String OBSERVADOR) {
        this.OBSERVADOR = OBSERVADOR;
    }

    public String getANIO() {
        return ANIO;
    }

    public void setANIO(String ANIO) {
        this.ANIO = ANIO;
    }

    public String getMES() {
        return MES;
    }

    public void setMES(String MES) {
        this.MES = MES;
    }

    public String getPERIODO() {
        return PERIODO;
    }

    public void setPERIODO(String PERIODO) {
        this.PERIODO = PERIODO;
    }

    public String getCCDD() {
        return CCDD;
    }

    public void setCCDD(String CCDD) {
        this.CCDD = CCDD;
    }

    public String getDEPARTAMENTO() {
        return DEPARTAMENTO;
    }

    public void setDEPARTAMENTO(String DEPARTAMENTO) {
        this.DEPARTAMENTO = DEPARTAMENTO;
    }

    public String getCCPP() {
        return CCPP;
    }

    public void setCCPP(String CCPP) {
        this.CCPP = CCPP;
    }

    public String getPROVINCIA() {
        return PROVINCIA;
    }

    public void setPROVINCIA(String PROVINCIA) {
        this.PROVINCIA = PROVINCIA;
    }

    public String getCCDI() {
        return CCDI;
    }

    public void setCCDI(String CCDI) {
        this.CCDI = CCDI;
    }

    public String getDISTRITO() {
        return DISTRITO;
    }

    public void setDISTRITO(String DISTRITO) {
        this.DISTRITO = DISTRITO;
    }

    public String getT_EMPRESA() {
        return T_EMPRESA;
    }

    public void setT_EMPRESA(String t_EMPRESA) {
        T_EMPRESA = t_EMPRESA;
    }

    public String getFRENTE() {
        return FRENTE;
    }

    public void setFRENTE(String FRENTE) {
        this.FRENTE = FRENTE;
    }

    public String getZONA() {
        return ZONA;
    }

    public void setZONA(String ZONA) {
        this.ZONA = ZONA;
    }

    public String getMANZANA() {
        return MANZANA;
    }

    public void setMANZANA(String MANZANA) {
        this.MANZANA = MANZANA;
    }

    public String getCAT_VIA() {
        return CAT_VIA;
    }

    public void setCAT_VIA(String CAT_VIA) {
        this.CAT_VIA = CAT_VIA;
    }

    public String getNOM_VIA() {
        return NOM_VIA;
    }

    public void setNOM_VIA(String NOM_VIA) {
        this.NOM_VIA = NOM_VIA;
    }

    public String getPUERTA() {
        return PUERTA;
    }

    public void setPUERTA(String PUERTA) {
        this.PUERTA = PUERTA;
    }

    public String getINTERIOR() {
        return INTERIOR;
    }

    public void setINTERIOR(String INTERIOR) {
        this.INTERIOR = INTERIOR;
    }

    public String getPISO() {
        return PISO;
    }

    public void setPISO(String PISO) {
        this.PISO = PISO;
    }

    public String getMZ() {
        return MZ;
    }

    public void setMZ(String MZ) {
        this.MZ = MZ;
    }

    public String getLOTE() {
        return LOTE;
    }

    public void setLOTE(String LOTE) {
        this.LOTE = LOTE;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues(27);
        contentValues.put(SQLConstantes.MARCO_ID,ID);
        contentValues.put(SQLConstantes.MARCO_RUC,RUC);
        contentValues.put(SQLConstantes.MARCO_RAZON_SOCIAL,RAZON_SOCIAL);
        contentValues.put(SQLConstantes.MARCO_NOMBRE_COMERCIAL,NOMBRE_COMERCIAL);
        contentValues.put(SQLConstantes.MARCO_OPERADOR,OPERADOR);
        contentValues.put(SQLConstantes.MARCO_JEFE,JEFE);
        contentValues.put(SQLConstantes.MARCO_OBSERVADOR,OBSERVADOR);
        contentValues.put(SQLConstantes.MARCO_ANIO,ANIO);
        contentValues.put(SQLConstantes.MARCO_MES,MES);
        contentValues.put(SQLConstantes.MARCO_PERIODO,PERIODO);
        contentValues.put(SQLConstantes.MARCO_CCDD,CCDD);
        contentValues.put(SQLConstantes.MARCO_DEPARTAMENTO,DEPARTAMENTO);
        contentValues.put(SQLConstantes.MARCO_CCPP,CCPP);
        contentValues.put(SQLConstantes.MARCO_PROVINCIA,PROVINCIA);
        contentValues.put(SQLConstantes.MARCO_CCDI,CCDI);
        contentValues.put(SQLConstantes.MARCO_DISTRITO,DISTRITO);
        contentValues.put(SQLConstantes.MARCO_T_EMPRESA,T_EMPRESA);
        contentValues.put(SQLConstantes.MARCO_FRENTE,FRENTE);
        contentValues.put(SQLConstantes.MARCO_ZONA,ZONA);
        contentValues.put(SQLConstantes.MARCO_MANZANA,MANZANA);
        contentValues.put(SQLConstantes.MARCO_CAT_VIA,CAT_VIA);
        contentValues.put(SQLConstantes.MARCO_NOM_VIA,NOM_VIA);
        contentValues.put(SQLConstantes.MARCO_PUERTA,PUERTA);
        contentValues.put(SQLConstantes.MARCO_INTERIOR,INTERIOR);
        contentValues.put(SQLConstantes.MARCO_PISO,PISO);
        contentValues.put(SQLConstantes.MARCO_MZ,MZ);
        contentValues.put(SQLConstantes.MARCO_LOTE,LOTE);
        return contentValues;
    }
}
