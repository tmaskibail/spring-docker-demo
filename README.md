#### Build Image
`docker build -t tmaskibail/spring-boot-docker .`

#### Run container
`docker run -p 8080:8080 -t tmaskibail/spring-boot-docker`

#### list process
`docker ps`

#### shutdown process
`docker stop <name/container id from previous command>`

#### delete container
`docker rm <>`

#### Use spring profile
`docker run -e "SPRING_PROFILES_ACTIVE=prod" -p 8080:8080 -t tmaskibail/spring-boot-docker`

#### Only on WINDOWS : Access app on container using JPDA
`docker run -e "JAVA_TOOL_OPTIONS=-agentlib:jdwp=transport=dt_socket,address=5005,server=y,suspend=n" -p 8080:8080 -p 5005:5005 -t tmaskibail/spring-boot-docker`
