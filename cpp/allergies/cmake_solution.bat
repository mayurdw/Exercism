set /p ex_file=Enter name of the file:
copy NUL %ex_file%.cpp
copy NUL %ex_file%.h
cmake -G "Visual Studio 15 2017 Win64"