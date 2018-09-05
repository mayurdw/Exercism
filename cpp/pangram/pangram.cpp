/*
   Author : Mayur Wadhwani
   Created : September 2018
*/

#include <iostream>
#include <algorithm>
#include "pangram.h"

using namespace std;

namespace pangram
{

   bool is_pangram( const string & sInputStr )
   {
      string sAlphabets = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

      for( auto aChar : sInputStr )
      {
         aChar = tolower( aChar );
         if( sAlphabets.find( aChar ) != string::npos )
         {
            sAlphabets.erase( remove( sAlphabets.begin(), sAlphabets.end(), aChar ) );
         }
      }

      cout << "Size " << sAlphabets.size() << endl;

      return ( sAlphabets.size() == 0 );
   }
}

