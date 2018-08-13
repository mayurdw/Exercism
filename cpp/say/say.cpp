#include "say.h"
/*
Author: Mayur Wadhwani
Created: August 2018
*/

using namespace std;

namespace say
{
   string in_english( uint64_t ullInput )
   {
      string sRet = {};
      string sTemp = {};
      uint64_t ullDecrementer = 0ULL;
      bool bDone = false;
      
      while ( !bDone )
      {
         if ( ullInput < vsTeens.size() && ullInput >= 0 )
         {
            GetUnitsName( sTemp, ullInput );
            sRet.append( sTemp );
            bDone = true;
         }
         else if ( ullInput < ullHundred && ullInput >= vsTeens.size() )
         {
            GetTensName( sTemp, ullInput );
            sRet.append( sTemp );
            bDone = true;
         }
         else if ( ullInput < ullThousand && ullInput >= 100ULL )
         {
            GetHundredsName( sTemp, ullInput );
            sRet.append( sTemp );
            bDone = true;
         }
         else if ( ullInput < ullMillion && ullInput >= ullThousand )
         {
            sTemp = vsTeens[ullInput / ullThousand];
            ullInput -= ( ullInput / ullThousand ) * ullThousand;
            sRet.append( sTemp );
            sRet.append( " " );
            sRet.append( vsIndex[1] );
            if ( ullInput == 0ULL )
            {
               bDone = true;
            }
            else
            {
               sRet.append( " " );
            }
         }
         else if ( ullInput < ullBillion && ullInput >= ullMillion )
         {
            sTemp = vsTeens[ullInput / ullMillion];
            ullInput -= ( ullInput / ullMillion ) * ullMillion;
            sRet.append( sTemp );
            sRet.append( " " );
            sRet.append( vsIndex[2] );
            if ( ullInput == 0ULL )
            {
               bDone = true;
            }
            else
            {
               sRet.append( " " );
            }
         }
      }
      
      return sRet;
   }

   void GetUnitsName( string & sName, uint64_t ullInput )
   {
      sName = vsTeens[ullInput];
   }

   void GetTensName( string & sName, uint64_t ullInput )
   {
      if ( ullInput < vsTeens.size() )
      {
         GetUnitsName( sName, ullInput );
      }
      else
      {
         sName = vsDecades[ullInput / ullTens];

         if ( ullInput % ullTens != 0 )
         {
            string sTemp = {};

            GetUnitsName( sTemp, ullInput % ullTens );
            sName.append( "-" );
            sName.append( sTemp );
         }
      }
   }

   void GetHundredsName( string & sName, uint64_t ullInput )
   {
      if ( ullInput < ullHundred )
      {
         GetTensName( sName, ullInput );
      }
      else
      {
         sName = vsTeens[ullInput / ullHundred];

         sName.append( " " );
         sName.append( vsIndex[0] );

         if ( ullInput % ullHundred != 0 )
         {
            string sTemp = {};

            GetTensName( sTemp, ullInput % ullHundred );
            sName.append( " " );
            sName.append( sTemp );
         }
      }
   }
}


