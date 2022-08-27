
<img src="./src/main/img/imagem000.png"/>

<!-- @import "[TOC]" {cmd="toc" depthFrom=1 depthTo=6 orderedList=false} -->

# :white_flower: EXERCICIOS JAVA SPRING BOOT :dark_sunglasses:

# FUNCIONABILIDADES.

Este projeto busca na base de dados informações sobre Funcionários, este estão atrelados a Unidades de Trabalhos e Cargos.

Conforme o diagrama abaixo.

##### TABELAS

<img src="./src/main/img/imagem007.png"/>
<img src="./src/main/img/imagem008.png"/>
<img src="./src/main/img/imagem009.png"/>


### CRUD

O usuário pode executar os metodos CRUD para editar e alterar informações contidas no banco de dados, como UPDATE CREATE DELETE e FIND;
As ações poderão ser realizados pelo terminal.

<img src="./src/main/img/imagem001.png"/>

CRUD

<img src="./src/main/img/imagem002.png"/>

:white_check_mark: ADICIONAR:

<img src="./src/main/img/imagem003.png"/>

:white_check_mark: BUSCAR:

<img src="./src/main/img/imagem004.png"/>

:white_check_mark: DELETAR:

<img src="./src/main/img/imagem005.png"/>

:white_check_mark: UPDATE:

<img src="./src/main/img/imagem006.png"/>


##ESTRUTURA DO CÓDIGO. :gear: :gear:

Neste Código Foi utilizado práticas modernas do SPRING BOOT para conectar ao banco de dados,
O Spring Boot melhora o código tornando o mesmo mais legivel que o JPA e ajuda no desenvolvimento e conexão com o banco de dados
Desta forma foram criado 3 caminhos para conexão.
- [x] Class Funcionario
- [x] Class Unidade Trabalho
- [x] Class Cargos

Estas entidades possuem relaciomanetos com o banco de dados de OneToMany, ManyToMany, ManyToOny.

<img src="./src/main/img/imagem010.png" align="center"/>

### :gear: Código para Funcionario :gear:

<img src="./src/main/img/imagem011.png" align="center"/>

### :gear: Código para Unidade Trabalho :gear:

<img src="./src/main/img/imagem012.png" align="center"/>

### :gear: Código para Cargos :gear:

<img src="./src/main/img/imagem013.png" align="center"/>

##METODO REPOSITORY. :gear: :gear:

A interface Repository já aclopa no código com SPRING os metodos necessários para o CRUD.
O mesmo já faz o gerenciamento do JDBC e JPA buscando os dados e criando a conexão no banco.

Alguns metodos podem ser reescritos ou criados usando termos especificos do SPRING.

<img src="./src/main/img/imagem014.png" align="center"/>

##METODO SERVICE. :gear: :gear:

O service realizará toda integração com o Repository e será responsável pelos retornos e configurações deseja para essa API.
O sitema utlizado é uma interação com o terminal sem usar interfaces ou html web para pegar os dados.

:white_check_mark: ESTRUTURA INICIAL:

<img src="./src/main/img/imagem015.png" align="center"/>

:white_check_mark: ADICIONAR:

<img src="./src/main/img/imagem016.png" align="center"/>

:white_check_mark: ALTERAR:

<img src="./src/main/img/imagem017.png" align="center"/>

:white_check_mark: REMOVER:

<img src="./src/main/img/imagem018.png" align="center"/>

:white_check_mark: BUSCAR:

<img src="./src/main/img/imagem019.png" align="center"/>

---

CRIADO COM :heart: POR KAI WANG!
<img src="./src/main/img/kai06.png" width="100px" heigth="100px"/>
