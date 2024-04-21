# api-java
api em java com springboot e postgres
O que eu preciso:
Autenticar login;
Retornar todas as fichas de um jogador;
retornar todas as salas de um jogador;
criar uma sala;
conectar a uma sala;
criar uma ficha;
editar uma ficha;



O que eu tenho:

CRIO USUARIO - POST para /user body {name,password}
BUSCO USUARIO POR ID GET para /user/id
BUSCO TODOS OS USUARIOS GET para /user
DELETO USUARIO delete para /user/id
FALTA LOGIN

CRIO FICHA
BUSCO TODAS AS FICHAS GET para /sheet
BUSCAR FICHA POR ID GET para /sheet/id
ALTERO FICHA POR ID PUT para /sheet/?user_id=xx {body nova ficha}
DELETO FICHA DELETE para /sheet/id

CRIO MESA POST para /table body {mesa}
BUSCO TODAS AS MESAS GET para /table
BUSCAR MESA POR ID GET para /table/id
DELETO MESA?

CRIO ROOM POST para /room?table_id=xx&user_id=xx&sheet_id=xx body {}
BUSCO TODAS AS ROOMS GET para /room
BUSCO ROOM POR ID GET para /room/id 
DELETO ROOM?



