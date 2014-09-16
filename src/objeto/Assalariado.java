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
	public Assalariado(String nome, String enderenco, int matricula,
			boolean sindicato, int tipo_pagamento, float salario,
			Sindicato obj_sindicato) {
		// TODO Auto-generated constructor stub
		super(nome, enderenco, matricula, sindicato, tipo_pagamento, obj_sindicato);
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
		return "Assalariado [" + super.toString() +  ", salario=" + salario + "]";
	}
	
	@Override
	public String pagamento()
	{
		return "O funcionario " + this.getNome()+" recebeu de salario "+this.getSalario()+".";
		
	}

	
	

	
	
}
