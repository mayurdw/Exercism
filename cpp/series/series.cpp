/*
   Author: Mayur Wadhwani
   Created: August 2018
*/

#include "series.h"

using namespace std;

namespace series
{
   vector<int> digits( string sNumberString )
   {
      vector<int> viRet;

      for ( auto cChar : sNumberString )
      {
         viRet.insert( viRet.end(), ( cChar - '0' ) );
      }

      return viRet;
   }

   vector<vector<int>> slice( string sNumberString, int iStrlen )
   {
      if ( iStrlen > static_cast< int >( sNumberString.length() ) ) 
      {
         throw domain_error( "Requested span too long for sequence" );
      }

      vector<vector<int>> vviRet;

      for ( size_t i = 0; i < sNumberString.length() - ( iStrlen - 1 ); ++i ) 
      {
         vviRet.push_back( digits( sNumberString.substr( i, iStrlen ) ) );
      }

      return vviRet;
   }
}

