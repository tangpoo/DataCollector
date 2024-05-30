#!/bin/bash

# 프로젝트 루트 디렉토리로 이동
cd C:\study\livecodingtest

# 프로젝트 빌드 (Gradle 사용)
echo "Building the project..."
./gradlew clean build

# 각 애플리케이션을 백그라운드에서 실행
echo "Starting application 1..."
nohup java -jar build/libs/livecodingtest-0.0.1-SNAPSHOT.jar > application1.log 2>&1 &

# 애플리케이션이 시작되었음을 알리는 메시지
echo "applications have been started."
