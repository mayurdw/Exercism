/*
   Author: Mayur Wadhwani
   Created: July 2018
*/

#ifndef SPACE_AGE
#define SPACE_AGE

typedef unsigned long long uint64_t;

namespace space_age
{
   class space_age
   {
   public:
      space_age( uint64_t secs );

      ~space_age( void );
      uint64_t seconds( void ) const;
      double on_earth( void ) const;
      double on_mercury() const;
      double on_venus() const;
      double on_mars() const;
      double on_jupiter() const;
      double on_saturn() const;
      double on_uranus() const;
      double on_neptune() const;
   private: 
      uint64_t ullspaceAge;
   };
}
#endif // !SPACE_AGE
