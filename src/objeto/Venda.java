package objeto;

public class Venda {
	private float valorVenda;
	private int idFuncionario;
	public Venda(float valorVenda, int idFuncionario) {
		this.valorVenda = valorVenda;
		this.idFuncionario = idFuncionario;
	}
	public float getValorVenda() {
		return valorVenda;
	}
	public void setValorVenda(float valorVenda) {
		this.valorVenda = valorVenda;
	}
	public int getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	

}
