/*
Author : Mayur Wadhwani
Created : July 2018
*/

#include "nucleotide_count.h"
#include <vector>

namespace dna
{
   counter::counter( const string & sDNAStr )
   {
      sOwnDNAStr = sDNAStr;
      mDNAMapped = nucleotide_counts();
   }
   
   map<char, int> counter::nucleotide_counts() const
   {
      map<char, int> mMap = { { 'A', 0 }, { 'T', 0 }, { 'C', 0 }, { 'G', 0 } };

      for ( auto cNucleotide : sOwnDNAStr )
      {
         auto cPair = mMap.find( cNucleotide );
         if (  cPair != mMap.end() )
         {
            ( *cPair ).second++;
         }
         else
         {
            throw invalid_argument( "Unknown nucleotide" );
         }
      }
      return mMap;
   }

   int counter::count( char pszDNAStr ) const
   {
      int iRet = 0;
      auto cPair = mDNAMapped.find( pszDNAStr );

      if ( cPair != mDNAMapped.end() )
      {
         iRet = ( *cPair ).second;
      }
      else
      {
         throw invalid_argument( "Unknown nucleotide" );
      }

      return iRet;
   }
}



