IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='empresas' and xtype='U')

create table empresas (
id BIGINT NOT NULL IDENTITY(1,1) PRIMARY KEY,
nome VARCHAR(50) NOT NULL,
logradouro VARCHAR(50) NULl,
bairro VARCHAR(50) NULL,
cidade VARCHAR(50) NULL,
cep VARCHAR(12) NULL,
telefone VARCHAR(15) NULL,
uf CHAR(2) NULL,
cnpj VARCHAR(30) NULL,
cod_status_empresa BIT NOT NULL
)

