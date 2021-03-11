package br.com.reactivebank.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Lucas Araújo - lucas.compufc@gmail.com
 * @version 0.1
 * @since 09/03/21
 */
@Data
@Table("tb_transaction")
public class Transaction {

    @Id
    private Long id;

    @Column("account_id")
    private Long accountId;

    @Column("operation_type_id")
    private Long operationTypeId;

    private BigDecimal amount;

    private LocalDateTime eventDate;
}
