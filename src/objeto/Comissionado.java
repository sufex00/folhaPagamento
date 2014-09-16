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
	
	public Comissionado(String nome, String enderenco, int matricula,
			boolean sindicato, int tipo_pagamento,float salario, float comissao, Sindicato obj_sindicato) {
		super(nome, enderenco, matricula, sindicato, tipo_pagamento, salario, obj_sindicato);
		// TODO Auto-generated constructor stub
		this.comissao=comissao;
	}

	public float getComissao() {
		return comissao;
	}

	public void setComissao(float comissao) {
		this.comissao = comissao;
	}



	@Override
	public String toString() {
		return super.toString().replace("Assalariado [","Comissionado [" ).replace("]", "") +", comissao=" + comissao + "]";
	}
	
	@Override
	public String pagamento()
	{
		String pagamento;
		float salario=this.getSalario();
		for(Venda obj_venda : this.list_venda)
		{
			salario+=obj_venda.getValorVenda()*this.comissao;
		}
		pagamento="O funcionario "+this.getNome()+" recebeu de salario "+ salario +" pois:\n";
		pagamento=pagamento.concat("Salario fixo: "+this.getSalario());
		for(Venda obj_venda : this.list_venda)
		{
			pagamento=pagamento.concat("\nVenda: "+obj_venda.getValorVenda() + "   comissao: " 
		+ obj_venda.getValorVenda()*this.comissao + "(" + this.comissao*100 + "%)");
		}
		return pagamento;
		
	}

}
