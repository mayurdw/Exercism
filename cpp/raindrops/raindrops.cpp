/*
   Author : Mayur Wadhwani
   Created: August 2018
*/


#include "raindrops.h"
#include <sstream>

using namespace std;

namespace raindrops
{
   const string convert( int iNumber )
   {
      bool bRetNumber = true;
      stringstream sRet;

      if( iNumber % 3 == 0 )
      {
         bRetNumber = false;
         sRet << "Pling";
      }

      if( iNumber % 5 == 0 )
      {
         bRetNumber = false;
         sRet << "Plang";
      }

      if( iNumber % 7 == 0 )
      {
         bRetNumber = false;
         sRet << "Plong";
      }


      
      if ( bRetNumber )
      {
         sRet << iNumber;
      }

      return sRet.str();
   }

}
