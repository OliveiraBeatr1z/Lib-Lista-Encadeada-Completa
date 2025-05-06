package br.com.beatrizoliveiralistagenerica;

public class No<T>  {
	T dado;
	No<T> proximo;
	
	
	public No(T dado) {
		super();
		this.dado = dado;
		this.proximo = null;  // ultimo elemento da lista sempre vai ter valor null
	}
	
	public No(T dado, No<T> proximo) {
		this.dado = dado;
		this.proximo = proximo;
	}

	public T getDado() {
		return dado;
	}

	public void setDado(T dado) {
		this.dado = dado;
	}

	public No<T> getProximo() {
		return proximo;
	}

	public void setProximo(No<T> proximo) {
		this.proximo = proximo;
	}
	
	
}