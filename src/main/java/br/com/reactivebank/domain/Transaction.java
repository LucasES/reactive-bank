package br.com.reactivebank.domain;

import lombok.Data;
import lombok.With;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

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

    private Long id;

    @Column("account_id")
    private Long accountId;

    @Column("operation_type_id")
    private Long operationTypeId;

    private BigDecimal amout;

    private LocalDateTime eventDate;
}
