package objeto;

public class Assalariado extends Funcionario
{

	private float salario;
	public Assalariado(String nome, String enderenco, int matricula,
			boolean sindicato, int tipo_pagamento, float salario) {
		super(nome, enderenco, matricula, sindicato, tipo_pagamento);
		// TODO Auto-generated constructor stub
		this.salario=salario;
	}
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		if(salario>0)
			this.salario = salario;
	}
	@Override
	public String toString() {
		return "Assalariado [salario=" + salario + ", nome=" + nome
				+ ", enderenco=" + enderenco + ", matricula=" + matricula
				+ ", sindicato=" + sindicato + ", tipo_pagamento="
				+ tipo_pagamento + "]";
	}
	

	
	
}
