-- Criação das tabelas
CREATE TABLE IF NOT EXISTS aplicativos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    custo_mensal DOUBLE NOT NULL
);

CREATE TABLE IF NOT EXISTS clientes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS assinaturas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    cliente_id BIGINT NOT NULL,
    aplicativo_id BIGINT NOT NULL,
    inicio_vigencia DATE NOT NULL,
    fim_vigencia DATE NOT NULL,
    FOREIGN KEY (cliente_id) REFERENCES clientes(id),
    FOREIGN KEY (aplicativo_id) REFERENCES aplicativos(id)
);

CREATE TABLE IF NOT EXISTS pagamentos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    assinatura_id BIGINT NOT NULL,
    valor_pago DOUBLE NOT NULL,
    data_pagamento DATE NOT NULL,
    FOREIGN KEY (assinatura_id) REFERENCES assinaturas(id)
);

CREATE TABLE IF NOT EXISTS promocoes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(255) NOT NULL,
    desconto DOUBLE NOT NULL
);
