package negocio;

import objeto.*;

import java.util.ArrayList;
import java.util.Scanner;

public class N_Funcionario {

	public Funcionario addFuncionario(ArrayList<Funcionario> list_Funcionario)
	{	Funcionario new_funcionario = null;
	Scanner leitor = new Scanner(System.in);
	System.out.println("---Menu---");
	System.out.print("Nome:");
	String nome=leitor.nextLine();
	System.out.print("Endereco:");
	String endereco=leitor.nextLine();
	String sindicato;
	do{
		System.out.print("Pertence ao Sindicato(S ou N)?");
		sindicato=leitor.nextLine();
	}while(sindicato.compareToIgnoreCase("S") * sindicato.compareToIgnoreCase("N")!=0 );
	boolean isSindicato;
	if(sindicato.compareToIgnoreCase("S")==0)
		isSindicato=true;
	else
		isSindicato=false;
	System.out.println("Tipo:");
	System.out.println("[1]-Funcionario Assalariado");
	System.out.println("[2]-Funcionario Comissionado");
	System.out.println("[3]-Funcionario Horista");
	System.out.println("[0]-Sair");
	System.out.print("Opcao:");
	int tipo=leitor.nextInt();
	int pagamento=0;
	if (tipo!=0)
	{
		System.out.println("Tipo de pagamento:");
		System.out.println("[1]-Cheque Correios");
		System.out.println("[2]-Cheque em Maos");
		System.out.println("[3]-Deposito");
		System.out.println("[0]-Sair");
		System.out.print("Opcao:");
		pagamento=leitor.nextInt();
	}
	if(nome.isEmpty() || endereco.isEmpty() || tipo==0 || pagamento==0)
		new_funcionario=null;
	else
	{
		switch(tipo)
		{
		case 1:
			System.out.println("Digite o Salarios fixo do Funcionario:");
			float salario_assalariado=leitor.nextFloat();
			new_funcionario=new Assalariado(nome,endereco,list_Funcionario.size(),isSindicato,pagamento-1,salario_assalariado);
			break;
		case 2:
			System.out.println("Digite o Salario fixo do Funcionario:");
			float salario_comissionado=leitor.nextFloat();
			System.out.println("Digite o valor da comissao do Funcionario:");
			float comissao=leitor.nextFloat();
			new_funcionario=new Comissionado(nome,endereco,list_Funcionario.size(),isSindicato,pagamento-1,salario_comissionado, comissao);
			break;
		case 3:
			System.out.println("Digite o preco da hora do Funcionario:");
			float salario_horista=leitor.nextFloat();
			new_funcionario=new Horista(nome,endereco,list_Funcionario.size(),isSindicato, pagamento-1,salario_horista);
		}
	}
	return new_funcionario;

	}
	public Funcionario procuraFuncionario(ArrayList<Funcionario> list_Funcionario, int matricula)
	{
		Funcionario retorno=null;
		for(Funcionario obj_funcionario : list_Funcionario)
			if(obj_funcionario.getMatricula()==matricula)
				retorno=obj_funcionario;
		return retorno;
		
	}
}
