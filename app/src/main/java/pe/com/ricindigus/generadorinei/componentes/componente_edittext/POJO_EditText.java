package pe.com.ricindigus.generadorinei.componentes.componente_edittext;

import android.content.ContentValues;

/**
 * Created by dmorales on 12/12/2017.
 */

public class POJO_EditText {
    private String numero;
    private String sp1;
    private String var1;
    private String sp2;
    private String var2;
    private String sp3;
    private String var3;

    public POJO_EditText() {
        numero = "";
        sp1 = "";
        var1 = "";
        sp2 = "";
        var2 = "";
        sp3 = "";
        var3 = "";
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getSp1() {
        return sp1;
    }

    public void setSp1(String sp1) {
        this.sp1 = sp1;
    }

    public String getVar1() {
        return var1;
    }

    public void setVar1(String var1) {
        this.var1 = var1;
    }

    public String getSp2() {
        return sp2;
    }

    public void setSp2(String sp2) {
        this.sp2 = sp2;
    }

    public String getVar2() {
        return var2;
    }

    public void setVar2(String var2) {
        this.var2 = var2;
    }

    public String getSp3() {
        return sp3;
    }

    public void setSp3(String sp3) {
        this.sp3 = sp3;
    }

    public String getVar3() {
        return var3;
    }

    public void setVar3(String var3) {
        this.var3 = var3;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues(7);
        return contentValues;
    }
}
