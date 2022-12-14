import java.util.Scanner;

import Estruturas.Cores;
import Estruturas.EmptyStructureException;
import Estruturas.Estrutura;
import Estruturas.FullTreeException;
import Estruturas.InvalidPositionException;
import Estruturas.Arvore.BinarySearchTree;
import Estruturas.ListaSeq.*;
import Estruturas.LSE.*;
import Estruturas.Pilha.*;
import Estruturas.Queue.*;

/*
Classe resposanvel pela formação grafica e comandos do usuarios
no terminal.
*/

public class App{
    private static Scanner scan;

    private static Estrutura estrutura;
    private static BinarySearchTree arvore;


    public static void inicio(){
        System.out.println("BEM-VINDOS A ESTRUTURA DE DADOS 2022.3!\n");
    }

    /*
    Função que irá imprimir no terminal as opções iniciais para o usuario, 
    as quais são os tipos de estruturas de dados a disposição da escolha
    do usuario
    */
    public static int menu_principal(){
        System.out.println("Escolha a Estrutura de Dados: \n");

        System.out.println("(1) - Lista Sequencial");
        System.out.println("(2) - Lista Simplesmente encadeada");
        System.out.println("(3) - Pilha");
        System.out.println("(4) - Fila");
        System.out.println("(5) - Arvore de Busca Binaria");
        System.out.println("(6) - Sair do Programa");

        System.out.print("\nDigite a opção desejada: ");
        
        int opcao = 0;

        try{
            opcao = scan.nextInt();
        }catch(Exception e){
            scan.next();
            opcao = 7;
        }

        return opcao;
    }
    /*funções para controlar qual estrutura foi escolhida pelo usuario, retornando uma string
    contendo o nome, que será utilizada mais pra frente  */
    public static String nome_estrutura(int opcaoEstrutura){
        String ret = "";
        switch(opcaoEstrutura){
            case 1:
                ret = "Lista Sequencial";
                break;
            case 2:
                ret = "Lista Simplesmente Encadeada";
                break;
            case 3:
                ret = "Pilha";
                break;
            case 4:
                ret = "Fila";
                break;
            case 5:
                ret = "Árvore de Busca";
                break;
        }
        return ret;
    }
    /*funções para controlar qual tipo foi escolhida pelo usuario, retornando uma string
    contendo o tipo, que será utilizada mais pra frente  */
    public static String nome_tipo(int opcaoTipo){
        String ret = "";
        switch(opcaoTipo){
            case 1:
                ret = "inteiro";
                break;
            case 2:
                ret = "termo";
                break;
            case 3:
                ret = "caractere";
                break;
        }

        return ret;
    }

    /*
    menu de qual tipo de variáveis será utilizado na estrutura
    */
    public static int menu_tipo(){
        System.out.println("(1) - Inteiro");
        System.out.println("(2) - String");
        System.out.println("(3) - Caractere");
        System.out.println("(4) - Voltar ao menu principal");

        System.out.print("\nDigite a opção desejada: ");

        int opcao = 0;

        try{
            opcao = scan.nextInt();
        }catch(Exception e){
            scan.next();
            opcao = 7;
        }

        return opcao;
    }
    /*
    exibe o menu de qual operação o usuário desejará fazer na ED
    */
    public static int menu_operacao(){
        System.out.println("(1) - Inserir");
        System.out.println("(2) - Remover");
        System.out.println("(3) - Consultar");
        System.out.println("(4) - Limpar");
        System.out.println("(5) - Sair");

        System.out.print("\nDigite a opção desejada: ");

        int opcao = 0;

        try{
            opcao = scan.nextInt();
            
        }catch(Exception e){
            scan.next();
            opcao = 7;
        }

        return opcao;
    }
    /*
    menu para quando a opção 'consulta' for selecionada, para especificar como será a consulta
    */
    public static int menu_consulta(){
        System.out.println("Escolha o tipo de consulta: \n");

        System.out.println("(1) - Consulta por posição");
        System.out.println("(2) - Consulta por elemento");
        System.out.println("(3) - Sair");

        System.out.print("\nDigite a opção desejada: ");

        int opcao = 0;

        try{
            opcao = scan.nextInt();
        }catch(Exception e){
            scan.next();
        }

        return opcao;
    }
    
