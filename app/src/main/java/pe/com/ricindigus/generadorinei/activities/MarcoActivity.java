package pe.com.ricindigus.generadorinei.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.R;
import pe.com.ricindigus.generadorinei.adapters.ItemMarcoAdapter;
import pe.com.ricindigus.generadorinei.pojos.PojoItemMarco;

public class MarcoActivity extends AppCompatActivity {

    private ArrayList<PojoItemMarco> items;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marco);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.marco_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setIcon(R.drawable.inei_logo_escala_grises);

        recyclerView = (RecyclerView) findViewById(R.id.marco_recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView = (RecyclerView) findViewById(R.id.marco_recycler);
        LayoutManager layoutManager = new LinearLayoutManager(MarcoActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        crearData();
        ItemMarcoAdapter itemMarcoAdapter = new ItemMarcoAdapter(items, new ItemMarcoAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(PojoItemMarco item) {
                Intent intent = new Intent(MarcoActivity.this,EncuestaActivity.class);
                intent.putExtra("codigo",item.getDato1());
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(itemMarcoAdapter);
    }

    public void crearData(){
        items = new ArrayList<PojoItemMarco>();
        items.add(new PojoItemMarco("1","campo2","campo3","campo4"));
        items.add(new PojoItemMarco("2","campo2","campo3","campo4"));
        items.add(new PojoItemMarco("3","campo2","campo3","campo4"));
        items.add(new PojoItemMarco("4","campo2","campo3","campo4"));
        items.add(new PojoItemMarco("5","campo2","campo3","campo4"));
        items.add(new PojoItemMarco("6","campo2","campo3","campo4"));
        items.add(new PojoItemMarco("7","campo2","campo3","campo4"));
        items.add(new PojoItemMarco("8","campo2","campo3","campo4"));
        items.add(new PojoItemMarco("9","campo2","campo3","campo4"));
        items.add(new PojoItemMarco("10","campo2","campo3","campo4"));
        items.add(new PojoItemMarco("11","campo2","campo3","campo4"));
        items.add(new PojoItemMarco("12","campo2","campo3","campo4"));
        items.add(new PojoItemMarco("13","campo2","campo3","campo4"));
        items.add(new PojoItemMarco("14","campo2","campo3","campo4"));
        items.add(new PojoItemMarco("15","campo2","campo3","campo4"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.marco_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_importar:
                return true;
            case R.id.menu_exportar:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
