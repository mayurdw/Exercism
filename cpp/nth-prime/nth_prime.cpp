/*
   Author : Mayur Wadhwani
   Created: August 2018
*/

#include "nth_prime.h"
#include <math.h>
#include <stdexcept>

namespace prime
{
   int nth( int iPosition )
   {
      int iCandidate = 2, iCount = 0;

      if ( iPosition <= 0 )
      {
         throw std::domain_error( "Incorrect Position" );
      }

      while ( iCount < iPosition )
      {
         if ( isPrime( iCandidate ) )
         {
            iCount++;
         }
         iCandidate++;
      }

      return iCandidate - 1;
   }
   
   bool isPrime( int iPosition )
   {
      int iStep = 4, iMax = 0;

      // If the number is divisible by 2 or 3, check if it is 2 or 3
      if ( iPosition % 2 == 0 )
         return ( iPosition == 2 );

      if ( iPosition % 3 == 0 )
         return ( iPosition == 3 );

      // For better explaination: https://stackoverflow.com/questions/9625663/calculating-and-printing-the-nth-prime-number
      // We only have to worry about numbers from 4 onwards
      // Prime numbers usually come in pairs ie number/prime number = prime number
      // or PM = sqrt( number );
      iMax = floor( sqrt( iPosition ) + 1 );

      for ( int i = 5; i < iMax; iStep = 6 - iStep, i += iStep ) 
      {
         if ( iPosition % i == 0 ) 
         {
            return false;
         }
      }

      return true;
   }
}

