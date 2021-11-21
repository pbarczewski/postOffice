# postOffice
## Table of contents
* [Informacje ogólne](#info)
* [Technologie](#technologie)
* [Uruchomienie](#uruchomienie)
* [Rest Api](#rest-api)
* [Status](#status)

## Informacje ogólne
Projekt RestAPI symulujący kolejkę na poczcie

## Technologie
Stworzony za pomocą
- Java
- Swagger
- h2 database
- Jpa
- Spring boot web

## Uruchomienie
!Projekt był pisany, uruchamiany i testowany na komputerze z systemem Windows (przeglądarki Brave, Firefox) i zainstalowanym gitem
Pierwsze co należy zrobić to pobrać projekt na dysk lokalny. W tym celuu 
1. Tworzymy w systemie folder w którym chcielibyśmy pobrać repozytorium
2. Uruchamiamy wiersz poleceń w systemie Windows 
3. W wierszu poleceń przechodzimy do katalogu który stworzyliśmy i w którym ma się znajdować repozytorium
4. Uruchamiamy polecenie: git clone https://github.com/pbarczewski/postOffice.git
5. Powinien zostać stworzony podfolder "postOffice", przechodzimy do niego w wierszu poleceń
6. Uruchamiamy polecenie: mvn spring-boot:run
7. W przeglądarce wpisujemy: http://localhost:8080/swagger-ui/
8. Projekt powinien zostać poprawnie uruchomiony i gotowy do użytkowania

## Rest Api
Za warstwę front endową aplikacji służy Swagger UI. Za jego pomocą możemy wykonywać operację na aplikacji.

## Get - pobieranie użytkowników
Pobiera listę wszystkich osób w kolejce, a po wybraniu jednego z dwóch dodatkowych parametrów otrzymujemy listę osób będących przed wybraną osobą, oraz informacje o czasie oczekiwania na obsługę. Uwaga: po uruchomieniu programu kolejka jest pusta, aby otrzymać wyniki trzeba dodać użytkowników.

## Post - tworzenie użytkownika
Osoby w kolejce posiadają trzy statusy: NORMAL, SPECIAL, oraz VIP. Status NORMAL jest przydzielany automatycznie. \
Nicki jakie nadajemy powinny być unikatowe, baza danych nie przyjmuje dwóch takich samych nicków. \
Żeby stworzyć użytkownika ze statusem NORMAL powinniśmy w Swagger UI stworzyć zapytanie POST w ponższy sposób (pole "pin" powinno zostać puste, ustawienie wartości na tym polu sprawi że użytkownik się nie utworzy):

{\
  "nick": "przykładowy_nick",\
  "pin": ""\
}

W Przypadku użytkownika unikatowego, przykładowe zapytanie POST powinno wyglądać jak poniżej, w przypadku ustawienia błędnego pinu użytkownik nie utworzy się:

{\
  "nick": "przykładowy_nick",\
  "pin": "0000"\
}

Analogicznie z użytkownikami ze statusem VIP:

{\
  "nick": "przykładowy_nick",\
  "pin": "9999"\
}

## Status
Projekt gotowy
