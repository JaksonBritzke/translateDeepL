# 🌐 DeepL Translator - MVP

Sistema simples de tradução automática integrando Angular 14 + Spring Boot + DeepL API.

## 📋 Descrição

MVP para tradução de textos do português para espanhol e inglês usando a API gratuita do DeepL. O sistema permite:

- Criar chaves personalizadas para organização
- Tradução automática PT → ES/EN
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
spring.web.cors.allowed-origins=http://localhost:4200
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
3. **Preencha os campos:**
   - **Key Value**: Chave personalizada (ex: `success.message`)
   - **PT**: Texto em português (ex: `Cadastro realizado com sucesso`)
4. **Clique em "Traduzir"**
5. **Os campos ES e EN** serão preenchidos automaticamente

## 📁 Estrutura do Projeto

```
translateDeepL/
├── backend/                          # Spring Boot API
│   ├── src/main/java/com/example/translator/
│   │   ├── controller/
│   │   │   └── TranslateController.java
│   │   ├── service/
│   │   │   └── TranslateService.java
│   │   └── TranslatorApplication.java
│   ├── src/main/resources/
│   │   └── application.properties
│   └── pom.xml
├── front/                            # Angular Frontend
│   ├── src/app/
│   │   ├── translate/
│   │   │   ├── translate.component.ts
│   │   │   ├── translate.component.html
│   │   │   └── translate.component.css
│   │   ├── app.component.html
│   │   └── app.module.ts
│   ├── angular.json
│   └── package.json
├── .gitignore
└── README.md
```

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
  "key": "success.message",
  "text": "Cadastro realizado com sucesso"
}
```

**Response:**
```json
{
  "key": "success.message",
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
Se houver problemas de CORS, verifique se o backend está configurado corretamente:
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

## 🤝 Contribuição

1. Faça um Fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/NovaFuncionalidade`)
3. Commit suas mudanças (`git commit -m 'Adiciona nova funcionalidade'`)
4. Push para a branch (`git push origin feature/NovaFuncionalidade`)
5. Abra um Pull Request

## 📞 Contato

- **Autor**: Jakson Britzke
- **GitHub**: [JaksonBritzke](https://github.com/JaksonBritzke)
- **Projeto**: [translateDeepL](https://github.com/JaksonBritzke/translateDeepL)

## 🎯 Próximas Features

- [ ] Histórico de traduções
- [ ] Suporte a mais idiomas
- [ ] Exportação para CSV/JSON
- [ ] Cache de traduções
- [ ] Interface para gerenciar chaves
- [ ] Autenticação de usuários
- [ ] Docker para fácil deployment

---

⭐ **Se este projeto te ajudou, deixe uma estrela!** ⭐
