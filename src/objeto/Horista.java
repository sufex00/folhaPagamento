package objeto;

public class Horista extends Funcionario
{

	private float preco_hora;
	
	public Horista(String nome, String enderenco, int matricula,
			boolean sindicato, int tipo_pagamento, float preco_hora) {
		super(nome, enderenco, matricula, sindicato, tipo_pagamento);
		// TODO Auto-generated constructor stub
		this.preco_hora=preco_hora;
	}

	public Horista(String nome, String enderenco, int matricula,
			boolean sindicato, int tipo_pagamento, float preco_hora,
			Sindicato obj_sindicato) {
		// TODO Auto-generated constructor stub
		super(nome, enderenco, matricula, sindicato, tipo_pagamento, obj_sindicato);
		this.preco_hora=preco_hora;
	}

	public float getPreco_hora() {
		return preco_hora;
	}
	public void setPreco_hora(float preco_hora) {
		this.preco_hora = preco_hora;
	}

	@Override
	public String toString() {
		return "Horista ["+ super.toString() +", preco_hora=" + preco_hora + "]";
	}
	
	


	
	
	

}
