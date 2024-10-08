public abstract class Pojazd implements Eksploatowalny {
    protected String marka;
    protected String model;
    protected int rokProdukcji;
    protected int przebieg;

    public Pojazd(String marka, String model, int rokProdukcji, int przebieg) throws NiepoprawnyPrzebiegException {
        this.marka = marka;
        this.model = model;
        this.rokProdukcji = rokProdukcji;
        setPrzebieg(przebieg);
    }

    public void setPrzebieg(int przebieg) throws NiepoprawnyPrzebiegException {
        if (przebieg < 0) {
            throw new NiepoprawnyPrzebiegException("Przebieg nie może być ujemny.");
        }
        this.przebieg = przebieg;
    }

    @Override
    public String toString() {
        return String.format("%s %s, Rok: %d, Przebieg: %d km", marka, model, rokProdukcji, przebieg);
    }
}
