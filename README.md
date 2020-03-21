# java-chicken-2019

## 기능 요구 사항 

치킨집사장님이사용하는간단한포스(POS)프로그램을구현한다. 주문등록,결제하기,프로그램종료기능을가진다.

## 기능목록 1. 등록하기

### 기능 나열

- 사용할 수 있는 기능을 출력한다
- 원하는 기능을 입력 받는다.
- 테이블 목록을 출력한다.
- 테이블을 선택받는다.
- 메뉴 목록을 출력한다.
- 등록할 메뉴를 입력 받는다.
- 등록할 수량을 입력 받는다.

### TDD 방식

- [x] MenuType & Category
- [x] Menu
- [x] MenuRepository
- [x] Order
- [x] Table
- [x] TableRepository

- [x] TableId
- [x] MenuId
- [x] 조립

### 추가 구현 사항

- [x] PaymentType 종류 추가(Naver, Payco, Kakao Pay) : 10%
- [x] 치킨을 3마리 이상 시킨 경우 음료 50% 할인
- [x] test 추가(가격에 대해서)