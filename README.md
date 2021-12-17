# JPAShop
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