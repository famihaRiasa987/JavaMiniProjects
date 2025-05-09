#ifndef PURSE_H
#define PURSE_H

#include <iostream>
#include <compare> 

using std::ostream;
using std::istream;

class Purse {
    int _pounds;
    int _shillings;
    int _pence;

    void rationalize();

public:
    Purse(int pounds = 0, int shillings = 0, int pence = 0);

    friend ostream& operator<< (ostream& out, const Purse& purse);
    friend istream& operator>> (istream& ist, Purse& purse);

        auto operator<=>(const Purse& purse) const = default;


    Purse& operator++();
    Purse operator++(int);

    Purse operator+ (const Purse& purse);
    Purse operator- (const Purse& purse);

    Purse& operator+= (const Purse& purse);
    Purse& operator-= (const Purse& purse);





};




#endif