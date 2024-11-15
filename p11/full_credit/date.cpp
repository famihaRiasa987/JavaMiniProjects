#include "date.h"

// Constructor to initialize the Date object
Date::Date(int year, int month, int day) : _year(year), _month(month), _day(day) {}

// Overload the << operator for outputting the Date object in the desired format
std::ostream& operator<<(std::ostream& ost, const Date& date) {
    char old_fill = ost.fill();
    ost << date._year << '/'
        << std::setw(2) << std::setfill('0') << date._month << '/'
        << std::setw(2) << std::setfill('0') << date._day;
    ost.fill(old_fill); // Restore the original fill character
    return ost;
}
