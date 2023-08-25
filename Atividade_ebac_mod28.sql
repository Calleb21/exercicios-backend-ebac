CREATE TABLE Cliente (
	id serial PRIMARY KEY,
	nome VARCHAR(55) NOT NULL,
	email VARCHAR(55) NOT NULL,
	telefone VARCHAR(15)
);

CREATE TABLE Produto (
	id serial PRIMARY KEY,
	nome VARCHAR(55) NOT NULL,
	preco DECIMAL(10, 2) NOT NULL
);	

CREATE TABLE Venda (
	id serial PRIMARY KEY,
	cliente_id INT REFERENCES Cliente(id),
	data_venda DATE NOT NULL,
	total DECIMAL(10, 2) NOT NULL
);

SELECT * FROM Cliente;
SELECT * FROM Produto;
SELECT * FROM Venda;

INSERT INTO Cliente (nome, email, telefone) VALUES
('Calleb Camargo', 'camargocalleb12@gmail.com', '(64)99333-1088'),
('Camargo Calleb', 'callebcamargo12@gmail.com', '(64)33399-8801');

INSERT INTO Produto (nome, preco) VALUES
('Produto Teste A', 29.39),
('Produto Teste B', 99.46),
('Produto Teste C', 102.99);

INSERT INTO Venda (cliente_id, data_venda, total) VALUES
(1, '11-04-2023', 59.76),
(2, '22-02-2019', 100.00);