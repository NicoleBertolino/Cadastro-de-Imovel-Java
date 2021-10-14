/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_imobiliaria_nicole;

import java.util.Scanner;

/**
 *
 * @author Nicole Bertolino
 */
public class Projeto_Imobiliaria_Nicole {

    private static final int TAM = 10;

    private static int i = 0;

    public static void menu() {
        System.out.println("\n\t\tIMOBILIARIA\n\t\tMENU DE OPÇÕES\n");
        System.out.println("\t1. Inserir novo imóvel.");
        System.out.println("\t2. Listar todos os imóveis.");
        System.out.println("\t3. Pesquisar por números de quartos.");
        System.out.println("\t4. Pesquisar por preço.");
        System.out.println("\t5. Alterar dado de um imóvel.");
        System.out.println("\t6. Excluir um imóvel.");
        System.out.println("\t0. Sair");
    }

    public static void main(String[] args) {

        Imovel[] imoveis;
        imoveis = new Imovel[TAM];
        
        BusinessImovel businessImovel = new BusinessImovel();

        Scanner in = new Scanner(System.in);

        int escolha, numquart;

        do {
            menu();
            System.out.print("Informe sua escolha ->");
            escolha = in.nextInt();

            if (escolha < 0 || escolha > 6) {
                System.out.println("Escolha invalida");
            } else if (escolha == 1) {
                //Verifica tamanho máximo do array
                if (i < TAM) {
                  BusinessImovel.inserirImovel(imoveis, in, i);
                } else {
                    System.out.println("ERRO: Tamanho maximo atingido: " + i);
                }
            } else if (escolha == 2) {

                BusinessImovel.listarImoveis(imoveis, TAM);
            } else if (escolha == 3) {
                System.out.print("Informe a quantidade de quartos desejado -> ");
                numquart = in.nextInt();
                for (int j = 0; j < TAM; j++) {
                    if (imoveis[j] != null) {
                        if (imoveis[j].getNumquarto() == numquart) {
                            //  listarImoveis(imoveis);
                            System.out.println("\tCodigo:           " + imoveis[j].getCodigo());
                            System.out.println("\tEndereço:         " + imoveis[j].getEndereco());
                            System.out.println("\tValor do imóvel:  " + imoveis[j].getValor());
                            System.out.println("\tDescrição:        " + imoveis[j].getDescricao());
                            System.out.println("\tMetros Quadrados: " + imoveis[j].getMetros());
                            System.out.println("\tNumero Quartos:   " + imoveis[j].getNumquarto());
                            System.out.println("\tNumero Vagas:     " + imoveis[j].getNumvaga());
                            System.out.println("----------------------------");
                        }
                    }
                }
            }
        } while (escolha != 0);
    }
}
