/*
   Author: Mayur Wadhwani
   Created: August 2018
*/

#ifndef RNA_TRANSCRIPTION_H
#define RNA_TRANSCRIPTION_H

#include <string>

namespace transcription
{
   const std::string dna_nucleotides( "CGAT" );
   const std::string rna_nucleotides( "GCUA" );

   char to_rna( const char szDNAStr );
   std::string to_rna( std::string const& sequence );
}

#endif // !RNA_TRANSCRIPTION_H
