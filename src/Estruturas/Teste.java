package Estruturas;

import Estruturas.LSE.SimpleLinkedList;
import Estruturas.ListaSeq.ListaSeqGen;
import Estruturas.Pilha.Stack;
import Estruturas.Queue.Queue;
import Estruturas.Arvore.BinarySearchTree;


public class Teste {
    public static void main(String[] args) throws EmptyStructureException {
         BinarySearchTree arvore = new BinarySearchTree();

        arvore.insert(10);
        arvore.insert(20);
        arvore.insert(30);
        arvore.insert(40);
        arvore.insert(5);
        arvore.insert(3);
        arvore.insert(100);
        arvore.insert(1);

        arvore.exibir();

        // System.out.println(arvore.showAscendingOrder().print(true, 0));
        
        // System.out.println(arvore.searchNode(20));

        // System.out.println(arvore.searchNode(50));

        
        /*Estrutura estrutura = new Queue<Integer>();

        int tipo = 2;

        switch(tipo){
            case 0:
                estrutura = new SimpleLinkedList<Integer>();
                break;
            case 1:
                estrutura = new Stack<Integer>();
                break;
            case 2:
                estrutura = new ListaSeqGen<String>(12);
                break;
        }

        estrutura.insert(10, 1);
        estrutura.insert(20, 2);
        estrutura.insert(30, 3);
        estrutura.insert(40,2);

        try {
            estrutura.remove(4);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // System.out.println(estrutura.isEmpty());

        System.out.println(estrutura.print(false, 0, false, 0));

        // estrutura.clear();

        // System.out.println(estrutura.isEmpty());

        System.out.println(estrutura.print(false, 0, false, 0));

        // estrutura = new SimpleLinkedList<String>();

        // estrutura.insert("String", 1);
        // estrutura.insert("Opa", 1);
        // estrutura.insert("Teste", 2);

        // System.out.println(estrutura.print(true, 1, false, 0));

        // estrutura = new Stack<Character>();

        // estrutura.insert('C', 0);
        // estrutura.insert('B', 0);
        // estrutura.insert('A', 0);
        // estrutura.insert('D', 0);

        // try {
        //     estrutura.remove(0);
        // } catch (InvalidPositionException e) {
        //     e.printStackTrace();
        // }

        // System.out.println(estrutura.print(true , 2, false, 0));

        // estrutura = new Queue<Integer>();

        // estrutura.insert(1, 0);
        // estrutura.insert(2,0);
        // try {
        //     estrutura.remove(0);
        // } catch (InvalidPositionException e) {
        //     e.printStackTrace();
        // }
        // estrutura.insert(3,0);
        // estrutura.insert(5, 0);

        // System.out.println(estrutura.print(true,1, false, 0));*/
    }
}
