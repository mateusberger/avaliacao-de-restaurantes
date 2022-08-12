# Avaliação de Restaurantes
Aplicação simples para demonstrar o funcionamento da arquitetura de micro serviços.

A aplicação tem como objetivo permitir a avaliação de restaurantes.
Para isso, a aplicação está divida em três partes:
 * Usuarios-MS
 * Restaurantes-MS
 * Avaliacoes-MS

---

### Usuarios-MS
Micro serviço destinado ao recurso de usuário.

### Restaurantes-MS
Micro serviço destinado ao recurso de restaurantes.

### Avaliacoes-MS
Micro serviço destinado ao recurso de Avaliações.
Agrega as avaliações de um usuário para um restaurante.

---

## Arquitetura da aplicação
A Arquitetura da aplicação conta com um gateway para centralizar as chamadas e um service discovery para o registro de aplicações e suas instancias.

![Arquitetura](https://user-images.githubusercontent.com/34915495/184186689-93de11c7-99d4-47f1-be52-895cd711c377.png)

---

## Requisitos
Para compilar e rodar o projeto, será necessário algumas dependecias/requisitos:
- Java 17
- Apache Maven

