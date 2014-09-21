
import objeto.*;
import negocio.*;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leitor = new Scanner(System.in);
		ArrayList<Funcionario> list_Funcionario=new ArrayList<Funcionario>();
		N_Funcionario n_Funcionario=new N_Funcionario();
		FolhaPagamento folhaPagamento=new FolhaPagamento(21, 11, 2014);
		list_Funcionario.add(new Comissionado("pedro", "travessa", 0, false, 0, 1000, (float) 0.2));
		list_Funcionario.add(new Assalariado("rafael", "santo", 1, false, 1, 2000));
		list_Funcionario.add(new Horista("joao","antonio", 2, false, 2, 10));
		Stack<ArrayList<Funcionario>> redo = new Stack<ArrayList<Funcionario>>();
		Stack<ArrayList<Funcionario>> undo = new Stack<ArrayList<Funcionario>>();
		int menu=0;
		boolean aux = false;
		boolean aux2 = false;
		do
		{
			System.out.println("---Menu-----    Data:"+folhaPagamento.getDate()+"\n");
			System.out.println("[1]-Inserir funcionario");
			System.out.println("[2]-Remover funcionario");
			System.out.println("[3]-Mostrar Funcionario");
			System.out.println("[4]-Alterar Dados");
			System.out.println("[5]-Lanca venda");
			System.out.println("[6]-Contra Cheque");
			System.out.println("[7]-Cobra taxas sindicais");
			System.out.println("[8]-Bate ponto");
			System.out.println("[9]-Folha de pagamento do dia");
			System.out.println("[10]-Refazer operacao");
			System.out.println("[11]-Fazer operacao");
			System.out.print("Opcao:");
			menu=leitor.nextInt();
			switch(menu)
			{
			case 1:
				Funcionario novo_funcionario= n_Funcionario.addFuncionario(list_Funcionario);
/*				if( novo_funcionario instanceof Assalariado && !(novo_funcionario instanceof Comissionado))
					undo.add(new Assalariado( novo_funcionario));
				if( novo_funcionario instanceof Horista)
					undo.add(new Horista( novo_funcionario));
				if( novo_funcionario instanceof Comissionado )
					undo.add(new Comissionado( novo_funcionario));*/
				if(novo_funcionario!=null)
				{
					undo.push(new ArrayList<Funcionario>(list_Funcionario));
					list_Funcionario.add(novo_funcionario);
					System.out.println("Funcionario cadastrado com sucesso!");
					aux=true;
					aux2=false;
				}
				else
					System.out.println("O funcionario nao pode ser cadastrado!!\nErro!");
				break;
			case 2:
				System.out.print("Digite a matricula do funcionario que deseja apaga:");
				int matricula=leitor.nextInt();
				Funcionario antigo_funcionario=n_Funcionario.procuraFuncionario(list_Funcionario, matricula);
/*				if( antigo_funcionario instanceof Assalariado && !(antigo_funcionario instanceof Comissionado))
					undo.add(new Assalariado(antigo_funcionario));
				if( antigo_funcionario instanceof Horista)
					undo.add(new Horista(antigo_funcionario));
				if( antigo_funcionario instanceof Comissionado )
					undo.add(new Comissionado(antigo_funcionario));*/
				if(antigo_funcionario!=null)
				{
					undo.push(new ArrayList<Funcionario>(list_Funcionario));
					list_Funcionario.remove(antigo_funcionario);
					System.out.println("Funcionario apagado com sucesso!");
					aux=false;
					aux2=true;
				}
				else
					System.out.println("O funcionario nao foi encontrado!!\nErro!");
				break;
				
			case 3:
				for(Funcionario obj_funcionario : list_Funcionario)
				{
					if(obj_funcionario!=null)
						System.out.println(obj_funcionario.toString());
				}
				break;
			case 4:
				System.out.print("Digite a matricula do funcionario que deseja atualiza:");
				int atualizaMatricula=leitor.nextInt();
				Funcionario atualizaFuncionario=n_Funcionario.procuraFuncionario(list_Funcionario, atualizaMatricula);
				if(atualizaFuncionario!=null)
				{
					undo.push(new ArrayList<Funcionario>(list_Funcionario));
					Funcionario novo_Funcionario=n_Funcionario.alterarFuncionario(list_Funcionario, atualizaFuncionario);
					if(novo_Funcionario!=null)
					{
						list_Funcionario.remove(atualizaFuncionario);
						list_Funcionario.add(novo_Funcionario);
						aux=false;
						aux2=false;
					}
					else
						System.out.println("O funcionario nao foi encontrado!!\nErro!");
				}
				else
					System.out.println("O funcionario nao foi encontrado!!\nErro!");
				break;
			case 5:
				System.out.println("Digite o id do funcionario:");
				int id=leitor.nextInt();
				Funcionario obj_VendedorAntigo=n_Funcionario.procuraFuncionario(list_Funcionario, id);
				if(obj_VendedorAntigo!=null)
				{
					undo.push(new ArrayList<Funcionario>(list_Funcionario));
					Funcionario obj_Vendedor = n_Funcionario.addVenda(obj_VendedorAntigo, folhaPagamento.getDate());
					if(obj_Vendedor!=null)
					{
						list_Funcionario.add(obj_Vendedor);
						list_Funcionario.remove(obj_VendedorAntigo);
						aux=false;
						aux2=false;
					}
				}
				break;
			case 6:
				System.out.println("Digite o id do funcionario:");
				int identificador=leitor.nextInt();
				Funcionario obj_VendedorPago=n_Funcionario.procuraFuncionario(list_Funcionario, identificador);
				System.out.println(obj_VendedorPago.pagamento());
				break;
			case 7:
				System.out.println("Digite o id do funcionario:");
				int identificado=leitor.nextInt();
				Funcionario obj_funcionarioSindicato=n_Funcionario.procuraFuncionario(list_Funcionario, identificado);
				if(obj_funcionarioSindicato!=null)
				{
					Funcionario obj_funFuncionarioSindicatonovo=n_Funcionario.addTaxa(obj_funcionarioSindicato);
					if(obj_funFuncionarioSindicatonovo!=null)
					{

						undo.push(new ArrayList<Funcionario>(list_Funcionario));
						list_Funcionario.add(obj_funFuncionarioSindicatonovo);
						list_Funcionario.remove(obj_funcionarioSindicato);
						aux=false;
						aux2=false;
					}
					else
						System.out.println("O funcionario nao foi encontrado!!\nErro!");
				}
				else
					System.out.println("O funcionario nao foi encontrado!!\nErro!");
				break;
			case 8:
				System.out.println("Digite o id do funcionario:");
				int ident=leitor.nextInt();
				Funcionario obj_funcionarioPonto=n_Funcionario.procuraFuncionario(list_Funcionario, ident);
				if(obj_funcionarioPonto!=null)
				{
					Funcionario obj_funcionarioPontoNovo=n_Funcionario.addPonto(obj_funcionarioPonto, folhaPagamento.getDate());
					if(obj_funcionarioPontoNovo!=null)
					{
						undo.push(new ArrayList<Funcionario>(list_Funcionario));
						list_Funcionario.add(obj_funcionarioPontoNovo);
						list_Funcionario.remove(obj_funcionarioPonto);
						aux=false;
						aux2=false;
					}
					else
						System.out.println("O funcionario nao foi encontrado!!\nErro!");
				}
				else
					System.out.println("O funcionario nao foi encontrado!!\nErro!");
				break;
			case 9:
				undo.push(new ArrayList<Funcionario>(list_Funcionario));
				System.out.println(folhaPagamento.geraPagamento(list_Funcionario));
				list_Funcionario = new ArrayList<Funcionario>(folhaPagamento.limpaBoleto(list_Funcionario));
				list_Funcionario = new ArrayList<Funcionario>(folhaPagamento.baterPonto(list_Funcionario));
				break;		
			case 10:
				redo.push(new ArrayList<Funcionario>(list_Funcionario));
				list_Funcionario=new ArrayList<Funcionario>(undo.pop());
				break;
			case 11:
				undo.push(new ArrayList<Funcionario>(list_Funcionario));
				list_Funcionario=new ArrayList<Funcionario>(redo.pop());
				break;
			}
		}while(true);

	}

}
