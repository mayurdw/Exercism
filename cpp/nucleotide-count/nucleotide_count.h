/*
   Author : Mayur Wadhwani
   Created : July 2018
*/

#include <string>
#include <map>

#ifndef NUC_COUNT_H
#define NUC_COUNT_H

namespace dna
{
   using namespace std;

   class counter
   {
   private: 
      string sOwnDNAStr;
      map<char, int> mDNAMapped;

   public:
      counter() = default;
      ~counter() = default;
      counter( const string &sDNAStr );
      map<char, int> nucleotide_counts() const;
      int count( char pszDNAStr ) const;
   };
}
#endif // !NUC_COUNT_H
