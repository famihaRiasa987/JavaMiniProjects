
#include "purse.h"


Purse::Purse(int pounds, int shillings, int pence)
    : _pounds(pounds), _shillings(shillings), _pence(pence) {
    rationalize();
 
}
    ostream& operator<< (ostream& ost , const Purse& purse){

        ost << "£" << purse._pounds <<" "<< purse._shillings <<"s" << purse._pence <<"d";
        return ost; 

    }

    istream& operator>> (istream& ist, Purse& purse){
        ist >> purse._pounds >> purse._shillings >> purse._pence;
        return ist;

    }

    Purse& Purse::operator++(){
        _pence++;
        rationalize();
        return *this;
    }
    Purse Purse::operator++(int){
        Purse temp = *this;
        ++(*this);
        return temp;
    }



    Purse Purse::operator+ (const Purse& purse){

        Purse result(_pounds + purse._pounds, _shillings + purse._shillings, _pence +purse._pence);
        result.rationalize();
        return result;

    }

    Purse Purse:: operator- (const Purse& purse){
        Purse result(_pounds - purse._pounds, _shillings - purse._shillings, _pence - purse._pence);
        result.rationalize();
        return result;
    }

    Purse& Purse::operator+= (const Purse& purse){

        _pounds += purse._pounds;
        _shillings += purse._shillings;
        _pence += purse._pence;

        rationalize();
        return *this;

    }

    Purse& Purse::operator-= (const Purse& purse){

        _pounds -= purse._pounds;
        _shillings -= purse._shillings;
        _pence -= purse._pence;

        rationalize();
        return *this;

    }


void Purse::rationalize() {
    if (_pence >= 12) {
        _shillings += _pence / 12;
        _pence %= 12;
    } else if (_pence < 0) {
        int borrow = (-_pence + 11) / 12;
        _shillings -= borrow;
        _pence += borrow * 12;
    }

    if (_shillings >= 20) {
        _pounds += _shillings / 20;
        _shillings %= 20;
    } else if (_shillings < 0) {
        int borrow = (-_shillings + 19) / 20;
        _pounds -= borrow;
        _shillings += borrow * 20;
    }

    if (_pounds < 0) {
        _pounds = 0;
        _shillings = 0;
        _pence = 0;
    }
}
