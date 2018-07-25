/*
Author: Mayur Wadhwani
Created: July 2018
*/

#include "binary.h"
#include <cmath>

int binary::convert( const string & sInputStr )
{
   int iRet = 0;
   int iLen = sInputStr.length();
   string sCopyStr;

   if ( iLen == 0 )
      return iRet;

   if ( !isBinary( sInputStr ) )
      return iRet;

   sCopyStr = sInputStr;
   reverse( sCopyStr.begin(), sCopyStr.end() );

   for ( int iIndex = 0; iIndex < iLen; iIndex++ )
   {
      if ( sCopyStr[iIndex] == '1' )
      {
         iRet += pow( iBase, iIndex );
      }
   }

   return iRet;
}

bool binary::isBinary( const string & sBinaryStr )
{
   for ( auto aChar : sBinaryStr )
   {
      if ( ( aChar != '1' ) && ( aChar != '0' ) )
      {
         return false;
      }
   }

   return true;
}

