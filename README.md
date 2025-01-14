# Circuit Breaker Caller Spring

Este projeto faz parte de um sistema em conjunto com outro projeto chamado [`circuit-breaker-spring`](https://github.com/CarlosGRSchneider/circuit-breaker-spring). Ele consome os endpoints expostos pelo projeto mencionado anteriormente, agregando respostas padrão com os resultados das chamadas realizadas aos serviços externos.

## Funcionalidades

- Consumo de endpoints expostos no microsserviço [`circuit-breaker-spring`](https://github.com/CarlosGRSchneider/circuit-breaker-spring) utilizando Feign.
- Implementação de circuit breakers com fallback utilizando Resilience4j.
- Monitoramento do estado dos circuit breakers via Actuator.

## Endpoints Disponíveis

### 1. `/chamada-animais` (GET)
- Realiza a chamada ao endpoint de geração de combinações de animais exposto pelo microsserviço.
- Respostas possíveis:
  - Resposta do microsserviço remoto.
  - Resposta de fallback baseada em cache ou mensagem customizada em caso de falha.

### 2. `/calculadora-complexa` (POST)
- Realiza a chamada ao endpoint de cálculo complexo (soma de dois números) no microsserviço remoto.
- Respostas possíveis:
  - Resultado da soma fornecida pelo microsserviço remoto.
  - Resposta de fallback com mensagem padrão em caso de falha.

### 3. `/actuator/circuitbreakers` (GET)
- Monitoramento do estado dos circuit breakers configurados:
  - `circuitoAnimal`
  - `circuitoCalculadora`
- Exemplo de resposta:

```json
{
  "circuitBreakers": {
    "circuitoAnimal": {
      "failureRate": "-1.0%",
      "slowCallRate": "-1.0%",
      "failureRateThreshold": "50.0%",
      "slowCallRateThreshold": "100.0%",
      "bufferedCalls": 0,
      "failedCalls": 0,
      "slowCalls": 0,
      "slowFailedCalls": 0,
      "notPermittedCalls": 0,
      "state": "CLOSED"
    },
    "circuitoCalculadora": {
      "failureRate": "-1.0%",
      "slowCallRate": "-1.0%",
      "failureRateThreshold": "50.0%",
      "slowCallRateThreshold": "40.0%",
      "bufferedCalls": 7,
      "failedCalls": 0,
      "slowCalls": 0,
      "slowFailedCalls": 0,
      "notPermittedCalls": 0,
      "state": "CLOSED"
    }
  }
}
```

## Configuração do Projeto

### Explicação dos Parâmetros encontrados no arquivo `application.properties`
- **`slidingWindowSize`**: Número de requisições monitoradas para determinar o estado do circuito.
- **`minimumNumberOfCalls`**: Número mínimo de requisições que devem falhar para abrir o circuito.
- **`permittedNumberOfCallsInHalfOpenState`**: Número de chamadas permitidas em estado semi-aberto.
- **`waitDurationInOpenState`**: Tempo (em ms) que o circuito permanecerá aberto antes de tentar reabrir.
- **`slowCallDurationThreshold`**: Duração máxima permitida para uma chamada ser considerada bem-sucedida.
- **`slowCallRateThreshold`**: Percentual máximo de chamadas lentas permitido antes de abrir o circuito.

## Como Executar

1. Certifique-se de que o projeto [`circuit-breaker-spring`](https://github.com/CarlosGRSchneider/circuit-breaker-spring) está em execução na porta `9090`.
2. Clone este repositório:

   ```bash
   git clone https://github.com/CarlosGRSchneider/circuit-breaker-caller-spring.git
   ```

3. Acesse o diretório do projeto:

   ```bash
   cd circuit-breaker-caller-spring
   ```

4. Execute o projeto com o Maven:

   ```bash
   mvn spring-boot:run
   ```

5. Acesse os endpoints na porta `8080`.

## Tecnologias Utilizadas
- **Spring Boot**
- **Spring Cloud OpenFeign**
- **Resilience4j**
- **Spring Actuator**
