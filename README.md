# 🌍 Global Solution Java 2025 - Gestão de Abrigos e Recursos para Eventos Climáticos Extremos

Projeto desenvolvido para o **Challenge FIAP 2025**, que consiste em uma **API RESTful** para gestão de abrigos, recursos e ocupantes em situações de eventos climáticos extremos, visando suporte eficiente à população afetada.

---

## 👨‍💻 Integrantes - Grupo LTAKN

- **Enzo Prado Soddano** – RM: 557937  
  [GitHub](https://github.com/DerBrasilianer)

- **Lucas Resende Lima** – RM: 556564  
  [GitHub](https://github.com/lucasresendelima)

- **Vinicius Prates Altafini** – RM: 559183  
  [GitHub](https://github.com/vinicius945)

---

## 📡 Sobre o Projeto

Esta solução foi desenvolvida com foco em boas práticas de arquitetura e tecnologias modernas para fornecer um sistema robusto, escalável e seguro que permita:

- Cadastro e gerenciamento de **Abrigose seus recursos e ocupantes**
- Persistência e relacionamento entre entidades em banco relacional Oracle via Spring Data JPA
- Validação rigorosa dos dados usando Bean Validation (javax.validation)
- Documentação interativa da API com Swagger/OpenAPI
- Deploy pronto para nuvem (exemplo: Heroku, AWS, Azure)

---

## 🛠️ Tecnologias Utilizadas

- Java 21 + Spring Boot 3.x  
- Spring Data JPA (com Oracle DB)  
- Bean Validation (Jakarta Validation)  
- Swagger / OpenAPI para documentação  
- Maven para gerenciamento de dependências  
- Deploy em nuvem (ex: [Link para deploy do projeto](https://seu-deploy-aqui.com))  

---

## 🗂️ Entidades e Relacionamentos

- **Abrigo:** Local físico para acolhimento  
- **Localização:** Informações geográficas do abrigo  
- **Recurso:** Equipamentos e suprimentos disponíveis  
- **Ocupante:** Pessoas acolhidas no abrigo  

Relacionamentos mapeados com JPA para garantir integridade e consulta eficiente.

---

## ⚙️ Endpoints Principais (REST API)

### Abrigo

| Método | Endpoint                 | Descrição                |
|--------|--------------------------|--------------------------|
| GET    | `/abrigos`               | Listar todos os abrigos  |
| GET    | `/abrigos/{id}`          | Obter abrigo por ID      |
| POST   | `/abrigos`               | Criar novo abrigo        |
| PUT    | `/abrigos/{id}`          | Atualizar abrigo         |
| DELETE | `/abrigos/{id}`          | Excluir abrigo           |

### Localização

| Método | Endpoint                 | Descrição                    |
|--------|--------------------------|------------------------------|
| GET    | `/localizacoes`           | Listar localizações           |
| GET    | `/localizacoes/{id}`      | Obter localização por ID      |
| POST   | `/localizacoes`           | Criar nova localização        |
| PUT    | `/localizacoes/{id}`      | Atualizar localização         |
| DELETE | `/localizacoes/{id}`      | Excluir localização           |

### Recurso

| Método | Endpoint                 | Descrição                |
|--------|--------------------------|--------------------------|
| GET    | `/recursos`               | Listar todos os recursos |
| GET    | `/recursos/{id}`          | Obter recurso por ID     |
| POST   | `/recursos`               | Criar novo recurso       |
| PUT    | `/recursos/{id}`          | Atualizar recurso        |
| DELETE | `/recursos/{id}`          | Excluir recurso          |

### Ocupante

| Método | Endpoint                 | Descrição                |
|--------|--------------------------|--------------------------|
| GET    | `/ocupantes`              | Listar todos os ocupantes|
| GET    | `/ocupantes/{id}`         | Obter ocupante por ID    |
| POST   | `/ocupantes`              | Criar novo ocupante      |
| PUT    | `/ocupantes/{id}`         | Atualizar ocupante       |
| DELETE | `/ocupantes/{id}`         | Excluir ocupante         |

## 🧪 Exemplos de Uso (com cURL)

### 🔹 Criar um Abrigo

```
curl -X POST https://seu-deploy-aqui.com/abrigos \
 -H "Content-Type: application/json" \
 -d '{
   "nome": "Abrigo Zona Norte",
   "capacidade": 200,
   "localizacaoId": 1
 }'
```
### 🔹 Listar Todos os Abrigos

```curl https://seu-deploy-aqui.com/abrigos```

### 🔹 Atualizar um Recurso
```
curl -X PUT https://seu-deploy-aqui.com/recursos/3 \
 -H "Content-Type: application/json" \
 -d '{
   "descricao": "Colchões extras",
   "quantidade": 50,
   "abrigoId": 2
 }'
```
### 🔹 Excluir um Ocupante
```
curl -X DELETE https://seu-deploy-aqui.com/ocupantes/7
```

### 📜 Documentação da API
A API está totalmente documentada via Swagger, permitindo testes interativos e visualização dos endpoints. Acesse por:

```https://seu-deploy-aqui.com/swagger-ui.html```
ou
```https://seu-deploy-aqui.com/swagger-ui/index.html```

### 🚀 Deploy
A aplicação foi disponibilizada em ambiente de nuvem, garantindo acesso remoto e escalabilidade.

🔗 Link de acesso ao sistema: [Deploy do Projeto](https://gs-java-2025.onrender.com/swagger-ui/index.html)

🎬 Vídeo Demonstração
Assista ao vídeo explicativo com a apresentação da arquitetura, exemplos de uso da API e funcionamento geral da solução:

📽️ Link para o vídeo no YouTube (não listado)? [Vídeo Pitch]([https://gs-java-2025.onrender.com/swagger-ui/index.html](https://www.youtube.com/watch?v=e16K1S7MDR4&feature=youtu.be))
