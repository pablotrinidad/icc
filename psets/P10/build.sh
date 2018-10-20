#! /bin/bash

DIR_NAME=trinidadppablo10

# Create temp dir
mkdir $DIR_NAME

# Copy files to dir
cp -r src $DIR_NAME/
cp build.xml $DIR_NAME/
cp readme.txt $DIR_NAME/

# Remove junk files
rm -rf ./src/**/**/*.class

# Show folder structure
cd $DIR_NAME
tree .

# Create compressed file
cd ..
tar zcf $DIR_NAME.tar.gz $DIR_NAME/

# Delete temp dir
rm -rf $DIR_NAME/
