PROJECT_DIR=./src

cd $PROJECT_DIR

echo "Compiling source code"
javac icc/p14/*.java

# if [ ! -f ../datos.txt ]; then
#     echo "Missing data file at root directory!"
# else
#     echo "Running program:\n"
#     java icc.p13.UsoMatrices ../datos.txt
# fi
