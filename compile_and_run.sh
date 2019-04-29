(echo "Compiling...") \
&& (javac src/*.java) \
&& (echo "Compiled successfully! Running...") \
&& (echo "") \
&& (java -ea -classpath src/ MainDriver $1)

