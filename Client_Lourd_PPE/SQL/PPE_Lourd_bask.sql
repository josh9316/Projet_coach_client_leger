drop database if exists clourd_bask ; 
create database clourd_bask; 
use clourd_bask; 

create table club (
	idclub int(5) not null auto_increment, 
	nom varchar(50),
	adresse varchar(50), 
	email varchar(50), 
	tel varchar(20), 
	primary key(idclub)  
);

create table exercice (
	idexo int(5) not null auto_increment, 
	nom varchar(50), 
	dateExo date, 
	tempsExo int, 
	difficulteExo varchar(50),
	idclub int(5) not null, 
	primary key(idexo), 
	foreign key (idclub) references club(idclub)
);

create table coach (
	idcoach int(5) not null auto_increment, 
	nom varchar(50), 
	prenom varchar(50), 
	qualification varchar(50), 
	email varchar(50), 
	mdp varchar(50),
	tel varchar(20), 
	primary key(idcoach)
);


delimiter $
create procedure deleteclub (IN p_idclub INT)
Begin
delete from intervention where idtel in
	(select idexo from exercice where idclub = p_idclub);
	delete from exercice where idlcient = p_idclub;
	delete from club where idclub = p_idlclub;

End $

delimiter ;
