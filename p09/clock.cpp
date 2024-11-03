#include "clock.h"

Clock::Clock(int hours, int minutes, int seconds) 
    : _hours(hours), _minutes(minutes), _seconds(seconds) {
    if (_hours < 0 || _hours > 23) {
        throw std::out_of_range("Hours out of range: " + std::to_string(_hours));
    }
    if (_minutes < 0 || _minutes > 59) {
        throw std::out_of_range("Minutes out of range: " + std::to_string(_minutes));
    }
    if (_seconds < 0 || _seconds > 59) {
        throw std::out_of_range("Seconds out of range: " + std::to_string(_seconds));
    }
}

void Clock::print() const {
    std::cout << std::setw(2) << std::setfill('0') << _hours << ":"
              << std::setw(2) << std::setfill('0') << _minutes << ":"
              << std::setw(2) << std::setfill('0') << _seconds << std::endl;
}

void Clock::tic() {
    _seconds++;
    if (_seconds == 60) {
        _seconds = 0;
        _minutes++;
        if (_minutes == 60) {
            _minutes = 0;
            _hours++;
            if (_hours == 24) {
                _hours = 0;
            }
        }
    }
}
