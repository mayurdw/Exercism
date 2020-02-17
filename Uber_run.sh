#!/bin/bash

echo "A single run file which one has to run after downloading an exercise from exercism.io
This script will uncomment all tests, run all tests and open the c file in Visual Studio Code. 
After the file is closed from visual studio, the script assumes that all work is done. 
It deletes all the folders from Users directory, because it assumes there was always only a single folder there."

EXERCISE_HOME=users/*/*/*
bash ./exercism_mentor_ignore.sh comment ${EXERCISE_HOME}/test/*.c
make -C ${EXERCISE_HOME}
code -w ${EXERCISE_HOME}/src/*.* 