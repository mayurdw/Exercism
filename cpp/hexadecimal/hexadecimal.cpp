/*
Author: Mayur Wadhwani
Created: July 2018
*/

#include "hexadecimal.h"
#include <algorithm>

int hexadecimal::convert( const string & sInputStr )
{
   int iRet = 0;

   if ( !isHex( sInputStr ) )
      return iRet;

   for ( auto sTempChar: sInputStr )
   {
      auto sStrChar = tolower( sTempChar );
      auto iTempCount = 0;

      if ( '0' <= sStrChar && sStrChar <= '9' )
      {
         iTempCount = sStrChar - '0';
      }
      else 
      {
         iTempCount = ( 10 + sStrChar - 'a' );
      }

      iRet *= 16;
      iRet += iTempCount;
   }

   return iRet;
}

bool hexadecimal::isHex( const string & sHexStr )
{
   for ( auto sStrChar : sHexStr )
   {
      auto sLowerChar = tolower( sStrChar );
      if ( sLowerChar > 'f' || sLowerChar < '0' )
         return false;
   }

   return true;
}
