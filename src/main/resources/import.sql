INSERT INTO tb_department(name) VALUES ('RH');
INSERT INTO tb_department(name) VALUES ('TI');

INSERT INTO tb_user(department_id, email, senha) VALUES (1, 'teste', '123');
INSERT INTO tb_user(department_id, name, email) VALUES (1, 'Maria', 'maria@gmail.com');
INSERT INTO tb_user(department_id, name, email) VALUES (2, 'Alex', 'alex@gmail.com');
INSERT INTO tb_user(department_id, name, email) VALUES (1, 'Bob', 'bob@gmail.com');
INSERT INTO tb_user(department_id, name, email) VALUES (2, 'Ana', 'ana@gmail.com');
INSERT INTO administrador(cracha, email, nascimento, nome, senha, telefone, id) VALUES ('cracha','teste', '10/04/2000', 'insertteste', '123', 'TELEFONE', 1);