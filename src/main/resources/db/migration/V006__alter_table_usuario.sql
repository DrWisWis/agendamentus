ALTER TABLE usuarios
    add
        empresa_id BIGINT NULL
CONSTRAINT fk_ususarios_empresa_id FOREIGN KEY (empresa_id) REFERENCES empresas(id);