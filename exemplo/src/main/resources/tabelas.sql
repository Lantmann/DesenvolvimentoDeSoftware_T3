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