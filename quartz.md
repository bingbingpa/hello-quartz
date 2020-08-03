### 1.의존성 추가
- springboot 2.3.0 기준 quartz 2.3.2 버전이 import 된다.
~~~ source
  implementation 'org.springframework.boot:spring-boot-starter-quartz'
~~~

### 2. Quartz API
- Scheduler : 스케줄러와 상호 작용하기 위한 기본 API
- Job :  단 하나의 메서드를 가진 execute Job 인터페이스를 제공하고, 실제 작업을 이 메서드에 구현하면 된다.
- JobDetail : Job을 실행시키기 위한 정보를 담고 있는 객체. Job의 이름, 그룹, JobDataMap 속성 등을 지정할 수 있다. 
- Trigger : Job을 실행시킬 스케줄링 조건(반복횟수, 시작시간 등)을 담고 있고 Scheduler 는 이 정보를 기반으로 Job을 수행시킨다.
- JobBuilder : Job 인스턴스를 정의하는 JobDetail 인스턴스를 정의 / 빌드 하는데 사용
- TriggerBuilder : Trigger 인스턴스를 정의 / 빌드하는데 사용
- Listener : Scheduler 의 이벤트를 받을 수 있도록 Quartz 에서 제공하는 인터페이스이며 2가지를 제공한다.
- JobListener : Job 실행 전후로 이벤트를 받을 수 있다.
- TriggerListener : Trigger 가 발생하거나 불발이 날 때나 Trigger를 완료할 때 이벤트를 받을 수 있다.
- JobStore : Job 과 Trigger 의 정보를 2가지 방식으로 저장 할 수 있다.
- RAMJobStore : 기본 값으로 메모리에 스케줄 정보를 저장한다. 메모리에 저장하기 때문에 성능면에서는 제일 좋지만, 시스템 문제 발생 시 스케줄 데이터를 유지하지 못한다. 
- JDBC JobStore : 스케줄 정보를 DB에 저장한다. 시스템이 셧다운 되더라도 스케줄 정보는 유지되어 시스템 재시작시 다시 Job을 실행할 수 있다.
- 기타 JobStore : Quartz JobStore 을 확장하여 다른 저장소(Redis, MongoDB)에도 저장할 수 있다.

### 3. sql 생성 
- JDBCJobStore를 사용하려면 먼저 Quartz가 사용할 데이터베이스 테이블 세트를 작성해야 한다. Quartz 배포판의 docs/dbTables 에서 tables_postgresql.sql 스크립트를 실행한다. 

### 4. 주의할 점 
- Quartz의 테이블에 직접 쓰지 말 것. 
- 적절한 데이터 소스 연결 크기 확인.
- 스케줄러 이름은 각각 다르게 사용.
