package origem;


import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class Main {

    public static final String PURPLE_BACKGROUND = "\033[45m";

    public static void main(String[] args) throws Exception {
        
        //Fazer uma conexão HTTP e buscar dados
        
        String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2023-01-11&end_date=2023-02-25";
        Extrator extrator = new ExtratorConteudoNasa();
        
//        String url = "url_erro";;
//        ExtratorConteudoImdb extrator = new ExtratorConteudoImdb();;;
        
        ClienteHttp http = new ClienteHttp();
        String json = http.buscaDados(url);
        

        //Exibir dados
        List<Conteudo> conteudos = extrator.extraiConteudos(json);
        
        GeradorDeFigurinhas geradora = new GeradorDeFigurinhas();

        for (int i = 0; i < 2; i++) {

            Conteudo conteudo = conteudos.get(i);

            InputStream inputStream = new URL(conteudo.getUrlImage()).openStream();
            String nomeArquivo = conteudo.getTitulo() + ".png";

            geradora.cria(inputStream, nomeArquivo, conteudo.getTitulo());

            System.out.println(conteudo.getTitulo());

            System.out.println(" ");

        }

    }
}
