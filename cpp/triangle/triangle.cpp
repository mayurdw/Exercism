/*
Author : Mayur Wadhwani
Created: August 2018
*/

#include "triangle.h"
#include <stdexcept>

triangle::TRIANGLE_TYPE triangle::kind( double dFirstSide, double dSecondSide, double dThirdSide )
{
   TRIANGLE_TYPE eRet = scalene;

   if ( ( !dFirstSide || !dSecondSide || !dThirdSide ) || 
         ( dFirstSide < 0 || dSecondSide < 0 || dThirdSide < 0 ) ||
         !( ( dFirstSide < ( dSecondSide + dThirdSide ) ) && ( dSecondSide < ( dThirdSide + dFirstSide ) ) && ( dThirdSide < ( dFirstSide + dSecondSide ) ) ) )
   {
      throw std::domain_error( "Invalid Values" );
   }
   else if ( dFirstSide == dThirdSide && dSecondSide == dThirdSide )
   {
      eRet = equilateral;
   }
   else if ( ( dFirstSide == dThirdSide ) ||
            ( dFirstSide == dSecondSide ) ||
            ( dSecondSide == dThirdSide ) )
   {
      eRet = isosceles;
   }

   return eRet;
}
