# 一、什么是MyBatis-Plus
Mybatis是作为一个半自动的持久层ORM框架一直以其可以直接在XML中通过SQL语句操作数据库的灵活可控稳居持久层框架前列。但正其操作都要通过SQL语句进行，就必须写大量的xml文件，很是麻烦。而我们今天要介绍的Mybatis-Plus就是为了解决这些问题的。
Mybatis-Plus是一个 Mybatis 的增强工具，在 Mybatis 的基础上只做增强不做改变，为简化开发、提高效率而生（官方定义）。它已经封装好了一些crud方法，单表的增删改查可以不用在xml中写 sql 语句了，直接调用这些方法就行，就类似于JPA，使用 MyBatis-Plus 可以减少大量的开发时间。
# 二、使用Mybatis-Plus
## 2.1 添加依赖
```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.2.6.RELEASE</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <groupId>com.oycbest</groupId>
    <artifactId>springboot-ssm</artifactId>
    <version>1.0.1</version>
    <name>springboot-ssm</name>
    <description>Demo project for Spring Boot</description>

    <properties>
        <java.version>1.8</java.version>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
        <druid.version>1.1.9</druid.version>
        <mybatis-plus.version>3.1.2</mybatis-plus.version>
        <mybatisplus-spring-boot-starter.version>1.0.5</mybatisplus-spring-boot-starter.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <scope>runtime</scope>
        </dependency>

        <!-- druid -->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>${druid.version}</version>
        </dependency>
        <!-- Mybatis-plus -->
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatisplus-spring-boot-starter</artifactId>
            <version>${mybatisplus-spring-boot-starter.version}</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/com.baomidou/mybatis-plus -->
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-boot-starter</artifactId>
            <version>${mybatis-plus.version}</version>
        </dependency>
        <!-- 这是mybatis-plus的代码自动生成器 -->
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-generator</artifactId>
            <version>${mybatis-plus.version}</version>
        </dependency>
       <!-- lombok 可以为我们生产getter、setter、构造方法、toString方法等-->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
        </dependency>
    </dependencies>
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>
```
## 2.2 编写MyBatis-plus配置
```
/**
 * @Description: Mybatis-Plus配置类
 * @Author oyc
 * @Date 2020/4/29 7:46 下午
 */
@EnableTransactionManagement
@Configuration
//扫描的mapper文件路径
@MapperScan(value = "com.oycbest.ssmblog.mapper")
public class MybatisPlusConfig {
    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
```
## 2.3 编写代码
让service、mapper分别继承Mybatis-Plus定义好的基础实现
（1） mapper
```
/**
 * (SsmUser)表数据库访问层
 *
 * @author oyc
 * @since 2020-04-28 23:21:52
 */
public interface SsmUserMapper extends BaseMapper<SsmUser> {
}
```
（2）service接口
```
/**
 * (SsmUser)表服务接口
 *
 * @author oyc
 * @since 2020-04-28 23:21:53
 */
public interface SsmUserService extends IService<SsmUser> {
}
```
（3）service实现类
```
/**
 * (SsmUser)表服务实现类
 *
 * @author oyc
 * @since 2020-04-28 23:21:54
 */
@Service("ssmUserService")
public class SsmUserServiceImpl extends ServiceImpl<SsmUserMapper, SsmUser> implements SsmUserService {
}
```
（4）controller 调用service中的基础方法完成数据的crud
```
package com.oycbest.ssmblog.controller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oycbest.ssmblog.domain.SsmUser;
import com.oycbest.ssmblog.service.SsmUserService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
/**
 * (SsmUser)表控制层
 *
 * @author oyc
 * @since 2020-04-28 23:24:43
 */
@RestController
@RequestMapping("ssmUser")
public class SsmUserController {
    /**
     * 服务对象
     */
    @Resource
    private SsmUserService ssmUserService;
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity selectOne(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(ssmUserService.getById(id));
    }
    /**
     * 列表数据
     *
     * @return 列表数据
     */
    @GetMapping
    public ResponseEntity list(SsmUser user,
                               @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                               @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        Page<SsmUser> page = new Page<>(pageNo, pageSize);
        QueryWrapper<SsmUser> wrapper = new QueryWrapper<>();
        wrapper.setEntity(user);
        IPage<SsmUser> pageList = ssmUserService.page(page, wrapper);
        return ResponseEntity.ok().body(pageList);
    }
    /**
     * 列表数据
     *
     * @return 列表数据
     */
    @GetMapping("list")
    public ResponseEntity list() {
        return ResponseEntity.ok().body(ssmUserService.list());
    }
    /**
     * 修改数据
     *
     * @param ssmUser 实例对象
     * @return 实例对象
     */
    @PostMapping
    public ResponseEntity save(SsmUser ssmUser) {
        return ResponseEntity.ok().body(ssmUserService.save(ssmUser));
    }
    /**
     * 新增或修改数据
     *
     * @param ssmUser 实例对象
     * @return 实例对象
     */
    @PutMapping
    public ResponseEntity saveOrUpdate(SsmUser ssmUser) {
        return ResponseEntity.ok().body(ssmUserService.saveOrUpdate(ssmUser));
    }
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Delete("{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(ssmUserService.removeById(id));
    }
}
```
