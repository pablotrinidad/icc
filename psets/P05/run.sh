#! /bin/bash

PROJECT_FOLDER=./src

cd $PROJECT_FOLDER

# Delete old byte code objects
rm -rf icc/recursion/*.class

# Compile source code
javac icc/recursion/*.java

# Run executable
printf "Running program with input\n"
java icc.recursion.Euclides 1190 476
printf "\n\nRunning program without input\n"
java icc.recursion.Euclides

cd ../
