package br.com.ia;

/**
 * 
 * @author Felipe Lima
 *
 */

public class Arvore {

	private Caso ARVORE;

	public Caso getARVORE() {
		return ARVORE;
	}

	public void setARVORE(Caso aRVORE) {
		ARVORE = aRVORE;
	}

	protected void inserirValor(Caso nao, String valor1, String valor2) {

		String aux = nao.valor;
		nao.valor = valor1;
		nao.casoSim = new Caso(valor2, ++Jogo.indice);
		nao.casoNao = new Caso(aux, ++Jogo.indice);

	}

}
