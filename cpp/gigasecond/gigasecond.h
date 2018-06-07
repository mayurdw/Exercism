#ifndef GIGASECOND_H
#define GIGASECOND_H

#include <boost/date_time.hpp>
#include "boost/date_time/posix_time/posix_time.hpp"

#define EXERCISM_RUN_ALL_TESTS

using namespace boost::posix_time;

namespace gigasecond
{
    ptime advance(const ptime& start)
    {
        return start + seconds(1000000000);
    }
}

#endif