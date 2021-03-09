package br.com.reactivebank.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @author Lucas Araújo - lucas.compufc@gmail.com
 * @version 0.1
 * @since 09/03/21
 */
@Data
@Table("tb_operation_type")
public class OperationType {

    @Id
    private Long id;

    private String description;
}
