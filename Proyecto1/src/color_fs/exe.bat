SET JAVA_HOME="C:\Program Files\Java\jdk1.8.0_161\bin"
SET PATH=%JAVA_HOME%;%PATH%
SET CLASSPATH=%JAVA_HOME%;
SET JFLEX_HOME= C:\analizadores\jflex-1.6.1


cd C:\Users\Pamela Palacios\Documents\2019\proyecto1_2019\Proyecto1\src\color_fs
java -jar %JFLEX_HOME%\lib\jflex-1.6.1.jar f_lexico.jflex

cd C:\Users\Pamela Palacios\Documents\2019\proyecto1_2019\Proyecto1\src\color_fs
java -jar C:\analizadores\java-cup-bin-11b-20160615\java-cup-11b.jar -parser f_sintactico -symbols f_simb f_sintactico.cup 


