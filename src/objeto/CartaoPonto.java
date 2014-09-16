package objeto;

import java.util.Date;
import java.util.GregorianCalendar;
import java.text.*;

public class CartaoPonto 
{
	private Date data;
	private SimpleDateFormat format;
	GregorianCalendar gegorianCal;
	GregorianCalendar horaInicial;
	GregorianCalendar horaFinal;
	
	public CartaoPonto(int horaInicial, int minutoInicial, int horaFinal, int minutoFinal)
	{
		this.format=new SimpleDateFormat("dd/MM/yyyy");
		this.data=new Date();
		this.gegorianCal=new GregorianCalendar();
		this.gegorianCal.set(2014, 9, 01);
		this.horaInicial=new GregorianCalendar();
		this.horaFinal=new GregorianCalendar();
		this.horaInicial.add(this.horaInicial.HOUR, horaInicial);
		this.horaInicial.add(this.horaInicial.MINUTE, minutoInicial);
		this.horaFinal.add(this.horaFinal.HOUR, horaFinal);
		this.horaFinal.add(this.horaFinal.MINUTE, minutoFinal);
	}
	
	

}
