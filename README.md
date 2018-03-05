###mybatis generator
only generate field comment

pom.xml
```
    <plugin>
        <groupId>org.mybatis.generator</groupId>
        <artifactId>mybatis-generator-maven-plugin</artifactId>
        <version>1.3.5</version>
        <configuration>
            <overwrite>true</overwrite>
        </configuration>
        <dependencies>
            <dependency>
                <groupId>com.ccciyo.mybatis</groupId>
                <artifactId>mybatis-generator-ex</artifactId>
                <version>1.0-SNAPSHOT</version>
                <scope>system</scope>
            </dependency>
        </dependencies>
    </plugin>
```

resources/generatorConfig.xml
```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE generatorConfiguration
        PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
        "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">

<generatorConfiguration>
    <classPathEntry location="/usr/local/repositories/maven/mysql/mysql-connector-java/5.1.44/mysql-connector-java-5.1.44.jar"/>

    <context id="DB2Tables" targetRuntime="MyBatis3Simple">
        <commentGenerator type="com.ccciyo.mybatis.CommentGenerator"/>
        <jdbcConnection driverClass="com.mysql.jdbc.Driver"
                        connectionURL="jdbc:mysql://127.0.0.1:3306/test"
                        userId="root"
                        password="root">
        </jdbcConnection>


        <javaTypeResolver>
            <property name="forceBigDecimals" value="true"/>
        </javaTypeResolver>

        <javaModelGenerator targetPackage="test" targetProject="/Users/ccciyo/workspace/test-spring-boot/src/main/java">
            <property name="enableSubPackages" value="true"/>
            <property name="trimStrings" value="true"/>
        </javaModelGenerator>

        <sqlMapGenerator targetPackage="test" targetProject="/Users/ccciyo/workspace/test-spring-boot/src/main/java">
            <property name="enableSubPackages" value="true"/>
        </sqlMapGenerator>

        <javaClientGenerator type="XMLMAPPER" targetPackage="test" targetProject="/Users/ccciyo/workspace/test-spring-boot/src/main/java">
            <property name="enableSubPackages" value="true"/>
        </javaClientGenerator>

        <table  tableName=""/>

    </context>
</generatorConfiguration>
```