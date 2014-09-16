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
		float salario=this.getSalario();
		if(this.isSindicato())
		{
			for(Pagamento obj_pagamento : this.list_pagamento)
			{
				salario-=obj_pagamento.getTaxaSindicato();
			}
			salario-=this.getObj_sindicato().getTaxa();
		}
		String pagamento="O funcionario " + this.getNome()+" recebeu de salario "+salario+", pois:\n";
		pagamento=pagamento.concat("Salario fixo: "+this.getSalario());
		if(this.isSindicato())
		{
			for(Pagamento obj_pagamento : this.list_pagamento)
			{
				pagamento=pagamento.concat("\nTaxas sindicais: -" + obj_pagamento.getTaxaSindicato());
			}
			pagamento=pagamento.concat("\nMensalidade sindical: -" + this.getObj_sindicato().getTaxa());
		}
		pagamento=pagamento.concat("\nMetodo de pagamento: ");
		switch(this.getTipo_pagamento())
		{
		case 0:
			pagamento=pagamento.concat("Cheque pelos correios");
			break;
		case 1:
			pagamento=pagamento.concat("Cheque em maos");
			break;
		case 2:
			pagamento=pagamento.concat("Deposito");
			break;
		}
		return pagamento;
		
	}

	
	

	
	
}
