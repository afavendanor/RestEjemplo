INSERT INTO cliente(nombre, salario, bonificacion, fecha_ingreso, activo) VALUES('Andres Avendano', 1200, 300, SYSDATE(),true);
INSERT INTO cliente(nombre, salario, bonificacion, fecha_ingreso, activo) VALUES('Lucas Silva', 3420, 230, SYSDATE()-68,false );
INSERT INTO cliente(nombre, salario, bonificacion, fecha_ingreso, activo) VALUES('Ana Lopez', 2340, 100, SYSDATE()-984,true );
INSERT INTO cliente(nombre, salario, bonificacion, fecha_ingreso, activo) VALUES('Sara Henao', 5430, 300, SYSDATE(), true );
INSERT INTO cliente(nombre, salario, bonificacion, fecha_ingreso, activo) VALUES('Luis Perez', 4300, 600, SYSDATE()-354, false);

INSERT INTO cuenta(id_cliente, tipo, saldo) VALUES(10445, 'AHORROS', 123400);
INSERT INTO cuenta(id_cliente, tipo, saldo) VALUES(63875, 'AHORROS', 34500);
INSERT INTO cuenta(id_cliente, tipo, saldo) VALUES(83564, 'CORRIENTE', 70000);