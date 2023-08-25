create table produto (
	id bigint not null,
	nome varchar(50) not null,
	preco decimal constraint check_idade CHECK (preco > 0)
);

INSERT INTO tb_produto (id, nome, preco)
VALUES (1, 'Manga', 3.5);
INSERT INTO tb_produto (id, nome, preco)
VALUES (2, 'Beterraba', 2.43);
INSERT INTO tb_produto (id, nome, preco)
VALUES (3, 'Mamão', 5.50);

ALTER TABLE tb_produto RENAME COLUMN nome TO nome_prod;

DELETE FROM tb_produto
WHERE id = 2;

select * from tb_produto

ALTER TABLE produto RENAME TO tb_produto;

DROP TABLE tb_produto;