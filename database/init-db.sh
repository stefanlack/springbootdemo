#!/bin/bash
set -e

echo "Starting to restore the dump..."

# Rollen erstellen, falls nicht vorhanden
echo "Check and create user 'springbootdemo_owner' if not exists"
psql -v ON_ERROR_STOP=1 -U "$POSTGRES_USER" -d "$POSTGRES_DB" <<-EOSQL
    DO \$\$
    BEGIN
        IF NOT EXISTS (SELECT 1 FROM pg_roles WHERE rolname = 'springbootdemo_owner') THEN
            CREATE ROLE springbootdemo_owner LOGIN PASSWORD 'geheim';
        END IF;
    END
    \$\$;
EOSQL
echo "User has been created: springbootdemo_owner."
