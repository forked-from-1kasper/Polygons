FILES=V.scala Move.scala Poly.scala GraphicsApp.scala Window.scala
LIBS=jar/scalaz-core_2.12-7.2.20.jar;jar/scalaz-effect_2.12-7.2.20.jar
CLASSNAME=animegular.GraphicsApp
OUTPUT=out
JARNAME=app.jar

build: clean
	mkdir $(OUTPUT)
	scalac -encoding utf8 -classpath "$(LIBS)" $(FILES) -d $(OUTPUT) -feature

run:
	scala -classpath "$(LIBS);out" $(CLASSNAME)

clean:
	rm -rf $(OUTPUT)

jar: build
	jar cvfm $(JARNAME) MANIFEST.MF -C $(OUTPUT) .
