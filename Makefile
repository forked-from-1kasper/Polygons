FILES=vector.scala polygon.scala main.scala
LIBS=
CLASSNAME=polygons.GraphicsApp
OUTPUT=out
JARNAME=app.jar

build: clean
	mkdir $(OUTPUT)
	scalac -encoding utf8 -classpath "$(LIBS)" $(FILES) -d $(OUTPUT)

run:
	scala -classpath "$(LIBS);out" $(CLASSNAME)

clean:
	rm -rf $(OUTPUT)

jar: build
	jar cvfm $(JARNAME) MANIFEST.MF -C $(OUTPUT) .
