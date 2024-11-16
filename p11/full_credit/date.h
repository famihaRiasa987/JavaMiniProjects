#ifndef DATE_H
#define DATE_H

#include <iostream>
#include <iomanip>

class Date {
private:
    int _year, _month, _day;

    // Helper function for comparisons
    int compare(const Date& rhs) const;

public:
    // Constructor with default values (January 1, 1970)
    Date(int year = 1970, int month = 1, int day = 1);

    // Comparison operators
    bool operator==(const Date& rhs) const;
    bool operator!=(const Date& rhs) const;
    bool operator<(const Date& rhs) const;
    bool operator<=(const Date& rhs) const;
    bool operator>(const Date& rhs) const;
    bool operator>=(const Date& rhs) const;

    // Friend function for outputting Date in YYYY/MM/DD format
    friend std::ostream& operator<<(std::ostream& os, const Date& date);

    // Friend function for reading input in the format "YYYY M D"
    friend std::istream& operator>>(std::istream& is, Date& date);
};

#endif // DATE_H
