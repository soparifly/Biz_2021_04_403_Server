# WAS ( Web Application Service)
* Web Application Server : Tomcat과 같은 서버소프트웨어를 일컫는말 
* Web Application Service : 어떤 특정한 Language 를 사용하여 Web(인터넷)환경에서 작동되는 어플리케이션

 *Service는 항상 Request를 받을 준비상태에 있으며 언제든지
 Web Browser에서 요청이 들어오면 그 요청이 무엇인지 파악하여 적절한 응답을 할 대기상태로 있다.
 
 *Web Service는 Client(Web Browser)의 요청이 있을때만 반응을 시작한다.
 
 
 ##Client의 요청하기
 *URL을 통하여 : http://localhost:8080/book/rent 와 같은 요청을 Web Browser의 주소창에 입력하는 방식
 *Service를 실행하는 화면에서 Link(Anchor)를 클릭하기 
 *Service를 실행하는 화면에서 데이터를 input box에 입력하고 전송하기
 
 ## Link 클릭
 *HTML 코드를 사용하여 파일을 만들고, 일단 Client에게 먼저 보여주고, Client가 클릭하도록하기
 * anchor tag 를 사용하여 코드를 작성하기
 * < a href ="요청"> 보여줄 내용 </a>
 
 ##데이터를 input box에 입력하고 전송하기
 *HTML 코드를 사용하여 파일을 만들고, 일단 Client에게 보여주고 Client가 값을 입력하고 전송을 클릭하면 데이터와함께 요청하기
 *<form action="요청"> <input name="변수이름"/></form> 
 *input box 값을 입력하고 전송을 요청하면 요청?변수이름=값 형식으로 서버에 요청한다. client가 입력한 데이터를 함께 서버로 전송하여 처리하도록 한다.
 
 ##Server에서 처리하기
 *client의 요청이 오면 지정된 Controller의 doGet()메소드가 먼저 반응을 한다
 *또다른 Sub요청을 분석하여 적절한 요청을 처리한다
 *좀더 세밀한 처리가 필요할 경우 Service 클래스에게 요청을하고, 결과를 리턴받는다
 *Client에게 문자열, view형식으로 보여주기를 준비한다
 이때 모든 보여주는 형식은 HTML 코딩 형식으로 만든다
 