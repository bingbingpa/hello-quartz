### docker start 
- docker container run -d -e POSTGRES_PASSWORD=postgres -p 25432:5432 --name "quartz-db" postgis/postgis:12-master

### 리팩토링 하기
- [원본소스](https://github.com/javabypatel/spring-boot-quartz-demo)
- 트랜잭션 관리 테스트 하기. 리팩토링 하고 스케줄 이력 관리를 위한 history 기능을 붙였을때 트랜잭션이 잘 작동 하는지 테스트 필요) 
- JobService, JobUtil 테스트 코드 작성(기존 코드 작성하고 잘 동작하는지 테스트가 필요해서)
- Job 구현은 QuartzJobBean extends 말고 Job implement 하는 걸로 변경. 그에 따라 Class<? extends QuartzJobBean> -> 이것들도 변경 필요 
- createJob 메서드에서 파라미터로 ApplicationContext 가 필요 없어 보이는데 확인 필요. JobDetail 생성에는 context 가 없어도 될거 같은데... 확인 후 변경
- JobService 관련 domain 생성
- controller 테스트 코드 작성   
- url mapping 은 rest 형태로 변경하기 
- ui 붙이기   