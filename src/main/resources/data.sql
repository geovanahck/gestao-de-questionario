INSERT INTO administrador( cracha, email, nome, telefone) VALUES ( '1','ativo@gmail.com', 'mateus', '99999 9999');
INSERT INTO administrador( cracha, email, nome, telefone) VALUES ( '2','inativo@gmail.com', 'teste2', '8888 9999');
INSERT INTO administrador( cracha, email, nome, telefone) VALUES ( '3','ativo@gmail.com', 'teste3', '8888 9999');
INSERT INTO administrador( cracha, email, nome, telefone) VALUES ( '4','teste1@gmail.com', 'teste4', '99999 9999');
INSERT INTO administrador( cracha, email, nome, telefone) VALUES ( '5','teste2@gmail.com', 'teste5', '8888 9999');
INSERT INTO administrador( cracha, email, nome, telefone) VALUES ( '6','teste1@gmail.com', 'teste6', '99999 9999');
INSERT INTO administrador( cracha, email, nome, telefone) VALUES ( '8','teste1@gmail.com', 'teste8', '99999 9999');
INSERT INTO administrador( cracha, email, nome, telefone) VALUES ( '9','teste2@gmail.com', 'teste9', '8888 9999');
INSERT INTO administrador( cracha, email, nome, telefone) VALUES ( '10','teste1@gmail.com', 'teste10', '99999 9999');
INSERT INTO administrador( cracha, email, nome, telefone) VALUES ( '11','teste2@gmail.com', 'teste11', '8888 9999');
INSERT INTO administrador( cracha, email, nome, telefone) VALUES ( '12','teste1@gmail.com', 'teste12', '99999 9999');
INSERT INTO administrador( cracha, email, nome, telefone) VALUES ( '13','teste2@gmail.com', 'teste13', '8888 9999');
INSERT INTO administrador( cracha, email, nome, telefone) VALUES ( '14','teste1@gmail.com', 'teste14', '99999 9999');
INSERT INTO administrador( cracha, email, nome, telefone) VALUES ( '15','teste2@gmail.com', 'teste15', '8888 9999');
INSERT INTO administrador( cracha, email, nome, telefone) VALUES ( '16','teste1@gmail.com', 'teste16', '99999 9999');
INSERT INTO administrador( cracha, email, nome, telefone) VALUES ( '17','testeteste2@gmail.com', 'teste17', '8888 9999');
INSERT INTO administrador( cracha, email, nome, telefone) VALUES ( '18','teste1@gmail.com', 'teste18', '99999 9999');
INSERT INTO administrador( cracha, email, nome, telefone) VALUES ( '19','teste2@gmail.com', 'teste19', '8888 9999');
INSERT INTO administrador( cracha, email, nome, telefone) VALUES ( '20','testestestetestetesteststeste1@gmail.com', 'teste20', '99999 9999');
INSERT INTO administrador( cracha, email, nome, telefone) VALUES ( '21','ativo@gmail.com', 'mateus', '99999 9999');
INSERT INTO administrador( cracha, email, nome, telefone) VALUES ( '22','inativo@gmail.com', 'teste2', '8888 9999');
INSERT INTO administrador( cracha, email, nome, telefone) VALUES ( '23','ativo@gmail.com', 'teste3', '8888 9999');
INSERT INTO administrador( cracha, email, nome, telefone) VALUES ( '24','teste1@gmail.com', 'teste4', '99999 9999');
INSERT INTO administrador( cracha, email, nome, telefone) VALUES ( '25','teste2@gmail.com', 'teste5', '8888 9999');
INSERT INTO administrador( cracha, email, nome, telefone) VALUES ( '26','teste1@gmail.com', 'teste6', '99999 9999');
INSERT INTO administrador( cracha, email, nome, telefone) VALUES ( '27','teste2@gmail.com', 'teste7', '8888 9999');
INSERT INTO administrador( cracha, email, nome, telefone) VALUES ( '28','teste1@gmail.com', 'teste8', '99999 9999');
INSERT INTO administrador( cracha, email, nome, telefone) VALUES ( '29','teste2@gmail.com', 'teste9', '8888 9999');
INSERT INTO administrador( cracha, email, nome, telefone) VALUES ( '30','teste1@gmail.com', 'teste10', '99999 9999');
INSERT INTO administrador( cracha, email, nome, telefone) VALUES ( '31','teste2@gmail.com', 'teste11', '8888 9999');
INSERT INTO administrador( cracha, email, nome, telefone) VALUES ( '32','teste1@gmail.com', 'teste12', '99999 9999');
INSERT INTO administrador( cracha, email, nome, telefone) VALUES ( '33','ativo@gmail.com', 'mateus', '99999 9999');
INSERT INTO administrador( cracha, email, nome, telefone) VALUES ( '34','inativo@gmail.com', 'teste2', '8888 9999');
INSERT INTO administrador( cracha, email, nome, telefone) VALUES ( '35','ativo@gmail.com', 'teste3', '8888 9999');
INSERT INTO administrador( cracha, email, nome, telefone) VALUES ( '36','teste1@gmail.com', 'teste4', '99999 9999');
INSERT INTO administrador( cracha, email, nome, telefone) VALUES ( '37','teste2@gmail.com', 'teste5', '8888 9999');
INSERT INTO administrador( cracha, email, nome, telefone) VALUES ( '38','teste1@gmail.com', 'teste6', '99999 9999');
INSERT INTO administrador( cracha, email, nome, telefone) VALUES ( '39','teste2@gmail.com', 'teste7', '8888 9999');
INSERT INTO administrador( cracha, email, nome, telefone) VALUES ( '40','teste1@gmail.com', 'teste8', '99999 9999');
INSERT INTO administrador( cracha, email, nome, telefone) VALUES ( '41','teste2@gmail.com', 'teste9', '8888 9999');
INSERT INTO administrador( cracha, email, nome, telefone) VALUES ( '42','teste1@gmail.com', 'teste10', '99999 9999');
INSERT INTO administrador( cracha, email, nome, telefone) VALUES ( '43','teste2@gmail.com', 'teste11', '8888 9999');
INSERT INTO administrador( cracha, email, nome, telefone) VALUES ( '44','teste1@gmail.com', 'teste12', '99999 9999');
INSERT INTO area( id, nome) VALUES ( 1, 'Financeiro');
INSERT INTO area( id, nome) VALUES ( 2, 'Administrativo');
INSERT INTO area( id, nome) VALUES ( 3, 'Administrativo');
INSERT INTO area( id, nome) VALUES ( 4, 'Producao');
INSERT INTO superior_imediato(nome, cargo, quant_subordinados, id_area) 
VALUES ( 'FinanceiroSupervisor', 'Supervisor', '1', 1);
INSERT INTO superior_imediato(nome, cargo, quant_subordinados, id_area) 
VALUES ( 'SuperiorSupervisor', 'Supervisor', '2', 2);
INSERT INTO superior_imediato(nome, cargo, quant_subordinados, id_area) 
VALUES ( 'AdministrativoSupervisor', 'Supervisor', '3', 3);
INSERT INTO superior_imediato(nome, cargo, quant_subordinados, id_area) 
VALUES ( 'FinanceiroGerente', 'Gerente', '4', 1);
INSERT INTO superior_imediato(nome, cargo, quant_subordinados, id_area) 
VALUES ( 'ProducaoGerente', 'Gerente', '5', 4);
INSERT INTO superior_imediato(nome, cargo, quant_subordinados, id_area) 
VALUES ( 'ProducaoGerente', 'Diretor', '7', 4);
INSERT INTO superior_imediato(nome, cargo, quant_subordinados, id_area) 
VALUES ( 'AdministrativoDiretor', 'Diretor', '6', 3);
INSERT INTO superior_imediato(nome, cargo, quant_subordinados, id_area) 
VALUES ( 'SuperiorDiretor', 'Diretor', '8', 2);
INSERT INTO superior_imediato(nome, cargo, quant_subordinados, id_area) 
VALUES ( 'SuperiorDiretor', 'Diretor', '8', 2);
INSERT INTO superior_imediato(nome, cargo, quant_subordinados, id_area) 
VALUES ( 'FinanceiroSupervisor', 'Supervisor', '9', 1);
INSERT INTO superior_imediato(nome, cargo, quant_subordinados, id_area) 
VALUES ( 'SuperiorSupervisor', 'Supervisor', '10', 2);
INSERT INTO superior_imediato(nome, cargo, quant_subordinados, id_area) 
VALUES ( 'SuperiorSupervisor', 'Supervisor', '11', 2);
INSERT INTO superior_imediato(nome, cargo, quant_subordinados, id_area) 
VALUES ( 'AdministrativoSupervisor', 'Supervisor', '12', 3);
INSERT INTO superior_imediato(nome, cargo, quant_subordinados, id_area) 
VALUES ( 'ProducaoSupervisor', 'Supervisor', '13', 4);
INSERT INTO superior_imediato(nome, cargo, quant_subordinados, id_area) 
VALUES ( 'FinanceiroSupervisor', 'Supervisor', '14', 1);
INSERT INTO superior_imediato(nome, cargo, quant_subordinados, id_area) 
VALUES ( 'AdministrativoSupervisor', 'Supervisor', '15', 3);
INSERT INTO superior_imediato(nome, cargo, quant_subordinados, id_area) 
VALUES ( 'FinanceiroSupervisor', 'Supervisor', '1', 1);
INSERT INTO superior_imediato(nome, cargo, quant_subordinados, id_area) 
VALUES ( 'SuperiorSupervisor', 'Supervisor', '2', 2);
INSERT INTO superior_imediato(nome, cargo, quant_subordinados, id_area) 
VALUES ( 'AdministrativoSupervisor', 'Supervisor', '3', 3);
INSERT INTO superior_imediato(nome, cargo, quant_subordinados, id_area) 
VALUES ( 'FinanceiroGerente', 'Gerente', '4', 1);
INSERT INTO superior_imediato(nome, cargo, quant_subordinados, id_area) 
VALUES ( 'ProducaoGerente', 'Gerente', '5', 4);
INSERT INTO superior_imediato(nome, cargo, quant_subordinados, id_area) 
VALUES ( 'ProducaoGerente', 'Diretor', '7', 4);
INSERT INTO superior_imediato(nome, cargo, quant_subordinados, id_area) 
VALUES ( 'AdministrativoDiretor', 'Diretor', '6', 3);
INSERT INTO superior_imediato(nome, cargo, quant_subordinados, id_area) 
VALUES ( 'SuperiorDiretor', 'Diretor', '8', 2);
INSERT INTO superior_imediato(nome, cargo, quant_subordinados, id_area) 
VALUES ( 'SuperiorDiretor', 'Diretor', '8', 2);
INSERT INTO superior_imediato(nome, cargo, quant_subordinados, id_area) 
VALUES ( 'FinanceiroSupervisor', 'Supervisor', '9', 1);
INSERT INTO superior_imediato(nome, cargo, quant_subordinados, id_area) 
VALUES ( 'SuperiorSupervisor', 'Supervisor', '10', 2);
INSERT INTO superior_imediato(nome, cargo, quant_subordinados, id_area) 
VALUES ( 'SuperiorSupervisor', 'Supervisor', '11', 2);
INSERT INTO superior_imediato(nome, cargo, quant_subordinados, id_area) 
VALUES ( 'AdministrativoSupervisor', 'Supervisor', '12', 3);
INSERT INTO superior_imediato(nome, cargo, quant_subordinados, id_area) 
VALUES ( 'ProducaoSupervisor', 'Supervisor', '13', 4);
INSERT INTO superior_imediato(nome, cargo, quant_subordinados, id_area) 
VALUES ( 'FinanceiroSupervisor', 'Supervisor', '14', 1);
INSERT INTO superior_imediato(nome, cargo, quant_subordinados, id_area) 
VALUES ( 'AdministrativoSupervisor', 'Supervisor', '15', 3);
INSERT INTO superior_imediato(nome, cargo, quant_subordinados, id_area) 
VALUES ( 'FinanceiroSupervisor', 'Supervisor', '1', 1);
INSERT INTO superior_imediato(nome, cargo, quant_subordinados, id_area) 
VALUES ( 'SuperiorSupervisor', 'Supervisor', '2', 2);
INSERT INTO superior_imediato(nome, cargo, quant_subordinados, id_area) 
VALUES ( 'AdministrativoSupervisor', 'Supervisor', '3', 3);
INSERT INTO superior_imediato(nome, cargo, quant_subordinados, id_area) 
VALUES ( 'FinanceiroGerente', 'Gerente', '4', 1);
INSERT INTO superior_imediato(nome, cargo, quant_subordinados, id_area) 
VALUES ( 'ProducaoGerente', 'Gerente', '5', 4);
INSERT INTO superior_imediato(nome, cargo, quant_subordinados, id_area) 
VALUES ( 'ProducaoGerente', 'Diretor', '7', 4);
INSERT INTO superior_imediato(nome, cargo, quant_subordinados, id_area) 
VALUES ( 'AdministrativoDiretor', 'Diretor', '6', 3);
INSERT INTO superior_imediato(nome, cargo, quant_subordinados, id_area) 
VALUES ( 'SuperiorDiretor', 'Diretor', '8', 2);
INSERT INTO superior_imediato(nome, cargo, quant_subordinados, id_area) 
VALUES ( 'SuperiorDiretor', 'Diretor', '8', 2);
INSERT INTO superior_imediato(nome, cargo, quant_subordinados, id_area) 
VALUES ( 'FinanceiroSupervisor', 'Supervisor', '9', 1);
INSERT INTO superior_imediato(nome, cargo, quant_subordinados, id_area) 
VALUES ( 'SuperiorSupervisor', 'Supervisor', '10', 2);
INSERT INTO superior_imediato(nome, cargo, quant_subordinados, id_area) 
VALUES ( 'SuperiorSupervisor', 'Supervisor', '11', 2);
INSERT INTO superior_imediato(nome, cargo, quant_subordinados, id_area) 
VALUES ( 'AdministrativoSupervisor', 'Supervisor', '12', 3);
INSERT INTO superior_imediato(nome, cargo, quant_subordinados, id_area) 
VALUES ( 'ProducaoSupervisor', 'Supervisor', '13', 4);
INSERT INTO superior_imediato(nome, cargo, quant_subordinados, id_area) 
VALUES ( 'FinanceiroSupervisor', 'Supervisor', '14', 1);
INSERT INTO superior_imediato(nome, cargo, quant_subordinados, id_area) 
VALUES ( 'AdministrativoSupervisor', 'Supervisor', '15', 3);
INSERT INTO modelo_questionario(nome, descricao) VALUES ('questionario2', 'questionario2');
INSERT INTO modelo_questionario(nome, descricao) VALUES ('questionario3', 'questionario3');
INSERT INTO modelo_questionario(nome, descricao) VALUES ('questionario4', 'questionario4');
INSERT INTO modelo_questionario(nome, descricao) VALUES ('questionario5', 'questionario5');
INSERT INTO modelo_questionario(nome, descricao) VALUES ('questionario6', 'questionario6');
INSERT INTO modelo_questionario(nome, descricao) VALUES ('questionario7', 'questionario7');
INSERT INTO modelo_questionario(nome, descricao) VALUES ('questionario8', 'questionario8');
INSERT INTO modelo_questionario(nome, descricao) VALUES ('questionario9', 'questionario9');
INSERT INTO modelo_questionario(nome, descricao) VALUES ('questionario10', 'questionario10');
INSERT INTO modelo_questionario(nome, descricao) VALUES ('questionario11', 'questionario11');
INSERT INTO modelo_questionario(nome, descricao) VALUES ('questionario12', 'questionario12');
INSERT INTO modelo_questionario(nome, descricao) VALUES ('questionario13', 'questionario13');
INSERT INTO modelo_questionario(nome, descricao) VALUES ('questionario14', 'questionario14');
INSERT INTO modelo_questionario(nome, descricao) VALUES ('questionario15', 'questionario15');
INSERT INTO modelo_questionario(nome, descricao) VALUES ('questionario16', 'questionario16');
INSERT INTO modelo_questionario(nome, descricao) VALUES ('questionario17', 'questionario17');
INSERT INTO modelo_questionario(nome, descricao) VALUES ('questionario18', 'questionario18');
INSERT INTO modelo_questionario(nome, descricao) VALUES ('questionario19', 'questionario19');
INSERT INTO modelo_questionario(nome, descricao) VALUES ('questionario20', 'questionario20');
INSERT INTO modelo_questionario(nome, descricao) VALUES ('questionario21', 'questionario21');
INSERT INTO modelo_questionario(nome, descricao) VALUES ('questionario22', 'questionario22');
INSERT INTO modelo_questionario(nome, descricao) VALUES ('questionario23', 'questionario23');
INSERT INTO modelo_questionario(nome, descricao) VALUES ('questionario24', 'questionario24');
INSERT INTO modelo_questionario(nome, descricao) VALUES ('questionario25', 'questionario25');
INSERT INTO modelo_questionario(nome, descricao) VALUES ('questionario26', 'questionario26');
INSERT INTO modelo_questionario(nome, descricao) VALUES ('questionario27', 'questionario27');
INSERT INTO modelo_questionario(nome, descricao) VALUES ('questionario28', 'questionario28');
INSERT INTO modelo_questionario(nome, descricao) VALUES ('questionario29', 'questionario29');
INSERT INTO modelo_questionario(nome, descricao) VALUES ('questionario30', 'questionario30');