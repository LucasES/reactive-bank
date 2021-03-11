package br.com.reactivebank.enums;

/**
 * @author Lucas Araújo - lucas.compufc@gmail.com
 * @version 0.1
 * @since 11/03/21
 */
public enum ReactiveBankException {
    DOCUMENT_NUMBER_REQUIRED("The document_number field is required!"),
    DOCUMENT_NUMBER_INCORRECT("The document_number field isn't valid!"),
    INSUFICIENT_LIMIT("Insuficient limit for this operation");

    private String description;

    ReactiveBankException(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
