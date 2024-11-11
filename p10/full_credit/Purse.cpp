#include "Purse.h"


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

    
   