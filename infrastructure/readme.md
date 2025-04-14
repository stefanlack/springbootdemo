
# Notizen zum Einrichten von Sonarqube

## Mit Docker Compose starten

Starten von Sonarqube
    cd infrastructure/sonar
    docker compose up -d
 
## Password ändern und Token erstellen

Temporärer-Login auf
  [http://localhost:9000](http://localhost:9000)
    Benutzer: admin
    Passwort: admin

Neues Passwort vergeben, z.B.:  Admin1234!Admin1234!

Auf http://localhost:9000/account/security token erstellen und kopieren

z.B.: squ_3d3c8f19012e56d248179ad522709fbe4621aa53 

Zum test in umgebungsvariablen speichern:

    export SONAR_TOKEN=squ_3d3c8f19012e56d248179ad522709fbe4621aa53

## Maven settings.xml konfigurieren

In der Datei `settings.xml` im Verzeichnis `~/.m2` einfügen:

```xml
    <pluginGroups>
        <pluginGroup>org.sonarsource.scanner.maven</pluginGroup>
    </pluginGroups>
    <profiles>
        <profile>
            <id>sonar</id>
            <activation>
                <activeByDefault>true</activeByDefault>
            </activation>
            <properties>
                <!-- Optional URL to server. Default value is http://localhost:9000 -->
                <sonar.host.url>
                  http://localhost:9000
                </sonar.host.url>
            </properties>
        </profile>
     </profiles>
```     


## Analyse ausführen:
    ./mvnw clean verify sonar:sonar -Dsonar.token=$SONAR_TOKEN

Analyse-Ergebnisse sind unter http://localhost:9000/dashboard?id=com.opitzconsulting%3Aspringbootdemo&codeScope=overall zu finden.


# Notizen für Jenkins

## Installation mit Docker

Entommen von der Anleitung auf https://www.jenkins.io/doc/book/installing/docker/


```bash

docker network create jenkins

## dann "docker login" ausführen und sich im browser anmelden

## dann jenkins docker image lokal bauen:

docker build -t myjenkins-blueocean:2.492.3-1 .

# jenkins starten. Lokaler port ist hier extra auf  8085 gesetzt:

docker run --name jenkins-blueocean --restart=on-failure --detach \
  --network jenkins --env DOCKER_HOST=tcp://docker:2376 \
  --env DOCKER_CERT_PATH=/certs/client --env DOCKER_TLS_VERIFY=1 \
  --publish 8085:8080 --publish 50000:50000 \
  --volume jenkins-data:/var/jenkins_home \
  --volume jenkins-docker-certs:/certs/client:ro \
  myjenkins-blueocean:2.492.3-1
  
```

## Post installation
Dem https://www.jenkins.io/doc/book/installing/docker/#setup-wizard folgen.

In `docker logs -f jenkins-blueocean` das initial password kopieren, 
http://localhost:8085/ öffnen,und  password eintragen.

Dummy User konfigurieren

username: stefanlack
password: geheim
(hier öffentlich sichtbar eingetragen, da es sich nur um ein lokales Demo Projekt handelt)