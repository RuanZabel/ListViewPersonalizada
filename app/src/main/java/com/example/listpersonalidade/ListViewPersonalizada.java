package com.example.listpersonalidade;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


import com.example.listpersonalidade.R;
import com.example.listpersonalidade.Fruta;
import com.example.listpersonalidade.Frutas;
import com.example.listpersonalidade.Fruta;
import com.example.listpersonalidade.FrutaListAdapter;

public class ListViewPersonalizada extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listagem_frutas);

        //Associando a variavel local listView a o objeto instaciado no layout com id listView
        ListView listView = findViewById(R.id.list);

        //Carregando Dados predefinidos chamando o controlador Frutas e solicitando a lista de frutas
        Frutas frutas= new Frutas();


        //Adiquirindo lista de frutas em um arrayList que será passado ao adapter
        final ArrayList<Fruta> listaFrutas = new ArrayList<>();
        for (Fruta f: frutas.FRUTAS) {
            listaFrutas.add(f);
        }

        /**Carregando um adapter com a estrutura das informações que configuram o ListView,
         * O Adapter tem a responsabidade de instanciar o layout definido para cada linha, para o número de dados passado no arrayList,
         * além disso ele o adapter atribui cada registro de dados os campos informados que estão no layout.
         *
         * O ArrayAdapater  saber associar 1 item de dados informado para linha do layout informado ao listView,
         * Se tivermos dois, para uma mesma linha do listView podemos utilizar o simpleAdapter, que recebe arrays,
         * como identificaores das views existentes no layout e também como nome de cada item do layout.
         * Mas de precisarmos passar três ou mais dados temos que sobreescrever a implementação do arrayAdapter
         *
         * Paramêtros
         * 1º parametro - Contexto da classe atual
         * 2º parametro - Id do recurso template do layout escolhido com três ou mais informações para apresentação
         * 3º parametro - Array de objetos que serão tratados  pelo adapter
         * */
        FrutaListAdapter adapter = new FrutaListAdapter(this,
                R.layout.listagem_frutas,
                listaFrutas);


        //Solicita ao listView que carregue o layout e dados passados no arrayAdapter e apresente
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String valorTexto = listaFrutas.get(position).getNome();
                Toast.makeText(getBaseContext(), valorTexto,Toast.LENGTH_LONG ).show();
            }
        });
    }
}