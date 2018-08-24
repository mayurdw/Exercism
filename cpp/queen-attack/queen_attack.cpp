/*
   Author : Mayur Wadhwani
   Created: August 2018
*/

#include "queen_attack.h"

using namespace std;

namespace queen_attack
{
   chess_board::chess_board()
   {
      piiWhite = { 0, 3 };
      piiBlack = { 7, 3 };
   }
   chess_board::chess_board( std::pair<int, int> WhitePos, std::pair<int, int> BlackPos )
   {
      if ( WhitePos == BlackPos )
         throw std::domain_error( "queen_positions_must_be_distinct" );

      piiBlack = BlackPos;
      piiWhite = WhitePos;
   }

   pair<int, int> chess_board::white() const
   {
      return piiWhite;
   }

   pair<int, int> chess_board::black() const
   {
      return piiBlack;
   }
   
   chess_board::operator std::string() const
   {
      string sRet;
      const string sLine = { "_ _ _ _ _ _ _ _\n" };
      const string sDash = { "_ " };
      int iRowCount = 0;
      int iColumnCount = 0;

      while ( iRowCount <= iMax )
      {
         if ( iRowCount == piiWhite.first )
         {
            while ( iColumnCount <= iMax )
            {
               if ( iColumnCount == piiWhite.second )
               {
                  sRet.append( "W " );
               }
               else if ( iColumnCount == iMax )
               {
                  sRet.append( "_\n" );
               }
               else
               {
                  sRet.append( sDash );
               }
               iColumnCount++;
            }
         }
         else if ( iRowCount == piiBlack.first )
         {
            while ( iColumnCount <= iMax )
            {
               if ( iColumnCount == piiBlack.second )
               {
                  sRet.append( "B " );
               }
               else if ( iColumnCount == iMax )
               {
                  sRet.append( "_\n" );
               }
               else
               {
                  sRet.append( sDash );
               }
               iColumnCount++;
            }
         }
         else
         {
            sRet.append( sLine );
         }

         iRowCount++;
         iColumnCount = 0;
      }

      return sRet;
   }

   bool chess_board::can_attack() const
   {
      return ( ( piiBlack.first == piiWhite.first ) ||
         ( piiBlack.second == piiWhite.second ) ||
         ( piiBlack.second == piiWhite.first && piiBlack.first == piiWhite.second ) ||
         ( piiBlack.first - piiWhite.first == piiBlack.second - piiWhite.second ) ||
         ( piiWhite.first - piiBlack.first == piiWhite.second - piiBlack.second ) );
   }
}


