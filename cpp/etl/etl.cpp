/*
    Author: Mayur Wadhwani

    Created: June 2018
*/

#include "etl.h"

namespace etl
{
    map <char, int> transform ( const map<int, vector<char>> &cInput )
    {
        map <char,int> cmOutput;

        for( auto const &iterator : cInput )
        {
            for( char c: iterator.second )
            {
                cmOutput[tolower(c)] = iterator.first;
            }
        }

        return cmOutput;
    }
}