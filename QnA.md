영한님의 인프런 강의인 "실전! 스프링 부트와 JPA 활용1 - 웹 애플리케이션 개발"를 들으며 작성하는 코드   

Q) @PersistenceContext?    
- EntityManager(영속성관리를 위함)를 주입해주기 위한 Annotation  
- Spring Data JPA에서 지원해주기 때문에 EntityManager를 @Autowired로 받아올 수 있음 

Q) jpql?
- Java Persistence Query Language의 줄임말로 SQL을 추상화한 객체지향쿼리 언어
- JPA는 엔티티 객체를 활용하여 개발하기 때문에 DB를 찾을 때도 테이블이 아닌 객체로 검색해야함

Q) @Transactional?
- Transaction을 수행하기 위하여 붙여주는 Annotation
- 'readOnly = true' 사용시 단순 조회하는 로직에서의 성능이 최적화됨
- Test에서 사용시 default로 RollBack해버림
- insert문을 로그로 보고싶으면 EntityManager로 flush()해서 볼 수 있음

Q) @RunWith(SpringRunner.class)?
- Spring을 동작시켜 테스트하고 싶을 때 사용할 수 있음.
- @SpringBootTest보다 좀 더 가볍게 테스트가 가능함.

Q) 동적쿼리해결법?
- JPA 스펙으로 Criteria를 사용해 동적쿼리를 만들 수 있음.(가독성이 떨어짐 어떤 sql 질의가 나올지 모르겠음)
- Querydsl을 사용하면 동적쿼리를 만들 수 있음.

Q) BindingResult?
- Valid로 데이터를 확인할 때 오류가 있으면 그 오류 정보를 넘겨줌   

Q) 준영속 엔티티?
- 객체를 새로 만들어도 key값이 DB에서 이미 가지고 있는 엔티티를 준영속 엔티티 
- JPA가 따로 관리 안함(영속성과 다름 - dirty checking을 안함)
- merge로 직접 변경(모든 속성이 전부 변경) 사용안하는게 좋음  
- Dirty Checking으로 변경할 수 있게 직접 객체 찾아서 영속성으로 변경(Transaction 안에서 객체 불러서 사용)

T) 엔티티 수정을 구현할 때 팁
1. Transaction 안에서 객체를 불러와 사용  Dirty Checking을 사용 
2. 컨트롤러에서 불필요하게 객체를 생성x
3. 트랜젝션이 있는 서비스 계층으로 ID와 변경할 데이터(DTO,파라미터)를 명확히 넘기자
4. setter로 변경하지 말고, change()와 같은 메소드를 하나 만들어서 변경하자(변경되는 위치를 한곳으로)
