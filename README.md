## Ref-Level-fun
一個以閾限空間風格主題的簡易網頁小遊戲，完成度低。

## Features
- 可以註冊登入
- 多張地圖
- 怪物戰鬥系統
- 等級系統

## Building

#### 建立 Docker Image
```sh
mvnw package dockerfile:build
```

#### 啟動容器
```sh
docker run -p 8080:8080 fubuki/reflevelfun
```