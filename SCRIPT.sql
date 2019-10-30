
Create TABLE tbuser (
    id int PRIMARY KEY AUTO_INCREMENT,
    nome varchar(100) not null,
    tipo varchar(50) not null,
    pass varchar(128) not null,
    registro varchar(50) not null,
    usuario varchar(100),
    setor varchar(50) not null
    );

    Insert into tbuser (nome, tipo, pass, registro, setor) VALUES ('admin', 'admin', 'dale','000','ADMIN');