package nl.han.bewd.lambdas;

import nl.han.bewd.lambdas.reis.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Buiten spits met fiets");
        Reis mijnReis = new Reis(false);
        VervoerStrategy fietsVervoer = isSpits -> 10; // Fiets duurt altijd 10 minuten
        mijnReis.simuleerReis(fietsVervoer);

        System.out.println("Tijdens de spits");
        mijnReis.setSpits(true);
        mijnReis.simuleerReis(fietsVervoer);                   // Met fiets
        mijnReis.simuleerReis(isSpits -> 20);                  // Auto, met spits 20 minuten
        mijnReis.simuleerReis(isSpits -> 15);                  // OV, met spits 15 minuten

        System.out.println("Met scooter via lambda:");
        VervoerStrategy scooterVervoer = isSpits -> {
            int snelheid = new java.util.Random().nextInt(100); // Random snelheid tussen 0 en 99
            return snelheid <= 50 ? 15 : 30; // Reistijd afhankelijk van de snelheid
        };

        mijnReis.simuleerReis(scooterVervoer); // Met scooter via lambda


}






// public class Main {
//     /*
//     Een Reis wordt gemaakt met een enkel vervoermiddel. De reistijd kan door middel van een simulatie van de
//     reis worden berekend. Hierbij kan onderscheid gemaakt worden of de reis tijdens de spits of buiten de spits is.
//      */
//     public static void main(String[] args) {
//         System.out.println("Buiten spits met fiets");
//         Reis mijnReis = new Reis(false);
//         VervoerStrategy vervoer = new FietsVervoerStrategy();
//         mijnReis.simuleerReis(vervoer);

//         System.out.println("Tijdens de spits");
//         mijnReis.setSpits(true);
//         mijnReis.simuleerReis(vervoer);                   // Met fiets
//         mijnReis.simuleerReis(new AutoVervoerStrategy()); // Met auto
//         mijnReis.simuleerReis(new OVVervoerStrategy());   // Met OV
//         mijnReis.simuleerReis(new ScooterVervoerStrategy()); // Met scooter


//         System.out.println("Met <nieuw> vervoer (Stap 2)  ");
//         System.out.println("TODO:");

//         System.out.println("Met <nieuw> vervoer, lambda edition! (Stap 5)");
//         System.out.println("TODO:");
//     }
// }