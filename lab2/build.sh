rm -rdf build dist
mkdir -p build dist

javac -cp "src:Pokemon.jar" -d build ./src/**.java
cp MANIFEST.MF build/
cp Pokemon.jar dist/

cd build
jar -c -m MANIFEST.MF -f ../dist/battle.jar ./** 
