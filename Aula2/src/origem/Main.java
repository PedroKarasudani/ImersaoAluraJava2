package origem;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class Main {
    
    public static final String PURPLE_BACKGROUND = "\033[45m";

    public static void main(String[] args) throws InterruptedException, IOException, Exception {
        //Fazer uma conexão HTTP e buscar os 250 filmes
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI endereco = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        
        //Extrair somente os dados que interresa(titulo, poster, classifição)
        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDosFilmes = parser.parse(body);
        
        //Exibir dados
        GeradorDeFigurinhas geradora = new GeradorDeFigurinhas();
        
        for (Map<String, String> filme : listaDosFilmes) {
          
            String urlImagem = filme.get("image");
            String titulo = filme.get("title");
            String nota = filme.get("imDbRating");
            
            InputStream inputStream = new URL(urlImagem).openStream();
            String nomeArquivo = titulo + ".png";

            geradora.cria(inputStream, nomeArquivo, titulo, nota);
            
            System.out.println(titulo);
            
            System.out.println(" ");
            
            
        }
            
        }
    }

