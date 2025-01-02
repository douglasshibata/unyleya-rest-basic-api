# Basic API Rest Unyleya 

Criação de uma API rest para o curso de pós graduação

**Objetivo**: Implementar uma API com um CRUD básico
O sistema deverá permitir as operações de CRUD através de uma API REST

## Stack utilizada

**Back-end:** Java 17

**Database**: H2


## Instalação

Instale o projeto

```bash
  ./mvnw clean package
```
    
## Rodar local

Para fazer o deploy desse projeto rode
```bash
./mvnw clean package wildfly:dev
```
Quando finalizar acessar [http://localhost:8080/basic-rest-api](http://localhost:8080/basic-rest-api).

## Swagger 
Para acessar o swagger [http://localhost:8080/basic-rest-api/swagger/](http://localhost:8080/basic-rest-api/swagger/).

## Deploy

Caso queira utilizar o docker

```bash
./mvnw clean package
docker build -t basic-rest-api:v1 .
```

```bash
docker run -it --rm -p 8080:8080 basic-rest-api:v1
```

Quando finalizar acessar [http://localhost:8080/basic-rest-api](http://localhost:8080/basic-rest-api).

## Referência

 - [Awesome Readme Templates](https://awesomeopensource.com/project/elangosundar/awesome-README-templates)
 - [Awesome README](https://github.com/matiassingers/awesome-readme)
 - [How to write a Good readme](https://bulldogjob.com/news/449-how-to-write-a-good-readme-for-your-github-project)
 - [Start Jakarta](https://start.jakarta.ee/)

