package arraysejer4;

import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedList;

/**
 *
 * @author Luis
 */
public class ArraysEjer4 {

    public static void main(String[] args) {

        Cliente juan = new Cliente("Juan", "Lucero", "Merlo", LocalDate.of(1978, 10, 27));
        Cuenta cuenta = new Cuenta();
        cuenta.setNumero(1234);
        cuenta.setTitular(juan);
        cuenta.setMovimientos(new LinkedList<>());

        System.out.println("Depositando 60000");
        cuenta.depositar(60000);

        System.out.println("ver saldo: " + cuenta.getSaldo());

        System.out.println("Extrayendo 10000");
        cuenta.extraer(10000);

        double saldoActual = cuenta.verSaldo();

        System.out.println("ver saldo " + saldoActual);
        
       cuenta.listarMovimientos();
       
        System.out.println("LUIIIISSS AAAAAA");
        
    }

}


