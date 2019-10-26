Create TABLE tbuser (
    id int PRIMARY KEY AUTO_INCREMENT,
    nome varchar(100) not null,
    tipo varchar(50) not null,
    pass varchar(128) not null
    );

    Insert into tbuser (nome, tipo, pass) VALUES ('admin', 'admin', 'dale');