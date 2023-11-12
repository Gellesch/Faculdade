Cliente(cod_Cli, Nome_cli, Cidade, Uf)
chave primária: cod_Cli
Pedido(Cod_ped, cod_Cli, Cod_Vend)
chave primária: Cod_ped
chave estrangeira:
cod_Cli (referencia Cliente(cod_Cli))
Cod_Vend (referencia Vendedor(Cod_Vend))

Vendedor(Cod_Vend, Nome_vend, Faixa_Comissao, Salario)
chave primária: Cod_Vend
Produto(Cod_prod, Descriçao, Valor_unit, Unidade)
chave primária: Cod_prod
