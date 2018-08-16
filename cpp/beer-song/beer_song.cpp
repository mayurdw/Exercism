/*
   Author: Mayur Wadhwani
   Created: August 2018
*/

#include <sstream>
#include "beer_song.h"

using namespace std;

const string strTakeItDown = "Take one down and pass it around, ";
const string strBttleOnWall = " bottles of beer on the wall";
const string strOneBttleOnWall = " bottle of beer on the wall";
const string strBttleofBeer = " bottles of beer.\n";
const string strOneBottle = "1 bottle of beer on the wall, 1 bottle of beer.\nTake it down and pass it around, no more bottles of beer on the wall.\n";
const string strNoBottle = "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n";

namespace beer
{
   string verse( int iBottles )
   {
      stringstream sStream;

      if ( iBottles > 1 )
      {
         sStream << iBottles << strBttleOnWall << ", " << iBottles << strBttleofBeer;
         sStream << strTakeItDown << --iBottles;
         if ( iBottles == 1 )
         {
            sStream << strOneBttleOnWall;
         }
         else
         {
            sStream << strBttleOnWall;
         }
         sStream << ".\n";
      }
      else if ( iBottles == 1 )
      {
         sStream << strOneBottle;
      }
      else
      {
         // iBottles == 0
         sStream << strNoBottle;
      }

      return sStream.str();
   }

   string sing( int iStart, int iEnd )
   {
      string sRet = {};

      while ( iStart >= iEnd )
      {
         sRet.append( verse( iStart ) );
         iStart--;
         if ( iStart >= iEnd )
         {
            sRet.append( "\n" );
         }
      }
      
      return sRet;
   }

   string sing( int iStart )
   {
      return sing( iStart, 0 );
   }

}
