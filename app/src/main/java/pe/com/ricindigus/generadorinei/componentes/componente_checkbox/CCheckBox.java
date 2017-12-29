package pe.com.ricindigus.generadorinei.componentes.componente_checkbox;

import android.content.ContentValues;

import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.SQLConstantesComponente;

/**
 * Created by dmorales on 20/12/2017.
 */

public class CCheckBox {
    private String ID;
    private String MODULO;
    private String NUMERO;
    private String PAGINA;
    private String PREGUNTA;
    private String SP1;
    private String VAR1;
    private String SP2;
    private String VAR2;
    private String SP3;
    private String VAR3;
    private String SP4;
    private String VAR4;
    private String SP5;
    private String VAR5;
    private String SP6;
    private String VAR6;
    private String SP7;
    private String VAR7;
    private String SP8;
    private String VAR8;
    private String SP9;
    private String VAR9;
    private String SP10;
    private String VAR10;
    private String SP11;
    private String VAR11;
    private String SP12;
    private String VAR12;
    private String SP13;
    private String VAR13;
    private String SP14;
    private String VAR14;
    private String SP15;
    private String VAR15;
    private String SP16;
    private String VAR16;
    private String SP17;
    private String VAR17;
    private String SP18;
    private String VAR18;
    private String SP19;
    private String VAR19;
    private String VARESP;

    public CCheckBox(String ID, String MODULO, String NUMERO, String PAGINA, String PREGUNTA, String SP1, String VAR1, String SP2, String VAR2, String SP3, String VAR3, String SP4, String VAR4, String SP5, String VAR5, String SP6, String VAR6, String SP7, String VAR7, String SP8, String VAR8, String SP9, String VAR9, String SP10, String VAR10, String SP11, String VAR11, String SP12, String VAR12, String SP13, String VAR13, String SP14, String VAR14, String SP15, String VAR15, String SP16, String VAR16, String SP17, String VAR17, String SP18, String VAR18, String SP19, String VAR19, String VARESP) {
        this.ID = ID;
        this.MODULO = MODULO;
        this.NUMERO = NUMERO;
        this.PAGINA = PAGINA;
        this.PREGUNTA = PREGUNTA;
        this.SP1 = SP1;
        this.VAR1 = VAR1;
        this.SP2 = SP2;
        this.VAR2 = VAR2;
        this.SP3 = SP3;
        this.VAR3 = VAR3;
        this.SP4 = SP4;
        this.VAR4 = VAR4;
        this.SP5 = SP5;
        this.VAR5 = VAR5;
        this.SP6 = SP6;
        this.VAR6 = VAR6;
        this.SP7 = SP7;
        this.VAR7 = VAR7;
        this.SP8 = SP8;
        this.VAR8 = VAR8;
        this.SP9 = SP9;
        this.VAR9 = VAR9;
        this.SP10 = SP10;
        this.VAR10 = VAR10;
        this.SP11 = SP11;
        this.VAR11 = VAR11;
        this.SP12 = SP12;
        this.VAR12 = VAR12;
        this.SP13 = SP13;
        this.VAR13 = VAR13;
        this.SP14 = SP14;
        this.VAR14 = VAR14;
        this.SP15 = SP15;
        this.VAR15 = VAR15;
        this.SP16 = SP16;
        this.VAR16 = VAR16;
        this.SP17 = SP17;
        this.VAR17 = VAR17;
        this.SP18 = SP18;
        this.VAR18 = VAR18;
        this.SP19 = SP19;
        this.VAR19 = VAR19;
        this.VARESP = VARESP;
    }

