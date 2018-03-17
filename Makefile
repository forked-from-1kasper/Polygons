S=:

LIBS=
CLASSNAME=animegular.GraphicsApp
OUTPUT=out
JARNAME=animegular.jar

build: clean
	mkdir $(OUTPUT)
	scalac -encoding utf8 -classpath "$(LIBS)" *.scala -d $(OUTPUT) -feature

run:
	scala -classpath "$(LIBS)$Sout" $(CLASSNAME)

clean:
	rm -rf $(OUTPUT)

jar: build
	jar cvfm $(JARNAME) MANIFEST.MF -C $(OUTPUT) .
