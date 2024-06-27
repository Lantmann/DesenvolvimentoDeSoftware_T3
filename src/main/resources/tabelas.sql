DROP TABLE Pagamento IF EXISTS;
DROP TABLE Assinatura IF EXISTS;
DROP TABLE Promocao IF EXISTS;
DROP TABLE Usuario IF EXISTS;
DROP TABLE Aplicativo IF EXISTS;
DROP TABLE Cliente IF EXISTS;

CREATE TABLE Usuario (
    usuario VARCHAR(255) PRIMARY KEY,
    senha VARCHAR(255) NOT NULL
);

CREATE TABLE Aplicativo (
    codigo BIGINT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    custoMensal FLOAT
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
    codigoAplicativo BIGINT NOT NULL,
    codigoCliente BIGINT NOT NULL,
    inicioVigencia DATE,
    fimVigencia DATE,
    FOREIGN KEY (codigoAplicativo) REFERENCES Aplicativo(codigo),
    FOREIGN KEY (codigoCliente) REFERENCES Cliente(codigo)
);

CREATE TABLE Pagamento (
    codigo BIGINT PRIMARY KEY,
    codigoAssinatura BIGINT NOT NULL,
    valorPago FLOAT,
    dataPagamento DATE,
    promocao BIGINT,
    FOREIGN KEY (codigoAssinatura) REFERENCES Assinatura(codigo),
    FOREIGN KEY (promocao) REFERENCES Promocao(codigo)
);

