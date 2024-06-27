-- Insere dados na tabela de aplicativos
INSERT INTO aplicativos (nome, custo_mensal) VALUES ('App Pro', 19.99);
INSERT INTO aplicativos (nome, custo_mensal) VALUES ('App Basic', 9.99);
INSERT INTO aplicativos (nome, custo_mensal) VALUES ('Super App', 29.99);
INSERT INTO aplicativos (nome, custo_mensal) VALUES ('Educação Plus', 15.49);
INSERT INTO aplicativos (nome, custo_mensal) VALUES ('Saúde Total', 25.00);
INSERT INTO aplicativos (nome, custo_mensal) VALUES ('Financeiro Fácil', 12.99);
INSERT INTO aplicativos (nome, custo_mensal) VALUES ('Culinária Master', 14.99);

-- Insere dados na tabela de clientes
INSERT INTO clientes (nome, email) VALUES ('John Doe', 'john.doe@example.com');
INSERT INTO clientes (nome, email) VALUES ('Jane Doe', 'jane.doe@example.com');
INSERT INTO clientes (nome, email) VALUES ('Carlos Silva', 'carlos.silva@example.com');
INSERT INTO clientes (nome, email) VALUES ('Ana Paula', 'ana.paula@example.com');
INSERT INTO clientes (nome, email) VALUES ('Roberto Dias', 'roberto.dias@example.com');
INSERT INTO clientes (nome, email) VALUES ('Mariana Alves', 'mariana.alves@example.com');
INSERT INTO clientes (nome, email) VALUES ('Fernanda Costa', 'fernanda.costa@example.com');

-- Insere dados na tabela de assinaturas
INSERT INTO assinaturas (cliente_id, aplicativo_id, inicio_vigencia, fim_vigencia) VALUES (1, 1, '2023-01-01', '2024-01-01');
INSERT INTO assinaturas (cliente_id, aplicativo_id, inicio_vigencia, fim_vigencia) VALUES (2, 2, '2023-02-01', '2024-02-01');
INSERT INTO assinaturas (cliente_id, aplicativo_id, inicio_vigencia, fim_vigencia) VALUES (3, 3, '2023-03-01', '2024-03-01');
INSERT INTO assinaturas (cliente_id, aplicativo_id, inicio_vigencia, fim_vigencia) VALUES (4, 4, '2023-04-01', '2024-04-01');
INSERT INTO assinaturas (cliente_id, aplicativo_id, inicio_vigencia, fim_vigencia) VALUES (5, 5, '2023-05-01', '2024-05-01');
INSERT INTO assinaturas (cliente_id, aplicativo_id, inicio_vigencia, fim_vigencia) VALUES (6, 6, '2023-06-01', '2024-06-01');
INSERT INTO assinaturas (cliente_id, aplicativo_id, inicio_vigencia, fim_vigencia) VALUES (7, 7, '2023-07-01', '2024-07-01');

-- Insere dados na tabela de pagamentos
INSERT INTO pagamentos (assinatura_id, valor_pago, data_pagamento) VALUES (1, 19.99, '2023-01-01');
INSERT INTO pagamentos (assinatura_id, valor_pago, data_pagamento) VALUES (2, 9.99, '2023-02-01');
INSERT INTO pagamentos (assinatura_id, valor_pago, data_pagamento) VALUES (3, 29.99, '2023-03-01');
INSERT INTO pagamentos (assinatura_id, valor_pago, data_pagamento) VALUES (4, 15.49, '2023-04-01');
INSERT INTO pagamentos (assinatura_id, valor_pago, data_pagamento) VALUES (5, 25.00, '2023-05-01');
INSERT INTO pagamentos (assinatura_id, valor_pago, data_pagamento) VALUES (6, 12.99, '2023-06-01');
INSERT INTO pagamentos (assinatura_id, valor_pago, data_pagamento) VALUES (7, 14.99, '2023-07-01');

-- Insere dados na tabela de promoções
INSERT INTO promocoes (descricao, desconto) VALUES ('Promo Verão', 15.00);
INSERT INTO promocoes (descricao, desconto) VALUES ('Desconto Anual', 20.00);
INSERT INTO promocoes (descricao, desconto) VALUES ('Desconto de Inverno', 10.00);
INSERT INTO promocoes (descricao, desconto) VALUES ('Promoção de Natal', 30.00);
INSERT INTO promocoes (descricao, desconto) VALUES ('Oferta de Ano Novo', 25.00);
INSERT INTO promocoes (descricao, desconto) VALUES ('Desconto Primavera', 5.00);
INSERT INTO promocoes (descricao, desconto) VALUES ('Promoção Black Friday', 50.00);
