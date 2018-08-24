/*
   Author : Mayur Wadhwani
   Created: August 2018
*/

#include <vector>
#include "roman_numerals.h"

using namespace std;

namespace roman
{
   string convert( int iInteger )
   {
      const vector<string> vsThousands = { "", "M", "MM", "MMM" };
      const vector<string> vsHundreds = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
      const vector<string> vsTens = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
      const vector<string> vsUnits = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
      string sRet;

      sRet.append( vsThousands.at( iInteger / 1000 ) );
      iInteger %= 1000;
      sRet.append( vsHundreds.at( iInteger / 100 ) );
      iInteger %= 100;
      sRet.append( vsTens.at( iInteger / 10 ) );
      iInteger %= 10;
      sRet.append( vsUnits.at( iInteger ) );

      return sRet;
   }
}
