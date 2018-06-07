/*
    Author: Mayur Wadhwani

    Created: June 2018

*/

#ifndef ANAGRAM_H
#define ANAGRAM_H

#include <string>
#include <vector>

using namespace std;

namespace anagram
{
    class anagram 
    {
        public:
            string sMainString;
            // constructor
            anagram();
            anagram( string const& inputString );

            //destructor
            ~anagram();
            // matches function
            vector<string> matches( vector<string> const& possibleMatches );
    };

}

#endif