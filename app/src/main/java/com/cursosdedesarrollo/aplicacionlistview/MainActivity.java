package com.cursosdedesarrollo.aplicacionlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView empty;
    private ListView listado;
    private String[] elementos={"Uno","Dos"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();
    }

    private void setupViews() {
        empty=(TextView)findViewById(R.id.empty);
        listado=(ListView)findViewById(R.id.listView);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(),
                R.layout.list_item,elementos);
        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view,
                                    int position, long id) {
                Toast.makeText(getApplicationContext(),elementos[position],
                        Toast.LENGTH_SHORT).show();
            }
        });
        if(adapter.getCount()>0) {
            empty.setVisibility(View.INVISIBLE);
            listado.setVisibility(View.VISIBLE);
            listado.setAdapter(adapter);
            listado.setTextFilterEnabled(true);
        }else{
            empty.setVisibility(View.VISIBLE);
            listado.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
