drop database congreso;
create database congreso;
use congreso;

/*Creacion de tablas*/
 create table investigador (
	idInvestigador integer primary key,
    nombre varchar (25),
    apellido varchar (25),
    especialidad varchar (25));
    
create table articulo (
idArticulo integer primary key,
nombreArt varchar (25),
idInvestigador INTEGER NOT NULL);

create table ArtiRev (
	idArticulo integer not null,
    idRevista integer not null);
    
create table ponencia (
	idPonencia integer primary key,
    nombrePon varchar (25),
    idInvestigador integer not null);
    
create table PonCon (
	idPonencia integer not null,
    idCongreso integer not null);
    
create table congreso (
idCongreso integer primary key,
Nombre varchar (25),
lugar varchar (25),
costo float,
AreaInt varchar (25),
relevancia varchar (25));
    
create table revista (
idRevista integer primary key,
costo float,
relevancia varchar (25),
numRevista integer,
Nombre varchar (25),
fecha date,
tipoPub varchar (25));
    
/*llaves foreign*/    
alter table articulo add foreign key fk_articulo_investigador (idInvestigador) references investigador (idInvestigador);
alter table artirev add foreign key fk_articulo_artirev (idArticulo) references articulo (idArticulo);
alter table artirev add foreign key fk_revista_artirev (idRevista) references revista (idRevista);
alter table ponencia add foreign key fk_ponencia_investigador (idInvestigador) references investigador (idInvestigador);    
alter table poncon add foreign key fk_ponencia_poncon (idPonencia) references ponencia (idPonencia);      
alter table poncon add foreign key fk_congreso_poncon (idCongreso) references congreso (idCongreso);       

/*Añadir datos*/
insert into investigador values
(100,"Roberto","Martinez","Fisica"),
(101,"Maria","Rocha","Botanica"),
(102,"Elena","Juarez","Computacion"),
(103,"Oscar","Gonzales","Fisica"),
(104,"Steve","Jobs","Computacion");

insert into articulo values
(2345,"Art1",100),
(2346,"Art2",101),
(2347,"Art3",102),
(2348,"Art4",103),
(2349,"Art5",100);

insert into ponencia values
(1,"Pon1",100),
(2,"Pon2",101),
(4,"Pon3",102),
(6,"Pon4",103),
(9,"Pon5",100);

insert into congreso values
(112,"Cong1","Zac",705.50,"Computacion","Med"),
(113,"Cong2","Ags",700,"Botanica","Alta"),
(114,"Cong3","Sin",500.50,"Computacion","Baja"),
(115,"Cong4","Sin",339,"Computacion","Alta"),
(116,"Cong5","Zac",420,"Fisica","Med");

insert into revista values
(84,20,"Med",100,"Rev1","2018-03-04","Ciencia"),
(85,20,"Baja",200,"Rev2","2018-07-06","Tecnologia"),
(86,30,"Alta",600,"Rev3","2017-03-01","Ciencia"),
(87,20,"Med",500,"Rev4","2018-01-21","Sociales"),
(88,10,"Baja",5,"Rev5","2016-02-27","Ciencia");

insert into artirev values
(2345,84),
(2346,85),
(2347,86),
(2348,87),
(2349,88);

insert into poncon values
(1,112),
(2,113),
(4,114),
(6,115),
(9,116);

/*Se me olvido lo de aceptado o rechazado xd*/
alter table articulo add aceptado bool;
alter table ponencia add aceptado bool;
update articulo set aceptado = true where (idInvestigador between 100 and 104);
update articulo set aceptado = false where (idInvestigador = 100);
update ponencia set aceptado = true where (idInvestigador between 101 and 104);
update ponencia set aceptado = false where (idInvestigador = 100);

/*3*/
/*mostrar articulos que fueron rechazados*/
select nombreArt from articulo where (aceptado=false);
/*Articulos que fueron aceptados*/
select nombreArt from articulo where (aceptado=true);

