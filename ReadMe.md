# 基于Spring-boot 和 elfinder 的在线文件管理系统

## 在konglinghai123的基础上做了修改，增加了一些功能
原git库地址如下：
https://github.com/konglinghai123/spring-elfinder

---

### 效果图
 <p align="center">
  <img width="900" src="https://github.com/panqixin16/project-images/blob/master/spring-elfinder/elfinder/elfinder.png?raw=true">
</p>

---

### 原有功能
- 支持在线文件下载
- 支持目录上传
- 支持zip tar Gzip 的在线解压和压缩文件夹
- 支持多种文本格式的高亮显示和在线编辑
- 支持在线文件预览
- 支持文件夹权限设置
- 支持国际化

---

### 新增功能
- 增加token验证，必须token正确才能访问elfinder进行文件管理
- 增加了appkey，多个不同目录时可以设置只显示管理其中的一个目录
- 增加获取文件列表的接口，可用于构建供外部用户使用的下载页面
- 添加了文件下载页面，网页使用vue+element构建，网站（dist）放置在resource/static目录下.(说明：目前直接运行spring-web项目无法访问dist中的文件下载页面，vue构建项目路径问题，后面再进行处理一下。但是部署到tomcat中运行是可以正常访问的，预览图见下面的war运行说明。)

---

### 配置 application.yml
```
token: mytoken

server:
  tomcat:
    uri-encoding: UTF-8
  port: 8181

spring:
  mvc:
    view:
      prefix: /
      suffix: .html
  resources:
    static-locations: classpath:static/
  http:
    encoding:
      charset: utf-8
      force: true
      enabled: true
    multipart:
      enabled: true
      max-file-size: -1

file-manager:
     thumbnail:
        width: 80 # 缩略图宽
     volumes:
        - Node:
          appkey: elfinder1
          source: fileSystem # 暂时只支持本地文件系统
          alias: elfinder1 # 目录别名
          path: /Users/twinkle/git/elfinder1 # 映射目录   D:/elfinder
          host: http://localhost:8899 #与映射目录下的相对路径拼接，host可以设置为相对地址，如/download
          _default: true # 是否默认打开
          locale:
          constraint:
            locked: false # 文件夹是否锁定
            readable: true # 是否可读
            writable: true # 是否可写
        - Node:
          appkey: elfinder2
          source: fileSystem # 暂时只支持本地文件系统
          alias: elfinder1 # 目录别名
          path: /Users/twinkle/git/elfinder2 # 映射目录   /D:/elfinder
          host: http://localhost:8898 #与映射目录下的相对路径拼接，host可以设置为相对地址，如/download
          _default: true # 是否默认打开
          locale:
          constraint:
            locked: false # 文件夹是否锁定
            readable: true # 是否可读
            writable: true # 是否可写
```

---

### 运行
#### 下载
```
git clone https://github.com/panqixin16/spring-elfinder.git
```
#### mvn
```
    mvn install
    cd spring-web
    mvn spring-boot:run
```
#### eclipse
```
    eclipse打开项目spring-elfinder
    spring-elfinder 右键项目选择Run As -> Maven Install
    spring-web 右键项目选择Run As -> Spring Boot App

```

访问地址：
- 管理所有的目录 http://localhost:8181/?token=mytoken#elf_A_
- 管理指定的目录 添加参数appkey（yml文件配置），http://localhost:8181/?appkey=elfinder1&token=mytoken#elf_A_

---
### war包部署运行
#### 下载
[war包下载页面](https://github.com/panqixin16/spring-elfinder/releases) -> Download -> Assets -> elfinder.war

#### 部署运行
- 将war包放入到tomcat的webapps目录下，启动tomcat即可

#### tomat部署访问地址
1. 需要带上项目名称elfinder
- 管理所有的目录 http://localhost:8080/elfinder?token=mytoken#elf_A_
- 管理指定的目录 添加参数appkey（yml文件配置），http://localhost:8080/elfinder?appkey=elfinder1&token=mytoken#elf_A_

2. vue-files-list： 文件下载里列表，供外部用户访问的
- 访问地址:  
    i. 以tree方式实现  
    http://localhost:8080/elfinder/dist/#/?appkey=elfinder1#elf_A_  
    预览图：  
    <p align="center">
       <img width="900" src="https://github.com/panqixin16/project-images/blob/master/spring-elfinder/vue-file-list/tree-list.png?raw=true">
    </p>
   ii. 以table展开树方式实现 

    http://localhost:8080/elfinder/dist/#/table?appkey=elfinder1#elf_A_ 

    预览图：
     <p align="center">
        <img width="900" src="https://github.com/panqixin16/project-images/blob/master/spring-elfinder/vue-file-list/table-list.png?raw=true">
    </p>

---
### 关于文件下载页面项目
文件下载页面使用vue+element构建，后面会放到github上。

