
package projeto_imobiliaria_nicole;

import java.util.Scanner;

/**
 *
 * @author Nicole Bertolino
 */

public class BusinessImovel {

    
    /**
     * método para inserir imóvel
     * @param imoveis -> objeto da classe Imovel
     * @param in      -> objeto do Scanner
     * @param i       -> posição que o vetor está percorrendo 
     * @param TAM     -> tamanho do array
     */
    public static void inserirImovel(Imovel[] imoveis, Scanner in, int i, int TAM) {

        // Objeto imovel -> recebe os dados do novo imóvel
        // validacodigo  -> retorna valor especifico para código valido ou invalido
        // validavalor   -> retorna valor esspecifico para valor do imovél valido ou não
        Imovel imovel = new Imovel();
        int validacodigo = 0;
        int validavalor;

        // recebendo dados
        System.out.println("\n");
        System.out.println("\tInserindo novo imóvel.");
        
        do{
        System.out.print("\tinforme o codigo do imóvel: ");
        imovel.setCodigo(in.nextInt());
        
        // confere se o código é igual.
            if(imovel.getCodigo() <= 0){
                System.out.println("Codigo invalido");
                validacodigo = 1;
            }else{
                if(i != 0){
                    for(int j = 0; j < i; j++){
                        if(imoveis[j] != null){
                            if(imoveis[j].getCodigo() == imovel.getCodigo()){
                                validacodigo = 1;
                                System.out.println("\tCódigo invalido. Tente novamente.\n");
                            }
                            else validacodigo = 0;
                        }   
                    }
                }else{
                    validacodigo = 0;
                    }
            }  
        }while(validacodigo != 0);
        
        System.out.print("\tInforme o endereço do imóvel: ");
        in.nextLine();
        imovel.setEndereco(in.nextLine());
        System.out.print("\tInforme a descrição do imóvel: ");
        imovel.setDescricao(in.nextLine());
        System.out.print("\tInforme o numero de quartos do imóvel: ");
        imovel.setNumquarto(in.nextInt());
        System.out.print("\tInforme quantos metros quadrados tem o imóvel: ");
        imovel.setMetros(in.nextDouble());
        System.out.print("\tInforme o numero de vagas do imóvel: ");
        imovel.setNumvaga(in.nextInt());
        
        // confere se o valor é zero ou negativo
        do{
            System.out.print("\tInforme o valor do imóvel: ");
            imovel.setValor(in.nextDouble());
            if(imovel.getValor() < 1){
                System.out.println("\tValor inserido invalido. Tente novamente.\n");
                validavalor = 1;
            }else validavalor = 0;
        } while(validavalor != 0);
        
        // guardando no array
        imoveis[i] = imovel;
    }

