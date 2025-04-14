# offizielle PostgreSQL-Image als Basis
FROM postgres:17

# Umgebungsvariable für PostgresQL
# Passworte sind hier im Klartext, da sie nur für die Lokale Entwicklung gedacht sind
ENV POSTGRES_USER=springbootdemo_owner
ENV POSTGRES_PASSWORD=geheim
ENV POSTGRES_DB=springbootdemo

# Setzen des Arbeitsverzeichnisses im Container
WORKDIR /docker-entrypoint-initdb.d

COPY init-db.sh ./

# Skript ausführbar machen
RUN chmod +x init-db.sh

# Start-Skript festlegen
#ENTRYPOINT ["/docker-entrypoint-initdb.d/init-db.sh"]

# PostgreSQL starten
CMD ["postgres"]
