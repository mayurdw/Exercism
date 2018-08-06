#include "sum_of_multiples.h"

int sum_of_multiples::to( std::initializer_list<int> const & ilInput, int iMax )
{
   int iRet = 0;

   if ( iMax <= 0 || ilInput.size() == 0 )
      return iRet;

   for ( int iCount = 0; iCount < iMax; iCount++ )
   {
      for ( auto iInput : ilInput )
      {
         if ( iCount % iInput == 0 )
         {
            iRet += iCount;
            break;
         }
      }
   }
   return iRet;
}
