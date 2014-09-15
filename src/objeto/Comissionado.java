package objeto;

import java.util.ArrayList;

public class Comissionado extends Assalariado
{

	private float comissao;

	public Comissionado(String nome, String enderenco, int matricula,
			boolean sindicato, int tipo_pagamento,float salario, float comissao) {
		super(nome, enderenco, matricula, sindicato, tipo_pagamento, salario);
		// TODO Auto-generated constructor stub
		this.comissao=comissao;
	}

	
	@Override
	public String toString() {
		return super.toString().replace("Assalariado [","Comissionado [" ).replace("]", "") +", comissao=" + comissao + "]";
	}
	
	

}
