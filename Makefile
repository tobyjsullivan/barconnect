OUTDIR = classes

build:
	javac ca/tark/barconnect/*.java -d $(OUTDIR)

clean:
	rm -Rf $(OUTDIR)/*

run:
	java -cp $(OUTDIR) ca.tark.barconnect.BarServer

remake: clean build
