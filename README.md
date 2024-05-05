# API - RPG: GO!
> API em java utilizando SpringBoot JPA e POSTGRESQL

## CRUD criado para o backend do trabalho de Dev Mobile
O sistema consiste na criação de usuários, criação de fichas de RPG, criação de mesas e criação de salas para conectar usuários a uma mesa

### Modelos do banco

User - ID, nome, senha

Sheet - ID, nome, classe, raça, nível, spells, user_id

Table - ID, nome, master_id

Room - ID, player_id, table_id, sheet_id

#### AÇÕES

## USER

| Método | Endpoint        | Descrição                     |
| ------ | --------------- | ----------------------------- |
| GET    | `/user`         | Listar Todos os Usuários      |
| GET    | `/user/id`      | Listar Usuário por ID         |
| POST   | `/user`         | Criar Usuário                 |
| POST   | `/user/login`   | Autenticar Login              |
| PUT    | `/user`         | Alterar Senha do Usuário      |
| DELETE | `/user/id`      | Excluir Usuário por ID        |

### Corpo da Requisição para Criar Usuário

```json
{
    "name": "Nome do Usuário",
    "password": "Senha do Usuário"
}
```
-----------------------------
## FICHA

| Método | Endpoint           | Descrição                    |
| ------ | ------------------ | ---------------------------- |
| GET    | `/sheet`           | Listar Todas as Fichas       |
| GET    | `/sheet/id`        | Listar Ficha por ID          |
| POST   | `/sheet?user_id=xx`| Criar Ficha                  |
| PUT    | `/sheet?user_id=xx`| Editar Ficha                  |


### Parâmetros de Consulta para Criar Ficha

- `user_id` - ID do usuário

Corpo da requisição:

```json
{
    "id": *Id do usuário em caso de PUT*,
    "name": "Nome do Usuário",
    "playerClass": "Classe do Jogador",
    "race": "Raça do Jogador",
    "playerLevel": "Nível do Jogador, INT",
    "spells": "Magias do Jogador"
}
```
------------------
## MESA

| Método | Endpoint       | Descrição               |
| ------ | -------------- | ----------------------- |
| GET    | `/table`       | Listar Todas as Mesas  |
| GET    | `/table/id`    | Listar Mesa por ID     |
| POST   | `/table?master_id=xx`       | Criar uma Mesa          |

### Parâmetros de Consulta para Criar uma Mesa

- `master_id` - ID do mestre

Corpo da requisição:

```json
{
    "name": "Nome da Mesa"
}
```
---------------
## ROOM

| Método | Endpoint    | Descrição                    |
| ------ | ----------- | ---------------------------- |
| GET    | `/room`     | Listar Todas as Salas       |
| POST   | `/room?table_id=xx&user_id=xx&sheet_id=xx`     | Criar uma Sala              |

### Parâmetros de Consulta para Criar uma Sala

- `table_id` - ID da mesa
- `user_id` - ID do usuário
- `sheet_id` - ID da ficha

Corpo da requisição:

```json
{
}
```
