package Estruturas.Pilha;

import Estruturas.Cores;
import Estruturas.EmptyStructureException;
import Estruturas.Estrutura;
import Estruturas.InvalidPositionException;
import Estruturas.SimpleNode;

public class Stack<T> extends Estrutura<T>{

    private SimpleNode<T> top;
    private int size;

    public Stack(){
        top = null;
        size = 0;
    }

    public boolean isEmpty(){
        if (size == 0){
            return true;
        }

        return false;
    }

    public T getTop(){
        return this.top.getValue();
    }

    public int getSize() {
        return this.size;
    }

    public SimpleNode<T> getterTop() {
        return this.top;
    }

    public void setTop(SimpleNode<T> top) {
        this.top = top;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void sizePlus(int update){
        this.size += update;
    }

    public void clear(){
        top = null;
        size = 0;
    }

    public String printStack(){
        String ret = "[ ";
        SimpleNode<T> aux = top;

        while(aux != null){
            ret += aux.getValue() + " ";
            aux = aux.getNext();
        }

        ret += "]";

        return ret;
    }


    @Override
    public boolean insert(T value, int position) {
        return insert(value);
    }

    public boolean insert(T value){
        SimpleNode<T> aux = new SimpleNode<T>();

        aux.setValue(value);
        aux.setNext(top);

        top = aux;


        sizePlus(1);

        return true;
    }

    @Override
    public T remove(int position) throws InvalidPositionException, EmptyStructureException {
        return remove();
    }

    public T remove() throws EmptyStructureException{
        if(isEmpty()){
            throw new EmptyStructureException();
        }
        SimpleNode<T> aux = top;
        SimpleNode<T> formerTop = aux;

        top = aux.getNext();
        aux.setNext(null);

        sizePlus(-1);

        return formerTop.getValue();
    }

    @Override
    //Os dois últimos parâmetros são os que importam
    public String print(boolean pesquisaPosicao, int posicao, boolean pesquisaValor, T valor) {
        SimpleNode<T> temp = top;
        
        if(temp == null){
            return "Pilha vazia\n";
        }

        String ret = "";

        String linha1 = "";
        String linha2 = "";
        String linha3 = "";
        String linha4 = "";

        String temp_str = "";

        int linha2_length = 0;
        int contador_nodos = 1;

        final int CENTRO = 70;
        final int TRACOS = 11;
        

        while(temp != null){

            for(int i = 0; i < CENTRO/2; i++){
                linha1 += " ";
                linha2 += " ";
                linha3 += " ";
                linha4 += " ";
            }

            temp_str = "| " + temp.getValue().toString() + " |";
            linha2_length = temp_str.length();

            if(pesquisaValor && contador_nodos == 1 || pesquisaPosicao && posicao == contador_nodos){
                temp_str = "| " + Cores.ANSI_GREEN + temp.getValue().toString() + Cores.ANSI_RESET + " |";
            }
            else{
                temp_str = "| " + temp.getValue().toString() + " |";
            }

            //Ficava um | a mais
            temp_str = removeSuffix(temp_str, "|");

            //Espaços dentro do nó
            for(int i = 0; i < TRACOS - linha2_length; i++){
                temp_str += " ";
            }

            //| do lado direito do nó
            temp_str += " |";
            linha2 += temp_str;

            if(contador_nodos != size){
                for(int i = 0; i < 3; i++){
                    for(int j = 0; j < TRACOS/2; j++){
                        linha4 += " ";
                    }

                    linha4 += "|";
                    if(i != 2){
                        linha4 += "\n";
                    }
                    //Botar os 2 últimos traços da conexão de nós no meio
                    for(int j = 0; j < CENTRO/2; j++){
                        linha4 += " ";
                    }
                }
            }


            for(int i = 0; i < 11; i++){
                linha1 += "-";
                linha3 += "-";
            }

            temp = temp.getNext();
            ret += linha1 + "\n" + linha2 + "\n" + linha3 + "\n" + linha4 + "\n";
            linha1 = "";
            linha2 = "";
            linha3 = "";
            linha4 = "";
            
            contador_nodos++;
        }

        return ret;
    }

    public static String removeSuffix(final String s, final String suffix)
    {
        if (s != null && suffix != null && s.endsWith(suffix)) {
            return s.substring(0, s.length() - suffix.length());
        }
        return s;
    }
}
