#!/usr/bin/env bash
./gradlew user-info-service:run > userInfoService.log &
./gradlew user-projects-service:run > userProjectsService.log &
./gradlew client:run > client.log &
