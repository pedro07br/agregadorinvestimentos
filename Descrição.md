O projeto foi desenvolvido com Spring Boot e utiliza Hibernate como provedor de persistência JPA (Java Persistence API) para realizar a integração entre a aplicação Java e o banco de dados MySQL.

A configuração da conexão é feita através do arquivo application.properties, onde são definidos os parâmetros de acesso ao banco, como a URL de conexão, usuário, senha, e o dialeto do Hibernate 
(MySQL8Dialect). A propriedade spring.jpa.hibernate.ddl-auto=update foi utilizada para permitir que o Hibernate crie e atualize automaticamente as tabelas conforme as entidades da aplicação.

O banco de dados MySQL foi executado dentro de um container Docker, garantindo um ambiente isolado e padronizado, facilitando a replicação do ambiente em outras máquinas. A imagem oficial do 
MySQL foi utilizada, e as portas foram expostas para que a aplicação Java pudesse se conectar ao banco de dados dentro do container.

As entidades da aplicação são mapeadas com anotações JPA, como @Entity, @Id, @GeneratedValue e outras. O acesso aos dados foi feito por meio de interfaces que estendem JpaRepository, fornecendo 
uma camada de abstração que facilita operações como salvar, buscar, editar e deletar dados.

Durante o desenvolvimento e testes da API, foi utilizada a ferramenta Insomnia, que permitiu enviar requisições HTTP (GET, POST, PUT, DELETE) e validar as respostas da aplicação em tempo real, 
garantindo o correto funcionamento dos endpoints.

Todo o código foi escrito e organizado utilizando a IDE IntelliJ IDEA, que forneceu suporte à autocompletação, debug, execução local e integração com o Maven e Docker, otimizando o processo 
de desenvolvimento.

Essa arquitetura e conjunto de ferramentas proporcionaram um ambiente de desenvolvimento completo, estável e eficiente, com foco em boas práticas e manutenibilidade do sistema.
