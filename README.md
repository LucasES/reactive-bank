# crud-dynamodb

CRUD utilizando spring webflux e r2dbc mysql para trabalhar com reatividade.
## Sobre

Este projeto tem como objetivo criar um CRUD utilizando Spring Boot WebFlux e Mysql com biblioteca R2DBC.
O projeto trata-se de um projeto de banco onde é possível realizar algumas operações simulando um sistema bancário.


## Criado com

* 	[Maven](https://www.docker.com/) - Docker
* 	[Docker](https://maven.apache.org/) - Dependency Management
* 	[JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Java™ Platform, Standard Edition Development Kit
* 	[Spring Boot](https://spring.io/projects/spring-boot) - Framework to ease the bootstrapping and development of new Spring Applications
* 	[r2dbc-mysql](https://github.com/mirromutth/r2dbc-mysql) - Reactive driver to connect Mysql connection
* 	[spring-boot-starter-data-r2dbc](https://spring.io/guides/gs/accessing-data-r2dbc/) - Sring data reactive dependency.
* 	[Lombok](https://projectlombok.org/) - Never write another getter or equals method again, with one annotation your class has a fully featured builder, Automate your logging variables, and much more.
* 	[modelmapper](http://modelmapper.org/) - The goal of ModelMapper is to make object mapping easy, by automatically determining how one object model maps to another, based on conventions, in the same way that a human would - while providing a simple, refactoring-safe API for handling specific use cases.
* 	[Swagger](https://swagger.io/) - Open-Source software framework backed by a large ecosystem of tools that helps developers design, build, document, and consume RESTful Web services.

## Ferramentas externas

* [Postman](https://www.getpostman.com/) - API Development Environment (Testing Docmentation)
* [IntelliJ IDEA](https://www.jetbrains.com/idea/download) - Java IDEA

### Pré-requisitos

Para instalar e executar a API é preciso instalar:

- [JDK 11](https://www.oracle.com/br/java/technologies/javase-jdk11-downloads.html)
- [Maven 3](https://maven.apache.org)
- [GIT](https://git-scm.com/downloads)

## Clonando o projeto

Primeiramente, devemos realizar o clone do projeto através do comando:

```sh
git clone https://github.com/LucasES/reactive-bank.git
```

Ou acessar a URL: https://github.com/LucasES/reactive-bank e realizar o download do projeto no formato zip e realizar a extração do arquivo.

## Executando a aplicação local

Existem várias maneiras de executar um aplicativo Spring Boot em sua máquina local. Uma maneira é executar o método `main` na classe `br.com.reactivebank.ReactiveBankApplication` do IDE.

Como alternativa, você pode usar o [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) e executar o seguinte comando na pasta do projeto onde localiza-se o arquivo pom.xml:

```shell
mvn spring-boot:run
```

### Swagger

A documentação da API poderá ser acessada após a execução do projeto na seguinte URL:

```sh
http://localhost:8080/api/swagger-ui/index.html#/
```

## Arquivos e diretórios

O projeto `reactive-bank` possui uma estrutura de diretórios específica.

Um projeto representativo é representado abaixo:

 ```
 .
 ├── Spring Elements
 ├── src
 │   └── main
 │       └── java
 │           ├── br.com.reactivebank.ReactiveBankApplication
 │           ├── br.com.reactivebank.config
 │           ├── br.com.reactivebank.controller
 │           ├── br.com.reactivebank.domain
 │           ├── br.com.reactivebank.dto
 │           ├── br.com.reactivebank.enums
 │           └── br.com.reactivebank.exception
 │           └── br.com.reactivebank.handler
 │           └── br.com.reactivebank.repository
 │           └── br.com.reactivebank.service
 │           └── br.com.reactivebank.util
 ├── src
 │   └── main
 │       └── resources
 │           ├── application.properties
 ├── src
 │   └── test
 │       └── java
 ├── JRE System Library
 ├── Maven Dependencies
 ├── bin
 ├── src
 ├── target
 │   └──reactive-bank-0.0.1.jar
 ├── mvnw
 ├── mvnw.cmd
 ├── pom.xml
 └── README.md
 ```
## Pacotes

- `config` — Pacote responsável em centralizar as configurações do projeto.
- `controller` — Camada responsável em externalizar as API's;
- `dto` — Camada responsável em externalizar as classes de Data Transfer Object.
- `enums` — Camada responsável em externalizar Enums do projeto.
- `exception` — Pacote responsável em centralizar as classes de POJO para mapear objeto de resposta utilizados no Exception Handler.
- `handler` — Pacote responsável em centralizar as classes que manipulam o exception handler do projeto.
- `model` — Camada de modelo responsável em centralizar as entidades do projeto;
- `repository` — Camada responsável para se comunicar com o banco de dados;
- `util` — Camada responsável em centralizar todos as classes de util que poderão ser utilizadas em todo o projeto.
- `service` — Camada responsável em centralizar a lógica de negócio do sistema;
- `resources/` - Contém todos os recursos estáticos, modelos e arquivos de propriedades.
- `resources/application.properties` - Ele contém propriedades para todo o aplicativo. O Spring lê as propriedades definidas neste arquivo para configurar seu aplicativo. Você pode definir a porta padrão do servidor, o caminho de contexto do servidor, os URLs do banco de dados etc., neste arquivo.

- `test/` - centraliza os testes unitários do projeto

- `pom.xml` - arquivo responsável em centralizar as dependências do projeto.


## Rodando o projeto com docker
Este projeto e possível executar com docker. 

Para isso siga os passos abaixo
 ```
 1. Faça um clone do projeto.
 2. Execute o comando:
    docker build -t reactive-bank .
 3. Após finalizar o comando anterior execute:
    docker-compose up -d
  ```

## Contribuição

Por favor, leia [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) para obter detalhes sobre nosso código de conduta e o processo de envio de solicitações pull requests.

## Autores

* **Lucas Araújo** - *projeto inicial* - [LucasES](https://github.com/LucasES)

## Licença

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details