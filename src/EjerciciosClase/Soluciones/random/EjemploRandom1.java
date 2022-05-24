package EjerciciosClase.Soluciones.random;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class EjemploRandom1 {
    static Scanner sc = new Scanner(System.in);
    static RandomAccessFile fichero = null;

    public static void main(String[] args) {
        int numero;
        try {
            //se abre el fichero para lectura y escritura
            fichero = new RandomAccessFile("ficheros/enteros.dat", "rw");
            mostrarFichero(); //muestra el contenido original del fichero
            System.out.print("Introduce un número entero para añadir al final del fichero: ");
            numero = sc.nextInt(); //se lee el entero a añadir en el fichero por teclado
            //nos situamos al final del fichero
            fichero.seek(fichero.length());
            fichero.writeInt(numero); //se escribe el entero
            mostrarFichero();//muestra el contenido del fichero después de añadir el número
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (fichero != null) {
                    fichero.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public static void mostrarFichero() {
        int n;
        try {
            //nos situamos al principio
            fichero.seek(0);
            while (true) {
                n = fichero.readInt(); //se lee un entero del fichero
                System.out.println(n); //se muestra en pantalla
            }
        } catch (EOFException e) {
            System.out.println("Fin de fichero");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
