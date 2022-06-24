package model;

public enum Tabelas {
    VEICULO("Veiculo"),
    CLIENTE("Cliente");

    private final String nomeTabela;

    Tabelas(String nomeTabela) {
        this.nomeTabela = nomeTabela;
    }

    public String getNomeTabelas() {
        return this.nomeTabela;
    }
}