    /**
     * método para listar imóvel
     * @param imoveis -> objeto da classe Imovel
     * @param TAM     -> tamanho do array
     */
    public static void listarImoveis(Imovel imoveis[], int TAM) {
        
        // printando a lista de imóveis
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
                System.out.println("-------------------------------");
                System.out.print("\n");
            }
        }
    }

    /**
     * método para pesquisar número de quartos
     * @param imoveis -> objeto da classe Imovel
     * @param in      -> objeto do Scanner
     * @param TAM     -> tamanho do array
     */
    public static void pesquisaNumeroQuarto(Imovel[] imoveis, Scanner in, int TAM) {
        
        // numquart -> recebe o número de quartos que o usuário busca no imóvel
        //FLAG -> retorna verdadeiro para imóvel encontrado e falso se não encontrou.
        int numquart;
        boolean FLAG = false;
        
        System.out.print("Informe a quantidade de quartos desejado -> ");
        numquart = in.nextInt();
        
        // pesquisando imóvel com número de quartos correspondentes 
        if(numquart > 1){
            for (int j = 0; j < TAM; j++) {
                if (imoveis[j] != null) {
                    if (imoveis[j].getNumquarto() == numquart) {
                        System.out.println("\tCodigo:           " + imoveis[j].getCodigo());
                        System.out.println("\tEndereço:         " + imoveis[j].getEndereco());
                        System.out.println("\tValor do imóvel:  " + imoveis[j].getValor());
                        System.out.println("\tDescrição:        " + imoveis[j].getDescricao());
                        System.out.println("\tMetros Quadrados: " + imoveis[j].getMetros());
                        System.out.println("\tNumero Quartos:   " + imoveis[j].getNumquarto());
                        System.out.println("\tNumero Vagas:     " + imoveis[j].getNumvaga());
                        System.out.println("----------------------------");
                        System.out.print("\n");
                        FLAG = true;
                    }
                }
            }
        }
        if(FLAG == false){
            System.out.println("\tNúmero de quartos inválidos.");
        }
    }
    
    /**
     * método para pesquisae preço do imóvel
     * @param imoveis -> objeto da classe Imovel
     * @param in      -> objeto do Scanner
     * @param TAM     -> tamanho do array
     */
    public static void pesquisaPreco(Imovel[] imoveis, Scanner in, int TAM) {
        
        // vlminimo -> recebe o valor mínimo que o usuário está disposto a pagar
        // vlmaximo -> recebe o valor máximo que o usuário está disposto a pagar
        // FLAG     -> retorna valor específico se existe ou não imóvel na faixa de preço
        double vlminimo;
        double vlmaximo;
        int FLAG = 0;

        System.out.println("Informe o valor mínimo do imóvel: ");
        vlminimo = in.nextDouble();
        System.out.println("Informe o valor máximo do imóvel:  ");
        vlmaximo = in.nextDouble();

        // pesquisando imóvel com valor correspondente 
        for (int j = 0; j < TAM; j++) {
            if (imoveis[j] != null) {
                if (imoveis[j].getValor() <= vlmaximo && imoveis[j].getValor() >= vlminimo) {
                    System.out.println("\tCodigo:           " + imoveis[j].getCodigo());
                    System.out.println("\tEndereço:         " + imoveis[j].getEndereco());
                    System.out.println("\tValor do imóvel:  " + imoveis[j].getValor());
                    System.out.println("\tDescrição:        " + imoveis[j].getDescricao());
                    System.out.println("\tMetros Quadrados: " + imoveis[j].getMetros());
                    System.out.println("\tNumero Quartos:   " + imoveis[j].getNumquarto());
                    System.out.println("\tNumero Vagas:     " + imoveis[j].getNumvaga());
                    System.out.println("----------------------------");
                    System.out.print("\n");
                    FLAG = 1;
                }
           }
        }
        if(FLAG == 0){
            System.out.println("\tNenhum imóvel encontrado na faixa de preço.");
        }
    }

    /**
     * método para alterar dados do imóvel
     * @param in      -> objeto do Scanner
     * @param imoveis -> objeto da classe Imovel
     * @param TAM     -> tamanho do array
     */
    public static void alterarImovel(Scanner in, Imovel[] imoveis, int TAM){
        
        // codigo  -> recebe código do imóvel que deseja alterar
        // FLAG    ->retorna valor específico se existe ou não imóvel para alterar do código
        // escolha -> recebe o que o usuário deseja alterar 
        int codigo;
        int FLAG = 0; 
        int escolha;
        
        System.out.println("\tInforme o codigo do imovél que deseja alterar: ");
        codigo = in.nextInt();

        // recebendo alterações
        for (int j = 0; j < TAM; j++) {
            if (imoveis[j] != null) {
                if (imoveis[j].getCodigo() == codigo) {
                    System.out.println("\n\tINFORMAÇÕES DO IMÓVEL");
                    System.out.println("\t1. Endereço");
                    System.out.println("\t2. Valor do imóvel");
                    System.out.println("\t3. Descrição");
                    System.out.println("\t4. Metros Quadrados");
                    System.out.println("\t5. Numero Quartos");
                    System.out.println("\t6. Numero Vagas\n");
                    
                    do{
                    System.out.println("\tO que deseja alterar nas informações do imóvel? ");
                    escolha = in.nextInt();
                    //escolha da alteração
                    switch (escolha){
                        case 1: 
                            System.out.println("Informe o novo endereço do imóvel: ");
                            imoveis[j].setEndereco(in.nextLine());
                            break;
                        case 2:
                            System.out.println("Informe o novo valor do imóvel: ");
                            imoveis[j].setValor(in.nextDouble());
                            in.nextLine();
                            break;
                        case 3: 
                            System.out.println("Informe a nova descrição do imóvel: ");
                            imoveis[j].setDescricao(in.nextLine());
                            break;
                        case 4: 
                            System.out.println("Informe a nova metragem do imóvel (m²): ");
                            imoveis[j].setMetros(in.nextDouble());
                            break;
                        case 5: 
                            System.out.println("Informe a nova quantidade de quartos do imóvel: ");
                            imoveis[j].setNumquarto(in.nextInt());
                            break;
                        case 6: 
                            System.out.println("Informe o novo número de vagas do imóvel: ");
                            imoveis[j].setNumvaga(in.nextInt());
                            break;
                        default: 
                            System.out.println("Escolha invalida.");
                            break;
                    }
                  }while(escolha > 6 || escolha < 1);
                    
                    System.out.println("Informação alterada com sucesso!");
                    FLAG = 1;  
                }
            }
        }
        if(FLAG == 0){
            System.out.println("Codigo não encontrado.");
        }
    }
    
    /**
     * método para excluir imóvel
     * @param in      -> objeto do Scanner 
     * @param imoveis -> objeto da classe Imovel
     * @param TAM     -> tamanho do array
     */
    public static void excluirImovel(Scanner in, Imovel imoveis[], int TAM){
        
        // escolha -> recebe escolha do código imóvel para excluir
        int escolha;
        
        System.out.print("Informe o código imóvel que deseja excluir -> ");
        escolha = in.nextInt();
        
        // excluindo imóvel
        for(int i = 0; i < TAM; i++){
            if(imoveis[i] != null){
                if(imoveis[i].getCodigo() == escolha){
                    imoveis[i] = null;
                    System.out.println("\n\tImóvel excluido com sucesso!");
                    break;
                }
            }
        }
    }
}
