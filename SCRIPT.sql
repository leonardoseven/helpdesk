
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
    
CREATE table tbsetor ( 
	id int PRIMARY KEY AUTO_INCREMENT, 
	nome varchar(30) not null, 
	nome_gestor varchar(30) not null 
	);
	
create table tbcomponente (
	id int PRIMARY KEY AUTO_INCREMENT,
    nome varchar(50) not null,
    descricao varchar(50) not null,
    preco decimal(10,2) not null,
    quantidade int not null

);