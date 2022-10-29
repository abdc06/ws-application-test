## JMeter 설치

- [https://jmeter.apache.org/download_jmeter.cgi](https://jmeter.apache.org/download_jmeter.cgi)
- 압축 파일 다운로드, 압축 파일 풀기
- bin/jmeter 실행

![jmeter-run](docs/jmeter-run.png)

## 사용 방법

### Thread Group 만들기
- Number of Threads: 쓰레드 개수
- Ramp-up period: 쓰레드 개수를 만드는데 소요할 시간
- Loop Count: infinite 체크 하면 위에서 정한 쓰레드 개수로 계속 요청 보내기. 값을 입력하면 해당 쓰레드 개수 X 루프 개수 만큼 요청 보냄.

### Sampler 만들기
- 여러 종류의 샘플러가 있지만 그 중에 우리가 사용할 샘플러는 HTTP Request 샘플러.
- HTTP Sampler
- 요청을 보낼 호스트, 포트, URI, 요청 본문 등을 설정
- 여러 샘플러를 순차적으로 등록하는 것도 가능하다.

### Listener 만들기
- View Results Tree
- View Resulrts in Table
- Summary Report
- Aggregate Report
- Response Time Graph
- Graph Results
- ...

### Assertion 만들기
- 응답 코드 확인
- 응답 본문 확인

### CLI 사용하기
- jmeter -n -t 설정 파일 -l 리포트 파일
