#### 关于Spring BOOT与Data JPA整合的一个小demo，出了比较大问题的地方是在使用了外键约束后提示需要配置entityManagerFactory，无奈从官网copy了config目录下的JpaConfiguration.java文件，该文件配置了dataSource数据源等信息