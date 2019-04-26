CREATE TABLE estacao_romaneio (
    codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    ano DATE NOT NULL,
    estacao_nome VARCHAR(30) NOT NULL,
    status BOOLEAN NOT NULL,
    codigo_fabrica BIGINT(20),
    FOREIGN KEY (codigo_fabrica) REFERENCES fabrica(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO estacao_romaneio (ano, estacao_nome, status, codigo_fabrica) VALUES	('2019-04-24', 'Alto Verão', true, 1);
INSERT INTO estacao_romaneio (ano, estacao_nome, status, codigo_fabrica) VALUES	('2019-04-24', 'Alto Inverno', true, 1);
INSERT INTO estacao_romaneio (ano, estacao_nome, status, codigo_fabrica) VALUES	('2019-04-24', 'Alto Verão', true, 2);
INSERT INTO estacao_romaneio (ano, estacao_nome, status, codigo_fabrica) VALUES	('2019-04-24', 'Alto Inverno', true, 2);
INSERT INTO estacao_romaneio (ano, estacao_nome, status, codigo_fabrica) VALUES	('2019-04-24', 'Verão', true, 2);
INSERT INTO estacao_romaneio (ano, estacao_nome, status, codigo_fabrica) VALUES	('2019-04-24', 'Verão', true, 2);