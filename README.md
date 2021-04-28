# 서버 네트워크 프로그래밍 
2021-04-28

## Tomcat 서버를 사용한 web Application, Network 프로그래밍

*Tomcat 9.x 서버 연동 프로젝트

## Network의 이론
###Protocol (통신 규약)
*통신(通信, 믿음이 통한다) : '지점과 지점이 데이터를 어떤 정보를 주고받을때  한 지점에서
보낸 정보는 항상 신뢰할 수 있다.' 라는 개념
* 통신이 정확하게 의미를 전달하고, 서로에게 신뢰성을 줄수 있도록 사전에 정보에 대한 약속을 정해놓은것
* <통신 규약> 이라고한다
* 지점과 지점이 통신을 하는데 서로 신뢰하지 못하면 막대한 비용적인 낭비가 발생한 것이다.

### InterNet(Inter Network, 국가간 통신) Protocol
*TCP/IP 프로토콜
* 각지점에 고유한 IP Address를 부여한다, 
* IP Address는 절대 2곳 이상에 같은 값이 부여될수 없다.
* 111.111.111.111 방식으로 IPv4 주소체계를 사용했는데
워낙많은 컴퓨터가 인터넷을 사용하다보니 주소가 고갈되었다.
*최근에는  IPv6 주소 체계로 전환되고 있고, 앞으로는 IPv4를 거의 사용하지 않을것이다.
*인터넷을 통해 연결된 Server, Client는 종류에 관계없이 모두 IP주소를 가지고있어야한다.
* DNS(Domain Name Service , Server) :도메인 주소(naver.com)를 IP 주소로 변환해주는 변환서비스를 하는 컴퓨터 서버가 있으며, 웹에서 http://naver.com 이라고 입력하면 자동으로 naver.com 컴퓨터 서버의 IP주소를 획득하여 접속할수 있다.
* 한개의 IP가 지정된 컴퓨터에서는 인터넷을 통한 다양한 서버 서비스를 제공하는데 그서비스를 구분하기 위하여 Port라는 개념을 사용한다 

* 한개의 IP주소에 65536개의 서비스를 제공하는 포트가 할당되는데 그중에서 0~ 1023까지는 아무나 임의로 사용할 수 없다. 
* 0 ~ 1023까지 port well Know Port라고 하여 인터넷으로 제공하는 서비스의 기본적으로 사용하는 PORT이다

이 Port는 임의로 다른 서비스를 제공하는 용도로 사용할 수 없다.

###well Known Port
*인터넷 서비스를 제공하는 Port중에서 0~ 1023까지
*80 : http:서비스를 제공하는 Port
원래 http:서비스에 접속하기 위해서는 http://naver.com:80 사용을 해야하는데 http:~~으로 시작되는 주소는 모두 80번 port를 통해서 접속한다라는 약속이 정해져있다
그래서: 80은 생략해도된다. 그래서 http:..com이라고만 사용해도된다.
http://naver.com:80
*443 : htts 서비스 제공하는 port
https:..naver.com:443/


###Tomcat Server Start
* Oracle Http Service Port 변경 (8080- > 9090 으로)
* eclipse의 Tomcat Server Start 
* Browser 에서 localhost :8080, 127,0,0,1 :8080으로 접속하면 Apche Tomcat 메시지 확인
### localhost, 127.0.0.1
*컴퓨터의 Local Loop Bakck Address
*Local에서 Server등의 서비스를 실행하고 테스트할수 있는 주소

###git 오류내기
