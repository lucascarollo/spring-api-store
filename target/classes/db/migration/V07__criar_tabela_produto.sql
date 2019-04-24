CREATE TABLE produto (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	referencia VARCHAR(50) NOT NULL,
    cor VARCHAR(100),
    descricao VARCHAR(150),
    tamanho VARCHAR(100),
	preco DECIMAL(10,2) NOT NULL,
	estacao_romaneio_codigo BIGINT(20) NOT NULL,
	FOREIGN KEY (estacao_romaneio_codigo) REFERENCES estacao_romaneio(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO produto (referencia, cor, descricao, tamanho, preco, estacao_romaneio_codigo) VALUES ('FEL04', 'AZUL MARINHO', 'CALÇA MASCULINA', '38', 69.92, 1);
INSERT INTO produto (referencia, cor, descricao, tamanho, preco, estacao_romaneio_codigo) VALUES ('FEL05', 'AZUL', 'CALÇA FEMININA', '34', 99.92, 2);
INSERT INTO produto (referencia, cor, descricao, tamanho, preco, estacao_romaneio_codigo) VALUES ('FEL06', 'VERMELHO MARINHO', 'BERMUDA', '42', 169.92, 1);
INSERT INTO produto (referencia, cor, descricao, tamanho, preco, estacao_romaneio_codigo) VALUES ('FEL07', 'PRATA MARINHO', 'CAMISA POLO', 'M', 369.92, 1);
INSERT INTO produto (referencia, cor, descricao, tamanho, preco, estacao_romaneio_codigo) VALUES ('FEL08', 'VERTIGEM MARINHO', 'CAMISETA GOLA CANOA', 'P', 99.99, 2);