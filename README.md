# OTAP GitHub Actions Pipeline

Dit project maakt gebruik van een volledige **OTAP-straat** binnen GitHub Actions.

De pipeline bestaat uit vier branches met elk een eigen verantwoordelijkheid:

- **Develop**
- **Test**
- **Acceptance**
- **Production**

---

# Develop Branch

## Workflow
Trigger:
- `push` naar `develop`
- `pull_request` naar `develop`

Uitgevoerde stappen:
- `mvn -B -f jabberpoint/pom.xml clean verify`
- Alle tests worden uitgevoerd
- De `.jar` wordt gebouwd
- De `.jar` wordt geüpload als **GitHub Artifact**

## Resultaat
- Tijdelijke build beschikbaar via **Actions → Artifacts**
- Geen officiële release
- Workflow faalt bij testfouten

Dit is de **Continuous Integration (CI)** omgeving.

---

# Test Branch

## Workflow
Trigger:
- `push` naar `test`
- `pull_request` naar `test`

Uitgevoerde stap:
- `mvn -B -f jabberpoint/pom.xml test`

## Resultaat
- Alleen unit tests worden uitgevoerd

Dit is een pure **testcontrole-stap**.

---

# Acceptance Branch

## Workflow
Trigger:
- `push` naar `acceptance`
- `pull_request` naar `acceptance`

Uitgevoerde stappen:
- Tests worden uitgevoerd op:
  - Ubuntu (Linux)
  - Windows
- Gebruik van een **matrix strategy**
- Workflow faalt als één platform faalt

## Resultaat
- Cross-platform validatie


Dit is de **kwaliteitscontrole vóór productie**.

---

# Production Branch

## Workflow
Trigger:
- `push` naar `production`

Uitgevoerde stappen:
- `mvn -B -f jabberpoint/pom.xml clean package -DskipTests`
- Automatisch aanmaken van:
  - Git tag (bijv. `v1.0.x`)
  - GitHub Release
- Upload van de `.jar` als release asset

## Resultaat
- Officiële versie zichtbaar onder **Releases**
- Permanente downloadbare build

Dit is de **productie-release omgeving**.

---