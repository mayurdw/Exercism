/*
Author : Mayur Wadhwani
Created : July 2018
*/
#include "grade_school.h"
#include <algorithm>

namespace grade_school
{
   map<int, vector<string>> school::roster()
   {
      if ( mSchoolDB.empty() )
         return map<int, vector<string>> {};

      return mSchoolDB;
   }

   void school::add( char * pszStudentName, int iStudentGrade )
   {
      vector<string> vTemp = mSchoolDB[iStudentGrade];

      if ( pszStudentName == NULL || iStudentGrade <= 0 )
         return;

      vTemp.insert( vTemp.cend(), pszStudentName );
      sort( vTemp.begin(), vTemp.end() );

      mSchoolDB[iStudentGrade] = vTemp;
   }
   vector<string> school::grade( int iStudentGrade )
   {
      if ( iStudentGrade <= 0 || ( mSchoolDB.find( iStudentGrade ) == mSchoolDB.end() ) )
         return vector<string> {};

      return mSchoolDB[iStudentGrade];
   }
}

