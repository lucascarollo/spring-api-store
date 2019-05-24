CREATE TABLE vendedor (

  	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	codigo_pessoa BIGINT(20) ,
	ativo BOOLEAN ,
	data_admissao DATE,
	data_demissao DATE,
  FOREIGN KEY (codigo_pessoa) REFERENCES pessoa(codigo)
  
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO vendedor (codigo_pessoa,ativo) VALUES (1, true);
INSERT INTO vendedor (codigo_pessoa,ativo) VALUES (2, true);