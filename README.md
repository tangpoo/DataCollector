# LiveCodingTest

# 테스트 커버리지

StationGroup Api test 및 Service test 구현

DataDevice Api test 및 Service test 구현

Data Api test 및 Service test 구현

---

# ERD

![Pasted image 20240522170538](https://github.com/tangpoo/LiveCodingTest/assets/131866367/cbb2352e-29fb-4e25-b238-d8faa9be6a47)

---
# SWAGGER API

![Pasted image 20240522171850](https://github.com/tangpoo/LiveCodingTest/assets/131866367/c5768136-62f1-4c67-9e9f-99801015c847)

----

# Shell Script로 프로젝트 실행
1. Gib Bash실행
2. 프로젝트의 root 폴더로 이동
3. ./start.sh 입력

![Pasted image 20240522180536](https://github.com/tangpoo/LiveCodingTest/assets/131866367/503a9db0-e132-4e78-a817-d1290d67c873)

---

# Insert 쿼리

StationGroup 등록

![Pasted image 20240522170028](https://github.com/tangpoo/LiveCodingTest/assets/131866367/7d7f0aea-3bd4-4869-9720-a1fe19c008d5)


DataDevice 등록

![Pasted image 20240522170223](https://github.com/tangpoo/LiveCodingTest/assets/131866367/72530900-c4e5-4147-bdd6-f16d413fc358)


Data 등록

![Pasted image 20240522170408](https://github.com/tangpoo/LiveCodingTest/assets/131866367/cb7b1476-972a-4476-a60f-5bdd8cec1863)

----

# 통계 정보 조회 최적화

Data를 16진수에서 10진수로 변환하여 저장합니다.
serialNumber(혹은 stationGroupSerialNumber)와 일치하고, startTime ~ endTime 사이에 위치하는
data 테이블에서 data_set의 avg를 먼저 추출한 후,
다음 조회 쿼리에서 avg와 함께 response 객체로 Projection 합니다.
이로인해 사용되지 않는 데이터의 조회를 차단할 수 있고, 데이터 조회를 DB Level에서 최적화 함으로써
성능을 최적화하고 리소스 사용을 최소화 하였습니다.