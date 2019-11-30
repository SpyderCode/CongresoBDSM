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
idInvestigador INTEGER NOT NULL,
veredicto varchar(10));

create table ArtiRev (
	idArticulo integer not null,
    idRevista integer not null);
    
create table ponencia (
	idPonencia integer primary key,
    nombrePon varchar (25),
    idInvestigador integer not null,
    veredicto varchar(10));
    
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
(2345,"Art1",100,"Aceptado"),
(2346,"Art2",101,"Aceptado"),
(2347,"Art3",102,"Rechazado"),
(2348,"Art4",103,"Rechazado"),
(2349,"Art5",100,"Rechazado");

insert into ponencia values
(1,"Pon1",100,"Aceptado"),
(2,"Pon2",101,"Rechazado"),
(4,"Pon3",102,"Aceptado"),
(6,"Pon4",103,"Rechazado"),
(9,"Pon5",100,"Aceptado");

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




 /* procedure consultas */ 
delimiter //
create procedure consultaArticulo (in idart int(11), nomart varchar(25), idinv varchar (25), vere varchar(10) )
begin
select * from articulo where idArticulo = idart and nombreArt = nomart and veredicto = vere and idinvestigador = idinv;
end;
//

call consultaArticulo(2345,"Art1",100,"Rechazado");

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
  create procedure consultaponencia (in idpon int(11), nom varchar(25), idinves int(11),vere varchar(10))
  begin
  select * from ponencia where idPonencia = idpon and nombrePon = nom and veredicto = vere and idInvestigador = idinves;
  end;
  //
  
  call consultaponencia (6,"Pon4",103,"Aceptado");
  
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
  
  delimiter ;
  
  delimiter //
  create procedure updateArticulo (in idart int(11), nomart varchar(25), idinv varchar (25), vere varchar(10))
  begin
  update articulo set nombreArt= nomart, idInvestigador=idinv ,veredicto = vere where idArticulo=idart;
  end;
  //
  
  delimiter ;
  
  delimiter //
  create procedure updateInvestigador (in idinv int(11),nom varchar(25), apell varchar(25),espe varchar(25))
  begin
  update investigador set nombre = nom, apellido = apell, especialidad = espe where idInvestigador = idinv;
  end;
  //
  
  delimiter ;
  delimiter //
  create procedure updatePonencia(in idpon int(11), nom varchar(25), idinves int(11), vere varchar(10))
  begin
  update ponencia set nombrePon = nom, idInvestigador = idinves, veredicto = vere where idPonencia = idpon;
  end;
  //
  
  delimiter;
  
  delimiter //
  create procedure updateRevista(in idrev int(11), cost float, rele varchar(25), numrev int(11),nom varchar(25),fecha date,tipo varchar(25))
  begin 
  update revista set costo = cost, relevancia = rele, numRevista = numrev, Nombre = nom, fecha = fecha, tipoPub = tipo where idRevista = idrev;
  end;
  //
  
  
  
  
  
  /* procedure altas */
  delimiter //
  create procedure altacongreso (in idcon int(11), nom varchar (25), lug varchar(25), cost float, area varchar(25), rele varchar(25))
  begin
  insert into congreso (idCongreso,Nombre,lugar,costo,AreaInt,relevancia) values ( idcon, nom, lug, cost, area, rele);
  end;
  //

delimiter ;
  call altacongreso(117,"Cong6","Zac",800,"Fisica","alto");
  
  delimiter //
 create procedure altaArticulo (in idart int(11), nomart varchar(25), idinv varchar (25), vere varchar(10))
  begin
  insert into articulo (idArticulo,nombreArt,idInvestigador,veredicto) values ( idart,nomart, idinv,vere);
  end;
  //

delimiter ;
call altaArticulo (2400,"art10",104,"Aceptado");

 delimiter //
 create procedure altaInvestigador (in idinv int(11),nom varchar(25), apell varchar(25),espe varchar(25))
  begin
  insert into investigador (idInvestigador,nombre,apellido,especialidad) values ( idinv, nom,apell,espe);
  end;
  //
  
delimiter ;
call altaInvestigador (105,"Steve","Maincra","Minero");


delimiter //
 create procedure altaponencia(in idpon int(11), nom varchar(25), idinves int(11), vere varchar(10))
  begin
  insert into ponencia (idPonencia,nombrePon,idInvestigador,veredicto) values ( idpon, nom, idinves,vere);
  end;
  //
  
delimiter //
 create procedure altarevista(in idrev int(11), cost float, rele varchar(25), numrev int(11),nom varchar(25),fecha date,tipo varchar(25))
  begin
  insert into revista (idRevista,costo,relevancia,numRevista,Nombre,fecha,tipoPub) values (idrev , cost , rele , numrev ,nom ,fecha ,tipo);
  end;
  //
  
  /* deletes */
  
  delimiter //
  create procedure deletearticulo (in id int(11))
  begin 
  delete from articulo where idArticulo= id;
  end;
  //
  

delimiter //
  create procedure deletecongreso (in id int(11))
  begin 
  delete from congreso where idCongreso= id;
  end;
  //
   
  delimiter //
  create procedure deleterevista (in id int(11))
  begin 
  delete from revista where idRevista= id;
  end;
  //
  
  delimiter //
  create procedure deleteponencia (in id int(11))
  begin 
  delete from ponencia where idPonencia =id;
  end;
  //
 
  
  delimiter //
  create procedure deletinvestigador (in id int(11))
  begin 
  delete from investigador where idInvestigador =id;
  end;
  //

  
  

  
  
  
  