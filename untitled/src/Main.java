public class Main {
    public static void main(String[] args) {
        Flota flota = new Flota();

        try {
            //pojazdy które mają zostać dodane do floty
            Samochod samochod1 = new Samochod("Toyota", "Corolla", 2018, 50000, 1.8);
            Motocykl motocykl1 = new Motocykl("Yamaha", "MT-07", 2020, 15000, "Sportowy");

            //dodanie pojazdów do floty
            flota.dodajPojazd(samochod1);
            flota.dodajPojazd(motocykl1);

            //dodanie pojazdów do floty poprzez przeciążenie metody
            flota.dodajPojazd("Samochod", "Honda", "Civic", 2019, 30000, 2.0);
            flota.dodajPojazd("Motocykl", "Kawasaki", "Ninja", 2021, 8000, "Sportowy");

            //próba dodania pojazdu o roku produkcji większym niż bieżący rok
            try {
                flota.dodajPojazd("Samochod", "Ford", "Focus", 2025, 10000, 1.5);
            } catch (IllegalArgumentException e) {
                System.out.println("Błąd przy dodawaniu pojazdu: " + e.getMessage());
            }

            // Próba dodania pojazdu z ujemnym przebiegiem
            try {
                Samochod samochod2 = new Samochod("BMW", "X3", 2022, -5000, 2.5);
                flota.dodajPojazd(samochod2);
            } catch (NiepoprawnyPrzebiegException e) {
                System.out.println("Błąd przy tworzeniu pojazdu: " + e.getMessage());
            }

            // Wyświetlanie wszystkich pojazdów
            System.out.println("\nPojazdy w flocie:");
            flota.wyswietlPojazdy();

            // Obliczanie całkowitego kosztu eksploatacji
            double koszt = flota.obliczCalkowityKosztEksploatacji();
            System.out.printf("\nCałkowity koszt eksploatacji floty: %.2f PLN\n", koszt);

            // Usuwanie pojazdu
            flota.usunPojazd(samochod1);

            // Wyświetlanie pojazdów po usunięciu
            System.out.println("\nPojazdy w flocie po usunięciu:");
            flota.wyswietlPojazdy();

            // Wyświetlanie liczby pojazdów
            System.out.println("\nLiczba pojazdów w flocie: " + Flota.liczbaPojazdow);

        } catch (NiepoprawnyPrzebiegException e) {
            System.out.println("Błąd: " + e.getMessage());
        }
    }
}

