#include <iostream>
#include <string>
#include "clock.h"

int main(int argc, char* argv[]) {
    if (argc != 4) {
        std::cerr << "usage: clock <hour> <minutes> <seconds>" << std::endl;
        return -1;
    }

    try {
        int hours = std::stoi(argv[1]);
        int minutes = std::stoi(argv[2]);
        int seconds = std::stoi(argv[3]);

        Clock clock(hours, minutes, seconds);
        
        std::string input;
        while (true) {
            clock.print();
            std::cout << "Enter 'q' to quit or any key to increment: ";
            std::getline(std::cin, input);
            if (input == "q") break;
            clock.tic();
        }

    } catch (const std::out_of_range& e) {
        std::cerr << e.what() << std::endl;
        return -2;
    } catch (const std::invalid_argument&) {
        std::cerr << "Invalid input. Please provide integers for hour, minutes, and seconds." << std::endl;
        return -2;
    }

    return 0;
}