/*4*/
select investigador.nombre as NOMBRE, revista.Nombre as REVISTA 
from investigador,artirev,revista,articulo 
where (revista.idRevista=artirev.idRevista) AND 
(artirev.idArticulo=articulo.idArticulo) AND 
(articulo.idInvestigador=investigador.idInvestigador);

/*5*/
select investigador.Nombre as USUARIO, ponencia.nombrePon as PONENCIA 
from investigador,ponencia 
where(investigador.idInvestigador=ponencia.idInvestigador);

/*6*/
select nombrePon from ponencia where (aceptado=false);
select nombrePon from ponencia where (aceptado=true);

/*7*/
select Nombre,nombrePon from congreso,ponencia,poncon
where (ponencia.idPonencia=poncon.idPonencia) 
and (congreso.idCongreso=poncon.idCongreso);

/*8*/
select nombreArt,nomRev from articulo,revista
where (revista.idRevista=artirev.idRevista) AND 
(artirev.idArticulo=articulo.idArticulo) ;

/*9*/
/* congreso */
/* a */
select relevancia from congreso;
/* b */
select costo from congreso;
/* d */
select AreaInt from congreso;
/* revista */
/* a */
select relevancia from revista;
/* b */
select costo from revista;
/* e */
select tipoPub from revista;

/*10*/
select investigador.Nombre as Investigador, Articulo.nombreArt as Articulo, 
ponencia.nombrePon as Ponencia, congreso.Nombre as Congreso, revista.Nombre as Revista 
from articulo,artirev,congreso,investigador,poncon,ponencia,revista 
where (revista.idRevista=artirev.idRevista) AND  
(artirev.idArticulo=articulo.idArticulo) AND  
(articulo.idInvestigador=investigador.idInvestigador) 
AND (investigador.idInvestigador=ponencia.idInvestigador) 
AND  (ponencia.idPonencia=poncon.idPonencia) 
and (poncon.idCongreso =congreso.idCongreso);



/*USUARIOS*/
drop user 'AdminCongreso'@'localhost';
create user 'AdminCongreso'@'localhost' identified by "Qbka4p";
GRANT ALL PRIVILEGES ON congreso.* TO 'AdminCongreso'@'localhost' WITH GRANT OPTION;
create user 'Roberto'@'localhost' identified by "password";
grant select on congreso.* to 'Roberto'@'localhost';





/*TRIGGERS-AUDITORIA*/
create table auditoria_investigador (
	TIPO varchar (25),
	idInvestigador integer,
    nombre varchar (25),
    apellido varchar (25),
    especialidad varchar (25),
    usuario varchar (40),
	modificado datetime
    );

delimiter //
create trigger aud_inv_trig after update on investigador for each row 
begin 
insert into auditoria_investigador (TIPO,idInvestigador,nombre,apellido,especialidad,usuario,modificado)
 values 
("OLD",OLD.idInvestigador,OLD.nombre,OLD.apellido,OLD.especialidad,current_user(), now() ),
("NEW",NEW.idInvestigador,NEW.nombre,NEW.apellido,NEW.especialidad,current_user(), now() );
end; //
delimiter ;

create table auditoria_articulo (
TIPO varchar (25),
idArticulo integer,
nombreArt varchar (25),
idInvestigador INTEGER,
aceptado bool,
usuario varchar (40),
modificado datetime);

delimiter //
create trigger aud_art_trig after update on articulo for each row 
begin 
insert into auditoria_articulo 
(TIPO,idArticulo,nombreArt ,idInvestigador,aceptado,usuario,modificado) 
values 
("OLD",OLD.idArticulo,OLD.nombreArt,OLD.idInvestigador,OLD.aceptado,current_user(), now() ),
("NEW",NEW.idArticulo,NEW.nombreArt,NEW.idInvestigador,NEW.aceptado,current_user(), now() );
end; //
delimiter ;

drop table auditoria_ArtiRev;
create table auditoria_ArtiRev (
	TIPO varchar (25),
	idArticulo integer,
    idRevista integer,
	usuario varchar (40),
	modificado datetime);
    
