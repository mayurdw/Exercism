/*
   Author: Mayur Wadhwani
   Created: August 2018
*/

#include <iostream>
#include "phone_number.h"

using namespace std;

phone_number::phone_number( string sInputNumber )
{
   sPhoneNumber = sInputNumber;
}

string phone_number::number() const
{
   string sRet = { "0000000000" };
   bool bSkipFirst = false;

   if ( sPhoneNumber.size() < 10 )
   {
      return sRet;
   }
   else if ( sPhoneNumber.size() == 11 && sPhoneNumber.size() >= 10 )
   {
      if ( *sPhoneNumber.begin() == '1' )
      {
         bSkipFirst = true;
      }
      else
      {
         return sRet;
      }
   }

   sRet.clear();
   // Remove any space, brackets and -

   for ( auto cChar = sPhoneNumber.begin(); cChar < sPhoneNumber.end(); cChar++ )
   {
      if ( bSkipFirst )
      {
         bSkipFirst = false;
         continue;
      }

      if ( isalnum( *cChar ) )
      {
         if ( *cChar >= '0' && *cChar <= '9' )
         {
            sRet.append( 1, *cChar );
         }
      }
   }

   return sRet;
}

string phone_number::area_code() const
{
   string sFormattedNumber = number();

   sFormattedNumber.erase( 3 );

   return sFormattedNumber;
}

phone_number::operator string() const
{
   string sRet = { "(" };
   string sNumber = number();

   sRet.append( sNumber.begin(), sNumber.begin() + 3 );
   sRet.append( ") ", 2 );
   sRet.append( sNumber.begin() + 3, sNumber.begin() + 6 );
   sRet.append( "-", 1 );
   sRet.append( sNumber.begin() + 6, sNumber.end() );

   return sRet;

}
