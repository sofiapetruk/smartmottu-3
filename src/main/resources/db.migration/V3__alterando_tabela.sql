ALTER TABLE T_SMARTMOTTU_STATUS_MOTO
MODIFY (status VARCHAR2(20) NOT NULL);

ALTER TABLE T_SMARTMOTTU_STATUS_MOTO
ADD CONSTRAINT ck_status_enum CHECK (status IN (
    'Ativo', 'Inativo', 'Bloqueado', 'Cancelado', 'Manutenção'
));
