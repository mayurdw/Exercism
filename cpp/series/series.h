/*
   Author: Mayur Wadhwani
   Created: August 2018
*/

#ifndef SERIES_H
#define SERIES_H

#include <string>
#include <vector>

namespace series
{
   std::vector<int> digits( std::string sNumberString );
   std::vector<std::vector<int>> slice( std::string sNumberString, int iStrlen );
}

#endif // !SERIES_H



