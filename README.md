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

** Uwagi prowadz�cego **

1. Panel pacjenta nie powinien by� dost�pny, dop�ki nie klikn� na Dodaj
2. PESEL nie jest sprawdzany na zgodno�� z sum� kontroln�
3. W koluimnie Badanie pojawia si� napis javax.swing.JCheckbox[...
4. Na moim ekranie panel Badanie jest uci�ty, musz� zmieni� rozmiar okienka. Nale�a�o sprawdzi� program na r�nych monitorach
5. Pola w badaniu zaznaczaj� si� na czerwono, ale nie ma informacji, jakie s� prawid�owe warto�ci
6. Brak informacji o podziale pracy w zespole
7. Projekt rozwijany po czasie (15 kwietnia)

20/30