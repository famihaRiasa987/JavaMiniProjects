#include "Date.h"

Date::Date(int year, int month, int day) : _year(year), _month(month), _day(day) {}
int Date::compare(const Date& rhs) const {
    if (_year != rhs._year) return _year - rhs._year;
    if (_month != rhs._month) return _month - rhs._month;
    return _day - rhs._day;
}

bool Date::operator==(const Date& rhs) const { return compare(rhs) == 0; }
bool Date::operator!=(const Date& rhs) const { return compare(rhs) != 0; }
bool Date::operator<(const Date& rhs) const { return compare(rhs) < 0; }
bool Date::operator<=(const Date& rhs) const { return compare(rhs) <= 0; }
bool Date::operator>(const Date& rhs) const { return compare(rhs) > 0; }
bool Date::operator>=(const Date& rhs) const { return compare(rhs) >= 0; }

std::ostream& operator<<(std::ostream& os, const Date& date) {
    char old_fill = os.fill('0');
    os << date._year << '/' 
       << std::setw(2) << date._month << '/' 
       << std::setw(2) << date._day;
    os.fill(old_fill);
    return os;
}
std::istream& operator>>(std::istream& is, Date& date) {
    is >> date._year >> date._month >> date._day;
    return is;
}
