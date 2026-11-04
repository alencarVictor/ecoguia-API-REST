# EcoGuia API

🔗 **Deploy:** https://ecoguia-api-rest.onrender.com
📄 **Documentação (PDF):** doc/EcoGuia-Documentacao.pdf

API RESTful em Java com Spring Boot e banco Oracle, desenvolvida para a Sprint 4 (FIAP). Gerencia avatares, badges, usuários e conquistas da aplicação de gamificação EcoGuia, consumida por um front-end em React.

## Tecnologias

- Java 21
- Spring Boot 4.1.2 (Web MVC e Bean Validation)
- Oracle Database (JDBC / ojdbc17)
- Maven
- Docker

## Arquitetura

Organização em camadas, no padrão **Resource → BO → DAO → TO**:

| Camada | Responsabilidade |
|---|---|
| `resource` | Endpoints REST, status HTTP e CORS |
| `bo` | Regras de negócio |
| `dao` | Acesso ao banco via JDBC |
| `to` | Objetos de transferência e validações |

## Documentação

Toda a documentação do projeto está na pasta [`doc/`](doc/): PDF final com endpoints, diagramas e passo a passo.

## Estrutura do projeto

```
ecoguia/
├── doc/
│   └── EcoGuia-Documentacao.pdf
├── src/
│   ├── main/
│   │   ├── java/br/com/fiap/
│   │   │   ├── EcoguiaApplication.java
│   │   │   ├── bo/
│   │   │   │   ├── AvatarBO.java
│   │   │   │   ├── BadgeBO.java
│   │   │   │   ├── ConquistaBO.java
│   │   │   │   └── UsuarioBO.java
│   │   │   ├── dao/
│   │   │   │   ├── AvatarDAO.java
│   │   │   │   ├── BadgeDAO.java
│   │   │   │   ├── ConnectionFactory.java
│   │   │   │   ├── ConquistaDAO.java
│   │   │   │   └── UsuarioDAO.java
│   │   │   ├── resource/
│   │   │   │   ├── AvatarResource.java
│   │   │   │   ├── BadgeResource.java
│   │   │   │   ├── ConquistaResource.java
│   │   │   │   ├── CorsFilter.java
│   │   │   │   └── UsuarioResource.java
│   │   │   └── to/
│   │   │       ├── AvatarTO.java
│   │   │       ├── BadgeTO.java
│   │   │       ├── ConquistaTO.java
│   │   │       └── UsuarioTO.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/java/br/com/fiap/
│       └── EcoguiaApplicationTests.java
├── Dockerfile
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

## Configuração do banco

As credenciais do Oracle não ficam no código. Configure as variáveis de ambiente antes de iniciar a API:

| Variável | Descrição |
|---|---|
| `DB_URL` | URL JDBC do banco |
| `DB_USER` | Usuário do banco |
| `DB_PASSWORD` | Senha do banco |

## Testes

Os endpoints foram testados localmente (Insomnia), com a API conectada ao banco Oracle.

## Equipe

- Ana Paula Cunha Brum
- Gabriella Serni Ponzetta
- Julio Cesar Iwata de Oliveira Barros
- Rafel Santos Dias
- Victor Felipe Silva Alencar
