/*
   Author: Mayur Wadhwani
   Created: August 2018
*/

#ifndef SAY_H
#define SAY_H

#include <string>
#include <vector>

namespace say
{
   const std::vector<std::string> vsTeens = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
                                              "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };
   const std::vector<std::string> vsDecades = { "zero", "ten" ,"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };
   const std::vector<std::string> vsIndex = { "hundred", "thousand", "million", "billion" };
   const std::uint64_t ullTens = 10ULL;
   const std::uint64_t ullHundred = ullTens * ullTens;
   const std::uint64_t ullThousand = ullHundred * ullTens;
   const std::uint64_t ullMillion = ullThousand * ullThousand;
   const std::uint64_t ullBillion = ullMillion * ullThousand;
   const std::uint64_t ullTrillion = ullMillion * ullMillion;

   std::string in_english( std::uint64_t ullInput );
   void GetUnitsName( std::string &sName, std::uint64_t ullInput );
   void GetTensName( std::string &sName, std::uint64_t ullInput );
   void GetHundredsName( std::string &sName, std::uint64_t ullInput );
}

#endif
