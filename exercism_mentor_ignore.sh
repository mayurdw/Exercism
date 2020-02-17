#!/bin/bash

#usage: ./exercism_mentor_ignore.sh $function $filename
# where $function is either comment or uncomment,
# and $filename the path to the test file.

if [ -z "$1" ]
	then echo "Function not supplied, tell either comment or uncomment"
	exit
fi

if [ -z "$2" ]
	then echo "Filename not supplied"
	exit
fi

COMMENTTYPE_DOUBLE_SLASH='\/\/'
COMMENTTYPE_HASH='\#'

#Feel free to add more comment type if necessary.

C_TEST_IGNORE='TEST_IGNORE'
PYTHON_TEST_IGNORE='unittest.skip\(.*\)'

#Above is the list of function calls to ignore a test, in c, it is TEST_IGNORE().

function comment() {
	case $1 in
		*.c)
			sed -i "/$C_TEST_IGNORE/s/^/$COMMENTTYPE_DOUBLE_SLASH/g" $1 ;;
		#add between the hashtags your file format, and copy-paste the above sed command with the appropriated comment type.
		*.py)
			sed -i "/$PYTHON_TEST_IGNORE/s/^/$COMMENTTYPE_HASH/g" $1 ;;
		#
		*)
			echo "not a valid file" >> /dev/stderr;;
	esac
}

function uncomment() {
	case $1 in
		*.c)
			sed -i "/$C_TEST_IGNORE/s/^$COMMENTTYPE_DOUBLE_SLASH*//g" $1;;
		#add between the hashtags your file format, and copy-paste the above sed command with the appropriated comment type.
		*.py)
			sed -i "/$PYTHON_TEST_IGNORE/s/^$COMMENTTYPE_HASH*//g" $1;;
		#
		*)
			echo "not a valid file" >> /dev/stderr;;
	esac
}

"$@"
