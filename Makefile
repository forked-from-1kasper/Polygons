FILES=vector.scala polygon.scala main.scala
LIBS=
CLASSNAME=GraphicsApp
OUTPUT=out/

build: clean
	mkdir $(OUTPUT)
	scalac -encoding utf8 -classpath "$(LIBS)" $(FILES) -d $(OUTPUT)

run:
	scala -classpath "$(LIBS);out" $(CLASSNAME)

clean:
	rm -rf $(OUTPUT)
