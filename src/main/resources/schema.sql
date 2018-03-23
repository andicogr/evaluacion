
create table cliente
(
   id integer not null,
   name varchar(255) not null,
   correo varchar(255) not null,
   primary key(id)
);

create table alumno
(
   id integer not null,
   nombre varchar(255) not null,
   nota integer,
   primary key(id)
);


INSERT INTO cliente VALUES (1, 'admin','admin@admin.com');

INSERT INTO cliente VALUES (2, 'john','john@gmail.com');

INSERT INTO cliente VALUES (3, 'sham','sham@yahoo.com');
