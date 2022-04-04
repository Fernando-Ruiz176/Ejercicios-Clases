
public class Remuneraciones {

	public static void main(String[] args) {
		if( args.length < 6 ) {
			// si se ejecuta el program sin argumentos
			mostrarAyuda();
		} else {
			calcularRemuneraciones( args);
		}
	}

	private static void mostrarAyuda() {
		System.out.println("Remuneraciones [sueldo-base] [colacion] [movilizacion] [afp] [salud] [tipo-contrato]");
		System.out.println("Ejemplo: Remuneraciones 800000 100000 50000 habitat fonasa i");
		// i=indefinido f=plazo fijo c=trabajador casa particular
	}

	private static void calcularRemuneraciones(String[] args) {
		// todas las conversiones de tipos de datos
		int sueldoBase     = Integer.parseInt( args[0] );
		int colacion       = Integer.parseInt( args[1] );
		int movilizacion   = Integer.parseInt( args[2] );
		
		String afp         = args[3];
		String salud       = args[4];
		char tipoContrato  = (args[5].charAt(0));
		float montoUfIsapre = 2.5f;

		int montoImponible   = calcularMontoImponible(sueldoBase);
		int montoAFP         = calcularMontoAFP(montoImponible, afp);
		int montoSalud       = calcularMontoSalud(montoImponible, montoUfIsapre, salud);
		
		
		System.out.printf("Monto Imponible: $%d \n", montoImponible);
		System.out.printf("AFP: %s\n", afp);
		System.out.printf("Monto AFP: $%d \n", montoAFP);
		System.out.printf("Salud: %s \n", salud);
		System.out.printf("Monto Salud: $%d \n", montoSalud);
		System.out.printf("Monto no Imponible: $%d \n", calcularMontoNoImponible(colacion, movilizacion));
		System.out.printf("Monto seguro cesantia Trabajador: $%d \n=======================================\n", calcularSeguroCesantiaTrabajador(montoImponible, tipoContrato ));
		System.out.printf("Monto seguro cesantia Empleador: $%d \n", calcularSeguroCesantiaEmpleador(montoImponible, tipoContrato));
		
			
	}

	
	private static int calcularMontoImponible(int sueldoBase) {
		return sueldoBase;
	}

	
	private static int calcularMontoNoImponible(int colacion, int movilizacion) {
		return colacion + movilizacion;
	}

	
	private static int calcularMontoAFP(int montoImponible, String afp) {
		switch (afp) {
		
		case "capital": {
			return (int) (montoImponible * 0.1144);
		}
		
		case "cuprum": {
			return (int) (montoImponible * 0.1144);
		}
		
		case "habitat": {
			return (int) (montoImponible * 0.1127);
		}
		
		case "planvital": {
			return (int) (montoImponible * 0.1116);
		}
		
		case "provida": {
			return (int) (montoImponible * 0.1145);
		}
		
		case "modelo": {
			return (int) (montoImponible * 0.1058);
		}
		
		case "uno": {
			return (int) (montoImponible * 0.1069);
		}
		
		}
		return 0;
		
	}	
	
	private static int calcularMontoSalud (int montoImponible, float montoUfSalud, String salud) {
		float uf = 31539.20f;
		
		switch (salud ) {
		case "fonasa": {
			return (int) (montoImponible * 0.07);
		}
		
		case "colmena": {
			return (int) (montoUfSalud * uf );
		}
		
		case "consalud": {
			return (int) (montoUfSalud * uf);
		}
		
		case "cruzBlanca": {
			return (int) (montoUfSalud * uf);
		}
		
		case "masvida": {
			return (int) (montoUfSalud * uf);
		}
		
		case "vidaTres": {
			return(int) (montoUfSalud * uf);
		}
		
		case "banmedica": {
			return (int) (montoUfSalud * uf);
		}
		
		default:
		}
		return 0;
	}
	
	private static int calcularSeguroCesantiaTrabajador (int montoImponible, char tipoContrato ) {
		switch (tipoContrato) {
			case 'i' : {
				return (int) (montoImponible * 0.006);
			}
			default:
		}
				return 0;
	}
	
	private static int calcularSeguroCesantiaEmpleador (int montoImponible, char tipoContrato ) {
		switch (tipoContrato) {
			case 'i' : {
				return (int) (montoImponible * 0.024);
			}
			
			case 'f' : {
				return (int) (montoImponible * 0.03);
			}
			
			case 'c' : {
				return (int) (montoImponible * 0.03);
			}
			
			default:
		}
				return 0;
	}
	
	
	
}
