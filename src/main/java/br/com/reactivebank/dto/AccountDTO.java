package br.com.reactivebank.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Account data transfer object.
 *
 * @author Lucas Araújo - lucas.compufc@gmail.com
 * @version 0.1
 * @since 07/03/21
 */
@Data
@ToString
public class AccountDTO implements Serializable {

    private static final long serialVersionUID = 8616889028122220243L;

    @CPF(message = "The document_number is incorrect!")
    @NotNull(message = "The document_number can't be null!")
    @NotEmpty(message = "The document_number can't be empty!")
    @JsonProperty("document_number")
    private String documentNumber;
}
