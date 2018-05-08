import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame{
    private JButton jbtrun = new JButton("RUN");
    private JButton jbtre =new JButton("RESET");
    private JButton jbtexit = new JButton("EXIT");
    private JButton jbt [] [ ] = new JButton [3][3];
    private Container cp ;
    private JPanel jpnc = new JPanel(new GridLayout(3,3,3,3));
    private JPanel jpnr = new JPanel(new GridLayout(3,1,3,3));
    private boolean flag = true;
    public MainFrame(){
        init();
    }
    private void init() {
        setBounds(100, 100, 600, 600);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cp = this.getContentPane();
        jpnr.add(jbtrun);
        jpnr.add(jbtre);
        jpnr.add(jbtexit);
        cp.add(jpnc, BorderLayout.CENTER);
        cp.add(jpnr, BorderLayout.EAST);


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                jbt[i][j] = new JButton();
                jbt[i][j].setBackground(new Color(91, 255, 209));
                jbt[i][j].setFont(new Font(null, Font.BOLD, 72));
                jpnc.add(jbt[i][j]);
                jbt[i][j].addActionListener(new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton tmpbon = (JButton) e.getSource();
                        if (tmpbon.getText().equals("")) {
                            if (flag) {
                                tmpbon.setText("O");
                            } else {
                                tmpbon.setText("X");
                            }
                            win();
                            flag = !flag;
                        }
                    }
                });
            }
        }

        jbtexit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        jbtrun.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0;i<3;i++){
                    for(int j = 0;j<3;j++){
                        jbt[i][j].setEnabled(true);
                    }
                }

            }
        });


        jbtre.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        jbt[i][j].setText("");
                        jbt[i][j].setEnabled(false);
                        jbt[i][j].setFont(new Font(null, Font.BOLD, 72));
                    }
                }
            }
        });

    }
    public void win () {
        if (jbt[0][0].getText().equals(jbt[0][1].getText()) && jbt[0][0].getText().equals(jbt[0][2].getText()) && !jbt[0][0].getText().equals("")) {
            JOptionPane.showMessageDialog(MainFrame.this,"~~win~~");
        }
        else if (jbt[1][0].getText().equals(jbt[1][1].getText()) && jbt[1][0].getText().equals(jbt[1][2].getText()) && !jbt[1][0].getText().equals("")){
            JOptionPane.showMessageDialog(MainFrame.this,"~~win~~");
        }
        else if (jbt[2][0].getText().equals(jbt[2][1].getText()) && jbt[2][0].getText().equals(jbt[2][2].getText()) && !jbt[2][0].getText().equals("")){
            JOptionPane.showMessageDialog(MainFrame.this,"~~win~~");
        }
        else if (jbt[0][0].getText().equals(jbt[1][0].getText()) && jbt[0][0].getText().equals(jbt[2][0].getText()) && !jbt[0][0].getText().equals("")){
            JOptionPane.showMessageDialog(MainFrame.this,"~~win~~");
        }
        else if (jbt[0][1].getText().equals(jbt[1][1].getText()) && jbt[0][1].getText().equals(jbt[2][1].getText()) && !jbt[0][1].getText().equals("")){
            JOptionPane.showMessageDialog(MainFrame.this,"~~win~~");
        }
        else if (jbt[0][2].getText().equals(jbt[1][2].getText()) && jbt[0][2].getText().equals(jbt[2][2].getText()) && !jbt[0][2].getText().equals("")){
            JOptionPane.showMessageDialog(MainFrame.this,"~~win~~");
        }
        else if (jbt[0][0].getText().equals(jbt[1][1].getText()) && jbt[0][0].getText().equals(jbt[2][2].getText()) && !jbt[0][0].getText().equals("")){
            JOptionPane.showMessageDialog(MainFrame.this,"~~win~~");
        }
        else if (jbt[0][2].getText().equals(jbt[1][1].getText()) && jbt[0][2].getText().equals(jbt[2][0].getText()) && !jbt[0][2].getText().equals("")){
            JOptionPane.showMessageDialog(MainFrame.this,"~~win~~");
        }

    }
}
