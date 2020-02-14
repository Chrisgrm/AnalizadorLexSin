/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author chris
 */
public class FrmAnalizador extends javax.swing.JFrame {
    
    public FrmAnalizador() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        Resultado = new javax.swing.JTextArea();
        btn_analizar = new javax.swing.JButton();

        Resultado.setColumns(20);
        Resultado.setRows(5);
        jScrollPane2.setViewportView(Resultado);

        btn_analizar.setText("jButton1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(btn_analizar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 91, Short.MAX_VALUE)
                .addComponent(btn_analizar))
        );
    }// </editor-fold>//GEN-END:initComponents

     private void btn_analizarActionPerformed(java.awt.event.ActionEvent evt) {                                             
        int cont = 1;
        JFileChooser escoger = new JFileChooser();
        escoger.showOpenDialog(null);
        try {
            Reader lectura = new BufferedReader(new FileReader(escoger.getSelectedFile()));
            Lexer lexicos = new Lexer(lectura);
            String result = "";
            while (true) {
                Tokens tokens = lexicos.yylex();
                if (tokens == null) {
                    result += "Final";
                    Resultado.setText(result);
                    return;
                }
                switch (tokens) {
                    case Linea:
                        cont++;
                        result += "LINEA " + cont + "\n";
                        break;
                    case Comillas:
                        result += " <Comillas>\t\t" + lexicos.lexeme + "\n";
                        break;
                    case Cadena:
                        result += " <Tipo de dato>\t" + lexicos.lexeme + "\n";
                        break;
                    case T_dato:
                        result += " <Tipo de dato>\t" + lexicos.lexeme + "\n";
                        break;
                    case If:
                        result += " <Reservada if>\t" + lexicos.lexeme + "\n";
                        break;
                    case Else:
                        result += " <Reservada else>\t" + lexicos.lexeme + "\n";
                        break;
                    case Do:
                        result += " <Reservada do>\t" + lexicos.lexeme + "\n";
                        break;
                    case While:
                        result += " <Reservada while>\t" + lexicos.lexeme + "\n";
                        break;
                    case For:
                        result += " <Reservada while>\t" + lexicos.lexeme + "\n";
                        break;
                    case Igual:
                        result += " <Operador igual>\t" + lexicos.lexeme + "\n";
                        break;
                    case Suma:
                        result += " <Operador suma>\t" + lexicos.lexeme + "\n";
                        break;
                    case Resta:
                        result += " <Operador resta>\t" + lexicos.lexeme + "\n";
                        break;
                    case Multiplicacion:
                        result += " <Operador multiplicacion>\t" + lexicos.lexeme + "\n";
                        break;
                    case Division:
                        result += " <Operador division>\t" + lexicos.lexeme + "\n";
                        break;
                    case Op_logico:
                        result += " <Operador logico>\t" + lexicos.lexeme + "\n";
                        break;
                    case Op_incremento:
                        result += " <Operador incremento>\t" + lexicos.lexeme + "\n";
                        break;
                    case Op_relacional:
                        result += " <Operador relacional>\t" + lexicos.lexeme + "\n";
                        break;
                    case Op_atribucion:
                        result += " <Operador atribucion>\t" + lexicos.lexeme + "\n";
                        break;
                    case Op_booleano:
                        result += " <Operador booleano>\t" + lexicos.lexeme + "\n";
                        break;
                    case Parentesis_a:
                        result += " <Parentesis de apertura>\t" + lexicos.lexeme + "\n";
                        break;
                    case Parentesis_c:
                        result += " <Parentesis de cierre>\t" + lexicos.lexeme + "\n";
                        break;
                    case Llave_a:
                        result += " <Llave de apertura>\t" + lexicos.lexeme + "\n";
                        break;
                    case Llave_c:
                        result += " <Llave de cierre>\t" + lexicos.lexeme + "\n";
                        break;
                    case Corchete_a:
                        result += " <Corchete de apertura>\t" + lexicos.lexeme + "\n";
                        break;
                    case Corchete_c:
                        result += " <Corchete de cierre>\t" + lexicos.lexeme + "\n";
                        break;
                    case Main:
                        result += " <Reservada main>\t" + lexicos.lexeme + "\n";
                        break;
                    case P_coma:
                        result += " <Punto y coma>\t" + lexicos.lexeme + "\n";
                        break;
                    case Identificador:
                        result += " <Identificador>\t\t" + lexicos.lexeme + "\n";
                        break;
                    case Numero:
                        result += " <Numero>\t\t" + lexicos.lexeme + "\n";
                        break;
                    case ERROR:
                        result += " <Simbolo no definido>\n";
                        break;
                    default:
                        result += " < " + lexicos.lexeme + " >\n";
                        break;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrmAnalizador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FrmAnalizador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                                            

    public void LexerFile() throws IOException {

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Resultado;
    private javax.swing.JButton btn_analizar;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
