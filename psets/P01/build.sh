#! /bin/bash

mkdir -p build
cp -r P01 build/
cp -r assets build/
cp README.md build/
cp P01.tex build/
cp P01.pdf build/

tar czf trinidadpablo.tar.gz build

rm -rf build
