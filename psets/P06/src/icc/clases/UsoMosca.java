package icc.clases;

public class UsoMosca {

    public static void main(String[] args) {
        // La canción original le pertenece a la clase.
        System.out.println("Letra original:");
        System.out.println(Mosca.original);

        // Creemos una mosca, con la vocal por defecto y agámosla cantar.
        Mosca moscaA = new Mosca();
        String cantoA = moscaA.canta();
        System.out.println("\nLa mosca A canta:");
        System.out.println(cantoA);

        // Creemos otra mosca, que cante con la 'e'.
        Mosca mosca2 = new Mosca();
        mosca2.setVocal('e');
        System.out.println("\nLa mosca 2 canta:");
        System.out.println(mosca2.canta());

        // Agamos cantar otra vez a la primera mosca:
        System.out.println("\nLa mosca A canta otra vez:");
        System.out.println(moscaA.canta());

        // Cambiemos otra vez la letra de la segunda mosca:
        System.out.println("\nLa mosca 2 cambia de letra:");
        mosca2.setVocal('u');
        System.out.println(mosca2.canta());
    }

}
