IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='usuarios' and xtype='U')

create table usuarios(
id BIGINT NOT NULL IDENTITY(1,1) PRIMARY KEY,
nome VARCHAR(45) NULL,
email VARCHAR(45) NOT NULL,
senha VARCHAR(200) NOT NULL,
data_nascimento DATE NULL,
cod_status_usuario BIT NOT NULL,
tipo_usuario VARCHAR(45) NOT NULL,
logradouro VARCHAR(50) NULl,
bairro VARCHAR(50) NULL,
cidade VARCHAR(50) NULL,
cep VARCHAR(12) NULL,
telefone VARCHAR(15) NULL,
uf CHAR(2) NULL,

unique(email)
)

