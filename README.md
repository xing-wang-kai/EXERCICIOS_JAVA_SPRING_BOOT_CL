
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

:white_check_mark: 
<fieldset>
<legend>ADICIONAR</legend>
<small>Primeiro metodo do crud responsável por adicionar uma nova entidade ao banco de dados.</small>
<img src="./src/main/img/imagem016.png" align="center"/>
</fieldset>

:white_check_mark:
<fieldset>
<legend>ALTERAR:</legend>
<small>Usando a ID da entidade informada no banco de dados, este metodo realiza a alteração dos dados realacionados ao ID</small>
<small>Mesmo que este metodo use recurso save ele não está salvando uma nova entidade, e sim alterando dados sobre ela</small>
<img src="./src/main/img/imagem017.png" align="center"/>
</fieldset>

:white_check_mark: 
<fieldset>
<legend>REMOVER:</legend>
<small>Remove uma entidade do banco de dados</small>
<img src="./src/main/img/imagem018.png" align="center"/>
<br/>
</fieldset>

:white_check_mark: 
<fieldset>
<legend>BUSCAR:</legend>
<small>Retorna todas unidades no banco de dados que estão relacinadas a entidade</small>
<img src="./src/main/img/imagem019.png" align="center"/>
<br/>
</fieldset>

##SPRING 'DERIVED QUERY'


É possivel personalizar algumas busca como no exemplo abaixo,
Neste exemplo foi usado o metodo findByNome que recebe uma String e retorna os dados pelo nome do funcionário.
o metodo deve ser adicionado no REPOSITORY.
<img src="./src/main/img/imagem020.png" align="center"/>
</br>
<img src="./src/main/img/imagem021.png" align="center"/>
</br>
<img src="./src/main/img/imagem022.png" align="center"/>
</br>
---

CRIADO COM :heart: POR KAI WANG!
<img src="./src/main/img/kai06.png" width="100px" heigth="100px"/>
