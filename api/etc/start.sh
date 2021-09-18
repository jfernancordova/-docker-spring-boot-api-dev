#!/bin/sh

source /root/set_features.sh
echo "Starting app"
java -jar /app/api.jar $MONGODB_CONF