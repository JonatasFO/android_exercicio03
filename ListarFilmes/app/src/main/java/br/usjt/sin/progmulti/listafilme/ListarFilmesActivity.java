package br.usjt.sin.progmulti.listafilme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * @author Jônatas Ferreira de Oliveira RA: 818231518
 */

public class ListarFilmesActivity extends Activity {

    public static final String DESCRICAO = "br.usjt.sin.progmulti.listafilme.descricao";
    ArrayList<String> lista;
    Activity atividade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_filmes);
        atividade = this;
        Intent intent = getIntent();
        String chave = intent.getStringExtra(MainActivity.NOME);
        lista = buscaChamados(chave);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, lista);
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {

                Intent intent = new Intent(atividade, DetalheFilmeActivity.class);
                intent.putExtra(DESCRICAO, lista.get(position));
                startActivity(intent);
                }
        });
    }
    public ArrayList<String> buscaChamados(String chave){
        ArrayList<String> lista = geraListaFilmes();
        if (chave == null || chave.length() == 0){
            return lista;
        } else {
            ArrayList<String> subLista = new ArrayList<>();
            for(String nome:lista){
                if(nome.toUpperCase().contains(chave.toUpperCase())){
                    subLista.add(nome);
                }
            }
            return subLista;
        }
    }
    public ArrayList<String> geraListaFilmes(){
        ArrayList<String> lista = new ArrayList<>();
        lista.add("O Protetor 2 - Ano de lançamento: 2018");
        lista.add("Venom - Ano de lançamento: 2018");
        lista.add("A Freira - Ano de lançamento: 2018");
        lista.add("Batman - O Cavaleiro das Trevas - Ano de lançamento: 2008");
        lista.add("Titanic - Ano de lançamento: 1997");
        lista.add("O Senhor dos Anéis: O Retorno do Rei - Ano de lançamento: 2003");
        lista.add("The Pursuit of Happyness - Ano de lançamento: 2006");
        lista.add("The Godfather - Ano de lançamento: 1972");
        lista.add("300 - Ano de lançamento: 2006");
        lista.add("Os Bad Boys - Ano de lançamento: 1995");
        return lista;
    }
}
