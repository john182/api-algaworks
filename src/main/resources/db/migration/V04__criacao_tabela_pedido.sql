CREATE TABLE produto (
  codigo SERIAL NOT NULL,
  nome VARCHAR(30),
  PRIMARY KEY (codigo)
);

INSERT INTO produto(nome) VALUES ('BOLA');
INSERT INTO produto(nome) VALUES ('BISCOITO');
INSERT INTO produto(nome) VALUES ('LAPIS');
INSERT INTO produto(nome) VALUES ('CANETA');
INSERT INTO produto(nome) VALUES ('BORRACHA');


CREATE TABLE pedido (
  codigo SERIAL NOT NULL,
  codigo_pessoa INTEGER NOT NULL,
  data_pedido DATE,
  PRIMARY KEY (codigo),
  FOREIGN KEY (codigo_pessoa) REFERENCES pessoa(codigo)
);

CREATE TABLE pedido_item (
  codigo SERIAL NOT NULL,
  codigo_pedido INTEGER NOT NULL,
  codigo_produto INTEGER NOT NULL,
  quantidade DECIMAL(10,2) NOT NULL,
  valor DECIMAL(10,2) DEFAULT (0),
  sub_total DECIMAL(10,2) DEFAULT (0),
  total DECIMAL(10,2) DEFAULT (0),
  PRIMARY KEY (codigo),
  FOREIGN KEY (codigo_pedido) REFERENCES pedido(codigo),
  FOREIGN KEY (codigo_produto) REFERENCES produto(codigo)
);

INSERT INTO pedido (codigo_pessoa,data_pedido) values (1,'2017-06-10');
INSERT INTO pedido (codigo_pessoa,data_pedido) values (2,'2017-02-10');
INSERT INTO pedido (codigo_pessoa,data_pedido) values (3,'2017-06-10');
INSERT INTO pedido (codigo_pessoa,data_pedido) values (4,'2017-02-10');
INSERT INTO pedido (codigo_pessoa,data_pedido) values (5,'2017-06-10');
INSERT INTO pedido (codigo_pessoa,data_pedido) values (6,'2017-03-10');
INSERT INTO pedido (codigo_pessoa,data_pedido) values (7,'2017-06-10');
INSERT INTO pedido (codigo_pessoa,data_pedido) values (8,'2017-03-10');
INSERT INTO pedido (codigo_pessoa,data_pedido) values (9,'2017-06-10');
INSERT INTO pedido (codigo_pessoa,data_pedido) values (10,'2017-04-10');
INSERT INTO pedido (codigo_pessoa,data_pedido) values (5,'2017-06-10');
INSERT INTO pedido (codigo_pessoa,data_pedido) values (4,'2017-04-10');
INSERT INTO pedido (codigo_pessoa,data_pedido) values (3,'2017-06-10');
INSERT INTO pedido (codigo_pessoa,data_pedido) values (2,'2017-04-10');
INSERT INTO pedido (codigo_pessoa,data_pedido) values (1,'2017-06-10');


INSERT INTO pedido_item (codigo_pedido,codigo_produto,quantidade,valor,sub_total,total) values (1,1,1,4.32,4.32,4.32);
INSERT INTO pedido_item (codigo_pedido,codigo_produto,quantidade,valor,sub_total,total) values (1,2,1,4.32,4.32,4.32);
INSERT INTO pedido_item (codigo_pedido,codigo_produto,quantidade,valor,sub_total,total) values (1,3,1,4.32,4.32,4.32);
INSERT INTO pedido_item (codigo_pedido,codigo_produto,quantidade,valor,sub_total,total) values (1,4,1,4.32,4.32,4.32);
INSERT INTO pedido_item (codigo_pedido,codigo_produto,quantidade,valor,sub_total,total) values (1,5,1,4.32,4.32,4.32);

INSERT INTO pedido_item (codigo_pedido,codigo_produto,quantidade,valor,sub_total,total) values (2,1,1,4.32,4.32,4.32);
INSERT INTO pedido_item (codigo_pedido,codigo_produto,quantidade,valor,sub_total,total) values (2,2,1,4.32,4.32,4.32);
INSERT INTO pedido_item (codigo_pedido,codigo_produto,quantidade,valor,sub_total,total) values (2,3,1,4.32,4.32,4.32);
INSERT INTO pedido_item (codigo_pedido,codigo_produto,quantidade,valor,sub_total,total) values (2,4,1,4.32,4.32,4.32);
INSERT INTO pedido_item (codigo_pedido,codigo_produto,quantidade,valor,sub_total,total) values (2,5,1,4.32,4.32,4.32);

INSERT INTO pedido_item (codigo_pedido,codigo_produto,quantidade,valor,sub_total,total) values (3,1,1,4.32,4.32,4.32);
INSERT INTO pedido_item (codigo_pedido,codigo_produto,quantidade,valor,sub_total,total) values (3,2,1,4.32,4.32,4.32);
INSERT INTO pedido_item (codigo_pedido,codigo_produto,quantidade,valor,sub_total,total) values (3,3,1,4.32,4.32,4.32);
INSERT INTO pedido_item (codigo_pedido,codigo_produto,quantidade,valor,sub_total,total) values (3,4,1,4.32,4.32,4.32);
INSERT INTO pedido_item (codigo_pedido,codigo_produto,quantidade,valor,sub_total,total) values (3,5,1,4.32,4.32,4.32);