    public CCheckBox() {
        this.ID = "";
        this.MODULO = "";
        this.NUMERO = "";
        this.PAGINA = "";
        this.PREGUNTA = "";
        this.SP1 = "";
        this.VAR1 = "";
        this.SP2 = "";
        this.VAR2 = "";
        this.SP3 = "";
        this.VAR3 = "";
        this.SP4 = "";
        this.VAR4 = "";
        this.SP5 = "";
        this.VAR5 = "";
        this.SP6 = "";
        this.VAR6 = "";
        this.SP7 = "";
        this.VAR7 = "";
        this.SP8 = "";
        this.VAR8 = "";
        this.SP9 = "";
        this.VAR9 = "";
        this.SP10 = "";
        this.VAR10 = "";
        this.SP11 = "";
        this.VAR11 = "";
        this.SP12 = "";
        this.VAR12 = "";
        this.SP13 = "";
        this.VAR13 = "";
        this.SP14 = "";
        this.VAR14 = "";
        this.SP15 = "";
        this.VAR15 = "";
        this.SP16 = "";
        this.VAR16 = "";
        this.SP17 = "";
        this.VAR17 = "";
        this.SP18 = "";
        this.VAR18 = "";
        this.SP19 = "";
        this.VAR19 = "";
        this.VARESP = "";
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getMODULO() {
        return MODULO;
    }

    public void setMODULO(String MODULO) {
        this.MODULO = MODULO;
    }

    public String getNUMERO() {
        return NUMERO;
    }

    public void setNUMERO(String NUMERO) {
        this.NUMERO = NUMERO;
    }

    public String getPAGINA() {
        return PAGINA;
    }

    public void setPAGINA(String PAGINA) {
        this.PAGINA = PAGINA;
    }

    public String getPREGUNTA() {
        return PREGUNTA;
    }

    public void setPREGUNTA(String PREGUNTA) {
        this.PREGUNTA = PREGUNTA;
    }

    public String getSP1() {
        return SP1;
    }

    public void setSP1(String SP1) {
        this.SP1 = SP1;
    }

    public String getVAR1() {
        return VAR1;
    }

    public void setVAR1(String VAR1) {
        this.VAR1 = VAR1;
    }

    public String getSP2() {
        return SP2;
    }

    public void setSP2(String SP2) {
        this.SP2 = SP2;
    }

    public String getVAR2() {
        return VAR2;
    }

    public void setVAR2(String VAR2) {
        this.VAR2 = VAR2;
    }

    public String getSP3() {
        return SP3;
    }

    public void setSP3(String SP3) {
        this.SP3 = SP3;
    }

    public String getVAR3() {
        return VAR3;
    }

    public void setVAR3(String VAR3) {
        this.VAR3 = VAR3;
    }

    public String getSP4() {
        return SP4;
    }

    public void setSP4(String SP4) {
        this.SP4 = SP4;
    }

    public String getVAR4() {
        return VAR4;
    }

    public void setVAR4(String VAR4) {
        this.VAR4 = VAR4;
    }

    public String getSP5() {
        return SP5;
    }

    public void setSP5(String SP5) {
        this.SP5 = SP5;
    }

    public String getVAR5() {
        return VAR5;
    }

    public void setVAR5(String VAR5) {
        this.VAR5 = VAR5;
    }

    public String getSP6() {
        return SP6;
    }

    public void setSP6(String SP6) {
        this.SP6 = SP6;
    }

    public String getVAR6() {
        return VAR6;
    }

    public void setVAR6(String VAR6) {
        this.VAR6 = VAR6;
    }

    public String getSP7() {
        return SP7;
    }

    public void setSP7(String SP7) {
        this.SP7 = SP7;
    }

    public String getVAR7() {
        return VAR7;
    }

    public void setVAR7(String VAR7) {
        this.VAR7 = VAR7;
    }

    public String getSP8() {
        return SP8;
    }

    public void setSP8(String SP8) {
        this.SP8 = SP8;
    }

    public String getVAR8() {
        return VAR8;
    }

    public void setVAR8(String VAR8) {
        this.VAR8 = VAR8;
    }

    public String getSP9() {
        return SP9;
    }

    public void setSP9(String SP9) {
        this.SP9 = SP9;
    }

    public String getVAR9() {
        return VAR9;
    }

    public void setVAR9(String VAR9) {
        this.VAR9 = VAR9;
    }

    public String getSP10() {
        return SP10;
    }

    public void setSP10(String SP10) {
        this.SP10 = SP10;
    }

    public String getVAR10() {
        return VAR10;
    }

    public void setVAR10(String VAR10) {
        this.VAR10 = VAR10;
    }

    public String getSP11() {
        return SP11;
    }

    public void setSP11(String SP11) {
        this.SP11 = SP11;
    }

    public String getVAR11() {
        return VAR11;
    }

    public void setVAR11(String VAR11) {
        this.VAR11 = VAR11;
    }

    public String getSP12() {
        return SP12;
    }

    public void setSP12(String SP12) {
        this.SP12 = SP12;
    }

    public String getVAR12() {
        return VAR12;
    }

    public void setVAR12(String VAR12) {
        this.VAR12 = VAR12;
    }

    public String getSP13() {
        return SP13;
    }

    public void setSP13(String SP13) {
        this.SP13 = SP13;
    }

    public String getVAR13() {
        return VAR13;
    }

    public void setVAR13(String VAR13) {
        this.VAR13 = VAR13;
    }

    public String getSP14() {
        return SP14;
    }

    public void setSP14(String SP14) {
        this.SP14 = SP14;
    }

    public String getVAR14() {
        return VAR14;
    }

    public void setVAR14(String VAR14) {
        this.VAR14 = VAR14;
    }

    public String getSP15() {
        return SP15;
    }

    public void setSP15(String SP15) {
        this.SP15 = SP15;
    }

    public String getVAR15() {
        return VAR15;
    }

    public void setVAR15(String VAR15) {
        this.VAR15 = VAR15;
    }

    public String getSP16() {
        return SP16;
    }

    public void setSP16(String SP16) {
        this.SP16 = SP16;
    }

    public String getVAR16() {
        return VAR16;
    }

    public void setVAR16(String VAR16) {
        this.VAR16 = VAR16;
    }

    public String getSP17() {
        return SP17;
    }

    public void setSP17(String SP17) {
        this.SP17 = SP17;
    }

    public String getVAR17() {
        return VAR17;
    }

    public void setVAR17(String VAR17) {
        this.VAR17 = VAR17;
    }

    public String getSP18() {
        return SP18;
    }

    public void setSP18(String SP18) {
        this.SP18 = SP18;
    }

    public String getVAR18() {
        return VAR18;
    }

    public void setVAR18(String VAR18) {
        this.VAR18 = VAR18;
    }

    public String getSP19() {
        return SP19;
    }

    public void setSP19(String SP19) {
        this.SP19 = SP19;
    }

    public String getVAR19() {
        return VAR19;
    }

    public void setVAR19(String VAR19) {
        this.VAR19 = VAR19;
    }

    public String getVARESP() {
        return VARESP;
    }

    public void setVARESP(String VARESP) {
        this.VARESP = VARESP;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues(43);
        contentValues.put(SQLConstantesComponente.CHECKBOX_ID,ID);
        contentValues.put(SQLConstantesComponente.CHECKBOX_MODULO,MODULO);
        contentValues.put(SQLConstantesComponente.CHECKBOX_NUMERO,NUMERO);
        contentValues.put(SQLConstantesComponente.CHECKBOX_PAGINA,PAGINA);
        contentValues.put(SQLConstantesComponente.CHECKBOX_PREGUNTA,PREGUNTA);
        contentValues.put(SQLConstantesComponente.CHECKBOX_SP1,SP1);
        contentValues.put(SQLConstantesComponente.CHECKBOX_VAR1,VAR1);
        contentValues.put(SQLConstantesComponente.CHECKBOX_SP2,SP2);
        contentValues.put(SQLConstantesComponente.CHECKBOX_VAR2,VAR2);
        contentValues.put(SQLConstantesComponente.CHECKBOX_SP3,SP3);
        contentValues.put(SQLConstantesComponente.CHECKBOX_VAR3,VAR3);
        contentValues.put(SQLConstantesComponente.CHECKBOX_SP4,SP4);
        contentValues.put(SQLConstantesComponente.CHECKBOX_VAR4,VAR4);
        contentValues.put(SQLConstantesComponente.CHECKBOX_SP5,SP5);
        contentValues.put(SQLConstantesComponente.CHECKBOX_VAR5,VAR5);
        contentValues.put(SQLConstantesComponente.CHECKBOX_SP6,SP6);
        contentValues.put(SQLConstantesComponente.CHECKBOX_VAR6,VAR6);
        contentValues.put(SQLConstantesComponente.CHECKBOX_SP7,SP7);
        contentValues.put(SQLConstantesComponente.CHECKBOX_VAR7,VAR7);
        contentValues.put(SQLConstantesComponente.CHECKBOX_SP8,SP8);
        contentValues.put(SQLConstantesComponente.CHECKBOX_VAR8,VAR8);
        contentValues.put(SQLConstantesComponente.CHECKBOX_SP9,SP9);
        contentValues.put(SQLConstantesComponente.CHECKBOX_VAR9,VAR9);
        contentValues.put(SQLConstantesComponente.CHECKBOX_SP10,SP10);
        contentValues.put(SQLConstantesComponente.CHECKBOX_VAR10,VAR10);
        contentValues.put(SQLConstantesComponente.CHECKBOX_SP11,SP11);
        contentValues.put(SQLConstantesComponente.CHECKBOX_VAR11,VAR11);
        contentValues.put(SQLConstantesComponente.CHECKBOX_SP12,SP12);
        contentValues.put(SQLConstantesComponente.CHECKBOX_VAR12,VAR12);
        contentValues.put(SQLConstantesComponente.CHECKBOX_SP13,SP13);
        contentValues.put(SQLConstantesComponente.CHECKBOX_VAR13,VAR13);
        contentValues.put(SQLConstantesComponente.CHECKBOX_SP14,SP14);
        contentValues.put(SQLConstantesComponente.CHECKBOX_VAR14,VAR14);
        contentValues.put(SQLConstantesComponente.CHECKBOX_SP15,SP15);
        contentValues.put(SQLConstantesComponente.CHECKBOX_VAR15,VAR15);
        contentValues.put(SQLConstantesComponente.CHECKBOX_SP16,SP16);
        contentValues.put(SQLConstantesComponente.CHECKBOX_VAR16,VAR16);
        contentValues.put(SQLConstantesComponente.CHECKBOX_SP17,SP17);
        contentValues.put(SQLConstantesComponente.CHECKBOX_VAR17,VAR17);
        contentValues.put(SQLConstantesComponente.CHECKBOX_SP18,SP18);
        contentValues.put(SQLConstantesComponente.CHECKBOX_VAR18,VAR18);
        contentValues.put(SQLConstantesComponente.CHECKBOX_SP19,SP19);
        contentValues.put(SQLConstantesComponente.CHECKBOX_VAR19,VAR19);
        contentValues.put(SQLConstantesComponente.CHECKBOX_VARESP,VARESP);
        return contentValues;
    }
}
