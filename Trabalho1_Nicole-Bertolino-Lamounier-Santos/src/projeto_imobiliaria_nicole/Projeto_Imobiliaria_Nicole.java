
package projeto_imobiliaria_nicole;

import java.util.Scanner;

/**
 *
 * @author Nicole Bertolino
 */
public class Projeto_Imobiliaria_Nicole {
    
    //TAM -> tamanho maximo da lista de imóveis
    private static final int TAM = 10;

    //método menu
    public static void menu() {
        System.out.println("\n\n\t\tIMOBILIARIA\n\n\t\tMENU DE OPÇÕES");
        System.out.println("\t1. Inserir novo imóvel.");
        System.out.println("\t2. Listar todos os imóveis.");
        System.out.println("\t3. Pesquisar por números de quartos.");
        System.out.println("\t4. Pesquisar por preço.");
        System.out.println("\t5. Alterar dado de um imóvel.");
        System.out.println("\t6. Excluir um imóvel.");
        System.out.println("\t0. Sair");
    }
   
    //méodo para conferir se existe imóvel cadastrado 
    public static boolean verificaImovel(Imovel[] imoveis){
        for(int i = 0; i< TAM; i++){
            if(imoveis[i] != null)
           return true; 
        }
        System.out.println("\n\tNão existe imóveis cadastrados.");
        return false;
    }

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        
        //Objeto da classe Imovel
        Imovel[] imoveis;
        imoveis = new Imovel[TAM];

        int escolha;
        int i;

        do {

            menu();
            System.out.print("\n\tInforme sua escolha -> ");
            escolha = in.nextInt();

            //verificar escolha
            switch (escolha) {
                case 1:
                    i = 0;
                    while(imoveis[i] != null){
                        i++;
                    }
                    if (i < TAM) {
                        //chama classe BusinessImovel para inserir novo imovel
                        BusinessImovel.inserirImovel(imoveis, in, i, TAM);
                    } else {
                        System.out.println("ERRO: Tamanho maximo atingido: " + i);
                    }
                    break;
                case 2:
                    if(verificaImovel(imoveis))
                        //chama classe BusinessImovel para listar todos os imoveis
                        BusinessImovel.listarImoveis(imoveis, TAM);
                    break;
                case 3: 
                    if(verificaImovel(imoveis))                    
                        //chama classe BusinessImovel para pesquisar por número de quartos
                        BusinessImovel.pesquisaNumeroQuarto(imoveis, in, TAM);

                    break;
                case 4: 
                    if(verificaImovel(imoveis))
                        //chama classe BusinessImóvel para pesquisar por preço
                        BusinessImovel.pesquisaPreco(imoveis, in, TAM);
                   break;
                case 5: 
                    if(verificaImovel(imoveis))
                        //chama classe BusinessImovel para alterar imóvel
                        BusinessImovel.alterarImovel(in, imoveis, TAM);
                    break;
                case 6: 
                    if(verificaImovel(imoveis))
                        //chama classe BusinessImovel para excluir imóvel
                        BusinessImovel.excluirImovel(in, imoveis, TAM);
                    break;
                default: 
                    System.out.println("\n\tEscolha invalida");
                    break;
            }
        } while (escolha != 0);
    }
}