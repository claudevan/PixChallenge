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

## Contributing

We welcome contributions to improve and expand this project. If you have new features, bug fixes, or improvements, please follow these steps:

1.  **Fork the repository.**
2.  **Create a new branch** for your changes: `git checkout -b feature/your-feature-name` or `bugfix/your-bug-fix-name`.
3.  **Make your changes**, ensuring to follow the project's coding style and best practices.
4.  **Write unit tests** for any new functionality or bug fixes.
5.  **Ensure all tests pass** before submitting your changes.
6.  **Commit your changes** with a clear and descriptive commit message.
7.  **Push your changes** to your forked repository.
8.  **Submit a pull request** to the main repository for review.

### Developing New Features

When contributing a new feature, please follow this workflow:

1.  **Create a feature branch:** Before starting development, create a new branch from the `main` (or `develop` if applicable) branch. Name your branch descriptively, prefixed with `feature/`, for example:
    ```bash
    git checkout -b feature/awesome-new-feature
    ```
2.  **Develop the feature:** Implement your feature, adhering to the project's coding standards and conventions.
3.  **Write unit tests:** It's crucial to write comprehensive unit tests for your new feature. Ensure that your tests cover various scenarios, including edge cases.
4.  **Test thoroughly:** Run all tests (including your new ones) to ensure that your changes haven't introduced any regressions.
    ```bash
    mvn test
    ```
5.  **Update documentation:** If your feature introduces new functionality, changes existing behavior, or modifies the API, please update any relevant documentation. This may include:
    *   This `README.md` file.
    *   API documentation (e.g., Swagger/OpenAPI specifications if used).
    *   Code comments and inline documentation.
6.  **Submit a Pull Request:** Once your feature is complete, tested, and documented, push your feature branch to your fork. Then, submit a pull request against the `main` branch of the upstream repository. Provide a clear description of the feature and any changes made in your pull request.

### Setting up the Development Environment

To set up the development environment, you will need the following installed:

*   Java 22
*   Maven
*   Docker (for running MySql or other services if not installed locally)

**Steps:**

1.  **Clone the repository:** `git clone https://github.com/username/repository.git` (replace 'username/repository.git' with the actual path to this project's repository)
2.  **Navigate to the project directory:** `cd repository` (Note: the directory name will match the 'repository' part of the clone URL. Please update if the actual repository name is different, e.g., `cd desafio-cadastro-de-chave-pix`)
3.  **Build the project using Maven:** `mvn clean install`
4.  **Set up MySql:**
    *   You can run MySql using Docker: `docker run --name mysql-pix -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=pix_db -p 3306:3306 -d mysql:latest`
    *   Or, ensure you have a local MySql instance running and configured.
5.  **Configure application properties:**
    *   Create or update `src/main/resources/application.properties` (or `application.yml`) with your database connection details:
        ```properties
        spring.datasource.url=jdbc:mysql://localhost:3306/pix_db
        spring.datasource.username=root
        spring.datasource.password=root
        spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
        spring.jpa.hibernate.ddl-auto=update
        spring.jpa.show-sql=true
        ```

### Running the Application

Once the development environment is set up, you can run the Spring Boot application using Maven:

```bash
mvn spring-boot:run
```

The application will typically be available at `http://localhost:8080`.

### Running Tests

To run the unit tests for the project, use the following Maven command:

```bash
mvn test
```

Ensure all tests pass before contributing your changes.
