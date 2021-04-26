import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Persona p1 = new Persona(0,"Franco ", 172, 75, true);
        Persona p2 = new Persona(1,"Antonio ", 122, 84, false);
        Persona p3 = new Persona(p1);

        System.out.println("Persona 1: "+p1.toString());
        System.out.println("Persona 2: "+p2.toString()+"\n");

        //Gestionepersone
        System.out.println("Gestione Persone: ");
        GestionePersone g1 = new GestionePersone(10);
        g1.addPersona(p1);
        g1.addPersona(p2);
        g1.addPersona(p3);
        System.out.println(g1.toString());
        
        g1.delete("Franco");


        String pal = "anna";
        System.out.println(g1.toString());
        System.out.println(p1.palindroma(pal));
        System.out.println(p1.palindromaric(pal));
    }
}