package pe.com.ricindigus.generadorinei.activities;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;

import pe.com.ricindigus.generadorinei.R;
import pe.com.ricindigus.generadorinei.componentes.componente_caratula.CaratulaFragment;
import pe.com.ricindigus.generadorinei.componentes.componente_checkbox.CheckBoxFragment;
import pe.com.ricindigus.generadorinei.componentes.componente_editsuma.EditSumaFragment;
import pe.com.ricindigus.generadorinei.componentes.componente_edittext.EditTextFragment;
import pe.com.ricindigus.generadorinei.componentes.componente_identificacion.IdentificacionFragment;
import pe.com.ricindigus.generadorinei.componentes.componente_radio.RadioFragment;
import pe.com.ricindigus.generadorinei.componentes.componente_visitas.VisitasFragment;

public class EncuestaActivity extends AppCompatActivity {

    private EditTextFragment editTextFragment;
    private CheckBoxFragment checkBoxFragment;
    private RadioFragment radioFragment;
    private EditSumaFragment editSumaFragment;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private CaratulaFragment caratulaFragment;
    private IdentificacionFragment identificacionFragment;
    private VisitasFragment visitasFragment;

    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuesta);
        toolbar = (Toolbar)findViewById(R.id.encuesta_toolbar);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.fragment_visitas_layout);
//        linearLayout.setVisibility(View.VISIBLE);
        setSupportActionBar(toolbar);

        editSumaFragment = new EditSumaFragment();
        editTextFragment = new EditTextFragment();
        checkBoxFragment = new CheckBoxFragment();
        caratulaFragment = new CaratulaFragment();
        identificacionFragment = new IdentificacionFragment();
        radioFragment = new RadioFragment();
        visitasFragment = new VisitasFragment();


        fragmentManager = getSupportFragmentManager();
        fragmentTransaction =  fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.fragment_layout1,editSumaFragment);
//        fragmentTransaction.replace(R.id.fragment_layout2,editTextFragment);
//        fragmentTransaction.replace(R.id.fragment_layout3,checkBoxFragment);
//        fragmentTransaction.replace(R.id.fragment_layout4,radioFragment);
        fragmentTransaction.replace(R.id.fragment_layout1,identificacionFragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_encuesta,menu);
        return true;
    }
}
