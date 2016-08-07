# lg4j
Java library for controlling LG TVs based on https://github.com/ubaransel/lgcommander

```java
Lg4j lg4j = new Lg4j();
String ip = lg4j.discoverIpAddress();
lg4j.displayAuthenticationKey(ip);
int session = lg4j.authenticate(ip, 674689);
lg4j.sendKey(ip, KeyCodes.VOLUME_DOWN);
```

For more information see:

http://www.adrianwalker.org/2016/08/lg4j-java-library-for-controlling-lg-tvs.html
