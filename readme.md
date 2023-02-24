# Semester 6 | Advanced Java Practicals

--- 

## Editing the project :

`webapps` folder contains practical files named per practical number and their respective servlets are in `WEB-INF/src/<package-name>/<class>.java` files

### To make a new practical:
- create a new folder in `webapps/`
- add classes in `WEB-INF/src/<package-name>/<class>.java`
- compile using `ant` build system command

  > \* make sure to include build.xml in the new folder else `ant` wont compile 
--- 

## Running the server
### linux: 
```
./bin/catalina.sh run
```

### windows:
```
./bin/catalina.bat run
```

and your server should be started on port `8080`


--- 


or just use eclipse and copy the code, who cares :P