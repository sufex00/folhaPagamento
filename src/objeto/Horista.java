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

	public float getPreco_hora() {
		return preco_hora;
	}
	public void setPreco_hora(float preco_hora) {
		this.preco_hora = preco_hora;
	}

	@Override
	public String toString() {
		return "Horista [preco_hora=" + preco_hora + ", nome=" + nome
				+ ", enderenco=" + enderenco + ", matricula=" + matricula
				+ ", sindicato=" + sindicato + ", tipo_pagamento="
				+ tipo_pagamento + "]";
	}
	
	
	

}
