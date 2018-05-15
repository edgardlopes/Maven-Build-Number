# Maven-Build-Number
Exemplo em Java para gerar um número sequencial a cada build

Foi usado o plugin [Build Number Maven Plugin](https://www.mojohaus.org/buildnumber-maven-plugin/)

Para gerar um número sequencial a cada build é necessário adicionar a seguinte configuração no **pom.xml**

```xml
<build>
  <finalName>${project.artifactId}-${project.version}-${buildNumber}</finalName>
  <plugins>   
    <plugin>
      <groupId>org.codehaus.mojo</groupId>
      <artifactId>buildnumber-maven-plugin</artifactId>
      <version>1.4</version>
      <executions>
        <execution>
          <id>buildnumber</id>
          <phase>validate</phase>
          <goals>
            <goal>create</goal>
          </goals>
        </execution>
      </executions>
      <configuration>
        <format>{0,number}</format>
        <items>
          <item>buildNumber</item>
        </items>                    
        <doCheck>false</doCheck>
        <doUpdate>false</doUpdate>
        <revisionOnScmFailure>unknownbuild</revisionOnScmFailure>   
      </configuration>
    </plugin>   
  </plugins>
</build>
<!-- É Obrigatorio configurar uma conexão SCM, podendo ser ficticia caso não possua uma -->
<scm>
  <connection>scm:svn:http://127.0.0.1/dummy</connection>
  <developerConnection>scm:svn:https://127.0.0.1/dummy</developerConnection>
  <tag>HEAD</tag>
  <url>http://127.0.0.1/dummy</url>
</scm>
```

Feito isso a cada build do projeto será disponibilizada a variável **buildNumber** que pode ser referenciada no **pom.xml**
ou em outras partes do projeto
```xml
    <!--pom.xml-->
    <finalName>${project.artifactId}-${project.version}-${buildNumber}</finalName>
```
```properties
  #application.properties
  build.number=@buildNumber@
```
