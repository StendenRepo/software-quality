# JabberPoint

JabberPoint is een Java-presentatieprogramma gebouwd met Maven.

---

## 📦 Vereisten

Zorg dat de volgende software is geïnstalleerd:

- Java JDK (versie 17 aanbevolen)
- Maven (versie 3.8 of hoger)

Controleer je installatie met:

```bash
java -version
mvn -version
```

---

## 📁 Projectstructuur

De projectstructuur volgt de standaard Maven-indeling:

```
jabberpoint/
├── pom.xml
├── README.md
└── src/
    ├── main/
    │   ├── java/
    │   │   └── nl/jabberpoint/
    │   └── resources/
    └── test/
        └── java/
```

---

## 🚀 Project bouwen

Navigeer in de terminal naar de root van het project  
(de map waar `pom.xml` staat).

Voer vervolgens uit:

```bash
mvn clean package
```

Wat gebeurt er:

- `clean` → verwijdert oude build-bestanden (de `target/` map)
- `package` → compileert de code en maakt een uitvoerbare JAR

Na een succesvolle build vind je het bestand hier:

```
target/jabberpoint-1.0-SNAPSHOT.jar
```

---

## ▶️ Programma starten

Start de applicatie met:

```bash
java -jar target/jabberpoint-1.0-SNAPSHOT.jar
```

Als alles correct is ingesteld, wordt de JabberPoint applicatie nu gestart.

---

## 🧪 Tests uitvoeren

Om alle unit tests uit te voeren:

```bash
mvn test
```

---

## 🧹 Project opschonen

Om alle gegenereerde bestanden te verwijderen:

```bash
mvn clean
```

---

## ⚙️ Overzicht Maven Commands

| Command | Beschrijving |
|----------|-------------|
| `mvn clean` | Verwijdert de `target/` map |
| `mvn compile` | Compileert de broncode |
| `mvn test` | Voert unit tests uit |
| `mvn package` | Maakt een JAR-bestand |
| `mvn clean package` | Schone build |

---