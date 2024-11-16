CXXFLAGS += --std=c++20

list_temps: list_temps.o date.o
	$(CXX) $(CXXFLAGS) list_temps.o date.o -o list_temps

list_temps.o: list_temps.cpp date.h
	$(CXX) $(CXXFLAGS) -c list_temps.cpp -o list_temps.o

date.o: date.cpp date.h
	$(CXX) $(CXXFLAGS) -c date.cpp -o date.o

clean:
	rm -f *.o list_temps
