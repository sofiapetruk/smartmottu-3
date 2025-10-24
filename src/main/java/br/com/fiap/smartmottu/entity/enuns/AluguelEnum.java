package br.com.fiap.smartmottu.entity.enuns;

public enum AluguelEnum {

    INATIVO("Inativo"),
    ATIVO("Ativo");

    private final String descricao;

    AluguelEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
