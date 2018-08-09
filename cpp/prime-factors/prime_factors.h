/*
   Author: Mayur Wadhwani
   Created: August 2018
*/

#ifndef PRIME_FACTORS_H
#define PRIME_FACTORS_H

#include <vector>

namespace prime_factors
{
   std::vector<int> of( int iNum );
   constexpr bool isAFactor( int iDividend, int iDivisor );
}
#endif // !PRIME_FACTORS_H

