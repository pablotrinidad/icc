#! /bin/bash

PROJECT_FOLDER=./src

cd $PROJECT_FOLDER

# Delete old byte code objects
rm -rf icc/p03/*.class

# Compile source code
javac icc/p03/*.java

# Run executable
java icc.p03.Prueba

cd ../
