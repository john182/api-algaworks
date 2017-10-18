CREATE TABLE categoria (
  codigo SERIAL NOT NULL,
  nome VARCHAR(30),
  PRIMARY KEY (codigo)
);

INSERT INTO categoria(nome) VALUES ('LAZER');
INSERT INTO categoria(nome) VALUES ('ALOMENTACAO');
INSERT INTO categoria(nome) VALUES ('SUPERMECADO');
INSERT INTO categoria(nome) VALUES ('FARMACIA');
INSERT INTO categoria(nome) VALUES ('OUTROS');
