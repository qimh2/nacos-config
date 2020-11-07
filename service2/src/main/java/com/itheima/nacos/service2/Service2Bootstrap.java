package com.itheima.nacos.service2;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @version 1.0
 **/
@RestController
@SpringBootApplication
public class Service2Bootstrap {

    public static void main(String[] args) {
        SpringApplication.run(Service2Bootstrap.class,args);
    }


    /**
     * 读取配置信息
     * 动态更新的意思是，nacos 管理页面，修改了配置，刷新就可以看到修改后的配置
     */


    /**
     * 支持动态更新
     */
    ConfigurableApplicationContext applicationContext;
    public Service2Bootstrap(ConfigurableApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }


    /**
     * 通过value注解读取配置信息
     * 不支持动态更新
     */
    @Value("${common.name}")
    private String config1;

    /**
     * http://localhost:56020/configs
     * 这个不支持动态更新
     * @return
     */
    @GetMapping("/configs")
    public String getConfigs(){
        return applicationContext.getEnvironment().getProperty("common.name");
    }




    @GetMapping(value = "/configs2")
    public String getConfigs2(){
        String name = applicationContext.getEnvironment().getProperty("common.name");
        String age =  applicationContext.getEnvironment().getProperty("common.age");
        String address =  applicationContext.getEnvironment().getProperty("common.address");
        String birthday=  applicationContext.getEnvironment().getProperty("common.birthday");
        String fullname =  applicationContext.getEnvironment().getProperty("common.fullname");
        return name+"+"+ age+"+"+address+"+"+ birthday+"+"+ fullname;
    }


}
