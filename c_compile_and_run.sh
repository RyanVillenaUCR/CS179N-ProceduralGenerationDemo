(echo "Compiling...") \
&& (g++ -g -o proc_gen cpp_src/*.cpp cpp_src/*.hpp) \
&& (mv proc_gen cpp_src/) \
&& (echo "Compiled! Running...") \
&& (echo "") \
&& (./cpp_src/proc_gen)
