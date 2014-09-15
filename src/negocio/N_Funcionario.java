package negocio;

import objeto.*;

import java.util.ArrayList;
import java.util.Scanner;

public class N_Funcionario {

	public Funcionario addFuncionario(ArrayList<Funcionario> list_Funcionario)
	{	
		Funcionario new_funcionario = null;
		Sindicato obj_sindicato=null;
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
		{
			isSindicato=true;
			System.out.println("Digite a taxa do sindicato");
			float taxa=leitor.nextFloat();
			obj_sindicato= new Sindicato(this.procuraSindicato(list_Funcionario), taxa);
		}
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
				new_funcionario=new Assalariado(nome,endereco,this.procuraMatricula(list_Funcionario),isSindicato,pagamento-1,salario_assalariado);
				if(isSindicato)
					new_funcionario.setObj_sindicato(obj_sindicato);
				break;
			case 2:
				System.out.println("Digite o Salario fixo do Funcionario:");
				float salario_comissionado=leitor.nextFloat();
				System.out.println("Digite o valor da comissao do Funcionario:");
				float comissao=leitor.nextFloat();
				new_funcionario=new Comissionado(nome,endereco,this.procuraMatricula(list_Funcionario),isSindicato,pagamento-1,salario_comissionado, comissao);
				if(isSindicato)
					new_funcionario.setObj_sindicato(obj_sindicato);
				break;
			case 3:
				System.out.println("Digite o preco da hora do Funcionario:");
				float salario_horista=leitor.nextFloat();
				new_funcionario=new Horista(nome,endereco,this.procuraMatricula(list_Funcionario),isSindicato, pagamento-1,salario_horista);
				if(isSindicato)
					new_funcionario.setObj_sindicato(obj_sindicato);
				break;
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
	public int procuraMatricula(ArrayList<Funcionario> list_Funcionario)
	{
		int matricula=0;
		boolean existeMatricula=false;
		int i;
		do
		{
			for(i=0 ; i<list_Funcionario.size() ; i++)
			{
				if(list_Funcionario.get(i).getMatricula()==matricula)
				{
					matricula++;
					i=0;
				}
			}
		}while(existeMatricula);
		return matricula;
	}
	public int procuraSindicato(ArrayList<Funcionario> list_Funcionario)
	{
		int matricula=0;
		boolean existeMatricula=false;
		int i;
		do
		{
			for(i=0 ; i<list_Funcionario.size() ; i++)
			{
				if(list_Funcionario.get(i).getObj_sindicato().getMatricula_sindicato()==matricula)
				{
					matricula++;
					i=0;
				}
			}
		}while(existeMatricula);
		return matricula;
	}
	public Funcionario alterarFuncionario(Funcionario obj_funcionario)
	{
		Scanner leitor = new Scanner(System.in);
		System.out.println("Escolha qual opcao deseja alterar:");
		System.out.println("[1]-Nome");
		System.out.println("[2]-Endereco");
		System.out.println("[3]-Metodo de pagamaneto");
		System.out.println("[4]-Pertence ao sindicado");
		System.out.println("[5]-Identificacao do Sindicato");
		System.out.println("[6]-Taxa Sindical");
		System.out.println("[7]-Tipo de Funcionario");
		int opcao=leitor.nextInt();
		switch(opcao)
		{
			case 1:
				System.out.print("Digite o novo nome:");
				String nome=leitor.nextLine();
				obj_funcionario.setNome(nome);
				break;
			case 2:
				System.out.print("Digite o novo endereco:");
				String endereco=leitor.nextLine();
				obj_funcionario.setEnderenco(endereco);
				break;
			case 3:
				System.out.println("Tipo de pagamento:");
				System.out.println("[1]-Cheque Correios");
				System.out.println("[2]-Cheque em Maos");
				System.out.println("[3]-Deposito");
				System.out.println("[0]-Sair");
				System.out.print("Opcao:");
				int pagamento=leitor.nextInt();
				obj_funcionario.setTipo_pagamento(pagamento-1);
				break;
			case 4:
				String sindicato;
				do
				{
					System.out.print("Pertence ao Sindicato(S ou N)?");
					sindicato=leitor.nextLine();
				}while(sindicato.compareToIgnoreCase("S") * sindicato.compareToIgnoreCase("N")!=0 );
				if(sindicato.compareToIgnoreCase("S")==0)
					obj_funcionario.setSindicato(true);
				else
					obj_funcionario.setSindicato(false);
				break;
			case 6:
				if(obj_funcionario.isSindicato())
				{
					System.out.println("Digite a taxa do sindicato:");
					float taxa=leitor.nextFloat();
				}
			case 7:
				System.out.println("Escolha o novo tipo do funcionario:");
				System.out.println("[1]-Funcionario Assalariado");
				System.out.println("[2]-Funcionario Comissionado");
				System.out.println("[3]-Funcionario Horista");
				System.out.println("[0]-Sair");
				System.out.print("Opcao:");
				int tipo=leitor.nextInt();
				switch(tipo)
				{
					case 1:
						System.out.println("Digite o salario do funcionario");
						float salario_assalariado=leitor.nextFloat();
						obj_funcionario=new Assalariado(obj_funcionario.getNome(), obj_funcionario.getEnderenco(),
							obj_funcionario.getMatricula(), obj_funcionario.isSindicato(), obj_funcionario.getTipo_pagamento(),
								salario_assalariado, obj_funcionario.getObj_sindicato());
						break;
					case 2:
						System.out.println("Digite o salario do funcionario");
						float salario_comissionado=leitor.nextFloat();
						System.out.println("Digite a comissao do funcionario");
						float comissao=leitor.nextFloat();
						obj_funcionario=new Comissionado(obj_funcionario.getNome(), obj_funcionario.getEnderenco()
							, obj_funcionario.getMatricula(), obj_funcionario.isSindicato(),
								obj_funcionario.getTipo_pagamento(), salario_comissionado, comissao);
						break;
					case 3:
						System.out.println("Digite o valor da hora do funcionario");
						float valor_hora=leitor.nextFloat();
						obj_funcionario=new Horista(obj_funcionario.getNome(), obj_funcionario.getEnderenco(),
							obj_funcionario.getMatricula(), obj_funcionario.isSindicato(), obj_funcionario.getTipo_pagamento()
								, valor_hora, obj_funcionario.getObj_sindicato());
						break;
				}
		}
		return null;
	}
}
