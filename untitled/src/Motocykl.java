public class Motocykl extends Pojazd {
    private String rodzajMotocykla;

    public Motocykl(String marka, String model, int rokProdukcji, int przebieg, String rodzajMotocykla)
            throws NiepoprawnyPrzebiegException {
        super(marka, model, rokProdukcji, przebieg);
        this.rodzajMotocykla = rodzajMotocykla;
    }

    @Override
    public double obliczKosztEksploatacji() {
        double bazowyKoszt = przebieg * 0.3;
        if (rodzajMotocykla.equalsIgnoreCase("Sportowy")) {
            bazowyKoszt += 200;
        } else if (rodzajMotocykla.equalsIgnoreCase("Turystyczny")) {
            bazowyKoszt += 150;
        } else {
            bazowyKoszt += 100;
        }
        return bazowyKoszt;
    }

    @Override
    public String toString() {
        return "Motocykl: " + super.toString() + ", Rodzaj: " + rodzajMotocykla;
    }
}

