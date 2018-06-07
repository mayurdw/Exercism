/*
    Author: Mayur Wadhwani

    Created: May 2018
*/

#include "hamming.h"
#include <stdexcept>

namespace hamming
{
    int compute( std::string const &lhs, std::string const &rhs )
    {
        int iRet = 0;
        int iCount = 0;
        
        if ( lhs.size() != rhs.size() )
            throw std::domain_error("domain_error_when_first_string_is_longer");

        while( iCount < lhs.size() )
        {
            if ( lhs[iCount] != rhs[iCount] )
                iRet++;
            
            iCount++;
        }


        return iRet;
    }
}