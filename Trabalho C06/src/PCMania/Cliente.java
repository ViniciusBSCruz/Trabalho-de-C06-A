package PCMania;

public class Cliente {

    private String nome;
    private String cpf;
    private Computador[] computadores = new Computador[10];
    private int quantidade = 0;

    public Cliente(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }

    public void adicionaComputador(Computador pc) {
        computadores[quantidade] = pc;
        quantidade++;
    }

    public float calculaTotalCompra() {
        float total = 0;

        for (int i = 0; i < quantidade; i++) {
            total += computadores[i].getPreco();
        }

        return total;
    }

    public void mostraComputadores() {
        for (int i = 0; i < quantidade; i++) {
            computadores[i].mostraPCConfigs();
            System.out.println("-------------------");
        }
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Computador[] getComputadores() {
        return computadores;
    }

    public int getQuantidade() {
        return quantidade;
    }
}