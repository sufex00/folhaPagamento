package objeto;

public class Funcionario 
{
	protected String nome;
	protected String enderenco;
	protected int matricula;
	protected boolean sindicato;
	protected int tipo_pagamento;
	
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

	@Override
	public String toString() {
		return "Funcionario [nome=" + nome + ", enderenco=" + enderenco
				+ ", matricula=" + matricula + ", sindicato=" + sindicato
				+ ", tipo_pagamento=" + tipo_pagamento + ", toString()="
				+ super.toString() + "]";
	}

}
