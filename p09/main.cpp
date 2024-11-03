#include <iostream>
#include <chrono>
#include <thread>
#include <unistd.h> // for non-blocking input in UNIX
#include "clock.h"

bool kbhit() {
    struct timeval tv = { 0, 0 };
    fd_set readfds;
    FD_ZERO(&readfds);
    FD_SET(STDIN_FILENO, &readfds);
    return select(STDIN_FILENO + 1, &readfds, NULL, NULL, &tv) == 1;
}

int main(int argc, char* argv[]) {
    if (argc != 4) {
        std::cerr << "usage: clock <hour> <minutes> <seconds>\n";
        return -1;
    }

    int hour = std::stoi(argv[1]);
    int minute = std::stoi(argv[2]);
    int second = std::stoi(argv[3]);

    try {
        Clock clock(hour, minute, second);

        while (true) {
            clock.print();

            if (kbhit()) {
                char ch;
                std::cin >> ch;
                if (ch == 'q' || ch == 'Q') {
                    break;
                }
            }

            clock.tic();
            std::this_thread::sleep_for(std::chrono::seconds(1));
        }
    } catch (const std::out_of_range& e) {
        std::cerr << e.what() << '\n';
        return -2;
    }

    return 0;
}
