package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
//        basePackages = "hello.core,member", //스캔 경로 지정
        //붙이지 않으면 ComponentScan이 붙은 설정 정보 클래스의 패키지에서 시작

        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        //@Configration을 Scan 범위에서 제외시킴, but 실무에서는 따로 안하지만 기존 예제 코드를 유지하기 위해 하는 것임.
)
public class AutoAppConfig {

}
