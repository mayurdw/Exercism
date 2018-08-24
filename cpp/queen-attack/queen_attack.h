/*
   Author : Mayur Wadhwani
   Created: August 2018
*/

#ifndef QUEEN_ATTACK_H
#define QUEEN_ATTACK

#include <map>

namespace queen_attack
{
   class chess_board
   {
   private:
      const int iMax = 7;
      std::pair<int, int> piiBlack;
      std::pair<int, int> piiWhite;
   public:
      chess_board();
      chess_board( std::pair<int, int> WhitePos, std::pair<int, int> BlackPos );
      ~chess_board() = default;
      std::pair<int, int> white() const;
      std::pair<int, int> black() const;
      operator std::string() const;
      bool can_attack() const;

   };
}
#endif // !QUEEN_ATTACK_H



