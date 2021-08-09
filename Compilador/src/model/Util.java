/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author willi
 */
public class Util {
    //Mensagens
    public static final String MESSAGEM_ERRO_LINHA = "Erro na linha %s – %s";
    public static final String MESSAGEM_ERRO_TOKEN_INVALIDO_LINHA = "Erro na linha %s – %s %s";
    public static final String COMPILADO_SUCESSO = "Programa compilado com sucesso";
    public static final String FIM_ARQUIVO = "fim de arquivo";
    public static final String SIMBOLO_INVALIDO = "símbolo inválido";
    //Simbolos
    public static final String UNDERLINE = "_";
    public static final String ESPACO = " ";
    public static final String FIM_ALGORITMO = "$";
    public static final char QUEBRA_LINHA = '\n';
    //Tipos
    public static final String BOOLEAN = "bool";
    public static final String STRING = "string";
    public static final String FLOAT = "float64";
    public static final String INT = "int64";
    public static final String VOID = "void";
    //Comandos
    public static final String OR = "or";
    public static final String AND = "and";
    public static final String LDSTR = "ldstr";
    public static final String RET = "ret";
    public static final String LDC_I4_0 = "ldc.i4.0";
    public static final String XOR = "xor";
    public static final String LDC_I4_1 = "ldc.i4.1";
    public static final String CGT = "cgt";
    public static final String CLT = "clt";
    public static final String CEQ = "ceq";
    public static final String LDC_I8_1 = "ldc.i8 -1";
    public static final String LDC_R8 = "ldc.r8 ";
    public static final String LDC_I8 = "ldc.i8 ";
    public static final String DIV = "div";
    public static final String MUL = "mul";
    public static final String SUB = "sub";
    public static final String ADD = "add";
    public static final String CLOSE_BRACES = "}";
    public static final String PROGRAM_HEADER = ".assembly extern mscorlib {}\n" + ".assembly %s{}\n" + ".module %s.exe\n" + ".class public _Principal{\n"
            + ".method static public void _principal()\n" + "{ .entrypoint";
    public static final String PRINT = "call void [mscorlib]System.Console::Write(%s)";
    //Operadores Relacionais
    public static final String GREATER_THAN_OR_EQUAL = ">=";
    public static final String LESS_THAN_OR_EQUAL = "<=";
    public static final String NOT_EQUAL = "<>";
    public static final String GREATER_THAN = ">";
    public static final String LESS_THAN = "<";
    public static final String EQUALS = "=";
}
