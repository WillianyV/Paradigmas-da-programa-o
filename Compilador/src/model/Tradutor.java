/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author willi
 */
public class Tradutor {

    Scanner arquivo;
    String nomeArq;
    File saidaJava;
    FileWriter gravar;
    PrintWriter saida;

    public Tradutor(String nome, String codigoFonte) {
        try {
            nome = new String();
            arquivo = new Scanner(new BufferedReader(new FileReader(nome + ".txt")));
            codigoFonte = new String();
            //nomeArq = new String();

            saidaJava = new File(codigoFonte + ".java");
            gravar = new FileWriter(new File(codigoFonte + ".java"), true);
            saida = new PrintWriter(gravar, true);

            while (arquivo.hasNext()) {
                String aux = new String();
                aux = codigoFonte;
                codigoFonte = arquivo.next();

                if (codigoFonte.compareToIgnoreCase("Algoritimo") == 0) {
                    codigoFonte = arquivo.next();
                    System.out.println("public class " + codigoFonte + " {");
                    saida.println("public class " + codigoFonte + " {");

                }

                /*
              Tipos   de   dados   
                 */
                if (codigoFonte.compareToIgnoreCase("variavel") == 0) {
                    codigoFonte = arquivo.next();
                    String nomeVariavel = new String();
                    nomeVariavel = codigoFonte;
                    codigoFonte = arquivo.next();
                    codigoFonte = arquivo.next();
                    String novoTipo = new String();
                    if (codigoFonte.compareToIgnoreCase("inteiro") == 0) {
                        novoTipo = "int ";
                        System.out.println("static " + novoTipo + nomeVariavel + ";");
                        saida.println("static " + novoTipo + nomeVariavel + ";\n");
                    }
                    if (codigoFonte.compareToIgnoreCase("real") == 0) {
                        novoTipo = "float ";
                        System.out.println("static " + novoTipo + nomeVariavel + ";");
                        saida.println("static " + novoTipo + nomeVariavel + ";\n");
                    }
                    if (codigoFonte.compareToIgnoreCase("caracter") == 0) {
                        novoTipo = "String ";
                        System.out.println("static " + novoTipo + nomeVariavel + ";");
                        saida.println("static " + novoTipo + nomeVariavel + ";");
                    }
                    if (codigoFonte.compareToIgnoreCase("logico") == 0) {
                        novoTipo = "boolean ";
                        System.out.println("static " + novoTipo + nomeVariavel + ";");
                        saida.println("static " + novoTipo + nomeVariavel + ";");
                    }
                }

                if (codigoFonte.compareToIgnoreCase("inicio") == 0) {
                    codigoFonte = arquivo.next();
                    System.out.println("public static void main(String[] args) {");
                    saida.println("public static void main(String[] args) {");
                }

                /*
            Comandos de Saída e Entrada de Dados 
                 */
                if (codigoFonte.compareToIgnoreCase("escreva") == 0) {
                    System.out.print("    System.out.println( ");
                    saida.println("    System.out.println( ");
                    int cont = 0;
                    while (cont <= 1) {
                        codigoFonte = arquivo.next();
                        System.out.print(codigoFonte + " ");
                        saida.println(codigoFonte + " ");
                        if (codigoFonte.compareToIgnoreCase(";") == 0) {
                            cont = 2;
                        }
                    }
                    System.out.println(" );");
                    saida.println(" );");
                }
                if (codigoFonte.compareToIgnoreCase("leia") == 0) {
                    System.out.print(" Scanner leia = new Scanner(");
                    saida.println("Scanner leia = new Scanner(");
                    int cont = 0;
                    while (cont <= 1) {
                        codigoFonte = arquivo.next();
                        System.out.print(codigoFonte + " ");
                        saida.println(codigoFonte + " ");
                        if (codigoFonte.compareToIgnoreCase(";") == 0) {
                            cont = 2;
                        }
                    }
                    System.out.println(" );");
                    saida.println(" );");
                }

                /*
            Operadores   Relacionais   
                 */
                if (codigoFonte.compareToIgnoreCase("<-") == 0) {
                    System.out.print(aux + " = ");
                    saida.println(aux + " = ");
                    int cont = 0;
                    while (cont <= 1) {
                        codigoFonte = arquivo.next();
                        System.out.print(codigoFonte);
                        saida.println(codigoFonte);
                        if (codigoFonte.compareToIgnoreCase(";") == 0) {
                            cont = 2;
                        }
                    }
                    System.out.println(" ");
                    saida.println(" ");
                }
                if (codigoFonte.compareToIgnoreCase("<>") == 0) {
                    System.out.print(aux + " != ");
                    saida.println(aux + " != ");
                    int cont = 0;
                    while (cont <= 1) {
                        codigoFonte = arquivo.next();
                        System.out.print(codigoFonte);
                        saida.println(codigoFonte);
                        if (codigoFonte.compareToIgnoreCase(";") == 0) {
                            cont = 2;
                        }
                    }
                    System.out.println(" ");
                    saida.println(" ");
                }
                if (codigoFonte.compareToIgnoreCase("=") == 0) {
                    System.out.print(aux + " == ");
                    saida.println(aux + " == ");
                    int cont = 0;
                    while (cont <= 1) {
                        codigoFonte = arquivo.next();
                        System.out.print(codigoFonte);
                        saida.println(codigoFonte);
                        if (codigoFonte.compareToIgnoreCase(";") == 0) {
                            cont = 2;
                        }
                    }
                    System.out.println(" ");//coloquei so p jogar a outra linha p baixo
                    saida.println(" ");
                }

                /*
            Operadores   Lógicos 
                 */
                if (codigoFonte.compareToIgnoreCase("nao") == 0) {
                    System.out.print(aux + " ! ");
                    saida.println(aux + " ! ");
                    int cont = 0;
                    while (cont <= 1) {
                        codigoFonte = arquivo.next();
                        System.out.print(codigoFonte);
                        saida.println(codigoFonte);
                        if (codigoFonte.compareToIgnoreCase(";") == 0) {
                            cont = 2;
                        }
                    }
                    System.out.println(" ");
                    saida.println(" ");
                }
                if (codigoFonte.compareToIgnoreCase("e") == 0) {
                    System.out.print(aux + " && ");
                    saida.println(aux + " && ");
                    int cont = 0;
                    while (cont <= 1) {
                        codigoFonte = arquivo.next();
                        System.out.print(codigoFonte);
                        saida.println(codigoFonte);
                        if (codigoFonte.compareToIgnoreCase(";") == 0) {
                            cont = 2;
                        }
                    }
                    System.out.println(" ");
                    saida.println(" ");
                }
                if (codigoFonte.compareToIgnoreCase("ou") == 0) {
                    System.out.print(aux + " || ");
                    saida.println(aux + " || ");
                    int cont = 0;
                    while (cont <= 1) {
                        codigoFonte = arquivo.next();
                        System.out.print(codigoFonte);
                        saida.println(codigoFonte);
                        if (codigoFonte.compareToIgnoreCase(";") == 0) {
                            cont = 2;
                        }
                    }
                    System.out.println(" ");
                    saida.println(" ");
                }

                if (codigoFonte.compareToIgnoreCase("se") == 0) {
                    System.out.print(" if ( ");
                    saida.println("if ( ");

                    codigoFonte = arquivo.next();
                    String se = new String();
                    se = codigoFonte;
                    codigoFonte = arquivo.next();
                    if (codigoFonte.compareToIgnoreCase("entao") == 0) {
                        System.out.println(" );");
                        saida.println(" );");
                    }
                }
                if (codigoFonte.compareToIgnoreCase("senao") == 0) {
                    System.out.print(" } else{ ");
                    saida.println(" } else { ");
                    int cont = 0;
                    while (cont <= 1) {
                        codigoFonte = arquivo.next();
                        System.out.print(codigoFonte);
                        saida.println(codigoFonte);
                        if (codigoFonte.compareToIgnoreCase(";") == 0) {
                            cont = 2;
                        }
                    }
                    System.out.println(" } ");//coloquei so p jogar a outra linha p baixo
                    saida.println(" } ");

                }
                if (codigoFonte.compareToIgnoreCase("repita") == 0) {
                    codigoFonte = arquivo.next();
                    codigoFonte = arquivo.next();
                    if (codigoFonte.compareToIgnoreCase("ate") == 0) {
                        codigoFonte = arquivo.next();
                        String ate = new String();
                        ate = codigoFonte;
                        codigoFonte = arquivo.next();
                        System.out.println(" do {" + codigoFonte + "} while(" + ate + ")");
                        saida.println(" do {" + codigoFonte + "} while(" + ate + ")");

                    } else {
                        System.out.println("Erro de comando!");
                        saida.println("Erro de comando!");
                    }
                }
                if (codigoFonte.compareToIgnoreCase("fim;") == 0) {
                    System.out.println("}");
                    saida.println("}");
                }
                if (codigoFonte.compareToIgnoreCase("fim") == 0) {
                    System.out.println("}");
                    saida.println("}");
                }
                saida.close();

                gravar.close();

                arquivo.close();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Tradutor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Tradutor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
