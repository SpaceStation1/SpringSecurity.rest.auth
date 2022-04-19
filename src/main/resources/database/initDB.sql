


CREATE TABLE if not exists clients  (
	id bigserial,
	password varchar,
	login varchar,
	firstname varchar,
	lastname varchar,
	patronymic varchar,
	birthdate date,
	mail varchar,
	number bigint,
	PRIMARY KEY (id)
);

INSERT INTO clients (id, password, login, firstname, lastname, patronymic, birthdate, mail, number) VALUES
 (1, 'root', 'root', 'костя', 'метелкин', 'андреевич', '2022-03-08', 'mail.ru', 86666666666),
 (2, 'root2', 'root2', 'антон', 'елизаров', 'андреевич', '1998-02-25', 'antonelizarow9987@gmail.com', 89633159306);

CREATE SEQUENCE JPA_SEQUENCE START WITH 3 INCREMENT BY 1 ;     /* при повторном запуске нужно закомментировать эту строчку  */

