CREATE TABLE pessoa (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(80) ,
    tipo_pessoa VARCHAR(15) ,
    cpf_cnpj VARCHAR(30) ,
    razao_social_ou_rg VARCHAR(30) ,
    telefone VARCHAR(20),
    email VARCHAR(60) ,
    data_nascimento DATE,
    logradouro VARCHAR(50),
    numero VARCHAR(15),
    complemento VARCHAR(20),
	cep VARCHAR(15),
    bairro VARCHAR(60),
    referencia VARCHAR(120),
    codigo_cidade BIGINT(20),
	FOREIGN KEY (codigo_cidade) REFERENCES cidade(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO pessoa (nome, codigo_cidade) VALUES ('Bugrinho',1);
INSERT INTO pessoa (nome, codigo_cidade) VALUES ('Felipe',1);