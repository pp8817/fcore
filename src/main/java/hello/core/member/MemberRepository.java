package hello.core.member;

public interface MemberRepository {
    //추상 메소드 생성 - 인터페이스를 구현하는 클래스는 구현 객체를 필수로 만들어야함
    void save(Member member);
    Member findById(Long memberId);
//테스트
}
