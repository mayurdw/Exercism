/* 
   Author : Mayur Wadhwani
   Created : July 2018
*/

#ifndef ROBOT_NAME_H
#define ROBOT_NAME_H

#include <string>

namespace robot_name
{
   class robot
   {
   private:
      std::string sRobotName;

   public:
      robot();
      ~robot() = default;
      std::string const &name() const { return sRobotName; }
      void reset();
   };
}
#endif
