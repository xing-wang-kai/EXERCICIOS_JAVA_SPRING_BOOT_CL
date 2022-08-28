
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

##SPRING DERIVED QUERY


É possivel personalizar algumas busca como no exemplo abaixo,
Neste exemplo foi usado o metodo findByNome que recebe uma String e retorna os dados pelo nome do funcionário.
o metodo deve ser adicionado no REPOSITORY.

<img src="./src/main/img/imagem020.png" align="center"/>

Foi informado ao REPOSITORY que haverá uma nova busca com retorno de lista de funcionários, nesta busca será iserido uma STRING com o nome do funcionário.
O Spring identifica que a entidade funcionario tem um atributo chamado nome e que é do tipo String e etão automáticamente cria a Query para o banco de dados.

<img src="./src/main/img/imagem021.png" align="center"/>

O metodo foi criado em relatório funcionário para retornar os dados escolhidos.


<img src="./src/main/img/imagem022.png" align="center"/>

Após o processo o sistema retorna os funcionários associados aos nomes informados.

###USANDO JPQL

É possivel usar o JPQL para auxiliar na criação de novos metodos para buscar usuários.
conforme o exemplo logo abaixo.

<img src="./src/main/img/imagem023.png" align="center"/>

###USANDO NATIVEQUERY

Além das Query do JPQL também foi utlizando os metodos com Query Nativas do SQL para buscar os valores desejados como no exemplo.
nesses caso na anotação QUERY foi usado propriedade VALUE e NATIVEQUERY como TRUE;

<img src="./src/main/img/imagem024.png" align="center"/>

###USANDO PAGING AND SORTING

É possivel realizar uma pesquisa páginada por número de Entidades, para isso modificamos primeiro a interface CrudRepository por PagingAndSortingRepository,
Esta interface permite criar modelos de paginação.

<img src="./src/main/img/imagem028.png" align="center"/>

Após modificar o REPOSITORY então em service adicionado o PAGEABLE e informado o PageRequest onde informamos a página da consulta, a quantidade de consulta retornadas e a ordenação da consulta.

<img src="./src/main/img/imagem029.png" align="center"/>

Como retorno temos.

<img src="./src/main/img/imagem030.png" align="center"/>


###USANDO PROJECTION

Projectos são facilidades disponibilizada no SPRING que permite determinar quais atributos devem retornar de uma entidade, 
para criar uma projection é simples.
1. Criar pasta projection - dentro de projection criar uma interface com as informações de retorno. OBS: os retornos devem ser o mesmo da Entidade.

<img src="./src/main/img/imagem025.png" align="center"/>

2. Criar em REPOSITORY informações para o retorno com Native Query que deve retornar as colunas desejadas da pesquisa.

<img src="./src/main/img/imagem027.png" align="center"/>

3. Criar SERVICE e  o metodo que retorna a PROJECTION criada com os valores get informados.

<img src="./src/main/img/imagem026.png" align="center"/>

### USANDO SPECIFICATION

Quando queremos executar querys especificas para determinados retornos de entidades como o LIKE ou GREATERTHAN etc. podemos usar o SPECIFICATION do SPRING.

1. Importamos o JpaSpecificationExecutor<clss> e incluimos como extensão interface em nosso REPOSITORY.

<img src="./src/main/img/imagem031.png" align="center"/>

2.Criamos um novo arquivo na pasta SPECIFICATION e então criamos o metodo do SPECIFICATION e seu retorno.

<img src="./src/main/img/imagem032.png" align="center"/>

3.Depois adicionado o metodo em findAll na pesquisa conforme o print.

<img src="./src/main/img/imagem033.png" align="center"/>

####OUTROS METODOS SPECIFICATION

GreateThan like Equal

<img src="./src/main/img/imagem034.png" align="center"/>

<img src="./src/main/img/imagem035.png" align="center"/>
---

CRIADO COM :heart: POR KAI WANG!
<img src="./src/main/img/kai06.png" width="100px" heigth="100px"/>
