# Multi-Tax-Banking-Java-SpringBoot

Codificação em Java para uma aplicação de Cálculos de Multi Impostos Banking para aplicação com uso de Frameowrk SpringBoot com melhores práticas de programação que permite calcular diversos tipos de impostos e taxas relacionadas a Empréstimos Bancários.

## Arquitetura e Padrões de Design

### Strategy Pattern

O sistema utiliza o Padrão de Projeto Strategy para calcular diferentes tipos de impostos. O interface `CalculadoraImpostosStrategy` define a assinatura do método para calcular impostos. Isso permite que diferentes estratégias de cálculo possam ser implementadas e trocadas de forma dinâmica.

### Dependency Injection

O uso de framework Spring, este projeto emprega Injeção de Dependência para manter uma baixa acoplamento entre classes e para promover a separação de responsabilidades. O Spring cuida da criação e gerenciamento de objetos, garantindo que cada componente obtenha suas dependências.

## Princípios SOLID

### Single Responsibility Principle (SRP)

Cada classe no sistema tem uma única responsabilidade. Por exemplo, `EmprestimoController` lida apenas com operações HTTP relacionadas a empréstimos, enquanto `ImpostoService` cuida da lógica de negócio associada ao cálculo de impostos.

### Open/Closed Principle (OCP)

A aplicação é aberta para extensão mas fechada para modificação, particularmente no uso do padrão Strategy. Novas estratégias de cálculo de impostos podem ser adicionadas sem alterar o código existente.

### Liskov Substitution Principle (LSP), Interface Segregation Principle (ISP) & Dependency Inversion Principle (DIP)

O projeto, ao usar Spring e programação orientada a interfaces, adere a esses princípios, garantindo substitutibilidade, segregação correta de interfaces e inversão de dependências.

## Programação Orientada a Objetos

O sistema é desenvolvido usando o paradigma de Programação Orientada a Objetos, o que facilita a representação do mundo real, promove o reuso de código e melhora a modularidade.

## Uso

### Endpoints

- `/emprestimos/calcular-impostos`: Calcula um imposto específico com base na solicitação.

- Corpo da Requisição em Json do Método Post:
{
    "taxType": "IOF",
    "baseValue": 18000,
    "days": 10,
    "annualProfit": 5000
}


- `/emprestimos/calcular-todos-impostos`: Calcula todos os impostos com base na solicitação.

- Corpo da Requisição em Json do Método Post:
{
    "baseValue": 18000,
    "days": 10,
    "annualProfit": 5000
}


### Requisições

Para calcular impostos específicos ou todos os impostos, envie uma requisição POST com um corpo JSON contendo `taxType`, `baseValue`, `days` e `annualProfit`.

## Conclusão

Esta aplicação demonstra como padrões de design, princípios SOLID e programação orientada a objetos podem ser utilizados para criar um software flexível, extensível e manutenível.

## Autor:
Emerson Amorim


