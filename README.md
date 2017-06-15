### 引入Hibernate的外键依赖
* 个人认为这是这个demo中一个败笔，因为引入了外键依赖，需额外引入一个配置类JpaConfiguration，其中配置有数据源（datasoure）、适配器（jpaVendorAdapter）以及实体管理工厂（entityManagerFactory），配置显得较为繁琐
* 后面在JPA的使用中，也会因为外键的获取策略而出现问题，不得已设置成饥饿加载模式，在后面的代码中带来了不便。总之，`慎用外键依赖`
### 日志的引入
* 在弃用boot自带的logging日志框架后，自己引入了log4j日志，pom文件为
``` java
<!--去除boot自带的loging日志，改用log4j日志-->
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter</artifactId>
<exclusions>
	<exclusion>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-logging</artifactId>
	</exclusion>
</exclusions>
</dependency>

<!--导入log4j日志，log4j2依赖则无效-->
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-log4j</artifactId>
<version>1.3.6.RELEASE</version>
</dependency>
```
* 注意，有些网站引入log4j2依赖依然有用，但自己试后发现并非如此

### 基于注解的权限管理
* 在annotation包中添加了一个`PermissionEnum`枚举类型，里面饱含了可能出现的各种角色，并定义了一个`SelfPermitition`注解
* 在拦截器中获取到controller层注解中的值，之后再与用户所对应权限比对是否符合
``` java
<!--o为传入的object对象-->
HandlerMethod handlerMethod = (HandlerMethod)o;
SelfPermission selfPermitition = handlerMethod.getMethodAnnotation(SelfPermission.class);
```
### 拦截器的实现
* 在config包中的InteceptorConfig类中定义了拦截规则并注册了拦截器，拦截器的具体实现是在interceptor包下的URLInteceptor类中。