drop trigger aud_arti_trig;
delimiter //
create trigger aud_arti_trig after update on ArtiRev for each row 
begin 
insert into auditoria_ArtiRev 
(TIPO,idArticulo,idRevista,usuario,modificado)
values 
("OLD",OLD.idArticulo,OLD.idRevista,current_user(), now() ),
("NEW",NEW.idArticulo,NEW.idRevista,current_user(), now() );
end; //
delimiter ;
    
drop table auditoria_ponencia;
create table auditoria_ponencia (
	TIPO varchar (25),
	idPonencia integer,
    nombrePon varchar (25),
    idInvestigador integer,
	usuario varchar (40),
	modificado datetime);
    
drop trigger aud_pon_trig;
delimiter //
create trigger aud_pon_trig after update on ponencia for each row 
begin 
insert into auditoria_ponencia values 
("OLD",OLD.idPonencia,OLD.nombrePon,OLD.idInvestigador,current_user(), now() ),
("NEW",NEW.idPonencia,NEW.nombrePon,OLD.idInvestigador,current_user(), now() );
end; //
delimiter ; 
    
    
drop table auditoria_PonCon;
create table auditoria_PonCon (
	TIPO varchar (25),
	idPonencia integer,
    idCongreso integer,
usuario varchar (40),
modificado datetime);

drop trigger aud_poncon_trig;
delimiter //
create trigger aud_poncon_trig after update on PonCon for each row 
begin 
insert into auditoria_PonCon values 
("OLD",OLD.idPonencia,OLD.idCongreso,current_user(), now() ),
("NEW",NEW.idPonencia,NEW.idCongreso,current_user(), now() );
end; //
delimiter ; 

drop table auditoria_congreso;    
create table auditoria_congreso (
	TIPO varchar (25),
	idCongreso integer,
	Nombre varchar (25),
	lugar varchar (25),
	costo float,
	AreaInt varchar (25),
	relevancia varchar (25),
usuario varchar (40),
modificado datetime);

drop trigger aud_congreso_trig;
delimiter //
create trigger aud_congreso_trig after update on congreso for each row 
begin 
insert into auditoria_congreso values 
("OLD",OLD.idCongreso,OLD.Nombre,OLD.lugar,OLD.costo,OLD.AreaInt,OLD.relevancia,current_user(), now() ),
("NEW",NEW.idCongreso,NEW.Nombre,NEW.lugar,NEW.costo,NEW.AreaInt,NEW.relevancia,current_user(), now() );
end; //
delimiter ; 

drop table auditoria_revista;
CREATE TABLE auditoria_revista (
    TIPO VARCHAR(25),
    idRevista INTEGER,
    costo FLOAT,
    relevancia VARCHAR(25),
    numRevista INTEGER,
    Nombre VARCHAR(25),
    fecha DATE,
    tipoPub VARCHAR(25),
    usuario VARCHAR(40),
    modificado DATETIME
);

drop trigger aud_revista_trig;
delimiter //
create trigger aud_revista_trig after update on revista for each row 
begin 
insert into auditoria_revista
(TIPO,idRevista,costo,relevancia,numRevista,Nombre,fecha,tipoPub,usuario,modificado)
values 
("OLD",OLD.idRevista,OLD.costo,OLD.relevancia,OLD.numRevista,OLD.Nombre,OLD.fecha,OLD.tipoPub,current_user(), now() ),
("NEW",NEW.idRevista,NEW.costo,NEW.relevancia,NEW.numRevista,NEW.Nombre,NEW.fecha,NEW.tipoPub,current_user(), now() );
end; //
delimiter ; 




 /* procedure consultas */ 
delimiter //
create procedure consultaArticulo (in idart int(11), nomart varchar(25), idinv varchar (25) )
begin
select * from articulo where idArticulo = idart and nombreArt = nomart and idinvestigador = idinv;
end;
//

call consultaArticulo(2345,"Art1",100);

