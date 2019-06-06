(echo "Compiling...") \
&& (javac java_src/*.java) \
&& (echo "Compiled successfully! Running...") \
&& (echo "") \
&& (java -ea -classpath java_src/ MainDriver $1)

