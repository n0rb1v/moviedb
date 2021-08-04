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
### Director (a Movie és a Director között kétirányu 1:n kapcsolat van)
* name - neve (Legalabb 5 karakter amiben szerepel space, nagybetűvel kezdödik)
* country - nemzetisége (nem lehet üres)
* yearOfBirth - születési év (nagyobb mint 1900)
* biography - rövid életrajz (nem lehet üres)
### Actor (a Movie és az Actor között n:m kapcsolat van)
* name - neve (Legalabb 5 karakter amiben szerepel space, nagybetűvel kezdödik)
* country - nemzetisége (nem lehet üres)
* yearOfBirth - születési év (nagyobb mint 1900)
* biography - rövid életrajz (nem lehet üres)

## Végpontok
| Http metódus | Vég pont                 | Leírás                                        |
| ------------ | ------------------------ | --------------------------------------------- |
| POST         | api/movies               | létrehoz egy filmet                           |
| GET          | api/movies               | lekérdezi az összes filmet, vagy keres köztük |
| PUT          | api/movies/{id}          | updateli a film adatait                       |
| POST         | api/movies/{id}/rate     | értékeli a filmet                             |
| POST         | api/movies/{id}/genre    | hozzáad egy műfajt(ENUM) a filmhez            |
| POST         | api/movies/{id}/director | hozzáad egy rendezõt a filmhez                |
| POST         | api/movies/{id}/actor    | hozzáad egy színészt a filmhez                |
| DELETE       | api/movies               | törli az összes filmet                        |
| DELETE       | api/movies/{id}          | törli a filmet id alapján                     |

| Http metódus | Vég pont                 | Leírás                                        |
| ------------ | ------------------------ | --------------------------------------------- |
| GET          | api/actors               | lekéri az összes színészt, vagy keres köztük  |
| GET          | api/actors/{id}          | lekéri a színészt id alapján                  |
| PUT          | api/actors/{id}          | updateli a színész adatait                    |



