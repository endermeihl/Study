#!/bin/bash
testuser=ender2
if grep $testuser /etc/passwd
then
	echo "This is my first command"
	echo "This is my second command"
	echo "I can even put in other commands besides echo:"
	ls -a /home/$testuser/.b*
	echo
else
	echo "The user $testuser does not exist on this sysdtem."
	echo 
fi
