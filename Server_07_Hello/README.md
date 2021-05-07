# Servlet의 응답처리


## Request 와 Response
*Request 는 Web Browser에서 서버에 요청을 하는 행위
*Response 는 서버가 Web Browser에게 응답을 하는 행위

##Request 의 forword(), Response의 sendReDirect()
*forword()는 서버에 있는 jsp파일을 읽어서 rendering을 수행한후 WebBrowser에게 전달하는 것
*senRedirect()는 서버가 다시 web browser에게 다른 요청주소를 보내고 Webbrowser가 그쪽 주소로 다시 요청을 보내도록 하는 것

## forward(), sendRedirect()
*forword()는 clien의 요청을 끝까지 책임지고 수행하여 결과를 알려주는 것까지 책임을 지는 코드 수행
	실제로 포워드는 데이터를 처리하고 화면 렌더링까지 수행하고

*sendRedirect() 는 client의 요청을 서버의 다른 요청 주소로 책임을 떠넘기는 방식
	마치 Web browser에 주소를 타이핑하여 입력하는 방식으로 요청을 전달만한다