#/bin/bash

JAVAFX_PATH=~/.java/libraries/javafx-sdk-11.0.1/lib
MAIN_CLASS=Main
PACKAGE_NAME=app

SRC_DIRECTORY=src

# Verify JavaFX is present
if [ ! -d $JAVAFX_PATH ]; then
    echo "MISSING JavaFX SDK!!"
    echo "Please move the JavaFX SDK to $JAVAFX_PATH"
    echo "or edit the JAVAFX_PATH variable in this script with the right location."
    return 1
fi

# Move to the source code folder
cd $SRC_DIRECTORY

# Compile application
echo "Compiling application..."
javac \
    --module-path $JAVAFX_PATH \
    --add-modules=javafx.controls \
    --add-exports=javafx.base/com.sun.javafx.collections=ALL-UNNAMED \
    $PACKAGE_NAME/*.java

echo "Starting application..."
# Run application
java \
    --module-path $JAVAFX_PATH \
    --add-modules=javafx.controls \
    --add-exports=javafx.base/com.sun.javafx.collections=ALL-UNNAMED \
    $PACKAGE_NAME.$MAIN_CLASS

cd ..
