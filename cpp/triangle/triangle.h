/*
   Author : Mayur Wadhwani
   Created: August 2018
*/

#ifndef TRIANGLE_H
#define TRIANGLE_H

namespace triangle
{
   enum TRIANGLE_TYPE
   {
      equilateral,
      isosceles,
      scalene,
   };

   TRIANGLE_TYPE kind( double dFirstSide, double dSecondSide, double dThirdSide );
}

#endif
