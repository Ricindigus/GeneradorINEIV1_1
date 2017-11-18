package pe.com.ricindigus.generadorinei.activities;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import pe.com.ricindigus.generadorinei.R;
import pe.com.ricindigus.generadorinei.fragments.CaratulaFragment;
import pe.com.ricindigus.generadorinei.fragments.CheckBoxFragment;
import pe.com.ricindigus.generadorinei.fragments.EditSumaFragment;
import pe.com.ricindigus.generadorinei.fragments.EditTextFragment;
import pe.com.ricindigus.generadorinei.fragments.RadioFragment;

public class EncuestaActivity extends AppCompatActivity {

    private EditTextFragment editTextFragment;
    private CheckBoxFragment checkBoxFragment;
    private RadioFragment radioFragment;
    private EditSumaFragment editSumaFragment;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private CaratulaFragment caratulaFragment;

    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuesta);
        toolbar = (Toolbar)findViewById(R.id.encuesta_toolbar);
        setSupportActionBar(toolbar);

        editSumaFragment = new EditSumaFragment();
        editTextFragment = new EditTextFragment();
        checkBoxFragment = new CheckBoxFragment();
        caratulaFragment = new CaratulaFragment();
        radioFragment = new RadioFragment();

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction =  fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.fragment_layout1,editSumaFragment);
//        fragmentTransaction.replace(R.id.fragment_layout2,editTextFragment);
//        fragmentTransaction.replace(R.id.fragment_layout3,checkBoxFragment);
//        fragmentTransaction.replace(R.id.fragment_layout4,radioFragment);
        fragmentTransaction.replace(R.id.fragment_layout1,caratulaFragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_encuesta,menu);
        return true;
    }
}
