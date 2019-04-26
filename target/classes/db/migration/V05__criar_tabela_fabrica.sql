CREATE TABLE fabrica (
	codigo BIGINT(2) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(80) NOT NULL,
	cnpj VARCHAR(30) NOT NULL,
	inscricao_estadual VARCHAR(30) NOT NULL,
	razao_social VARCHAR(100) NOT NULL,
	telefone VARCHAR(30) NOT NULL,
	telefone_celular VARCHAR(30) NOT NULL,
	email VARCHAR(80) NOT NULL,
	cep VARCHAR(80) NOT NULL,
	estado VARCHAR(30) NOT NULL,
	cidade VARCHAR(60) NOT NULL,
	logradouro VARCHAR(100) NOT NULL,
	numero VARCHAR(30) NOT NULL,
	bairro VARCHAR(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO fabrica (nome,cnpj, inscricao_estadual,razao_social,telefone,telefone_celular,
					email,cep,estado,cidade,logradouro,numero,bairro ) VALUES 
							('MONNARI JEANS','1111111', '111111', 'Monnari Jeans ME', '4734114000', 'ntem', 
							'marketing@monnari.com.br','8988888', 'SC', 'Navegantes', 'KM 470','10000','Rodovia'); 
							
INSERT INTO fabrica (nome,cnpj, inscricao_estadual,razao_social,telefone,telefone_celular,
					email,cep,estado,cidade,logradouro,numero,bairro ) VALUES 
							('VISUAL JEANS','2222222', '2222222', 'Visual Jeans ME', '159357', 'ntem', 
							'visual@visual.com.br','13467989', 'SC', 'Rio do Sul', 'Rua dos Jeans','200000','Centro'); 							