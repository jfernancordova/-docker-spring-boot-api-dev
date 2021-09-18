#!/bin/sh

set_mongodb () {
    MONGODB_CONF=""
    echo -n "Starting General Environment..."
    if [ "$USE_MONGODB" = "true" ]; then
            echo -n "Setting MongoDB..."
            if [ -f /run/secrets/mongodb_uri ]; then
            export MONGODB_CONF="--spring.data.mongodb.uri=$(cat /run/secrets/mongodb_uri) "
            echo "MongoDB set."
        else
            echo -n "Mongo URI is not set. "
            echo "Using default config in application.properties"
        fi
    else
        echo -n "Mongo URI is not set. "
        echo "Using default config in application.properties"
    fi
    if [ -f /run/secrets/mongodb_uri ]; then
        export MONGO_DB_URI="$(cat /run/secrets/mongodb_uri)"
    fi
}

set_mongodb
