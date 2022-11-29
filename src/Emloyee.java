import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Emloyee {
    private JPanel Main;
    private JTextField txtName;
    private JTextField txtOccupation;
    private JTextField txtSalary;
    private JTextField txtEpf;
    private JTextField txtEtf;
    private JTextField txtTax;
    private JTextField txtGSalary;
    private JTextField txtNSalary;
    private JButton btnOK;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Emloyee");
        frame.setContentPane(new Emloyee().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public Emloyee() {
        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double salary = Double.parseDouble(txtSalary.getText());

                double epfEmployee;
                double epfEmployer;
                double epf;
                double etf;
                double grossSalary;
                double tax;
                double netSalary;

                //Calculating epf from Employee Salary
                epfEmployee = salary * 0.08;

                //Calculating epf from Employer
                epfEmployer = salary * 0.12;

                //Calculating total epf
                epf = epfEmployee + epfEmployer;

                //Calculating etf
                etf = salary * 0.03;

                //Calculating Gross Salary
                grossSalary = salary - (epfEmployee + etf);


                //Calculating Tax
                if(grossSalary > 2500000){
                    tax = grossSalary * 0.36;
                }
                else if (grossSalary >2000000) {
                    tax = grossSalary * 0.3;
                }
                else if (grossSalary >1500000) {
                    tax = grossSalary * 0.24;
                }
                else if (grossSalary >1000000) {
                    tax = grossSalary * 0.18;
                }
                else if (grossSalary >500000) {
                    tax = grossSalary * 0.12;
                }
                else if (grossSalary >100000) {
                    tax = grossSalary * 0.06;
                }
                else {
                    tax = 0;
                }

                //Calculating Net Salary
                netSalary = grossSalary - tax;


                //Setting values
                txtEpf.setText(String.valueOf(epf));
                txtEtf.setText(String.valueOf(etf));
                txtTax.setText(String.valueOf(tax));
                txtGSalary.setText(String.valueOf(grossSalary));
                txtNSalary.setText(String.valueOf(netSalary));



            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
