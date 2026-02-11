-- -----------------------------
-- Inserción de categorías
-- -----------------------------
INSERT INTO CATEGORIAS (id,nombre) VALUES (1,'Alevin');
INSERT INTO CATEGORIAS (id,nombre) VALUES (2,'Infantil');
INSERT INTO CATEGORIAS (id,nombre) VALUES (3,'Cadete');
INSERT INTO CATEGORIAS (id,nombre) VALUES (4,'Juvenil');
INSERT INTO CATEGORIAS (id,nombre) VALUES (5,'Senior');

-- -----------------------------
-- Inserción de jugadores
-- -----------------------------
-- Senior
INSERT INTO JUGADORES (nombre, apellido, edad, pierna_habil, email, categoria_id) 
VALUES ('Marcos', 'Perez', 30, 'Derecha', 'marcos@gmail.com', 5);

INSERT INTO JUGADORES (nombre, apellido, edad, pierna_habil, email, categoria_id) 
VALUES ('Raquel', 'Prieto', 29, 'Derecha', 'raquel@gmail.com', 5);

INSERT INTO JUGADORES (nombre, apellido, edad, pierna_habil, email, categoria_id) 
VALUES ('David', 'Lopez', 27, 'Izquierda', 'david@gmail.com', 5);

INSERT INTO JUGADORES (nombre, apellido, edad, pierna_habil, email, categoria_id) 
VALUES ('Mario', 'Del Rincon', 26, 'Derecha', 'mario@gmail.com', 5);

INSERT INTO JUGADORES (nombre, apellido, edad, pierna_habil, email, categoria_id) 
VALUES ('Laura', 'Sanchez', 24, 'Derecha', 'laura@gmail.com', 5);

-- Juvenil
INSERT INTO JUGADORES (nombre, apellido, edad, pierna_habil, email, categoria_id) 
VALUES ('Carlos', 'Martin', 18, 'Derecha', 'carlos@gmail.com', 4);

INSERT INTO JUGADORES (nombre, apellido, edad, pierna_habil, email, categoria_id) 
VALUES ('Paula', 'Gomez', 17, 'Izquierda', 'paula@gmail.com', 4);

INSERT INTO JUGADORES (nombre, apellido, edad, pierna_habil, email, categoria_id) 
VALUES ('Adrian', 'Ruiz', 16, 'Derecha', 'adrian@gmail.com', 4);

INSERT INTO JUGADORES (nombre, apellido, edad, pierna_habil, email, categoria_id) 
VALUES ('Sara', 'Navarro', 17, 'Derecha', 'sara@gmail.com', 4);

INSERT INTO JUGADORES (nombre, apellido, edad, pierna_habil, email, categoria_id) 
VALUES ('Javier', 'Molina', 18, 'Izquierda', 'javier@gmail.com', 4);

-- Cadete
INSERT INTO JUGADORES (nombre, apellido, edad, pierna_habil, email, categoria_id) 
VALUES ('Lucia', 'Ortega', 15, 'Derecha', 'lucia@gmail.com', 3);

INSERT INTO JUGADORES (nombre, apellido, edad, pierna_habil, email, categoria_id) 
VALUES ('Pablo', 'Castro', 14, 'Derecha', 'pablo@gmail.com', 3);

INSERT INTO JUGADORES (nombre, apellido, edad, pierna_habil, email, categoria_id) 
VALUES ('Elena', 'Vega', 15, 'Izquierda', 'elena@gmail.com', 3);

INSERT INTO JUGADORES (nombre, apellido, edad, pierna_habil, email, categoria_id) 
VALUES ('Diego', 'Ramos', 14, 'Derecha', 'diego@gmail.com', 3);

INSERT INTO JUGADORES (nombre, apellido, edad, pierna_habil, email, categoria_id) 
VALUES ('Nerea', 'Blanco', 15, 'Derecha', 'nerea@gmail.com', 3);

-- Infantil
INSERT INTO JUGADORES (nombre, apellido, edad, pierna_habil, email, categoria_id) 
VALUES ('Hugo', 'Iglesias', 13, 'Izquierda', 'hugo@gmail.com', 2);

INSERT INTO JUGADORES (nombre, apellido, edad, pierna_habil, email, categoria_id) 
VALUES ('Marta', 'Flores', 12, 'Derecha', 'marta@gmail.com', 2);

INSERT INTO JUGADORES (nombre, apellido, edad, pierna_habil, email, categoria_id) 
VALUES ('Alex', 'Herrera', 13, 'Derecha', 'alex@gmail.com', 2);

INSERT INTO JUGADORES (nombre, apellido, edad, pierna_habil, email, categoria_id) 
VALUES ('Clara', 'Moreno', 12, 'Izquierda', 'clara@gmail.com', 2);

INSERT INTO JUGADORES (nombre, apellido, edad, pierna_habil, email, categoria_id) 
VALUES ('Ivan', 'Gil', 13, 'Derecha', 'ivan@gmail.com', 2);

-- Alevin
INSERT INTO JUGADORES (nombre, apellido, edad, pierna_habil, email, categoria_id) 
VALUES ('Leo', 'Cano', 11, 'Derecha', 'leo@gmail.com', 1);

INSERT INTO JUGADORES (nombre, apellido, edad, pierna_habil, email, categoria_id) 
VALUES ('Noa', 'Serrano', 10, 'Izquierda', 'noa@gmail.com', 1);

INSERT INTO JUGADORES (nombre, apellido, edad, pierna_habil, email, categoria_id) 
VALUES ('Daniel', 'Rey', 9, 'Derecha', 'daniel@gmail.com', 1);

INSERT INTO JUGADORES (nombre, apellido, edad, pierna_habil, email, categoria_id) 
VALUES ('Irene', 'Pascual', 11, 'Derecha', 'irene@gmail.com', 1);

INSERT INTO JUGADORES (nombre, apellido, edad, pierna_habil, email, categoria_id) 
VALUES ('Samuel', 'Aguilar', 10, 'Izquierda', 'samuel@gmail.com', 1);