INSERT INTO pedido_item (codigo_pedido,codigo_produto,quantidade,valor,sub_total,total) values (4,1,1,4.32,4.32,4.32);
INSERT INTO pedido_item (codigo_pedido,codigo_produto,quantidade,valor,sub_total,total) values (4,2,1,4.32,4.32,4.32);
INSERT INTO pedido_item (codigo_pedido,codigo_produto,quantidade,valor,sub_total,total) values (4,3,1,4.32,4.32,4.32);
INSERT INTO pedido_item (codigo_pedido,codigo_produto,quantidade,valor,sub_total,total) values (4,4,1,4.32,4.32,4.32);
INSERT INTO pedido_item (codigo_pedido,codigo_produto,quantidade,valor,sub_total,total) values (4,5,1,4.32,4.32,4.32);

INSERT INTO pedido_item (codigo_pedido,codigo_produto,quantidade,valor,sub_total,total) values (5,1,1,4.32,4.32,4.32);
INSERT INTO pedido_item (codigo_pedido,codigo_produto,quantidade,valor,sub_total,total) values (5,2,1,4.32,4.32,4.32);
INSERT INTO pedido_item (codigo_pedido,codigo_produto,quantidade,valor,sub_total,total) values (5,3,1,4.32,4.32,4.32);
INSERT INTO pedido_item (codigo_pedido,codigo_produto,quantidade,valor,sub_total,total) values (5,4,1,4.32,4.32,4.32);
INSERT INTO pedido_item (codigo_pedido,codigo_produto,quantidade,valor,sub_total,total) values (5,5,1,4.32,4.32,4.32);


INSERT INTO pedido_item (codigo_pedido,codigo_produto,quantidade,valor,sub_total,total) values (6,1,1,4.32,4.32,4.32);
INSERT INTO pedido_item (codigo_pedido,codigo_produto,quantidade,valor,sub_total,total) values (6,2,1,4.32,4.32,4.32);
INSERT INTO pedido_item (codigo_pedido,codigo_produto,quantidade,valor,sub_total,total) values (6,3,1,4.32,4.32,4.32);
INSERT INTO pedido_item (codigo_pedido,codigo_produto,quantidade,valor,sub_total,total) values (6,4,1,4.32,4.32,4.32);
INSERT INTO pedido_item (codigo_pedido,codigo_produto,quantidade,valor,sub_total,total) values (6,5,1,4.32,4.32,4.32);

INSERT INTO pedido_item (codigo_pedido,codigo_produto,quantidade,valor,sub_total,total) values (7,1,1,4.32,4.32,4.32);
INSERT INTO pedido_item (codigo_pedido,codigo_produto,quantidade,valor,sub_total,total) values (7,2,1,4.32,4.32,4.32);
INSERT INTO pedido_item (codigo_pedido,codigo_produto,quantidade,valor,sub_total,total) values (7,3,1,4.32,4.32,4.32);
INSERT INTO pedido_item (codigo_pedido,codigo_produto,quantidade,valor,sub_total,total) values (7,4,1,4.32,4.32,4.32);
INSERT INTO pedido_item (codigo_pedido,codigo_produto,quantidade,valor,sub_total,total) values (7,5,1,4.32,4.32,4.32);

INSERT INTO pedido_item (codigo_pedido,codigo_produto,quantidade,valor,sub_total,total) values (8,1,1,4.32,4.32,4.32);
INSERT INTO pedido_item (codigo_pedido,codigo_produto,quantidade,valor,sub_total,total) values (8,2,1,4.32,4.32,4.32);
INSERT INTO pedido_item (codigo_pedido,codigo_produto,quantidade,valor,sub_total,total) values (8,3,1,4.32,4.32,4.32);
INSERT INTO pedido_item (codigo_pedido,codigo_produto,quantidade,valor,sub_total,total) values (8,4,1,4.32,4.32,4.32);
INSERT INTO pedido_item (codigo_pedido,codigo_produto,quantidade,valor,sub_total,total) values (8,5,1,4.32,4.32,4.32);


INSERT INTO pedido_item (codigo_pedido,codigo_produto,quantidade,valor,sub_total,total) values (9,1,1,4.32,4.32,4.32);
INSERT INTO pedido_item (codigo_pedido,codigo_produto,quantidade,valor,sub_total,total) values (9,2,1,4.32,4.32,4.32);
INSERT INTO pedido_item (codigo_pedido,codigo_produto,quantidade,valor,sub_total,total) values (9,3,1,4.32,4.32,4.32);
INSERT INTO pedido_item (codigo_pedido,codigo_produto,quantidade,valor,sub_total,total) values (9,4,1,4.32,4.32,4.32);
INSERT INTO pedido_item (codigo_pedido,codigo_produto,quantidade,valor,sub_total,total) values (9,5,1,4.32,4.32,4.32);

INSERT INTO pedido_item (codigo_pedido,codigo_produto,quantidade,valor,sub_total,total) values (10,1,1,4.32,4.32,4.32);
INSERT INTO pedido_item (codigo_pedido,codigo_produto,quantidade,valor,sub_total,total) values (10,2,1,4.32,4.32,4.32);
INSERT INTO pedido_item (codigo_pedido,codigo_produto,quantidade,valor,sub_total,total) values (10,3,1,4.32,4.32,4.32);
INSERT INTO pedido_item (codigo_pedido,codigo_produto,quantidade,valor,sub_total,total) values (10,4,1,4.32,4.32,4.32);
INSERT INTO pedido_item (codigo_pedido,codigo_produto,quantidade,valor,sub_total,total) values (10,5,1,4.32,4.32,4.32);