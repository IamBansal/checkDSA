package college_labs.java_lab_5th_sem.week10;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

//Scientific Calculator
class ScientificCalculator extends JFrame implements ActionListener {
    JTextField tField;
    double temp, temp1, result, a;
    static double m1;
    int k = 1, x = 0, y = 0, z = 0;
    char ch;
    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, zero, clr, pow2, pow3, exp,
            fac, plus, min, div, log, rec, mul, eq, addSub, dot, mr, mc, mp,
            mm, sqrt, sin, cos, tan;
    Container cont;
    JPanel buttonPanel;

    ScientificCalculator() {
        cont = getContentPane();
        cont.setLayout(new BorderLayout());
        JPanel textPanel = new JPanel();
        tField = new JTextField(25);
        tField.setHorizontalAlignment(SwingConstants.RIGHT);
        tField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent keyevent) {
                char c = keyevent.getKeyChar();
                if (c >= '0' && c <= '9') {
                } else {
                    keyevent.consume();
                }
            }
        });
        textPanel.add(tField);
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(8, 4, 2, 2));
        mr = new JButton("MR");
        buttonPanel.add(mr);
        mr.addActionListener(this);
        mc = new JButton("MC");
        buttonPanel.add(mc);
        mc.addActionListener(this);

        mp = new JButton("M+");
        buttonPanel.add(mp);
        mp.addActionListener(this);

        mm = new JButton("M-");
        buttonPanel.add(mm);
        mm.addActionListener(this);

        b1 = new JButton("1");
        buttonPanel.add(b1);
        b1.addActionListener(this);
        b2 = new JButton("2");
        buttonPanel.add(b2);
        b2.addActionListener(this);
        b3 = new JButton("3");
        buttonPanel.add(b3);
        b3.addActionListener(this);

        b4 = new JButton("4");
        buttonPanel.add(b4);
        b4.addActionListener(this);
        b5 = new JButton("5");
        buttonPanel.add(b5);
        b5.addActionListener(this);
        b6 = new JButton("6");
        buttonPanel.add(b6);
        b6.addActionListener(this);

        b7 = new JButton("7");
        buttonPanel.add(b7);
        b7.addActionListener(this);
        b8 = new JButton("8");
        buttonPanel.add(b8);
        b8.addActionListener(this);
        b9 = new JButton("9");
        buttonPanel.add(b9);
        b9.addActionListener(this);

        zero = new JButton("0");
        buttonPanel.add(zero);
        zero.addActionListener(this);

        plus = new JButton("+");
        buttonPanel.add(plus);
        plus.addActionListener(this);

        min = new JButton("-");
        buttonPanel.add(min);
        min.addActionListener(this);

        mul = new JButton("*");
        buttonPanel.add(mul);
        mul.addActionListener(this);

        div = new JButton("/");
        div.addActionListener(this);
        buttonPanel.add(div);

        addSub = new JButton("+/-");
        buttonPanel.add(addSub);
        addSub.addActionListener(this);

        dot = new JButton(".");
        buttonPanel.add(dot);
        dot.addActionListener(this);

        eq = new JButton("=");
        buttonPanel.add(eq);
        eq.addActionListener(this);

        rec = new JButton("1/x");
        buttonPanel.add(rec);
        rec.addActionListener(this);
        sqrt = new JButton("Sqrt");
        buttonPanel.add(sqrt);
        sqrt.addActionListener(this);
        log = new JButton("log");
        buttonPanel.add(log);
        log.addActionListener(this);

        sin = new JButton("SIN");
        buttonPanel.add(sin);
        sin.addActionListener(this);
        cos = new JButton("COS");
        buttonPanel.add(cos);
        cos.addActionListener(this);
        tan = new JButton("TAN");
        buttonPanel.add(tan);
        tan.addActionListener(this);
        pow2 = new JButton("x^2");
        buttonPanel.add(pow2);
        pow2.addActionListener(this);
        pow3 = new JButton("x^3");
        buttonPanel.add(pow3);
        pow3.addActionListener(this);
        exp = new JButton("Exp");
        exp.addActionListener(this);
        buttonPanel.add(exp);
        fac = new JButton("n!");
        fac.addActionListener(this);
        buttonPanel.add(fac);

        clr = new JButton("AC");
        buttonPanel.add(clr);
        clr.addActionListener(this);
        cont.add("Center", buttonPanel);
        cont.add("North", textPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("1")) {
            if (z == 0) {
                tField.setText(tField.getText() + "1");
            } else {
                tField.setText("");
                tField.setText(tField.getText() + "1");
                z = 0;
            }
        }
        if (s.equals("2")) {
            if (z == 0) {
                tField.setText(tField.getText() + "2");
            } else {
                tField.setText("");
                tField.setText(tField.getText() + "2");
                z = 0;
            }
        }
        if (s.equals("3")) {
            if (z == 0) {
                tField.setText(tField.getText() + "3");
            } else {
                tField.setText("");
                tField.setText(tField.getText() + "3");
                z = 0;
            }
        }
        if (s.equals("4")) {
            if (z == 0) {
                tField.setText(tField.getText() + "4");
            } else {
                tField.setText("");
                tField.setText(tField.getText() + "4");
                z = 0;
            }
        }
        if (s.equals("5")) {
            if (z == 0) {
                tField.setText(tField.getText() + "5");
            } else {
                tField.setText("");
                tField.setText(tField.getText() + "5");
                z = 0;
            }
        }
        if (s.equals("6")) {
            if (z == 0) {
                tField.setText(tField.getText() + "6");
            } else {
                tField.setText("");
                tField.setText(tField.getText() + "6");
                z = 0;
            }
        }
        if (s.equals("7")) {
            if (z == 0) {
                tField.setText(tField.getText() + "7");
            } else {
                tField.setText("");
                tField.setText(tField.getText() + "7");
                z = 0;
            }
        }
        if (s.equals("8")) {
            if (z == 0) {
                tField.setText(tField.getText() + "8");
            } else {
                tField.setText("");
                tField.setText(tField.getText() + "8");
                z = 0;
            }
        }
        if (s.equals("9")) {
            if (z == 0) {
                tField.setText(tField.getText() + "9");
            } else {
                tField.setText("");
                tField.setText(tField.getText() + "9");
                z = 0;
            }
        }
        if (s.equals("0")) {
            if (z == 0) {
                tField.setText(tField.getText() + "0");
            } else {
                tField.setText("");
                tField.setText(tField.getText() + "0");
                z = 0;
            }
        }
        if (s.equals("AC")) {
            tField.setText("");
            x = 0;
            y = 0;
            z = 0;
        }
        if (s.equals("log")) {
            if (tField.getText().equals("")) {
                tField.setText("");
            } else {
                a = Math.log(Double.parseDouble(tField.getText()));
                tField.setText("");
                tField.setText(tField.getText() + a);
            }
        }
        if (s.equals("1/x")) {
            if (tField.getText().equals("")) {
                tField.setText("");
            } else {
                a = 1 / Double.parseDouble(tField.getText());
                tField.setText("");
                tField.setText(tField.getText() + a);
            }
        }
        if (s.equals("Exp")) {
            if (tField.getText().equals("")) {
                tField.setText("");
            } else {
                a = Math.exp(Double.parseDouble(tField.getText()));
                tField.setText("");
                tField.setText(tField.getText() + a);
            }
        }
        if (s.equals("x^2")) {
            if (tField.getText().equals("")) {
                tField.setText("");
            } else {
                a = Math.pow(Double.parseDouble(tField.getText()), 2);
                tField.setText("");
                tField.setText(tField.getText() + a);
            }
        }
        if (s.equals("x^3")) {
            if (tField.getText().equals("")) {
                tField.setText("");
            } else {
                a = Math.pow(Double.parseDouble(tField.getText()), 3);
                tField.setText("");
                tField.setText(tField.getText() + a);
            }
        }
        if (s.equals("+/-")) {
            if (x == 0) {
                tField.setText("-" + tField.getText());
                x = 1;
            } else {
                tField.setText(tField.getText());
            }
        }
        if (s.equals(".")) {
            if (y == 0) {
                tField.setText(tField.getText() + ".");
                y = 1;
            } else {
                tField.setText(tField.getText());
            }
        }
        if (s.equals("+")) {
            if (tField.getText().equals("")) {
                tField.setText("");
                temp = 0;
                ch = '+';
            } else {
                temp = Double.parseDouble(tField.getText());
                tField.setText("");
                ch = '+';
                y = 0;
                x = 0;
            }
            tField.requestFocus();
        }
        if (s.equals("-")) {
            if (tField.getText().equals("")) {
                tField.setText("");
                temp = 0;
            } else {
                x = 0;
                y = 0;
                temp = Double.parseDouble(tField.getText());
                tField.setText("");
            }
            ch = '-';
            tField.requestFocus();
        }
        if (s.equals("/")) {
            if (tField.getText().equals("")) {
                tField.setText("");
                temp = 1;
                ch = '/';
            } else {
                x = 0;
                y = 0;
                temp = Double.parseDouble(tField.getText());
                ch = '/';
                tField.setText("");
            }
            tField.requestFocus();
        }
        if (s.equals("*")) {
            if (tField.getText().equals("")) {
                tField.setText("");
                temp = 1;
                ch = '*';
            } else {
                x = 0;
                y = 0;
                temp = Double.parseDouble(tField.getText());
                ch = '*';
                tField.setText("");
            }
            tField.requestFocus();
        }
        if (s.equals("MC")) {
            m1 = 0;
            tField.setText("");
        }
        if (s.equals("MR")) {
            tField.setText("");
            tField.setText(tField.getText() + m1);
        }
        if (s.equals("M+")) {
            if (k == 1) {
                m1 = Double.parseDouble(tField.getText());
                k++;
            } else {
                m1 += Double.parseDouble(tField.getText());
                tField.setText("" + m1);
            }
        }
        if (s.equals("M-")) {
            if (k == 1) {
                m1 = Double.parseDouble(tField.getText());
                k++;
            } else {
                m1 -= Double.parseDouble(tField.getText());
                tField.setText("" + m1);
            }
        }
        if (s.equals("Sqrt")) {
            if (tField.getText().equals("")) {
                tField.setText("");
            } else {
                a = Math.sqrt(Double.parseDouble(tField.getText()));
                tField.setText("");
                tField.setText(tField.getText() + a);
            }
        }
        if (s.equals("SIN")) {
            if (tField.getText().equals("")) {
                tField.setText("");
            } else {
                a = Math.sin(Double.parseDouble(tField.getText()));
                tField.setText("");
                tField.setText(tField.getText() + a);
            }
        }
        if (s.equals("COS")) {
            if (tField.getText().equals("")) {
                tField.setText("");
            } else {
                a = Math.cos(Double.parseDouble(tField.getText()));
                tField.setText("");
                tField.setText(tField.getText() + a);
            }
        }
        if (s.equals("TAN")) {
            if (tField.getText().equals("")) {
                tField.setText("");
            } else {
                a = Math.tan(Double.parseDouble(tField.getText()));
                tField.setText("");
                tField.setText(tField.getText() + a);
            }
        }
        if (s.equals("=")) {
            if (tField.getText().equals("")) {
                tField.setText("");
            } else {
                temp1 = Double.parseDouble(tField.getText());
                switch (ch) {
                    case '+' -> result = temp + temp1;
                    case '-' -> result = temp - temp1;
                    case '/' -> result = temp / temp1;
                    case '*' -> result = temp * temp1;
                }
                tField.setText("");
                tField.setText(tField.getText() + result);
                z = 1;
            }
        }
        if (s.equals("n!")) {
            if (tField.getText().equals("")) {
                tField.setText("");
            } else {
                a = fact(Double.parseDouble(tField.getText()));
                tField.setText("");
                tField.setText(tField.getText() + a);
            }
        }
        tField.requestFocus();
    }

    double fact(double x) {
        if (x < 0) {
            return 0;
        }
        double i, s = 1;
        for (i = 2; i <= x; i += 1.0)
            s *= i;
        return s;
    }

    
}

public class Program24 {
    public static void main(String[] args) {
        try {
            UIManager
                    .setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception ignored) {
        }
        ScientificCalculator f = new ScientificCalculator();
        f.setTitle("ScientificCalculator");
        f.pack();
        f.setVisible(true);
    }

}