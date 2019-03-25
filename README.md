# Desafio Solutis

Projeto composto de API restfull e um client para avaliação de conhecimento da empresa Solutis. Utilizando a seguinte stack: 

  - Java 11
  - Spring Boot v2.1.3.RELEASE
  - Spring Data
  - Angular 6

Desenvolver uma API (Restful) simples que receba uma requisição HTTP com uma string, e encontre o primeiro caractere Vogal, após uma consoante, onde a mesma é antecessora a uma vogal e que não se repita na string.

Exemplo:
Input:  aAbBABacafe
Output: e
No exemplo, ‘e’ é o primeiro caractere Vogal da stream que não se repete após a primeira Consoante ‘f’o qual tem uma vogal ‘a’ como antecessora.

O resultado do processamento deverá ser igual á:
```sh
{
  "palavra": " aAbBABacafe",
  "vogal": "e",
  "tempoTotal": "10ms"
}
```

### Tecnologias Necessárias

Abaixo segue a lista de tecnologias nescessárias para rodar o projeto.

* [JDK 11]
* [Maven v3.5+]
* [Node.js v8+]
* [PostgreSQL]  

Se preferir rodar em um banco de memória - h2 -, navegue até o arquivo application.properties, comente a conexão com o PostgreSQL e descomente a conexão com o h2.

Caso tenha dúvida de como instalar, recomendo procurar pelo tutorial especifico de cada tecnologia no repositório: [Como instalar XYZ].

### Run Project

Instruções para subir o projeto localmente, primeiros subiremos a API e em seguida o client.

#### Run API

Digite os seguinte comando através do terminal/cmd, acessando o diretório raiz do projeto da API: demo-api-restfull. 
```sh
$ mvn clean install
$ mvn spring-boot:run
```

#### Run Client

Digite os seguinte comando através do terminal/cmd, acessando o diretório raiz do projeto cliente em Angular: client-app.
```sh
$ npm install
$ ng build
$ ng serve
```

Agora acesse o projeto pelo seguinte link: http://localhost:4200



  [JDK 11]: <https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html>
  [Maven v3.5+]: <https://maven.apache.org/download.cgi>
  [Node.js v8+]: <https://nodejs.org/en/>
  [Como Instalar XYZ]: <https://github.com/backend-br/como-instalar-xyz>
  [PostgreSQL]: <https://www.postgresql.org/download/>



