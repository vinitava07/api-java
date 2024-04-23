# API - RPG: GO!
> API em java utilizando SpringBoot JPA e POSTGRESQL

## CRUD criado para o backend do trabalho de Dev Mobile
O sistema consiste na criação de usuários, criação de fichas de RPG e criação de salas para conectar usuários a uma mesa

### Modelos do banco

User - ID, nome, senha

Sheet - ID, nome, classe, raça, nível, spells, user_id

Table - ID, nome, master_id

Room - ID, player_id, table_id, sheet_id

### Ações

#### User

* Criar usuário

* Buscar usuário por id

* Deletar usuário

-----------------------------
#### Ficha

* Criar ficha

* Buscar ficha por id

* Alterar ficha

* Deletar ficha

------------------
#### Mesa

* Criar mesa

* Buscar mesa por id

---------------
#### Room

* Criar room

* Buscar room por id




