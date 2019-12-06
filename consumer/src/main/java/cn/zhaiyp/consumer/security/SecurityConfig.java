package cn.zhaiyp.consumer.security;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author fkptxmz
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity httpSecurity) {
        try {
            httpSecurity.formLogin()        //定义当需要用户登录时，跳转的登录页面
                    .and()                  //
                    .authorizeRequests()    //定义那些URL需要被保护、那些不需要被保护
                    .anyRequest()           //任何请求，登录后可以访问
                    .authenticated();       //
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
