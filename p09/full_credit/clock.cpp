#include <iostream>
#include <iomanip>
#include "clock.h"

Clock::Clock(int hours, int minutes, int seconds)
    : _hours(hours), _minutes(minutes), _seconds(seconds) {
    if (_hours < 0 || _hours > 23) throw std::out_of_range("Invalid hour: " + std::to_string(_hours));
    if (_minutes < 0 || _minutes > 59) throw std::out_of_range("Invalid minute: " + std::to_string(_minutes));
    if (_seconds < 0 || _seconds > 59) throw std::out_of_range("Invalid second: " + std::to_string(_seconds));
}

void Clock::print() const {
    std::cout << "The time is now "
              << std::setw(2) << std::setfill('0') << _hours << " "
              << std::setw(2) << std::setfill('0') << _minutes << " "
              << std::setw(2) << std::setfill('0') << _seconds << "\n";
}

void Clock::tic() {
    _seconds++;
    if (_seconds == 60) {
        _seconds = 0;
        _minutes++;
        if (_minutes == 60) {
            _minutes = 0;
            _hours = (_hours + 1) % 24;
        }
    }
}
