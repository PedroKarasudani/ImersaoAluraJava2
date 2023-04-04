package origem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import javax.imageio.ImageIO;
import java.lang.String;


public class GeradorDeFigurinhas {
    
    public void cria(InputStream inputStream, String nomeArquivo, String textFig, String notaFig) throws Exception{
        //leitura da imagem
        BufferedImage imagemOriginal = ImageIO.read(inputStream);
         
        //cria nova imagem em memoria com transparencia e com tamanho novos
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
        
        //copiar a imagem original para nova imagem em memoria
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);
        
        //configurar font
        Font fonte = new Font(Font.SANS_SERIF, Font.BOLD, 43);
        graphics.setColor(Color.RED);
        graphics.setFont(fonte);
        
        //escrever uma frase na nova imagem
        graphics.drawString(textFig, 80, novaAltura - 100);
        graphics.drawString("Nota:", 80, novaAltura - 50);
        graphics.drawString(notaFig, 200, novaAltura - 50);
        
        //escrever a nova imagem em um arquivo
        String nomeArquivoTratado = nomeArquivo.replace(":"," ");
        String local = "src/origem/saida/"+nomeArquivoTratado;
        ImageIO.write(novaImagem, "png", new File(local));
    }
    
}
