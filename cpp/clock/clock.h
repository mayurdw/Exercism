/*
   Author : Mayur Wadhwani
   Created: August 2018
*/

#ifndef CLOCK_H
#define CLOCK_H

#include <string>

namespace date_independent
{
   class clock
   {
   private:
      int Hour__ = 0;
      int Min__ = 0;
      void SanityCheck();

   public:
      const int iHourPerDay = 24;
      const int iMinPerHour = 60;

      clock( int iHour, int iMin );
      static clock at( int iHour, int iMin = 0 );
      clock &plus( int iMin );
      bool operator == ( const clock &rhs ) const;
      bool operator != ( const clock &rhs ) const;
      operator std::string() const;
   };
}

#endif // !CLOCK_H


