### 引入Hibernate的关联映射
* 前期代码中，实体间采用了@ManyToOne关联映射，但后期发现，在实体较多时，懒加载策略会出现问题，所以不得已采用饿汉模式进行实体间的加载，这就会使得查询出来的实体过于庞大，且较多数据都不是我们所需要的。
* 因此，现在版本的代码中，这个问题得以纠正，但关联映射所需要的实体管理工厂（entityManagerFactory）仍保留在配置类JpaConfiguration中
* 总之，`慎用关联映射`
### 日志的引入
* 在弃用boot自带的logging日志框架后，自己引入了log4j日志，并对日志信息进行了一些配置，详见log4j.properties，pom文件为
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
* 在config包中的InteceptorConfig类中定义了拦截规则并注册了拦截器。
* 具体拦截实现是在interceptor包下的URLInteceptor类中对用户的登录状态以及权限进行了控制。
### 全局异常的捕获
* 有些导致业务代码出现问题的情况我们是不需要将确切的错误信息返回给用户的，而是只需要将其记入日志，之后我们对系统进行改进或者修改bug时可参照日志进行完善。
* 在exception包下自定义了各种异常（继承RuntimeException）
* 之后在service层对异常进行抛出，并在ExceptionController类中根据@ExceptionHandler注解对异常进行精确捕获。
* 进入异常对应的处理逻辑后，将异常对应的信息记入日志
### 下一步计划配置多数据源
