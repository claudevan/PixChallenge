# Desafio Cadastro de chave PIX

Permitir que sejam cadastradas chaves PIX, conforme regras determinadas:

## Tecnologias Utilizadas

 - Java 22
 - Spring Boot 3.2.5
 - Maven
 - Lombok
 - MySql
 - Docker

## Tarefas

 - [x] Inclusão
 - [ ] Alteração
 - [ ] Deleção (Lógica)
 - [x] Validar dados das requisições
 - [ ] Validar regra de negócio (Validação de chaves conforme seu tipo)
 - [x] Validar quantidade de chaves máximas, de acordo com o tipo pessoa
 - [ ] Logs
 - [ ] Testes Unitários

## 12 Fatores
A solução adere aos seguintes princípios do 12 Factor App:

-   **Codebase:** Uma base de código rastreada em controle de versão, com muitas implantações.
-   **Dependencies:** Declaração explícita e isolamento de dependências.
-   **Config:** Armazenamento de configurações no ambiente.
-   **Processes:** Execução da aplicação como um ou mais processos sem estado.
-   **Port binding:** Exportação de serviços através da ligação a uma porta.
-   **Concurrency:** Escalabilidade através do modelo de processo.
-   **Disposability:** Maximização da robustez com inicialização e desligamento rápidos.
-   **Logs:** Tratamento de logs como fluxos de eventos.

## Melhorias futuras

 - [ ] Utilizar Scalar, uma opção mais moderna ao Swagger, implementando uma documentação OpenApi
 - [ ] Healthy Checkes
 - [ ] Quebrar melhor os endpoints pra respeitar as regras da openapi 3.0

## Plano de estudos

Está sendo uma jornada interessante colocar em pratica um pouco do Java que já não mexia a um bom tempo e mergulhar de cabeça nos estudo pra seguir com o desafio.

 - Java 22 e suas novidades
 - Spring Boot
 - Spring Data
 - DynamoDB
 - Docker
