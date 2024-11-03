# HmacSha256
使用 maven-jar-plugin 插件,直接在idea中package 打包

打包完成后通过以下命令得到结果
``` shell
java -jar HmacSha256-1.0.jar 0 021
140f87accbc0b2bb280ccd7630dc304c5bc23e7aaa50ebf8281366be28450668
```


# HmacSha256-jdk5
进到 \HmacSha256-jdk5\src> 目录
先检查java命令版本 确认配置的是 java 1.5
``` shell
HmacSha256-jdk5\src> java -version
java version "1.5.0"
Java(TM) 2 Runtime Environment, Standard Edition (build 1.5.0-b64)
Java HotSpot(TM) Client VM (build 1.5.0-b64, mixed mode, sharing)

HmacSha256\HmacSha256-jdk5\src> javac .\HmacSha256.java
HmacSha256\HmacSha256-jdk5\src> jar cvf HmacSha256-jdk5.jar .\HmacSha256.class
标明清单(manifest)
增加：HmacSha256.class(读入= 1657) (写出= 968)(压缩了 41%)
HmacSha256\HmacSha256-jdk5\src> java -cp HmacSha256-jdk5.jar HmacSha256 0 021
140f87accbc0b2bb280ccd7630dc304c5bc23e7aaa50ebf8281366be28450668
```