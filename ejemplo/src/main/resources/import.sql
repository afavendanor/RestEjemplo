INSERT INTO cliente(id, nombre, salario, bonificacion, fecha_ingreso, activo) VALUES(10445, 'Andres Avendaño', 1200, 300, SYSDATE(),true);
INSERT INTO cliente(id, nombre, salario, bonificacion, fecha_ingreso, activo) VALUES(43205, 'Lucas Silva', 3420, 230, SYSDATE(),false );
INSERT INTO cliente(id, nombre, salario, bonificacion, fecha_ingreso, activo) VALUES(87340, 'Ana Lopez', 2340, 100, SYSDATE(),false );
INSERT INTO cliente(id, nombre, salario, bonificacion, fecha_ingreso, activo) VALUES(83564, 'Sara Henao', 5430, 300, SYSDATE(), true );
INSERT INTO cliente(id, nombre, salario, bonificacion, fecha_ingreso, activo) VALUES(63875, 'Luis Perez', 4300, 600, SYSDATE(), false);

INSERT INTO cuenta(id_cuenta, id_cliente, tipo, saldo) VALUES(1234, 10445, 'AHORRO', 123400);
INSERT INTO cuenta(id_cuenta, id_cliente, tipo, saldo) VALUES(1235, 63875, 'AHORRO', 34500);
INSERT INTO cuenta(id_cuenta, id_cliente, tipo, saldo) VALUES(1236, 83564, 'AHORRO', 70000);