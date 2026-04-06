package PCMania;

public class Computador {

    private String marca;
    private float preco;

    private HardwareBasico[] hardwares = new HardwareBasico[3];
    private SistemaOperacional sistema;
    private MemoriaUSB memoria;

    public Computador(String marca, float preco){
        this.marca = marca;
        this.preco = preco;
    }

    public void addHardware(HardwareBasico hw, int posicao) {
        hardwares[posicao] = hw;
    }

    public void setSistema(SistemaOperacional sistema) {
        this.sistema = sistema;
    }

    public void addMemoriaUSB(MemoriaUSB memoria) {
        this.memoria = memoria;
    }

    public void mostraPCConfigs() {
        System.out.println("Marca: " + marca);
        System.out.println("Preço: " + preco);

        System.out.println("Hardware:");
        for (int i = 0; i < hardwares.length; i++) {
            if (hardwares[i] != null) {
                float cap = hardwares[i].getCapacidade();

                if (hardwares[i].getNome().equals("HD") && cap >= 1024) {
                    System.out.println(hardwares[i].getNome() + " - " + (cap / 1024) + " TB");
                } else {
                    System.out.println(hardwares[i].getNome() + " - " + cap + " GB");
                }
            }
        }

        System.out.println("Sistema Operacional: " + sistema.getNome() + " (" + sistema.getTipo() + " bits)");

        if (memoria != null) {
            System.out.println("Memória USB: " + memoria.getNome() + " - " + memoria.getCapacidade() + " GB");
        }
    }

    public float getPreco() {
        return preco;
    }
}