/*
Author: Mayur Wadhwani
Created: July 2018
*/

#include "scrabble_score.h"
#include <map>
#include <algorithm>

int scrabble_score::score( const string & sInputStr )
{
   int iRet = 0;
   const map<char, int> cmmLookup = { 
   { 'a', 1 },{ 'e', 1 },{ 'i', 1 },{ 'o', 1 },{ 'u', 1 },{ 'l', 1 },{ 'n', 1 }, { 's', 1 }, { 't', 1 }, { 'r', 1 }, 
   { 'd', 2 },{ 'g', 2 }, 
   { 'b', 3 },{ 'c', 3 },{ 'm', 3 },{ 'p', 3 }, 
   { 'f', 4 },{ 'h', 4 },{ 'v', 4 },{ 'w', 4 },{ 'y', 4 }, 
   { 'k', 5 }, 
   { 'j', 8 },{ 'x', 8 }, 
   { 'q', 10 },{ 'z', 10 } };
   map<char, int> mCompleted;

   if ( sInputStr.length() == 0 )
      return iRet;

   for ( auto aStrLoop : sInputStr )
   {
      auto aKeyPair = ( cmmLookup.find( tolower( aStrLoop ) ) );

      if ( ( aKeyPair != cmmLookup.end() ) && ( mCompleted.find( aStrLoop ) == mCompleted.end() ) )
      {
         auto aCount = count( sInputStr.begin(), sInputStr.end(), aStrLoop );
         iRet += ( *aKeyPair ).second * aCount;
         mCompleted.insert( pair<char, int>( aStrLoop, aCount ) );
      }
   }

   return iRet;
}
