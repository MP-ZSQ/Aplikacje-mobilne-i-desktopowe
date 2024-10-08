import java.util.ArrayList;
import java.util.List;

public class Flota {
    private List<Pojazd> pojazdy;
    public static int liczbaPojazdow = 0;

    public Flota() {
        pojazdy = new ArrayList<>();
    }

    public void dodajPojazd(Pojazd pojazd) throws NiepoprawnyPrzebiegException, IllegalArgumentException {
        if (pojazd.rokProdukcji > 2024) { // Aktualny rok to 2024
            throw new IllegalArgumentException("Rok produkcji nie może być większy niż bieżący rok.");
        }
        pojazdy.add(pojazd);
        liczbaPojazdow++;
    }

    // Przeciążona metoda dodajPojazd dla różnych zestawów parametrów
    public void dodajPojazd(String typ, String marka, String model, int rokProdukcji, int przebieg,
                            double pojemnoscSilnika) throws NiepoprawnyPrzebiegException, IllegalArgumentException {
        if (typ.equalsIgnoreCase("Samochod")) {
            Samochod samochod = new Samochod(marka, model, rokProdukcji, przebieg, pojemnoscSilnika);
            dodajPojazd(samochod);
        } else {
            throw new IllegalArgumentException("Nieznany typ pojazdu dla tej metody.");
        }
    }

    public void dodajPojazd(String typ, String marka, String model, int rokProdukcji, int przebieg,
                            String rodzajMotocykla) throws NiepoprawnyPrzebiegException, IllegalArgumentException {
        if (typ.equalsIgnoreCase("Motocykl")) {
            Motocykl motocykl = new Motocykl(marka, model, rokProdukcji, przebieg, rodzajMotocykla);
            dodajPojazd(motocykl);
        } else {
            throw new IllegalArgumentException("Nieznany typ pojazdu dla tej metody.");
        }
    }

    public void usunPojazd(Pojazd pojazd) {
        if (pojazdy.remove(pojazd)) {
            liczbaPojazdow--;
            System.out.println("Pojazd został usunięty z floty.");
        } else {
            System.out.println("Pojazd nie został znaleziony w flocie.");
        }
    }

    public void wyswietlPojazdy() {
        if (pojazdy.isEmpty()) {
            System.out.println("Flota jest pusta.");
            return;
        }
        for (Pojazd p : pojazdy) {
            System.out.println(p);
        }
    }

    public double obliczCalkowityKosztEksploatacji() {
        double suma = 0.0;
        for (Pojazd p : pojazdy) {
            suma += p.obliczKosztEksploatacji();
        }
        return suma;
    }
}
