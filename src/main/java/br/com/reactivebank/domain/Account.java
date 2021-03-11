package br.com.reactivebank.domain;

import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/**
 * Account entity.
 *
 * @author Lucas Araújo - lucas.compufc@gmail.com
 * @version 0.1
 * @since 05/03/21
 */
@Data
@Table(value = "tb_account")
public class Account {

    @Id
    private Long id;

    @CPF(message = "The document_number is required!")
    private String documentNumber;
}
