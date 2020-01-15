#!/usr/bin/env bash

docker run --name sftp -p 2222:22 -v /home/perkele/Desktop/test/ftp:/data/incoming -d -P writl/sftp