JAVA=@java
JAVAC=@javac
JFLEX=$(JAVA) -jar jflex.jar
CUP=$(JAVA) -jar java-cup-11b.jar -interface
RUNTIME=java-cup-11b-runtime.jar 

ifdef OS
	RM = @del /S /q *.class *.java~
	COMPILE = $(JAVAC) -cp .;$(RUNTIME) MParser.java Parser.java sym.java
	EXECUTE = $(JAVA) -cp .;$(RUNTIME) Parser.java
else
	RM = @rm *.class *.java~
	COMPILE = $(JAVAC) -cp .:$(RUNTIME) MParser.java Parser.java sym.java
	EXECUTE = $(JAVA) -cp .:$(RUNTIME) Parser.java
endif

run:
	$(JFLEX) minilang.jflex
	$(CUP) -parser Parser minilang.cup
	$(COMPILE)
	$(EXECUTE) Main
l1:
	$(JFLEX) minilang.jflex
	$(CUP) -parser Parser minilang.cup
	$(COMPILE)
	$(EXECUTE) MainL1
l2:
	$(JFLEX) minilang.jflex
	$(CUP) -parser Parser minilang.cup
	$(COMPILE)
	$(EXECUTE) MainL2
s1:
	$(JFLEX) minilang.jflex
	$(CUP) -parser Parser minilang.cup
	$(COMPILE)
	$(EXECUTE) MainS1
s2:
	$(JFLEX) minilang.jflex
	$(CUP) -parser Parser minilang.cup
	$(COMPILE)
	$(EXECUTE) MainS2
clean:
	@$(RM)