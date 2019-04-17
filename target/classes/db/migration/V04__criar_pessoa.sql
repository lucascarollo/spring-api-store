CREATE TABLE pessoa (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(80) NOT NULL,
    tipo_pessoa VARCHAR(15) NOT NULL,
    cpf_cnpj VARCHAR(30) NOT NULL,
    razao_social_ou_rg VARCHAR(30) NOT NULL,
    telefone VARCHAR(20),
    email VARCHAR(60) NOT NULL,
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