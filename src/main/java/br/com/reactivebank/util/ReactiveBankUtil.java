package br.com.reactivebank.util;

import br.com.caelum.stella.validation.CPFValidator;

/**
 * @author Lucas Araújo - lucas.compufc@gmail.com
 * @version 0.1
 * @since 11/03/21
 */
public abstract class ReactiveBankUtil {

    private ReactiveBankUtil() {throw new IllegalArgumentException("Could not be instantiate.");}

    public static boolean isValid(String cpf) {
        CPFValidator cpfValidator = new CPFValidator();
        try{ cpfValidator.assertValid(cpf);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
