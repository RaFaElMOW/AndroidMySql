package com.example.a3ainfo.mysql_livrob;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ConsultarActivity extends AppCompatActivity {
    ListView listViewLivro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar);

        listViewLivro = (ListView) findViewById(R.id.listVIewLivro);
        DaoLivro daoLivro = new DaoLivro();
        ArrayList<DtoLIvro> listLivro = daoLivro.consultar();
        ArrayAdapter adapter = new ArrayAdapter(ConsultarActivity.this, android.R.layout.simple_list_item_1, listLivro);
        listViewLivro.setAdapter(adapter);

    }
}
