#!/bin/bash
cd ..
export CLASSPATH=lib/junit-4.7.jar:lib/scalatest-1.0.jar:bin

scala org.junit.runner.JUnitCore imagem.MatrizTest
scala org.scalatest.tools.Runner -p . -o -s util.LeituraSuite
scala org.junit.runner.JUnitCore imagem.FuncoesSuite
#scala org.scalatest.tools.Runner -p . -o -s algoritmos.SilhuetaAlgoritmos