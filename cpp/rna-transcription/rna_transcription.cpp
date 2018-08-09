/*
Author: Mayur Wadhwani
Created: August 2018
*/

#include "rna_transcription.h"
#include <algorithm>

using namespace std;

char transcription::to_rna( const char szDNAStr )
{
   const auto pos = dna_nucleotides.find( szDNAStr );
   if ( pos != string::npos ) {
      return rna_nucleotides[pos];
   }
   return 0;
}

string transcription::to_rna( string const& sequence )
{
   string transcription;
   transform( sequence.begin(), sequence.end(), back_inserter( transcription ),
      []( char c ) { return transcription::to_rna( c ); } );
   return transcription;
}
