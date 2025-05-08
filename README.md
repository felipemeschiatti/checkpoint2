
# 🩺 Checkpoint 2 - Sistema de Agendamento de Consultas

Projeto desenvolvido como parte da disciplina de Engenharia Web com foco em microserviços e arquitetura REST utilizando **Spring Boot**.

## 📚 Descrição

O sistema permite gerenciar consultas entre pacientes e profissionais da saúde. Nele é possível:

- Cadastrar profissionais e pacientes
- Agendar consultas
- Consultar histórico
- Acompanhar status de atendimentos

## 🛠️ Tecnologias Utilizadas

- Java 17
- Spring Boot 3
- Spring Data JPA
- H2 (banco de dados em memória)
- Maven
- Lombok
- Postman (para testes)

## 🧱 Estrutura de Pacotes

```
src/
├── controller/        # Camada de controle REST
├── dto/               # Objetos de transferência de dados
├── model/             # Entidades JPA
├── repository/        # Interfaces de acesso a dados
├── service/           # Lógica de negócio
└── Application.java   # Classe principal
```

## 🗃️ Entidades Principais

### Profissional

- `id` (gerado automaticamente)
- `nome`
- `especialidade`
- `valorHora`
- `createdAt`, `updatedAt`

### Paciente

- `id` (gerado automaticamente)
- `nome`
- `cpf`
- `createdAt`, `updatedAt`

### Consulta

- `id`
- `profissional_id` (relacionamento)
- `paciente_id` (relacionamento)
- `dataConsulta`
- `statusConsulta`
- `quantidadeHoras`
- `valorConsulta`
- `createdAt`, `updatedAt`

## ▶️ Como Rodar o Projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/felipemeschiatti/checkpoint2.git
   ```
2. Abra o projeto no IntelliJ ou VSCode.
3. Execute a classe `Application.java`.
4. Acesse o H2 Database Console:
   ```
   http://localhost:8080/h2-console
   ```
   Use os seguintes dados:
   - JDBC URL: `jdbc:h2:mem:testdb`
   - User: `sa`
   - Password: *(em branco)*

## 📮 Endpoints REST

| Método | Rota                       | Descrição                         |
|--------|----------------------------|-----------------------------------|
| GET    | `/profissionais`           | Lista todos os profissionais      |
| POST   | `/profissionais`           | Cria um novo profissional         |
| GET    | `/pacientes`               | Lista todos os pacientes          |
| POST   | `/pacientes`               | Cadastra novo paciente            |
| GET    | `/consultas`               | Lista todas as consultas          |
| POST   | `/consultas`               | Agendar nova consulta             |

## 👨‍💻 Contribuidores

- Felipe Meschiatti

---

> Este projeto foi desenvolvido para fins acadêmicos. Para dúvidas, sugestões ou melhorias, fique à vontade para abrir issues ou pull requests.
