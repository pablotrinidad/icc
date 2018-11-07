PROJECT_DIR=./src

cd $PROJECT_DIR

echo "Compiling source code"
javac icc/p13/*.java

if [ ! -f ../datos.txt ]; then
    echo "Missing data file at root directory!"
else
    echo "Running program:\n"
    java icc.p13.UsoEstadisticas ../datos.txt
fi
