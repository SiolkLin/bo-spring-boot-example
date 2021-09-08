# BO Spring Boot Example Maven Project
## 一、環境安裝
### 1.安裝Open JDK8
https://adoptopenjdk.net/

### 2.下載/安裝 Eclipse IDE for Enterprise Java Developers
https://www.eclipse.org/downloads/packages/release/2020-06/r

### 3.Eclipse 安裝 Lombok 
#### 3.1.下載網址
https://projectlombok.org/download
#### 3.2.教學
https://matthung0807.blogspot.com/2019/09/eclipse-lombok-installation.html

## 二、匯入範例專案
### 1.Eclipse Import BO Spring Boot 範例專案
```sh
#Step1.
Eclipse主選單：File -> Import -> Existing Maven Project

#Step2.
透過Root Directory旁邊的「Browse...」按鈕，選到專案目錄

#Step3.
點擊Finish按鈕

#Step4.
Eclipse 右下角會有進度條，需等待至library下載完畢
```

### 2.更改BO IP
```sh
#Step1.找到設定檔案
src\main\resources\application.properties

#Step2.修改BO IP
spring.datasource.url = jdbc:mysql://%你的IP%/bigobject
```

### 3.建立測試資料(可使用MYSQL Client...等工具建立資料)
```sh
src\main\resources\db\example\example.sql
```

### 4.更新Eclipse專案
```sh
# 有修改到設定檔，皆建議此操作
範例專案右鍵 -> Maven -> Update Project...
```

### 5.啟動Spring Boot
```sh
#Step1.找到Spring Boot應用程式進入點
src\main\java\io\bigobject\demo\BoExampleApplication.java

#Step2.執行主程式
點擊工具列Run旁邊的小箭頭-> Run As -> Java Application
```

### 6.測試SQL
http://127.0.0.1:8080/



## 三、疑難排解
### IndexService出現紅色毛毛蟲
有可能Lombok導入不正常，導致setter出現紅色毛毛蟲，可註解程式碼或自行加上setter
