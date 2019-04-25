(echo "Compiling...") \
&& (javac src/*.java) \
&& (echo "Compiled successfully! Running...") \
&& (echo "") \
&& (java -classpath src/ MainDriver)

