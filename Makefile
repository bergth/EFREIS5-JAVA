default:
	javac *.java

run: default
	java Main


clean:
	rm -rf *.class
	rm -rf out
