CREATE TABLE pedido_venda (

    codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    transportadora VARCHAR(75),
    data_criacao DATETIME,
    data_emissao DATE,
    valor_total_bruto DECIMAL(10,2),
    valor_total_liquido DECIMAL(10,2), 
    valor_total_acrescimo DECIMAL(10,2),
    valor_total_desconto DECIMAL(10,2),
    valor_total_acrescimo_itens DECIMAL(10,2) ,
    valor_total_desconto_itens DECIMAL(10,2) ,
    status_pedido VARCHAR(30) NOT NULL,
    observacao VARCHAR(200),
    data_entrega DATE,
    
    codigo_cliente BIGINT(20) NOT NULL,
    codigo_vendedor BIGINT(20) NOT NULL,
    codigo_fabrica BIGINT(20) NOT NULL,
    
    FOREIGN KEY (codigo_cliente) REFERENCES pessoa(codigo),
    FOREIGN KEY (codigo_vendedor) REFERENCES vendedor(codigo),
    FOREIGN KEY (codigo_fabrica) REFERENCES fabrica(codigo)
    
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE pedido_venda_item (

    codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    quantidade INTEGER NOT NULL,
    
    valor_unitario DECIMAL(10,2) ,
    valor_total_bruto DECIMAL(10,2) ,
    valor_total_liquido DECIMAL(10,2) ,
    valor_total_desconto DECIMAL(10,2) ,
    valor_total_acrescimo DECIMAL(10,2) ,
    
    codigo_pedido_venda BIGINT(20) NOT NULL,
    codigo_produto BIGINT(20) NOT NULL,
    
    FOREIGN KEY (codigo_pedido_venda) REFERENCES pedido_venda(codigo),
    FOREIGN KEY (codigo_produto) REFERENCES produto(codigo)
    
) ENGINE=InnoDB DEFAULT CHARSET=utf8;