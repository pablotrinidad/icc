#! /bin/bash

PROJECT_FOLDER=./src

cd $PROJECT_FOLDER

# Delete old byte code objects
rm -rf icc/p04/*.class

# Compile source code
javac icc/p04/*.java

# Run executable
while read x; do
  java icc.p04.Primos $x
done < ../input.txt

cd ../
