
import objeto.*;
import negocio.*;

import java.util.Scanner;
import java.util.ArrayList;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leitor = new Scanner(System.in);
		ArrayList<Funcionario> list_Funcionario=new ArrayList<Funcionario>();
		N_Funcionario n_Funcionario=new N_Funcionario();
		list_Funcionario.add(new Comissionado("pedro", "travessa", 0, true, 0, 1000, (float) 0.2));
		list_Funcionario.add(new Assalariado("rafael", "santo", 1, false, 1, 2000));
		list_Funcionario.add(new Horista("joao","antonio", 2, true, 2, 15));
		
		do
		{
			System.out.println("---Menu-----\n");
			System.out.println("[1]-Inserir funcionario");
			System.out.println("[2]-Remover funcionario");
			System.out.println("[3]-Mostrar Funcionario");
			System.out.println("[4]-Alterar Dados");
			System.out.println("[5]-Sair");
			System.out.print("Opcao:");
			int menu=leitor.nextInt();
			switch(menu)
			{
			case 1:
				Funcionario novo_funcionario= n_Funcionario.addFuncionario(list_Funcionario);	
				if(novo_funcionario!=null)
				{
					list_Funcionario.add(novo_funcionario);
					System.out.println("Funcionario cadastrado com sucesso!");
				}
				else
					System.out.println("O funcionario nao pode ser cadastrado!!\nErro!");
				break;
			case 2:
				System.out.print("Digite a matricula do funcionario que deseja apaga:");
				int matricula=leitor.nextInt();
				Funcionario antigo_funcionario=n_Funcionario.procuraFuncionario(list_Funcionario, matricula);
				if(antigo_funcionario!=null)
				{
					list_Funcionario.remove(antigo_funcionario);
					System.out.println("Funcionario apagado com sucesso!");
				}
				else
					System.out.println("O funcionario nao foi encontrado!!\nErro!");
				break;
			case 3:
				for(Funcionario obj_funcionario : list_Funcionario)
				{
					System.out.println(obj_funcionario.toString());
				}
			case 4:
				System.out.print("Digite a matricula do funcionario que deseja atualiza:");
				int atualizaMatricula=leitor.nextInt();
				Funcionario atualizaFuncionario=n_Funcionario.procuraFuncionario(list_Funcionario, atualizaMatricula);
				Funcionario novo_Funcionario=n_Funcionario.alterarFuncionario(atualizaFuncionario);
				if(novo_Funcionario!=null)
				{
					list_Funcionario.add(novo_Funcionario);
					list_Funcionario.remove(atualizaFuncionario);
				}
			case 5:
			}
		}while(true);

	}

}
