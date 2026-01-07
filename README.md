# 💱 Conversor de Moedas em Java

Projeto de **conversor de moedas via terminal**, desenvolvido em **Java**, que utiliza uma **API de cotações em tempo real** para realizar conversões entre diferentes moedas.

O objetivo principal do projeto é **estudo e prática**, abordando:
- Estruturas de controle (`while`, `switch`)
- Entrada de dados via terminal
- Consumo de API HTTP
- Leitura de JSON
- Organização de código

---

## 🚀 Funcionalidades

O programa permite converter valores entre:

1. Dólar (USD) ➜ Peso Argentino (ARS)
2. Peso Argentino (ARS) ➜ Dólar (USD)
3. Dólar (USD) ➜ Real Brasileiro (BRL)
4. Real Brasileiro (BRL) ➜ Dólar (USD)
5. Dólar (USD) ➜ Peso Colombiano (COP)
6. Peso Colombiano (COP) ➜ Dólar (USD)
7. Sair do programa

As cotações são obtidas **em tempo real** através da API **ExchangeRate API**.

---

## 🌐 API Utilizada

**ExchangeRate API**  
Base: USD

Endpoint:
```
https://v6.exchangerate-api.com/v6/SUA_API_KEY/latest/USD
```

O programa consome o objeto `conversion_rates` retornado em formato JSON.

Exemplo de resposta:
```json
{
  "conversion_rates": {
    "BRL": 5.39,
    "ARS": 1452.25,
    "COP": 3754.02
  }
}
```

---

## 🛠️ Tecnologias e Recursos

- **Java 11+** (obrigatório por causa do `HttpClient`)
- **Gson** (para leitura de JSON)
- Terminal / Console
- API REST

---

## 📦 Dependência (Gson)

Para funcionar corretamente, é necessário adicionar a biblioteca **Gson** ao projeto.

### Maven
```xml
<dependency>
  <groupId>com.google.code.gson</groupId>
  <artifactId>gson</artifactId>
  <version>2.10.1</version>
</dependency>
```

Ou adicionar o `.jar` manualmente ao classpath.

---

## ▶️ Como Executar

1. Certifique-se de estar usando **Java 11 ou superior**
2. Clone ou baixe o projeto
3. Adicione a dependência Gson
4. Compile o projeto:

```bash
javac ConversorDeMoedas.java
```

5. Execute:

```bash
java ConversorDeMoedas
```

---

## 🧠 Estrutura do Código

- `main()`
  - Loop principal (`while`)
  - Menu interativo
  - Controle de opções (`switch`)

- `buscarCotacoes()`
  - Faz a requisição HTTP
  - Lê a resposta JSON
  - Extrai as taxas de câmbio

- `readDouble()`
  - Valida entradas numéricas do usuário

---

## 📚 Objetivo Educacional

Este projeto foi criado com foco em:

- Aprender a consumir APIs em Java
- Separar responsabilidades no código
- Evitar valores fixos (hardcoded)
- Desenvolver aplicações de terminal

Não é um projeto comercial, mas uma base sólida para estudos e evolução.

---

## 🔮 Possíveis Melhorias Futuras

- Cache de cotações
- Tratamento avançado de erros
- Separação em múltiplas classes
- Suporte a mais moedas
- Interface gráfica (JavaFX ou Swing)

---

## 👨‍💻 Autor Rodrigo Anastácio

Projeto desenvolvido para fins de estudo e prática em Java.

---

💡 *Sinta-se à vontade para modificar, testar e evoluir este projeto.*

