# [2주차 과제] REST API 스터디 & API 가이드 문서 작성





### TIL 목차 
* [1.1 REST](#1-1-rest)
  - [REST의 개념](#rest의-개념)
  - [REST의 구성 요소](#rest의-구성-요소)
  - [REST의 장단점](#rest의-장단점)
  - [REST의 특징](#rest의-특징)
  - [REST가 필요한 이유](#rest가-필요한-이유)
* [1.2 REST API](#1-2-rest-api)
  - [REST API란?](#rest-api란)
  - [REST API의 특징](#rest-api의-특징)
* [1.3 RESTful](#1-3-restful)
  - [RESTful이란?](#restful이란)
  - [RESTful의 목적](#restful의-목적)
  - [RESTful하지 못한 경우](#restful하지-못한-경우)
* [2.1 HTTP](#2-1-http)
  - [HTTP 통신 개념](#http-통신-개념)
  - [HTTP 통신 방식](#http-통신-방식)
* [3.1 브라우저에 URL입력 후 접속할 때까지의 과정](#3-1-브라우저에-URL입력-후-접속할-때까지의-과정)
* [4.1 API 응답 방식](#3-1-api-응답-방식)
  - [@PathVariable](#@PathVariable)
  - [JSON](#json)

- - - 

# 1-1 REST
## REST의 개념
- "Represntational State Transfer"의 약자 
  * 자원을 이름(자원의 표현)으로 구분하여 해당 자원의 상태(정보)를 주고 받는 모든 것을 의미.
    + 자원: 해당 소프트웨어가 관리하는 모든 것. 
    + 상태 전달: JSON 혹은 XML을 통해 데이터를 주고 받는 것이 일반적.  
  * 월드 와이드 웹(www)과 같은 분산 하이퍼미디어 시스템을 위한 소프트웨어 개발 아키텍처의 한 형식
    + REST는 기본적으로 웹의 기존 기술과 HTTP 프로토콜을 그대로 활용하기 때문에 웹의 장점을 최대한 활용할 수 있는 아키텍처 스타일임. 
    + REST는 네트워크 상에서 클라이언트와 서버 사이의 통신 방식 중 하나. 
- **HTTP URI**를 통해 자원을 명시하고 **HTTP Method**(GET, POST, PUT, DELETE)를 통해 해당 자원에 대한 **CRUD Operation**을 적용하는 것. 
  * 웹 사이트의 이미지, 텍스트, 디비 내용 등 모든 자원에 고유한 ID인 HTTP URI를 부여함. 
  * CRUD Operation
    + Create: 생성 (POST)
    + Read: 조회 (GET)
    + Update: 수정 (PUT)
    + Delete: 삭제 (DELETE)
- 쉽게 말해 **URI와 HTTP 메소드를 이용해 객체화된 서비스에 접근하는 것**. 

## REST의 구성 요소
1. 자원: URI
    - 모든 자원에 고유한 ID 가 존제하고, 이 자원은 Server에 존재. 
    - 자원을 구별하는 ID는 '/groups/:groupsid' 와 같은 HTTP URI
    - 클라이언트는 URI를 이용해서 자원을 지정하고 해당 자원의 상태에 대한 조작을 서버에 요청. 
2. 행위: HTTP Method
3. 표현
    - 클라이언트가 자원에 대한 조작을 요청하면 서버는 이에 적절한 응답을 보냄. 
    - JSON, XML을 통해 데이터를 주고받는 것이 일반적. 

## REST의 장단점
- 장점
  * HTTP 프로토콜의 인프라를 그대로 사용하므로 REST API 사용을 위한 별도의 인프라를 구출할 필요가 없다.
  * HTTP 표준 프로토콜에 따르는 모든 플랫폼에서 사용이 가능하다.
  * REST API 메시지가 의도하는 바를 명확하게 나타내므로 의도하는 바를 쉽게 파악할 수 있다.
  * 서버와 클라이언트의 역할을 명확하게 분리한다. 
- 단점
  * 표준이 존재하지 않음. 
  * 사용할 수 있는 메소드가 4가지 밖에 없음. 
  * 구형 브라우저가 아직 제대로 지원해지지 못하는 부분(PUT, DELETE)이 존재함. 

## REST의 특징
1. Server-Client 구조
    - 자원이 있는 쪽이 Server, 자원을 요청하는 쪽이 Client가 됨. 
      + REST Server: API를 제공하고 비즈니스 로직 처리 및 저장을 책임 짐. 
      + Client: 사용자 인증이나 정보를 직접 관리하고 책임짐. 
    - 서로간의 의존성이 줄어듬. 
2. 무상태
    - HTTP 프로토콜은 무상태성이므로 REST 역시 무상태성을 갖는다. 
    - 클라이언트의 Context를 서버에 저장하지 않음. (구현이 단순해짐)
    - 서버는 각각의 요청을 완전히 별개의 것으로 인식하고 처리함. (서버 처리 방식에 일관성을 부여하여 부담이 줄어들고 서비스의 자유도가 높아짐.)
3. 캐시 처리 가능
4. 계층화
    - REST Server 는 다중 계층으로 구성될 수 있음. 
    - API 서버는 순수 비즈니스 로직을 수행하고 그 앞단에 보안, 로드밸런싱, 암호화 등을 추가하여 구조상의 유연성을 줄 수 있고 확장성과 보안성을 향상시킬 수 있음. 
5. Code-On-Demend
    - 서버로부터 스크립트를 받아서 클라이언트에서 실행. (반드시 충족할 필요는 없음.)
6. 인터페이스 일관성
    - URI로 지정한 자원에 대한 조작을 통일되고 한정적인 인터페이스로 수행함. 
    - HTTP 표준 프로토콜에 따르는 모든 플랫폼에서 사용이 가능함. 

## REST가 필요한 이유
- 어플리케이션 분리 및 통합
- 다양한 클라이언트의 등장
  * 서버 프로그램이 다양한 브라우저, 모바일 환경에서도 통신을 할 수 있어야 함.

# 1-2 REST API
## REST API란
- REST 기반으로 서비스 API를 구현한 것. 
- OpenAPI, 마이크로 서비스 등을 제공하는 업체 대부분은 REST API를 제공함. 


## REST API의 특징
- 사내 시스템들도 REST 기반으로 시스템을 분산해 확장성과 재사용성을 높여 유지보수 및 운용을 편리하게 할 수 있음. 
- REST는 HTTP 표준을 기반으로 구현하므로, HTTP를 지원하는 프로그램 언어로 클라이언트, 서버를 구현할 수 있음. 
- REST API 설계 예시
<img width="759" alt="restapi-example" src="https://user-images.githubusercontent.com/58394729/129701855-f0e2a076-b00f-48b2-aaa4-5086949062a4.png">

# 1-3 RESTful
## RESTful이란
- 'REST API'를 제공하는 웹서비스를 'RESTful'하다고 할 수 있음. 
- REST 원리를 따르는 시스템은 RESTful이란 용어로 지칭됨. 

## RESTful의 목적
- 이해하기 쉽고 사용하기 쉬운 REST API를 만드는 것.
- RESTful한 API를 구현하는 근본적인 목적은 일관적인 컨밴션을 통한 API의 이해도 및 호환성을 높이는 것이 주 동기이므로, 성능이 중요한 상황에서는 굳이 RESTful한 API를 구현할 필요는 겂다. 

## RESTful하지 못한 경우
- CRUD 기능을 모두 POST로만 처리하는 API
- route에 resource, id외의 정보가 들어가는 경우 (/students/updateName)

### 참고문헌
https://gmlwjd9405.github.io/2018/09/21/rest-and-restful.html





# 2-1 HTTP
## HTTP 통신 개념
- HyperText Transfer Protocol의 약자로 인터넷에서 데이터를 주고받는 프로토콜. 
- HTML 뿐만 아니라 JSON 등 다영한 포맷이 가능함. 

## HTTP 통신 방식
- 클라이언트가 서버에 **요청**을 보내면 그에 맞는 **응답** 결과를 돌려주고, 클라이언트는 사용자에게 서버로부터 응답받은 결과를 보여줌. 
- 클라이언트의 요청이 있을 때 서버가 응답하는 방식으로 **단방향 통신**임. 
- **비연결성**
    + 클라이언트가 서버에 요청을 보내고 응답을 받으면 통신이 종료됨. 
    + 서버는 클라이언트가 웹사이트에 접속해있는지 알 수 없음. 
    + 통신을 주고 받아도 서버와 클라이언트가 연결되어있는 것이 아니라 각각의 통신은 독립적. 
 ![image](https://user-images.githubusercontent.com/58394729/129706396-1230eaee-29d9-4fcf-9770-91f6a7438284.png)
- HTTP request, response 구조
![image (1)](https://user-images.githubusercontent.com/58394729/129706745-bcab0a02-4172-433f-a775-1c7241af9abf.png)



# 3-1 브라우저에 URL입력 후 접속할 때까지의 과정




# 4-1 API 응답 방식

## @PathVariable

## JSON 



