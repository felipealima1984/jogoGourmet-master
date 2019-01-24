package br.com.ia;

/**
 * 
 * @author Felipe Lima
 *
 */

public class Caso {
	
	Caso casoSim;
	Caso casoNao;
	int id;
	String valor;
	
	Caso(int id){
		this.id = id;
		this.casoSim=null;    
        this.casoNao=null;
        this.valor=null;
	}
	
	public Caso(String valor, int id){
		this.valor = valor;
		this.id = id;
	}
	
}
