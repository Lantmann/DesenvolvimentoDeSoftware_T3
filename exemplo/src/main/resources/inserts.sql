-- Inserção de dados na tabela Clientes
INSERT INTO Clientes (Nome, Email, DataNascimento) VALUES
('João Silva', 'joao.silva@example.com', '1980-05-15'),
('Maria Santos', 'maria.santos@example.com', '1992-07-20'),
('Carlos Pereira', 'carlos.pereira@example.com', '1985-12-30'),
('Ana Costa', 'ana.costa@example.com', '1990-11-22'),
('Pedro Oliveira', 'pedro.oliveira@example.com', '1978-09-10'),
('Lucia Souza', 'lucia.souza@example.com', '1982-01-05'),
('Marcos Lima', 'marcos.lima@example.com', '1995-04-18'),
('Fernanda Alves', 'fernanda.alves@example.com', '1988-07-23'),
('Rafael Pinto', 'rafael.pinto@example.com', '1983-10-29'),
('Carla Moura', 'carla.moura@example.com', '1991-03-12');

-- Inserção de dados na tabela Pedidos
INSERT INTO Pedidos (ClienteID, DataPedido, ValorTotal) VALUES
(1, '2023-01-15', 150.75),
(2, '2023-02-10', 299.99),
(3, '2023-03-05', 89.50),
(4, '2023-04-22', 250.00),
(5, '2023-05-18', 175.20),
(6, '2023-06-10', 320.00),
(7, '2023-07-01', 220.75),
(8, '2023-08-15', 150.00),
(9, '2023-09-20', 99.99),
(10, '2023-10-05', 450.50);
