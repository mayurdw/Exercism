/*
   Author: Mayur Wadhwani
   Created: August 2018
*/

#ifndef BEER_SONG_H
#define BEER_SONG_H

#include <string>

namespace beer
{
   std::string verse( int iBottles );
   std::string sing( int iStart, int iEnd );
   std::string sing( int iStart );
}

#endif // !BEER_SONG_H


