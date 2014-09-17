package negocio;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import objeto.*;

public class FolhaPagamento {
	
	private Date data;
	private SimpleDateFormat format;
	public GregorianCalendar gegorianCal;
	
	public FolhaPagamento(int dia, int mes, int ano)
	{
		this.gegorianCal=new GregorianCalendar();
		this.gegorianCal.set(this.gegorianCal.DATE, dia);
		this.gegorianCal.set(this.gegorianCal.MONTH, mes);
		this.gegorianCal.set(this.gegorianCal.YEAR, ano);
	}
	public ArrayList<Funcionario> baterPonto(ArrayList<Funcionario> list_funcionario)
	{
		this.gegorianCal.add(this.gegorianCal.DATE, 1);
		for(Funcionario obj_funcionario : list_funcionario)
		{
			if(obj_funcionario instanceof Comissionado)
			{
				if(this.gegorianCal.get(this.gegorianCal.DAY_OF_WEEK)==this.gegorianCal.FRIDAY)
				{
					if(((Comissionado) obj_funcionario).isPagamento())
					{
						((Comissionado) obj_funcionario).setPagamento(false);
					}
					else
						((Comissionado) obj_funcionario).setPagamento(true);
				}
			}
		}
		return list_funcionario;
	}
	
	public String getDate()
	{
		String data = this.gegorianCal.get(this.gegorianCal.DATE)+"/"+(this.gegorianCal.get(this.gegorianCal.MONTH)+1)+"/"+this.gegorianCal.get(this.gegorianCal.YEAR);
		if(this.gegorianCal.get(this.gegorianCal.DAY_OF_WEEK)==this.gegorianCal.SUNDAY)
		{
			data=data.concat("(Domingo)");
		}
		if(this.gegorianCal.get(this.gegorianCal.DAY_OF_WEEK)==this.gegorianCal.MONDAY)
		{
			data=data.concat("(Segunda)");
		}
		if(this.gegorianCal.get(this.gegorianCal.DAY_OF_WEEK)==this.gegorianCal.TUESDAY)
		{
			data=data.concat("(Terca)");
		}
		if(this.gegorianCal.get(this.gegorianCal.DAY_OF_WEEK)==this.gegorianCal.WEDNESDAY)
		{
			data=data.concat("(Quarta)");
		}
		if(this.gegorianCal.get(this.gegorianCal.DAY_OF_WEEK)==this.gegorianCal.THURSDAY)
		{
			data=data.concat("(Quinta)");
		}
		if(this.gegorianCal.get(this.gegorianCal.DAY_OF_WEEK)==this.gegorianCal.FRIDAY)
		{
			data=data.concat("(Sexta)");
		}
		if(this.gegorianCal.get(this.gegorianCal.DAY_OF_WEEK)==this.gegorianCal.SATURDAY)
		{
			data=data.concat("(Sabado)");
		}
		return data;
	}
	
	public String geraPagamento(ArrayList<Funcionario> list_funcionario)
	{
		String pagamento="\n";
		for(Funcionario obj_funcionario : list_funcionario)
		{
			if(obj_funcionario instanceof Assalariado && ! (obj_funcionario instanceof Comissionado))
			{
				if(this.gegorianCal.get(this.gegorianCal.DATE)==this.gegorianCal.getMaximum(this.gegorianCal.DATE))
				{
					pagamento=pagamento.concat("\n\n"+obj_funcionario.pagamento());
					obj_funcionario.list_pagamento.clear();
				}
			}
			if(obj_funcionario instanceof Horista)
			{
				if(this.gegorianCal.get(this.gegorianCal.DAY_OF_WEEK)==this.gegorianCal.FRIDAY)
				{
					pagamento=pagamento.concat("\n\n"+obj_funcionario.pagamento());
					obj_funcionario.list_cartao.clear();
				}
			}
			if(obj_funcionario instanceof Comissionado)
			{
				if(this.gegorianCal.get(this.gegorianCal.DAY_OF_WEEK)==this.gegorianCal.FRIDAY)
				{
					if(((Comissionado) obj_funcionario).isPagamento())
					{
						pagamento=pagamento.concat("\n\n"+obj_funcionario.pagamento());
						obj_funcionario.list_venda.clear();
					}
				}
			}
		}
		return pagamento;
	}

}
