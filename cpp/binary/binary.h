/*
Author: Mayur Wadhwani
Created: July 2018
*/

#include <string>

using namespace std;

#ifndef BINARY_H
#define BINARY_H

namespace binary
{
   const int iBase = 2;
   int convert( const string & sInputStr );
   bool isBinary( const string & sBinaryStr );
}
#endif // !BINARY_H

