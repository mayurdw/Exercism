/*
   Author: Mayur Wadhwani
   Created: August 2018
*/

#ifndef ATBASH_H
#define ATBASH_H

#include <string>

namespace atbash
{
   const std::string encode( const std::string &sInputStr );
   const std::string decode( const std::string &sInputStr );
}
#endif
