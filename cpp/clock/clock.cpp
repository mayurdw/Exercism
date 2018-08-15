/* 
   Author : Mayur Wadhwani
   Created: August 2018
*/

#include "clock.h"
#include <sstream>
#include <iomanip>

using namespace std;

namespace date_independent
{
   void clock::SanityCheck()
   {
      while ( Min__ >= iMinPerHour )
      {
         Hour__++;
         Min__ -= iMinPerHour;
      }

      while ( Hour__ >= iHourPerDay )
      {
         Hour__ -= iHourPerDay;
      }

      while ( Min__ < 0 )
      {
         Hour__--;
         Min__ = iMinPerHour + Min__;
      }

      while ( Hour__ < 0 )
      {
         Hour__ = iHourPerDay + Hour__;
      }
   }

   clock::clock( int iHour, int iMin )
   {
      Hour__ = iHour;
      Min__ = iMin;
      SanityCheck();
   }

   clock clock::at( int iHour, int iMin )
   {
      return clock( iHour, iMin );
   }

   clock & clock::plus( int iMin )
   {
      Min__ += iMin;
      SanityCheck();

      return *this;
   }

   bool clock::operator==( const clock & rhs ) const
   {
      return ( ( Hour__ == rhs.Hour__ ) && ( Min__ == rhs.Min__ ) );
   }

   bool clock::operator!=( const clock & rhs ) const
   {
      return !( *this == rhs );
   }

   clock::operator string() const
   {
      stringstream sStr;

      sStr << setw( 2 ) << setfill( '0' ) << Hour__ << ":" << setw( 2 ) << setfill( '0' ) << Min__;
      
      return sStr.str();
   }

}
