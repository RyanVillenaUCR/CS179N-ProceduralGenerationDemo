(echo "Compiling...") \
&& (g++ -g -o proc_gen cpp_src/*.cpp cpp_src/*.hpp) \
&& (mv proc_gen cpp_src/) \
&& (echo "Compiled! Testing with valgrind...") \
&& (echo "") \
&& (valgrind --leak-check=full ./cpp_src/proc_gen)
