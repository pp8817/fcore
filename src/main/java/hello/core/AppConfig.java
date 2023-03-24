package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//AppConfig를 통해서 관심사를 분리
//각 impl 클래스들이 인터페이스에 의존, appconfig가 구체 클래스를 선택
@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    //기존에는 impl에서 Repository를 설정하던 것은 역할의 중복 이기 때문에 AppConfig를 생성하여 역할 분담. 기존의 중복을 삭제
    //구체 클래스에 의존하지 않고 인터페이스에만 의존하도록 도와줌
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(
                memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    } //AppConfig를 역할과 구현 클래스가 한 눈에 보이도록 리팩토링 했음. 이렇게 함으로서 구성의 영역과 사용의 영역이 확실하게 구분됨. Repository or DiscountPolicy의 정책을 변경할 때는 AppConfigp만 변경하면 됨

}
