/*
Author: Mayur Wadhwani
Created: August 2018
*/
#include "prime_factors.h"

using namespace std;

vector<int> prime_factors::of( int iNum )
{
   const vector<int> iDivisors = { 2, 3, 5, 7, 11, 13, 17, 23 };
   vector<int> iRet;

   if ( iNum == 1 )
      return iRet;

   for ( auto iDiv : iDivisors )
   {
check:
      if ( isAFactor( iNum, iDiv ) )
      {
         iRet.push_back( iDiv );
         iNum = iNum / iDiv;
         goto check;
      }
   }

   if ( iNum != 1 )
   {
      iRet.push_back( iNum );
   }

   return iRet;
}

constexpr bool prime_factors::isAFactor( int iDividend, int iDivisor )
{
   return( iDividend % iDivisor == 0 );
}
