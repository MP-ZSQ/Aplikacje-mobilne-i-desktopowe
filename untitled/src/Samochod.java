public class Samochod extends Pojazd {
    private double pojemnoscSilnika;

    public Samochod(String marka, String model, int rokProdukcji, int przebieg, double pojemnoscSilnika)
            throws NiepoprawnyPrzebiegException {
        super(marka, model, rokProdukcji, przebieg);
        this.pojemnoscSilnika = pojemnoscSilnika;
    }

    @Override
    public double obliczKosztEksploatacji() {
        return przebieg * 0.5 + pojemnoscSilnika * 100;
    }

    @Override
    public String toString() {
        return "Samochod: " + super.toString() + String.format(", Pojemność silnika: %.1fL", pojemnoscSilnika);
    }
}

