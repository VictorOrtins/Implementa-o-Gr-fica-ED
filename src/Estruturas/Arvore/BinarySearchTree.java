package Estruturas.Arvore;

import Estruturas.Cores;
import Estruturas.FullTreeException;

public class BinarySearchTree {

    private final int MAXIMO_ELEMENTOS = 18;
    private Node root;
    private int size;

    public BinarySearchTree(){
        root = null;
        size = 0;
    }

    public boolean isEmpty(){
        if(root == null){
            return true;
        }

        return false;
    }

    public Node searchNode(int value){
        if(isEmpty()){
            return null;
        }

        return searchNode(value, root);
    }

    private Node searchNode(int value, Node node){
        if(node == null){
            return null;
        }

        if(node.getValue() == value){
            return node;
        }

        Node aux = null;
        if(value > node.getValue()){
            aux = searchNode(value, node.getRight());
        }
        else{
            aux = searchNode(value, node.getLeft());
        }

        return aux;
    }

    public boolean setRoot(int value){
        if(!(isEmpty())){
            return false;
        }

        Node newRoot = new Node();
        newRoot.setValue(value);

        root = newRoot;

        return true;
    }

    public boolean insert(int value) throws FullTreeException{
        if(isEmpty()){
            return setRoot(value);
        }


        if(searchNode(value) != null){
            return false;
        }

        if(size > MAXIMO_ELEMENTOS){
            throw new FullTreeException();
        }


        Node aux = root;
        Node father = new Node();
        boolean left = false;
        while(aux != null){
            father = aux;
            if(value > aux.getValue()){
                aux = aux.getRight();
                left = false;
            }
            else{
                aux = aux.getLeft();
                left = true;
            }
        }

        aux = new Node();
        aux.setValue(value);

        if(left){
            father.setLeft(aux);
        }
        else{
            father.setRight(aux);
        }

        size++;
        return true;
    }

    public String showAscendingOrder(){
        if(isEmpty()){
            return "";
        }

        String[] ret = showAscendingOrder(root, "").split("");
        String auxiliar = "";
        for(int i = 0; i < ret.length; i++){
            auxiliar += ret[i];
        }

        return auxiliar.strip();
    }

    private String showAscendingOrder(Node node, String ret){
        if(node == null){
            return "";
        }

        return showAscendingOrder(node.getLeft(), ret) + " " + node.getValue() + " "+ showAscendingOrder(node.getRight(), ret);
    }

    public String print(boolean pesquisaValor, int valor){
        return null;
    }

    public void clearTree(){
        root = null;
        size = 0;
    }

    public Node getRoot(){
        return root;
    }

    public void exibir(boolean pesquisaValor, int valor) {

        if(root != null) {
            exibir(root, 0, pesquisaValor, valor);
        }
        else{
            System.out.println("Árvore vazia\n");
        }

    }

    private void exibir(Node atual, int altura, boolean pesquisaValor, int valor) {

        if(atual != null) {
            //Printando a parte da direita
            exibir(atual.getRight(), altura + 1, pesquisaValor, valor);

            //Dando um tab de acordo com a altura do nó
            for(int i = 0; i < altura; i++) {
                System.out.print("\t");
            }

            if(pesquisaValor && valor == atual.getValue()){
                System.out.println(Cores.ANSI_GREEN + atual.getValue() + Cores.ANSI_RESET);
            }
            else{
                System.out.println(atual.getValue());
            }

            exibir(atual.getLeft(), altura + 1, pesquisaValor, valor);
            //Printando a parte da esquerda
        }

    }

    public int getSize(){
        return size;
    }
    
    
    

    
}

