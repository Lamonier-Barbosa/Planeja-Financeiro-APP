package br.com.planeja.financeiro.api.common.validation;

import java.util.ArrayList;
import java.util.List;

public class ValidationResult {


    private List<CampoInvalido>  campoInvalido;

    public ValidationResult(List<CampoInvalido> campoInvalido) {
        this.campoInvalido = campoInvalido;
    }

    public static ValidationResult novo() {
        return new ValidationResult(new ArrayList<>());
    }

    public void add(CampoInvalido campoInvalido) {
        this.campoInvalido.add(campoInvalido);
    }

    public List<CampoInvalido> getCampoInvalidos() {
        return campoInvalido;
    }

    public boolean isInvalido() {
       return !campoInvalido.isEmpty();
    }

}
