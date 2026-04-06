package PCMania;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite seu nome:");
        String nome = sc.nextLine();

        System.out.println("Digite seu CPF:");
        String cpf = sc.nextLine();

        System.out.println("Digite sua matricula:");
        int matricula = sc.nextInt();

        Cliente cliente = new Cliente(nome, cpf);

        // PC1
        Computador pc1 = new Computador("Apple", matricula);
        pc1.addHardware(new HardwareBasico("Pentium Core i3", 2200), 0);
        pc1.addHardware(new HardwareBasico("RAM", 8), 1);
        pc1.addHardware(new HardwareBasico("HD", 500), 2);
        pc1.setSistema(new SistemaOperacional("macOS Sequoia", 64));
        pc1.addMemoriaUSB(new MemoriaUSB("Pen-drive", 16));

        // PC2
        Computador pc2 = new Computador("Samsung", matricula + 1234);
        pc2.addHardware(new HardwareBasico("Pentium Core i5", 3370), 0);
        pc2.addHardware(new HardwareBasico("RAM", 16), 1);
        pc2.addHardware(new HardwareBasico("HD", 1024), 2);
        pc2.setSistema(new SistemaOperacional("Windows 8", 64));
        pc2.addMemoriaUSB(new MemoriaUSB("Pen-drive", 32));

        // PC3
        Computador pc3 = new Computador("Dell", matricula + 5678);
        pc3.addHardware(new HardwareBasico("Pentium Core i7", 4500), 0);
        pc3.addHardware(new HardwareBasico("RAM", 32), 1);
        pc3.addHardware(new HardwareBasico("HD", 2048), 2);
        pc3.setSistema(new SistemaOperacional("Windows 10", 64));
        pc3.addMemoriaUSB(new MemoriaUSB("HD Externo", 1024));

        int opcao;

        do {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Apple");
            System.out.println("2 - Samsung");
            System.out.println("3 - Dell");
            System.out.println("0 - Sair");

            opcao = sc.nextInt();

            switch(opcao){
                case 1:
                    pc1.mostraPCConfigs();

                    System.out.println("\nDeseja Comprar: ");
                    System.out.println("0 - Não");
                    System.out.println("1 - sim");
                    int escolha1 = sc.nextInt();

                    if(escolha1 == 1){
                        cliente.adicionaComputador(pc1);
                        System.out.println("PC adicionado!");
                    } else {
                        System.out.println("Compra cancelada.");
                    }
                    break;

                case 2:
                    pc2.mostraPCConfigs();

                    System.out.println("\nDeseja Comprar: ");
                    System.out.println("0 - Não");
                    System.out.println("1 - sim");
                    int escolha2 = sc.nextInt();

                    if(escolha2 == 1){
                        cliente.adicionaComputador(pc2);
                        System.out.println("PC adicionado!");
                    } else {
                        System.out.println("Compra cancelada.");
                    }
                    break;

                case 3:
                    pc3.mostraPCConfigs();

                    System.out.println("\nDeseja Comprar: ");
                    System.out.println("0 - Não");
                    System.out.println("1 - sim");
                    int escolha3 = sc.nextInt();

                    if(escolha3 == 1){
                        cliente.adicionaComputador(pc3);
                        System.out.println("PC adicionado!");
                    } else {
                        System.out.println("Compra cancelada.");
                    }
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while(opcao != 0);

        System.out.println("\nCliente: " + cliente.getNome());
        System.out.println("CPF: " + cliente.getCpf());

        cliente.mostraComputadores();

        System.out.println("\nTotal: " + cliente.calculaTotalCompra());

        ProcessarPedido.processar(
                cliente.getComputadores(),
                cliente.getQuantidade()
        );
    }
}