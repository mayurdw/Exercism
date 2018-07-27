/*
   Author : Mayur Wadhwani
   Created : July 2018
*/

#include "difference_of_squares.h"
int squares::square_of_sums( int iInput )
{
   int iRet = 0;
   
   while ( iInput > 0 )
   {
      iRet += iInput;
      iInput--;
   }

   iRet *= iRet;

   return iRet;
}

int squares::sum_of_squares( int iInput )
{
   int iRet = 0;

   while ( iInput > 0 )
   {
      int iNum = iInput;

      iNum *= iNum;
      iRet += iNum;
      iInput--;
   }

   return iRet;
}

int squares::difference( int iInput )
{
   int iSumSq = sum_of_squares( iInput );
   int iSqSum = square_of_sums( iInput );

   return ( ( iSqSum > iSumSq ) ? ( iSqSum - iSumSq ) : ( iSumSq - iSqSum ) );
}
