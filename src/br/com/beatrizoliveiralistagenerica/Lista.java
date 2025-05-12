package br.com.beatrizoliveiralistagenerica;

import java.util.NoSuchElementException;

public class Lista<T> implements ILista<T>{
	
	//inicializar o nó
	No<T> primeiro; 
	No<T> ultimo;
	
	// inicializar a lista
	public Lista() {
		primeiro = null;
	}
	

	@Override
	public boolean isEmpty() {
		if(primeiro == null) {
			return true;
		}
		return false;
	}
	
	//verifica se o valor que quer ser adicionado já existe na lista
	 public boolean contains(T dado) throws Exception {
	        No<T> atual = primeiro;
	        while (atual != null) {
	            if (atual.dado.equals(dado)) {
	                return true;
	            }
	            atual = atual.proximo;
	        }
	        addLast(dado);
	        return false;
	   }
	 
	@Override
	public int size() {
		int count = 0;
		if(!isEmpty()) {
			No<T> auxiliar = primeiro;
			while(auxiliar != null) {
				count +=1;
				auxiliar = auxiliar.proximo;
			}
		}
		return count;
	}

	@Override
	public void addFirst(T dado) {
		No<T> elemento = new No<>(dado);
		elemento.dado = dado;
		elemento.proximo = primeiro;
		primeiro = elemento; 
		
	}

	@Override
	public void addLast(T dado) throws Exception {
		if(isEmpty()) {
			addFirst(dado);
		}
		int tamanho = size();
		No<T> elemento = new No<>(dado);
		elemento.dado = dado;
		elemento.proximo = null;
		No<T> ultimo = getNo(tamanho - 1);
		ultimo.proximo = elemento;
	}

	@Override
	public void add(T dado, int posicao) throws Exception {
		int tamanho = size();
		if(posicao < 0 || posicao > tamanho) {
			throw new IllegalArgumentException("Posição inválida: " + posicao);
		}
		if(posicao == 0) {
			addFirst(dado);
		} else if(posicao == tamanho) {
			addLast(dado);
		} else {
			No<T> elemento = new No<T>(dado);
			elemento.dado = dado;
			No<T> anterior = getNo(posicao - 1);
			elemento.proximo = anterior.proximo;
			anterior.proximo = elemento;
		}
		
	}

	@Override
	public void removeFirst() throws Exception {
		if(isEmpty()) {
			throw new NoSuchElementException("A lista está vazia.");
		}
		primeiro = primeiro.proximo;
		
	}

	@Override
	public void removeLast() throws Exception {
		if(isEmpty()) {
			throw new NoSuchElementException("A lista está vazia.");
		}
		int tamanho = size();
		if(tamanho == 1) {
			removeFirst();
		} else {
			No<T> penultimo = getNo(tamanho - 2);
			penultimo .proximo = null;
		}
	}

	@Override
	public void remove(int posicao) throws Exception {
		if(isEmpty()) {
			throw new NoSuchElementException("A lista está vazia.");
		}
		int tamanho  = size();
		if(posicao < 0 || posicao  > tamanho - 1) {
			throw new IllegalArgumentException("Posição inválida: " + posicao);
		}
		if(posicao == 0) {
			removeFirst();
		}else if(posicao == tamanho - 1) {
			removeLast();
		}else {
			No<T> anterior = getNo(posicao - 1);
			No<T> atual = getNo(posicao);
			anterior.proximo = atual.proximo;
		}
	}

	@Override
	public T get(int posicao) throws Exception {
		No<T> elemento = getNo(posicao);
		return elemento.dado;
	}
	
	// vamos contar até chegar na posicao que estamos procurando.
	public No<T> getNo(int posicao) {
		int tamanho = size();
		if(isEmpty()) {
			throw new NoSuchElementException("A lista está vazia.");
		}
		if(posicao < 0 || posicao > tamanho) {
			throw new IllegalArgumentException("Posição inválida: " + posicao);
		}
		No<T> auxiliar = primeiro;
		int count = 0;
		while(count < posicao) {
			auxiliar = auxiliar.proximo;
			count++;
		}
		return auxiliar;
	}


	@Override
	public void limpa() {
		for(No<T> atual = primeiro; atual != null;) {
			No<T> proximo = atual.getProximo();
			atual.setDado(null);
			atual.setProximo(null);
			atual = proximo;
		}
		primeiro = null;
		ultimo = null;
	}
}
