# SpringIntegration-SFTP-Docker-Example
Example of usage Spring Integration with dockerized sftp server.

# Stack:

- SpringBoot, Spring Integration
- Docker, Docker compose
- SFTP server docker image

# Launching:

- Go to the project root folder
- Launch ```bldAll.sh``` script

To connect to SFTP server [docker container], You should get IP address of Your SFTP container.
To do this, run ```getDockerContainerIPAddresses.sh``` script, from ```src/main/resources/scripts``` 
folder.


|           |Credentials:| 
|-----------|------------|
| Login     |    sftp    |
| Password  | c83eDteUDT |


To upload test file to sftp server, goto ```localhost:8080/test```.

Folder ```fileuploaddownload``` contains additional examples.
