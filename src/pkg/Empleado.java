package pkg;

public class Empleado {	
	
	public enum TipoEmpleado{Vendedor, Encargado, Otro};
	
	public static float calculoNominaBruta(TipoEmpleado tipoEmpleado, float ventasMes, float horasExtra) {
		float salarioBase = 0, primas = 0, extras = 0;
		
		//Compruebo el Tipo de Empleado
		if(tipoEmpleado == TipoEmpleado.Vendedor) {
			salarioBase = 2000;
		}else if(tipoEmpleado == TipoEmpleado.Encargado) {
			salarioBase = 2500;
		}else {
			return -1;
		}
		
		//Compruebo y devuelvo el Salario de Nomina Bruta
		if(ventasMes>=1500) {
				primas = 200;
		}else if(ventasMes>=1000){
				primas = 100;
		}else if(ventasMes<0) {
			return -1;
		}
		
		//Asigno las horas extras
		if(horasExtra>=0) {
			extras = 30*horasExtra;	
		}else {
			return -1;
		}
		
		return salarioBase + primas + extras;
		
	}
	
	public static float calculoNominaNeta(float nominaBruta) {
		float retencion = 0;
		
		if(nominaBruta>2500) {
			retencion=0.18f;
		}else if(nominaBruta>2100) {
			retencion = 0.15f;
		}else if(nominaBruta<0) {
			return -1;
		}
		return nominaBruta*(1-retencion);
	}
}
