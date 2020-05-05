#一、什么是Swagger
        由于Spring Boot能够快速开发、便捷部署等特性，相信有很大一部分Spring Boot的用户会用来构建RESTful API。由于存在多终端的情况（移动端，web前端，小程序等），所以我们会抽象出RESTful API并共用一些底层业务代码。 

       由于接口众多，并且细节复杂，所以催生了一些api框架，Swagger就凭借其使用简单、实时更新等特点脱颖而出。Swagger可以轻松的整合到Spring Boot中，并与Spring MVC程序配合组织出强大RESTful API文档。它既可以减少我们创建文档的工作量，同时说明内容又整合入实现代码中，让维护文档和修改代码整合为一体，可以让我们在修改代码逻辑的同时方便的修改文档说明。另外Swagger2也提供了强大的页面测试功能来调试每个RESTful API。

使用SwaggerHub，您可以：

以OpenAPI格式定义您的API。

将所有API定义托管在一个地方。

将常见的API组件（例如数据模型和响应）存储在域中，并从API定义中引用它们。

与您的团队就API定义进行协作。

生成服务器和客户端代码，并将其推送到GitHub，GitLab，Bitbucket或Azure DevOps Services。

公开和私下共享您的API。

迭代API设计并管理多个API 版本。

#二、在SpringBoot中使用Swagger
##2.1 在pom中添加swagger的依赖

要使用swagge，我们首先需要在项目的pom中添加swagger依赖（这里使用的是maven构建，如果是gradle请在build.gradle中添加）。我们需要添加的依赖主要有两个，分别是swagger和swagger-ui，如果要使用其他功能(如接口文档导出)还需要引入对应的包。

<!--swagger API获取-->
<dependency>
	<groupId>io.springfox</groupId>
	<artifactId>springfox-swagger2</artifactId>
	<version>2.9.2</version>
</dependency>
<!--swagger-ui API获取-->
<dependency>
	<groupId>io.springfox</groupId>
	<artifactId>springfox-swagger-ui</artifactId>
	<version>2.9.2</version>
</dependency>

##2.2 添加swagger配置类

创建SwaggerConfig.java类

package com.oycbest.springbootswagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Description: swagger 配置类
 * @Author oyc
 * @Date 2020/5/5 3:47 下午
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * 创建API
     */
    @Bean
    public Docket createRestApi() {
        // 指定扫描包路径
        return new Docket(DocumentationType.SWAGGER_2) // 指定生成的文档的类型是Swagger2
//                .pathMapping("/swagger")
                // 用来创建该API的基本信息，展示在文档的页面中（自定义展示的信息）
                .apiInfo(apiInfo()) // 配置文档页面的基本信息内容
                // 设置哪些接口暴露给Swagger展示
                .select()
                // 扫描所有有注解的api，用这种方式更灵活
                //.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .apis(RequestHandlerSelectors.basePackage("com.oycbest.springbootswagger.controller"))
                // 扫描所有 .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any()).build();
    }

    /**
     * 添加摘要信息
     */
    private ApiInfo apiInfo() {
        // 用ApiInfoBuilder进行定制
        return new ApiInfoBuilder()
                // 设置标题
                .title("描述：Spring Boot中使用Swagger2构建RESTful APIs")
                // 描述
                .description("swagger 测试demo")
                // 作者信息
                .contact("oyc")
                .termsOfServiceUrl("http://www.oycyqr.xyz")
                // 版本
                .version("版本号:" + "1.0.1")
                .build();
    }
}
@Configuration 配置类，启动时加载此类
@EnabledSwagger2 标识项目启动 SwaggerApi 文档
ApiInfo 这个类时Swagger 页面展示的一些基础信息
RequestHandlerSelectors.basePackage("com.oycbest.springbootswagger.controller“) 这里的com.oycbest.springbootswagger.controller是扫描包的路径

##2.3 在controller中添加swagger接口注解

package com.oycbest.springbootswagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 测试swagger controller
 * @Author oyc
 * @Date 2020/5/5 3:43 下午
 */
@RestController
@Api(tags = "SwaggerController", description = "SwaggerController | 测试swagger")
@RequestMapping("api")
public class SwaggerController {


    @GetMapping("hello")
    @ApiOperation(value="hello 方法", notes="hello Swagger测试方法--hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("test1")
    @ApiOperation(value="test1 方法", notes="hello Swagger测试方法--test1")
    public String test1(){
        return "test1";
    }

    @GetMapping("test2")
    @ApiOperation(value="test2 方法", notes="hello Swagger测试方法-test2")
    public String test2(){
        return "test2";
    }
}

@Api 修饰类，可以描述这个类的作用。
@ApiOperation 修饰方法，可以描述这个方法的功能和注意事项。若不使用则用函数名作为方法功能。
@ApiImplicitParams 修饰方法，可以描述这个方法的参数的作用。若不使用则用参数名作为参数的作用。
@ApiModel 修饰实体类，可以描述这个类的功能。
@ApiModelProperty 修饰实体类的属性，可以描述这个属性的作用。
@ApiIgnore 修饰参数、方法和类，可以在自动生成文档时对修饰的对象进行忽略。

##2.4 查看&测试接口

如果没有引入安全框架或设置路径拦截机制，可以直接访问 http://127.0.0.1:8080/[项目名称]/swagger-ui.html查看接口。

接口列表：



测试接口：



源码地址：

