#! /bin/bash

DIR_NAME=trinidadppablo03

# Create temp dir
mkdir $DIR_NAME

# Copy files to dir
cp -r src $DIR_NAME/
cp build.xml $DIR_NAME/
cp readme.txt $DIR_NAME/
cp P03.pdf $DIR_NAME/

# Test project runs
cd $DIR_NAME/
ant compile && ant run && ant clean

# Remove junk files
rm -rf ./src/**/**/*.class

# Show folder structure
tree .

# Create compressed file
cd ..
tar zcf $DIR_NAME.tar.gz $DIR_NAME/

# Delete temp dir
rm -rf $DIR_NAME/
