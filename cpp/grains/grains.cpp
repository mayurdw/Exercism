/*
   Author : Mayur Wadhwani
   Created: August 2018
*/

#include <math.h>
#include "grains.h"
using namespace std;

namespace grains
{
   uint64_t square( int iSquareNumber )
   {
      return static_cast< uint64_t >( pow( 2, ( iSquareNumber - 1 ) ) );
   }

   uint64_t total()
   {
      // based on the geometric progression formula Sum = 2^(n+1) - 1
      uint64_t ulRet = square( 64 );

      ulRet += square( 64 );
      ulRet -= 1;

      return ulRet;
   }
}
