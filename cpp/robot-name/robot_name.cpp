#include "robot_name.h"
#include <iomanip>
#include <sstream>
#include <stdexcept>
#include <vector>

using namespace std;

static string generate_name()
{
   const string sletters{ "ABCDEFGHIJKLMNOPQRSTUVWXYZ" };
   const size_t iLength = sletters.length();
   static vector<int> vIndices = { 0, 0 };
   static int iNumSuffix = 0;
   string sSuffixLetters = { };
   ostringstream buff;

   if ( iNumSuffix > 999 )
   {
      if ( vIndices[1] > iLength )
      {
         if ( vIndices[0] > iLength )
         {
            throw range_error( "Out of Combinations" );
         }
         else
         {
            vIndices[1] = vIndices[0];
            vIndices[0]++;
         }
      }
      else
      {
         vIndices[1]++;
      }

      iNumSuffix = 0;
   }

   sSuffixLetters.insert( sSuffixLetters.begin(), sletters[vIndices[0]] );
   sSuffixLetters.insert( sSuffixLetters.end(), sletters[vIndices[1]] );

   buff << sSuffixLetters << setw( 3 ) << setfill( '0' ) << iNumSuffix++;
   return buff.str();
}

robot_name::robot::robot()
{
   sRobotName = generate_name();
}

void robot_name::robot::reset()
{
   sRobotName = generate_name();
}


