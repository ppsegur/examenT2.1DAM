package ejercicio1;

import java.util.Random;

import utilidades.Leer;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Bienvenida
		System.out.println("Bienvenido a Programadores Reunidos Independientes Nacionales y Territoriales ");
		
		//Declaración de variables
		int desde = 0, hasta = 0,suma =0,opcion = 0, tam=8,votosPartido,provinciaMenos = 0,indiceProvincia, votosASumar,indiceMaxVotos = 0,maxVotos, cien=100;
		double porcentaje,media=0;
		
		//Declaración de arrays
        int [] votos = new int[tam];
        String[] nombres = {"Sevilla","Granada", "Almería","Córdoba", "Málaga" ,"Cádiz","Jaen","Huelva" };

        //RANDOMS
        Random random = new Random();
     
        // Declaración del array pidiendo desde y hasta(Lectura por teclado)
        System.out.print("Introduce desde que valor empieza el array: ");
        desde = Leer.datoInt();
        System.out.print("Introduce hasta que valor llega el array: ");
        hasta = Leer.datoInt();
        
        for (int i = 0; i < votos.length; i++) {
          votos  [i] = random.nextInt(hasta-desde+1)+desde;
        }
        
        System.out.println("El total de votos por cada provincia es: ");
 
        //Impresión de los  arrays por consola
        for (int i = 0; i < nombres.length; i++) {
            System.out.print(nombres[i] + "\t\t"); 
        }

        System.out.println("\n");

        for (int i = 0; i < votos.length; i++) {
            System.out.print(votos[i] + "\t\t"); 
        }
        //Numero de votos 
        for (int i = 0; i < votos.length; i++) {
        	suma+=votos[i];
		}
    	System.out.println("\nEl número total de votos será de: "+suma+" votos");
    	
    	
    	//Bucle do-while con menú
    	do {
    	System.out.println(" ");
    	System.out.println("Ahora podrá hacer las siguientes operaciones:");
    	System.out.println("_________________________________________________________________________________");
    	System.out.println("Pulse 1 si desea ver el número de provincias que no han superado los 1000 votos ");
    	System.out.println("----------------------------------------------------------------------------------");
    	System.out.println("Pulse 2 si desea ver el porcentaje de votos que ha tenido su partido en Andalucía ");
    	System.out.println("----------------------------------------------------------------------------------");
    	System.out.println("Pulse 3 si desea sumar un número de votos a una provincia ");
    	System.out.println("----------------------------------------------------------------------------------");
    	System.out.println("Pulse 4 si desea calcular la media de votos de la comunidad autónoma");
    	System.out.println("----------------------------------------------------------------------------------");
    	System.out.println("Pulse 5 si desea ver la provincia que mas votos a recibido  ");
    	System.out.println("----------------------------------------------------------------------------------");
    	System.out.println("Pulse 0 para salir");
       	System.out.println("_________________________________________________________________________________");
    	opcion = Leer.datoInt();
    	
    	//SWITCH
		switch (opcion) {

		case 1: //Nº provincias que no superan los 1000 votos
            
            for (int i = 0; i < votos.length; i++) {
                if (votos[i] < 1000) {
                    provinciaMenos++;
                }
            }
            System.out.println("El número de provincias que no han superado los 1000 votos es: " + provinciaMenos);
            break;
            
        case 2: //porcentaje de votos que ha tenido su partido 
            System.out.print("Ingrese el número de votos de su partido en Andalucía: ");
            votosPartido = Leer.datoInt();
            porcentaje = ((double) votosPartido / suma) * cien; //Cálculo del pporcentaje de votos
            System.out.printf("Su partido ha obtenido el %.2f por ciento de los votos en Andalucía.",porcentaje);
            break;
            
        case 3: //Sumar un nº de votos a una provincia
            System.out.print("Ingrese el índice de la provincia (0-7) a la que desea sumar votos: ");
            indiceProvincia = Leer.datoInt();
            System.out.print("Ingrese la cantidad de votos a sumar: ");
            votosASumar = Leer.datoInt();

            // Verificar si el índice es válido
            if (indiceProvincia >= 0 && indiceProvincia < tam) {
                votos[indiceProvincia] += votosASumar;
                System.out.println("Se han sumado " + votosASumar + " votos a la provincia " + nombres[indiceProvincia]);
            } else {
                System.out.println("El índice de provincia ingresado no es válido.");
            }
            break;
        case 4 : //Media de votos de la comunidad autónoma
        	for (int i = 0; i < votos.length; i++) {
        		media=votos[i]/nombres.length;
			}
        System.out.printf("La media de  votos por cada provincia es de %.2f ",media);
        	break;
        case 5: //Provincia que mas votos obtuvo
             maxVotos = votos[0];
            for (int i = 1; i < votos.length; i++) {
                if (votos[i] > maxVotos) {
                    maxVotos = votos[i];
                    indiceMaxVotos = i;
                }
            }
            System.out.println("La provincia con más votos es " + nombres[indiceMaxVotos] + " con " + maxVotos + " votos.");
            break;

        case 0:
            System.out.println("Adios");
            break;

        default:
            System.out.println("Opción no válida. Por favor, elija una opción válida.");
            break;
    }

    	
	}while(opcion !=0); {
		
	}
	System.out.println("Gracias por usar el programa ");
}
	}