delimiter //
create procedure consultaArtirev (in idart int(11), idrevi int (11) )
begin
select * from artirev where idArticulo = idart and idRevista = idrevi;
end;
//

 call consultaArtirev(2346,85); 
 
 delimiter //
 create procedure consultaCongreso (in idcon int(11), nom varchar (25), lug varchar(25), cost float, area varchar(25), rele varchar(25))
 begin
 select * from congreso where idCongreso = idcon and Nombre = nom and lugar= lug and costo = cost and AreaInt = area and relevancia = rele;
 end;
 //
 
  call consultaCongreso (115,"Cong4","Sin",339,"Computacion","Alta");
  
  delimiter //
  create procedure consultainvest (in idinv int(11),nom varchar(25), apell varchar(25),espe varchar(25))
  begin
  select * from investigador where idInvestigador = idinv and nombre= nom and apellido =apell and especialidad = espe;
  end;
  //
  
  call consultainvest (102,"Elena","Juarez","Computacion");
  
  delimiter //
  create procedure consultaponcon (in idpon int(11), idcon int(11))
  begin
  select * from poncon where idPonencia =  idpon and idCongreso = idcon;
  end;
  //
  
  call consultaponcon (4,114);
  
  delimiter //
  create procedure consultaponencia (in idpon int(11), nom varchar(25), idinves int(11))
  begin
  select * from ponencia where idPonencia = idpon and nombrePon = nom and idInvestigador = idinves;
  end;
  //
  
  call consultaponencia (6,"Pon4",103);
  
  delimiter //
  create procedure consultarevista (in idrev int(11), cost float, rele varchar(25), numrev int(11),nom varchar(25),fecha date,tipo varchar(25))
  begin
  select * from revista where idRevista = idrev and costo = cost and relevancia = rele and numRevista = numrev and Nombre = nom and fecha = fecha and tipoPub = tipo;
  end;
  //
  
  /* procedure update */
    /* procedure update */
  delimiter //
  create procedure updateCongreso (in idcon int(11), nom varchar (25), lug varchar(25), cost float, area varchar(25), rele varchar(25))
  begin
  update congreso set Nombre = nom , lugar = lug, costo = cost, AreaInt =area, relevancia = rele where idCongreso= idcon;
  end;
  //
  
  /* procedure altas */
  delimiter //
  create procedure altacongreso (in idcon int(11), nom varchar (25), lug varchar(25), cost float, area varchar(25), rele varchar(25))
  begin
  insert into congreso (idCongreso,Nombre,lugar,costo,AreaInt,relevancia) values ( idcon, nom, lug, cost, area, rele);
  end;
  //

  call altacongreso(117,"Cong6","Zac",800,"Fisica","alto");
  
  delimiter//
 create procedure altaArticulo (in idart int(11), nomart varchar(25), idinv varchar (25),vere tinyInt(1), idrev int(11))
  begin
  insert into articulo (idArticulo,nombreArt,idInvestigador,aceptado) values ( idart,nomart, idinv);
  insert into artirev values (idart,idrev);
  end;
  //

delimiter ;
call altaArticulo (2400,"art10",200);

 delimiter //
 create procedure altaInvestigador (in idinv int(11),nom varchar(25), apell varchar(25),espe varchar(25))
  begin
  insert into investigador (idInvestigador,nombre,apellido,especialidad) values ( idinv, nom,apell,espe);
  end;
  //
  
delimiter ;
call altaInvestigador (105,"Steve","Maincra","Minero");


delimiter //
 create procedure altaponencia(in idpon int(11), nom varchar(25), idinves int(11),idCon int(11))
  begin
  insert into ponencia (idPonencia,nombrePon,idInvestigador) values ( idpon, nom, idinves);
  insert into poncon values (idpon,idCon);
  end;
  //
  
delimiter //
 create procedure altarevista(in idrev int(11), cost float, rele varchar(25), numrev int(11),nom varchar(25),fecha date,tipo varchar(25))
  begin
  insert into revista (idRevista,costo,relevancia,numRevista,Nombre,fecha,tipoPub) values (idrev , cost , rele , numrev ,nom ,fecha ,tipo);
  end;
  //

delimiter // 
  /* procedure delete */

