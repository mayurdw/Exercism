/*
    Author: Mayur Wadhwani

    Created: June 2018

*/

#include "anagram.h"

namespace anagram
{
    anagram::anagram( string const& inputString )
    {
        if ( !inputString.empty() )
        {
            sMainString.assign(inputString);
        }
    }

    anagram::~anagram()
    {

    }

    vector<string> anagram::matches( vector<string> const& possibleMatches )
    {
        vector<string> vsOutputString;

        if ( possibleMatches.empty() )
        {
            return vsOutputString;
        }

        for( auto iter = possibleMatches.begin(); iter != possibleMatches.end(); iter++ )
        {
            if ( ( *iter ).length() == sMainString.length() )
            {
                bool bNotMatch = false;
                int iIndex = 0;

                while( iIndex < sMainString.length() && !bNotMatch )
                {
                    auto sMatch = ( *iter ).find( sMainString[iIndex] );

                    if ( sMatch == string::npos )
                        bNotMatch = true;
                    else
                        iIndex++;
                }

                if ( !bNotMatch )
                {
                    vsOutputString.push_back(*iter);
                }
            }
        }

        return vsOutputString;
    }
}

int main()
{
    anagram::anagram subject("ant");

    auto matched = subject.matches({"tan", "stand", "at"});

    return 0;
}



