#! /bin/bash

DIR_NAME=trinidadppablop02

# Create temp dir
mkdir $DIR_NAME

# Copy files to dir
cp -r src $DIR_NAME/
cp run.sh $DIR_NAME/
cp README.md $DIR_NAME/

# Delete compiled files
rm ./$DIR_NAME/src/app/*.class
rm ./$DIR_NAME/src/simulations/*.class
rm ./$DIR_NAME/src/simulations/**/*.class


# Show folder structure
cd $DIR_NAME
tree .

# Create compressed file
cd ..
tar zcf $DIR_NAME.tar.gz $DIR_NAME/

# Delete temp dir
rm -rf $DIR_NAME/
