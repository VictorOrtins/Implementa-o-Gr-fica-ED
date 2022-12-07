package Estruturas;

public abstract class Estrutura<T> {

    public abstract boolean isEmpty();

    public abstract boolean insert(T value, int position);

    public abstract T remove (int position) throws InvalidPositionException, EmptyStructureException;

    public abstract String print(boolean pesquisaPosicao, int posicao, boolean pesquisaValor, T valor);

    public abstract void clear();

}
