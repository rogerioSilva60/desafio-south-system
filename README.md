# desafio-south-system

## Configuração

Para executar o projeto, será necessário instalar os seguintes programas:

- [JDK 11: Necessário para executar o projeto Java](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Maven 3.5.4: Necessário para realizar o build do projeto Java](https://maven.apache.org/docs/3.5.4/release-notes.html)
- [Spring Tools 4 for Eclipse: Para desenvolvimento do projeto](https://spring.io/tools)

Para executar o projeto, é necessário utilizar o Spring Tools 4 for Eclipse, para que o mesmo identifique as dependências necessárias para a execução no repositório .m2 do Maven. Uma vez importado o projeto, será criado um arquivo *.classpath* que irá informar qual a classe principal para a execução.

### Gerenciamento dos arquivos de leitura

  Para o funcionamento da leitura dos arquivos é necessário adicionar o caminho do diretório raiz na variável de ambiente do SO com o nome HOME_PATH, dentro da raiz deve existir pelo menos o diretório data/in com o arquivo .dat para poder o sistema ler o arquivo e transferir para data/out com os valores requisitados. 
  
![variavel-de-ambiente](https://user-images.githubusercontent.com/23174611/93826118-efd25e00-fc3c-11ea-92b0-bd4e90c7674c.png)

## Teste da documentação

Por fim, basta acessar a url: http://localhost:8080/swagger-ui.html#/ na máquina que esteja executando o projeto, Terá a documentacao da api pelo Swagger.

![desafio-south-system](https://user-images.githubusercontent.com/23174611/93825270-4d65ab00-fc3b-11ea-9548-9721242c8a81.png)
