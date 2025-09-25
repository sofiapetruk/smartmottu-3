INSERT INTO T_SMARTMOTTU_STATUS_MOTO (status, data)
VALUES ('ATIVA', DATE '2025-01-10');

INSERT INTO T_SMARTMOTTU_STATUS_MOTO (status, data)
VALUES ('MANUTENCAO', DATE '2025-02-15');


INSERT INTO T_SMARTMOTTU_TIPO_MOTO (nm_tipo)
VALUES ('MOTTU_SPORT_110I');

INSERT INTO T_SMARTMOTTU_TIPO_MOTO (nm_tipo)
VALUES ('MOTTU_SPORT_ESD_2025');


INSERT INTO T_SMARTMOTTU_USUARIO (nome, email, senha)
VALUES ('João Silva', 'joao.silva@exemplo.com', '123456');

INSERT INTO T_SMARTMOTTU_USUARIO (nome, email, senha)
VALUES ('Maria Oliveira', 'maria.oliveira@exemplo.com', 'abcdef');

INSERT INTO T_SMARTMOTTU_MOTO (nm_chassi, placa, unidade, fk_id_status, fk_id_tipo)
VALUES ('9BWZZZ377VT004251', 'ABC1234', 'São Paulo', 1, 1);

INSERT INTO T_SMARTMOTTU_MOTO (nm_chassi, placa, unidade, fk_id_status, fk_id_tipo)
VALUES ('9BWZZZ377VT004999', 'XYZ5678', 'Rio de Janeiro', 2, 2);
