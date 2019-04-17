CREATE TABLE categoria (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO categoria (nome) values ('Lazer');
INSERT INTO categoria (nome) values ('Mercado');
INSERT INTO categoria (nome) values ('Higiene Pessoal');
INSERT INTO categoria (nome) values ('Alimentação');
INSERT INTO categoria (nome) values ('Fast Food');
INSERT INTO categoria (nome) values ('Farmácia');
INSERT INTO categoria (nome) values ('Outros');