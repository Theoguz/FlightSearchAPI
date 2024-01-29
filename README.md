# Flight Search API

Flight Search API for Amadeus

## Proje Bağımlılıkları
- Spring Boot
- Spring Boot Starter Web
- Spring Data JPA
- Maven
- H2 Database
- Swagger UI http://localhost:8080/swagger-ui/index.html#/
- Lombok


## API Kullanımı

#### Flight-controller

#### ID'ye Göre Uçuşları Getirir

```http
  GET /api/flight/{id}
   
```

#### Bütün Uçuşları Getirir

```http
  GET /api/flight/all
   
```

#### ID'ye Göre Uçuşları Siler

```http
  DELETE /api/flight/delete/{id}
   
```

#### ID'ye Göre Uçuşları Değiştirir

```http
  PUT /api/flight/update/{id}
  
```

#### Uçuş Ekler

```http
  POST /api/flight/create
  
```

#### Airport-controller

#### ID'ye Göre Airport Getirir

```http
  GET /api/airport/{id}
   
```

#### Bütün Airportları Getirir

```http
  GET  /api/airport/all
   
```

#### ID'ye Göre Airport Siler

```http
  DELETE /api/airport/delete/{id}
   
```

#### ID'ye Göre Airport Değiştirir

```http
  PUT /api/airport/update/{id}
  
```

#### User-Controller

#### ID'ye Göre User Getirir

```http
  GET /api/user/{id}
   
```

#### Bütün Userları Getirir

```http
  GET  /api/user/all
   
```

#### ID'ye Göre User Siler

```http
  DELETE /api/user/delete/{id}
   
```

#### User Ekler

```http
  POST /api/user/create
  
```
## Ekran Görüntüleri

![Ekran görüntüsü 2024-01-28 212300](https://github.com/Theoguz/FlightSearchAPI/assets/73759725/b314be26-607e-428d-9938-e05fc473e8cb)
![Ekran görüntüsü 2024-01-28 212246](https://github.com/Theoguz/FlightSearchAPI/assets/73759725/20719541-af3f-49d2-9611-b9ae8dcf8c8a)
![Ekran görüntüsü 2024-01-28 212226](https://github.com/Theoguz/FlightSearchAPI/assets/73759725/783d5265-5e12-44fc-bc17-33b71866a539)
![Ekran görüntüsü 2024-01-28 212327](https://github.com/Theoguz/FlightSearchAPI/assets/73759725/04e0ec5a-9767-4eeb-a9ae-45007b8f841c)
