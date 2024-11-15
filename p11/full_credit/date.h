#ifndef DATE_H
#define DATE_H

#include <iostream>
#include <iomanip>
#include <compare>

class Date {
    int _year, _month, _day;

public:
    // Constructor with default values
    Date(int year = 1970, int month = 1, int day = 1) : _year(year), _month(month), _day(day) {}

    // Three-way comparison operator for sorting and comparisons
    auto operator<=>(const Date&) const = default;

    // Friend function for outputting dates in YYYY/MM/DD format
    friend std::ostream& operator<<(std::ostream& ost, const Date& date) {
        char old_fill = ost.fill();
        ost << date._year << '/'
            << std::setw(2) << std::setfill('0') << date._month << '/'
            << std::setw(2) << std::setfill('0') << date._day;
        ost.fill(old_fill);
        return ost;
    }
};

#endif

