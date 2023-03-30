package origem;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class Main {
    
    public static final String PURPLE_BACKGROUND = "\033[45m";

    public static void main(String[] args) throws InterruptedException, IOException {
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
        for (Map<String, String> filme : listaDosFilmes) {
            System.out.print("Titulo: ");
            System.out.println(filme.get("title"));
            
            System.out.print("Imagem: ");
            System.out.println(filme.get("image"));
            
            System.out.print("Classificação: ");
            System.out.println(PURPLE_BACKGROUND + filme.get("imDbRating"));
            float avaliacao = Float.parseFloat(filme.get("imDbRating"));
            int numeroDeEstrela = Math.round(avaliacao);
            
            for (int CC=0; CC<numeroDeEstrela; CC++) {
                System.out.print("\u2605");
            }
            System.out.println(" ");
            System.out.println(" ");
            
            
        }
            
        }
    }

