#ifndef CLOCK_H
#define CLOCK_H

#include <stdexcept>

class Clock {
public:
    Clock(int hours, int minutes, int seconds);
    virtual ~Clock() = default;
    void print() const;
    void tic();

private:
    int _hours;
    int _minutes;
    int _seconds;
};

#endif
