### 引入Hibernate的外键依赖
* 个人认为这是这个demo中一个败笔，因为引入了外键依赖，需额外引入一个配置类JpaConfiguration，其中配置有数据源（datasoure）、适配器（jpaVendorAdapter）以及实体管理工厂（entityManagerFactory），配置显得较为繁琐
* 后面在JPA的使用中，一开始将获取策略设置为懒加载模式，后面写逻辑过程有遇到了很大问题，不得已设置成饥饿加载模式。总之，`慎用外键依赖`
### 日志的引入
* 在弃用boot自带的logging日志框架后，自己引入了log4j日志，pom文件为
``` java
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter</artifactId>
	<!--去除boot默认使用的loging日志，改用log4j日志-->
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
* 注意，有些网站代码引入的依赖为log4j2，最后发现并没用

### 基于注解的权限管理
* 在annotation包中添加了一个`PermissionEnum`枚举类型，里面饱含了可能出现的各种角色，并定义了一个`SelfPermitition`注解
* 在拦截器中获取到controller层方法前SelfPermission注解中的值，之后再与用户所对应权限比对是否符合
``` java
<!--o为传入的object对象-->
HandlerMethod handlerMethod = (HandlerMethod)o;
SelfPermission selfPermitition = handlerMethod.getMethodAnnotation(SelfPermission.class);
```
### 拦截器的实现
* 在config包中的InteceptorConfig类中定义了拦截规则并注册了拦截器，拦截器的具体实现是在interceptor包下的URLInteceptor类中。
### 全局异常的捕获
* 有些导致业务代码出现问题的情况我们是不需要将确切的错误信息返回给用户的，而是只需要将其记入日志，之后我们对系统进行改进或者修改bug时可参照日志进行完善。
* 在exception包下自定义了各种异常（继承RuntimeException）
* 之后在service层对异常进行抛出，并在ExceptionController类中根据@ExceptionHandler注解对异常进行精确捕获。
* 进入异常对应的处理逻辑后，将异常对应的信息记入日志
