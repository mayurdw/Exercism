/*
   Author : Mayur Wadhwani
   Created: August 2018
*/

#include "allergies.h"

using namespace std;

namespace allergies
{
   map<string, int> msiAllergens = { { "eggs", 1 }, { "peanuts", 2 } , { "shellfish", 4 } , { "strawberries", 8 } , { "tomatoes", 16 } , { "chocolate", 32 } , { "pollen", 64 } , { "cats", 128 } };

   allergy_test::allergy_test( int iScore )
   {
      if( iScore >= 0 )
      {
         iScore__ = iScore;
      }
   }

   bool allergy_test::is_allergic_to( const string & sAllergyItem )
   {
      if( msiAllergens.find( sAllergyItem ) != msiAllergens.end() )
      {
         if( iScore__ & msiAllergens.at( sAllergyItem ) )
         {
            return true;
         }
      }

      return false;
   }

   const unordered_set<string> allergy_test::get_allergies()
   {
      unordered_set<string> usRet;

      for( auto pAllergen : msiAllergens )
      {
         if( is_allergic_to( pAllergen.first ) )
         {
            usRet.insert( pAllergen.first );
         }
      }

      return usRet;
   }
}

