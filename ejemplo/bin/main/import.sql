INSERT INTO CLIENTE(id, nombre, salario, bonificacion, fecha_ingreso, activo) VALUES('10445', 'Andres Avendaño', 1200, 300, SYSDATE(), true);
INSERT INTO CLIENTE(id, nombre, salario, bonificacion, fecha_ingreso, activo) VALUES('43205', 'Lucas Silva', 3420, 230, SYSDATE(), false);
INSERT INTO CLIENTE(id, nombre, salario, bonificacion, fecha_ingreso, activo) VALUES('87340', 'Ana Lopez', 2340, 100, SYSDATE(), true);
INSERT INTO CLIENTE(id, nombre, salario, bonificacion, fecha_ingreso, activo) VALUES('83564', 'Sara Henao', 5430, 300, SYSDATE(), false);
INSERT INTO CLIENTE(id, nombre, salario, bonificacion, fecha_ingreso, activo) VALUES('63875', 'Luis Perez', 4300, 600, SYSDATE(), true);


INSERT INTO cuenta(cliente_id, cuenta_id, tipo, saldo) VALUES(10445, 1234, 'AHORRO', 123400);
INSERT INTO cuenta(cliente_id, cuenta_id, tipo, saldo) VALUES(63875, 3421, 'AHORRO', 34500);
INSERT INTO cuenta(cliente_id, cuenta_id, tipo, saldo) VALUES(10445, 4332, 'AHORRO', 70000);
