#!/bin/bash

#removes old .class files before compiling
#compiles all java files and runs the Main file 

rm -f *.class
javac *.java
java Main
