/*
   Author: Mayur Wadhwani
   Created: August 2018
*/

#include "atbash_cipher.h"

using namespace std;

namespace atbash
{
   const string encode( const string & sInputStr )
   {
      string sRetStr;
      int iCount = 0;

      for( auto cChar : sInputStr )
      {
         if( isalnum( cChar ) )
         {
            if( iCount == 5 )
            {
               sRetStr += ' ';
               iCount = 0;
            }

            if( ( cChar >= 'a' && cChar <= 'z' ) || ( cChar >= 'A' && cChar <= 'Z' ) )
            {
               sRetStr += static_cast< char >( 'z' - tolower( cChar ) + 'a' );
            }
            else if( ( cChar >= '0' && cChar <= '9' ) )
            {
               sRetStr += cChar;
            }
            iCount++;
         }
      }

      return sRetStr;
   }

   const string decode( const string & sInputStr )
   {
      string sRetStr;

      for( auto cChar : sInputStr )
      {
         if( cChar != ' ' )
         {
            if( ( cChar >= 'a' && cChar <= 'z' ) )
            {
               sRetStr += static_cast< char >( 'z' - tolower( cChar ) + 'a' );
            }
            else if( ( cChar >= '0' && cChar <= '9' ) )
            {
               sRetStr += cChar;
            }
         }
      }
      return sRetStr;
   }

}
