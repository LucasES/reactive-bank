package br.com.reactivebank.enums;

/**
 * @author Lucas Araújo - lucas.compufc@gmail.com
 * @version 0.1
 * @since 11/03/21
 */
public enum OperationTypeEnum {

    COMPRA_A_VISTA(1l),
    COMPRA_PARCELADA(2l),
    SAQUE(3l),
    PAGAMENTO(4l);

    private Long id;

    OperationTypeEnum(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
