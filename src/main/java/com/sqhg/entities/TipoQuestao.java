package com.sqhg.entities;

public enum TipoQuestao {
    MULTIPLA("Múltipla escolha"),
    ALTERNATIVAS("Alternativas"),
    ABERTA("Aberta"),
    LIKERT("Likert");

    private final String display;

    private TipoQuestao(String display) {
        this.display = display;
    }

    public String getDisplay() {
        return display;
    }
}
