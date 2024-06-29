DROP TABLE Pagamento IF EXISTS;
DROP TABLE Assinatura IF EXISTS;
DROP TABLE Promocao IF EXISTS;
DROP TABLE Cliente IF EXISTS;
DROP TABLE Usuario IF EXISTS;
DROP TABLE Aplicativo IF EXISTS;

CREATE TABLE Usuario (
    usuario VARCHAR(255) PRIMARY KEY,
    senha VARCHAR(255) NOT NULL
);

CREATE TABLE Aplicativo (
    codigo BIGINT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    custo_Mensal FLOAT
);

CREATE TABLE Cliente (
    codigo BIGINT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255)
);

CREATE TABLE Promocao (
    codigo BIGINT PRIMARY KEY,
    nome VARCHAR(100),
    tipo VARCHAR(100),
    valor FLOAT,
    ativa BOOLEAN DEFAULT TRUE
);

CREATE TABLE Assinatura (
    codigo BIGINT PRIMARY KEY,
    codigo_Aplicativo BIGINT NOT NULL,
    codigo_Cliente BIGINT NOT NULL,
    inicio_Vigencia DATE,
    fim_Vigencia DATE,
    FOREIGN KEY (codigo_Aplicativo) REFERENCES Aplicativo(codigo),
    FOREIGN KEY (codigo_Cliente) REFERENCES Cliente(codigo)
);

CREATE TABLE Pagamento (
    codigo BIGINT PRIMARY KEY,
    codigo_Assinatura BIGINT NOT NULL,
    valor_Pago FLOAT,
    data_Pagamento DATE,
    promocao BIGINT,
    FOREIGN KEY (codigo_Assinatura) REFERENCES Assinatura(codigo),
    FOREIGN KEY (promocao) REFERENCES Promocao(codigo)
);