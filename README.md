# TP-Poo-Api-OutillageNicolasPoupon

LIEN GITHUB : https://github.com/Rednels-21/TP-Poo-Api-OutillageNicolasPoupon

PARTIE 1 :
Dépendances :
  - Spring Web : Dépendance pour créer des applciations web MVC.
  - Spring Data JPA : Dépendance pour faire des requêtes SQL en lien avec des bases de données.
  - H2 Database : Dépendance pour créer des bases de données SQL.
  - Spring boot DevTools : Fournit des configurations et des outils pour développer plus facilement.
  - Thymeleaf : Template web pour manipuler facilement HTML et faire des afficahges propres sur navigateur.
  
Etape 13 :
  - L'URL d'appel est paramétré dans le controller avec le code suivant : "@GetMapping("/greeting")".
  - Le fichier HTML est paramétré dans le controller avec : "return "greeting";".
  - Nous envoyons le nom dans le second lien avec le paramètre "nameGET". On le définit dans le controller : par défault (Nicolas) et par lien avec "String nameGET" et avec "model.addAttribute("nomTemplate", nameGET);". Puis dans l'HTML on a écrit : "${nomTemplate}".

Etape 17 :
  - Une table "ADDRESS" a été créée dans la base de données H2 incluant l'id, la date, le contenu et indexes. Une partie "Sequences" est aussi apparue.
  
Etape 18 :
  - Hibernate permet de faciliter la création de base de données en représentant une base de données en Java ou, du Java en base de données. Hibernate facilite la persistence en créant automatiquement des tables de base de données à partir de classes Java.
  Ici on a fait une nouvelle classe Address, Hibernate l'a donc lu et transformé en une table de notre base de données directement. 
  
Etape 20 :
  - On voit tout le contenu de data.sql dans le résultat de la requête "Select * FROM Address" avec bien sûr "CURRENT_TIMESTAMP" transformé en la date du jour.
  
Etape 23 :
  - Autowired permet de lier automatiquement des élémentes de l'application. Spring va relier l'interface, et la classe directement. Il va créer l'instance de la classe AddressController et injecter l'objet dans l'interface AddressRepository.
  
PARTIE 2 :

Etape 6 :
  - Il faut une clé API pour appeler OpenWeatherMap.
  - On appelle l'URL : http://api.openweathermap.org/data/2.5/weather?lat=<<para1>>&lon=<<para2>>&units=metric&appid=<cléAPI>
  - On utilise la méthode GET pour utiliser l'API.
  - On passe les paramètres en les mettant dans l'URL juste après "lat=" et "lon=".
  - La température du lieu visé se situe dans le json après "temp".
  - Pour avoir les prévisions météos il faut appeler un autre URL du type : http://api.openweathermap.org/data/2.5/forecast/daily?lat=<<para1>>&lon=<<para2>&appid=<cléAPI> 
  ou http://api.openweathermap.org/data/2.5/forecast/daily?q={city name}&cnt={cnt}&appid={API key}
