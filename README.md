# Curso Essencial de JSF e Primefaces

Curso de JSF e Primefaces desenvolvido e ministrado pela AlgaWorks.

## Informações sobre o projeto

Este projeto é um simples cadastro de empresas, que aborda um CRUD completo utilizando JSF e JPA.

| Projeto                     | Curso JSF e Primefaces Essencial                    |
| --------------------------- | --------------------------------------------------- |
| **Nome do Projeto**         | Curso JSF e PrimeFaces (curso-jsf-e-primefaces)     |
| **Tecnologias**             | <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" height=30 /> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/tomcat/tomcat-original.svg" height=30 /> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/mysql/mysql-original-wordmark.svg"  height=30 /> |
| **Link no GitHub**          | https://github.com/Bambatera/curso-jsf-e-primefaces |
| **Situação**                | Indisponível                                        |
| **URL de Acesso**           | Indisponível                                        |
| **Versão Atual**            | 0.0.1                                               |
| **Front-end**               | [Primefaces](https://www.primefaces.org/gettingstarted/) 6.0 |
| **Back-end**                | Java 1.8 / JavaEE 7                                 |
| **Servidor de Aplicação**   | Tomcat 8.5                                          |

### Principais Dependências

- Apache POI
- JBoss Weld
- Javax Faces
- Primefaces
- Hibernate
- MySQL JDBC Driver

### Recursos Iniciais

Inicialmente, o projeto deveria criar automaticamente o banco de dados de acordo com as configurações existentes no `persistence.xml`.
Porém, devido algum problema com a versão do driver do MySQL, a criação do banco de dados e suas tabelas não ocorreram.
Dessa forma, o banco de dados e suas tabelas foram criados manualmente, utilizando o MySQL Workbench.

A carga de dados inicial pode ser encontrada no arquivo [`dados-iniciais.sql`](./src/main/resources/META-INF/sql/dados-iniciais.sql).

O script completo para restauração do banco de dados está no arquivo [`curso-jsf-e-primefaces.sql`](./src/main/resources/com/algaworks/sql/curso-jsf-e-primefaces.sql).

**Observação:** O banco de dados do projeto original foi concebido no MySQL 5.1, porém, para este projeto foi utilizada a versão 5.7 do MySQL.
