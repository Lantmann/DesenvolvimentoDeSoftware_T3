INSERT INTO Usuario (usuario, senha) VALUES ('FulanoUser', 'senha123');
INSERT INTO Usuario (usuario, senha) VALUES ('CiclanoUser', 'senha456');

INSERT INTO Aplicativo (codigo, nome, custo_Mensal) VALUES (1123, 'Spotify', 29.99);
INSERT INTO Aplicativo (codigo, nome, custo_Mensal) VALUES (2123, 'Apple Music', 19.99);
INSERT INTO Aplicativo (codigo, nome, custo_Mensal) VALUES (3123, 'Deezer', 49.99);
INSERT INTO Aplicativo (codigo, nome, custo_Mensal) VALUES (4123, 'Prime Video', 21.99);
INSERT INTO Aplicativo (codigo, nome, custo_Mensal) VALUES (5123, 'Netflix', 37.90);

INSERT INTO Cliente (codigo, nome, email) VALUES (6123, 'FulanoCli', 'fulano@email.com');
INSERT INTO Cliente (codigo, nome, email) VALUES (7123, 'CiclanoCli', 'ciclano@email.com');
INSERT INTO Cliente (codigo, nome, email) VALUES (8123, 'BeltranoCli', 'beltrano@email.com');
INSERT INTO Cliente (codigo, nome, email) VALUES (9123, 'AnaCli', 'ana@email.com');
INSERT INTO Cliente (codigo, nome, email) VALUES (10123, 'JoaoCli', 'joao@email.com');
INSERT INTO Cliente (codigo, nome, email) VALUES (11123, 'MariaCli', 'maria@email.com');
INSERT INTO Cliente (codigo, nome, email) VALUES (12123, 'PedroCli', 'pedro@email.com');
INSERT INTO Cliente (codigo, nome, email) VALUES (13123, 'RonaldoCli', 'ronaldo@email.com');
INSERT INTO Cliente (codigo, nome, email) VALUES (14123, 'CarlosCli', 'carlos@email.com');
INSERT INTO Cliente (codigo, nome, email) VALUES (15123, 'JuliaCli', 'julia@email.com');

INSERT INTO Assinatura (codigo, codigo_Aplicativo, codigo_Cliente, inicio_Vigencia, fim_Vigencia) VALUES (7123, 1123, 6123, '2024-01-01', '2024-12-31');
INSERT INTO Assinatura (codigo, codigo_Aplicativo, codigo_Cliente, inicio_Vigencia, fim_Vigencia) VALUES (8123, 2123, 7123, '2024-02-01', '2024-11-30');
INSERT INTO Assinatura (codigo, codigo_Aplicativo, codigo_Cliente, inicio_Vigencia, fim_Vigencia) VALUES (9123, 3123, 8123, '2024-03-01', '2024-10-31');

INSERT INTO Promocao (codigo, nome, tipo, valor, ativa) VALUES (10123, 'Promo20', 'Desconto', 20.00, TRUE);
INSERT INTO Promocao (codigo, nome, tipo, valor, ativa) VALUES (11123, 'Promo7', 'Extensão', 7.00, TRUE);

INSERT INTO Pagamento (codigo, codigo_Assinatura, valor_Pago, data_Pagamento, promocao) VALUES (12123, 7123, 19.99, '2024-01-15', 10123);
INSERT INTO Pagamento (codigo, codigo_Assinatura, valor_Pago, data_Pagamento, promocao) VALUES (13123, 8123, 14.99, '2024-02-15', 11123);
INSERT INTO Pagamento (codigo, codigo_Assinatura, valor_Pago, data_Pagamento, promocao) VALUES (14123, 9123, 44.99, '2024-03-15', NULL);