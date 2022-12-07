package Estruturas.ListaSeq;

import Estruturas.Cores;
import Estruturas.EmptyStructureException;
import Estruturas.Estrutura;
import Estruturas.InvalidPositionException;

public class ListaSeqGen<T> extends Estrutura<T>{
	private T dados[]; // Vetor que contém os dados da lista 
	private int nElementos;
	private int tam_array;
	private final int MAX_NODOS_LINHA = 12;
    
    public ListaSeqGen(){
    		nElementos = 0;
			tam_array = 100;
    		dados = (T[]) new Object[100];
    }
    
    public ListaSeqGen(int n){
    		nElementos = 0;
			tam_array = n;
    		dados = (T[]) new Object[n];
    }

	
    /**Verifica se a Lista está cheia */
    public boolean cheia(){
		if (nElementos == dados.length)
			return true;
		else
			return false;
	}
	
    /**Obtém o tamanho da Lista*/
    public int tamanho(){
		return nElementos;
	}
    
    /** Obtém o i-ésimo elemento de uma lista.
    		Retorna -1 se a posição for inválida. */
    public T elemento(int pos){
        
    	/* Se posição estiver fora dos limites <= 0 
         * ou > tamanho da lista */
        if ((pos > nElementos) || (pos <= 0))
            return null;

       return dados[pos-1];
	}

    /**	Retorna a posição de um elemento pesquisado.
    		Retorna -1 caso não seja encontrado */
	public int posicao (T valor){
	    /* Procura elemento a elemento, se o dado está na
	    		lista. Se estiver, retorna a sua posição no array+1 */
	    for (int i = 0; i < nElementos; i++){
	        if (dados[i].equals(valor)){
	            return (i + 1);
	        }
	    }

	    return -1;
	}
	
	/**	Retorna a posição de um elemento pesquisado.
	Retorna -1 caso não seja encontrado */
	public int posicao (T valor, int desloc){
		/* Procura elemento a elemento, se o dado está na
		lista. Se estiver, retorna a sua posição no array+1 */
		for (int i = desloc+1; i < nElementos; i++){
		    if (dados[i].equals(valor)){
		        return (i + 1);
		    }
		}
		
		return -1;
	}

	/**Remove um elemento de uma determinada posição
    Retorna o valor do elemento removido. -1 caso a remoção falhe  */
	public T remove(int pos) throws InvalidPositionException, EmptyStructureException{
	    T dado;
		/* Verifica se a posicao eh valida */
	    if ((pos > nElementos) || (pos < 1 ))
			   throw new InvalidPositionException();

		
		if(isEmpty()){
			throw new EmptyStructureException();
		}

	    /* Armazena o dado a ser removido na var "dado" */
	    dado = dados[pos-1];
		if(pos == nElementos){
			dados[pos - 1] = null;
			nElementos--;
			return dado;
		}

	    /* Desloca todos os elementos após 'pos', uma
	    posicao a esquerda */
	    for (int i = pos - 1; i < nElementos - 1; i++){
	 		  dados[i] = dados[i+1];
			  if(i == nElementos - 2){
				dados[i+1] = null;
			  }
		 }

	   /* Decrementa o numero de elementos na lista */
	    nElementos--;
	    return dado;
	}

	public void clear(){
		nElementos = 0;
		for(int i = 0; i < tam_array; i++){
			dados[i] = null;
		}
	}

	@Override
	public boolean isEmpty() {
		if (nElementos == 0 )
			return true;
		else
			return false;
		
	}

	@Override
	public boolean insert(T value, int position) {
		/* Verifica se a lista está cheia ou se a posicao a ser
	    inserida eh invalida (i.e., > tamanho da lista+1*/
	    if (cheia() || (position > nElementos+1) || (position <=0)){
	        return false;
	    }

	    /* Desloca os elementos após position, uma positionicao a
	    direita. Isso serve para abrir espaço para insercao
	    do novo elemento */
	    for (int i = nElementos; i >= position; i--){
	 		 dados[i] = dados[i-1];
	    }

	    /* Insere o dado na positionicao correta */
	    dados[position - 1] = value;

	 	/* Incrementa o numero de elementos na lista */
	    nElementos++;
	    return true;
		
	}

	@Override
	public String print(boolean pesquisaPosicao, int posicao, boolean pesquisaValor, T valor) {
		String ret = "";

		/*
		 * 4 linhas de cada "segmento" do terminal, cada segmento formado por 4-6 linhas
		 */

		String linha1 = "";
        String linha2 = "";
        String linha3 = "";
        String linha4 = "";

        String temp_str = "";
		String dados_i = "";

        int linha3_length = 0; //Para o cálculo dos tracinhos
		int posicao_lista = 0; 

		for(int i = 0; i < tam_array; i++){
			posicao_lista = i + 1; 

			if(dados[i] == null){
				dados_i = "null";
			}
			else{
				dados_i = dados[i].toString();
			}

			temp_str = "| " + dados_i + " |";
			linha3_length = temp_str.length();

			if((pesquisaValor && valor.equals(dados[i]) || pesquisaPosicao && posicao == posicao_lista) && dados[i] != null){
				temp_str = "| " + Cores.ANSI_GREEN + dados_i + Cores.ANSI_RESET +  " |";
			}


			if(posicao_lista % MAX_NODOS_LINHA != 1){ //Se isso aqui não for o primeiro da lista
				if((pesquisaValor && valor.equals(dados[i]) || pesquisaPosicao && posicao == posicao_lista) && dados[i] != null){
					temp_str = " " + Cores.ANSI_GREEN + dados_i + Cores.ANSI_RESET + " |";
				}
				else{
					temp_str = " " + dados_i + " |";
				}
			}	

			linha3 += temp_str;
			
			//Adicionar primeiro traço da Lista Sequencial
			if(posicao_lista % MAX_NODOS_LINHA == 0){
				linha2 += "-";
				linha4 += "-";
			}

			//Adiciona os traços nas linhas 2 e 4
			for(int j = 0; j < linha3_length - 1; j++){
				linha2 += "-";
				linha4 += "-";
			}

			//Se for o último da linha
            if(posicao_lista % MAX_NODOS_LINHA == 0){
                ret += linha1 + "\n" + linha2 + "\n" + linha3 + "\n" + linha4 + "\n";
                linha1 = "";
                linha2 = "";
                linha3 = "";
                linha4 = "";
            }

		}


		return ret;
		
	}

}
