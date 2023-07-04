# websphereDecrypt
Let's you decrypt {aes} passwords, based on com.ibm.websphere.crypto.PasswordUtil

```bash
cd ~ ; wget https://download.java.net/java/GA/jdk11/9/GPL/openjdk-11.0.2_linux-x64_bin.tar.gz
tar xf openjdk-11.0.2_linux-x64_bin.tar.gz
wget https://download.java.net/java/GA/jdk11/9/GPL/openjdk-11.0.2_linux-x64_bin.tar.gz
export JAVA_HOME=~/jdk-11.0.2
mvn liberty:run
```

```bash
$ curl localhost:9080/encode --data-urlencode "key=random_key" --data-urlencode "pwd=decoded_password" -s | jq -r .
{
  "decoded": "decoded_password",
  "key": "random_key",
  "encoded": "{aes}AJBArJLIU1Jx0vtBsdPwaNioLIYNXFTQHJEcli8cLK1xBTKKpjCFpkMUBj/W0L2nBg=="
}
```

```bash
$ curl localhost:9080/decode --data-urlencode "key=random_key" --data-urlencode "pwd={aes}AJBArJLIU1Jx0vtBsdPwaNioLIYNXFTQHJEcli8cLK1xBTKKpjCFpkMUBj/W0L2nBg==" -s | jq -r .
{
  "decoded": "decoded_password",
  "key": "random_key",
  "encoded": "{aes}AJBArJLIU1Jx0vtBsdPwaNioLIYNXFTQHJEcli8cLK1xBTKKpjCFpkMUBj/W0L2nBg=="
}
```
