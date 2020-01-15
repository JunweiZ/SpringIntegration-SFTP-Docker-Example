#!/usr/bin/env bash

./gradlew clean build docker;
docker-compose build;
docker-compose up