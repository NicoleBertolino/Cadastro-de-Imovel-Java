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
public class BusinessImovel {

    public static void listarImoveis(Imovel imoveis[], int TAM) {
        System.out.println("\n\t\tLISTA DE IMÓVEIS");
        for (int j = 0; j < TAM; j++) {
            if (imoveis[j] != null) {
                System.out.println("\tCodigo:           " + imoveis[j].getCodigo());
                System.out.println("\tEndereço:         " + imoveis[j].getEndereco());
                System.out.println("\tValor do imóvel:  " + imoveis[j].getValor());
                System.out.println("\tDescrição:        " + imoveis[j].getDescricao());
                System.out.println("\tMetros Quadrados: " + imoveis[j].getMetros());
                System.out.println("\tNumero Quartos:   " + imoveis[j].getNumquarto());
                System.out.println("\tNumero Vagas:     " + imoveis[j].getNumvaga());
                System.out.println("----------------*------------");
            }
        }
    }
    
    public static void inserirImovel(Imovel[] imoveis, Scanner in, int i) {

        Imovel imovel = new Imovel();

        System.out.println("informe o codigo do imóvel: ");
        imovel.setCodigo(in.nextInt());
        System.out.println("Informe o endereço do imóvel: ");
        in.nextLine();
        imovel.setEndereco(in.nextLine());
        System.out.println("Informe a descrição do imóvel: ");
        imovel.setDescricao(in.nextLine());
        System.out.println("Informe o numero de quartos do imóvel: ");
        imovel.setNumquarto(in.nextInt());
        System.out.println("Informe quantos metros quadrados tem o imóvel: ");
        imovel.setMetros(in.nextDouble());
        System.out.println("Informe o numero de vagas do imóvel: ");
        imovel.setNumvaga(in.nextInt());
        System.out.println("Informe o valor do imoóvel: ");
        imovel.setValor(in.nextDouble());

        imoveis[i++] = imovel;
    }
}
