######    &emsp;&emsp;    关于Spring BOOT与DataJPA整合的一个小demo，出了比较大问题的地方是在使用了外键约束后提示需要配置entityManagerFactory，无奈从官网copy了config目录下的JpaConfiguration.java文件，该文件配置了dataSource数据源等信息   </font>
+  引入Hibernate的外键依赖
 - 个人认为这是这个demo中一个败笔，因为引入了外键依赖，需额外引入一个配置类JpaConfiguration，其中配置有数据源（datasoure）、适配器（jpaVendorAdapter）以及实体管理工厂（entityManagerFactory），配置显得较为繁琐
 - 后面在JPA的使用中，也会因为外键的获取策略而出现问题，不得已设置成饥饿加载模式，在后面的代码中带来了不便。总之，`慎用外键依赖`    
+ 日志的引入
  - 在弃用boot自带的logging日志框架后，自己引入了log4j日志，pom文件为
  - 注意，有些网站引入log4j2依赖依然有用，但自己试后发现并非如此  
+ 基于注解的权限管理
 -  在annotation包中添加了一个`PermissionEnum`枚举类型，里面饱含了可能出现的各种角色，并定义了一个`SelfPermitition`注解
+ 拦截器的实现
  