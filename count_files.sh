#!/bin/bash 

files_count=$(sudo find /etc -type f | wc -l) 
echo "Number of files in /etc directory: $files_count"
