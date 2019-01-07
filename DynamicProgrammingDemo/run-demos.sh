#!/bin/bash

file1="RodCutting.class"

if [ -f "$file1" ]; then
	rm "$file1"
fi

javac RodCutting.java
java RodCutting


rm "$file1"