CREATE TABLE IF NOT EXISTS account (
     id   INTEGER      NOT NULL AUTO_INCREMENT,
     document_number VARCHAR(11) NOT NULL,
     UNIQUE(document_number),
     PRIMARY KEY (id)
);