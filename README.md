# ImersaoAluraJava2

- Aula1 - Construindo uma API de filmes com Java

Ultilizando o API do IMDB retornando os "250 Melhores filmes".
	
Foi ultilizado a biblioteca java.net para obter esses dados dentro da IDE.
	
Para tratamento dos dados foi criado uma classes JsonParser.
 
Resultado:

![image](https://user-images.githubusercontent.com/128757305/228695478-dc42b1c5-a9e0-4e73-9735-58c1a69aed0f.png)



- Aula2 - Gerando figurinhas

Foi criado uma classe GeradorDeFigurinhas com somente um metodo cria(...)

Para criação dessa classe, ultilizamos algumas bibliotecas muito importante como:

-java.io, java.ImageIO, para leitura e gravação da imagem
-java.awt, para estilização da imagem

As imagens geradas em .png foram salvas na pasta /saida, sendo possivel usar como figurinhas, e nelas possuem o texto com o titulo do filmes e classificaçao

Resultado: 

![image](https://user-images.githubusercontent.com/128757305/229680864-7ee1b764-18d1-4344-a184-03b25009f677.png)



- Aula3 - Refatorando o codigo

Nessa aula foi feito a refatoração do codigo, criando novas classe como: 

-Classe ClienteHttp: aonde vamos fazer a leitura da API e devolve um json em String.

-Classe Conteudo: que serve para comunicação de dados, para classe ExtratorConteudoNasa e ExtratorConteudoImdb.

-Classe ExtratorConteudoNasa e ExtratorConteudoImdb: filtra o necessario da String em json





