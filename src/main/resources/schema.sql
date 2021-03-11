CREATE TABLE IF NOT EXISTS tb_account (
     id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
     document_number VARCHAR(11) NOT NULL,
     UNIQUE(document_number)
);

CREATE TABLE IF NOT EXISTS tb_operation_type (
    id INTEGER NOT NULL PRIMARY KEY,
    description VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS tb_transaction (
    id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    account_id INTEGER NOT NULL,
    operation_type_id INTEGER NOT NULL,
    amount DECIMAL(12, 2) NOT NULL,
    event_date DATETIME NOT NULL,
    CONSTRAINT fk_account_id foreign key (account_id) references tb_account(id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT fk_operation_type_id foreign key (operation_type_id) references tb_operation_type(id) ON UPDATE CASCADE ON DELETE CASCADE
);
