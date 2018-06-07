/*
    Author: Mayur Wadhwani

    Created: June 2018

*/

#ifndef ANAGRAM_H
#define ANAGRAM_H

#include <string>
#include <vector>

using namespace std;

class anagram 
{
    // own string
    private:
        string sMainString;

    public:
        // constructor
        anagram();
        anagram( string const& inputString );

        //destructor
        ~anagram();
        // matches function
        vector<string> matches( vector<string> const& possibleMatches );
};

#endif