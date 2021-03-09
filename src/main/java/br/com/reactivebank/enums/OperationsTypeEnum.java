package br.com.reactivebank.enums;

/**
 * Enum for Operations Type
 *
 * @author Lucas Araújo - lucas.compufc@gmail.com
 * @version 0.1
 * @since 09/03/21
 */
public enum OperationsTypeEnum {

    COMPRA_A_VISTA(1l, "COMPRA A VISTA"),
    COMPRA_PARCELADO(2l, "COMPRA A VISTA"),
    SAQUE(3l, "SAQUE"),
    PAGAMENTO(4l, "PAGAMENTO");

    private Long id;

    private String description;

    OperationsTypeEnum(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
