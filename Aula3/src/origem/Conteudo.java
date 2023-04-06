package origem;


public class Conteudo {
    private final String titulo;
    private final  String urlImage;

    public Conteudo(String titulo, String urlImage) {
        this.titulo = titulo;
        this.urlImage = urlImage;
    }
   

    public String getTitulo() {
        return this.titulo;
    }

    public String getUrlImage() {
        return this.urlImage;
    }
    
     
}
