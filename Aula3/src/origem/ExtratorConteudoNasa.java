package origem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorConteudoNasa implements Extrator{

    
    public List<Conteudo> extraiConteudos(String json){
        
        //Extrair somente os dados que interresa(titulo, poster, classifição)
        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);
        
        List<Conteudo> conteudos = new ArrayList<>();
        
        //popular lista de conteudos
        for (Map<String, String> atributos : listaDeAtributos) {
            String urlImagem = atributos.get("url");
            String titulo = atributos.get("title");
            
            Conteudo conteudo = new Conteudo(titulo, urlImagem);
            
            conteudos.add(conteudo);
            
        }
        
        return conteudos;
        
    }
}
