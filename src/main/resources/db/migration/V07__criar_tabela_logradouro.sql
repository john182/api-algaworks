CREATE TABLE tipo_logradouro
(
  id serial NOT NULL,
  codigo_cadsus character varying(3),
  codigo_dne character varying(8) ,
  flag_ativo integer,
  nome character varying(50) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE logradouro
(
  id serial NOT NULL,
  id_tipo_logradouro INTEGER,
  cep_geral character varying(8),
  epigrafe character varying(500),
  nome character varying(70) NOT NULL,
  nome_exibicao character varying(120),
  PRIMARY KEY (id),
  FOREIGN KEY (id_tipo_logradouro)
  REFERENCES tipo_logradouro (id)
);


insert into tipo_logradouro(id,nome) values(1,'rua');
insert into tipo_logradouro(id,nome) values(2,'avenida');
insert into tipo_logradouro(id,nome) values(3,'praça');


insert into logradouro(nome,id_tipo_logradouro) VALUES ('JOAO',1);
insert into logradouro(nome,id_tipo_logradouro) VALUES ('MARIA',1);
insert into logradouro(nome,id_tipo_logradouro) VALUES ('JOSE',1);
insert into logradouro(nome,id_tipo_logradouro) VALUES ('SEI LA',1);
insert into logradouro(nome,id_tipo_logradouro) VALUES ('TO INDO',1);
insert into logradouro(nome,id_tipo_logradouro) VALUES ('JA VOU',2);
insert into logradouro(nome,id_tipo_logradouro) VALUES ('FULANO',2);
insert into logradouro(nome,id_tipo_logradouro) VALUES ('SICRANO',2);
insert into logradouro(nome,id_tipo_logradouro) VALUES ('SANTO',2);
insert into logradouro(nome,id_tipo_logradouro) VALUES ('RSSSSSSSSSSSS',2);
insert into logradouro(nome,id_tipo_logradouro) VALUES ('KKKKKKKKKKKKK',2);
insert into logradouro(nome,id_tipo_logradouro) VALUES ('ENFIM',2);
insert into logradouro(nome,id_tipo_logradouro) VALUES ('JAVA',3);
insert into logradouro(nome,id_tipo_logradouro) VALUES ('c#',3);
insert into logradouro(nome,id_tipo_logradouro) VALUES ('PHP',3);
insert into logradouro(nome,id_tipo_logradouro) VALUES ('DELPHI',3);
insert into logradouro(nome,id_tipo_logradouro) VALUES ('C++',3);
insert into logradouro(nome,id_tipo_logradouro) VALUES ('C',3);
insert into logradouro(nome,id_tipo_logradouro) VALUES ('KOTLIN',3);

