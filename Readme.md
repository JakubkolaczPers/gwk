Aplikacja gra w kości

Wzorzec projektowy: MVC

Flow aplikacji -> Rejestracja Użytkownika -> Podanie Danych -> Rozpoczęcie gry

Testy:
 Jednostkowe w Junit i z użyciem frameworka mockito
Otestowany - UserService i GameService 

Testy MoneyService i SessionService nie mają sensu oraz wymagają testów integracyjnych

Frontend - zrobony przy pomocy frameworka thymeleaf, podstawowy wystarczajacy do obsłużenia
Zalecane środowisko użycia - postman

Obiekty bazodanowe:
 - Game, Session i User

Repozytoria z wykorzystaniem JPA - Game, Session i User
Baza danych - H2 - adres - localhost:9092

Parametry startowe - brak