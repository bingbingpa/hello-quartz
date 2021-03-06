### Quartz 란? 
- Terracotta 라는 회사에 의해 개발된 Job Scheduling 라이브러리 
- 수십에서 수천 개의 작업도 실행 가능하며 간단한 interval 형식이나 Cron 표현식으로 복잡한 스케줄링도 지원한다. 

### 장단점 
- 장점 
    - DB 기반으로 스케줄러 간의 Clustering 기능을 제공한다. 
    - 시스템 Fail-over 와 Random 방식의 로드 분산처리를 지원한다. 
    - In-memory 스케줄링도 제공한다. 
- 단점 
    - Clustering 기능을 제공하지만, 단순한 random 방식이라서 완벽한 Cluster 간의 로드 분산은 안된다. 
    - 어드민 UI 를 제공하지 않는다. 
    - 스케줄링 실행에 대한 History 는 보관하지 않는다. 

### 의존성 추가
- springboot 2.3.0 기준 quartz 2.3.2 버전이 import 된다.
~~~ source
  implementation 'org.springframework.boot:spring-boot-starter-quartz'
~~~

### Quartz API
- Scheduler : 스케줄러와 상호 작용하기 위한 기본 API
- Job :  단 하나의 메서드를 가진 execute Job 인터페이스를 제공하고, 실제 작업을 이 메서드에 구현하면 된다.
- JobDetail : Job을 실행시키기 위한 정보를 담고 있는 객체. Job의 이름, 그룹, JobDataMap 속성 등을 지정할 수 있다. 
- JobDataMap : Job 인스턴스가 실행할 때 사용할 수 있게 원하는 정보를 담을 수 있는 객체.
- Trigger : Job을 실행시킬 스케줄링 조건(반복횟수, 시작시간 등)을 담고 있고, Scheduler 는 이 정보를 기반으로 Job을 수행시킨다.
- JobBuilder : Job 인스턴스를 정의하는 JobDetail 인스턴스를 정의 / 빌드 하는데 사용
- TriggerBuilder : Trigger 인스턴스를 정의 / 빌드하는데 사용
- Listener : Scheduler 의 이벤트를 받을 수 있도록 Quartz 에서 제공하는 인터페이스이며 2가지를 제공한다.
- JobListener : Job 실행 전후로 이벤트를 받을 수 있다.
- TriggerListener : Trigger 가 발생하거나 불발이 날 때나 Trigger를 완료할 때 이벤트를 받을 수 있다.
- JobStore : Job 과 Trigger 의 정보를 2가지 방식으로 저장 할 수 있다.
- RAMJobStore : 기본 값으로 메모리에 스케줄 정보를 저장한다. 메모리에 저장하기 때문에 성능면에서는 제일 좋지만, 시스템 문제 발생 시 스케줄 데이터를 유지하지 못한다. 
- JDBC JobStore : 스케줄 정보를 DB에 저장한다. 시스템이 셧다운 되더라도 스케줄 정보는 유지되어 시스템 재시작시 다시 Job을 실행할 수 있다.
- 기타 JobStore : Quartz JobStore 을 확장하여 다른 저장소(Redis, MongoDB)에도 저장할 수 있다.

### sql 생성 
- JDBCJobStore를 사용하려면 먼저 Quartz가 사용할 데이터베이스 테이블 세트를 작성해야 한다. Quartz 배포판의 docs/dbTables 에서 tables_postgresql.sql 스크립트를 실행한다. 

### 주의할 점 
- Quartz의 테이블에 직접 쓰지 말 것. 
- 적절한 데이터 소스 연결 크기 확인.
- 스케줄러 이름은 각각 다르게 사용.

### 모르는 내용 정리 
- Spring Boot 에서는 @EnableAutoConfiguration 어노테이션(@SpringBootApplication 어노테이션에 의해 포함됨)에 의해서 
application.properties 내의 spring.datasource.* 속성은 정의하면 자동으로 인식 된다. 
하지만, JavaConfig 로 별도의 DataSource 를 구현하여 Bean 을 등록했다면 spring.datasource.* 속성은 적용되지 않는다. 
- @EnableAutoConfiguration 는 @SpringBootConfiguration, @ComponentScan, @EnableAutoConfiguration 3가지 합쳐진 것이라고 볼 수 있다. 
- SpringBeanJobFactory
    - 애플리케이션 구동 완료 후에 동적으로 추가하는 bean 에도 의존 관계를 쉽게 주입할 수 있게 해준다.
    - 스케줄러는 일반적으로 작업을 스케줄하는 시점과 작업을 실행하는 시점이 다르다. 그리고 작업을 실행하려면 작업 클래스를 인스턴스화 해야 하는데, 이 때 JobFactory 가 사용된다.
- Job : Job 은 **실행 해야 할 작업**을 의미한다. Job 인터페이스는 execute 메서드를 정의하는데, execute 메서드의 파라미터인 JobExecutionContext 에는 트리거 핸들링, 스케쥴에 의한
핸들링 등을 포함하여 런타임 환경에 대한 정보를 제공한다.
- spring.quartz.properties.org.quartz.jobStore.useProperties 이 값이 true 이면 DB 에 JobDataMaps 에 저장되는 값이 바이너리가 아닌 String 값으로 저장된다. 
- quartz 설정을 @ConditionalOnProperty 설정값에 따라 활성화 할 경우 properties 파일을 따로 분리해야 한다.  
 


