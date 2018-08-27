#! /bin/bash

PROJECT_FOLDER=./P02

cd $PROJECT_FOLDER/src

# Delete old byte code objects
rm -rf icc/primitivos/*.class

# Compile source code
javac icc/primitivos/*.java

# Run executable
printf "Ejecutando UsoImpresora:\n"
java icc.primitivos.UsoImpresora

printf "\n\n\n\nEjecutando Vilchis:\n\n"
java icc.primitivos.Vilchis

cd ../../
