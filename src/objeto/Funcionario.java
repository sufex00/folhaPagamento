package objeto;

public class Funcionario 
{
	protected String nome;
	protected String enderenco;
	protected int matricula;
	protected boolean sindicato;
	protected int tipo_pagamento;
	protected Sindicato obj_sindicato;
	
	protected static final int cheque_correios = 0;
	protected static final int cheque_maos     = 1;
	protected static final int deposito        = 2;
	
	public Funcionario(String nome, String enderenco, int matricula,
			boolean sindicato, int tipo_pagamento) {
		this.nome = nome;
		this.enderenco = enderenco;
		this.matricula = matricula;
		this.sindicato = sindicato;
		this.tipo_pagamento = tipo_pagamento;
	}
	
	public Funcionario(String nome, String enderenco, int matricula,
			boolean sindicato, int tipo_pagamento, Sindicato obj_sindicato) {
		this.nome = nome;
		this.enderenco = enderenco;
		this.matricula = matricula;
		this.sindicato = sindicato;
		this.tipo_pagamento = tipo_pagamento;
		if(this.sindicato)
			this.obj_sindicato=obj_sindicato;
		else 
			this.obj_sindicato=null;
	}
	
	public Sindicato getObj_sindicato() {
		return obj_sindicato;
	}

	public void setObj_sindicato(Sindicato obj_sindicato) {
		this.obj_sindicato = obj_sindicato;
	}

	public String getNome() 
	{
		return nome;
	}
	public void setNome(String nome) 
	{
		if(!nome.isEmpty())
			this.nome = nome;
	}
	public int getMatricula() 
	{
		return matricula;
	}
	public void setMatricula(int matricula) 
	{
		if(this.matricula>0)
			this.matricula = matricula;
	}

	public boolean isSindicato() {
		return sindicato;
	}

	public void setSindicato(boolean sindicato) {
		this.sindicato = sindicato;
	}

	public int getTipo_pagamento() {
		return tipo_pagamento;
	}

	public void setTipo_pagamento(int tipo_pagamento) {
		this.tipo_pagamento = tipo_pagamento;
	}

	public String getEnderenco() {
		return enderenco;
	}

	public void setEnderenco(String enderenco) {
		this.enderenco = enderenco;
	}

	@Override
	public String toString() {
		String retorno = "nome=" + nome + ", enderenco=" + enderenco
				+ ", matricula=" + matricula ;
		switch(this.tipo_pagamento)
		{
		case 0:
			retorno = retorno + ", tipo de pagamento= cheque pelos correios";
			break;
		case 1:
			retorno = retorno+", tipo de pagamento= cheque em maos";
			break;
		case 2:
			retorno = retorno + ", tipo de pagamento= deposito";
			break;
		}
		if(this.sindicato)
			retorno = retorno + ", sindicato=sim, taxa do sindicato="+this.obj_sindicato.getTaxa()+ ", id="+ this.obj_sindicato.getMatricula_sindicato();
		else
			retorno = retorno + ", sindicato=nao";
		return retorno;
	}

}
