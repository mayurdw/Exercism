/*
   Author : Mayur Wadhwani 
   Created: August 2018
*/

#ifndef ALLERGIES_H
#define ALLERGIES_H

#include <map>
#include <string>
#include <unordered_set>

namespace allergies
{
   class allergy_test
   {
   private:
      int iScore__;
   public:
      allergy_test( int iScore );
      bool is_allergic_to( const std::string &sAllergyItem );
      const std::unordered_set<std::string> get_allergies();
   };
}
#endif // !ALLERGIES_H


