package nl.han.bewd.lambdas.reis;

public class ScooterVervoerStrategy implements VervoerStrategy {
    private static final int MAX_SNEIDING = 50;

    @Override
    public int berekenReistijd(boolean isSpits) {
        int snelheid = getSnelheid();
        if (snelheid <= MAX_SNEIDING) {
            return 15; // Reistijd is 15 minuten als de snelheid maximaal 50 is
        } else {
            return 30; // Reistijd is 30 minuten als de snelheid hoger is dan 50
        }
    }


    private int getSnelheid() {
        return new java.util.Random().nextInt(100); // Simuleer een snelheid tussen 0 en 99
    }
}
