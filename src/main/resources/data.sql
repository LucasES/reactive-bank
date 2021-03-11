DELETE FROM tb_transaction;
DELETE FROM tb_account;
DELETE FROM tb_operation_type;
INSERT INTO tb_operation_type VALUES (1, 'COMPRA A VISTA');
INSERT INTO tb_operation_type VALUES (2, 'COMPRA PARCELADA');
INSERT INTO tb_operation_type VALUES (3, 'SAQUE');
INSERT INTO tb_operation_type VALUES (4, 'PAGAMENTO');