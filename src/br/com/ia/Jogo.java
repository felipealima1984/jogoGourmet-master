package br.com.ia;


import javax.swing.JOptionPane;

/*
 * @author Felipe Lima
 * 
 */

public class Jogo extends Arvore {

	public static int indice = 1;

	public Jogo() {
		
		String str[] = { "Sim", "Não" };


		int sair = 1;

		while (sair == 1) {
			JOptionPane.showMessageDialog(null, "Pense em um prato que gosta");
			
			if (getARVORE() == null) {
				setARVORE(new Caso("pensou é massa?", indice));
				getARVORE().casoNao = new Caso("Bolo de Chocolate", ++indice);
				getARVORE().casoSim = new Caso("Lasanha", ++indice);
				
			}

			int resp = JOptionPane.showOptionDialog(null, "O prato que você "
					+ getARVORE().valor, "Confirm", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, str, str[0]);

			if (resp == 0) {
				
				perguntarUsuario(getARVORE().casoSim);
			} else {
				
				perguntarUsuario(getARVORE().casoNao);
			}

			int respSair = JOptionPane.showOptionDialog(null,
					"Deseja sair do jogo?", "Confirm",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
					null, str, str[0]);

			if (respSair == 0) {
				sair = 0;
			}
		}

	}

	private void inserirPratoNovo(Caso no) {
		
		++indice;
			String prato = JOptionPane.showInputDialog(null,
					"Qual prato pensou?");

			++indice;
			String caracteristica = JOptionPane.showInputDialog(prato + " é ______ mas  "+ no.valor +" não.");

			inserirValor(no, caracteristica, prato);
	
	}

	private void perguntarUsuario(Caso caso) {
		String str[] = { "Sim", "Não" };

		int respSim = JOptionPane.showOptionDialog(null, "O prato que você pensou é "
				+ caso.valor, "Confirm", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, str, str[0]);

		if (respSim == 0) {

			if (caso.casoSim == null)
				JOptionPane.showMessageDialog(null, "Acertei de novo!");
			else {
				perguntarUsuario(caso.casoSim);
			}

		} else {
			if (caso.casoNao == null)
				inserirPratoNovo(caso);
			else {
				perguntarUsuario(caso.casoNao);
			}
		}

	}

}
