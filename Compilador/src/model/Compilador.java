package model;

import javax.swing.JOptionPane;



public final class Compilador {
    
    private boolean compilando = false;
    private Semantico semantico;
    private final Lexico lexico;
    private final Sintatico sintatico;
    private Tradutor tradutor;
    public Compilador(final Lexico lexico, final Sintatico sintatico) {
        this.lexico = lexico;
        this.sintatico = sintatico;
    }

    public String compile(final String codigoFote, String nomeArquivo) {
        try {
            semantico = new Semantico(nomeArquivo.replace(Util.ESPACO, Util.UNDERLINE));

            lexico.setInput(codigoFote);
            sintatico.parse(lexico, semantico);

            this.compilando = true;
            tradutor = new Tradutor("Arquivo", codigoFote);
            
            return Util.COMPILADO_SUCESSO;
        } catch (final LexicalError e) {
            this.compilando = false;
            
            if (e.getMessage().equals(Util.SIMBOLO_INVALIDO)) {
                return String.format(Util.MESSAGEM_ERRO_TOKEN_INVALIDO_LINHA, procurarLinha(codigoFote, e.getPosition()), codigoFote.charAt(e.getPosition()),
                        e.getMessage());
            } else {
                return String.format(Util.MESSAGEM_ERRO_LINHA, procurarLinha(codigoFote, e.getPosition()), e.getMessage());
            }
        } catch (final SyntaticError e) {
            this.compilando = false;
            

            String token = e.getToken();
            if (token.equals(Util.FIM_ALGORITMO)) {
                token = Util.FIM_ARQUIVO;
            }
            return String.format(Util.MESSAGEM_ERRO_LINHA, procurarLinha(codigoFote, e.getPosition()), String.format(e.getMessage(), token));
        } catch (final SemanticError e) {
            this.compilando = false;
            return String.format(Util.MESSAGEM_ERRO_LINHA, procurarLinha(codigoFote, e.getPosition()), e.getMessage());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao traduzir codigo para JAVA", "Erro", JOptionPane.ERROR_MESSAGE); 
            return null;
        }
 
    }

    public boolean estaCompilando() {
        return this.compilando;
    }

    public String getSourceCode() {
        return this.semantico.getSourceCode();
    }

    private int procurarLinha(final String sourceCode, final int index) {
        final String fileContentAfterIndex = sourceCode.substring(0, index);

        int lineCounter = 1;
        for (int i = 0; i < fileContentAfterIndex.length(); i++) {
            if (fileContentAfterIndex.charAt(i) == Util.QUEBRA_LINHA) {
                lineCounter++;
            }
        }
        return lineCounter;
    }
    
    

}
