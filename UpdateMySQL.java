import java.sql.*;
import java.util.Scanner;

public class UpdateMySQL {

    public static void main(String[] args) {
        String status = "Nada aconteceu ainda.";
        Connection conn = App.conectar();
        Scanner scnLogin = new Scanner(System.in);
        Scanner scnResp = new Scanner(System.in);

        try {
            System.out.println("Bem vindo ao Banco de Dados.");
            System.out.println("Digite seu login : ");
            String strLogin = scnLogin.nextLine();
            System.out.println("Deseja alterar sua senha? (N) para não, ou (S) para sim. ");
            String strResp = scnResp.nextLine();

            if (strResp.equalsIgnoreCase("N")) {
                status = "Login concluído. ";
                System.out.println(status);
            } else {
                Statement stmSql = conn.createStatement();
                System.out.println("Digite a nova senha: ");
                String strNSenha = scnLogin.nextLine();

                String strSqlUpdate = "UPDATE `mysql_connector`.`tbl_login` SET `senha` = '" + strNSenha + "' WHERE (`login` = '" + strLogin + "')";
                stmSql.executeUpdate(strSqlUpdate);

                status = "Sua senha foi alterada com sucesso!";
                System.out.println(status);
                stmSql.close();
            }
            
        } catch (Exception e) {
            System.err.println("Ops! Ocorreu um erro: " + e);
       
           
            scnLogin.close();
            scnResp.close();
        }
    }
}
