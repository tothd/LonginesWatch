# Longines Watch

###Futtatás:
java -jar target\longines.jar

###Funkciók
Óra megjelenítése a neve alapján: http://localhost:8888/watch/{name}

Óra keresése termékazonosító alapján: http://localhost:8888/watchSearch?sn={serialNumber}

Órák listázása keresési kulcsszó alapján: http://localhost:8888/watchList?term={term}

Órák listázása rendezve név/ár/népszerűség szerint növekvő vagy csökkenő sorrendben:
http://localhost:8888/watchList?dir={direction}&order={order}

Órák listázása megadott mennyiségben és a megadott lapon:
http://localhost:8888/watchList?limit={limit}&p={page}