package arraysejer4;

import java.time.LocalDate;
import java.util.LinkedList;

public class Cuenta {

    private long numero;

    private double saldo;

    private Cliente titular;
    
    private double interesAnual;

    private LinkedList<Movimiento> movimientos;

    public Cuenta() {
    }

    public Cuenta(long numero, double saldo, Cliente titular, LinkedList<Movimiento> movimientos) {
        this.numero = numero;
        this.saldo = saldo;
        this.titular = titular;
        this.movimientos = movimientos;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public LinkedList<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(LinkedList<Movimiento> movimientos) {
        this.movimientos = new LinkedList<>();
    }

    // depositar(cantidad)  Recibe la cantidad de dinero que incrementará el saldo de la
    //cuenta y registra el movimiento “D”(Depósito)
    public void depositar(double cantidad) {
        saldo += cantidad;
                
        Movimiento movimiento = new Movimiento();
        movimiento.setFecha(LocalDate.now());
        movimiento.setTipo('D');
        movimiento.setImporte(cantidad);
        movimiento.setSaldo(saldo);
        movimientos.add(movimiento);
    }
//    extraer(cantidad)  Recibe la cantidad de dinero a extraer que disminuirá el siento “E” (Extracción). Ojo!!! Solo extraerá dinero si hay saldo
//    suficiente.

    public void extraer(double cantidad) {
        if (saldo >= cantidad) {
            saldo -= cantidad;
            Movimiento mov = new Movimiento();
            mov.setFecha(LocalDate.now());
            mov.setImporte(cantidad);
            mov.setTipo('E');
            mov.setSaldo(saldo);
            movimientos.add(mov);
        } else {
            System.out.println("Saldo Insuficiente para extraccion");
        }

    }
    // cambiarInteresAnual(valor) Establecerá el nuevo interés anual de la cuenta.
    public void cambiarInteresesAnual(double valor) {
        interesAnual = valor;
    }
    // verTitular():ClienteRetornará el Cliente titular de la cuenta
    public Cliente verTitular() {
        return titular;
    }
    // verSaldo():doubleRetornará el saldo actual de la cuenta.
    public double verSaldo() {
        return saldo;
    }
    // listarMovimientos():voidMostrará por consola todos lo movimientos en el orden en el
    //que fueron ejecutados.
    public void listarMovimientos() {
        for (Movimiento movimiento : movimientos) {
            
            System.out.println(movimiento.getFecha());
            System.out.println(movimiento.getTipo());
            System.out.println(movimiento.getImporte());
            System.out.println(movimiento.getSaldo());
            System.out.println("--------------------------");
        }
    }
}
