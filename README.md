# 🌐 DeepL Translator - MVP

Sistema simples de tradução automática integrando Angular 14 + Spring Boot + DeepL API.

## 📋 Descrição

MVP para tradução de textos do português para espanhol e inglês usando a API gratuita do DeepL. O sistema permite:

- Tradução automática PT → ES/EN
- Interface simples e intuitiva
- Interface responsiva com Bootstrap
- Backend REST API em Spring Boot

## 🛠️ Tecnologias

### Frontend
- **Angular 14.2**
- **Bootstrap 5.3.7**
- **TypeScript 4.7**
- **RxJS 7.8**

### Backend
- **Java 17**
- **Spring Boot 2.7.18**
- **Maven**
- **DeepL API**

## 🚀 Pré-requisitos

- **Node.js** 16+ e npm
- **Java 17**
- **Maven 3.6+**
- **Conta gratuita DeepL** (500.000 caracteres/mês)

## ⚙️ Configuração

### 1. Clonar o repositório
```bash
git clone https://github.com/JaksonBritzke/translateDeepL.git
cd translateDeepL
```

### 2. Configurar Backend

#### 2.1 Obter API Key do DeepL
1. Acesse [DeepL API](https://www.deepl.com/api)
2. Crie uma conta gratuita
3. Copie sua API Key

#### 2.2 Configurar application.properties
```bash
cd backend
```

Crie/edite `src/main/resources/application.properties`:
```properties
server.port=8080
deepl.api.key=SUA_CHAVE_DEEPL_AQUI
spring.web.cors.allowed-origins=http://localhost:4201 ou a porta que for utilizada ao rodar o projeto front
```

#### 2.3 Executar Backend
```bash
# Na pasta backend/
mvn clean install
mvn spring-boot:run
```

O backend estará disponível em: `http://localhost:8080`

### 3. Configurar Frontend

```bash
# Na pasta front/
cd ../front
npm install
ng serve
```

O frontend estará disponível em: `http://localhost:4200`

## 🖥️ Como usar

1. **Certifique-se de que o backend está rodando** em `http://localhost:8080`
2. **Abra o navegador** em `http://localhost:4200`
3. **Digite o texto** em português que deseja traduzir
4. **Clique em "Traduzir"**
5. **Os campos ES e EN** serão preenchidos automaticamente com as traduções

## 📦 Dependências Utilizadas

### Backend (Java 17 + Spring Boot 2.7.18)
```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
```

### Frontend (Angular 14.2)
```json
{
  "@angular/core": "^14.2.0",
  "@angular/common": "^14.2.0",
  "@angular/forms": "^14.2.0",
  "bootstrap": "^5.3.7",
  "rxjs": "^7.8.2",
  "typescript": "~4.7.2"
}
```

## 🔄 API Endpoints

### POST `/api/translate`

**Request:**
```json
{
  "text": "Cadastro realizado com sucesso"
}
```

**Response:**
```json
{
  "spanish": "Registro completado exitosamente",
  "english": "Registration completed successfully"
}
```

## 🚀 Scripts de Execução

### Executar apenas o Backend:
```bash
cd backend
mvn spring-boot:run
```

### Executar apenas o Frontend:
```bash
cd front
ng serve
```

### Executar ambos (em terminais separados):
```bash
# Terminal 1 - Backend
cd backend && mvn spring-boot:run

# Terminal 2 - Frontend  
cd front && ng serve
```

## 🐛 Resolução de Problemas

### Erro de CORS
Se houver problemas de CORS, verifique se o backend está configurado corretamente x porta do front:
```java
@CrossOrigin(origins = "http://localhost:4200")
```

### Erro de dependências Angular
```bash
cd front
rm -rf node_modules package-lock.json
npm install
```

### Erro Java Version
Verifique se está usando Java 17:
```bash
java -version
```

### Limite de caracteres DeepL
A versão gratuita tem limite de 500.000 caracteres/mês. Para mais informações, consulte [DeepL Pricing](https://www.deepl.com/pricing).

## 🔒 Segurança

⚠️ **Importante**: Nunca commite sua API Key do DeepL no repositório.

- Use variáveis de ambiente em produção
- O arquivo `application.properties` está no `.gitignore`
- Para produção, considere usar Spring Profiles

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## 📞 Contato
- **Autor**: Jakson Britzke
- **GitHub**: [JaksonBritzke](https://github.com/JaksonBritzke)
- **Projeto**: [translateDeepL](https://github.com/JaksonBritzke/translateDeepL)
