# Vizsgaremek - Moviedb (movie database)

## Leírás
Film adatbázis, az adatok felvitelét és lekérdezését teszi lehetővé.

## Entitások

### Movie
* title - film cím (nem lehet üres)
* description - film rövid tartalma (nem lehet üres)
* country - származási ország (nem lehet üres)
* release date - megjeleneési dátum (nem lehet null)
* length - hossza percben (pozitív)
* genre(s) - film műfaja (nem lehet null)
* rate - értékelés (1 és 5 között lehet)
* director(s) - rendező 
* actors - színészek
### Director
* name - neve (Legalabb 5 karakter amiben szerepel space, nagybetűvel kezdödik)
* country - nemzetisége (nem lehet üres)
* yearOfBirth - születési év (nagyobb mint 1900)
* biography - rövid életrajz (nem lehet üres)
### Actor
* name - neve (Legalabb 5 karakter amiben szerepel space, nagybetűvel kezdödik)
* country - nemzetisége (nem lehet üres)
* yearOfBirth - születési év (nagyobb mint 1900)
* biography - rövid életrajz (nem lehet üres)
