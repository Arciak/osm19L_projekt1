## osm19L_projekt1

**Przedmiot:** OSM

**Projekt:** 1

**Zadanie:** 18

**Temat:** Diagnostyka ostrej bialaczki szpikowej: liczba leukocytow, liczba neutrofili, liczba erytrocytow.

**Zespol:** Agnieszka Grotek, Artur Zarzecki

**Biblioteki:** JDatePicker, Java AWT, Java Swing

**Uwagi dodatkowe:** Aplikacja sklada sie z trzech paneli: panelu pacjenta, panelu badania oraz isty pacjentow.
 Po uruchomieniu aplikacji lista jest pusta, a pola tekstowe nieaktywne. Wypelnianie listy nastepuje
wraz z dodawaniem kolejnych pacjentow.

**Panel listy:**
Nacisniecie przycisku "Dodaj" umozliwia wprowadzenie danych nowego pacjenta przelaczajac do panelu pacjenta i uaktywniajac pola tekstowe.
Wybranie elementu powoduje wyswietlenie wszystkich informacji o pacjencie w sasiednich panelach.
Wybranie elementu i nacisniecie przycisku „Usun”
powoduje usunięcie wybranego z listy pacjenta i wyczyszczenie obu formularzy.

**Panel pacjenta:**
**Wypelnienie formularza danymi i nacisniecie przycisku
„Zapisz” powoduje dodanie nowego pacjenta i wstawienie informacji o nim do listy,
Nacisniecie przycisku „Anuluj” czysci formularz.

**Panel Badania:**
Wypelnienie formularza danymi i nacisniecie przycisku „Zapisz” w panelu badania powoduje dodatnie wynikow badan do wybranego pacjenta (jezeli
nie zostały one wcześniej wprowadzone) lub modyfikację już istniejących wyników. Ponadto sygnalizowane jest wykroczenie wartosci parametrow poza zakres normy (przkroczenie normy powoduje zmiane tla pola tekstowego z bialego na czerwony).