    /* Realiza o carregamento das operações */
    public static void loading(String carregamento){
        for(char c : carregamento.toCharArray()){
            System.out.print(c);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {

            }
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {

        }
        System.out.println("\n");
    }
    /*Função que ira criar a estrutura desejada a partir das escolhas do usuario nos menus anteriores */
    public static void instanciaEstrutura(int opcaoMenuPrincipal, int opcaoTipo){
        if(opcaoMenuPrincipal == 1 && opcaoTipo == 1){
            estrutura = new ListaSeqGen<Integer>(12);
        }
        else if(opcaoMenuPrincipal == 1 && opcaoTipo == 2){
            estrutura = new ListaSeqGen<String>(12);
        }
        else if(opcaoMenuPrincipal == 1 && opcaoTipo == 3){
            estrutura = new ListaSeqGen<Character>(12);
        }
        else if(opcaoMenuPrincipal == 2 && opcaoTipo == 1){
            estrutura = new SimpleLinkedList<Integer>();
        }
        else if(opcaoMenuPrincipal == 2 && opcaoTipo == 2){
            estrutura = new SimpleLinkedList<String>();
        }   
        else if(opcaoMenuPrincipal == 2 && opcaoTipo == 3){
            estrutura = new SimpleLinkedList<Character>();
        }
        else if(opcaoMenuPrincipal == 3 && opcaoTipo == 1){
            estrutura = new Stack<Integer>();
        }
        else if(opcaoMenuPrincipal == 3 && opcaoTipo == 2){
            estrutura = new Stack<String>();
        }
        else if(opcaoMenuPrincipal == 3 && opcaoTipo == 3){
            estrutura = new Stack<Character>();
        }
        else if(opcaoMenuPrincipal == 4 && opcaoTipo == 1){
            estrutura = new Queue<Integer>();
        }
        else if(opcaoMenuPrincipal == 4 && opcaoTipo == 2){
            estrutura = new Queue<String>();
        }
        else if(opcaoMenuPrincipal == 4 && opcaoTipo == 3){
            estrutura = new Queue<Character>();
        }
        else if(opcaoMenuPrincipal == 5){
            arvore = new BinarySearchTree();
        }
    }

    //função principal
    public static void main(String[] args) {
        scan = new Scanner(System.in);

        final String CARREGANDO = Cores.ANSI_BLUE + "Carregando..." + Cores.ANSI_RESET, SAINDO = Cores.ANSI_YELLOW + "Saindo..." + Cores.ANSI_RESET;
        final String OPCAOINVALIDA = Cores.ANSI_RED + "Opção inválida" + Cores.ANSI_RED;
        final int MAXIMO_INT = 9999999;

        //iniciando as variaveis de controle
        boolean controleMenuOperacao = true, controleMenuTipo = true, saiuMenuTipo = false, pesquisa = false; 

        int opcaoMenuPrincipal = 0, opcaoTipo = 0, opcaoOperacao = 0, opcaoConsulta = 0; //variáveis para armazenar as escolhas do usuário retornada pelos menus

        int temp_posicao = 0, temp_numero = 0; //variáveis temporarias 
        String temp_str = "";
        char temp_char = 'A';

        String strEstrutura = "", strTipo = "";

        inicio(); // chama o cabeçalho do menu
        while(true){ //estrutura de repetição para garantir a volta do menu principal
            opcaoMenuPrincipal = menu_principal(); //armazena o retorno inserido pelo usuario na função do menu principal em uma variavel para seu controle

            if(opcaoMenuPrincipal < 0 || opcaoMenuPrincipal > 6){ //tratamento de opções invalidas
                System.out.println(OPCAOINVALIDA);
                loading(CARREGANDO);
                continue;
            }
            else if(opcaoMenuPrincipal == 6){ //selecionou a opção Sair
                loading(SAINDO);
                break;
            }

            strEstrutura = nome_estrutura(opcaoMenuPrincipal); //strEstrutura vai armazenar a string do tipo da estrutura e evitar if desnecessários

            // Valida o valor passado pelo usuario
            if(opcaoMenuPrincipal != 5){
                loading(CARREGANDO);
            }

            controleMenuTipo = true; //inicia o menu do tipo 
            while(controleMenuTipo){ //estrutura de repetição para garantir a volta do menu tipo
                if(opcaoMenuPrincipal != 5){ //condição para garantir a escolha do tipo nas estruturas sem ser a arvore
                    while(true){  
                        opcaoTipo = menu_tipo();
                        if(opcaoTipo < 0 || opcaoTipo > 4){
                            System.out.println(OPCAOINVALIDA); //tratamento de casos inválidos
                            loading(CARREGANDO);
                            saiuMenuTipo = false;
                            continue;
                        }
                        else if(opcaoTipo == 4){ // Realiza a saida do menu
                            loading(SAINDO);  
                            saiuMenuTipo = true;
                            break;
                        }
                        else{
                            saiuMenuTipo = false;
                            strTipo = nome_tipo(opcaoTipo); //armazena o tipo escolhido pelo usuário em uma variável
                            break;
                        }
                    }
                    if(saiuMenuTipo){
                        break;
                    }
                }
                else{
                    strTipo = nome_tipo(1);
                }

                instanciaEstrutura(opcaoMenuPrincipal, opcaoTipo); //inicia a estrutura, passando o tipo correto
                loading(CARREGANDO);

                
                controleMenuOperacao = true;
                pesquisa = false; 
                while(controleMenuOperacao){
                    /* Valida  a operação 'pesquisa', se caso seja verdadeiro, a estrutura não é 
                    printada, caso não, a estrutura é mostrada no terminal*/
                    if(!pesquisa){ //evita que print 2 vezes ao consultar
                        if(opcaoMenuPrincipal != 5){
                            System.out.println(estrutura.print(false, -1, false, null));                           
                        }
                        else{
                            System.out.println("\n");
                            arvore.exibir(false, 0);
                            System.out.println();
                            System.out.println("In-ordem: " + arvore.showAscendingOrder() + "\n");
                            
                        }
                    }
                    
                    /* Abre o leque de escolhas das operações da estrutura de dados escolhida pelo usuario*/
                    opcaoOperacao = menu_operacao();
                    switch(opcaoOperacao){
                        case 1:
                            pesquisa = false;
                            System.out.println("Digite o " + strTipo + " que deseja adicionar na " + strEstrutura + ":");
                            if(opcaoMenuPrincipal != 5){
                                if(opcaoTipo == 1){
                                    try{
                                        temp_numero = scan.nextInt();
                                    }
                                    catch(Exception e){
                                        System.out.println(Cores.ANSI_RED + "Não é um " + strTipo + Cores.ANSI_RESET);
                                        loading(CARREGANDO);
                                        scan.next();
                                        break;
                                    }

                                    if(temp_numero > MAXIMO_INT){
                                        System.out.println(Cores.ANSI_RED + "Número muito grande" + Cores.ANSI_RESET);
                                        loading(CARREGANDO);
                                        break;
                                    }
                                }
                                else if(opcaoTipo == 2){
                                    temp_str = scan.next();
                                    if(temp_str.length() > 7){
                                        System.out.println(Cores.ANSI_RED + "String muito grande" + Cores.ANSI_RESET);
                                        loading(CARREGANDO);
                                        break;
                                    }
                                }
                                else if(opcaoTipo == 3){
                                    temp_str = scan.next();
                                    if(temp_str.length() > 1){
                                        System.out.println(Cores.ANSI_RED + "Não é um caractere" + Cores.ANSI_RESET);
                                        loading(CARREGANDO);
                                        break;
                                    }

                                    temp_char = temp_str.charAt(0);
                                }

                                if(opcaoMenuPrincipal == 1 || opcaoMenuPrincipal == 2){ //Lista Sequencial ou Lista Encadeada
                                    System.out.println("Digite a posição que deseja adicionar:");

                                    try{
                                        temp_posicao = scan.nextInt();
                                    }
                                    catch(Exception e){
                                        System.out.println(Cores.ANSI_RED + "Não é um inteiro" + Cores.ANSI_RESET);
                                        loading(CARREGANDO);
                                        scan.next();
                                        break;
                                    }
                                }

                                if(opcaoTipo == 1){
                                    if(estrutura.insert(temp_numero, temp_posicao)){ //realiza a inserção quando solicitado
                                        System.out.println(Cores.ANSI_GREEN + "Inserção bem-sucedida" + Cores.ANSI_RESET); 
                                    }
                                    else{
                                        System.out.println(Cores.ANSI_RED + "Inserção inválida" + Cores.ANSI_RESET); //caso a operação de inserção retorne false, avisa que a inserção nao ocorreu
                                    }
                                }
                                else if(opcaoTipo == 2){
                                    if(estrutura.insert(temp_str, temp_posicao)){
                                        System.out.println(Cores.ANSI_GREEN + "Inserção bem-sucedida" + Cores.ANSI_RED);
                                    }
                                    else{
                                        System.out.println(Cores.ANSI_RED + "Inserção inválida" + Cores.ANSI_RESET);
                                    }
                                }
                                else if(opcaoTipo == 3){ //Valida a opção de inserlção pelo usuario
                                    if(estrutura.insert(temp_char, temp_posicao)){ // valida a inserção feita pelo usuario
                                        System.out.println(Cores.ANSI_GREEN + "Inserção bem-sucedida" + Cores.ANSI_RESET);
                                    }
                                    else{
                                        System.out.println(Cores.ANSI_RED + "Inserção inválida" + Cores.ANSI_RESET);
                                    }
                                }
                            }
                            else if(opcaoMenuPrincipal == 5){ //Entra na aréa de manipulação de Arvore
                                if(arvore.getSize() > arvore.getMaximoElementos()){
                                    System.out.println(Cores.ANSI_RED + "Inserção inválida - Árvore com muitos elementos" + Cores.ANSI_RESET);
                                    break;
                                }
                                
                                try{
                                    temp_numero = scan.nextInt();
                                }
                                catch(Exception e){
                                    System.out.println(Cores.ANSI_RED + "Não é um " + strTipo + Cores.ANSI_RESET);
                                    loading(CARREGANDO);
                                    scan.next();
                                    break;
                                }

                                if(temp_numero > MAXIMO_INT){
                                    System.out.println(Cores.ANSI_RED + "Número muito grande" + Cores.ANSI_RED);
                                    loading(CARREGANDO);
                                    break;
                                }

                                try {
                                    if(arvore.insert(temp_numero)){
                                        System.out.println(Cores.ANSI_GREEN + "Inserção bem-sucedida" + Cores.ANSI_RESET); //controla as inserções na arvore
                                    }
                                    else{
                                        System.out.println(Cores.ANSI_RED + "Inserção inválida" + Cores.ANSI_RESET);
                                    }
                                } catch (FullTreeException e) {
                                    System.out.println(Cores.ANSI_RED + "Árvore cheia" + Cores.ANSI_RESET); //limita as inserções na arvore
                                }
                                
                            }
                            loading(CARREGANDO);
                            break;
                        case 2:
                            pesquisa = false;
                            if(opcaoMenuPrincipal == 1 || opcaoMenuPrincipal == 2){
                                System.out.println("Digite a posição que deseja remover da " + strEstrutura);
                                try{
                                    temp_posicao = scan.nextInt();
                                }
                                catch(Exception e){
                                    System.out.println(Cores.ANSI_RED + "Posição inválida" + Cores.ANSI_RED);
                                    scan.next();
                                    break;
                                }
                            }else if(opcaoMenuPrincipal == 5){
                                System.out.println(Cores.ANSI_RED + "Não é possível remover elementos da árvore" + Cores.ANSI_RESET);
                                loading(CARREGANDO);
                                break;
                            }

                            try {
                                estrutura.remove(temp_posicao);
                            } catch (InvalidPositionException e) {
                                System.out.println(Cores.ANSI_RED + "Posição inválida" + Cores.ANSI_RESET);
                            } catch (EmptyStructureException e) {
                                System.out.println(Cores.ANSI_RED + strEstrutura + " vazia" + Cores.ANSI_RESET);
                            }

                            loading(CARREGANDO);
                            break;
                        case 3:
                            pesquisa = true; //aciona a variável de controle para a operação de pesquisa
                            opcaoConsulta = 0; 
                            while (true){
                                loading(CARREGANDO);
                                if((opcaoMenuPrincipal == 1 || opcaoMenuPrincipal == 2)){
                                    opcaoConsulta = menu_consulta();
                                    
                                    if (opcaoConsulta == 1){
                                        System.out.println("Digite a posição que deseja consultar na " + strEstrutura);
                                        try{
                                            temp_posicao = scan.nextInt();
                                        }
                                        catch(Exception e){
                                            System.out.println(Cores.ANSI_RED + "Posição inválida" + Cores.ANSI_RESET);
                                            pesquisa = false;
                                            scan.next();
                                            break;
                                        }

                                        loading(CARREGANDO + "\n");
                                        System.out.println(estrutura.print(true, temp_posicao, false, -1));
                                        break;

                                    }else if(opcaoConsulta == 2){
                                        System.out.println("Digite o elemento que deseja consultar na " + strEstrutura);

                                        if(opcaoTipo == 1){
                                            try{
                                                temp_numero = scan.nextInt();
                                            }
                                            catch(Exception e){
                                                System.out.println(Cores.ANSI_RED + "Elemento inválido" + Cores.ANSI_RESET);
                                                pesquisa = false;
                                                scan.next();
                                                break;
                                            }

                                            loading(CARREGANDO + "\n");
                                            System.out.println(estrutura.print(false, -1, true, temp_numero));
                                        }
                                        else if(opcaoTipo == 2){
                                            temp_str = scan.next();

                                            if(temp_str.length() > 7){
                                                System.out.println(Cores.ANSI_RED + "String muito grande" + Cores.ANSI_RESET);
                                                loading(CARREGANDO);
                                                break;
                                            }

                                            loading(CARREGANDO + "\n");
                                            System.out.println(estrutura.print(false, -1, true, temp_str));
                                        }
                                        else if(opcaoTipo == 3){
                                            temp_str = scan.next();
                                            if(temp_str.length() > 1){
                                                System.out.println(Cores.ANSI_RED + "Não é um caractere" + Cores.ANSI_RESET);
                                                pesquisa = false;
                                                break;
                                            }
                                            temp_char = scan.next().charAt(0);
                                            loading(CARREGANDO + "\n");
                                            System.out.println(estrutura.print(false, -1, true, temp_char));
                                        }
                

                                        break;
                                    }
                                    else if(opcaoConsulta == 3){
                                        loading(SAINDO);
                                        break;
                                    }
                                    else{
                                        System.out.println(Cores.ANSI_RED + "Opção inválida" + Cores.ANSI_RESET);
                                    }
                                }
                                else if(opcaoMenuPrincipal == 3){
                                    System.out.println("Consultando o topo da pilha:\n");
                                    System.out.println(estrutura.print(false, -1, true, -1)); 
                                    break;
                                
                                }
                                else if(opcaoMenuPrincipal == 4){
                                    System.out.println("Consultando o inicio e o fim da fila:\n");
                                    System.out.println(estrutura.print(true, -1, true, 0));
                                    break;   
                                }
                                else if(opcaoMenuPrincipal == 5 ){
                                    System.out.println("Digite o elemento que deseja consultar na " + strEstrutura);
                                    try{
                                        temp_numero = scan.nextInt();
                                    }
                                    catch(Exception e){
                                        System.out.println(Cores.ANSI_RED + "Não é um número" + Cores.ANSI_RESET);
                                        pesquisa = false;
                                        scan.next();
                                        break;
                                    }
                                    System.out.println("\n");

                                    arvore.exibir(true, temp_numero);
                                    System.out.println("In-ordem: " + arvore.showAscendingOrder() + "\n");
                                    break;
                                }
                            }
                            break;
                        case 4:
                            pesquisa = false;
                            
                            if(opcaoMenuPrincipal != 5){
                                estrutura.clear();
                                System.out.println(strEstrutura + " limpa\n");
                            }
                            else{
                                arvore.clearTree();
                                System.out.println("Árvore limpa\n");
                            }

                            loading(CARREGANDO);
                            break;
                        case 5:
                            pesquisa = false;
                            controleMenuOperacao = false; 
                            controleMenuTipo = false;
                            loading(SAINDO);
                            break;

                        default:
                            System.out.println(Cores.ANSI_RED + "Opção inválida" + Cores.ANSI_RESET);
                            loading(CARREGANDO);
                    }
                }
            }
        }
    }
}
