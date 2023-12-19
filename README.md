## 프로젝트 이름

### Spring으로 만든 Java기반 TextRPG_Pakage whit NameValue
<br>

## 프로젝트 소개
#### 국비를 수강하며 만든 첫번째 팀 프로젝트
#### 객체지향코드로 자바를 이용한 TextRpg게임
#### 퀄리티는 다소 떨어지니 주의.
##### 지금보니 경악할 코드들의 연속..(2023.12.19)

## 개발환경

* IDE: IntelliJ IDEA Community
* Gradle - Groovy, Java 17
* Jar 11
* Spring Boot 2.7.6
* jvm.convert 3.3.2
* JDK 11

## 기술 스택
- Lombok
- Json
- H2 1.4.200

## 담당한 작업

#### Start Game
#### Monster
#### Go Village
#### Scene Manager

## 코드기능
#### Start Game
 - 코드를 실행하면 제일 처음 작동하는 코드
 - 타이틀(텍스트 아키텍쳐) 및 시작안내문 출력
 - if문 사용으로 1사용시 시작, 그 외의 입력값은 게임을 종료시킨다.
#### Monster
 - Charactor를 상속받아 몬스터의 정보를 초기화
 - Dungeon에서 생성된 몬스터 정보값을 저장 할 수 있는 싱글톤함수로 작성
#### Go Village
 - 추상클래스 Scene을 상속받아 추상함수를 사용
 - 마을에 입장하면 player 정보창 및 배경문구 출력
 - Scene Manager의 menu 호출한다.
 - 호출된 menu를 통해 다른장소로 이동
#### Scene Manager
 - Scene으로 분류되는 클래스에 생성자를 선언
 - getter를 이용하여 형변환
 - Go Village에서 호출한 menu는 장면이동 스위치문
 - switch문 안에 switch문이 존재.



## 업데이트 예정

 - #### 코드 리펙토링

# 작업한 버전

##### V1.1.3 (2023.09.08)
 Start Game 작동 코드 수정 

##### V1.1.2 (2023.09.07)
 Start Game 파일 추가

##### V1.1.1 (2023.09.06)
  Monster 코드 수정

##### V1.1.0 (2023.09.05)
  Scene Controller 생성
  In-Village-Controller 코드 수정
  
##### V1.0.0 (2023.08.27)
  프로젝트 완성
