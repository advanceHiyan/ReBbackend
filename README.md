# 北京航空航天大学数据库大作业-禮棠訂箴读书系统后端
这是北京航空航天大学数据库大作业的一部分。
我们做了禮棠訂箴读书系统，本人负责后端。
## 数据库设计
见"**数据库实现报告.pdf**"
## 项目环境
详情**请见pom.xml**
后端框架spring boot
```
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.3.5</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
```
mybatis版本：
```
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>3.0.3</version>
        </dependency>
```
项目管理为Maven3.9.9
jdk23.0.1
数据库是华为高斯DB。
数据库版本类型：TaurusDB。
目前lombok和Maven存在一定的冲突导致@Data无法实现。
![86bb7e6a2917b2552a6946a47c6aa20](https://github.com/user-attachments/assets/bb8efbb0-8acd-431e-a87f-eaa63b4d6916)
## 如何复现
### 一、下载idea专业版2024.2.3
如果想要复现，必须使用专业版idea，尽量和这个版本一致，不然可能会出现版本不匹配导致的bug
https://www.jetbrains.com/zh-cn/idea/download/other.html
![image](https://github.com/user-attachments/assets/28924bb2-820a-442c-97af-81aeb06089d9)
### 二、安装配置Maven3.9.9
参照下面这个博客
https://blog.csdn.net/u012660464/article/details/114113349
你需要做到：
- 安装Maven
- 设置系统变量
- 在settings.xml配置本地仓库和阿里云远程仓库
- 学习Maven的基本用法。
### 三、使用ssh密钥克隆本项目至本地。
![image](https://github.com/user-attachments/assets/6cff5989-4143-435c-8edb-25f437c0d77c)

### 四、配置idea
（1）安装插件：lombok
![image](https://github.com/user-attachments/assets/9bfaec14-df07-4296-88ec-04c680f6398e)
（2）配置idea的Maven设置，重写用户设置文件和本地仓库。
![image](https://github.com/user-attachments/assets/c07e705c-f5ec-45e7-a78e-4f86deeaf90d)
（3）安装jdk23.0.1
![image](https://github.com/user-attachments/assets/d330967e-f123-4749-bd29-4803a8ee86ee)
（4）点击pom.xml看看有没有报错。
如果有报错，点击这里：Maven的刷新键，会自动下载缺失的依赖。
![image](https://github.com/user-attachments/assets/74b20b9b-ce68-4e11-b5ee-ebfb3d0fc932)

### 五、数据库配置
如果你用MySQL，请自主配置src/main/resources/application.properties或者src/main/resources/application.yml
如果你用高斯DB，先按照这个教程配置本地证书：
https://support.huaweicloud.com/intl/zh-cn/usermanual-gaussdbformysql/gaussdbformysql_02_0018.html
注意keytool.exe用jdk的，详情看你自己电脑上的jdk安装目录。
![b3cf005eceea5e0a293812dc5f19e57](https://github.com/user-attachments/assets/438426bd-9bae-4113-aa73-e0da240d8f59)
这三个参数都用false。
然后看src/main/resources/application.properties
![image](https://github.com/user-attachments/assets/46e16016-4de2-476a-bfac-ff36c60cd774)
点击左上角的木桶，看能不能连上。能连上就成功了。
当这个仓库公开后我的高斯DB账号应该就过期了，所以不怕泄露账号密码。

### 六、如何使用。
运行com/readbook/readbookbackend/ReadBookBackendApplication.java即可。
### 七、项目源代码说明
Controller控制层，和前端交互。调用Service层方法
![image](https://github.com/user-attachments/assets/3022bcb1-2cd2-41fd-a617-1f0ca376ae5d)
Service层，具体逻辑实现，调用Mapper层和数据库连接。
![image](https://github.com/user-attachments/assets/cd33922f-2b58-4d36-9df4-7b89f80c89c4)
Mapper层，和数据库交互，前提是你配好了src/main/resources/application.properties或者src/main/resources/application.yml
每个Mapper接口可以有一个对应的xml
![image](https://github.com/user-attachments/assets/058bebe3-640c-4778-8b43-15145b4f2e7a)
pojo：数据库的表的实体类
![image](https://github.com/user-attachments/assets/8ecafdfc-17c8-4fd5-9d27-cbda77d4e614)
utils和前端交互的类，有实体类，有result封装，有拦截器，有Jwt生成。
![image](https://github.com/user-attachments/assets/cd019504-c913-426e-8a92-6f3b93956b31)











