/*
-- Criação da tabela Clientes
CREATE TABLE Clientes (
    ClienteID SERIAL PRIMARY KEY, -- Chave primária
    Nome VARCHAR(100) NOT NULL,
    Email VARCHAR(100) NOT NULL UNIQUE,
    DataNascimento DATE NOT NULL 
);

-- Criação da tabela Pedidos
CREATE TABLE Pedidos (
    PedidoID SERIAL PRIMARY KEY,
    ClienteID INT NOT NULL,
    DataPedido DATE NOT NULL,
    ValorTotal DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (ClienteID) REFERENCES Clientes(ClienteID) -- Restrição de chave estrangeira
);
*/

CREATE TABLE Usuario (
    usuario VARCHAR(255) PRIMARY KEY,
    senha VARCHAR(255) NOT NULL
)

CREATE TABLE Aplicativos (
    codigo BIGINT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    custoMensal VARCHAR(100) float
)

CREATE TABLE Cliente (
    codigo BIGINT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255)
)

CREATE TABLE Assinatura (
    codigo BIGINT PRIMARY KEY,
    codigoAplicativo BIGINT NOT NULL,
    codigoCliente BIGINT NOT NULL,
    inicioVigencia DATE,
    fimVigencia DATE,
    FOREIGN KEY (codigoAplicativo) REFERENCES Aplicativos(codigo),
    FOREIGN KEY (codigoCliente) REFERENCES Cliente(codigo)
)

CREATE TABLE Pagamento (
    codigo BIGINT PRIMARY KEY,
    codigoAssinatura BIGINT NOT NULL,
    valorPago FLOAT,
    dataPagamento DATE,
    promocao BIGINT,
    FOREIGN KEY (codigoAssinatura) REFERENCES Assinatura(codigo)
    FOREIGN KEY (promocao) REFERENCES Promocao(codigo)
)

CREATE TABLE Promocao (
    codigo BIGINT PRIMARY KEY,
    nome VARCHAR(100)
    tipo VARCHAR(100)
    valor FLOAT,
    ativa BOOLEAN DEFAULT TRUE
)