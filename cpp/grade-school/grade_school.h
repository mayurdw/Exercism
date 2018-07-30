/*
   Author: Mayur Wadhwani
   Created: July 2018
*/

#ifndef GRADE_SCHOOL_H
#define GRADE_SCHOOL_H

#include <string>
#include <map>
#include <vector>

namespace grade_school
{
   using namespace std;
   class school
   {
   private: 
      map<int, vector<string>> mSchoolDB;

   public:
      school() = default;
      ~school() = default;
      map<int, vector<string>> roster();
      void add( char *pszStudentName, int iStudentGrade );
      vector<string> grade( int iStudentGrade );
   };
}

#endif //GRADE_SCHOOL_H
