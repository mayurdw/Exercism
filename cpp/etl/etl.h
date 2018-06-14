/*
    Author: Mayur Wadhwani

    Created: June 2018
*/

#ifndef ETL_H
#define ETL_H

#include <map>
#include <vector>

namespace etl
{
    using namespace std;
    map <char, int> transform ( const map<int, vector<char>> &cInput );
}

#endif