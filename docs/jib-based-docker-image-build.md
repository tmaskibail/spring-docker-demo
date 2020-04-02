## Build Image using JIB 
I use Docker Desktop on Mac and hence use the native Docker deamon to build the code instead of the Maven plugin

`mvn compile jib:dockerBuild`

* Uses date and timestamp as the tag for each build 

**Note:** 
* As of current version, jib doesn't load spring config file onto the path. 
* One might have to run the image manually using below : 
`docker run -e "spring.config.location=/secrets/application.yml" -v /local/path/config/:/secrets/ IMAGE:1.0`

