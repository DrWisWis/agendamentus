IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='agendamentos' and xtype='U')

create table agendamentos (
id BIGINT NOT NULL IDENTITY(1,1) PRIMARY KEY,
data_agendamento DATE NULL,
horario_agendamento TIME NULL,
descricao_agendamento VARCHAR(45) NULL,
usuario_id BIGINT NULL,
empresa_id BIGINT NULL,
CONSTRAINT fk_agendamento_cliente_id FOREIGN KEY (usuario_id) REFERENCES usuarios(id),
CONSTRAINT fk_agendamento_empresa_id FOREIGN KEY (empresa_id) REFERENCES empresas(id)
)

