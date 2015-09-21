Entidades e suas propriedades: <br />
ALUGUEL <br />
id (Chave Primária), data\_retirada, data\_entrega, prazo, atraso, valor\_parcial, valor\_atraso, assegurado, status\_id (Chave Estrangeira), carro\_id (Chave Estrangeira)
<br />

CAMBIO<br />
id (Chave Primária), nome

CARRO<br />
id (Chave Primária), modelo, ano, preco, categoria, fabricante\_id (Chave Estrangeira), portas\_id (Chave Estrangeira), lugares\_id (Chave Estrangeira), motor\_id (Chave Estrangeira), carroceria\_id (Chave Estrangeira), combustivel\_id (Chave Estrangeira), cambio\_id (Chave Estrangeira), direcao\_id (Chave Estrangeira)

CARROCERIA<br />
id (Chave Primária), nome

COMBUSTIVEL<br />
id (Chave Primária), nome

DIRECAO<br />
id (Chave Primária), nome

ENDERECO<br />
id (Chave Primária), cep, logradouro, numero, complemento, bairro, cidade, estado

FABRICANTE<br />
id (Chave Primária), nome, email, origem, id\_telefone (Chave Estrangeira), id\_endereco (Chave Estrangeira)

PERMISSAO<br />
id (Chave Primária), descricao

LUGARES<br />
id (Chave Primária), quantidade

PORTAS<br />
id (Chave Primária), quantidade

STAUS\_ALUGUEL<br />
id (Chave Primária), descricao

TELEFONE<br />
id (Chave Primária), ddi, ddd, numero, tipo

USUARIO<br />
id (Chave Primária), nome, email, senha, cpf, rg, data\_nascimento, cnh, categoria\_carta, permissao\_id (Chave Estrangeira), id\_enredeco (Chave Estrangeira), id\_telefone (Chave Estrangeira)