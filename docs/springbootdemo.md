
# Dokumentation

## Anforderungen

1. Erstellen Sie ein Java-Spring-Boot-Projekt, das mithilfe von OpenAPI einen einfachen REST-Endpoint bereitstellt.
2. Persistieren Sie Daten mithilfe von Hibernate (JPA) in eine Datenbank.
3. Richten Sie eine einfache Jenkins-Pipeline ein, die
* den Code aus einem Git-Repository checkt,
* das Projekt baut und testet (Maven), und 
* einen kurzen Code-Quality-Check (welche) durchführt.
4. Dokumentieren Sie kurz, wie das Projekt aufgebaut ist und wie Sie die Pipeline konfiguriert haben.

## Build

Das Projekt wird mit Maven gebaut. 
Die Tests werden mit JUnit 5 durchgeführt. 

## Local Deployment


[Swagger-UI
](http://localhost:8080/swagger-ui/index.html) ist unter dem Pfad `/swagger-ui/index.html` erreichbar.

Die OPEN-API-Spezifikation kann unter dem Pfad [/v3/api-docs](http://localhost:8080/v3/api-docs) geladen werden.
# Architektur

## ADR-Liste

_Hinweis:_ Einzelne ADR-Einträge enthalten in der Regel mehr Informationen (Datum der Entscheidung, Liste der Entscheider, Betrachtete Alternativen). Da dies hier nur einen Demo-Charakter darstellt, sind diese Informationen nicht enthalten.

### 001  - Datenbank Postgrsql
Verwendung von Postgresql als Datenbank

### 002 - Datenbank-Tests Embedded Postgres
Für automatisierte Tests wird eine embedded Postgres Datenbank verwendet: io.zonky.test:embedded-postgres.
Grund: wir verwenden nicht h2, da wir auch in den Tests möglichst nahe an der späteren Produktionsumgebung sein wollen.

### 003 - Entscheidung Code First
Bei der Implementierung einer REST Api mit dem OPEN-API Standards muss entschieden werden, ob man einen "API-First" oder "Code-First" Ansatz verfolgt. 

Da erst mal keine weiteren Anforderungen an die API gestellt werden, wurde der "Code-First" Ansatz gewählt.

Diese Entscheidung basiert auf der getroffenen _Annahme_, dass die API nur für einen einzigen Client erstellt wird. Dies wird eine Angular Webanwendung sein. 

Der REST-Controller werden also durch Annotationen als REST-Endpunkte konfiguriert. Bei Bedarf kann mithilfe entsprechender Plugins auch eine OPEN-API-Spezifikation generiert werden.

## 004 - Entscheidung Spring-Boot

Die Verwendung von Spring Boot war durch die Rahmenbedingungen vorgegeben.

## 005 - Entscheidung Spring Data JPA
Die Verwendung von Spring Data JPA war durch die Rahmenbedingungen vorgegeben.

## 006 - Entscheidung Spring Web
Die Verwendung von Spring Web war durch die Rahmenbedingungen vorgegeben.

### 007 - Database First Ansatz und Verwendung von Liquibase
Der Database First Ansatz wurde gewählt, da die Datenbank mittels automatisierter Schema migration mittels Liquibase verwaltet wird.