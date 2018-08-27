#! /bin/bash

PROJECT_FOLDER=./P02

# Compile source code
cd $PROJECT_FOLDER/src
javac icc/primitivos/*.java

# Run executable
java icc.primitivos.UsoImpresora

cd ../../

